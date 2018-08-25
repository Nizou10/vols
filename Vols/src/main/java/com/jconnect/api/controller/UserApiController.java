package com.jconnect.api.controller;

import java.security.Principal;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jconnect.entities.User;
import com.jconnect.service.AeroportService;
import com.jconnect.service.JetService;
import com.jconnect.service.ReservationService;
import com.jconnect.service.UserService;
@RestController
@RequestMapping("/api")
public class UserApiController {

	@Resource(name = "jetService")
    protected JetService jetService;
	@Resource(name = "userService")
    protected UserService userService;
	@Resource(name= "reservationService")
	protected ReservationService reservationService;
	@Resource(name="aeroportService")
	protected AeroportService aeroportService;

    @GetMapping("user/test")
	public String test() {
		
		return "Test is OK";
	}
    
    @GetMapping("/admin/home")
    public String adminHome(OAuth2Authentication authentication) {
    	
    	return "admin ressources ok";
    }
    
    

	
//	 @RequestMapping(value = "/reservation", method = RequestMethod.POST)
//	 public ResponseEntity<ReservationForm> addReservation(@RequestBody ReservationForm reservationform) throws ParseException {
//		 final Reservation reservation = new Reservation();
//		User user = userService.findUserById(reservationform.getUser_id());
//		if(user == null){ 
//			return new ResponseEntity<ReservationForm>(reservationform,HttpStatus.FAILED_DEPENDENCY);
//		}
//	     
//	     Jet jet= jetService.findJetById(reservationform.getJet_id());
//	     reservation.setJet(jet);
//	    // reservation.setPilote(piloteService.findPiloteById(reservationform.getPilote_id()));
//	     reservation.setUser(user);
//	     reservation.setTypeReservation(reservationform.getTypeReservation());
//	     
//	     Vol vol =new Vol();
//	     DateFormat df = new SimpleDateFormat("yyyy/MM/dd hh:mm");
//	     vol.setDateDepart(df.parse(reservationform.getDateDepart()));
//	     vol.setDateRetour(df.parse(reservationform.getDateRetour()));
//	     vol.setNbPassager(reservationform.getNbPassager());
//	     vol.setVilleArrivee(reservationform.getVilleArrivee());
//	     vol.setVilleDepart(reservationform.getVilleDepart());
//	     
//	     reservation.setVol(vol);
//	     reservation.setState("pending");
//	     reservationService.save(reservation);
//
//	    // HttpHeaders headers=new HttpHeaders();
//
//
//	     return new ResponseEntity<ReservationForm>(reservationform,HttpStatus.OK);
//	 }
//	 
//	 @RequestMapping(value = "/jet", method = RequestMethod.GET)
//	 public ResponseEntity<List<Jet>> returnJet(HttpServletRequest request){
////		 Principal principal = request.getUserPrincipal();
////		 String name = principal.getName();
//
//		 List<Jet> jets = jetService.findAll();
//		 
//		 return new ResponseEntity<List<Jet>>(jets, HttpStatus.OK);
//	 }
//	 
	 @RequestMapping(value = "/me", method = RequestMethod.GET)
	 public User getCurrentCustomer(HttpServletRequest request){
		 Principal principal = request.getUserPrincipal();
		 String name = principal.getName();
		 return userService.findByEmail(name).get(0);
	 }
//	 
//	    @RequestMapping(value = "/registration", method = RequestMethod.POST)
//	    public ResponseEntity<List<FieldError>>  registration(@RequestBody RegisterUserForm userForm, final BindingResult bindingResult) {
//	    	List<FieldError> errors= null;
//	    	userValidator.validate(userForm, bindingResult);
//	        if (bindingResult.hasErrors()) {
//	        	errors = bindingResult.getFieldErrors();
//	        	return new ResponseEntity<List<FieldError>>(errors, HttpStatus.NOT_ACCEPTABLE);
//	        }
//
//	        final User user = new User();
//	        user.setEmail(userForm.getEmail());
//	        user.setFirstName(userForm.getFirstName());
//	        user.setLastName(userForm.getLastName());
//	        user.setPassword(bCryptPasswordEncoder.encode(userForm.getPassword()));
//	        Authority authority = new Authority();
//	        authority.setName(Authorities.ROLE_USER.name());
//	        HashSet<Authority> authorities = new HashSet<Authority>();
//	        authorities.add(authority);
//	        user.setAuthorities(authorities);
//	        userService.addUser(user);
//
//	        //securityService.autologin(userForm.getEmail(), userForm.getPassword());
//
//	        return new ResponseEntity<List<FieldError>>(errors, HttpStatus.OK);
//	    }
//	    
//	    @RequestMapping(value="/aeroport", method=RequestMethod.GET)
//	    public  ResponseEntity<List<Aeroport>> findAeroport(@RequestParam String name){
//	    	List<Aeroport> AeroportList = aeroportService.search(name);
//	    	return new ResponseEntity<List<Aeroport>>(AeroportList, HttpStatus.OK);
//	    	
//	    }
	 
}
