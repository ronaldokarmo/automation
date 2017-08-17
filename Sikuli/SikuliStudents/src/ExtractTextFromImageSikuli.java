import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

import org.sikuli.script.TextRecognizer;

public class ExtractTextFromImageSikuli {

	/**
	 * Convert an Image to BufferedImage for feeding into Sikuli OCR.
	 * 
	 * @param image
	 * @return BufferedImage
	 */
	private static BufferedImage getBufferedImageFromImage(Image image) {

		Image temp = new ImageIcon(image).getImage();
		BufferedImage bufferedImage = new BufferedImage(temp.getWidth(null),
				temp.getHeight(null), BufferedImage.TYPE_INT_RGB);
		Graphics g = bufferedImage.createGraphics();
		g.drawImage(temp, 0, 0, null);
		g.dispose();
		return bufferedImage;
	}

	public static void main(String[] args) {

		try
		{
			Image img = Toolkit.getDefaultToolkit().createImage(args[0]);
			BufferedImage brimage = getBufferedImageFromImage(img);
			TextRecognizer tr = TextRecognizer.getInstance();
			String s = tr.recognize(brimage);
			System.out.println(s);	
		}
		catch (Exception warn)
		{
			System.out.println(warn);
		}
	}
}
