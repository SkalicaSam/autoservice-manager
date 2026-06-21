package com.sam.autoservice_manager.config;


import com.sam.autoservice_manager.entity.Role;
import com.sam.autoservice_manager.entity.User;
import com.sam.autoservice_manager.repository.RoleRepository;
import com.sam.autoservice_manager.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Set;

//@Configuration
public class DataInitializer {

//    @Bean
//    CommandLineRunner init(RoleRepository roleRepo, UserRepository userRepo) {
//        return args -> {
//
//            Role adminRole = roleRepo.findByName("ROLE_ADMIN")
//                    .orElseGet(() -> roleRepo.save(new Role(null, "ROLE_ADMIN")));
//
//            if (userRepo.findByUsername("admin").isEmpty()) {
//
//                User admin = new User();
//                admin.setUsername("admin");
//                admin.setPassword("{noop}admin123"); // zatiaľ bez hashovania
//                admin.setRoles(Set.of(adminRole));
//
//                userRepo.save(admin);
//            }
//        };
//    }
}