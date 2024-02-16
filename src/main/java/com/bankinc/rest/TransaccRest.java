package com.bankinc.rest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankinc.model.Transacc;
import com.bankinc.service.TransaccService;

@RestController
@RequestMapping("transaction")
public class TransaccRest {

	@Autowired
	private TransaccService transaccServ;
	
	@PostMapping("/guardar")
	private void guardar(@RequestBody Transacc transacc) {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("MM/yyyy");
		LocalDate fecha_trans = LocalDate.parse(transacc.getFecha_transac(), formato);
		LocalDateTime fecha_tarj = LocalDateTime.parse(transacc.getTarj().getFecha_vencim());
		int fMes = fecha_trans.getMonthValue();
		int fAno = fecha_trans.getYear();
		if(transacc.getMonto_transac() <= transacc.getTarj().getSaldo() &&
		fMes <= fecha_tarj.getMonthValue() && fAno <= fecha_tarj.getYear() &&
		transacc.getTarj().isActivac()) {
			transaccServ.saveTransacc(transacc);
		}
		else JOptionPane.showMessageDialog(null, "No se puede realizar la Transacción !!");
	}
	
	@GetMapping("/listar") 
	public List<Transacc> listar() {
		return transaccServ.findAll();
	}
	
	@PostMapping("/purchase")
	public Transacc registTransacc(@RequestBody Transacc transacc) {
		Transacc transaccObj = null;
		transaccObj = transaccServ.saveTransacc(transacc);
		return transaccObj;
	}
	
	@GetMapping("/{transactionId}")
	public Transacc consulta(@PathVariable("transactionId") int transactionId) throws Exception {
		Transacc transaccObj = null;
		if(transactionId != 0 && transactionId > 0) {
			transaccObj = transaccServ.fetchTransById(transactionId);
			if(transaccObj == null) {
				throw new Exception("No existe la Transacción para consultar !!");
			}
		}
		return transaccObj;
	}
	
	@SuppressWarnings("null")
	@PostMapping("/anulation")
	public Transacc anulaTransacc(@RequestBody Transacc transacc) {
		Transacc transaccObj = null;
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("MM/yyyy");
		LocalDate fecha_trans = LocalDate.parse(transaccObj.getFecha_transac(), formato);
		LocalDateTime hoy = LocalDateTime.now();
		int fDia = fecha_trans.getDayOfMonth();
		int fMes = fecha_trans.getMonthValue();
		if(fDia >= hoy.getDayOfMonth() - 1 && fMes == hoy.getMonthValue()) {
			transaccObj.setEstado_transac(false);
			int saldo_act = transaccObj.getTarj().getSaldo();
			transaccObj.getTarj().setSaldo(saldo_act + transaccObj.getMonto_transac());
		}
		else JOptionPane.showMessageDialog(null, "La Transacción no puede ser anulada !!");
		transaccObj = transaccServ.saveTransacc(transacc);
		return transaccObj;
	}
}
