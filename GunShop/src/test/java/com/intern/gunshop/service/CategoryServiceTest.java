package com.intern.gunshop.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.anyInt;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.intern.gunshop.entity.Category;
import com.intern.gunshop.repository.CategoryRepository;

@SpringBootTest
public class CategoryServiceTest {	

	@MockBean
	private CategoryRepository repo;
	
	@Autowired
	private CategoryService service;
	
	private List<Category> list;
	
	@BeforeEach
	void setUp() throws Exception {
		this.list = new ArrayList<Category>();
		this.list.add(new Category("heavy", "booom"));
		this.list.add(new Category("rpg", "ddd"));
		this.list.add(new Category("ak-47", "tchhhh"));
		this.list.add(new Category("mini", "chhhhh"));
	}

	@DisplayName("Get all category")
	@Test
	void getAllTest() {
		when(repo.findAll()).thenReturn(this.list);
		
		List<Category> categoryList = service.getAll();		
		assertEquals(list.size(), categoryList.size());
	}

	@DisplayName("Get category by id")
	@Test
	void getByIdTest() {
		Category cate = new Category();
		cate.setCategory_id(1);
		cate.setCategory_name("gun");
		cate.setCategory_description("pew");		
		Optional<Category> reCate = Optional.ofNullable(cate);
		
		when(repo.findById(anyInt())).thenReturn(reCate);
		
		Category categoryDetail = service.get(anyInt());
		
		assertEquals("gun", categoryDetail.getCategory_name());
	}

	@DisplayName("Add new category")
	@Test
	void testAdd() {
		Category cate = new Category("bazooka", "bomb");
		Category sCate = new Category("bazooka", "bomb");
		sCate.setCategory_id(1);
		
		when(repo.save(cate)).thenReturn(sCate);
		
		assertEquals(sCate, service.addNew(cate));
	}

}
