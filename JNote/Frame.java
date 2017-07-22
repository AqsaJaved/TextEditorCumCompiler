package JNote;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.*;
import java.awt.Robot.*;
import java.awt.Desktop.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.Desktop;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.event.*;
import java.io.*;
import javax.swing.SwingUtilities.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.tree.*;

public class Frame extends JFrame implements ChangeListener, ActionListener, WindowListener{
	
	public static int tabs = 1;
	private static String tempText = "";
        static String speaktext;
        static int flag=0;//flag to check whether file saved or not
        static String filename="";
        String str7,str8,str9="";
        int len1;
	private static JMenuBar menuBar;
        private FindOrReplace findOrReplace;
	public static JMenu menuFile, menuEdit, menuFormat, menuView, menuChangeCase,menuAdvanced,menuRead, menuHelp;
	private static JMenuItem menuItemNew, menuItemNewJava, menuItemOpen,menuItemSave,
			menuItemSaveAs, menuItemPageSetup, menuItemPrint, menuChangeWorkingDirectory, menuItemExit,
                        menuItemCut,menuItemCopy,menuItemPaste,menuItemUndo,menuItemRedo,
                        menuItemSelectAll,menuItemGOTO,menuItemFindOrReplace, menuItemFindNext, menuItemReplaceNext,
			 menuItemTimeAndDate,menuItemStatusBar, menuItemLineNumbers, menuWordCount,menuItemChangeToUpper,menuItemChangeToLower,
                         menuItemLineWrap,menuItemWordWrap, menuItemTextToPdf,menuEncrypt,menuItemTextToAudio,menuItemPause,
                        menuItemStop, menuItemResume, menuItemViewHelp,menuItemAbout;
	
	private static JPanel contentPane, panelTools;
	private static TabbedPane tabbedPane;
	private static JButton buttonNew, buttonOpen, buttonSave, buttonPrint, buttonPaste, buttonCopy, buttonCut,buttonClose;
	private static JFileChooser fileChooser = new JFileChooser();
	
	private static Scanner scanner;
	private static PrintWriter printWriter;
	
        private static Tab tab;
	private static ImageIcon iconActive = new ImageIcon(Frame.class.getResource("/icons/active.png"));
	
	private static Printer printer = new Printer();
	public static Settings settings = new Settings();
	private static About about = new About();
        private static CreateZip createzip;
        private static JNote_ide jnote_ide;
        int arr[]=new int[2];
        Robot robot;
	private JTree jTree;
        public String directory="";
        String treevar;
	private static ArrayList<String> arrayListFilePaths = new ArrayList<String>();
        String filename1="";
        String password="";
        help help_ob=new help();
        
        
        
