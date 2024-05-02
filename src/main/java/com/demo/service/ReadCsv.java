package com.demo.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
@Component
public class ReadCsv {

	public static List<String[]> readCsv() {
		List<String[]> data = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(
				new InputStreamReader(new ClassPathResource("name_number_address_Id.csv").getInputStream()))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",");
				data.add(values);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
}
