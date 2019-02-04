package com.cts.viewnews.mockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SignupControllerMockMVC {
	private static final Logger LOGGER = LoggerFactory.getLogger(SignupControllerMockMVC.class);

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testSuccessfullSignup() throws Exception {
		LOGGER.info("START");
		String USER_DATA = "{\"name\":\"Sankar Sardar\"," + "\"email\":\"sankar@gmail.com\","
				+ "\"password\":\"A123456\"," + "\"blocked\":\"no\"," + "\"language\":{\"id\":\"1\"},"
				+ "\"role\":{\"id\":1}}";

		LOGGER.debug("JSON Object created :  {}", USER_DATA);

		mockMvc.perform(post("/signup/add").content(USER_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().isOk()).andExpect(jsonPath("$.signupStatus").value("true"));

		LOGGER.info("END");
	}

	@Test
	public void testExistingEmail() throws Exception {
		LOGGER.info("START");
		String USER_DATA = "{\"name\":\"Sankar Sardar\"," + "\"email\":\"s@g.com\"," + "\"password\":\"A123456\","
				+ "\"blocked\":\"no\"," + "\"language\":{\"id\":\"1\"}}";

		LOGGER.debug("JSON Object created :  {}", USER_DATA);

		mockMvc.perform(post("/signup/add").content(USER_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().isOk()).andExpect(jsonPath("$.emailExist").value("true"));

		LOGGER.info("END");
	}

	
	@Test
	public void testNameisNull() throws Exception {
		LOGGER.info("START");

		String USER_DATA = "{\"email\":\"d@aagmail.com\"," + "\"password\":\"A123456\","
				+ "\"blocked\":\"no\"," + "\"language\":{\"id\":\"1\"}}";

		mockMvc.perform(post("/signup/add").content(USER_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().is4xxClientError())
				.andExpect(jsonPath("$.errorMessage").value("Input Validation Failed:Name cannot be empty"));

		LOGGER.info("END");
	}
	
	@Test
	public void testemailisNull() throws Exception {
		LOGGER.info("START");

		String USER_DATA = "{\"name\":\"mailk\"," + "\"password\":\"A123456\","
				+ "\"blocked\":\"no\"," + "\"language\":{\"id\":\"1\"}}";

		mockMvc.perform(post("/signup/add").content(USER_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().is4xxClientError())
				.andExpect(jsonPath("$.errorMessage").value("Input Validation Failed:Email cannot be empty"));

		LOGGER.info("END");
	}
	
	@Test
	public void testPasswordisNull() throws Exception {
		LOGGER.info("START");

		String USER_DATA = "{\"name\":\"mailk\"," + "\"email\":\"saas@gma.hom\","
				+ "\"blocked\":\"no\"," + "\"language\":{\"id\":\"1\"}}";

		mockMvc.perform(post("/signup/add").content(USER_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().is4xxClientError())
				.andExpect(jsonPath("$.errorMessage").value("Input Validation Failed:Password cannot be empty"));

		LOGGER.info("END");
	}
	
	@Test
	public void testStatusisNull() throws Exception {
		LOGGER.info("START");

		String USER_DATA = "{\"name\":\"mailk\"," + "\"email\":\"saas@gma.hom\","
				+ "\"password\":\"n154656o\"," + "\"language\":{\"id\":\"1\"}}";

		mockMvc.perform(post("/signup/add").content(USER_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().is4xxClientError())
				.andExpect(jsonPath("$.errorMessage").value("Input Validation Failed:Status cannot be empty"));

		LOGGER.info("END");
	}
	
	

	
	
	
	@Test
	public void testWrongEmailFormat() throws Exception {
		LOGGER.info("START");

		String USER_DATA = "{\"name\":\"Sankar Sardar\"," + "\"email\":\"gmail.com\"," + "\"password\":\"A123456\","
				+ "\"blocked\":\"no\"," + "\"language\":{\"id\":\"1\"}}";

		mockMvc.perform(post("/signup/add").content(USER_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().is4xxClientError())
				.andExpect(jsonPath("$.errorMessage").value("Input Validation Failed:Email address is invalid"));
		LOGGER.info("END");
	}

	
	
	@Test
	public void testwrongEmailSize() throws Exception {
		LOGGER.info("START");

		String USER_DATA = "{\"name\":\"Sankar Sardar\"," + "\"email\":\"Sasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss@gmail.com\"," + "\"password\":\"A123456\","
				+ "\"blocked\":\"no\"," + "\"language\":{\"id\":\"1\"}}";

		mockMvc.perform(post("/signup/add").content(USER_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().is4xxClientError())
				.andExpect(jsonPath("$.errorMessage").value("Input Validation Failed:Email must be of 3 to 250 characters"));
		LOGGER.info("END");
	}

	
	@Test
	public void testWrongpasswordSize() throws Exception {
		LOGGER.info("START");

		String USER_DATA = "{\"name\":\"Sankar Sardar\"," + "\"email\":\"sa@asgmail.com\"," + "\"password\":\"46\","
				+ "\"blocked\":\"no\"," + "\"language\":{\"id\":\"1\"}}";

		mockMvc.perform(post("/signup/add").content(USER_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().is4xxClientError())
				.andExpect(jsonPath("$.errorMessage").value("Input Validation Failed:Passsword must be of 3 to 25 characters"));
		LOGGER.info("END");
	}
	
	
	@Test
	public void testWrongNameSize() throws Exception {
		LOGGER.info("START");

		String USER_DATA = "{\"name\":\"Sankasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssr Sardssssssssssssaaaaaaaaaaaaaaaaaaaaaaaaaaaaaar\"," + "\"email\":\"sa@asgmail.com\"," + "\"password\":\"4ssssss6\","
				+ "\"blocked\":\"no\"," + "\"language\":{\"id\":\"1\"}}";

		mockMvc.perform(post("/signup/add").content(USER_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().is4xxClientError())
				.andExpect(jsonPath("$.errorMessage").value("Input Validation Failed:Name must be of 1 to 50 characters"));
		LOGGER.info("END");
	}


	
}
