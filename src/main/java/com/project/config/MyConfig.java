package com.project.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.Type;

@Configuration
@EnableWebMvc
public class MyConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }


//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

//
//    @Bean
//    public RepositoryRestConfigurer repositoryRestConfigurer(EntityManager entityManager) {
//        return RepositoryRestConfigurer.withConfig(config -> {
//            config.exposeIdsFor(entityManager.getMetamodel().getEntities()
//                    .stream().map(Type::getJavaType).toArray(Class[]::new));
//        });
//    }

}
