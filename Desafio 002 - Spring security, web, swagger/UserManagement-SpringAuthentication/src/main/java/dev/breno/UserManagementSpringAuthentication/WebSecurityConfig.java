package dev.breno.UserManagementSpringAuthentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import dev.breno.UserManagementSpringAuthentication.service.SecurityDatabaseService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class WebSecurityConfig {
	
	@Autowired
    private SecurityDatabaseService securityService;
    @Autowired
    public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(securityService).passwordEncoder(NoOpPasswordEncoder.getInstance());
    }
    
    
	
	/*     //Como vamos começar a armazenar os usuarios no banco de dados, nao precisamos mais dos usuarios em memoria interna
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
	}*/
	
	
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
    	         .requestMatchers("/users").hasAnyRole("USERS")   //o parametro do hasAnyRole é a permissão que vc deseja
    	         .requestMatchers("/manager").hasAnyRole("MANAGERS")
                .anyRequest().authenticated()
            )
            .httpBasic();
        return http.build();
    }
}
	
	