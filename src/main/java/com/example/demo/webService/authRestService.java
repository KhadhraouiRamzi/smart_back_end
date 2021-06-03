package com.example.demo.webService;

import com.example.demo.entite.ERole;
import com.example.demo.entite.role;
import com.example.demo.entite.user;
import com.example.demo.payload.request.LoginRequest;
import com.example.demo.payload.request.SignupRequest;
import com.example.demo.payload.response.JwtResponse;
import com.example.demo.payload.response.MessageResponse;
import com.example.demo.security.jwt.JwtUtils;
import com.example.demo.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@CrossOrigin
@RestController
@RequestMapping("/api/auth")
public class authRestService {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
    com.example.demo.dao.userRepository userRepository;

	@Autowired
    com.example.demo.dao.roleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
    JwtUtils jwtUtils;

	@RequestMapping(value = "signin", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(new JwtResponse(jwt,
												 userDetails.getId(),
												 userDetails.getEmail(), 
												 roles));
	}

	@RequestMapping(value = "signup", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}

		// Create new user's account
		user user = new user(signUpRequest.getNom(),
				signUpRequest.getPrenom(),
				signUpRequest.getPhone(),
				signUpRequest.getEmail(),
				encoder.encode(signUpRequest.getPassword()));

		Set<String> strRoles = signUpRequest.getRole();
		Set<role> roles = new HashSet<>();

		if (strRoles == null) {
			role userRole = roleRepository.findByName(ERole.ROLE_ADMIN)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "ROLE_ADMIN":
					com.example.demo.entite.role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);

					break;
				case "ROLE_GESTIONNAIRE":
					com.example.demo.entite.role gestRole = roleRepository.findByName(ERole.ROLE_GESTIONNAIRE)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(gestRole);

					break;
				case "ROLE_CONSULTANT":
						com.example.demo.entite.role consultRole = roleRepository.findByName(ERole.ROLE_CONSULTANT)
								.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
						roles.add(consultRole);

						break;
				case "ROLE_ARTISTE":
						com.example.demo.entite.role artRole = roleRepository.findByName(ERole.ROLE_ARTISTE)
								.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
						roles.add(artRole);

						break;
				case "ROLE_FOURNISSEUR":
						com.example.demo.entite.role fournRole = roleRepository.findByName(ERole.ROLE_FOURNISSEUR)
								.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
						roles.add(fournRole);

						break;
					default:
					com.example.demo.entite.role roleAd = roleRepository.findByName(ERole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(roleAd);
				}
			});
		}

		user.setRoles(roles);
		userRepository.save(user);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
	
}
