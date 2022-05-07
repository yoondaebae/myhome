package com.toto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toto.model.Board;
import com.toto.model.User;
import com.toto.repository.BoardRepository;
import com.toto.repository.UserRepository;

@Service
public class BoardService {
	
	@Autowired
	private BoardRepository boardRepository;
	
	@Autowired
	private UserRepository userRepository;
	

	public Board save(String username, Board board) {
		
		User user = userRepository.findByUsername(username);
		
		board.setUser(user);
		
		return boardRepository.save(board);
	}
}
