package kr.pe.playdata;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import kr.pe.playdata.controller.Controller;

@SpringBootTest
class LblProjectApplicationTests {

	@Autowired
	private Controller controller;
	private MockMvc mock;

	@BeforeEach
	public void init() {
		mock = MockMvcBuilders.standaloneSetup(controller).build();
	}

	@Test
	void contextLoads() {
		try {
			//=============전체 조회==========================// 
			mock.perform(get("/selectall"));
			
			//============제목 조회==========================//
			mock.perform(get("/selecttitle").param("title", "눈의여왕"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
