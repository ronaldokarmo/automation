package Framework;

import org.sikuli.script.Screen;
import org.sikuli.script.SikuliException;
import org.sikuli.script.Key;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;

/*******************************************************************************
 * Author: Ronaldo do Carmo e-mail: ronaldo.carmo@prosoft.com.br
 * 
 * Description: Framework Element.
 ******************************************************************************/

public class Automation {

	private String name;
	private String source;

	// Constructor
	public Automation(String _nome, String _source) {
		this.name = _nome;
		this.source = _source;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Match WaitProcess() {
		Screen screen = new Screen();
		Pattern pattner = new Pattern(source);
		int count = 0;
		int loop = 5;

		while(true) {
			count++;			
			Match waitObject = screen.exists(pattner);
			
			if (waitObject != null) {
				return waitObject;
			}
			else {
				if(count == loop)	
					break;
			}			
			try {
				Thread.sleep(1000);
				System.out.println("[log] Looking for Element... " + name);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("[log] Element Not Found! " + name);
		return null;
	}

	public void Click() throws SikuliException {
		WaitProcess().click();
		System.out.println("[log] Event -> " + name);
	}

	public void TypeClear(String value) {
		WaitProcess().click();
		if (value.toString() == value) {
			WaitProcess();
		}
		WaitProcess().type(Key.BACKSPACE + Key.BACKSPACE + Key.BACKSPACE + Key.BACKSPACE + Key.BACKSPACE);
		System.out.println("[log] Event -> " + name);
	}

	public void TypeText(String value) {
		WaitProcess().click();
		WaitProcess().type(value);
		System.out.println("[log] Event -> " + name);
	}

	public void Key(String value) {
		WaitProcess().type(value);
		System.out.println("[log] Event -> " + name);
	}
}