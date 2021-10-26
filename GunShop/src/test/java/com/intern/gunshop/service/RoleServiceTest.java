package com.intern.gunshop.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.intern.gunshop.entity.Role;
import com.intern.gunshop.repository.RoleRepository;

@SpringBootTest
public class RoleServiceTest {
	
	@Mock
	private RoleRepository repo;
	
	@Autowired
	private RoleService service;
	
	@DisplayName("Get all role in database")
	@Test
	public void getAllRolesTest() {
		List<Role>  listed = service.listAll();
		
		assertThat(listed.size()).isGreaterThan(0);
	}
	
	@DisplayName("Using a real id in database to get role")
	@Test
	public void getRoleByTrueId() {
		Role role = service.get(1);
		
		assertThat(role.getRole_name()).contains("ADMIN");
	}
	
	@DisplayName("Input an id that does not exist")
	@Test
	public void exceptionGetRoleByIdTest() {		
		
		assertThrows(NoSuchElementException.class,() ->{
			service.get(0);
		});
	}
}
