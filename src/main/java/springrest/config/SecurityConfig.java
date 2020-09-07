package springrest.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import springrest.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserService userService;

    @Autowired
    private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;
    
   @Override
    protected void configure(AuthenticationManagerBuilder auth) {
		try {
	        auth.authenticationProvider(this.authenticationProvider());
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	@Override
	protected void configure(HttpSecurity http) {
		
		try {
			http.cors().and().csrf().disable().authorizeRequests().antMatchers("/**").permitAll();
//	        	.antMatchers("/", "/login", "/logout", "/meeting/list", "/user/autoLogout", "/user/register")
//	        		.permitAll()
//				.antMatchers("/meetingUser/signUp", "/meetingUser/signOut").permitAll()
////					.hasRole("USER")
//				.antMatchers("/meetingUser/listParticipants", "/meeting/delete", "/meeting/showSavePage", "/meeting/save", "/meeting/changeDisplay").permitAll()
////					.hasRole("ADMIN")
//				.and()
//				.formLogin()
//					.loginPage("/user/showLoginPage")
//					.loginProcessingUrl("/user/login")
//					.successHandler(customAuthenticationSuccessHandler)
//					.permitAll()
//				.and()
//				.logout().permitAll()
//				.and()
//				.exceptionHandling().accessDeniedPage("/user/accessDenied");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(userService);
		auth.setPasswordEncoder(this.passwordEncoder());
		return auth;
	}
	
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
		configuration.setAllowedMethods(Arrays.asList("GET","POST", "DELETE"));
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}
	  
}