package Object;

import org.sikuli.script.SikuliException;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Match;
import Framework.Automation;

/*******************************************************************************
 * Author: Roanldo do Carmo e-mail: ronaldo.carmo@prosoft.com.br
 * 
 * Description: Page Object Vender.
 ******************************************************************************/

public class SellItens {
	/* fields */
	private Automation fiedlplu = new Automation("Campo Produto", ".\\img\\field\\fieldPlu.png");
	//private ElementBeta fiedlcancelpluitem = new ElementBeta("", ".\\img\\fiedl\\fieldCancelPluItem.png");
	private Automation fieldqtd = new Automation("Campo Quantidade", ".\\img\\field\\fieldQuantity.png");
	private Automation fieldidentification = new Automation("Campo Identificação", ".\\img\\field\\fieldIdentification.png");
	private Automation fieldidentification1 = new Automation("Campo Identificação", ".\\img\\field\\fieldIdentification1.png");
	private Automation fieldpasswordauthorizer = new Automation("Campo senha Autorizador", ".\\img\\field\\fieldPasswordAuthorizer.png");
	private Automation fieldpasswordfinancial = new Automation("Campo senha Autorizador", ".\\img\\field\\fieldPasswordFinancial.png");
	private Automation fieldvaluepayment = new Automation("Campo Valor pago", ".\\img\\field\\fieldValuePayment.png");
	private Automation filedextdiscountpercent = new Automation("Campo Percentual", ".\\img\\field\\fieldExtDiscPercent.png");
	private Automation filedextdiscountmonetary = new Automation("Campo Monetário", ".\\img\\field\\fieldExtDiscMonetary.png");
	private Automation fieldExtrDiscountSubTotal = new Automation("Campo Acrs/DescontoSubtotal", ".\\img\\field\\fieldExtrDiscountSubTotal.png"); 

	/* buttons */
	private Automation bntsale = new Automation("BntVender", ".\\img\\bntSale.png");
	private Automation bntpayment = new Automation("BntPagamento", ".\\img\\bntPayment.png");
	private Automation bntcancelpay = new Automation("BntCancelarPagamento", ".\\img\\bntCancelPay.png");
	private Automation bntcancelsale = new Automation("BntCancelarVenda", ".\\img\\bntCancelSale.png");
	private Automation bntcancelpluitem = new Automation("BntCancelarVenda", ".\\img\\bntCancelPluItem.png");
	private Automation selectitemcancel = new Automation("Item Cancelado", ".\\img\\SelectItemCancel.png");
	private Automation bntyes = new Automation("BntSim", ".\\img\\bntYes.png");
	private Automation bntno = new Automation("BntNo", ".\\img\\bntNo.png");
	private Automation bntconfirmaddress = new Automation("BntConfirmarEndereco", ".\\img\\bntConfirmAddress.png");
	private Automation bntextradiscount = new Automation("BntAcresDesconto", ".\\img\\bntExtraDiscount.png");
	private Automation bntextra = new Automation("Bnt Acréscimo", ".\\img\\bntExtra.png");
	private Automation bntdiscount = new Automation("Bnt Desconto", ".\\img\\bntDiscount.png");
	private Automation bntconfirmextrdiscount = new Automation("Bnt Confirma Acres/Desc", ".\\img\\bntConfirmExtrDiscount.png");
	private Automation bntvoltar = new Automation("ProximaVenda", ".\\img\\bntCancelSaleCurrent.png");
	private Automation bntok = new Automation("ProximaVenda", ".\\img\\bntOK.png");

	/* buttons Payment */
	private Automation bntmoney = new Automation("", ".\\img\\paymentform\\bntMoney.png");
	private Automation bntbankcheck = new Automation("", ".\\img\\paymentform\\bntBankCheck.png");
	private Automation bntcardcred = new Automation("", ".\\img\\paymentform\\bntCardCred.png");
	private Automation bntcarddeb = new Automation("", ".\\img\\paymentform\\bntCardDeb.png");
	private Automation bntfoodstamps = new Automation("", ".\\img\\paymentform\\bntFoodStamps.png");
	private Automation bntcardcredstore = new Automation("", ".\\img\\paymentform\\bntCardCredStore.png");
	private Automation bntmealticket = new Automation("", ".\\img\\paymentform\\bntMealTicket.png");
	private Automation bntgiftvoucher = new Automation("", ".\\img\\paymentform\\bntGiftVoucher.png");
	private Automation bntfuelworth = new Automation("", ".\\img\\paymentform\\bntFuelWorth.png");
	private Automation bntotherpayments = new Automation("", ".\\img\\paymentform\\bntOtherPayments.png");
	private Automation bntcancelsalecurrent = new Automation("", ".\\img\\paymentform\\bntCancelSaleCurrent.png");
	private Automation payandgo = new Automation("Pay&Go", ".\\img\\paymentform\\PayAndGo.png");
	private Automation confirmreturnsefaz = new Automation("Aguardando Retorno Seafza!", ".\\img\\ConfirmReturnSefaz.png");
	private Automation confirmprinting = new Automation("Confirmar Impressão!", ".\\img\\ConfirmPrinting.png");
	private Automation confirmissuesuccess = new Automation("Confirmar Emissão!", ".\\img\\ConfirmIssueSuccess.png");
	private Automation confirmissuefailure = new Automation("Confirmar Falha de Emissão!", ".\\img\\ConfirmIssueFailure.png");

