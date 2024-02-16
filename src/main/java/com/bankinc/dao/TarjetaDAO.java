package com.bankinc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bankinc.model.Tarjeta;

public interface TarjetaDAO extends JpaRepository<Tarjeta, Integer>{
	public Tarjeta findByNrotarjeta(String nrotarjeta);
}
