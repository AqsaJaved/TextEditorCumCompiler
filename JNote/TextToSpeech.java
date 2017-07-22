/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JNote;

/**
 *
 * @author Aqsa Javed
 */
import javax.swing.JTextArea;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import com.sun.speech.freetts.audio.AudioPlayer;

public class TextToSpeech {
	
	private static int position = 0;
	private static boolean pause = false;
	public static boolean reading = false;
	
	private static final String voiceName = "kevin16";
	private static Voice voice = null;
	private static AudioPlayer audioPlayer;
	public static volatile Tab tab;
	
	private static void initialize() {
             
		try {
			Thread.sleep(1000);
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		
		reading = true;
		voice = VoiceManager.getInstance().getVoice(voiceName);
		voice.allocate();
		
		audioPlayer = voice.getAudioPlayer();
	}
	
	public static void read(final String text) {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				initialize();
				
				try {
					voice.speak(text);
				}
				catch (Exception exc) {
					System.err.println(exc.getMessage());
				}
				
				reading = false;
			}
		}).start();
	}
        public static void pause() {
		audioPlayer.pause();
		
		pause = true;
	}
	
	public static void resume() {
		pause = false;
		
		audioPlayer.resume();
	}
	
	public static void stop() {
		reading = false;
		
		if (voice != null) {
			audioPlayer.pause();
			voice.deallocate();
                       
		}
		
		voice = null;
	}
}
