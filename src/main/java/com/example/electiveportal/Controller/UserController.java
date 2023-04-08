package com.example.electiveportal.Controller;

import com.example.electiveportal.BusinessLayer.UserDetailsImpl;
import com.example.electiveportal.Entity.ChoiceDetails;
import com.example.electiveportal.Service.ChoiceDetailsService;
import com.example.electiveportal.Service.ElectiveDetailsService;
import com.example.electiveportal.Service.SubjectDetailsService;
import com.example.electiveportal.Service.UserService;
import org.hibernate.JDBCException;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashSet;
import java.util.Set;

@Controller
public class UserController {

    final
    UserService userService;
    final
    ElectiveDetailsService electiveDetailsService;
    final
    SubjectDetailsService subjectDetailsService;
    final
    ChoiceDetailsService choiceDetailsService;

    public UserController(UserService userService, ElectiveDetailsService electiveDetailsService, SubjectDetailsService subjectDetailsService, ChoiceDetailsService choiceDetailsService) {
        this.userService = userService;
        this.electiveDetailsService = electiveDetailsService;
        this.subjectDetailsService = subjectDetailsService;
        this.choiceDetailsService = choiceDetailsService;
    }

    @GetMapping("/")
    public String homePage() {
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String home(Model model) {
        if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof UserDetailsImpl ud) {
            model.addAttribute("user", userService.getUserByRollNumber(ud.getUsername()));
        }
        return "Home";
    }

    @GetMapping("/choice-filling")
    public String forms(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        model.addAttribute("user", userService.getUserByRollNumber(userDetails.getUsername()));
        model.addAttribute("subjectDetails", subjectDetailsService.findAllSubjects());
        model.addAttribute("choiceDetails", new ChoiceDetails());
        return "Form";
    }

    @PostMapping("/choice-filling")
    public String addChoices(RedirectAttributes redirectAttributes, @ModelAttribute("choiceDetails") ChoiceDetails choices, @AuthenticationPrincipal UserDetails userDetails) {
        choices.setUserid(userService.getUserByRollNumber(userDetails.getUsername()));

        Set<String> setChoices = new HashSet<>(choices.getAllChoices());

        if (setChoices.size() != 5) {
            redirectAttributes.addFlashAttribute("less_than_5_subjects", "Please select 5 different subjects");
            return "redirect:/choice-filling";
        }

        try {
            choiceDetailsService.saveChoices(choices);
        } catch (DataAccessException e) {
            if (e.getCause() instanceof JDBCException sqlEx) {
//                    SQLException sqlEx = (SQLException) e.getCause();
                int sqlErrorCode = sqlEx.getErrorCode();
                if (sqlErrorCode == 1062) {
                    redirectAttributes.addFlashAttribute("errorMessage", "You have already submitted your choices");
                    return "redirect:/error";
                }
                System.out.println(sqlEx.getMessage());
            }
            return "redirect:/error";
        }
        return "ChoicesFilledSuccessfully";
    }
}
