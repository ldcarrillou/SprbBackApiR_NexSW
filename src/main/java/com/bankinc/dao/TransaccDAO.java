package com.bankinc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bankinc.model.Transacc;

public interface TransaccDAO extends JpaRepository<Transacc, Integer> {
	public Transacc findById(int id);
}
