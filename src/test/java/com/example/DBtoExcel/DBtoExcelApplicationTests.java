package com.example.DBtoExcel;

import com.example.DBtoExcel.repo.DetailsRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DBtoExcelApplicationTests {
	@Autowired
	private DetailsRepo detailsRepo;

	@Test
	void contextLoads() {
	}
	@Test
	public void testDetails(){
		System.out.println("Test Started");
		detailsRepo.findAll().forEach(i -> System.out.println(i.getEmail()));
	}

}
