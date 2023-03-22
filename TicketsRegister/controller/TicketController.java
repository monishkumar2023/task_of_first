package com.example.TicketsRegister.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.TicketsRegister.bean.Bean;
import com.example.TicketsRegister.service.TicketService;
@Validated
@RestController
public class TicketController
{
	@Autowired
	TicketService ticketprovide;
	
	@GetMapping("/alltickets")
	public List<Bean> alltickets()
	{
		return ticketprovide.alltickets();
	}
	
	@GetMapping("/ticket/{id}")
	public Bean oneticket(@Validated @PathVariable("id")int id) throws IdNotFoundException
	{
		if(id>45 && id<100)
		{
			String messege=String.format("id not found",id);
			throw new IdNotFoundException(messege);
		}
		return ticketprovide.Per_ticket_info(id);
	}
	@PostMapping("/add_passenger")
	public List<Bean> addperson_info(@RequestBody Bean person_information)
	{
		ticketprovide.add_new_register(person_information);
		return ticketprovide.alltickets();
	}
	
	@DeleteMapping("/remove/{id}")
	public List<Bean> delete_passenger(@PathVariable("id")int id)
	{
		ticketprovide.delete_passenger(id);
		return ticketprovide.alltickets();
	}
	
	@PutMapping("/update/{passenger_id}")
	public List<Bean> update_details(@RequestBody Bean passenger_id)
	{
		ticketprovide.update_user(passenger_id);
		return ticketprovide.alltickets();
	}
}
@ResponseStatus(value=HttpStatus.NOT_FOUND,reason="no person")
class IdNotFoundException extends Exception
{
	public IdNotFoundException(String messege)
	{
		super("id not found");
	}
}