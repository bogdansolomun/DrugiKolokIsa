package drugikolok.app.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import drugikolok.app.security.JwtUtil;
import drugikolok.app.service.StudentService;
import drugikolok.app.model.AuthRequest;
import drugikolok.app.model.AuthResponse;

@Controller
@CrossOrigin
public class ProveraCtrl {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	JwtUtil util;
	
	@Autowired
	StudentService serviceAuth;
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthToken(@RequestBody AuthRequest authRequest) throws Exception{
		
		try {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getIndeks(), authRequest.getLozinka()));
		}
		catch(BadCredentialsException e) {
			throw new Exception("Pogresni podaci", e);
		}
		
		final UserDetails userDetails = serviceAuth.loadUserByUsername(authRequest.getIndeks());
		final String jwt = util.generateToken(userDetails);
	
		return ResponseEntity.ok(new AuthResponse(jwt));
	}

}
