package com.shah.springsecurity.jwt.repo;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class MyUserDetailRepository {

    Map<String, MyUser> userMap = new HashMap<>();

    @PostConstruct
    void method() {
        userMap.put("user", new MyUser("user", "user", "ROLE_USER", true));
        userMap.put("user1", new MyUser("user1", "user1", "ROLE_USER", false));
        userMap.put("admin", new MyUser("admin", "admin", "ROLE_ADMIN", true));
        userMap.put("admin1", new MyUser("admin1", "admin", "ROLE_ADMIN", true));
    }

    public MyUser getUserByName(String name) {
        return userMap.get(name);
    }

}
