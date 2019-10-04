package com.xu.springbootdemo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xu.springbootdemo.annotation.TestAnnotation;
import com.xu.springbootdemo.entity.TestDB_getUsername;

/**
 * 控制器Controller示例 HelloWorldController
 * 
 * @author xuenhua
 */

@RestController // servlet map 注解
public class HelloWorldController {
	/**
	 * 注入实体类
	 * 注意：不能用用new 创建实体类，用new创建 spring启动时的注入没了
	 */
	@Autowired 
	private TestDB_getUsername test;

	@RequestMapping("/hello1")
	@TestAnnotation(name="aspect hello1")
	public String hello1() {
		return "Hello World";
	}

	@RequestMapping("/hello2")
	public List<String> hello2() {
		return Arrays.asList(new String[] { "A", "B", "C" });
	}

	@RequestMapping("/username")
	public String getUsername() {
		//new 创建实体类对象有问题！
		//TestDB_getUsername test=new TestDB_getUsername();
		String result = test.getUserName("xuenhua");
		return result;
	}
}
