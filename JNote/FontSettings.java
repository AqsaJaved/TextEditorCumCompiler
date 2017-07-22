package JNote;

import java.awt.Font;
public class FontSettings {
	
	public int size = 13;
	public boolean isBold = false, isItalik = false;
	
	public String name = "Segoe UI";
	
	public Font getFont() {
		int style = Font.PLAIN;
		
		if (isBold && !isItalik) {
			style = Font.BOLD;
		}
		else if (!isBold && isItalik) {
			style = Font.ITALIC;
		}
		else if (isBold && isItalik) {
			style = (Font.BOLD | Font.ITALIC);
		}
		
		return new Font(name, style, size);
                
	}
	
}