package com.aerotravel.flightticketbooking.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(securedEnabled = true, proxyTargetClass = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private DataSource dataSource;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .dataSource(dataSource)
                .usersByUsernameQuery("select username, password, enabled from users where username=?")
                .authoritiesByUsernameQuery("select username, role from users where username=?");
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .cors().disable()
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
//                .httpBasic(); // - pentru requesturi Postman fara pagina de Login
                .formLogin()
                .loginPage("/login").permitAll();




        // - pentru pagini web cu LOGIN

    }


}


//    @Override
//   protected void configure(HttpSecurity http) throws Exception {
//       http
//               .headers()
//              .frameOptions().sameOrigin()
//               .and()
//               .authorizeRequests()     .antMatchers("/", "/flight/search", "/flight/book/verify", "/flight/book/cancel", "/img/**").permitAll()
//               .antMatchers("/flight/book**", "/flight/book/new").hasRole("AGENT")
//               .antMatchers("/**").hasRole("ADMIN")
//
//               .anyRequest().authenticated()
//              .and()
//                .formLogin()
//              .loginPage("/login")
//           .defaultSuccessUrl("/")
//                .failureUrl("/login?error")
//               .permitAll()
//              .and()
//               .logout()
//               .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//              .logoutSuccessUrl("/login?logout")
//              .permitAll()
//              .and()
//                .csrf().disable()
//                .exceptionHandling();
//    }
//}