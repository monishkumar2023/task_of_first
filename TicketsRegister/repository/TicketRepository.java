package com.example.TicketsRegister.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.TicketsRegister.bean.Bean;

public interface TicketRepository extends CrudRepository<Bean, Integer> 
{
	
}
