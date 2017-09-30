import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class FontConverter {
	
	static byte[][] chars;
	static String msg="";
	
	public static void initChars(String file) throws IOException {
		BufferedImage image  = ImageIO.read(new File(file));
		chars = new byte[256][8];
		
		for(int i=0; i<8; i++) {
			for(int j=0; j<16; j++) {
				System.out.print("{ ");
				for(int x=0; x<8; x++) {
					byte b = 0;
					for(int y=0; y<8; y++) {
						 b = (byte) ((b << 1) | (image.getRGB(j*9 + x, i*9 + y) == 0xFF000000 ? 1 : 0));
					}
					chars[i*16+j][x] = b;
					System.out.print(b + (x==7 ? " " : ", "));
				}
				System.out.println("},");
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		initChars("C:\\font.png");
	}
}
