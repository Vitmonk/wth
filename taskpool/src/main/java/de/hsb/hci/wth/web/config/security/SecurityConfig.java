package de.hsb.hci.wth.web.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private String[] allowedResources = {
        "/javax.faces.resource/**", "/assets/**", "*resource*/**"
    };

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // .anyRequest().authenticated()
                .antMatchers("/pages/**").fullyAuthenticated()
                .antMatchers(allowedResources).permitAll()
                .and()
                .formLogin()
                .loginPage("/pages/login.xhtml")
                .defaultSuccessUrl("/pages/home.xhtml")
                .permitAll()
                .and().logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout")).permitAll()
                .logoutSuccessUrl("/pages/login.xhtml")
                .clearAuthentication(true)
                .invalidateHttpSession(true)
                .and().csrf();
        /*
         * // pages to secure
         * .antMatchers("/pages/**").hasRole("USER")
         * // login configuration
         * .and().formLogin()
         * .loginPage("/pages/login.xhtml").permitAll()
         * .loginProcessingUrl("/login").usernameParameter("username").passwordParameter("password")
         * .defaultSuccessUrl("/pages/home.xhtml").failureUrl("/pages/login.xhtml?error")
         * // logout configuration
         * .and().logout()
         * .logoutUrl("/logout").logoutSuccessUrl("/pages/login.xhtml")
         * .invalidateHttpSession(true)
         * .and().csrf();
         */
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("admin").password("admin").roles("USER");
    }
}
