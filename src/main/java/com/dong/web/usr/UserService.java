package com.dong.web.usr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dong.web.pxy.Proxy;

@Component("us")
public class UserService extends Proxy {
	@Autowired UserMapper userMapper;
	public String selectAlla() {
		//Arrays.asList(1,2,3,4,5).stream().forEach(System.out::println);
		//IntStream.rangeClosed(101, 105).forEach(System.out::println);
		new Random().ints().limit(5).forEach(System.out::println);
		return string("");
	}
	public String selectAll() {
		List<User> ls = userMapper.selectAll();
		List<String> ls2 = new ArrayList<>();
		for(int i = 0 ; i<ls.size();i++) {
			ls2.add(ls.get(i).getUid());
		}
		Stream.of(ls2)
		.sorted()
		.forEach(System.out::println);
		return string("5");
	}
	public static void main(String[] args) {
		UserService s = new UserService();
		s.selectAll();
	}
}
