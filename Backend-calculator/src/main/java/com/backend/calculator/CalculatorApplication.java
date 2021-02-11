package com.backend.calculator;

import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

@CrossOrigin
@SpringBootApplication
//@RestController //automatically serializes respond to json
@Controller
@RequestMapping(value = "api")
public class CalculatorApplication {

	//javascript engine that's going to be doing calculation for us.
	ScriptEngineManager mgr = new ScriptEngineManager();
	ScriptEngine engine = mgr.getEngineByName("JavaScript");
	

	public static void main(String[] args) {
		SpringApplication.run(CalculatorApplication.class, args);
	}

	@GetMapping(value = "/")
	@ResponseBody
	public String landingPage(){
		return "Welcome to the calculator api\n";
	}

	@RequestMapping(value = "calculate", method = RequestMethod.GET)		
	@ResponseBody
	public String calculate(@RequestParam String expression){
		//System.out.println(expression + "\n");
		try{
			 //System.out.println(engine.eval(expression) + "\n");
			 return engine.eval(expression).toString() + "\n";
		}		
		catch(Exception e){
			return "Error: Invalid exp\n";
		}		
	}

	@GetMapping(value = "*")
	@ResponseBody
	public String fallBack(){		
		return "Could not find endpoint\n";
	}



}
