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

public class SellSAT {
	
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
	public void VenderItemDentrodoEstado() throws SikuliException, InterruptedException {
		item.PluItens("00001");
		item.QuantityItens(99);
		item.Identification("64048414000173");
		item.Pay();
		item.FormPaymentSat("A","990,00");
		Assert.assertNotNull(item.ConfirmPrinting());
		extrato.ExtactCFE("Detalhado");
	}

	@Test
	public void VenderItemForadoEstado() throws SikuliException, InterruptedException {
		item.PluItens("00001");
		item.QuantityItens(12);
		item.Identification("18443820870");
		item.Pay();
		item.FormPaymentSat("A","120,00");
		Assert.assertNotNull(item.ConfirmPrinting());
		extrato.ExtactCFE("Detalhado");
	}
	
	@Test
	public void VenderItemAcrescimoPercent() throws SikuliException{
		item.PluItens("00001");
		item.ExtraDiscountItens("acresc", "percent", "1");
		item.QuantityItens(1);
		item.Identification1("64048414000173");
		item.Pay();
		item.FormPaymentSat("A", "10,10");
		Assert.assertNotNull(item.ConfirmPrinting());
		extrato.ExtactCFE("Detalhado");
	}
	
	@Test
	public void VenderItemAcrescimoMonetary() throws SikuliException{
		item.PluItens("00001");
		item.ExtraDiscountItens("acresc", "monetary", "1,00");
		item.QuantityItens(1);
		item.Identification1("64048414000173");
		item.Pay();
		item.FormPaymentSat("A", "11,00");
		Assert.assertNotNull(item.ConfirmPrinting());
		extrato.ExtactCFE("Detalhado");
	}
	
	@Test
	public void VenderItemDescontoPercent() throws SikuliException{
		item.PluItens("00001");
		item.ExtraDiscountItens("desc", "percent", "1");
		item.QuantityItens(1);
		item.Identification1("64048414000173");
		item.Pay();
		item.FormPaymentSat("A", "9,00");
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
		item.FormPaymentSat("A", "9,90");
		Assert.assertNotNull(item.ConfirmPrinting());
		extrato.ExtactCFE("Detalhado");
	}
	
	@Test
	public void VenderItemAcrescimoSubTotal() throws SikuliException{
		item.PluItens("00001");
		item.QuantityItens(1);
		item.Identification1("64048414000173");
		item.Pay();
		item.ExtraDiscountSubTotal("acresc", "0,10");
		item.FormPaymentSat("A", "10,10");
		Assert.assertNotNull(item.ConfirmPrinting());
		extrato.ExtactCFE("Detalhado");
	}
	
	@Test
	public void VenderItemDescontoSubTotal() throws SikuliException{
		item.PluItens("00001");
		item.QuantityItens(1);
		item.Identification1("64048414000173");
		item.Pay();
		item.ExtraDiscountSubTotal("desc", "0,10");
		item.FormPaymentSat("A", "9,90");
		Assert.assertNotNull(item.ConfirmPrinting());
		extrato.ExtactCFE("Detalhado");
	}
}
