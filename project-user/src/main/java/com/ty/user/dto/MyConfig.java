package com.ty.user.dto;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = {"com.ty.user.dto","com.ty.user.dao", "com.ty.helper"})
public class MyConfig {
	
	@Bean(name = "entityManager")
	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("ratna").createEntityManager();
	}
	
	@Bean(name="entityTranscation")
	public EntityTransaction getEntityTransaction() {
		return getEntityManager().getTransaction();
	}
	@Bean(name = "scanner")
	public Scanner getScanner() {
		return new Scanner(System.in);
	}
}
