package com.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.demo.entity.User;
import com.demo.service.ReadCsv;
@Component
public class CsvToObject {

	public void printUser() {
		//CsvToObject csvToObject = new CsvToObject();
		mapData().forEach(user->{
			System.out.println(user.toString());
		});
	}
	
	public List<User> mapData() {
		List<String[]> list=ReadCsv.readCsv();
		List<User> listUser= new ArrayList<>();
		String[] strA=list.get(0);
		list.stream().skip(1).forEach(user->{
			listUser.add(mapUser(strA, user));
		});
		return listUser;
	}
	
	
	public User mapUser(String[] strA,String[] data) {
		User user=new User();
		for(int i=0;i<strA.length;i++) {
			String temp=strA[i];
			switch (temp) {
				case "id":
				    user.setId(Integer.parseInt(data[i]));
				    break;
				case "name":
					user.setName(data[i]);
					break;
				case "number":
				    user.setNumber(Integer.parseInt(data[i]));
				    break;
				case "address":
				    user.setAddress(data[i]);
				    break;
				default: 
				    break;
				}
		}
		return user;
		
	}
}
