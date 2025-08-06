package net.dsa.ex.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.dsa.ex.dto.CommentDTO;
import net.dsa.ex.service.CommentService;

@Slf4j
@RestController
@RequestMapping("ex")
@RequiredArgsConstructor
public class CommentRestController {
	
	private final CommentService commentService;
	
	@GetMapping("list")
	public List<CommentDTO> list(){
		
		List<CommentDTO> list = commentService.getList();
		
		return list;
	}
	
	@DeleteMapping("delete/{num}")
	public void delete(@PathVariable("num") Integer num) {
		
		log.debug("delete-num : {}", num);
		commentService.delete(num);
	}

}
