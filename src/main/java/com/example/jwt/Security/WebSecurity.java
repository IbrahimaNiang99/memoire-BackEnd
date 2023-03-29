package com.example.jwt.Security;
import com.example.jwt.Filter.AuthenticationFilter;
import com.example.jwt.Filter.AuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.web.bind.annotation.RequestBody;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
    @Value("${jwtSecret}")
    private String jwtSecret;
    private UserDetailsService userDetailsService;
    @Autowired
    public WebSecurity(@Lazy UserDetailsService userDetailsService){
        this.userDetailsService = userDetailsService;
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.cors().and().csrf().disable()
                .addFilterBefore(new AuthorizationFilter(jwtSecret), LogoutFilter.class).authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS,"/*").permitAll();

        http.cors().and().csrf().disable().authorizeRequests().antMatchers("/login").permitAll();

        AuthenticationFilter authenticationFilter = new AuthenticationFilter(authenticationManager(), jwtSecret);
        authenticationFilter.setFilterProcessesUrl("/login");

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        /*
         * Route concernant les utilisateurs
         */
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/users/**").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.POST, "/users/**").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/getUser/**").permitAll();

        /*
         * Route concernant les Régistres
         */
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/registre/liste/**").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.POST, "/registre/ajout/**").permitAll();

        /*
         * Route concernant les Naissances 
         */
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/naissance/liste/**").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.POST, "/naissance/ajout/**").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/naissance/getById/{id}/**").permitAll();











        http.authorizeRequests().anyRequest().authenticated();
        http.addFilter(authenticationFilter);
        http.addFilterBefore(new AuthorizationFilter(jwtSecret), UsernamePasswordAuthenticationFilter.class);

    }

    @Bean
    @Override
    public AuthenticationManager authenticationManager() throws Exception{
        return super.authenticationManager();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        return super.userDetailsService();
    }
}

