package com.toto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.toto.model.Board;

public interface BoardRepository extends JpaRepository<Board, Long>{

}
