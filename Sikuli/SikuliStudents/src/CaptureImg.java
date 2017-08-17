import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.sikuli.script.Screen;

public class CaptureImg {

	public static void main(String[] args) throws IOException {
		Screen scr = new Screen();

		BufferedImage bf = scr.capture(scr.selectRegion()).getImage();

		File file1 = new File(".\\img\\teste.png");
		ImageIO.write(bf, "png", file1);
		
		
	}
}