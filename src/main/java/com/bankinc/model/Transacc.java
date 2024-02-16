package com.bankinc.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Data
@Table(name = "transacc")
public class Transacc {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "\\d{2}/\\d{4}")
	private String fecha_transac;
	@Column
	private int monto_transac;
	@Column
	private boolean estado_transac;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "id_tarj", nullable = false)
	private Tarjeta tarj;
	
	public Transacc() {
		
	}
	
	public Transacc(int id, String fecha_transac, int monto_transac, boolean estado_transac) {
		super();
		this.id = id;
		this.fecha_transac = fecha_transac;
		this.monto_transac = monto_transac;
		this.estado_transac = estado_transac;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFecha_transac() {
		return fecha_transac;
	}

	public void setFecha_transac(String fecha_transac) {
		this.fecha_transac = fecha_transac;
	}

	public int getMonto_transac() {
		return monto_transac;
	}

	public void setMonto_transac(int monto_transac) {
		this.monto_transac = monto_transac;
	}

	public boolean isEstado_transac() {
		return estado_transac;
	}

	public void setEstado_transac(boolean estado_transac) {
		this.estado_transac = estado_transac;
	}

	public Tarjeta getTarj() {
		return tarj;
	}

	public void setTarj(Tarjeta tarj) {
		this.tarj = tarj;
	}
	
	
}
