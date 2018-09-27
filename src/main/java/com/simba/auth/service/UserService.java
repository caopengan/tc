package com.simba.auth.service;

import com.simba.auth.entity.User;
import com.simba.auth.repository.UserRepository;
import com.simba.common.util.UtilValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public int addUser(User user){
        User u = userRepository.save(user);
        if(UtilValidate.isNotEmpty(u)){
            return 1;
        }
        return 0;
    }
}
