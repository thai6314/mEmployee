package com.vmo.qlfresher.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;

import com.vmo.qlfresher.exception.ResponseException;
import com.vmo.qlfresher.repositories.CompanyRepository;
import com.vmo.qlfresher.security.CompanyDetail;
import com.vmo.qlfresher.security.JwtAuthenticationEntryPoint;
import com.vmo.qlfresher.security.JwtRequestFilter;
import com.vmo.qlfresher.services.CompanyDetailService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private JwtRequestFilter jwtRequestFilter;

	private CompanyDetailService companyDetailService;

	public SecurityConfig(@Lazy CompanyDetailService companyDetailService) {
		this.companyDetailService = companyDetailService;
	}

	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

	@Bean(BeanIds.AUTHENTICATION_MANAGER)
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public ResponseException responseException() {
		return new ResponseException();
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable().authorizeRequests()
				.antMatchers(HttpMethod.GET, "/company/auth/login", "/company/create", "/*", "/v2/api-docs", // swagger
						"/webjars/**", // swagger-ui webjars
						"/swagger-resources/**", // swagger-ui resources
						"/swagger-ui/**")
				.permitAll().anyRequest().authenticated().and().exceptionHandling()
				.authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	}

	public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.userDetailsService(companyDetailService).passwordEncoder(encoder());
	}

	@Bean
	public InternalResourceViewResolver defaultViewResolver() {
		return new InternalResourceViewResolver();
	}
}
