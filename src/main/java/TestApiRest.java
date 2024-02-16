import java.util.List;
import java.util.Random;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bankinc.model.Tarjeta;
import com.bankinc.rest.TarjetaRest;

import jakarta.validation.constraints.AssertTrue;
import junit.framework.TestCase;

public class TestApiRest extends TestCase {

	private TarjetaRest tarjetaRest;
	
	public void escenario() {
		tarjetaRest = new TarjetaRest();
	}
	
	private void testGuardar() {
		escenario();
		//assertTrue(tarjetaRest.listar(findAll()));
	}
	
	private Object testFindAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public void testListar() {
		escenario();
		//assertTrue(tarjetaRest.listar(findAll()));
	}
	
	public void testActualizar() {
		escenario();
		//assert.assertNotNull(tarjetaRest);
	}
	
	public void testEliminar() {
		;
	}
	
	public void testNumber() {
		;
	}
	
	public void testEnroll() {
		;
	}
	
	public void testDelete() {
		;
	}
	
	public void testBalance() {
		;
	}
	
	public void testRecarga() {
		;
	}
}
