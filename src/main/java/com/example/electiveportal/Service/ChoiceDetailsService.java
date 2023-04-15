package com.example.electiveportal.Service;

import com.example.electiveportal.Entity.ChoiceDetails;
import com.example.electiveportal.Entity.User;

public interface ChoiceDetailsService {
    public void saveChoices(ChoiceDetails choices);

    public ChoiceDetails getChoicesOfStudent(User user);
}
