package com.jsp.springboot.actor.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.springboot.actor.Service.ActorService;
import com.jsp.springboot.actor.model.Actor;
import com.jsp.springboot.actor.utility.ResponseStructure;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class ActorController {

	@Autowired 
	private ActorService actorService;
	
	@RequestMapping(method = RequestMethod.POST,value = "/addActor")
	public Actor addActor(@RequestBody Actor actor) {
	return actorService.addActor(actor);
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "/actors/findByActorId")
	public Actor findByActorId(@RequestParam int actorId) {
		return actorService.findByActorById(actorId);
		
	}
	
	
	@RequestMapping(method = RequestMethod.PUT ,value = "/actors/updateByActorId")
	public Actor updateByActorId(@RequestParam int actorId ,@RequestBody Actor actor) {
		return actorService.updateByActorId(actorId, actor);
		
	}

	
	@RequestMapping(method = RequestMethod.DELETE ,value = "/actors/deleteByActorId")
	public Actor deleteByActorId(@RequestParam int actorId) {
		return actorService.deleteByActorId(actorId);
		
	}
	@RequestMapping(method = RequestMethod.GET,value = "/actors/findAllActors")
	public List<Actor> findAllActors() {
		return actorService.findAllActors();
	}
	

	
//----------------------------------------------- We are using ResponseEntity --------------------------------------------

	


	//@RequestMapping(method = RequestMethod.POST,value = "/addActor1")
	@PostMapping(value = "/addActor1")
	public ResponseEntity<ResponseStructure<Actor>> addActor1(@RequestBody Actor actor) {
	return actorService.addActor1(actor);
	}
	
	//@RequestMapping(method = RequestMethod.GET,value = "/actors/findActorById")
	@GetMapping(value = "/actors/findActorById/{actorId}")
	public ResponseEntity<ResponseStructure<Actor>> findActorById(@PathVariable int actorId){
		return actorService.findActorById(actorId);
		
	}
	
	//@RequestMapping(method = RequestMethod.PUT ,value = "/actors/updateActorById/{actorId}")
	@PutMapping(value = "/actors/updateActorById/{actorId}")
	public ResponseEntity<ResponseStructure<Actor>> updateActoByrId(@PathVariable int actorId ,@RequestBody Actor actor) {
		return actorService.updateActorById(actorId, actor);
		
	}
	
	
	//@RequestMapping(method = RequestMethod.DELETE ,value = "/actors/deleteActorById/{actorId}")
	@DeleteMapping(value = "/actors/deleteActorById/{actorId}")
	public ResponseEntity<ResponseStructure<Actor>> deleteActorById(@PathVariable int actorId) {
		return actorService.deleteActorById(actorId);
		
	}
	
	
	//@RequestMapping(method = RequestMethod.GET ,value = "/actors/fndAllActorss")
	@GetMapping(value = "/actors/fndAllActorss")
	public ResponseEntity<ResponseStructure<List<Actor>>> findAllActorss() {
		return actorService.findAllActorss();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
//----------------------------------- Basic How To Access Postman App ------------------------------------------
//----------------------------------- We Can Access By Using value name as a key value -------------------------
//----------------------------------- http://localhost:8080/print ----------------------------------------------
//----------------------------------- By default postman is get method -----------------------------------------

//		@RequestMapping(value = "/print",method = RequestMethod.GET)
//		public String print(@RequestParam String name,@RequestParam String city ) {
//			return name+" Belongs To "+city ;
//		}
	
//		@RequestMapping(value = "/calculate" ,method =RequestMethod.GET )
//		public int calculate(@RequestParam int num1, @RequestParam int num2) {
//			int sum=num1+num2;
//			return sum;
//		}

}
