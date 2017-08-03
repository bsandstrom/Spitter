package spitter.web;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spitter.repository.interfaces.SpittleRepository;

@Controller
@RequestMapping("/spittles")
public class SpittleController {
	
	private static final Logger logger = Logger.getLogger(SpittleController.class);
	
	private static final String MAX_LONG_AS_STRING = "" + Long.MAX_VALUE;

	private SpittleRepository spittleRepositoryEM;
	
	
	@Autowired
	public SpittleController(@Qualifier("spittleRepositoryEM")SpittleRepository spittleRepository){
		this.spittleRepositoryEM = spittleRepository;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String spittles(Model model,	@RequestParam(value="max", defaultValue=MAX_LONG_AS_STRING) long max,
			@RequestParam(value="count",defaultValue="20") int count){
		logger.debug("getting list of all spittles ");
		model.addAttribute("spittleList", spittleRepositoryEM.findSpittles(max, count));
		return "spittles";
	}
	
	@RequestMapping(value="/{spittleId}", method=RequestMethod.GET)
	public String spittle(@PathVariable("spittleId") int spittleId, Model model){
		model.addAttribute("spittle", spittleRepositoryEM.findOne(spittleId));
		return "spittle";
	}
}
