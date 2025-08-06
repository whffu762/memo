package net.dsa.ex.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class Ajax1Controller {
	
	@GetMapping("ajax1")
	public String ajax1() {
		return "ajax/ajaxTest";
	}

	
	@ResponseBody
	@GetMapping("ajaxTest1")
	public void ajaxTest1() {
		log.debug("ajaxTest1 실행");
		return ;
	}
	
	@ResponseBody
	@PostMapping("ajaxTest2")
	public void ajaxTest2(@RequestParam("str") String str) {
		log.debug("ajaxTest2 출력 : {}", str);
	}
	
	@ResponseBody
	@GetMapping("ajaxTest3")
	public String ajaxTest3() {
		String msg = "서버에서 보낸 메세지";
		log.debug("ajaxTest3에서 보냄 : {}", msg);
		
		return msg;
	}
	
	@ResponseBody
	@PostMapping("ajaxTest4")
	public int ajaxTest4(
			@RequestParam("num1") int a,
			@RequestParam("num2") int b
			) {
		log.debug("ajaxTest4 전달받은 값 : {} {} ", a, b);
		
		return a + b;
	}
	
	@PostMapping("ajaxTest5")
	public ResponseEntity<?> ajaxTest5(
			@RequestParam("num4") String a,
			@RequestParam("num5") String b
			) {
		log.debug("ajaxTest5 전달받은 값 : {} {} ", a, b);
		
		try {
			int x = Integer.parseInt(a);
			int y = Integer.parseInt(b);
			int result = x / y;
			
			return ResponseEntity.ok(result);
		} catch (NumberFormatException e) {
			
			log.debug("예외 발생 {}", e.getMessage());
			return ResponseEntity.badRequest().body("정수가 아닙니다");
		} catch(ArithmeticException e) {
			
			log.debug("예외 발생 {}", e.getMessage());
			return ResponseEntity.badRequest().body("0으로 나눌 수 없습니다");
		}
	}
	
	@PostMapping("ajaxTest6")
	public ResponseEntity<?> ajaxTest5(
			@RequestParam("num7") String a,
			@RequestParam("num8") String b,
			@RequestParam("op") String op
			) {
		log.debug("ajaxTest6 전달받은 값 : {} {} {}", a, b, op);
		
		try {
			int x = Integer.parseInt(a);
			int y = Integer.parseInt(b);
			int result = 0;
			
			switch(op) {
			case "+" : result = x + y; break;
			case "-" : result = x - y; break;
			case "*" : result = x * y; break;
			case "/" : result = x / y; break;
			default : 
				return ResponseEntity.badRequest().body("wrong op");
			}
			
			return ResponseEntity.ok(result);
		} catch (NumberFormatException e) {
			
			log.debug("예외 발생 {}", e.getMessage());
			return ResponseEntity.badRequest().body("정수가 아닙니다");
		} catch(ArithmeticException e) {
			
			log.debug("예외 발생 {}", e.getMessage());
			return ResponseEntity.badRequest().body("0으로 나눌 수 없습니다");
		}
	}
	
}