	public void Sale() throws SikuliException {
		bntsale.Click();
	}
	
	public void nextSale() throws SikuliException {
		bntvoltar.Click();
	}

	public void PluItens(String x) throws SikuliException {
		fiedlplu.Key(x + Key.ENTER);
	}

	public void ExtraDiscountItens(String x, String type, String value) throws SikuliException {
		switch (x) {
		case "acresc":
			bntextradiscount.Click();
			bntextra.Click();
			if (type == "percent"){
				filedextdiscountpercent.TypeText(value + Key.ENTER);
				bntconfirmextrdiscount.Click();
			}
			else {
				filedextdiscountmonetary.TypeText(value + Key.ENTER);
				bntconfirmextrdiscount.Click();
			}
			break;
		
		case "desc":
			bntextradiscount.Click();
			bntextra.Click();
			bntdiscount.Click();
			if (type == "monetary"){
				filedextdiscountpercent.TypeText(value + Key.ENTER);
				bntconfirmextrdiscount.Click();
			}
			else {
				filedextdiscountmonetary.TypeText(value + Key.ENTER);
				bntconfirmextrdiscount.Click();
			}
			break;
		}
	}
	
	public void QuantityItens(int x) throws SikuliException {
		fieldqtd.Key(Key.BACKSPACE + x + Key.ENTER);
	}
	
	public void DeliveryDomucilio(String x) throws SikuliException {
		switch (x) {
		case "yes":
			bntyes.Click();
			break;

		case "no":
			bntno.Click();
			break;
		}
	}
	
	public void DeliveryDomucilioAuthorizer(String x) throws SikuliException {
		switch (x) {
		case "yes":
			bntyes.Click();
			fieldpasswordauthorizer.Key("9632" + Key.ENTER);
			break;

		case "no":
			bntno.Click();
			break;
		}
	}

	public void Identification(String x) {
		fieldidentification.Key(x + Key.ENTER);
	}
	public void NoIdentification() {
		fieldidentification.Key(Key.ENTER);
	}
	
	public void Identification1(String x) {
		fieldidentification1.Key(x + Key.ENTER);
	}
	
	public void SelectAddress() throws SikuliException{
		bntconfirmaddress.Click();
	}

	public void Pay() throws SikuliException {
		bntpayment.Click();
	}
	
	public void ExtraDiscountSubTotal(String x, String value) throws SikuliException {
		switch (x) {
		case "acresc":
			fieldExtrDiscountSubTotal.Key("+" + value + Key.ENTER);
			break;
		
		case "desc":
			fieldExtrDiscountSubTotal.Key("-" + value + Key.ENTER);
			break;
		}
	}
	
	public void ExtraDiscountSubTotalAuthorizer(String x, String value) throws SikuliException {
		switch (x) {
		case "acresc":
			fieldExtrDiscountSubTotal.Key("+" + value + Key.ENTER);
			bntyes.Click();
			fieldpasswordfinancial.Key("9632" + Key.ENTER);
			break;
		
		case "desc":
			fieldExtrDiscountSubTotal.Key("-" + value + Key.ENTER);
			bntyes.Click();
			fieldpasswordfinancial.Key("9632" + Key.ENTER);
			break;
		}
	}

