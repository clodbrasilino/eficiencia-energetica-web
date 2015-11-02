package br.edu.ifpi.see.request;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.edu.ifpi.see.model.Status;

public class GeneratedStatusTest {
	
	private GeneratedStatus gs;
	
	private static final String VERIFIQUE = "Verifique!";
	private static final String SEM_CONSUMO = "Sem consumo";
	private static final String DESPERDICO = "Desperdício";
	private static final String SALA_LIVRE = "Sala livre";
	private static final String CONSUMO_NORMAL = "Consumo normal";
	
	@Before
	public void init(){
		this.gs = new GeneratedStatus();
	}
	
	@Test
	public void testGeraStatus(){
		// -1
		assertEquals(VERIFIQUE, this.gs.geraStatus(-1, -1, -1, -1).getDescricao());
		assertEquals(VERIFIQUE, this.gs.geraStatus(-1, -1, -1, 0).getDescricao());
		assertEquals(VERIFIQUE, this.gs.geraStatus(-1, -1, -1, 1).getDescricao());
		
		assertEquals(VERIFIQUE, this.gs.geraStatus(-1, -1, 0, -1).getDescricao());
		assertEquals(SEM_CONSUMO, this.gs.geraStatus(-1, -1, 0, 0).getDescricao());
		assertEquals(VERIFIQUE, this.gs.geraStatus(-1, -1, 0, 1).getDescricao());
		
		assertEquals(VERIFIQUE, this.gs.geraStatus(-1, -1, 1, -1).getDescricao());
		assertEquals(VERIFIQUE, this.gs.geraStatus(-1, -1, 1, 0).getDescricao());
		assertEquals(VERIFIQUE, this.gs.geraStatus(-1, -1, 1, 1).getDescricao());
		
		assertEquals(VERIFIQUE, this.gs.geraStatus(-1, 0, -1, -1).getDescricao());
		assertEquals(VERIFIQUE, this.gs.geraStatus(-1, 0, -1, 0).getDescricao());
		assertEquals(DESPERDICO, this.gs.geraStatus(-1, 0, -1, 1).getDescricao());
		
		assertEquals(VERIFIQUE, this.gs.geraStatus(-1, 0, 0, -1).getDescricao());
		assertEquals(SALA_LIVRE, this.gs.geraStatus(-1, 0, 0, 0).getDescricao());
		assertEquals(DESPERDICO, this.gs.geraStatus(-1, 0, 0, 1).getDescricao());
		
		assertEquals(DESPERDICO, this.gs.geraStatus(-1, 0, 1, -1).getDescricao());
		assertEquals(DESPERDICO, this.gs.geraStatus(-1, 0, 1, 0).getDescricao());
		assertEquals(DESPERDICO, this.gs.geraStatus(-1, 0, 1, 1).getDescricao());
		
		assertEquals(VERIFIQUE, this.gs.geraStatus(-1, 1, -1, -1).getDescricao());
		assertEquals(VERIFIQUE, this.gs.geraStatus(-1, 1, -1, 0).getDescricao());
		assertEquals(VERIFIQUE, this.gs.geraStatus(-1, 1, -1, 1).getDescricao());
		
		assertEquals(VERIFIQUE, this.gs.geraStatus(-1, 1, 0, -1).getDescricao());
		assertEquals(SEM_CONSUMO, this.gs.geraStatus(-1, 1, 0, 0).getDescricao());
		assertEquals(VERIFIQUE, this.gs.geraStatus(-1, 1, 0, 1).getDescricao());
		
		assertEquals(VERIFIQUE, this.gs.geraStatus(-1, 1, 1, -1).getDescricao());
		assertEquals(CONSUMO_NORMAL, this.gs.geraStatus(-1, 1, 1, 0).getDescricao());
		assertEquals(VERIFIQUE, this.gs.geraStatus(-1, 1, 1, 1).getDescricao());
		
		
		// 0
		assertEquals(VERIFIQUE, this.gs.geraStatus(0, -1, -1, -1).getDescricao());
		assertEquals(VERIFIQUE, this.gs.geraStatus(0, -1, -1, 0).getDescricao());
		assertEquals(DESPERDICO, this.gs.geraStatus(0, -1, -1, 1).getDescricao());
		
		assertEquals(VERIFIQUE, this.gs.geraStatus(0, -1, 0, -1).getDescricao());
		assertEquals(SEM_CONSUMO, this.gs.geraStatus(0, -1, 0, 0).getDescricao());
		assertEquals(DESPERDICO, this.gs.geraStatus(0, -1, 0, 1).getDescricao());
		
		assertEquals(VERIFIQUE, this.gs.geraStatus(0, -1, 1, -1).getDescricao());
		assertEquals(VERIFIQUE, this.gs.geraStatus(0, -1, 1, 0).getDescricao());
		assertEquals(DESPERDICO, this.gs.geraStatus(0, -1, 1, 1).getDescricao());
		
		assertEquals(VERIFIQUE, this.gs.geraStatus(0, 0, -1, -1).getDescricao());
		assertEquals(VERIFIQUE, this.gs.geraStatus(0, 0, -1, 0).getDescricao());
		assertEquals(DESPERDICO, this.gs.geraStatus(0, 0, -1, 1).getDescricao());
		
		assertEquals(VERIFIQUE, this.gs.geraStatus(0, 0, 0, -1).getDescricao());
		assertEquals(SALA_LIVRE, this.gs.geraStatus(0, 0, 0, 0).getDescricao());
		assertEquals(DESPERDICO, this.gs.geraStatus(0, 0, 0, 1).getDescricao());
		
		assertEquals(DESPERDICO, this.gs.geraStatus(0, 0, 1, -1).getDescricao());
		assertEquals(DESPERDICO, this.gs.geraStatus(0, 0, 1, 0).getDescricao());
		assertEquals(DESPERDICO, this.gs.geraStatus(0, 0, 1, 1).getDescricao());
		
		assertEquals(VERIFIQUE, this.gs.geraStatus(0, 1, -1, -1).getDescricao());
		assertEquals(VERIFIQUE, this.gs.geraStatus(0, 1, -1, 0).getDescricao());
		assertEquals(DESPERDICO, this.gs.geraStatus(0, 1, -1, 1).getDescricao());
		
		assertEquals(VERIFIQUE, this.gs.geraStatus(0, 1, 0, -1).getDescricao());
		assertEquals(SEM_CONSUMO, this.gs.geraStatus(0, 1, 0, 0).getDescricao());
		assertEquals(DESPERDICO, this.gs.geraStatus(0, 1, 0, 1).getDescricao());
		
		assertEquals(VERIFIQUE, this.gs.geraStatus(0, 1, 1, -1).getDescricao());
		assertEquals(CONSUMO_NORMAL, this.gs.geraStatus(0, 1, 1, 0).getDescricao());
		assertEquals(DESPERDICO, this.gs.geraStatus(0, 1, 1, 1).getDescricao());
		
		// 1
		assertEquals(VERIFIQUE, this.gs.geraStatus(1, -1, -1, -1).getDescricao());
		assertEquals(VERIFIQUE, this.gs.geraStatus(1, -1, -1, 0).getDescricao());
		assertEquals(VERIFIQUE, this.gs.geraStatus(1, -1, -1, 1).getDescricao());
		
		assertEquals(VERIFIQUE, this.gs.geraStatus(1, -1, 0, -1).getDescricao());
		assertEquals(SEM_CONSUMO, this.gs.geraStatus(1, -1, 0, 0).getDescricao());
		assertEquals(VERIFIQUE, this.gs.geraStatus(1, -1, 0, 1).getDescricao());
		
		assertEquals(VERIFIQUE, this.gs.geraStatus(1, -1, 1, -1).getDescricao());
		assertEquals(VERIFIQUE, this.gs.geraStatus(1, -1, 1, 0).getDescricao());
		assertEquals(VERIFIQUE, this.gs.geraStatus(1, -1, 1, 1).getDescricao());
		
		assertEquals(VERIFIQUE, this.gs.geraStatus(1, 0, -1, -1).getDescricao());
		assertEquals(VERIFIQUE, this.gs.geraStatus(1, 0, -1, 0).getDescricao());
		assertEquals(DESPERDICO, this.gs.geraStatus(1, 0, -1, 1).getDescricao());
		
		assertEquals(VERIFIQUE, this.gs.geraStatus(1, 0, 0, -1).getDescricao());
		assertEquals(SALA_LIVRE, this.gs.geraStatus(1, 0, 0, 0).getDescricao());
		assertEquals(DESPERDICO, this.gs.geraStatus(1, 0, 0, 1).getDescricao());
		
		assertEquals(DESPERDICO, this.gs.geraStatus(1, 0, 1, -1).getDescricao());
		assertEquals(DESPERDICO, this.gs.geraStatus(1, 0, 1, 0).getDescricao());
		assertEquals(DESPERDICO, this.gs.geraStatus(1, 0, 1, 1).getDescricao());
		
		assertEquals(VERIFIQUE, this.gs.geraStatus(1, 1, -1, -1).getDescricao());
		assertEquals(VERIFIQUE, this.gs.geraStatus(1, 1, -1, 0).getDescricao());
		assertEquals(CONSUMO_NORMAL, this.gs.geraStatus(1, 1, -1, 1).getDescricao());
		
		assertEquals(VERIFIQUE, this.gs.geraStatus(1, 1, 0, -1).getDescricao());
		assertEquals(SEM_CONSUMO, this.gs.geraStatus(1, 1, 0, 0).getDescricao());
		assertEquals(CONSUMO_NORMAL, this.gs.geraStatus(1, 1, 0, 1).getDescricao());
		
		assertEquals(CONSUMO_NORMAL, this.gs.geraStatus(1, 1, 1, -1).getDescricao());
		assertEquals(CONSUMO_NORMAL, this.gs.geraStatus(1, 1, 1, 0).getDescricao());
		assertEquals(CONSUMO_NORMAL, this.gs.geraStatus(1, 1, 1, 1).getDescricao());
	}
	
	@Test
	public void testGeraValor(){
		// -1
		assertEquals("-1", this.gs.geraValor(-1, -1));
		assertEquals("-1", this.gs.geraValor(-1, 0));
		assertEquals("1", this.gs.geraValor(-1, 1));
		
		// 0
		assertEquals("-1", this.gs.geraValor(0, -1));
		assertEquals("0", this.gs.geraValor(0, 0));
		assertEquals("1", this.gs.geraValor(0, 1));
		
		// 1
		assertEquals("1", this.gs.geraValor(1, -1));
		assertEquals("1", this.gs.geraValor(1, 0));
		assertEquals("1", this.gs.geraValor(1, 1));
	}
	
	@Test
	public void testGeraStatusComposto(){
		Status s = this.gs.geraStatus(Integer.parseInt(this.gs.geraValor(-1, 1)),
				Integer.parseInt(this.gs.geraValor(-1, 1)), Integer.parseInt(this.gs.geraValor(-1, 0)),
				Integer.parseInt(this.gs.geraValor(-1, 0)));
		assertEquals(VERIFIQUE, s.getDescricao());
	}

}
