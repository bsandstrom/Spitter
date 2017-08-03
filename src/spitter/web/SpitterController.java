package spitter.web;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.Date;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import spitter.Spitter;
import spitter.Spittle;
import spitter.repository.interfaces.SpitterRepository;
import spitter.repository.interfaces.SpittleRepository;

@Controller
@RequestMapping("/spitter")
public class SpitterController {
	
	private SpitterRepository spitterDAO;
	
	private SpittleRepository spittleDAO;
	
	@Autowired
	public void setSpitterDAO(SpitterRepository spitterDAO){
		this.spitterDAO = spitterDAO;
	}
	
	@Autowired
	public void setSpittleDAO(@Qualifier("spittleRepositoryEM")SpittleRepository spittleDAO){
		this.spittleDAO = spittleDAO;
	}
	
	private static final Logger logger = Logger.getLogger(SpitterController.class);
		
	@RequestMapping(value="/registerForm", method=GET)
	public String showRegistrationForm(Model model){
		return "registerForm";
	}
	
	@RequestMapping(value="/registerForm", method=POST)
	public String processRegistration(@Valid Spitter spitter, Errors result){
		if(result.hasErrors()){
			logger.debug("errors exist" + result.getAllErrors());
			return "registerForm";
		}
		
		spitterDAO.save(spitter);
		return "redirect:/spitter/" + spitter.getUsername();
	}
	
	@RequestMapping(value="/{username}", method=GET)
	public String showSpitterProfile(@PathVariable String username, Model model){
		Spitter spitter = spitterDAO.findByUsername(username);
		model.addAttribute(spitter);
		return "profile";
	}
	
	@RequestMapping(value="/{username}/spit", method=POST)
	public String postSpittle(@PathVariable String username,
			@RequestParam("message")String message, Model model){
		logger.debug("************************ Called post ****************");
		
		Spitter spitter = spitterDAO.findByUsername(username);
		model.addAttribute(spitter);
		
		Spittle spittle = new Spittle(spitter, message, new Date());
		spittleDAO.save(spittle);
		return "profile";
	}
}
