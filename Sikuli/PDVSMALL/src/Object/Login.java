package Object;

import org.sikuli.script.App;
import org.sikuli.script.FindFailed;
import org.sikuli.script.SikuliException;
import org.sikuli.script.Match;
import Framework.*;

/*******************************************************************************
 * Author: Ronaldo do Carmo e-mail: ronaldo.carmo@prosoft.com.br
 * 
 * Description: Page Object Log on.
 ******************************************************************************/

public class Login {

	private static String modopaf = "C:\\PDVSmall\\PDV_SMALL_620.EXE 2";
	private static String modosat = "C:\\GFCSmall\\PDV_SMALL_610.EXE 4";
	private static String modonfce = "C:\\GFCSmall\\PDV_SMALL_610.EXE 5";
	private Automation fieldnameuser = new Automation("Nome de usuário!", ".\\img\\field\\fieldNameUser.png");
	private Automation fieldpwd = new Automation("Senha!", ".\\img\\field\\fieldPassword.png");
	private Automation bntSign = new Automation("Fazer Logon!", ".\\img\\bntSign.png");
	private Automation selectemp = new Automation("Seleciona Empresa!", ".\\img\\SelectEmp.png");
	private Automation confirmlogonpaf = new Automation("Confirma Logon!", ".\\img\\ConfirmLogon-paf.png");
	//private ElementBeta confirmlogonsat = new ElementBeta("Confirma Logon!", ".\\img\\ConfirmLogon.png");
	//private ElementBeta confirmlogonnfce = new ElementBeta("Confirma Logon!", ".\\img\\ConfirmLogon.png");

	public static void AppOpen(String x) {
		switch(x) {
			case "paf":
				App.open(modopaf);
			break;
		
			case "sat":
				App.open(modosat);
			break;
			
			case "nfce":
				App.open(modonfce);
			break;
		}
	}

	public void SetNameUser(String x) throws SikuliException, InterruptedException {
		fieldnameuser.TypeClear(x);
		fieldnameuser.TypeText(x);	
	}

	public void SetPassword(String x) throws FindFailed {
		fieldpwd.TypeText(x);
	}

	public void ClickSign() throws SikuliException, InterruptedException {
		bntSign.Click();
	}

	public void SelectEmp(String x) throws FindFailed {
		selectemp.Key(x);
	}
	
	public Match ConfirmLogon() throws FindFailed {
		return confirmlogonpaf.WaitProcess();
	}
	
	public static void CloseApp() {
		App.close(modopaf);
		App.close(modosat);
		App.close(modonfce);
	}
}