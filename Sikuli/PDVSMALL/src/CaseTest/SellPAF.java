package CaseTest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.sikuli.script.SikuliException;
import Object.Extract;
import Object.Login;
import Object.SellItens;

/*******************************************************************************
 * Author: Roanldo do Carmo e-mail: ronaldo.carmo@prosoft.com.br
 * 
 * Description: Case Test Efetutar Login, Vener e fazer Logoff.
 ******************************************************************************/

public class SellPAF {
	
	Login login = new Login();
	SellItens item = new SellItens();
	Extract extrato = new Extract();
	
	@Before
	public void BeforceSale() throws SikuliException {
		item.Sale();
	}
	
	@After
	public void AfterSale() throws SikuliException {
		item.nextSale();
	}
	
	@Test
	public void VenderPasso01() throws SikuliException, InterruptedException {
		item.PluItens("00018");
		item.QuantityItens(1);
		//item.Identification("64048414000173");
		item.Pay();
		item.FormPaymentPaf("B","999999,99");
		Assert.assertNotNull(item.ConfirmPrinting());
	}
	
	@Test
	public void VenderPasso2() throws SikuliException, InterruptedException {
		item.PluItens("00016");
		item.QuantityItens(1);
		item.Identification("64048414000173");
		item.Pay();
		item.FormPaymentPaf("B","1,00");
		Assert.assertNotNull(item.ConfirmPrinting());
	}
	
	@Test
	public void VenderItemAcrescimoMonetary() throws SikuliException{
		item.PluItens("00001");
		item.ExtraDiscountItens("acresc", "monetary", "1,00");
		item.QuantityItens(1);
		item.Identification1("64048414000173");
		item.Pay();
		item.FormPaymentPaf("B", "11,00");
		Assert.assertNotNull(item.ConfirmPrinting());
		extrato.ExtactCFE("Detalhado");
	}

	@Test
	public void VenderItemDescontoMonetary() throws SikuliException{
		item.PluItens("00001");
		item.ExtraDiscountItens("desc", "monetary", "1,00");
		item.QuantityItens(1);
		item.Identification1("64048414000173");
		item.Pay();
		item.FormPaymentPaf("B", "9,90");
		Assert.assertNotNull(item.ConfirmPrinting());
		extrato.ExtactCFE("Detalhado");
	}
}
