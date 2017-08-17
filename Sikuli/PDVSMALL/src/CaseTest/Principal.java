package CaseTest;

import org.junit.Test;
import org.sikuli.script.FindFailed;

import Object.RegistrodoPAF;

public class Principal {

	@Test
	public void CenarioA() throws FindFailed {
		RegistrodoPAF a = new RegistrodoPAF();
		
		a.setDados("01072016", "31072016");
		a.setOpcaoEstoque("Parcial");
	}
	
	@Test
	public void CenarioB() throws FindFailed {
		RegistrodoPAF a = new RegistrodoPAF();
		
		a.setDados("20160701", "20160731");
	}
}