	public Frame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Frame.class.getResource("/icons/logo1.png")));
		initialize();
                initTree("C:/");
	}
	
	private void initialize() {
		setTitle("JNote");
		setSize(1200, 700);
		setLocationRelativeTo(null);
               
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(this);
                
		
                jTree = new javax.swing.JTree();
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
                menuBar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 102, 102), null, null));
		
		menuFile = new JMenu("File");
                menuFile.setFont(new java.awt.Font("Microsoft YaHei", 0, 14));
		menuBar.add(menuFile);
		
		menuItemNew = new JMenuItem("New");
		menuItemNew.setIcon(new ImageIcon(Frame.class.getResource("/icons/new.png")));
		menuItemNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
                menuItemNew.setFont(new java.awt.Font("Microsoft YaHei", 0, 14));
		menuItemNew.addActionListener(this);
		menuFile.add(menuItemNew);
    
                menuItemNewJava=new JMenuItem("New Java File");
                menuItemNewJava.setIcon(new ImageIcon(Frame.class.getResource("/icons/java.jpg")));
                menuItemNewJava.setFont(new java.awt.Font("Microsoft YaHei", 0, 14));
                menuItemNewJava.addActionListener(this);
		menuFile.add(menuItemNewJava);
		
		menuItemOpen = new JMenuItem("Open");
		menuItemOpen.setIcon(new ImageIcon(Frame.class.getResource("/icons/open.png")));
		menuItemOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
                menuItemOpen.setFont(new java.awt.Font("Microsoft YaHei", 0, 14));
		menuItemOpen.addActionListener(this);
		menuFile.add(menuItemOpen);
               
		menuItemSave = new JMenuItem("Save");
		menuItemSave.setIcon(new ImageIcon(Frame.class.getResource("/icons/save.png")));
		menuItemSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
                menuItemSave.setFont(new java.awt.Font("Microsoft YaHei", 0, 14));
		menuItemSave.addActionListener(this);
		menuFile.add(menuItemSave);
		
		menuItemSaveAs = new JMenuItem("Save As");
                menuItemSaveAs.setIcon(new ImageIcon(Frame.class.getResource("/icons/save_as.png")));
                menuItemSaveAs.setFont(new java.awt.Font("Microsoft YaHei", 0, 14));
		menuItemSaveAs.addActionListener(this);
		menuFile.add(menuItemSaveAs);
		
		menuFile.addSeparator();
		
		menuItemPageSetup = new JMenuItem("Page Setup");
                menuItemPageSetup.setIcon(new ImageIcon(Frame.class.getResource("/icons/page_setup.png")));
                menuItemPageSetup.setFont(new java.awt.Font("Microsoft YaHei", 0, 14));
		menuItemPageSetup.addActionListener(this);
		menuFile.add(menuItemPageSetup);
		
		menuItemPrint = new JMenuItem("Print");
		menuItemPrint.setIcon(new ImageIcon(Frame.class.getResource("/icons/print.png")));
		menuItemPrint.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
                menuItemPrint.setFont(new java.awt.Font("Microsoft YaHei", 0, 14));
		menuItemPrint.addActionListener(this);
		menuFile.add(menuItemPrint);
                
                menuChangeWorkingDirectory=new JMenuItem("Change Working Directory..");
                menuChangeWorkingDirectory.setIcon(new ImageIcon(Frame.class.getResource("/icons/dir.png")));
                menuChangeWorkingDirectory.setFont(new java.awt.Font("Microsoft YaHei", 0, 14));
                menuChangeWorkingDirectory.addActionListener(this);
		menuFile.add(menuChangeWorkingDirectory);
		
		menuFile.addSeparator();
		
		menuItemExit = new JMenuItem("Exit");
                menuItemExit.setIcon(new ImageIcon(Frame.class.getResource("/icons/exit.png")));
                menuItemExit.setFont(new java.awt.Font("Microsoft YaHei", 0, 14));
		menuItemExit.addActionListener(this);
		menuFile.add(menuItemExit);
                
                menuFile.setRolloverEnabled(true);
                
                menuEdit=new JMenu("Edit");
                menuEdit.setFont(new java.awt.Font("Microsoft YaHei", 0, 14));
                menuBar.add(menuEdit);
                
                menuItemCut = new JMenuItem("Cut");
                menuItemCut.setIcon(new ImageIcon(Frame.class.getResource("/icons/cut.png")));
                menuItemCut.setFont(new java.awt.Font("Microsoft YaHei", 0, 14));
		menuItemCut.addActionListener(this);
		menuEdit.add(menuItemCut);
                
                menuItemCopy = new JMenuItem("Copy");
                menuItemCopy.setIcon(new ImageIcon(Frame.class.getResource("/icons/copy.png")));
                menuItemCopy.setFont(new java.awt.Font("Microsoft YaHei", 0, 14));
		menuItemCopy.addActionListener(this);
		menuEdit.add(menuItemCopy);
                
                menuItemPaste = new JMenuItem("Paste");
                menuItemPaste.setIcon(new ImageIcon(Frame.class.getResource("/icons/paste.png")));
                menuItemPaste.setFont(new java.awt.Font("Microsoft YaHei", 0, 14));
		menuItemPaste.addActionListener(this);
		menuEdit.add(menuItemPaste);
                
                menuEdit.addSeparator();
                
                 menuItemUndo = new JMenuItem("Undo");
                 menuItemUndo.setIcon(new ImageIcon(Frame.class.getResource("/icons/undo.png")));
                 menuItemUndo.setFont(new java.awt.Font("Microsoft YaHei", 0, 14));
		menuItemUndo.addActionListener(this);
		menuEdit.add(menuItemUndo);
                
                menuItemRedo = new JMenuItem("Redo");
                menuItemRedo.setIcon(new ImageIcon(Frame.class.getResource("/icons/redo.png")));
                  menuItemRedo.setFont(new java.awt.Font("Microsoft YaHei", 0, 14));
		menuItemRedo.addActionListener(this);
		menuEdit.add(menuItemRedo);
                
                menuEdit.addSeparator();
                
                 menuItemSelectAll = new JMenuItem("Select All");
                 menuItemSelectAll.setIcon(new ImageIcon(Frame.class.getResource("/icons/Select_All.png")));
                   menuItemSelectAll.setFont(new java.awt.Font("Microsoft YaHei", 0, 14));
		menuItemSelectAll.addActionListener(this);
		menuEdit.add(menuItemSelectAll);
                
                menuItemGOTO = new JMenuItem("Go To");
                menuItemGOTO.setIcon(new ImageIcon(Frame.class.getResource("/icons/goto.png")));
                menuItemGOTO.setFont(new java.awt.Font("Microsoft YaHei", 0, 14));
		menuItemGOTO.addActionListener(this);
		menuEdit.add(menuItemGOTO);
                
                menuEdit.addSeparator();
                
                menuItemFindOrReplace=new JMenuItem("Find or Replace");
                menuItemFindOrReplace.setIcon(new ImageIcon(Frame.class.getResource("/icons/find-replace.png")));
                menuItemFindOrReplace.setFont(new java.awt.Font("Microsoft YaHei", 0, 14));
                menuItemFindOrReplace.addActionListener(this);
                menuEdit.add(menuItemFindOrReplace);
		
                menuItemFindNext=new JMenuItem("Find Next");
                menuItemFindNext.setIcon(new ImageIcon(Frame.class.getResource("/icons/findnext.png")));
                menuItemFindNext.setFont(new java.awt.Font("Microsoft YaHei", 0, 14));
                menuItemFindNext.addActionListener(this);
                menuEdit.add(menuItemFindNext);
                
                menuItemReplaceNext=new JMenuItem("Replace Next");
                menuItemReplaceNext.setIcon(new ImageIcon(Frame.class.getResource("/icons/replace.png")));
                menuItemReplaceNext.setFont(new java.awt.Font("Microsoft YaHei", 0, 14));
                menuItemReplaceNext.addActionListener(this);
                menuEdit.add(menuItemReplaceNext);
                
                menuEdit.addSeparator();
                
                menuItemTimeAndDate=new JMenuItem("Time And Date");
                menuItemTimeAndDate.setIcon(new ImageIcon(Frame.class.getResource("/icons/timedate.jpg")));
                menuItemTimeAndDate.setFont(new java.awt.Font("Microsoft YaHei", 0, 14));
                menuItemTimeAndDate.addActionListener(this);
                menuEdit.add(menuItemTimeAndDate);               
                
		menuFormat = new JMenu("Format");
                menuFormat.setFont(new java.awt.Font("Microsoft YaHei", 0, 14));
		menuBar.add(menuFormat);
		
		menuItemLineWrap = new JMenuItem("Line Wrap");
                menuItemLineWrap.setIcon(new ImageIcon(Frame.class.getResource("/icons/line.png")));
                menuItemLineWrap.setFont(new java.awt.Font("Microsoft YaHei", 0, 14));
		menuItemLineWrap.addActionListener(this);
		menuFormat.add(menuItemLineWrap);
		
		menuItemWordWrap = new JMenuItem("Word Wrap");
		menuItemWordWrap.setEnabled(false);
                menuItemWordWrap.setIcon(new ImageIcon(Frame.class.getResource("/icons/word_wrap.png")));
                menuItemWordWrap.setFont(new java.awt.Font("Microsoft YaHei", 0, 14));
		menuItemWordWrap.addActionListener(this);
		menuFormat.add(menuItemWordWrap);
		                
		menuView = new JMenu("View");
                menuView.setFont(new java.awt.Font("Microsoft YaHei", 0, 14));
		menuBar.add(menuView);
		
		menuItemLineNumbers = new JMenuItem("Line Numbers");
		menuItemLineNumbers.setIcon(iconActive);
                menuItemLineNumbers.setFont(new java.awt.Font("Microsoft YaHei", 0, 14));
		menuItemLineNumbers.addActionListener(this);
		menuView.add(menuItemLineNumbers);
		
		menuItemStatusBar = new JMenuItem("Status Bar");
		menuItemStatusBar.setIcon(iconActive);
                menuItemStatusBar.setFont(new java.awt.Font("Microsoft YaHei", 0, 14));
		menuItemStatusBar.addActionListener(this);
		menuView.add(menuItemStatusBar);
                
                menuWordCount=new JMenuItem("Word Count");
                menuWordCount.setIcon(new ImageIcon(Frame.class.getResource("/icons/word.png")));
                menuWordCount.setFont(new java.awt.Font("Microsoft YaHei", 0, 14));
                menuWordCount.addActionListener(this);
                menuView.add(menuWordCount);
                
                menuChangeCase=new JMenu("Change Case");
                menuChangeCase.setIcon(new ImageIcon(Frame.class.getResource("/icons/font.gif")));
                menuChangeCase.setFont(new java.awt.Font("Microsoft YaHei", 0, 14));
                menuBar.add(menuChangeCase);
                
                menuItemChangeToUpper=new JMenuItem("Change To Uppercase");
                menuItemChangeToUpper.setIcon(new ImageIcon(Frame.class.getResource("/icons/uppercase.png")));
                menuItemChangeToUpper.setFont(new java.awt.Font("Microsoft YaHei", 0, 14));
                menuItemChangeToUpper.addActionListener(this);
                
                menuItemChangeToLower=new JMenuItem("Change To Lowercase");
                menuItemChangeToLower.setIcon(new ImageIcon(Frame.class.getResource("/icons/lowercase.png")));
                menuItemChangeToLower.setFont(new java.awt.Font("Microsoft YaHei", 0, 14));
                menuItemChangeToLower.addActionListener(this);
                
                menuChangeCase.add(menuItemChangeToUpper);
                menuChangeCase.add(menuItemChangeToLower);
                
                
                menuView.add(menuChangeCase);
                
                menuAdvanced = new JMenu("Advanced");
                 menuAdvanced.setFont(new java.awt.Font("Microsoft YaHei", 0, 14));
		menuBar.add(menuAdvanced);
                
                menuItemTextToPdf = new JMenuItem("Convert Text file to Pdf");
                menuItemTextToPdf.setIcon(new ImageIcon(Frame.class.getResource("/icons/pdf-icon.gif")));
                menuItemTextToPdf.setFont(new java.awt.Font("Microsoft YaHei", 0, 14));
		menuItemTextToPdf.addActionListener(this);
		menuAdvanced.add(menuItemTextToPdf);
                               
                menuAdvanced.addSeparator();
                
                menuEncrypt= new JMenuItem("Make Password Protected Zip of Text File");
                menuEncrypt.setIcon(new ImageIcon(Frame.class.getResource("/icons/encrypt.png")));
                menuEncrypt.setFont(new java.awt.Font("Microsoft YaHei", 0, 14));
                menuEncrypt.addActionListener(this);
                menuAdvanced.add(menuEncrypt);

                menuAdvanced.addSeparator();
                
                menuRead=new JMenu("Read Text");
                menuRead.setFont(new java.awt.Font("Microsoft YaHei", 0, 14));
                menuBar.add(menuRead);
                
                menuItemTextToAudio = new JMenuItem("Convert Text to Audio");
                menuItemTextToAudio.setIcon(new ImageIcon(Frame.class.getResource("/icons/audio.png")));
                menuItemTextToAudio.setFont(new java.awt.Font("Microsoft YaHei", 0, 14));
		menuItemTextToAudio.addActionListener(this);
		menuRead.add(menuItemTextToAudio);
                
                menuItemPause=new JMenuItem("Pause Reading Text");
                menuItemPause.setIcon(new ImageIcon(Frame.class.getResource("/icons/pause.png")));
                menuItemPause.setFont(new java.awt.Font("Microsoft YaHei", 0, 14));
                menuItemPause.addActionListener(this);
                menuItemPause.setEnabled(false);
		menuRead.add(menuItemPause);
                
                menuItemStop=new JMenuItem("Stop Reading Text");
                menuItemStop.setIcon(new ImageIcon(Frame.class.getResource("/icons/stop.gif")));
                menuItemStop.setFont(new java.awt.Font("Microsoft YaHei", 0, 14));
                menuItemStop.addActionListener(this);
                menuItemStop.setEnabled(false);
		menuRead.add(menuItemStop);
                
                menuItemResume=new JMenuItem("Resume Reading Text");
                menuItemResume.setIcon(new ImageIcon(Frame.class.getResource("/icons/resume.png")));
                menuItemResume.setFont(new java.awt.Font("Microsoft YaHei", 0, 14));
                menuItemResume.addActionListener(this);
                menuItemResume.setEnabled(false);
		menuRead.add(menuItemResume);
                             		
		menuHelp = new JMenu("Help");
                  menuHelp.setFont(new java.awt.Font("Microsoft YaHei", 0, 14));
		menuBar.add(menuHelp);
                
                menuItemViewHelp = new JMenuItem("View Help");
                menuItemViewHelp.setIcon(new ImageIcon(Frame.class.getResource("/icons/help.png")));
                  menuItemViewHelp.setFont(new java.awt.Font("Microsoft YaHei", 0, 14));
		menuItemViewHelp.addActionListener(this);
		menuHelp.add(menuItemViewHelp);
		
		menuItemAbout = new JMenuItem("About");
                menuItemAbout.setIcon(new ImageIcon(Frame.class.getResource("/icons/about.png")));
                 menuItemAbout.setFont(new java.awt.Font("Microsoft YaHei", 0, 14));
		menuItemAbout.addActionListener(this);
		menuHelp.add(menuItemAbout);
		
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
                contentPane.setBackground(Color.darkGray);
		setContentPane(contentPane);
		
		panelTools = new JPanel();
		panelTools.setLayout(new FlowLayout(5, 5, 5));
		contentPane.add(panelTools, BorderLayout.NORTH);
		
		buttonNew = new JButton("");
		buttonNew.setIcon(new ImageIcon(Frame.class.getResource("/icons/new.png")));
		buttonNew.addActionListener(this);
                buttonNew.setToolTipText("Create New File");
                buttonNew.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		panelTools.add(buttonNew);
		
		buttonOpen = new JButton("");
		buttonOpen.setIcon(new ImageIcon(Frame.class.getResource("/icons/open.png")));
		buttonOpen.addActionListener(this);
                buttonOpen.setToolTipText("Open existing File");
                buttonOpen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		panelTools.add(buttonOpen);
		
		buttonSave = new JButton("");
		buttonSave.setIcon(new ImageIcon(Frame.class.getResource("/icons/save.png")));
		buttonSave.addActionListener(this);
                buttonSave.setToolTipText("Save Selected Tab File");
                buttonSave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		panelTools.add(buttonSave);
		
		buttonPrint = new JButton("");
		buttonPrint.setIcon(new ImageIcon(Frame.class.getResource("/icons/print.png")));
		buttonPrint.addActionListener(this);
                buttonPrint.setToolTipText("Print Selected File");
                buttonPrint.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		panelTools.add(buttonPrint);
		
		buttonCut = new JButton("");
		buttonCut.setIcon(new ImageIcon(Frame.class.getResource("/icons/cut.png")));
		buttonCut.addActionListener(this);
                buttonCut.setToolTipText("Cut");
                buttonCut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		panelTools.add(buttonCut);
		
		buttonCopy = new JButton("");
		buttonCopy.setIcon(new ImageIcon(Tab.class.getResource("/icons/copy.png")));
		buttonCopy.addActionListener(this);
                buttonCopy.setToolTipText("Copy");
                buttonCopy.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		panelTools.add(buttonCopy);
		
		buttonPaste = new JButton("");
		buttonPaste.setIcon(new ImageIcon(Tab.class.getResource("/icons/paste.png")));
		buttonPaste.addActionListener(this);
                buttonPaste.setToolTipText("Paste");
                buttonPaste.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		panelTools.add(buttonPaste);
                                	
		buttonClose = new JButton("");
		buttonClose.setIcon(new ImageIcon(Frame.class.getResource("/icons/close.png")));
		buttonClose.addActionListener(this);
                buttonClose.setToolTipText("Exit JNote");
                buttonClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		panelTools.add(buttonClose);
		
		tabbedPane = new TabbedPane(JTabbedPane.TOP);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.addChangeListener(this);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
                
		newFile("Untitled " + tabs);                
        }
        public void SetDirectory()
        {
            directory= JOptionPane.showInputDialog("Change Working Directory");
             File theDir = new File(directory);
  if (!theDir.exists())
  {
    JOptionPane.showMessageDialog(null,"Incorrect Directory.Set a correct directory", "Error", JOptionPane.ERROR_MESSAGE);
  }
  else
  {
  jTree.setModel(new FileSystemModel(new File(directory)));
        }
        }
        public void initTree(String dir)
        {
                jTree.setModel(new FileSystemModel(new File(dir)));
                jTree.setEditable(false);
               jTree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
               
               JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,new JScrollPane(jTree),tabbedPane);
             add(splitPane);
             
             jTree.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e){if (e.getButton() == MouseEvent.BUTTON1 && e.getClickCount() == 2) {
                 int in=0;
                 String temp;
               treevar=jTree.getSelectionPath().toString().replaceAll("[\\[\\]]", "").replace(", ", "\\");
               int len=treevar.length();
               String tpath=treevar.substring(4,len);
              temp=treevar;
             try
        {
             File selection=new File(temp);
             String fn=selection.getName();
            if(temp.endsWith(".txt")||temp.endsWith(".TXT")||temp.endsWith(".java")||temp.endsWith(".html")||temp.endsWith(".xml")||
                    temp.endsWith(".mf")||temp.endsWith(".doc")||temp.endsWith(".docx")||temp.endsWith(".bat")||temp.endsWith(".sys")||temp.endsWith(".SYS")
                    ||temp.endsWith(".dll"))
            {         
             if(selection.exists())
            {
                Tab tab = new Tab();
		tabbedPane.addTab(fn, null, tab, null);
		tabbedPane.setSelectedIndex(tabbedPane.getTabCount() - 2);
		tabs++;
                getSelectedTab().fileName=fn;
                getSelectedTab().filePath=temp;
                FileInputStream fobj=new FileInputStream(selection);
                int length=(int)selection.length();
String str4="";
   for(int j=0;j<length;j++)
{
char str5=(char)fobj.read();
str4=str4 + str5;
}
getSelectedTextArea().setText(str4);
             
             }
            }
            else
            {
              JOptionPane.showMessageDialog(null,"Selected File is not supported by the Editor.", "Error", JOptionPane.ERROR_MESSAGE);   
            }
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        
       }}
             } );
        }
	public static JTextArea getSelectedTextArea() {
		return ((Tab) tabbedPane.getSelectedComponent()).textArea;
	}
	
	private Tab getSelectedTab() {
		return (Tab) tabbedPane.getSelectedComponent();
	}
        	
	public static void newFile(String title) {
		Tab tab = new Tab();
		tabbedPane.addTab(title, null, tab, null);
		tabbedPane.setSelectedIndex(tabbedPane.getTabCount() - 2);
		
		tabs++;
	}
	
	private void openFile() {
		fileChooser.setDialogTitle("Open");
		fileChooser.setMultiSelectionEnabled(true);
		  
		if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                  
			File[] files = fileChooser.getSelectedFiles();
                        int count=0;
			for (int i=0; i<files.length; i++) {
                      
                             if (!arrayListFilePaths.contains(files[i].getAbsolutePath())) {
					try {
						tempText = "";
						scanner = new Scanner(files[i]);
						newFile(files[i].getName());
						getSelectedTab().fileName = files[i].getName();
						getSelectedTab().filePath = files[i].getAbsolutePath();
						arrayListFilePaths.add(files[i].getAbsolutePath());
                                                
                            				while (scanner.hasNextLine()) {
							tempText += scanner.nextLine() + "\n";
						}
						getSelectedTextArea().setText(tempText);
						scanner.close();
					}
					catch (Exception exc) {
						JOptionPane.showMessageDialog(this, exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				else {
					for (int j=0; j<tabbedPane.getTabCount()-1; j++) {
						if (((Tab) tabbedPane.getComponentAt(j)).filePath.equals(files[i].getAbsolutePath())) {
							tabbedPane.setSelectedIndex(j);
							
							break;
						}
					}
				}

			}
		}
	}
	private void save()
        {
            flag=1;
		if (getSelectedTab().filePath.equals("")) {
                   
			saveAs();
		}
		else {
			try {
				printWriter = new PrintWriter(new File(getSelectedTab().filePath));
				printWriter.println(getSelectedTextArea().getText());
				printWriter.flush();
				printWriter.close();
			}
			catch (Exception exc) {
				exc.printStackTrace();
			}
		}
	}
	
	private void saveAs() {
            flag=1;
 
		fileChooser.setDialogTitle("Save As");
		fileChooser.setMultiSelectionEnabled(false);
		
		if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			
			try {
                            if(file.getName().endsWith(".txt")||file.getName().endsWith(".TXT")||file.getName().endsWith(".xml")||
                                    file.getName().endsWith(".html")||file.getName().endsWith(".java")
                                    ||file.getName().endsWith(".mf")||file.getName().endsWith(".doc")){
				printWriter = new PrintWriter(file);
				printWriter.println(getSelectedTextArea().getText());
				printWriter.flush();
				printWriter.close();
				
                                 filename1=fileChooser.getSelectedFile().getName();
                                String filename2=fileChooser.getSelectedFile().getPath();
                                filename=filename2;
                                tabbedPane.setTitleAt(tabbedPane.getSelectedIndex(), fileChooser.getSelectedFile().getName());
				tabbedPane.setTitleAt(tabbedPane.getSelectedIndex(), file.getName());
				getSelectedTab().fileName = file.getName();
				getSelectedTab().filePath = file.getAbsolutePath();
				arrayListFilePaths.add(file.getAbsolutePath());
			}
                            else
                            {
                                printWriter = new PrintWriter(file+".txt");
				printWriter.println(getSelectedTextArea().getText());
				printWriter.flush();
				printWriter.close();
				
                                filename1=fileChooser.getSelectedFile().getName()+".txt";
                                String filename2=fileChooser.getSelectedFile().getPath();
                                filename=filename2;
                                tabbedPane.setTitleAt(tabbedPane.getSelectedIndex(), fileChooser.getSelectedFile().getName()+".txt");
				tabbedPane.setTitleAt(tabbedPane.getSelectedIndex(), file.getName()+".txt");
				getSelectedTab().fileName = file.getName()+".txt";
				getSelectedTab().filePath = file.getAbsolutePath();
				arrayListFilePaths.add(file.getAbsolutePath());
                            }
                        }
			catch (Exception exc) {
				JOptionPane.showMessageDialog(this, exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	private void exit() {
		if(JOptionPane.showConfirmDialog(this,
				"All unsaved documents will be lost. Are you sure you want to exit?",
				"JNote v0.01 (Beta)", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			System.gc();
			System.exit(0);
		}
	}
       	public static void removeTab(Component component, TabbedPane tabbedPane) {
		try {
			if (tabbedPane.getTabCount() > 2) {
				try {
					arrayListFilePaths.remove(arrayListFilePaths.indexOf(((Tab) component).filePath));
				}
				catch (Exception exc) {
					/*
					 * don't need to know this exception...
					 */
				}
				
				tabbedPane.remove(component);
				
				if (tabbedPane.getSelectedIndex() == (tabbedPane.getTabCount() - 1)) {
					tabbedPane.setSelectedIndex((tabbedPane.getTabCount() - 2));
				}
				
				((Tab) tabbedPane.getSelectedComponent()).textArea.requestFocusInWindow();
			}
			else {
				tabbedPane.removeAll();
				arrayListFilePaths.clear();
				tabs = 1;
				newFile("Untitled " + tabs);
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		
		System.gc();
	}
	
	private void updateMenuItemIcons(boolean active, JMenuItem menuItem) {
		if (menuItem.equals(menuItemLineWrap)) {
			if (menuItemLineNumbers.getIcon() != null) {
				settings.lineNumbersVisible = !active;
				
				getSelectedTab().panelLineNumbers.setVisible(settings.lineNumbersVisible);
			}
			
			menuItemLineNumbers.setEnabled(!active);
			menuItemWordWrap.setEnabled(active);
		}
                              
				if (active) {
			menuItem.setIcon(iconActive);
		}
		else {
			menuItem.setIcon(null);
		}
	}
	
	@Override
	public void stateChanged(ChangeEvent event) {
		if (event.getSource().equals(tabbedPane)) {
			try {
				Tab tab = getSelectedTab();
				tab.panelLineNumbers.setVisible(settings.lineNumbersVisible);
				tab.statusBar.setVisible(settings.statusBarVisible);
				
				getSelectedTextArea().setLineWrap(settings.activateLineWrap);
				getSelectedTextArea().setWrapStyleWord(settings.activateWordWrap);
			}
			catch (Exception exc) {
				/*
				 * don't need to know this exception...
				 */
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource().equals(menuItemNew) || event.getSource().equals(buttonNew)) {
			newFile("Untitled " + tabs);
		}
                else if (event.getSource().equals(menuItemNewJava)) {
			jnote_ide=new JNote_ide();
                        jnote_ide.setVisible(true);
                }
		else if (event.getSource().equals(menuItemOpen) || event.getSource().equals(buttonOpen)) {
			openFile();
		}
		else if (event.getSource().equals(menuItemSave) || event.getSource().equals(buttonSave)) {
			save();
		}
		else if (event.getSource().equals(menuItemSaveAs)) {
			saveAs();
		}
		else if (event.getSource().equals(menuItemPageSetup)) {
			printer.showPageDialog();
		}
		else if (event.getSource().equals(menuItemPrint) || event.getSource().equals(buttonPrint)) {
			JTextArea textArea = getSelectedTextArea();
			textArea.setFocusable(false);
			printer.showPrintDialog(textArea);
			textArea.setFocusable(true);
			textArea.requestFocus();
		}
                else if (event.getSource().equals(menuChangeWorkingDirectory)) {
			SetDirectory();
		}
                else if (event.getSource().equals(menuItemExit)) {
			exit();
		}
		else if (event.getSource().equals(buttonCut)||event.getSource().equals(menuItemCut)) {
			getSelectedTextArea().cut();
		}
		else if (event.getSource().equals(buttonCopy)||event.getSource().equals(menuItemCopy)) {
			getSelectedTextArea().copy();
		}
		else if (event.getSource().equals(buttonPaste)||event.getSource().equals(menuItemPaste)) {
			getSelectedTextArea().paste();
		}
		else if (event.getSource().equals(buttonClose)) {
			if(JOptionPane.showConfirmDialog(this,
					"Unsaved progress of this document will be lost. Are you sure you want to close?",
					"JNote v0.01 (Beta)", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		}
                else if (event.getSource().equals(menuItemUndo))
                {
                    
                   try {
    robot = new Robot();

    robot.keyPress(KeyEvent.VK_CONTROL);
    robot.keyPress(KeyEvent.VK_Z);
    robot.keyRelease(KeyEvent.VK_CONTROL);
    robot.keyRelease(KeyEvent.VK_Z);
} catch (AWTException e) {
    e.printStackTrace();
}
                }
                else if (event.getSource().equals(menuItemRedo))
                {
                    
                   try {
    robot = new Robot();
    // Simulate a key press
    robot.keyPress(KeyEvent.VK_CONTROL);
    robot.keyPress(KeyEvent.VK_Y);
    robot.keyRelease(KeyEvent.VK_CONTROL);
    robot.keyRelease(KeyEvent.VK_Y);
} catch (AWTException e) {
    e.printStackTrace();
}
                }
                else if (event.getSource().equals(menuItemSelectAll))
                {
                    
                   try {
    robot = new Robot();
    // Simulate a key press
    robot.keyPress(KeyEvent.VK_CONTROL);
    robot.keyPress(KeyEvent.VK_A);
    robot.keyRelease(KeyEvent.VK_CONTROL);
    robot.keyRelease(KeyEvent.VK_A);
} catch (AWTException e) {
    e.printStackTrace();
}
                }
                else if (event.getSource().equals(menuItemGOTO))
                {
                    
                   try {
    robot=new Robot();
    // Simulate a key press
    robot.keyPress(KeyEvent.VK_CONTROL);
    robot.keyPress(KeyEvent.VK_G);
    robot.keyRelease(KeyEvent.VK_CONTROL);
    robot.keyRelease(KeyEvent.VK_G);
} catch (AWTException e) {
    e.printStackTrace();
}
                }
               else if (event.getSource().equals(menuItemFindOrReplace))
                {
                    
                   try {
    robot=new Robot();
    // Simulate a key press
    robot.keyPress(KeyEvent.VK_CONTROL);
    robot.keyPress(KeyEvent.VK_F);
    robot.keyRelease(KeyEvent.VK_CONTROL);
    robot.keyRelease(KeyEvent.VK_G);
} catch (AWTException e) {
    e.printStackTrace();
}
                }
                else if (event.getSource().equals(menuItemFindNext))
                {
               findOrReplace.findOrReplace(0);
                
                }
                else if (event.getSource().equals(menuItemReplaceNext))
                {
               findOrReplace.findOrReplace(1);
                
                }
                else if (event.getSource().equals(menuItemTimeAndDate))
                {
                    
                   try {
    robot=new Robot();
    // Simulate a key press
    robot.keyPress(KeyEvent.VK_F5);
    robot.keyRelease(KeyEvent.VK_F5);
} catch (AWTException e) {
    e.printStackTrace();
}
                }
                
		else if (event.getSource().equals(menuItemLineNumbers)) {
			settings.lineNumbersVisible = !settings.lineNumbersVisible;
			getSelectedTab().panelLineNumbers.setVisible(settings.lineNumbersVisible);
			
			updateMenuItemIcons(settings.lineNumbersVisible, menuItemLineNumbers);
		}
		else if (event.getSource().equals(menuItemStatusBar)) {
			settings.statusBarVisible = !settings.statusBarVisible;
			getSelectedTab().statusBar.setVisible(settings.statusBarVisible);
			
			updateMenuItemIcons(settings.statusBarVisible, menuItemStatusBar);
		}
		else if (event.getSource().equals(menuItemLineWrap)) {
			settings.activateLineWrap = !settings.activateLineWrap;
			getSelectedTextArea().setLineWrap(settings.activateLineWrap);
			
			updateMenuItemIcons(settings.activateLineWrap, menuItemLineWrap);
		}
		else if (event.getSource().equals(menuItemWordWrap)) {
			settings.activateWordWrap = !settings.activateWordWrap;
			getSelectedTextArea().setWrapStyleWord(settings.activateWordWrap);
			
			updateMenuItemIcons(settings.activateWordWrap, menuItemWordWrap);
		}
                else if(event.getSource().equals(menuWordCount))
                {
                    int count=0;
                    String strText=getSelectedTextArea().getText().trim();
                    char ch[]= new char[strText.length()];      
                    for(int i=0;i<strText.length();i++)
                    {
                    ch[i]= strText.charAt(i);
                    if( ((i>0)&&(ch[i]!=' ')&&(ch[i-1]==' ')) || ((ch[0]!=' ')&&(i==0)) )
                    count++;
                }
                    JOptionPane.showMessageDialog(null, "The Word Count is "+count);
                }
                 else if (event.getSource().equals(menuItemChangeToUpper)){
			String temp=getSelectedTextArea().getText().toUpperCase();
                        getSelectedTextArea().setText(temp);
 
				}
                 else if (event.getSource().equals(menuItemChangeToLower)) {
			String temp=getSelectedTextArea().getText().toLowerCase();
                        getSelectedTextArea().setText(temp);
				}
                else if (event.getSource().equals(menuItemTextToPdf)) {
			TextToPDFConverter();
				}
                else if (event.getSource().equals(menuItemTextToAudio)) {
			String name=getSelectedTextArea().getText();
                       if(name.length()==0)
                     {
                         JOptionPane.showMessageDialog(null, "No text found");
                      }
                       else
                       {
                        try 
                        {
                         TextToSpeech.read(name);
                         menuItemPause.setEnabled(true);
                         menuItemStop.setEnabled(true);
                         menuItemResume.setEnabled(true);
                        }
                       catch(Exception err) 
                        {
                        System.out.println("Error reading line");
                        }
                  
		}
                }
                else if(event.getSource().equals(menuEncrypt))
                    {
                        createzip=new CreateZip();
                        if((getSelectedTab().fileName.length()<=0))
        {
           JOptionPane.showMessageDialog(null,"Save the file first");
           saveAs();
        }
                    else{
                        createzip.getFileName(getSelectedTab().fileName);
                        createzip.getFilePath(getSelectedTab().filePath);
                        String fnt=getSelectedTab().filePath.replace(getSelectedTab().fileName," ");
                        createzip.getFileDir(fnt);
                        password= JOptionPane.showInputDialog("Give password of the Zip to be created");
                        String temppass=JOptionPane.showInputDialog("Re-enter password of the Zip to be created");
                        if(temppass.equals(password)){
                        createzip.getPassword(password);
                        int index=getSelectedTab().filePath.lastIndexOf(".");
                  if(index<0)
                  {
                      getSelectedTab().filePath+=".txt";
                  }
                        File f=new File(getSelectedTab().filePath);
                        f.delete();
                    }
                        else
                        {
                            JOptionPane.showMessageDialog(this,"Passwords dont match", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }}
                else if (event.getSource().equals(menuItemPause)) {
			TextToSpeech.pause();
		}
		else if (event.getSource().equals(menuItemResume)) {
			TextToSpeech.resume();
		}
		else if (event.getSource().equals(menuItemStop)) {
			TextToSpeech.stop();
		}
                else if (event.getSource().equals(menuItemViewHelp)) {
			help_ob.setLocationRelativeTo(this);
			help_ob.showDialog();
		}
               		else if (event.getSource().equals(menuItemAbout)) {
			about.setLocationRelativeTo(this);
			about.showDialog();
		}
                
		getSelectedTextArea().requestFocusInWindow();
	}
	@Override
	public void windowActivated(WindowEvent event) {
		getSelectedTextArea().requestFocusInWindow();
	}

	@Override
	public void windowClosed(WindowEvent event) {
		/*
		 * nothing to be implemented here...
		 */
	}

	@Override
	public void windowClosing(WindowEvent event) {
		if (event.getSource().equals(this)) {
			exit();
		}
	}

	@Override
	public void windowDeactivated(WindowEvent event) {
		/*
		 * nothing to be implemented here...
		 */
	}

	@Override
	public void windowDeiconified(WindowEvent event) {
		/*
		 * nothing to be implemented here...
		 */
	}
	@Override
	public void windowIconified(WindowEvent event) {
		/*
		 * nothing to be implemented here...
		 */
	}

	@Override
	public void windowOpened(WindowEvent event) {
		/*
		 * nothing to be implemented here...
		 */
        }
        public void TextToPDFConverter()
{
    File file;
    try{
        String strText=getSelectedTextArea().getText();
        if(strText.length()==0)
    {
        JOptionPane.showMessageDialog(null, "No text found");
    }
        else
        {
        if(getSelectedTab().fileName.length()<=0)
        {
           JOptionPane.showMessageDialog(null,"Save the file first");
           saveAs();
        }
        else
        {
            if(getSelectedTab().filePath.endsWith(".txt"))
            {
                 file=new File(getSelectedTab().filePath);
            }
            else
            {
             file=new File(getSelectedTab().filePath+".txt");   
            }
                if(convertTextToPDF(file)){
                    String temp=getSelectedTab().filePath.replace(getSelectedTab().fileName,"");
                JOptionPane.showMessageDialog(null,"Text file successfully converted to PDF.Created File at "+temp+".pdf"); 
            try {

		File pdfFile = new File(getSelectedTab().filePath+".pdf");
		if (pdfFile.exists()) {

			if (Desktop.isDesktopSupported()) {
				Desktop.getDesktop().open(pdfFile);
			} else {
				System.out.println("Awt Desktop is not supported!");
			}

		} else {
			System.out.println("File does not exist!");
		}


	  } catch (Exception ex) {
		ex.printStackTrace();
	  }

                }}}}
    catch(Exception e)
    {
        System.out.println(e);
    }
}
    public boolean convertTextToPDF(File file) throws Exception  
    {  
        FileInputStream fis=null;  
        DataInputStream in=null;  
        InputStreamReader isr=null;  
        BufferedReader br=null;  
        try {  
            Document pdfDoc = new Document();  
            String output_file =getSelectedTab().filePath+".pdf";  
            PdfWriter writer=PdfWriter.getInstance(pdfDoc,new FileOutputStream(output_file));  
            pdfDoc.open();  
            pdfDoc.setMarginMirroring(true);  
            pdfDoc.setMargins(36, 72, 108,180);  
            pdfDoc.topMargin();  
            com.itextpdf.text.Font myfont = new com.itextpdf.text.Font();  
            com.itextpdf.text.Font bold_font = new com.itextpdf.text.Font();  
            bold_font.setStyle(com.itextpdf.text.Font.BOLD);  
            bold_font.setSize(10);  
            myfont.setStyle(com.itextpdf.text.Font.NORMAL);  
            myfont.setSize(10);  
            pdfDoc.add(new Paragraph("\n"));  
            if(file.exists()){  
                fis = new FileInputStream(file);  
                in = new DataInputStream(fis);  
                isr=new InputStreamReader(in);  
                br = new BufferedReader(isr);  
                String strLine;  
                while ((strLine = br.readLine()) != null)  {  
                    Paragraph para =new Paragraph(strLine+"\n",myfont);  
                    para.setAlignment(Element.ALIGN_JUSTIFIED);  
                    pdfDoc.add(para);  
                }  
            }     
            else {  
 
                System.out.println("no such file exists!");  
                return false;  
            }  
            pdfDoc.close();   
        }  
         catch(Exception e) {  
            System.out.println("Exception: " + e.getMessage());  
        }  
        finally {  
             if(br!=null)  
            {  
                br.close();  
            }  
            if(fis!=null)  
            {  
                fis.close();  
            }  
            if(in!=null)  
            {  
                in.close();  
            }  
            if(isr!=null)  
            {  
                isr.close();  
            }  
         }  
         return true;  
    } 
 }
	
