package com.example.findyourlaw.configuration;

import com.example.findyourlaw.entity.Lawyer;
import com.example.findyourlaw.repositories.LawyerRepository;
import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .oauth2Login();
    }

    @Bean
    public PrincipalExtractor principalExtractor(LawyerRepository lawyerRepository){
        return map -> {
            Lawyer lawyer = lawyerRepository.findByEmail((String) map.get("email")).orElseGet(() -> {
                Lawyer newlawyer = new Lawyer();

                newlawyer.setEmail((String) map.get("email"));
                newlawyer.setName((String) map.get("name"));

                return newlawyer;
            });

            return lawyerRepository.saveAndFlush(lawyer);
        };
    }
}
