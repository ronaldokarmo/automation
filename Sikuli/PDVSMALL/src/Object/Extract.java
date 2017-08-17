package Object;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Match;
import org.sikuli.script.SikuliException;
import Framework.Automation;

/*******************************************************************************
 * Author: Roanldo do Carmo e-mail: ronaldo.carmo@prosoft.com.br
 * 
 * Description: Page Object Extrato.
 ******************************************************************************/

public class Extract {

	private Automation extSimpl = new Automation("Ext Simpl", ".\\img\\bntSimplified.png");
	private Automation extDet = new Automation("Extr Detal", ".\\img\\bntDetailed.png");
	private Automation confirmlogon = new Automation("Logon!", ".\\img\\ConfirmLogon.png");

	public void ExtactCFE(String x) throws SikuliException {
		switch (x) {
		case "Detalhado":
			extDet.Click();
			break;

		case "Simplificado":
			extSimpl.Click();
			break;
		}
	}
	
	public Match ConfirmLogon() throws FindFailed {
		return confirmlogon.WaitProcess();
	}
}
