package com.example.electiveportal.Controller;

import com.example.electiveportal.Entity.MarkSheetDetails;
import com.example.electiveportal.Entity.User;
import com.example.electiveportal.Service.Impl.MarkSheetDetailsServiceImpl;
import com.example.electiveportal.Service.Impl.UserServiceImpl;
import org.hibernate.JDBCException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

@Controller
public class UploadController {

    @Autowired
    UserServiceImpl userServ;
    @Autowired
    MarkSheetDetailsServiceImpl marksheetServ;

    private final String UPLOAD_DIR = "./Uploads/";

    @GetMapping("/upload")
    public String upload(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        model.addAttribute("user", userServ.getUserByRollNumber(userDetails.getUsername()));
        return "Upload";
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("semester") int sem,
            @AuthenticationPrincipal UserDetails userDetails, RedirectAttributes attributes) {

        // check if file is empty
        if (file.isEmpty()) {
            attributes.addFlashAttribute("message", "Please select a file to upload.");
            return "redirect:/upload";
        }

        if (StringUtils.endsWithIgnoreCase(file.getOriginalFilename(), "pdf")
                || StringUtils.endsWithIgnoreCase(file.getOriginalFilename(), "docx")) {
            // normalize the file path
            String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
            // save the file on the local file system
            try {
                Path path = Paths.get(UPLOAD_DIR + userDetails.getUsername() + "_Semester_" + sem
                        + (fileName.matches(".*[.]pdf") ? ".pdf" : ".docx"));
                System.out.println(path.toString());
                if (new File(path.toString()).exists()) {
                    System.out.println(path);
                    attributes.addFlashAttribute("message", "File Already Exists");
                    return "redirect:/upload";
                } else {
                    // File file1 = new File(path.toString());
                    System.out.println(path);
                    Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
                    User user = userServ.getUserByRollNumber(userDetails.getUsername());
                    marksheetServ
                            .saveMarkSheet(new MarkSheetDetails(user, user.getCurrentSemester() - 1, path.toString()));
                }
            } catch (IOException | DataAccessException e) {
                if (e.getCause() instanceof JDBCException sqlEx) {
                    // SQLException sqlEx = (SQLException) e.getCause();
                    int sqlErrorCode = sqlEx.getErrorCode();
                    if (sqlErrorCode == 1062) {
                        attributes.addFlashAttribute("errorMessage",
                                "You have already submitted the File for your Previous Semester");
                        return "redirect:/upload";
                    }
                }
            }

            // return success response
            attributes.addFlashAttribute("message", "You successfully uploaded " + fileName + '!');
        }
        return "redirect:/upload";
    }

}
