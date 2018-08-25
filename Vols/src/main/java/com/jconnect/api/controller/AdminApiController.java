package com.jconnect.api.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jconnect.dto.JetDto;
import com.jconnect.dto.VolDto;
import com.jconnect.entities.Jet;
import com.jconnect.entities.TypeJet;
import com.jconnect.entities.Vol;
import com.jconnect.service.CancelCauseService;
import com.jconnect.service.JetService;
import com.jconnect.service.PiloteService;
import com.jconnect.service.ReservationService;
import com.jconnect.service.TypeJetService;
import com.jconnect.service.UserService;
import com.jconnect.service.VolService;



@RestController
@RequestMapping("/api")
public class AdminApiController {

	Logger log = LoggerFactory.getLogger(AdminApiController.class);
	
	private SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
	

	@Resource(name = "jetService")
	protected JetService jetService;

	@Resource(name = "typejetservice")
	protected TypeJetService typejetService;

	@Resource(name = "volService")
	protected VolService volService;

	@Resource(name = "userService")
	protected UserService userService;
	
	@Resource(name="reservationService")
	protected ReservationService reservationService;
	
	@Resource(name="cancelCauseService")
	protected CancelCauseService cancelCauseService;
	
	@Resource(name="piloteService")
	protected PiloteService piloteService;
	
	
	@GetMapping("/test")
	public String test() {
		return "testOk";
	}



	@PostMapping("/jetType")
	public ResponseEntity<TypeJet> addTypeJet(@RequestBody TypeJet typejet) {

		return new ResponseEntity<TypeJet>(typejetService.save(typejet), HttpStatus.CREATED);

	}

