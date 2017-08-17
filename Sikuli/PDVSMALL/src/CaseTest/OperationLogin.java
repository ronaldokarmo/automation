package CaseTest;

import org.junit.Before;
import org.junit.Test;
import org.sikuli.script.SikuliException;
import Object.Login;

/*******************************************************************************
 * Author: Ronaldo do Carmo e-mail: ronaldo.carmo@prosoft.com.br
 * 
 * Description: Caso Teste efetuar Logon.
 ******************************************************************************/

public class OperationLogin {

	Login login = new Login();
	
	@Before
	public void BeforcePaf() {
		Login.AppOpen("paf");
	}
	
	@Test
	public void LoginPAF() throws SikuliException, InterruptedException {
		login.SetNameUser("PAF");
		login.SetPassword("9632");
		login.ClickSign();
		/*Assert.assertNotNull(login.ConfirmLogon());
		Login.CloseApp();*/
	}
}