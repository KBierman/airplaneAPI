package fish.burger.airplaneapi;

import fish.burger.airplaneapi.model.UserModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig{

    UserBLL ub = new UserBLL();

    private final InMemoryUserDetailsManager memAuth = new InMemoryUserDetailsManager();
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

                UserModel user = ub.findUser(userName);

                Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
                grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
                if (user.getAdmin()){
                    grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
                }

                UserAuthority ua = new UserAuthority(user.getUsername(), passwordEncoder().encode(user.getUserPassword()), grantedAuthorities);
                System.out.println(ua.getAuthorities());
                return ua;
            }
        };
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http, UserDetailsService userDetailsService) throws Exception{
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder())
                .and().build();
    }

    public static class NoPopupBasicAuthenticationEntryPoint implements AuthenticationEntryPoint {
        @Override
        public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage());
        }
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        return http.csrf().disable()
                .httpBasic(Customizer.withDefaults())
                .authorizeRequests()
                .antMatchers("index.html").permitAll()
                .antMatchers("/api/login").hasAnyRole("USER")
                .antMatchers("/api/adminLogin").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST,"/api/user").permitAll()
                .antMatchers( "/api/user/{username}").hasRole("USER")
                .antMatchers("/api/user/{id}").hasRole("ADMIN")
                .antMatchers("/api/user/{id}/{pass}").hasRole("ADMIN")
                .antMatchers("/api/user/delete/{id}").hasRole("ADMIN")
                .antMatchers("/api/flight/{fltno}").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/api/flight").permitAll()
                .antMatchers("/api/flight/{fltno}").hasRole("ADMIN")
                .antMatchers("/api/reports/flights").hasRole("ADMIN")
                .antMatchers("/api/reports/users").hasRole("ADMIN")
                .antMatchers("/api/reports/reservations").hasRole("ADMIN")
                .antMatchers("/api/reports/{user}/{id}").hasRole("ADMIN")
                .antMatchers("api/ticket").hasRole("USER")
                .antMatchers("api/ticket/{userID}").hasRole("USER")
                .and().csrf().disable()
                .sessionManagement().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().httpBasic()
                .authenticationEntryPoint(new NoPopupBasicAuthenticationEntryPoint())
                .and().cors()
                .and()
                .build();
    }
}

