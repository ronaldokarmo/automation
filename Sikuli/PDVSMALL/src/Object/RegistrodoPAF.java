package Object;

import org.sikuli.script.*;

public class RegistrodoPAF {
	
	Screen scr = new Screen();
	Region reg = new Region(0,0,1600,900);

	public void setDados(String Ini, String Fim) throws FindFailed{		
		String dataini = ".\\img\\field\\fieldDataini.png";
		String datafim = ".\\img\\field\\fieldDatafim.png";		
		
		scr.exists(dataini).click();
		scr.type(Ini);
		scr.find(datafim).click();
		scr.type(Fim);
	}
	
	public void setOpcaoEstoque(String x) throws FindFailed{
		String estoquetotal = ".\\img\\field\\optionEstTotal.png";
		String estoqueparcial = ".\\img\\field\\optionEstParcial.png";
		
		if(x == "Total"){
			scr.find(estoquetotal).click();
		}
		else {
			scr.find(estoqueparcial).click();
		}
	}
}
