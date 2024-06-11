package com.humanresourcemanagementsystem.Config;

import com.humanresourcemanagementsystem.util.JwtRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                //For Login
                                "/api/login",
                                "/api/employee/addEmployee",

                                //Vacation
                                "/api/vacations",
                                "/api/vacations/{id}",
                                "/api/vacations/addVacation/{id}",
                                "/api/vacations/updateVacation/{id}",
                                "/api/vacations/deleteVacation/{id}",

                                //For Payroll
                                "/api/payrolls",
                                "/api/payrolls/{id}",
                                "/api/payrolls/addPayroll/{id}",
                                "/api/payrolls/updatePayroll/{id}",
                                "/api/payrolls/deletePayroll/{id}",

                                //For Department
                                "/api/departments",
                                "/api/departments/{id}",
                                "/api/departments/addDepartment",
                                "/api/departments/updateDepartment/{id}",
                                "/api/departments/deleteDepartment/{id}",

                                //For Asset
                                "/api/v1/assets/all",
                                "/api/v1/assets/save",
                                "/api/v1/assets/update/{id}",
                                "/api/v1/assets/{id}",
                                "/api/v1/assets/multi ",

                                //For Experience
                                "/api/v1/experience/save",
                                "/api/v1/experience/all",
                                "/api/v1/experience/{id}",
                                "/api/v1/experience/update/{id}",
                                "/api/v1/experience/multi",

                                //For Logout
                                "/api/logout",

                                //For Employee
                                "api/v1/employee/all",
                                "api/v1/employee/save",

                                //For Education
                                "api/v1/education/all",
                                "api/v1/education/save",
                                "/api/v1/education/update/{id}",
                                "/api/v1/education/{id}",
                                "/api/v1/education/multi",

                                //For Separation
                                "/api/v1/separation/save",
                                "/api/v1/separation/{id}",
                                "api/v1/separation/all",
                                "/api/v1/separation/update/{id}"

                                ).permitAll()
                        .anyRequest().authenticated()
                )
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                );
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
