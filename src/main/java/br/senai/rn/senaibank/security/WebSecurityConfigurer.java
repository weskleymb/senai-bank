package br.senai.rn.senaibank.security;

import br.senai.rn.senaibank.service.UsuarioService;
import br.senai.rn.senaibank.service.implementation.UsuarioServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Autowired
    private UsuarioServiceImplementation usuarioService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .anyRequest().authenticated()
            .and().formLogin().loginPage("/entrar").permitAll()
//                .defaultSuccessUrl("/clientes")
                .successHandler(loginSuccessHandler())
            .and().logout().logoutUrl("/sair").logoutSuccessUrl("/entrar");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(usuarioService);
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring()
            .antMatchers("/bootstrap/**")
            .antMatchers("/fontawesome/**")
            .antMatchers("/jquery/**")
            .antMatchers("/popper/**")
            .antMatchers("/js/**");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public AuthenticationSuccessHandler loginSuccessHandler() {
        return (request, response, authentication)-> {
            response.sendRedirect("/clientes");
            request.getSession().setAttribute("success", "Bem vindo!!!");
        };
    }

    public AuthenticationFailureHandler loginFailureHandler() {
        return (request, response, exception) -> {
//            request.getSession().setAttribute();
            //request.removeAttribute("username");
            response.sendRedirect("/login");
        };
    }

}
