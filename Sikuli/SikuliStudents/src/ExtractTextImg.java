import org.sikuli.script.Screen;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.basics.*;

public class ExtractTextImg {

	public static void main(String[] args) throws FindFailed {
		/* Parâmetros OCR */		
		try
		{
			Settings.OcrTextRead = true;
			Settings.OcrTextSearch = true;
			
			Screen scr = new Screen();
			// Pattern bConsumidores = new Pattern(".\\img\\Consumidores1.png");
			Pattern img = new Pattern(".\\img\\teste.png");
			
			scr.exists(img);
			System.out.println("Imagem encontrada! \n");

			System.out.println("Palavra encontrada! \n" + scr.text());

			//String objecto = scr.text();
			//System.out.println("Palavra encontrada! \n" + objecto);
		}
		
		catch (Exception erro)
		{
			System.out.println("Erro: "+ erro.getMessage());
		}

		/*
		 * String palavraChave = "CONSUMIDORES"; List<String> palavras =
		 * Arrays.asList(objecto.split(" "));
		 * 
		 * if (palavras.contains(palavraChave)) {
		 * System.out.println("Palavra chave encontrada! \n" + objecto);
		 * scr.highlight().click(); }
		 */
	}
}