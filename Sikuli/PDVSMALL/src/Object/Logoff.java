package Object;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Match;
import org.sikuli.script.SikuliException;
import Framework.*;

/*******************************************************************************
 * Author: Roanldo do Carmo e-mail: ronaldo.carmo@prosoft.com.br
 * 
 * Description: Automação da Operação de LogOff.
 ******************************************************************************/

public class Logoff {

	private Automation bntexit = new Automation("Sair", ".\\img\\bntExit.png");
	private Automation bntyes = new Automation("Confimar", ".\\img\\bntYes.png");
	private Automation bntno = new Automation("Não Confirma", ".\\img\\bntNo.png");

	public void ClickExit() throws SikuliException {
		bntexit.Click();
	}

	public void ClickYes() throws SikuliException {
		bntyes.Click();
	}

	public void ClickNo() throws SikuliException {
		bntno.Click();
	}
	
	public Match ConfirmLogoff() throws FindFailed {
		return bntyes.WaitProcess();
	}
}
