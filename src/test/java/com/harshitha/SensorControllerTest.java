package com.harshitha;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.harshitha.controller.SensorController;
import com.harshitha.model.Sensor;
import com.harshitha.service.impl.SensorDataServiceImpl;
import com.harshitha.service.impl.SensorServiceImpl;
import com.jayway.jsonpath.JsonPath;

@RunWith(SpringRunner.class)
@WebMvcTest(SensorController.class)
class SensorControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private SensorServiceImpl service;
	
	@MockBean
	private SensorDataServiceImpl simpl;

	@Test
	public void testSaveController() throws Exception {
		Sensor sensor = new Sensor();
		sensor.setSensorId(1L);
		when(service.createSensor(ArgumentMatchers.any())).thenReturn(sensor);
		final MvcResult result = performMockPost();
		assertThat(JsonPath.parse(result.getResponse().getContentAsString()).read("$['sensorId']", Long.class)).isEqualTo(1L);
	}

	public MvcResult performMockPost() throws Exception {
		return mockMvc.perform(post("/").contentType(MediaType.APPLICATION_JSON)
				.content("{\n" + 
						"    \"country\": \"USA\",\n" + 
						"    \"city\": \"California\"\n" + 
						"}"))
				.andExpect(status().isOk())
				.andReturn();

	}

}
