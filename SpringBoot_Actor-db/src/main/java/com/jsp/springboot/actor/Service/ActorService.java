package com.jsp.springboot.actor.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.jsp.springboot.actor.model.Actor;
import com.jsp.springboot.actor.utility.ResponseStructure;

public interface ActorService  {
	

	 Actor addActor(Actor actor);
	
	 Actor findByActorById(int actor);
	
	 Actor updateByActorId(int actorId, Actor updateActor);
	
	 Actor deleteByActorId(int actorId);
	
	 List<Actor> findAllActors();
	
//------------------------------------------------ ResponseEntity ----------------------------------------------------------
	
	 ResponseEntity<ResponseStructure<Actor>> addActor1(Actor actor);
	
	 ResponseEntity<ResponseStructure<Actor>> findActorById(int actor);
	
	 ResponseEntity<ResponseStructure<Actor>> updateActorById(int actorId,Actor updateActor);
	
	 ResponseEntity<ResponseStructure<Actor>> deleteActorById(int actorId);
	 
	 ResponseEntity<ResponseStructure<List<Actor>>> findAllActorss();
	
	
}