	// @RequestBody pour récup body de la req http et si on était dans html
	// @ModelAttribute
	@PostMapping("/jet")
	public ResponseEntity<Jet> addJet(@RequestBody JetDto jetDto) {
		Jet jet = new Jet();
		try {
			TypeJet typeJet = typejetService.findById(jetDto.getIdTypeJet());
			jet.setDescription(jetDto.getDescription());
			jet.setDisponible(jetDto.isDisponible());
			jet.setImageUrl(jetDto.getImgUrl());
			jet.setName(jetDto.getName());
			jet.setNbPlace(jetDto.getNbPlace());
			jet.setType(typeJet);
			return new ResponseEntity<Jet>(jetService.save(jet), HttpStatus.CREATED);
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<Jet>(jet, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PutMapping("/jet")
	public ResponseEntity<Jet> updateJet(@RequestBody JetDto jetDto) {
		Jet jet = jetService.findById(jetDto.getId());
		try {

			TypeJet typeJet = typejetService.findById(jetDto.getIdTypeJet());
			jet.setDescription(jetDto.getDescription());
			jet.setDisponible(jetDto.isDisponible());
			jet.setImageUrl(jetDto.getImgUrl());
			jet.setName(jetDto.getName());
			jet.setNbPlace(jetDto.getNbPlace());
			jet.setType(typeJet);
			return new ResponseEntity<Jet>(jetService.save(jet), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Jet>(jet, HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	@DeleteMapping("/jet/{id}")
	public ResponseEntity<Jet> removeJet(@PathParam("id") Long id) {
		try {
			jetService.delete(id);
			return new ResponseEntity<Jet>(HttpStatus.OK);

		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<Jet>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@GetMapping("/jet/{id}")
	public ResponseEntity<Jet> findJetById(@PathVariable("id") Long id) {
		try {
	Jet jet = jetService.findById(id);
			return new ResponseEntity<Jet>(jet,HttpStatus.OK);
			} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<Jet>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/jets")
	public ResponseEntity<List<Jet>> findAll() {
		try {

			return new ResponseEntity<List<Jet>>(jetService.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<List<Jet>>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/vols")
	public ResponseEntity<List<Vol>> findAllVols() {
		List<Vol> vols = volService.findAll();
		return new ResponseEntity<List<Vol>>(vols, HttpStatus.OK);
	}

	// @RequestBody pour récup body de la req http et si on était dans html
	// @ModelAttribute
	@PostMapping("/vol")
	public ResponseEntity<Vol> addVol(@RequestBody VolDto volDto) {
		Vol vol = new Vol();
		try {
			String dtdepart=volDto.getDateDepart();
			String dtArrive=volDto.getDateRetour();
			
			vol.setNbPassager(volDto.getNbPassager());
			vol.setDateDepart(sdf.parse(dtdepart));
			vol.setDateRetour(sdf.parse(dtArrive));
			vol.setVilleArrivee(volDto.getVilleArrivee());
			vol.setVilleDepart(volDto.getVilleDepart());

			return new ResponseEntity<Vol>(volService.save(vol), HttpStatus.CREATED);
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<Vol>(vol, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PutMapping("/vol")
	public ResponseEntity<Vol> updateVol(@RequestBody VolDto volDto) {

		Optional<Vol> volOp = volService.findById(volDto.getId());
		if (!volOp.isPresent()) {
			return new ResponseEntity<Vol>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		Vol vol = new Vol();
		try {
			vol = volOp.get();
			String dtdepart=volDto.getDateDepart();
			String dtArrive=volDto.getDateRetour();
			
			vol.setNbPassager(volDto.getNbPassager());
			vol.setDateDepart(sdf.parse(dtdepart));
			vol.setDateRetour(sdf.parse(dtArrive));
			vol.setVilleArrivee(volDto.getVilleArrivee());
			vol.setVilleDepart(volDto.getVilleDepart());
			return new ResponseEntity<Vol>(volService.save(vol), HttpStatus.CREATED);
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<Vol>(vol, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/vol/{id}")
	public ResponseEntity<Vol> removeVol(@PathParam("id") Long id) {
		Vol vol = volService.findById(id).get();
		try {
			volService.remove(vol);
			return new ResponseEntity<Vol>(HttpStatus.OK);

		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<Vol>(HttpStatus.INTERNAL_SERVER_ERROR);
		}}
		
	
	//request param method 
	@RequestMapping("/search")
		public ResponseEntity<List<Vol>> searchVols(@RequestParam(value="villeDep") String villeDep, @RequestParam(value="dateDep") String dateDep){
	
				try {
					Date	dateDepart = sdf.parse(dateDep);
					return new ResponseEntity<List<Vol>>(volService.search(villeDep,dateDepart ),HttpStatus.OK);

				} catch (ParseException e) {
					return new ResponseEntity<List<Vol>>(HttpStatus.INTERNAL_SERVER_ERROR);

				}
			
		}
	
	/*@PostMapping("/reservation")
	public ResponseEntity<Reservation> addReservation(@RequestBody ReservationDto reservationDto) {
		Reservation reservation = new Reservation();
		
		try {
			CancelCause cancelCause =cancelCauseService.findById(reservationDto.getIdCancelCause()).get();
			Pilote pilote=piloteService.findById(reservationDto.getIdPilote()).get();
			Jet jet=jetService.findById(reservationDto.getIdJet()).get();
			User user=userService.findById(reservationDto.getIdUser()).get();
			Vol vol =volService.findById(reservationDto.getIdVol()).get();
			reservation.setCancelCause(cancelCause);
			reservation.setPilote(pilote);
			reservation.setTypeReservation(reservationDto.getTypeReservation());
			reservation.setJet(jet);
			reservation.setUser(user);
			reservation.setVol(vol);
			
			return new ResponseEntity<Reservation>(reservationService.save(reservation), HttpStatus.CREATED);
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<Reservation>(reservation, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@PutMapping("/reservation")
	public ResponseEntity<Reservation> updateReservation(@RequestBody ReservationDto reservationDto) {
		Reservation reservation = reservationService.findById(reservationDto.getIdJet()).get();
		try {

			CancelCause cancelCause =cancelCauseService.findById(reservationDto.getIdCancelCause()).get();
			Pilote pilote=piloteService.findById(reservationDto.getIdPilote()).get();
			Jet jet=jetService.findById(reservationDto.getIdJet()).get();
			User user=userService.findById(reservationDto.getIdUser()).get();
			Vol vol =volService.findById(reservationDto.getIdVol()).get();
			
			
			reservation.setCancelCause(cancelCause);
			reservation.setPilote(pilote);
			reservation.setTypeReservation(reservationDto.getTypeReservation());
			reservation.setJet(jet);
			reservation.setUser(user);
			reservation.setVol(vol);
			return new ResponseEntity<Reservation>(reservationService.update(reservation), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Reservation>(reservation, HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}*/
	
	/*@PostMapping( "/registration")
    public ResponseEntity<User> registration(@RequestBody  RegisterUserDto registerUserDto) {
		User user = new User();
        user.setEmail(registerUserDto.getEmail());
        user.setFirstName(registerUserDto.getFirstName());
        user.setLastName(registerUserDto.getLastName());
        user.setPassword(registerUserDto.getPassword());
        Authority authority = new Authority();
        authority.setName(Authorities.ROLE_USER.name());
        Set<Authority> authorities = new HashSet<Authority>();
        authorities.add(authority);
        user.setAuthorities(authorities);
        return new ResponseEntity<User>(userService.save(user), HttpStatus.CREATED);
    }
*/

}

