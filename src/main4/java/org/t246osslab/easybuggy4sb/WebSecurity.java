package org.t246osslab.easybuggy4sb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import static org.t246osslab.easybuggy4sb.Config.AUTH_PASS;
import static org.t246osslab.easybuggy4sb.Config.AUTH_USER;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

    static final String AUTH_PATH = "/v2/authed/**";
    static final String AUTH_PATH_SWAGGER_REGEX = "\\/v2\\/authed\\/.*";

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(AUTH_PATH).authenticated()
                .anyRequest().permitAll()
                .and()
                .httpBasic();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser(AUTH_USER).password(AUTH_PASS)
                .authorities("ROLE_USER")
                .and()
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
    }
}