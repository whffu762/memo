package net.dsa.ex.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import net.dsa.ex.dto.PersonDTO;

@Slf4j
@Controller
public class Ajax2Controller {

	@GetMapping("ajax2")
	public String ajax2() {
		return "ajax/ajaxTest2";
	}
	
	@ResponseBody
	@PostMapping("formSubmit1")
	public void formSubmit1(
			@RequestParam("name") String name,
			@RequestParam("age") String age,
			@RequestParam("phone") String phone) {
		
		log.debug("formSubmit 1 : {} {} {}", name, age, phone);
	}
	
	@ResponseBody
	@PostMapping("formSubmit2")
	public void formSubmit1(@RequestBody PersonDTO person) {
		
		log.debug("formSubmit 2 : {} {} {}", person.getName(), person.getPhone(), person.getAge());
	}
	
	@ResponseBody
	@PostMapping("formSubmit3")
	public void formSubmit3(
			@RequestParam("name") String name,
			@RequestParam("age") String age,
			@RequestParam("phone") String phone) {
		
		log.debug("formSubmit 3 : {} {} {}", name, age, phone);
	}
	
	@ResponseBody
	@GetMapping("getObject")
	public PersonDTO getObject() {
		return new PersonDTO("홍길동", 11, "011");
	}
	
	@ResponseBody
	@GetMapping("getList")
	public List<PersonDTO> getList() {
		
		List<PersonDTO> list = new ArrayList<>();
		for(int i=0;i<4;i++) {
			list.add(new PersonDTO("홍길동" + i, 10 + i, "011" + i));
		}
		
		return list;
	}
	
	@ResponseBody
	@PostMapping("postList")
	public void postList(
			@RequestParam("ar") String [] ar
			) {
		
		for( String s : ar) {
			log.debug("배열 요소 : {}", s);
		}
	}
	
	@ResponseBody
	@PostMapping("postObjectList")
	public List<PersonDTO> postObjectList(
			@RequestBody List<PersonDTO> personList
			) {
		
		log.debug("personList {} ", personList);
		
		return personList;
		
	}
}

