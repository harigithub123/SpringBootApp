package com.billing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.AbstractRequestMatcherRegistry;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.header.HeaderWriterFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.billing.dao.UserRepository;
import com.billing.filter.CorsFilter;
import com.billing.filter.JWTAuthenticationFilter;
import com.billing.filter.JWTAuthorizationFilter;
import com.billing.service.UserService;

@Configuration
@EnableWebSecurity
@EnableWebMvc
public class WebSecurity extends WebSecurityConfigurerAdapter{

    @Autowired
    CorsFilter corsFilter;

//    @Autowired
//    private Environment environment;

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;
    
    private UserDetailsService userDetailsService;
    
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    public WebSecurity(UserDetailsService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDetailsService = userDetailsService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");

    }   

    private AbstractRequestMatcherRegistry<ExpressionUrlAuthorizationConfigurer<HttpSecurity>.AuthorizedUrl> ignoring() {
        return null;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
        .antMatchers("/webjars/**").permitAll()
        .antMatchers("/app/**").permitAll()
        .antMatchers("/destination/**").hasRole("ADMIN")
        .antMatchers(HttpMethod.POST, "login").permitAll().anyRequest().authenticated().and()
        .addFilterBefore(corsFilter, HeaderWriterFilter.class)
        .addFilterBefore(
                new JWTAuthenticationFilter("/login", authenticationManager(), userService, userRepository),
                UsernamePasswordAuthenticationFilter.class)
        .addFilterBefore(new JWTAuthorizationFilter(authenticationManager()),
                UsernamePasswordAuthenticationFilter.class);
        
    	/* http.authorizeRequests()
        .antMatchers("/webjars/**").permitAll()
        .antMatchers("/app/**").permitAll()
        .antMatchers("/destination/**").hasRole("ADMIN")
        .antMatchers(HttpMethod.POST, "login").permitAll()
        .anyRequest().authenticated().and()
        .addFilterBefore(corsFilter, HeaderWriterFilter.class)
        .addFilterBefore(
                new JWTAuthenticationFilter("/login", authenticationManager(), userService, userRepository),
                UsernamePasswordAuthenticationFilter.class)
        .addFilterBefore(new JWTAuthorizationFilter(authenticationManager()),
                UsernamePasswordAuthenticationFilter.class);*/
    }
    
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }
    
  
}
