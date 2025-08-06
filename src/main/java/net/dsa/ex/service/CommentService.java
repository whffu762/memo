package net.dsa.ex.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.dsa.ex.dto.CommentDTO;
import net.dsa.ex.entity.CommentEntity;
import net.dsa.ex.repository.CommentRepository;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class CommentService {
	
	private final CommentRepository commentRepository;

	public List<CommentDTO> getList(){
		
		List<CommentEntity> entityList = commentRepository.findAll();
		List<CommentDTO> dtoList = new ArrayList<>();
		
		for(CommentEntity e : entityList) {
			CommentDTO dto = CommentDTO.builder()
									.num(e.getNum())
									.name(e.getName())
									.comment(e.getComment())
									.build();
			dtoList.add(dto);
		}
		
		return dtoList;
	}
	
	public void delete(int num) {
		
		commentRepository.deleteById(num);
	}
}
