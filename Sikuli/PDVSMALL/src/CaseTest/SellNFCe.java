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

public class SellNFCe {
	
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
		item.FormPaymentNFCe("A","990,00");
		Assert.assertNotNull(item.ConfirmReturnSefaz());
		Assert.assertNotNull(item.ConfirmPrinting());
		extrato.ExtactCFE("Detalhado");
		Assert.assertNotNull(item.ConfirmIssueSuccess());
	}
	
	@Test
	public void VenderItemAcimaDezMilReais() throws SikuliException, InterruptedException {
		item.PluItens("00001");
		item.QuantityItens(1000);
		item.Identification("64048414000173");
		item.Pay();
		item.FormPaymentNFCe("A","10000,00");
		Assert.assertNotNull(item.ConfirmReturnSefaz());
		Assert.assertNotNull(item.ConfirmPrinting());
		extrato.ExtactCFE("Detalhado");
		Assert.assertNotNull(item.ConfirmIssueSuccess());
	}
	
	@Test
	public void VenderItemComTroco() throws SikuliException, InterruptedException {
		item.PluItens("00001");
		item.QuantityItens(99);
		item.Identification("64048414000173");
		item.Pay();
		item.FormPaymentNFCe("A","1000,00");
		Assert.assertNotNull(item.ConfirmReturnSefaz());
		Assert.assertNotNull(item.ConfirmPrinting());
		extrato.ExtactCFE("Detalhado");
		Assert.assertNotNull(item.ConfirmIssueSuccess());
	}
	
	@Test
	public void VenderItemSemIdentificacao() throws SikuliException, InterruptedException {
		item.PluItens("00001");
		item.QuantityItens(99);
		item.NoIdentification();
		item.Pay();
		item.FormPaymentNFCe("A","1000,00");
		Assert.assertNotNull(item.ConfirmReturnSefaz());
		Assert.assertNotNull(item.ConfirmPrinting());
		extrato.ExtactCFE("Detalhado");
		Assert.assertNotNull(item.ConfirmIssueSuccess());
	}
	
	@Test
	public void VenderMultiplosItem() throws SikuliException, InterruptedException {
		item.PluItens("00001");
		item.QuantityItens(1);
		item.Identification("64048414000173");
		item.PluItens("00003");
		item.QuantityItens(2);
		item.PluItens("00005");
		item.QuantityItens(3);
		item.PluItens("00006");
		item.QuantityItens(4);
		item.PluItens("00009");
		item.QuantityItens(5);
		item.Pay();
		item.FormPaymentNFCe("A","70,35");
		Assert.assertNotNull(item.ConfirmReturnSefaz());
		Assert.assertNotNull(item.ConfirmPrinting());
		extrato.ExtactCFE("Detalhado");
		Assert.assertNotNull(item.ConfirmIssueSuccess());
	}

	@Test
	public void VenderItemGrupoICMS() throws SikuliException, InterruptedException {
		item.PluItens("00001");
		item.QuantityItens(1);
		item.Identification("64048414000173");
		item.PluItens("00003");
		item.QuantityItens(2);
		item.PluItens("00005");
		item.QuantityItens(3);
		item.PluItens("00006");
		item.QuantityItens(4);
		item.PluItens("00009");
		item.QuantityItens(5);
		item.Pay();
		item.FormPaymentNFCe("A","70,35");
		Assert.assertNotNull(item.ConfirmReturnSefaz());
		Assert.assertNotNull(item.ConfirmPrinting());
		extrato.ExtactCFE("Detalhado");
		Assert.assertNotNull(item.ConfirmIssueSuccess());
	}

	/*@Test
	public void VenderItemGrupoCSOSN() throws SikuliException, InterruptedException {
		item.PluItens("00013");
		item.QuantityItens(1);
		item.Identification("64048414000173");
		item.PluItens("00014");
		item.QuantityItens(2);
		item.PluItens("00015");
		item.QuantityItens(3);
		item.Pay();
		item.FormPaymentNFCe("A","990,00");
		Assert.assertNotNull(item.ConfirmReturnSefaz());
		Assert.assertNotNull(item.ConfirmPrinting());
		extrato.ExtactCFE("Detalhado");
		Assert.assertNotNull(item.ConfirmIssueSuccess());
	}*/
	
	@Test
	public void VenderComCancelamentoItem() throws SikuliException, InterruptedException {
		item.PluItens("00001");
		item.QuantityItens(5);
		item.Identification("64048414000173");
		item.PluItens("00001");
		item.QuantityItens(1);
		item.CancelPluItens("00001");
		item.Pay();
		item.FormPaymentNFCe("A","50,00");
		Assert.assertNotNull(item.ConfirmReturnSefaz());
		Assert.assertNotNull(item.ConfirmPrinting());
		extrato.ExtactCFE("Detalhado");
		Assert.assertNotNull(item.ConfirmIssueSuccess());
	}
	
	@Test
	public void VenderItemForadoEstado() throws SikuliException, InterruptedException {
		item.PluItens("00001");
		item.QuantityItens(12);
		item.Identification("18443820870");
		item.Pay();
		item.FormPaymentNFCe("A","120,00");
		Assert.assertNotNull(item.ConfirmReturnSefaz());
		Assert.assertNotNull(item.ConfirmIssueFailure());
	}
	
	@Test
	public void VenderItemAcrescimoPercent() throws SikuliException{
		item.PluItens("00001");
		item.ExtraDiscountItens("acresc", "percent", "1");
		item.QuantityItens(1);
		item.Identification1("64048414000173");
		item.Pay();
		item.FormPaymentNFCe("A", "10,10");
		Assert.assertNotNull(item.ConfirmReturnSefaz());
		Assert.assertNotNull(item.ConfirmPrinting());
		extrato.ExtactCFE("Detalhado");
		Assert.assertNotNull(item.ConfirmIssueSuccess());
	}
	
	@Test
	public void VenderItemAcrescimoMonetary() throws SikuliException{
		item.PluItens("00001");
		item.ExtraDiscountItens("acresc", "monetary", "1,00");
		item.QuantityItens(1);
		item.Identification1("64048414000173");
		item.Pay();
		item.FormPaymentNFCe("A", "11,00");
		Assert.assertNotNull(item.ConfirmReturnSefaz());
		Assert.assertNotNull(item.ConfirmPrinting());
		extrato.ExtactCFE("Detalhado");
		Assert.assertNotNull(item.ConfirmIssueSuccess());
	}
	
	@Test
	public void VenderItemAcrescimoSubTotal() throws SikuliException{
		item.PluItens("00001");
		item.QuantityItens(1);
		item.Identification1("64048414000173");
		item.Pay();
		item.ExtraDiscountSubTotal("acresc", "0,10");
		item.FormPaymentNFCe("A", "10,10");
		Assert.assertNotNull(item.ConfirmReturnSefaz());
		Assert.assertNotNull(item.ConfirmPrinting());
		extrato.ExtactCFE("Detalhado");
		Assert.assertNotNull(item.ConfirmIssueSuccess());
	}
	
	@Test
	public void VenderItemDescontoPercent() throws SikuliException{
		item.PluItens("00001");
		item.ExtraDiscountItens("desc", "percent", "1");
		item.QuantityItens(1);
		item.Identification1("64048414000173");
		item.Pay();
		item.FormPaymentNFCe("A", "9,00");
		Assert.assertNotNull(item.ConfirmReturnSefaz());
		Assert.assertNotNull(item.ConfirmPrinting());
		extrato.ExtactCFE("Detalhado");
		Assert.assertNotNull(item.ConfirmIssueSuccess());
	}
	
	@Test
	public void VenderItemDescontoMonetary() throws SikuliException{
		item.PluItens("00001");
		item.ExtraDiscountItens("desc", "monetary", "1,00");
		item.QuantityItens(1);
		item.Identification1("64048414000173");
		item.Pay();
		item.FormPaymentNFCe("A", "9,90");
		Assert.assertNotNull(item.ConfirmReturnSefaz());
		Assert.assertNotNull(item.ConfirmPrinting());
		extrato.ExtactCFE("Detalhado");
		Assert.assertNotNull(item.ConfirmIssueSuccess());
	}
	
	@Test
	public void VenderItemDescontoSubTotal() throws SikuliException{
		item.PluItens("00001");
		item.QuantityItens(1);
		item.Identification1("64048414000173");
		item.Pay();
		item.ExtraDiscountSubTotal("desc", "0,10");
		item.FormPaymentNFCe("A", "9,90");
		Assert.assertNotNull(item.ConfirmReturnSefaz());
		Assert.assertNotNull(item.ConfirmPrinting());
		extrato.ExtactCFE("Detalhado");
	}
}
