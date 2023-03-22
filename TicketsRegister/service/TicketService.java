package com.example.TicketsRegister.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.TicketsRegister.bean.Bean;
import com.example.TicketsRegister.repository.TicketRepository;

@Component
@Service
public class TicketService 
{
	@Autowired
	TicketRepository availabletickets;
	public List<Bean> alltickets()
	{
		List<Bean> list=new ArrayList<Bean>();
		list=(List<Bean>) availabletickets.findAll();
		return list;
	}
	public Bean Per_ticket_info(int ticket_id)
	{
		return availabletickets.findById(ticket_id).get();
	}
	public Bean add_new_register(Bean user_info)
	{
		return availabletickets.save(user_info);
	}
	public void delete_passenger(int removeID)
	{
		availabletickets.deleteById(removeID);
	}
	public Bean update_user(Bean new_detail) 
	{
		return availabletickets.save(new_detail);
	}
}
