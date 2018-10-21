package com.cc.springbootstudy.user;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import com.cc.springbootstudy.App;
import com.cc.springbootstudy.user.service.UserService;
import com.cc.springbootstudy.user.vo.UserModel;


@RunWith(SpringRunner.class)
@SpringBootTest(classes=App.class,webEnvironment=WebEnvironment.RANDOM_PORT)
//@AutoConfigureMockMvc
public class UserControllerTest {
	@Autowired
	private WebApplicationContext wac;
	
//	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private UserService us;
	
	@Autowired
	private TestRestTemplate rest;
	
	
	@Before
	public void setup() {
		this.mvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}
	
	@Test
	public void testAdd()throws Exception {
		UserModel um = this.getUM();
		
		this.us.delete(um.getUuid());
		
		MockHttpServletRequestBuilder hb = MockMvcRequestBuilders.post("/user/add")
				.param("uuid", um.getUuid())
				.param("name", um.getName())
				.param("age",""+um.getAge())
				;
		ResultActions ra = mvc.perform(hb);
		
		ra.andExpect(MockMvcResultMatchers.view().name("forward:/user/toList"));
		
		
		UserModel um2 = this.us.getByUuid(um.getUuid());
		
		Assert.assertEquals(um.getName(), um2.getName());		
		
	}
	
	private UserModel getUM() {
		UserModel um = new UserModel();
		um.setUuid("myUuid1");
		um.setName("testName");
		um.setAge(135);
		
		return um;
	}
	
	@Test
	public void testRest()throws Exception {
		UserModel um = this.getUM();
		
		this.us.delete(um.getUuid());
		
		MultiValueMap mvm = new LinkedMultiValueMap<>();
		mvm.add("uuid",um.getUuid());
		mvm.add("name",um.getName());
		mvm.add("age",um.getAge());
		
		String result = rest.postForObject("/user/add", mvm, String.class);
		System.out.println("result == "+result);
		
		
	}
	
}
