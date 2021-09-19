package com.atypon.kdbms_spring.service;

import com.atypon.kdbms_spring.domain.Payload;
import com.atypon.kdbms_spring.domain.Record;
import com.atypon.kdbms_spring.domain.User;
import com.atypon.kdbms_spring.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;

public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    RecordService recordService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Payload payload =  recordService.getRecords("kdbms_web", "users", "username", username);
       ArrayList<Record> records = payload.getRecords();
       String password = "";
       String role = "";

       if(records.size()>0) {
           Record userRecord = records.get(0);
           password = userRecord.getField("password").trim();
           role = userRecord.getField("role").trim();
       }

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setRole(role);
        return new MyUserDetails(user);
    }
}
