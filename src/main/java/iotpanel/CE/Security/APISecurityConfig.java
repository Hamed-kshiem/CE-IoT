/*
 * Copyright (c) 2020. Hamed  CE
 *
 */

package iotpanel.CE.Security;

import net.minidev.json.JSONUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.w3c.dom.ls.LSOutput;
@Configuration
@EnableWebSecurity
public class APISecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${principalRequestValue}")
    private String principalRequestValue;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        String principalRequestHeader = "API_KEY";
        APIKeyAuthFilter filter = new APIKeyAuthFilter(principalRequestHeader);
        filter.setAuthenticationManager(new AuthenticationManager() {

            @Override
            public Authentication authenticate(Authentication authentication) throws AuthenticationException {
                String principal = (String) authentication.getPrincipal();
                if (!principalRequestValue.equals(principal))
                {
                    System.out.println("failed");
                    throw new BadCredentialsException("The API key was not found or not the expected value.");
                }
                authentication.setAuthenticated(true);
                return authentication;
            }
        });
        System.out.println(principalRequestHeader);
        System.out.println(principalRequestValue);

       /* httpSecurity.
                antMatcher("/auth/**").
                csrf().disable().
                sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).
                and().addFilter(filter).authorizeRequests().anyRequest().authenticated();*/
    }

}