	public void FormPaymentPaf(String Payment, String value) throws SikuliException {
		switch (Payment) {
		case "A":
			bntmoney.Click();
			fieldvaluepayment.Key(Key.BACKSPACE + value + Key.ENTER);
			break;

		case "B":
			bntbankcheck.Click();
			fieldvaluepayment.Key(Key.BACKSPACE + value + Key.ENTER + Key.ENTER);
			break;

		case "C":
			bntcardcred.Click();
			fieldvaluepayment.Key(Key.BACKSPACE + value + Key.ENTER + Key.ENTER);
			payandgo.Key("01" + Key.ENTER);
			payandgo.Key("5400221034682511"+ Key.ENTER);
			payandgo.Key("20"+ Key.ENTER);
			break;

		case "D":
			bntcarddeb.Click();
			fieldvaluepayment.Key(Key.BACKSPACE + value + Key.ENTER + Key.ENTER);
			payandgo.Key("01" + Key.ENTER);
			payandgo.Key("5400221034682511"+ Key.ENTER);
			payandgo.Key("20"+ Key.ENTER);
			break;

		case "E":
			bntcardcredstore.Click();
			fieldvaluepayment.Key(Key.BACKSPACE + value + Key.ENTER + Key.ENTER);
			break;

		case "F":
			bntfoodstamps.Click();
			fieldvaluepayment.Key(Key.BACKSPACE + value + Key.ENTER + Key.ENTER);
			payandgo.Key("01" + Key.ENTER);
			payandgo.Key("5400221034682511"+ Key.ENTER);
			payandgo.Key("20"+ Key.ENTER);
			break;

		case "G":
			bntmealticket.Click();
			fieldvaluepayment.Key(Key.BACKSPACE + value + Key.ENTER + Key.ENTER);
			payandgo.Key("01" + Key.ENTER);
			payandgo.Key("5400221034682511"+ Key.ENTER);
			payandgo.Key("20"+ Key.ENTER);
			break;

		case "H":
			bntgiftvoucher.Click();
			fieldvaluepayment.Key(Key.BACKSPACE + value + Key.ENTER + Key.ENTER);
			payandgo.Key("01" + Key.ENTER);
			payandgo.Key("5400221034682511"+ Key.ENTER);
			payandgo.Key("20"+ Key.ENTER);
			break;

		case "I":
			bntfuelworth.Click();
			fieldvaluepayment.Key(Key.BACKSPACE + value + Key.ENTER + Key.ENTER);
			payandgo.Key("01" + Key.ENTER);
			payandgo.Key("5400221034682511"+ Key.ENTER);
			payandgo.Key("20"+ Key.ENTER);
			break;

		case "J":
			bntotherpayments.Click();
			fieldvaluepayment.Key(Key.BACKSPACE + value + Key.ENTER + Key.ENTER);
			payandgo.Key("01" + Key.ENTER);
			payandgo.Key("5400221034682511"+ Key.ENTER);
			payandgo.Key("20"+ Key.ENTER);
			break;
		}
	}
	
	public void FormPaymentSat(String Payment, String value) throws SikuliException {
		switch (Payment) {
		case "A":
			bntmoney.Click();
			fieldvaluepayment.Key(Key.BACKSPACE + value + Key.ENTER);
			break;

		case "B":
			bntbankcheck.Click();
			fieldvaluepayment.Key(Key.BACKSPACE + value + Key.ENTER + Key.ENTER);
			break;

		case "C":
			bntcardcred.Click();
			fieldvaluepayment.Key(Key.BACKSPACE + value + Key.ENTER + Key.ENTER);
			payandgo.Key("01" + Key.ENTER);
			payandgo.Key("5400221034682511"+ Key.ENTER);
			payandgo.Key("20"+ Key.ENTER);
			break;

		case "D":
			bntcarddeb.Click();
			fieldvaluepayment.Key(Key.BACKSPACE + value + Key.ENTER + Key.ENTER);
			payandgo.Key("01" + Key.ENTER);
			payandgo.Key("5400221034682511"+ Key.ENTER);
			payandgo.Key("20"+ Key.ENTER);
			break;

		case "E":
			bntcardcredstore.Click();
			fieldvaluepayment.Key(Key.BACKSPACE + value + Key.ENTER + Key.ENTER);
			break;

		case "F":
			bntfoodstamps.Click();
			fieldvaluepayment.Key(Key.BACKSPACE + value + Key.ENTER + Key.ENTER);
			payandgo.Key("01" + Key.ENTER);
			payandgo.Key("5400221034682511"+ Key.ENTER);
			payandgo.Key("20"+ Key.ENTER);
			break;

		case "G":
			bntmealticket.Click();
			fieldvaluepayment.Key(Key.BACKSPACE + value + Key.ENTER + Key.ENTER);
			payandgo.Key("01" + Key.ENTER);
			payandgo.Key("5400221034682511"+ Key.ENTER);
			payandgo.Key("20"+ Key.ENTER);
			break;

		case "H":
			bntgiftvoucher.Click();
			fieldvaluepayment.Key(Key.BACKSPACE + value + Key.ENTER + Key.ENTER);
			payandgo.Key("01" + Key.ENTER);
			payandgo.Key("5400221034682511"+ Key.ENTER);
			payandgo.Key("20"+ Key.ENTER);
			break;

		case "I":
			bntfuelworth.Click();
			fieldvaluepayment.Key(Key.BACKSPACE + value + Key.ENTER + Key.ENTER);
			payandgo.Key("01" + Key.ENTER);
			payandgo.Key("5400221034682511"+ Key.ENTER);
			payandgo.Key("20"+ Key.ENTER);
			break;

		case "J":
			bntotherpayments.Click();
			fieldvaluepayment.Key(Key.BACKSPACE + value + Key.ENTER + Key.ENTER);
			payandgo.Key("01" + Key.ENTER);
			payandgo.Key("5400221034682511"+ Key.ENTER);
			payandgo.Key("20"+ Key.ENTER);
			break;
		}
	}
	
