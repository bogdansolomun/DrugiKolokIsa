package drugikolok.app.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import drugikolok.app.security.JwtUtil;
import drugikolok.app.service.StudentService;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {
	
	@Autowired
	private StudentService service;

	@Autowired
	private JwtUtil util;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		final String authorizationHeader = request.getHeader("Authorization");
		
		String indeks = null;
		String jwt = null;
		
		if(authorizationHeader != null) {
			jwt = authorizationHeader;
			indeks = util.extractUsername(jwt);
		}
		
		if(indeks != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails ud = this.service.loadUserByUsername(indeks);
			
			if(util.validateToken(jwt, ud)) {
				UsernamePasswordAuthenticationToken uapToken = new UsernamePasswordAuthenticationToken(ud, null, ud.getAuthorities());
				uapToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(uapToken);
			}
		}
		filterChain.doFilter(request, response);
	}
	
	
	
	
	
	
}
