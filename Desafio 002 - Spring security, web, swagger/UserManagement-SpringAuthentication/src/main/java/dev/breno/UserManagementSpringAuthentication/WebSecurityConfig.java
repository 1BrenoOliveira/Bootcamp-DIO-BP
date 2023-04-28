package dev.breno.UserManagementSpringAuthentication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class WebSecurityConfig {
	
	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user = 
				User.withDefaultPasswordEncoder()
					.username("Breno")
					.password("123456")
					.roles("USER")
					.build();
		UserDetails admin = 
				User.withDefaultPasswordEncoder()
					.username("Joao")
					.password("123456")
					.roles("ADMIN")
					.build();
		return new InMemoryUserDetailsManager(user,admin);
	}
	/* //implementação vista no curso DIO
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	    http.authorizeRequests()
	            .antMatchers("/").permitAll()
	            .antMatchers("/login").permitAll()
	            .antMatchers("/managers").hasAnyRole("MANAGERS")
	            .antMatchers("/users").hasAnyRole("USERS","MANAGERS")
	            .anyRequest().authenticated().and().formLogin();
	}
	*/
	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception  {
        http
            .authorizeHttpRequests((authz) -> authz
            	.requestMatchers("/").permitAll()
    	        .requestMatchers("/login").permitAll()
    	         .requestMatchers("/users").hasAnyRole("USERS") //o parametro do hasAnyRole é a permissão que vc deseja
                .anyRequest().authenticated()
            )
            .httpBasic();
        return http.build();
    }
}
	
	