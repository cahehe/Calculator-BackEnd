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

	ScriptEngineManager mgr = new ScriptEngineManager();
    ScriptEngine engine = mgr.getEngineByName("JavaScript");

	public static void main(String[] args) {
		SpringApplication.run(CalculatorApplication.class, args);
	}

	@RequestMapping(value = "/calculate", method = RequestMethod.GET)		
	@ResponseBody
	public String calculate(@RequestParam String expression){
		System.out.println(expression + "\n");
		try{
			 //System.out.println(engine.eval(expression) + "\n");
			 return engine.eval(expression).toString() + "\n";
		}		
		catch(Exception e){
			return "Error: Invalid exp\n";
		}		
	}

	@GetMapping(value = "*")
	public String fallBack(){		
		return "Could not find endpoint\n";
	}

	@RequestMapping(value = "/hola", headers = "key=val")
	//@ResponseBody
	public String hola(){		
		return "Hola1\n";
	}

	@RequestMapping(value = "/hola", headers = "key2=val2")
	//@ResponseBody
	public String hola2(){		
		return "Hola2\n";
	}

	@PostMapping("/api/foos")
	@ResponseBody
	public String updateFoos(@RequestParam Map<String,String> allParams) {
		return "Parameters are " + allParams.entrySet() + "\n";
	}


	@GetMapping(value = "/map")
	public String withMap(@RequestParam Map<String, String> allParam){
		return "Params are " + allParam.entrySet() + "\n"; 
	}



}
