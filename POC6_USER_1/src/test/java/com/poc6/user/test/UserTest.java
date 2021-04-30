package com.poc6.user.test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.CoreMatchers.any;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.poc6.user.Response;
import com.poc6.user.User;
import com.poc6.user.UserController;
import com.poc6.user.UserService;
@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class UserTest {
private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext context;
	
	ObjectMapper objectMapper = new ObjectMapper();

	@BeforeAll
	public void setUp()
	{
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	  @Test public void creatUser() throws Exception { 
	  User user=new User();
	  user.setUserName("Amit"); 
	  user.setLname("Mishra"); 
	  user.setAge(23);
	  user.setUcontact("91234567098");
	  user.setUmail("amit2108@gmail.com");
	  user.setArea("Opp Main Road"); 
	  user.setCity("Bhayandar East");
	  user.setUserPinCode("400064");
	  user.setState("Maharashtra");
	  user.setCountry("India");
	  user.setEmployeeId("amit23097");
	  String JsonRequest= objectMapper.writeValueAsString(user);
	  MvcResult result=mockMvc.perform(post("/users1/createUser").content(JsonRequest).contentType(
	  MediaType.APPLICATION_JSON_VALUE)).andDo(print()).andExpect(status().isOk()).
	  andReturn();
	  String resultContext =result.getResponse().getContentAsString(); 
	  Response response=objectMapper.readValue(resultContext, Response.class);
	  Assertions.assertTrue(response.isStatus() == Boolean.TRUE);
	  Assertions.assertEquals("Success",response.getProgressMessage()); }
	 
	 
	@Test
	public void getAllUsers() throws Exception {
		
		MvcResult result = mockMvc.perform(get("/users1/getAllUser").contentType(MediaType.APPLICATION_JSON_VALUE)).andDo(print())
				.andExpect(status().isOk()).andReturn();
		
		String resultContext = result.getResponse().getContentAsString();
		
		Response response = objectMapper.readValue(resultContext, Response.class);
		
		Assertions.assertTrue(response.isStatus() == Boolean.TRUE);
		Assertions.assertEquals("Success",response.getProgressMessage());
			
		}	
	@Test
	public void getUserByName() throws Exception {	
		MvcResult result = mockMvc.perform(get("/users1/name/Sonal").contentType(MediaType.APPLICATION_JSON_VALUE)).andDo(print())
				.andExpect(status().isOk()).andReturn();
		
		String resultContext = result.getResponse().getContentAsString();
		
		Response response = objectMapper.readValue(resultContext, Response.class);
		
		Assertions.assertTrue(response.isStatus() == Boolean.TRUE);
		Assertions.assertEquals("Success",response.getProgressMessage());	
		}	
	@Test
	public void getUserById() throws Exception {	
		MvcResult result = mockMvc.perform(get("/users1/id/6").contentType(MediaType.APPLICATION_JSON_VALUE)).andDo(print())
				.andExpect(status().isOk()).andReturn();
		
		String resultContext = result.getResponse().getContentAsString();
		
		Response response = objectMapper.readValue(resultContext, Response.class);
		
		Assertions.assertTrue(response.isStatus() == Boolean.TRUE);
		Assertions.assertEquals("Success",response.getProgressMessage());	
		}	
	@Test
	public void getUserByPinCode() throws Exception {	
		MvcResult result = mockMvc.perform(get("/users1/pincode/400064").contentType(MediaType.APPLICATION_JSON_VALUE)).andDo(print())
				.andExpect(status().isOk()).andReturn();
		
		String resultContext = result.getResponse().getContentAsString();
		
		Response response = objectMapper.readValue(resultContext, Response.class);
		
		Assertions.assertTrue(response.isStatus() == Boolean.TRUE);
		Assertions.assertEquals("Success",response.getProgressMessage());	
		}	
	@Test
	public void getUserByEmployeeId() throws Exception {	
		MvcResult result = mockMvc.perform(get("/users1/empid/Akshata0221").contentType(MediaType.APPLICATION_JSON_VALUE)).andDo(print())
				.andExpect(status().isOk()).andReturn();
		
		String resultContext = result.getResponse().getContentAsString();
		
		Response response = objectMapper.readValue(resultContext, Response.class);
		
		Assertions.assertTrue(response.isStatus() == Boolean.TRUE);
		Assertions.assertEquals("Success",response.getProgressMessage());	
		}	
	@Test 
	public void getUserByCity() throws Exception{
		MvcResult result = mockMvc.perform(get("/users1/city/Thane").contentType(MediaType.APPLICATION_JSON_VALUE)).andDo(print())
				.andExpect(status().isOk()).andReturn();
		
		String resultContext = result.getResponse().getContentAsString();
		
		Response response = objectMapper.readValue(resultContext, Response.class);
		
		Assertions.assertTrue(response.isStatus() == Boolean.TRUE);
		Assertions.assertEquals("Success",response.getProgressMessage());
			
	}
	@Test
	public void updateUserByEmployeeId() throws Exception{
		User update=new User();
		update.setUserName("Yash");
		update.setLname("Chowdhary");
		update.setAge(23);
		update.setUmail("yash.neosoftmail.com");
		update.setUcontact("7977109376");
		update.setArea("Borivali East");
		update.setCity("Mumbai");
		update.setUserPinCode("400066");
		update.setState("Maharashtra");
		update.setCountry("India");
		update.setEmployeeId("Yash2410");
		String JsonRequest= objectMapper.writeValueAsString(update);
		MvcResult result = mockMvc.perform(put("/users1/updateUser/Yash2410").content(JsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE)).andDo(print())
				.andExpect(status().isOk()).andReturn();
		
		String resultContext = result.getResponse().getContentAsString();
		
		Response response = objectMapper.readValue(resultContext, Response.class);
		
		Assertions.assertTrue(response.isStatus() == Boolean.TRUE);
		Assertions.assertEquals("Success",response.getProgressMessage());	
	}
	
	
	  @Test 
	public void deleteUserById() throws Exception{ 
	  MvcResult result =  mockMvc.perform(delete("/users1/deleteUser/15").contentType(MediaType.APPLICATION_JSON_VALUE)).andDo(print()).
	  andExpect(status().isOk()).andReturn(); 
	  String resultContext=result.getResponse().getContentAsString(); 
	  Response response=objectMapper.readValue(resultContext, Response.class);
	  Assertions.assertTrue(response.isStatus() == Boolean.TRUE);
	  Assertions.assertEquals("Success",response.getProgressMessage()); 
	  }
	  
	  
	  }
	 