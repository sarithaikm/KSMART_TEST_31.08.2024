package com.hrms.hrmstest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.hrmstest.model.hrmsModel;
import com.hrms.hrmstest.repository.hrmsRepository;



@Service
public class hrmsService {
     @Autowired
    private  hrmsRepository hrmsRepository;


    public hrmsModel saveHRMS(hrmsModel hrms) {
        return hrmsRepository.save(hrms);
    }

    

}
