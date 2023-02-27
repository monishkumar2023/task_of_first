package com.example.TicketsRegister.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.TicketsRegister.bean.Bean;
import com.example.TicketsRegister.service.TicketService;

@RestController
public class TicketController
{
	@Autowired
	TicketService ticketprovide;
	
	@GetMapping("/getalltickets")
	public List<Bean> alltickets()
	{
		return ticketprovide.alltickets();
	}
	
	@GetMapping("/getidticket/{getid}")
	public Bean oneticket(@PathVariable("getid")int getid)
	{
		return ticketprovide.Per_ticket_info(getid);
	}
	
	@PostMapping("/add_passenger")
	public List<Bean> addperson_info(@RequestBody Bean tickets)
	{
		ticketprovide.add_new_register(tickets);
		return ticketprovide.alltickets();
	}
	
	@DeleteMapping("/delete/{del_id}")
	public List<Bean> delete_passenger(@PathVariable("del_id")int del_id)
	{
		ticketprovide.delete_passenger(del_id);
		return ticketprovide.alltickets();
	}
	
	@PutMapping("/update/{passenger_id}")
	public List<Bean> update_details(@RequestBody Bean pass_id)
	{
		ticketprovide.update_user(pass_id);
		return ticketprovide.alltickets();
	}
}
