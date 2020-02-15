package com.springboot.backend.apirest.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SpringSecurityConfig  extends WebSecurityConfigurerAdapter{
	
	@Autowired 
	private UserDetailsService usuarioService; //Al buscar la interfaz inyecta la unica implementacion que tenemos

	
	@Bean //registrar objetos en el contenedor de spring que retorna un metodo y así utilizar en el resto del proyecto
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(this.usuarioService).passwordEncoder(passwordEncoder());
	}


	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}

	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests() //cualqueir peticion requiere autenticacion
		.anyRequest().authenticated()
		.and()
		.csrf().disable() //deshabilitamos la configuracion csrf
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		//Manejo de sesion deshabilitado por el lado spring
	}
}
