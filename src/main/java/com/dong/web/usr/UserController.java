package com.dong.web.usr;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dong.web.enums.SQL;
import com.dong.web.pxy.Box;
import com.dong.web.pxy.Proxy;
@Component("usrc")
@RestController
@RequestMapping("/users")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired User user;
	@Autowired Map <String, Object> map;
	@Autowired UserMapper userMapper;
	@Autowired Box<Integer> box;
	@Autowired Proxy pxy;
	
	public int rowCount(){
		int rowCount = userMapper.countUsers();
		pxy.printer("rC"+rowCount);
		box.put("rowCount", rowCount);
		return box.get("rowCount");
	}
	
	@PostMapping("/")
	public Map<?,?> join(@RequestBody User param) {
		Consumer<User> c = t -> userMapper.insertUser(param);
		c.accept(param);
		map.clear();
		map.put("msg", "SUCCESS");
		return map;
		}
	
	@GetMapping("/{uid}/exist")
	public Map<?,?> existId(@PathVariable String uid){
		Function<String, Integer> f = t -> userMapper.existId(uid);
		map.clear();
		map.put("msg", f.apply(uid)==0 ? "SUCCESS" : "FAIL");
		return map;
		}
	
	@PostMapping("/{uid}")
	public User login(@PathVariable String uid, @RequestBody User param) {
		logger.info("ajax2가 보낸 아이디 비번{}",param.getUid()+","+param.getUpw());
		Function<User, User> f = t -> userMapper.selectUserByIdPw(param);
		logger.info("ajax2가 보낸 아이디 비번{}",f.apply(param));
		return f.apply(param);
	}
	
	@GetMapping("/{uid}")
	public User searchUserById(@PathVariable String uid, @RequestBody User param) {
		Function<User, User> f = t -> userMapper.selectUserByIdPw(param);
		return f.apply(param);
	}
	@PutMapping("/{uid}")
	public Map<?,?> updateUser(@PathVariable String uid, @RequestBody User param) {
		Consumer<User> c = t -> userMapper.selectUserByIdPw(param);
		c.accept(param);
		map.clear();
		map.put("msg", "SUCCESS");
		return map;
	}
	@DeleteMapping("/{uid}")
	public Map<?,?> removeUser(@PathVariable String uid, @RequestBody User param) {
		Consumer<User> c = t -> userMapper.selectUserByIdPw(param);
		c.accept(param);
		map.clear();
		map.put("msg", "SUCCESS");
		return map;
	}

	@GetMapping("/create/table")
	public Map<?,?> createUser(){
		HashMap<String, String> paramMap = new HashMap<>();
		paramMap.put("CREATE_USER", SQL.CREATE_USER.toString());
		Consumer<HashMap<String, String>> c = t -> userMapper.createUser(t);
		c.accept(paramMap);
		paramMap.clear();
		paramMap.put("msg",	"SUCCESS");
		return paramMap;
		
	}

	@GetMapping("/drop/table")
	public Map<?,?> dropUser(){
		HashMap<String, String> paramMap = new HashMap<>();
		paramMap.put("DROP_USER", SQL.DROP_USER.toString());
		Consumer<HashMap<String, String>> c = t -> userMapper.dropUser(t);
		c.accept(paramMap);
		paramMap.clear();
		paramMap.put("msg", "SUCCESS");
		return paramMap;
	}

	@GetMapping("/create/res")
	public Map<?,?> createRes(){
		HashMap<String, String> paramMap = new HashMap<>();
		paramMap.put("CREATE_RES", SQL.CREATE_RES.toString());
		Consumer<HashMap<String, String>> c = t -> userMapper.createRes(t);
		paramMap.put("msg", "SUCCESS");
		return paramMap;
	}

	@GetMapping("/create/db")
	public Map<?,?> createDB(){
		HashMap<String, String> paramMap = new HashMap<>();
		paramMap.put("CREATE_DB", SQL.CREATE_DB.toString());
		Consumer<HashMap<String, String>> c = t -> userMapper.createUser(t);
		c.accept(paramMap);
		paramMap.clear();
		paramMap.put("msg", "SUCCESS");
		return paramMap;
	}

	@GetMapping("/create/lol")
	public Map<?,?> createLolTable(){
		HashMap<String, String> paramMap = new HashMap<>();
		paramMap.put("CREATE_LOL", SQL.CREATE_LOL.toString());
		Consumer<HashMap<String, String>> c = t -> userMapper.createLolTable(t);
		c.accept(paramMap);
		paramMap.clear();
		paramMap.put("msg",	"SUCCESS");
		return paramMap;
		
	}
	@GetMapping("/create/report")
	public Map<?,?> createReportTable(){
		HashMap<String, String> paramMap = new HashMap<>();
		paramMap.put("CREATE_REPORT", SQL.CREATE_REPORT.toString());
		Consumer<HashMap<String, String>> c = t -> userMapper.createReportTable(t);
		c.accept(paramMap);
		paramMap.clear();
		paramMap.put("msg",	"SUCCESS");
		return paramMap;
		
	}
}
