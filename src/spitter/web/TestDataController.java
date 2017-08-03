package spitter.web;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import spitter.TestData;
import spitter.data.TestDataDAO;

@Controller
public class TestDataController {
	
	private static final Logger logger = Logger.getLogger(TestDataController.class);
	
	TestDataDAO testDataDAO;
	
	@Autowired
	public void setTestData(TestDataDAO testDataDAO){
		this.testDataDAO = testDataDAO;
	}

	@RequestMapping("TestData")
	public String test(){
		logger.debug(testDataDAO.getTestDataById(2L).toString());
		return "home";
	}
	
	@RequestMapping("addTestData")
	public String addTestData(){
		TestData test = new TestData("poop");
		testDataDAO.addTestData(test);
		return "home";
	}
}
