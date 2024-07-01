package com.jsp.springboot.actor.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.springboot.actor.Repository.ActorRepository;
import com.jsp.springboot.actor.Service.ActorService;
import com.jsp.springboot.actor.exception.ActorNotFoundByIdException;
import com.jsp.springboot.actor.model.Actor;
import com.jsp.springboot.actor.utility.ResponseStructure;
@Service
public class ActorServiceImpl implements ActorService {
	@Autowired
	private ActorRepository actorRepository;

	public Actor addActor(Actor actor) {
		return actorRepository.save(actor);

	}

	@Override
	public Actor findByActorById(int actorId) {
		Optional<Actor> optional = actorRepository.findById(actorId);

		if(optional.isPresent()) {
			Actor actor=optional.get();
			return actor;
		}
		else {
			System.out.println("Data is not Present");
			return null;
		}

	}

	@Override
	public Actor updateByActorId(int actorId, Actor updateActor) {
		Optional<Actor> optional=actorRepository.findById(actorId);
		if(optional.isPresent()) {
			Actor existingActor=optional.get();
			updateActor.setActorId(existingActor.getActorId());
			return actorRepository.save(updateActor);
		}
		else {
			return null;
		}
	}

	@Override
	public Actor deleteByActorId(int actorId) {
		Optional<Actor> optional=actorRepository.findById(actorId);
		if(optional.isPresent()) {
			Actor actor =optional.get();
			actorRepository.delete(actor);
			return actor;
		}
		else {
		return null;
		}
	}

	@Override
	public List<Actor> findAllActors() {
		List<Actor> actors = actorRepository.findAll();
		
//		if(actors !=null) {
//		return null;
//		}
//		else {
//			return null;
//		}
		
		if(actors.isEmpty()) {
			return null;
		}
		else {
			return actors;
		}
	}
	
//--------------------------------------------------------------------------------------------------------------------------

	@Override
	public ResponseEntity<ResponseStructure<Actor>> addActor1(Actor actor) {
		Actor actor2 =actorRepository.save(actor);
		
		ResponseStructure<Actor> responseStructure=new ResponseStructure<>();
		responseStructure.setStatuscode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Actor Object created Sucessfully !!");
		responseStructure.setData(actor2);
		return new ResponseEntity<ResponseStructure<Actor>> (responseStructure,HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<ResponseStructure<Actor>> findActorById(int actorId) {
		Optional<Actor> optional=actorRepository.findById(actorId);
		
		if(optional.isPresent()) {
			Actor actor = optional.get();
			ResponseStructure<Actor> responseStructure=new ResponseStructure<>();
			responseStructure.setStatuscode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Actor Object created Sucessfully !!");
			responseStructure.setData(actor);

			return new ResponseEntity<ResponseStructure<Actor>> (responseStructure,HttpStatus.FOUND);
		}
		else {
			throw new ActorNotFoundByIdException("Not Found Message");
		}
		
		
	}

	@Override
	public ResponseEntity<ResponseStructure<Actor>> updateActorById(int actorId, Actor updateActor ) {
		Optional<Actor> optional=actorRepository.findById(actorId);
		if(optional.isPresent()) {
			Actor actor=optional.get();
			updateActor.setActorId(actor.getActorId());
			ResponseStructure<Actor> responseStructure=new ResponseStructure<>();
			responseStructure.setStatuscode(HttpStatus.OK.value());
			responseStructure.setMessage("Actor Data is Updated Sucessfully !!");
			responseStructure.setData(actor);
			actorRepository.save(updateActor);
			return new ResponseEntity<ResponseStructure<Actor>>(responseStructure,HttpStatus.OK);
		}
		else {
		return null;
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<Actor>> deleteActorById(int actorId) {
		
		Optional<Actor> optional=actorRepository.findById(actorId);
		if(optional.isPresent()) {
			Actor actor =optional.get();
			actorRepository.delete(actor);
			ResponseStructure<Actor> responseStructure=new ResponseStructure<>();
			responseStructure.setStatuscode(HttpStatus.OK.value());
			responseStructure.setMessage("Actor Data is Deleted Sucessfully !!");
			responseStructure.setData(actor);
			return new ResponseEntity<ResponseStructure<Actor>>(responseStructure,HttpStatus.OK);
		}
		else {
		return null;
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Actor>>> findAllActorss() {
		List<Actor> actors = actorRepository.findAll();
			
		if(actors!=null) {
			ResponseStructure<List<Actor>> responseStructure=new ResponseStructure<>();
			responseStructure.setStatuscode(HttpStatus.OK.value());
			responseStructure.setMessage("Actor Data is Deleted Sucessfully !!");
			responseStructure.setData(actors);
			return new ResponseEntity<ResponseStructure<List<Actor>>>(responseStructure,HttpStatus.FOUND);
		}
		else {
			return null;
		}
		
	}

}
