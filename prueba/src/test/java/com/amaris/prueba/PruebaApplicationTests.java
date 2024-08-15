package com.amaris.prueba;

import com.amaris.prueba.dto.ModelWrapperDto;
import com.amaris.prueba.entity.Employee;
import com.amaris.prueba.service.IEmployeeService;
import com.amaris.prueba.service.imp.IEmployeeServiceImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class PruebaApplicationTests {

	@Mock
	private RestTemplate restTemplate;

	@InjectMocks
	private IEmployeeServiceImp employeeService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testGetEmployeeId() {
		String employeeId = "1";
		ModelWrapperDto mockResponse = new ModelWrapperDto();
		Employee mockEmployee = new Employee();
		mockEmployee.setEmployee_salary(5000);
		mockResponse.setData(mockEmployee);

		when(restTemplate.getForObject(
				"https://dummy.restapiexample.com/api/v1/employee/" + employeeId,
				ModelWrapperDto.class)).thenReturn(mockResponse);

		ModelWrapperDto result = employeeService.getEmployeeId(employeeId);

		assertNotNull(result);
		assertEquals("60000", result.getData().getEmployee_anual_salary());
		verify(restTemplate).getForObject(
				"https://dummy.restapiexample.com/api/v1/employee/" + employeeId,
				ModelWrapperDto.class);
	}

}
