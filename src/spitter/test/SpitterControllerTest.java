package spitter.test;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import spitter.Spitter;
import spitter.repository.interfaces.SpitterRepository;
import spitter.web.SpitterController;

public class SpitterControllerTest {
	
	@Test
	public void shouldShowRegistration() throws Exception {
		SpitterRepository mockRepository = Mockito.mock(SpitterRepository.class);
		//SpittleRepository mockSpittleRepository = Mockito.mock(SpittleRepository.class);
		SpitterController controller = new SpitterController();
		controller.setSpitterDAO(mockRepository);
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
		
		mockMvc.perform(MockMvcRequestBuilders.get("/spitter/register"))
			.andExpect(MockMvcResultMatchers.view().name("registerForm"));
	}
	
	@Test
	public void shouldProcessRegistration() throws Exception {
		SpitterRepository mockRepository = Mockito.mock(SpitterRepository.class);
		//SpittleRepository mockSpittleRepository = Mockito.mock(SpittleRepository.class);
		Spitter unsaved = new Spitter("jbauer", "24hours", "Jack", "Bauer");
		Spitter saved = new Spitter(24, "jbauer", "24hours", "Jack", "Bauer");
		Mockito.when(mockRepository.save(unsaved)).thenReturn(saved);
		
		SpitterController controller = new SpitterController();
		controller.setSpitterDAO(mockRepository);
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
		
		mockMvc.perform(MockMvcRequestBuilders.post("/spitter/register")
				.param("firstName", "Jack")
				.param("lastName", "Bauer")
				.param("username", "jbauer")
				.param("password", "24hours"))
				.andExpect(MockMvcResultMatchers.redirectedUrl("/spitter/jbauer"));
	}
}
