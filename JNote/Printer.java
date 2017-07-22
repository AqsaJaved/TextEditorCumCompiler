package JNote;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterJob;

import javax.swing.RepaintManager;

public class Printer implements Printable {
	
	private Component component;
	private PrinterJob printerJob = PrinterJob.getPrinterJob();
	private PageFormat pageFormat;
	
	public void showPageDialog() {
		if (pageFormat == null) {
			pageFormat = printerJob.pageDialog(printerJob.defaultPage());
		}
		else {
			pageFormat = printerJob.pageDialog(pageFormat);
		}
	}
	
	public void showPrintDialog(Component component) {
		this.component = component;
		
		printerJob.setPrintable(this);
		
		if(printerJob.printDialog()) {
			try {
				printerJob.print();
			}
			catch (Exception exc) {
				exc.printStackTrace();
			}
		}
	}
	
	@Override
	public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) {
		if (pageIndex > 0) {
			return NO_SUCH_PAGE;
		}
		else {
			Graphics2D graphics2D = (Graphics2D) graphics;
			graphics2D.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
			RepaintManager.currentManager(component).setDoubleBufferingEnabled(false);
			component.paint(graphics2D);
			RepaintManager.currentManager(component).setDoubleBufferingEnabled(true);
		}
		
		return 0;
	}
	
}