	public void FormPaymentNFCe(String Payment, String value) throws SikuliException {
		switch (Payment) {
		case "A":
			bntmoney.Click();
			fieldvaluepayment.Key(Key.BACKSPACE + value + Key.ENTER);
			break;

		case "B":
			bntbankcheck.Click();
			fieldvaluepayment.Key(Key.BACKSPACE + value + Key.ENTER + Key.ENTER);
			break;

		case "C":
			bntcardcred.Click();
			fieldvaluepayment.Key(Key.BACKSPACE + value + Key.ENTER + Key.ENTER);
			payandgo.Key("01" + Key.ENTER);
			payandgo.Key("5400221034682511"+ Key.ENTER);
			payandgo.Key("20"+ Key.ENTER);
			break;

		case "D":
			bntcarddeb.Click();
			fieldvaluepayment.Key(Key.BACKSPACE + value + Key.ENTER + Key.ENTER);
			payandgo.Key("01" + Key.ENTER);
			payandgo.Key("5400221034682511"+ Key.ENTER);
			payandgo.Key("20"+ Key.ENTER);
			break;

		case "E":
			bntcardcredstore.Click();
			fieldvaluepayment.Key(Key.BACKSPACE + value + Key.ENTER + Key.ENTER);
			break;

		case "F":
			bntfoodstamps.Click();
			fieldvaluepayment.Key(Key.BACKSPACE + value + Key.ENTER + Key.ENTER);
			payandgo.Key("01" + Key.ENTER);
			payandgo.Key("5400221034682511"+ Key.ENTER);
			payandgo.Key("20"+ Key.ENTER);
			break;

		case "G":
			bntmealticket.Click();
			fieldvaluepayment.Key(Key.BACKSPACE + value + Key.ENTER + Key.ENTER);
			payandgo.Key("01" + Key.ENTER);
			payandgo.Key("5400221034682511"+ Key.ENTER);
			payandgo.Key("20"+ Key.ENTER);
			break;

		case "H":
			bntgiftvoucher.Click();
			fieldvaluepayment.Key(Key.BACKSPACE + value + Key.ENTER + Key.ENTER);
			payandgo.Key("01" + Key.ENTER);
			payandgo.Key("5400221034682511"+ Key.ENTER);
			payandgo.Key("20"+ Key.ENTER);
			break;

		case "I":
			bntfuelworth.Click();
			fieldvaluepayment.Key(Key.BACKSPACE + value + Key.ENTER + Key.ENTER);
			payandgo.Key("01" + Key.ENTER);
			payandgo.Key("5400221034682511"+ Key.ENTER);
			payandgo.Key("20"+ Key.ENTER);
			break;

		case "J":
			bntotherpayments.Click();
			fieldvaluepayment.Key(Key.BACKSPACE + value + Key.ENTER + Key.ENTER);
			payandgo.Key("01" + Key.ENTER);
			payandgo.Key("5400221034682511"+ Key.ENTER);
			payandgo.Key("20"+ Key.ENTER);
			break;
		}
	}

	public Match ConfirmReturnSefaz() throws FindFailed {
		return confirmreturnsefaz.WaitProcess();
	}
	
	public Match ConfirmPrinting() throws FindFailed {
		return confirmprinting.WaitProcess();
	}
	
	public Match ConfirmIssueSuccess() throws FindFailed {
		return confirmissuesuccess.WaitProcess();
	}
	
	public Match ConfirmIssueFailure() throws FindFailed {
		return confirmissuefailure.WaitProcess();
	}
	
	/***************************************************************************************************
	 * Cancelamento de Itens e Vendas
	 ***************************************************************************************************/
	public void CancelPluItens(String x) throws SikuliException {
		bntcancelpluitem.Click();
		selectitemcancel.Click();
		bntok.Click();
	}

	public void CancelPay() throws SikuliException {
		bntcancelpay.Click();
	}

	public void ConfirmCancelSale(String x) throws SikuliException {
		switch (x) {
		case "yes":
			bntyes.Click();
			fieldpasswordauthorizer.Key("9632" + Key.ENTER);
			break;

		case "no":
			bntno.Click();
			break;
		}
	}
	
	public void CancelSale() throws SikuliException {
		bntcancelsale.Click();
	}

	public void CancelSaleCurrent() throws SikuliException {
		bntcancelsalecurrent.Click();
	}
}