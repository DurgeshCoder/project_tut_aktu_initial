package com.project;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectTut implements CommandLineRunner {


    public static void main(String[] args) {
        SpringApplication.run(ProjectTut.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

        try {



        } catch (Exception e) {
            e.printStackTrace();
        }

//
//        Role role1 = new Role();
//        role1.setName("ROLE_ADMIN");
//
//        Role role2 = new Role();
//        role2.setName("ROLE_NORMAL");
//
//        Set<Role> roles = new HashSet<>();
//
//        roles.add(role1);
//        roles.add(role2);
//
//        User user = new User();
//        user.setName("Sharma Ji");
//        user.setEmail("sharma@gmail.com");
//        user.setPassword(this.passwordEncoder.encode("abc"));
//        user.setAddress("Lucknow");
//        user.setImageName("default.png");
//        user.setAbout("I am very good programmer.");
//        User save = this.userRepository.save(user);
//        System.out.println(save);
    }
}
