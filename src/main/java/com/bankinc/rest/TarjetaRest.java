package com.bankinc.rest;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankinc.dao.TarjetaDAO;
import com.bankinc.model.Tarjeta;
import com.bankinc.service.TarjetaService;

@RestController
@RequestMapping("card")
public class TarjetaRest {

	@Autowired
	private TarjetaDAO tarjetaDAO;
	
	@Autowired
	private TarjetaService tarjServ;
	
	@PostMapping("/guardar")
	private void guardar(@RequestBody Tarjeta tarjeta) {
		tarjetaDAO.save(tarjeta);
	}
	
	@GetMapping("/listar") 
	public List<Tarjeta> listar() {
		return tarjetaDAO.findAll();
	}
	
	@PutMapping("/actualizar")
	public void actualizar(@RequestBody Tarjeta tarjeta) {
		tarjetaDAO.save(tarjeta);
	}
	
	@PutMapping("/eliminar")
	public void eliminar(@RequestBody Tarjeta tarjeta) {
		tarjetaDAO.save(tarjeta);
	}
	
	@GetMapping("/{productId}/number") 
	public String number(@PathVariable("productId") String productId) {
		// caracteres de interés en array de char
		char [] number = "0123456789".toCharArray();
		// longitud del array
		int numberLength = number.length;
		// instancia la clase Random
		Random random = new Random();
		// StringBuffer para componer cadena aleatoria
		StringBuffer buffer = new StringBuffer();
		// añadimos el productId
		buffer.append(productId);
		// bucle para elegir cadena de 10 caracteres al azar
		for(int i = 0; i < 10; i ++) {
			// se añade al buffer un caracter al azar del array
			buffer.append(number[random.nextInt(numberLength)]);
		}
		System.out.println("Random Nro Tarjeta: " + buffer.toString());
		return buffer.toString();
	}
	
	@PostMapping("/enroll")
	public void enroll(@RequestBody Tarjeta tarjeta) {
		tarjeta.setActivac(true);
		System.out.println(tarjeta.getNrotarjeta() + tarjeta.isActivac());
		actualizar(tarjeta);
	}
	
	@DeleteMapping("/{cardId}")
	public void delete(@PathVariable("cardId") String cardId) throws Exception {
		Tarjeta tarjObj = null;
		if(!"".equals(cardId)) {
			tarjObj = tarjServ.fetchTarjByNrotarjeta(cardId);
			if(tarjObj == null) {
				throw new Exception("No existe la Tarjeta a bloquear !!");
			}
		}
		tarjObj.setActivac(false);
		System.out.println(tarjObj.getNrotarjeta() + tarjObj.isActivac());
		eliminar(tarjObj);
	}
	
	@PostMapping("/balance")
	public void balance(@RequestBody Tarjeta tarjeta) {
		//tarjeta.setSaldo(0);
		System.out.println(tarjeta.getNrotarjeta() + tarjeta.getSaldo());
		actualizar(tarjeta);
	}
	
	@GetMapping("/balance/{cardId}")
	public int recarga(@PathVariable("cardId") String cardId) throws Exception {
		Tarjeta tarjObj = null;
		int balance = 0;
		if(!"".equals(cardId)) {
			tarjObj = tarjServ.fetchTarjByNrotarjeta(cardId);
			if(tarjObj == null) {
				throw new Exception("No existe la Tarjeta para consultar su Saldo !!");
			}
		}
		balance = tarjObj.getSaldo();
		System.out.println(tarjObj.getNrotarjeta() + tarjObj.getSaldo());
		return balance;
	}
}
