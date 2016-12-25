package com.spring.batch.simple;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.spring.batch.simple.model.User;

@Component("csvItemProcessor")
public class CsvItemProcessor implements ItemProcessor<User, User>{

	@Override
	public User process(User user) throws Exception {
		
		user.setUsername(user.getUserId() + "--" + user.getUsername());
        
        return user;
	}
}
