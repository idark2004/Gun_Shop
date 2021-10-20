package com.intern.gunshop.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

import com.intern.gunshop.entity.Role;

@DataJpaTest
@Rollback(false)
public class RoleServiceTest {
	
	@Autowired
	private RoleService service;
	
	@Test
	public void testGetAll() {
		List<Role>  listed = service.listAll();
		
		assertThat(listed.size()).isGreaterThan(0);
	}
}
