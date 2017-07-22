package JNote;

import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class Main {

	public static void main(String[] args) {
               System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
            try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
                     } catch (Exception ex) {
            System.err.println(ex);
        }
            try{
             
			Frame frame = new Frame();
			frame.setVisible(true);
                }
		catch (Exception exc) {
			exc.printStackTrace();
		}
}
        
}