package com.toto.validator;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.thymeleaf.util.StringUtils;

import com.toto.model.Board;

@Component
public class BoardValidator implements Validator{
		
		@Override
	    public boolean supports(Class clazz) {
	        return Board.class.equals(clazz);
	    }

		@Override
	    public void validate(Object obj, Errors e) {

	        Board b = (Board) obj;
	        if (StringUtils.isEmpty(b.getContent())) {
	            e.rejectValue("content", "key", "내용을 입력하세요");
	        } 
	    }
}
