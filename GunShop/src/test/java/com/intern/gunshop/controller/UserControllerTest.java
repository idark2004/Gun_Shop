//package com.intern.gunshop.controller;
//
//import static org.mockito.Mockito.when;
//import static org.hamcrest.CoreMatchers.is;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//
//import java.sql.Timestamp;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.BeforeEach;
//import org.mockito.Mock;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.security.test.context.support.WithMockUser;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import com.intern.gunshop.entity.Role;
//import com.intern.gunshop.entity.Users;
//import com.intern.gunshop.repository.UserRepository;
//import com.intern.gunshop.service.UserService;
//
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class UserControllerTest {
//
//	@Autowired
//	private MockMvc mockMvc;
//
//	@Mock
//	private UserService service;
//
//	@MockBean
//	private UserRepository repo;
//
//	private List<Users> userList;
//
//	@BeforeEach
//	void setUp() {
//		Role role = new Role();
//		List<Role> roleList = new ArrayList<Role>();
//		role.setRole_id(1);
//		role.setRole_name("USER");
//		roleList.add(role);
//		this.userList = new ArrayList<Users>();
//		this.userList.add(new Users(1, "pete", "a@a.com", "123", LocalDate.now(),
//				Timestamp.valueOf(LocalDateTime.now()), true, roleList, null, null, null));
//	}
//
//	@Test
//	@WithMockUser
//	public void getAllUserWithUserRole() throws Exception {
//		when(repo.findAll()).thenReturn(userList);
//
//		this.mockMvc.perform(MockMvcRequestBuilders.get("/api/user/all").accept(MediaType.APPLICATION_JSON))
//				.andExpect(status().isForbidden());
//	}
//
//	@Test
//	@WithMockUser(authorities = { "ADMIN" })
//	public void getAllUserWithAdminRole() throws Exception {
//		when(repo.findAll()).thenReturn(userList);
//
//		this.mockMvc.perform(MockMvcRequestBuilders.get("/api/user/all").accept(MediaType.APPLICATION_JSON))
//				.andExpect(status().isOk()).andExpect(jsonPath("$.size()", is(userList.size())));
//	}
//}
