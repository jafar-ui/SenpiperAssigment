package com.example.liv2train.service;

import com.example.liv2train.entity.TrainingCenter;
import com.example.liv2train.exception.EmailException;
import com.example.liv2train.exception.PhoneNumberException;
import com.example.liv2train.repo.TrainingCenterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class CenterService {


    @Autowired
    private TrainingCenterRepo repo;

    @Transactional
    public TrainingCenter addCenter(TrainingCenter center) throws Exception {
        String s = String.valueOf(center.getContact());
        if (!valid(s)) {
            throw new PhoneNumberException("Phone number is not correct");
        }
        if (!isValidEmail(center.getMail())) {
            throw new EmailException("Email is not valid");

        }
        center.setCreated(new Date());
        return repo.save(center);
    }

    public List<TrainingCenter> getAll() {
        return repo.findAll();
    }

    public boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null) {
            return false;
        }
        return pat.matcher(email).matches();
    }

    public boolean valid(String s) {
        return (s.length() == 10 && s.matches("[0-9]+"));
    }

}
