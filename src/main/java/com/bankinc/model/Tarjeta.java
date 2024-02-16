package com.bankinc.model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Data
@Table(name = "tarjeta")
public class Tarjeta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_tarj;
	
	@Column
	private String nrotarjeta;
	@Column
	private String nombre_titular;
	//Pattern pattern = Pattern.compile("\\d{2}/\\d{4}"); 
	@Column
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "\\d{2}/\\d{4}")
	private String fecha_vencim;
	//private LocalDateTime Fecha_vencim;
	@Column
	private int saldo;
	@Column
	private int tipo_prod;
	@Column
	private boolean activac;
	@OneToMany(mappedBy="tarj", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	//@JoinColumn(name = "id_transac")
	private List<Transacc> transaccs = new ArrayList<Transacc>();
	
	public Tarjeta() {
		
	}
	
	public Tarjeta(int id_tarj, String nrotarjeta, String nombre_titular, String fecha_vencim, int saldo,
			int tipo_prod, boolean activac, List<Transacc> transaccs) {
		super();
		this.id_tarj = id_tarj;
		this.nrotarjeta = nrotarjeta;
		this.nombre_titular = nombre_titular;
		this.fecha_vencim = fecha_vencim;
		this.saldo = saldo;
		this.tipo_prod = tipo_prod;
		this.activac = activac;
		this.transaccs = transaccs;
	}

	public int getId_tarj() {
		return id_tarj;
	}

	public void setId_tarj(int id_tarj) {
		this.id_tarj = id_tarj;
	}

	public String getNrotarjeta() {
		return nrotarjeta;
	}

	public void setNrotarjeta(String nrotarjeta) {
		this.nrotarjeta = nrotarjeta;
	}

	public String getNombre_titular() {
		return nombre_titular;
	}

	public void setNombre_titular(String nombre_titular) {
		this.nombre_titular = nombre_titular;
	}

	public String getFecha_vencim() {
		return fecha_vencim;
	}

	public void setFecha_vencim(String fecha_vencim) {
		this.fecha_vencim = fecha_vencim;
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	public int getTipo_prod() {
		return tipo_prod;
	}

	public void setTipo_prod(int tipo_prod) {
		this.tipo_prod = tipo_prod;
	}

	public boolean isActivac() {
		return activac;
	}

	public void setActivac(boolean activac) {
		this.activac = activac;
	}

	public List<Transacc> getTransaccs() {
		return transaccs;
	}

	public void setTransaccs(List<Transacc> transaccs) {
		this.transaccs = transaccs;
	}
	
	public void addTransacc(Transacc transacc) {
		this.transaccs.add(transacc);
	}
}
