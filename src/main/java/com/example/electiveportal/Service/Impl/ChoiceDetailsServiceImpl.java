package com.example.electiveportal.Service.Impl;

import com.example.electiveportal.Entity.ChoiceDetails;
import com.example.electiveportal.Entity.User;
import com.example.electiveportal.Repository.ChoiceDetailsRepository;
import com.example.electiveportal.Service.ChoiceDetailsService;
import org.springframework.stereotype.Service;

@Service
public class ChoiceDetailsServiceImpl implements ChoiceDetailsService {

    private ChoiceDetailsRepository choiceDetailsRepo;

    public ChoiceDetailsServiceImpl(ChoiceDetailsRepository choiceDetailsRepo) {
        super();
        this.choiceDetailsRepo = choiceDetailsRepo;
    }

    @Override
    public void saveChoices(ChoiceDetails choices) {
        choiceDetailsRepo.save(choices);
    }

    @Override
    public ChoiceDetails getChoicesOfStudent(User user) {
        return choiceDetailsRepo.findChoiceDetailsByUserid(user);
    }
}
