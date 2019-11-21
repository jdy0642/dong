package com.dong.web.usr;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data 
@Component
@AllArgsConstructor
@NoArgsConstructor
@Lazy
public class User {

	private String uid, uname, upw, tel, upoint, age, loc, gender,
		email, bookmark, lolblack, futblack;
}