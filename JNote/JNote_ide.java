
package JNote;

import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.FileDialog;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import jsyntaxpane.DefaultSyntaxKit;

public class JNote_ide extends javax.swing.JFrame {
    public JNote_ide() {
        setTitle("Untitled-JNoteIDE");
        initComponents();
        Compile.setEnabled(false);
        Run.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jMenuItem2 = new javax.swing.JMenuItem();
        jScrollPane5 = new javax.swing.JScrollPane();
        MessageArea = new javax.swing.JTextArea();
        Open = new javax.swing.JButton();
        Save = new javax.swing.JButton();
        Compile = new javax.swing.JButton();
        Run = new javax.swing.JButton();
        New = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        ProgramArea = new javax.swing.JEditorPane();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuItemNew = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        menuItemOpen = new javax.swing.JMenuItem();
        menuItemSave = new javax.swing.JMenuItem();
        menuItemSaveAs = new javax.swing.JMenuItem();
        menuItemExitWindow = new javax.swing.JMenuItem();
        menuItemExitJNote = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuItemCut  = new javax.swing.JMenuItem();
        menuItemCopy = new javax.swing.JMenuItem();
        menuItemPaste =new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menuItemUndo = new javax.swing.JMenuItem();
        menuItemRedo = new javax.swing.JMenuItem();
        menuItemFind = new javax.swing.JMenuItem();
        menuSurround = new javax.swing.JMenu();
        menuItemSurroundWhile = new javax.swing.JMenuItem();
        menuItemSurrondIf = new javax.swing.JMenuItem();
        menuItemSurrondTry = new javax.swing.JMenuItem();
        menuItemToggleComments = new javax.swing.JMenuItem();
        menuCheckBoxToggleLines = new javax.swing.JCheckBoxMenuItem();
        menuItemFindReplace = new javax.swing.JMenuItem();
        menuItemFindNext = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        menuItemSelectAll = new javax.swing.JMenuItem();
        menuItemGoTo = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        menuItemUndo = new javax.swing.JMenuItem();
        menuItemRedo = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        menuItemIndent = new javax.swing.JMenuItem();
        menuItemUnindent = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        menuHelp = new javax.swing.JMenu();
        menuItemAbout = new javax.swing.JMenuItem();
        
        jScrollPane1.setViewportView(jTextPane1);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane4.setViewportView(jTextArea1);

        jMenuItem2.setText("jMenuItem2");

        setBackground(new java.awt.Color(255, 102, 102));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFont(new java.awt.Font("Monotype Corsiva", 0, 14)); // NOI18N

        MessageArea.setBackground(new java.awt.Color(218, 250, 250));
        MessageArea.setColumns(20);
        MessageArea.setEditable(false);
        MessageArea.setFont(new java.awt.Font("Mongolian Baiti", 3, 18)); // NOI18N
        MessageArea.setLineWrap(true);
        MessageArea.setRows(5);
        MessageArea.setWrapStyleWord(true);
        MessageArea.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jScrollPane5.setViewportView(MessageArea);

        Open.setBackground(new java.awt.Color(105, 105, 105));
        Open.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        Open.setText("Open");
        Open.setToolTipText("Open an existing Java program");
        Open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenActionPerformed(evt);
            }
        });

        Save.setBackground(new java.awt.Color(105, 105, 105));
        Save.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        Save.setText("Save");
        Save.setToolTipText("Save the Java program");
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });

        Compile.setBackground(new java.awt.Color(105, 105, 105));
        Compile.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        Compile.setText("Compile");
        Compile.setToolTipText("Compile the Java program");
        Compile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CompileActionPerformed(evt);
            }
        });

        Run.setBackground(new java.awt.Color(105, 105, 105));
        Run.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        Run.setText("Run");
        Run.setToolTipText("Run the compiled Java program");
        Run.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RunActionPerformed(evt);
            }
        });

        New.setBackground(new java.awt.Color(105, 105, 105));
        New.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        New.setText("New");
        New.setToolTipText("Create a New Java Program");
        New.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        New.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewActionPerformed(evt);
            }
        });

        ProgramArea.setBackground(new java.awt.Color(223, 242, 242));
        ProgramArea.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        ProgramArea.setFont(new java.awt.Font("Gungsuh", 0, 14)); // NOI18N
        ProgramArea.setText("Type Java program or Click Open to open a Java program");
        ProgramArea.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ProgramAreaFocusGained(evt);
            }
        });
        jScrollPane6.setViewportView(ProgramArea);
        
        jsyntaxpane.DefaultSyntaxKit.initKit();
        ProgramArea.setContentType("text/java");
        
        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logo1large.png"))); // NOI18N
        jLabel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jMenuBar1.setBackground(new java.awt.Color(102, 102, 255));
        jMenuBar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 102, 102), null, null));

        menuItemNew.setText("File");
        menuItemNew.setFont(new java.awt.Font("Microsoft YaHei", 0, 14)); // NOI18N
        menuItemNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemNewActionPerformed(evt);
            }
        });

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/new.png"))); // NOI18N
        jMenuItem1.setText("New");
       jMenuItem1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        jMenuItem1.setFont(new java.awt.Font("Microsoft YaHei", 0, 14));
        menuItemNew.add(jMenuItem1);

        menuItemOpen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/open.png"))); // NOI18N
        menuItemOpen.setText("Open Java Program");
        menuItemOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        menuItemOpen.setFont(new java.awt.Font("Microsoft YaHei", 0, 14));
        menuItemOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemOpenActionPerformed(evt);
            }
        });
        menuItemNew.add(menuItemOpen);
       
        menuItemNew.addSeparator();
        
        menuItemSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/save.png"))); // NOI18N
        menuItemSave.setText("Save");
        menuItemSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        menuItemSave.setFont(new java.awt.Font("Microsoft YaHei", 0, 14));
        menuItemSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSaveActionPerformed(evt);
            }
        });
        menuItemNew.add(menuItemSave);

        menuItemSaveAs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/save_as.png"))); // NOI18N
        menuItemSaveAs.setText("Save As");
        menuItemSaveAs.setFont(new java.awt.Font("Microsoft YaHei", 0, 14));
        menuItemSaveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSaveAsActionPerformed(evt);
            }
        });
        menuItemNew.add(menuItemSaveAs);
        menuItemNew.addSeparator();

        menuItemExitWindow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/close.png"))); // NOI18N
        menuItemExitWindow.setText("Exit To Main Window");
        menuItemExitWindow.setFont(new java.awt.Font("Microsoft YaHei", 0, 14));
        menuItemExitWindow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemExitWindowActionPerformed(evt);
            }
        });
        menuItemNew.add(menuItemExitWindow);

        menuItemExitJNote.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/exit.png"))); // NOI18N
        menuItemExitJNote.setText("Exit JNote");
        menuItemExitJNote.setFont(new java.awt.Font("Microsoft YaHei", 0, 14));
        menuItemExitJNote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemExitJNoteActionPerformed(evt);
            }
        });
        menuItemNew.add(menuItemExitJNote);

        jMenuBar1.add(menuItemNew);

        jMenu2.setText("Edit");
        jMenu2.setFont(new java.awt.Font("Microsoft YaHei", 0, 14)); // NOI18N
        jMenu2.setIconTextGap(8); // NOI18N
        
         menuItemCut.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        menuItemCut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cut.png"))); // NOI18N
        menuItemCut.setText("Cut");
        menuItemCut.setFont(new java.awt.Font("Microsoft YaHei", 0, 14));
        menuItemCut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCutActionPerformed(evt);
            }
        });
        jMenu2.add(menuItemCut);

        menuItemCopy.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        menuItemCopy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/copy.png"))); // NOI18N
        menuItemCopy.setText("Copy");
        menuItemCopy.setFont(new java.awt.Font("Microsoft YaHei", 0, 14));
        menuItemCopy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCopyActionPerformed(evt);
            }
        });
        jMenu2.add(menuItemCopy);

        menuItemPaste.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        menuItemPaste.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/paste.png"))); // NOI18N
        menuItemPaste.setText("Paste");
        menuItemPaste.setFont(new java.awt.Font("Microsoft YaHei", 0, 14));
        menuItemPaste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemPasteActionPerformed(evt);
            }
        });
        jMenu2.add(menuItemPaste);
        jMenu2.add(jSeparator1);
        
         menuItemUndo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        menuItemUndo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/undo.png"))); // NOI18N
        menuItemUndo.setText("Undo");
        menuItemUndo.setFont(new java.awt.Font("Microsoft YaHei", 0, 14));
        menuItemUndo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemUndoActionPerformed(evt);
            }

            private void menuItemUndoActionPerformed(ActionEvent evt) {
                                 try {
                    Robot robot = new Robot();
    // Simulate a key press
                   robot.keyPress(KeyEvent.VK_CONTROL);
                   robot.keyPress(KeyEvent.VK_Z);
                   robot.keyRelease(KeyEvent.VK_CONTROL);
                   robot.keyRelease(KeyEvent.VK_Z);
                   } catch (AWTException e) {
                  e.printStackTrace();
                   }  
            }
        });
        jMenu2.add(menuItemUndo);
        
        menuItemRedo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_MASK));
        menuItemRedo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/redo.png"))); // NOI18N
        menuItemRedo.setText("Redo");
        menuItemRedo.setFont(new java.awt.Font("Microsoft YaHei", 0, 14));
        menuItemRedo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemRedoActionPerformed(evt);
            }
        private void menuItemRedoActionPerformed(ActionEvent evt) {
                try {
                    Robot robot = new Robot();
    // Simulate a key press
                   robot.keyPress(KeyEvent.VK_CONTROL);
                   robot.keyPress(KeyEvent.VK_Y);
                   robot.keyRelease(KeyEvent.VK_CONTROL);
                   robot.keyRelease(KeyEvent.VK_Y);
                   } catch (AWTException e) {
                  e.printStackTrace();
                   }  
            }
        });
        jMenu2.add(menuItemRedo);
        
        menuItemFind.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        menuItemFind.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/findnext.png"))); // NOI18N
        menuItemFind.setText("Find");
        menuItemFind.setFont(new java.awt.Font("Microsoft YaHei", 0, 14));
        menuItemFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemFindActionPerformed(evt);
            }
        });
        jMenu2.add(menuItemFind);
        
        menuItemFindReplace.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        menuItemFindReplace.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/find-replace.png"))); // NOI18N
        menuItemFindReplace.setText("Find/Replace");
        menuItemFindReplace.setFont(new java.awt.Font("Microsoft YaHei", 0, 14));
        menuItemFindReplace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemFindReplaceActionPerformed(evt);
            }
        });
        jMenu2.add(menuItemFindReplace);

        menuItemFindNext.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        menuItemFindNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/images/small-icons/find-next.png"))); // NOI18N
        menuItemFindNext.setText("Find Next");
        menuItemFindNext.setFont(new java.awt.Font("Microsoft YaHei", 0, 14));
        menuItemFindNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemFindNextActionPerformed(evt);
            }
        });
        jMenu2.add(menuItemFindNext);
        jMenu2.add(jSeparator2);

        menuItemSelectAll.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        menuItemSelectAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Select_All.png"))); // NOI18N
        menuItemSelectAll.setText("Select All");
        menuItemSelectAll.setFont(new java.awt.Font("Microsoft YaHei", 0, 14));
        menuItemSelectAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSelectAllActionPerformed(evt);
            }
        });
        jMenu2.add(menuItemSelectAll);

        menuItemGoTo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        menuItemGoTo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/goto.png"))); // NOI18N
        menuItemGoTo.setText("Go To Line");
        menuItemGoTo.setFont(new java.awt.Font("Microsoft YaHei", 0, 14));
        menuItemGoTo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemGoToActionPerformed(evt);
            }
        });
        jMenu2.add(menuItemGoTo);
        jMenu2.add(jSeparator3);

        menuItemUndo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        menuItemUndo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/undo.png"))); // NOI18N
        menuItemUndo.setText("Undo");
        menuItemUndo.setFont(new java.awt.Font("Microsoft YaHei", 0, 14));
        menuItemUndo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemUndoActionPerformed(evt);
            }
        });
        jMenu2.add(menuItemUndo);

        menuItemRedo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_MASK));
        menuItemRedo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/redo.png"))); // NOI18N
        menuItemRedo.setText("Redo");
        menuItemRedo.setFont(new java.awt.Font("Microsoft YaHei", 0, 14));
        menuItemRedo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemRedoActionPerformed(evt);
            }
        });
        jMenu2.add(menuItemRedo);
        jMenuBar1.add(jMenu2);
        
        jMenu1.setText("Advanced ");
        jMenu1.setFont(new java.awt.Font("Microsoft YaHei", 0, 14)); // NOI18N

        menuItemIndent.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_TAB, 0));
        menuItemIndent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/images/small-icons/indent.png"))); // NOI18N
        menuItemIndent.setText("Indent");
        menuItemIndent.setFont(new java.awt.Font("Microsoft YaHei", 0, 14));
        menuItemIndent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemIndentActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemIndent);

        menuItemUnindent.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_TAB, java.awt.event.InputEvent.SHIFT_MASK));
        menuItemUnindent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/images/small-icons/unindent.png"))); // NOI18N
        menuItemUnindent.setText("Unindent");
        menuItemUnindent.setFont(new java.awt.Font("Microsoft YaHei", 0, 14));
        menuItemUnindent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemUnindentActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemUnindent);
        jMenu1.add(jSeparator4);

        menuItemToggleComments.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_SLASH, java.awt.event.InputEvent.CTRL_MASK));
        menuItemToggleComments.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/images/small-icons/comment.png"))); // NOI18N
        menuItemToggleComments.setText("Toggle-Comments");
        menuItemToggleComments.setFont(new java.awt.Font("Microsoft YaHei", 0, 14));
        menuItemToggleComments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemToggleCommentsActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemToggleComments);

        menuCheckBoxToggleLines.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, java.awt.event.InputEvent.CTRL_MASK));
        menuCheckBoxToggleLines.setSelected(true);
        menuCheckBoxToggleLines.setText("Toggle-Lines");
        menuCheckBoxToggleLines.setFont(new java.awt.Font("Microsoft YaHei", 0, 14));
        menuCheckBoxToggleLines.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/images/small-icons/toggle-lines.png"))); // NOI18N
        menuCheckBoxToggleLines.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCheckBoxToggleLinesActionPerformed(evt);
            }
        });
        jMenu1.add(menuCheckBoxToggleLines);
        jMenu1.add(jSeparator5);

        menuSurround.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/images/small-icons/surround-with.png"))); // NOI18N
        menuSurround.setText("Surround With");
        menuSurround.setFont(new java.awt.Font("Microsoft YaHei", 0, 14));
        menuSurround.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSurroundActionPerformed(evt);
            }
        });

        menuItemSurroundWhile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_MASK));
        menuItemSurroundWhile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/images/small-icons/surround-while.png"))); // NOI18N
        menuItemSurroundWhile.setText("Surround while");
        menuItemSurroundWhile.setFont(new java.awt.Font("Microsoft YaHei", 0, 14));
        menuItemSurroundWhile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSurroundWhileActionPerformed(evt);
            }
        });
        menuSurround.add(menuItemSurroundWhile);

        menuItemSurrondIf.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        menuItemSurrondIf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/images/small-icons/surround-if.png"))); // NOI18N
        menuItemSurrondIf.setText("Surround if");
        menuItemSurrondIf.setFont(new java.awt.Font("Microsoft YaHei", 0, 14));
        menuItemSurrondIf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSurrondIfActionPerformed(evt);
            }
        });
        menuSurround.add(menuItemSurrondIf);

        menuItemSurrondTry.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        menuItemSurrondTry.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/images/small-icons/surround-try.png"))); // NOI18N
        menuItemSurrondTry.setText("Surround try");
        menuItemSurrondTry.setFont(new java.awt.Font("Microsoft YaHei", 0, 14));
        menuItemSurrondTry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSurrondTryActionPerformed(evt);
            }
        });
        menuSurround.add(menuItemSurrondTry);

        jMenu1.add(menuSurround);

        jMenuBar1.add(jMenu1);
        menuHelp.setText("Help");
        menuHelp.setFont(new java.awt.Font("Microsoft YaHei", 0, 14)); // NOI18N

        menuItemAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/about.png"))); // NOI18N
        menuItemAbout.setText("About");
        menuItemAbout.setFont(new java.awt.Font("Microsoft YaHei", 0, 14));
        menuItemAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemAboutActionPerformed(evt);
            }
        });
        menuHelp.add(menuItemAbout);

        jMenuBar1.add(menuHelp);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 1057, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Run, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Compile, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                            .addComponent(Save, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Open, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(New, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(New, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addComponent(Open, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(Save, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(Compile, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(Run, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane5)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>

    private void NewActionPerformed(java.awt.event.ActionEvent evt) {                                    
        newFile();
    }                                   

    private void RunActionPerformed(java.awt.event.ActionEvent evt) {                                    
          runp(classname,f);
    }                                   

    private void ProgramAreaFocusGained(java.awt.event.FocusEvent evt) {                                        
        
    }                                       

    private void OpenActionPerformed(java.awt.event.ActionEvent evt) {                                     
         openFile();
    }                                    

    
        private void SaveActionPerformed(java.awt.event.ActionEvent evt) {                                     
       save();
        Compile.setEnabled(true);
        Run.setEnabled(false);
    }                                    

          
        private void CompileActionPerformed(java.awt.event.ActionEvent evt) {                                        
       if((FileName.length()<=0))
        {
           JOptionPane.showMessageDialog(null,"Save the file first");
           saveAs();
        }
                    else{
                    if(FileName.endsWith(".java")){
                    String fnt=path.replace(FileName," ");
                     f=new File(fnt);
                    File file = new File(FileName);
                    String filename = file.getName();
                     classname = filename.substring(0, filename.length()-5);
                    try{
   Runtime rt=Runtime.getRuntime();
   Process p=rt.exec("javac -d . "+filename,null,f);
   InputStream is=p.getErrorStream();
   int x=-1;
   String emsg="";
   while((x=is.read())!=-1)
    emsg=emsg+(char)x;
   if(emsg.equals(""))
   {
       MessageArea.setText("Compiled Successfully");
       Run.setEnabled(true);
   }
   else
   {
    MessageArea.setText(emsg);
    emsg=emsg.substring(0,4);
    if(emsg.equals("Note")){
        Run.setEnabled(true);
       }}
   p.destroy();
                    }
                    catch(Exception e)
                    {
                        System.err.println(e);
                    }
		}
                    else
                    {
                        JOptionPane.showMessageDialog(this,"This is not a java file", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    }
    }                                       

    private void menuItemNewActionPerformed(java.awt.event.ActionEvent evt) {
       newFile();
    }

    private void menuItemOpenActionPerformed(java.awt.event.ActionEvent evt) {
        openFile();
    }

    private void menuItemSaveActionPerformed(java.awt.event.ActionEvent evt) {
     save();
    }

    private void menuItemSaveAsActionPerformed(java.awt.event.ActionEvent evt) {
      saveAs();
    }

    private void menuItemExitWindowActionPerformed(java.awt.event.ActionEvent evt) {
        if(JOptionPane.showConfirmDialog(this,
				"Unsaved document will be lost. Are you sure you want to exit?",
				"JNote-IDE", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			System.gc();
        setVisible(false);
    }}

    private void menuItemExitJNoteActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }
    private void menuItemFindActionPerformed(java.awt.event.ActionEvent evt) {
      try {
    Robot robot = new Robot();
    // Simulate a key press
    robot.keyPress(KeyEvent.VK_CONTROL);
    robot.keyPress(KeyEvent.VK_F);
    robot.keyRelease(KeyEvent.VK_CONTROL);
    robot.keyRelease(KeyEvent.VK_F);
} catch (AWTException e) {
    e.printStackTrace();
}  
    }
    
    private void menuItemFindReplaceActionPerformed(java.awt.event.ActionEvent evt) {                                                    
         try {
    Robot robot = new Robot();
    // Simulate a key press
    robot.keyPress(KeyEvent.VK_CONTROL);
    robot.keyPress(KeyEvent.VK_H);
    robot.keyRelease(KeyEvent.VK_CONTROL);
    robot.keyRelease(KeyEvent.VK_H);
} catch (AWTException e) {
    e.printStackTrace();
}  
    }                                                   

    private void menuItemToggleCommentsActionPerformed(java.awt.event.ActionEvent evt) {                                                       
         try {
    Robot robot = new Robot();
    // Simulate a key press
    robot.keyPress(KeyEvent.VK_CONTROL);
    robot.keyPress(KeyEvent.VK_SLASH);
    robot.keyRelease(KeyEvent.VK_CONTROL);
    robot.keyRelease(KeyEvent.VK_SLASH);
} catch (AWTException e) {
    e.printStackTrace();
}  
    }                                                      

    private void menuItemSurrondTryActionPerformed(java.awt.event.ActionEvent evt) {                                                   
         try {
    Robot robot = new Robot();
    robot.keyPress(KeyEvent.VK_CONTROL);
    robot.keyPress(KeyEvent.VK_T);
    robot.keyRelease(KeyEvent.VK_CONTROL);
    robot.keyRelease(KeyEvent.VK_T);
} catch (AWTException e) {
    e.printStackTrace();
}  
    }                                                  

    private void menuItemFindNextActionPerformed(java.awt.event.ActionEvent evt) {                                                 
         try {
    Robot robot = new Robot();
    // Simulate a key press
    robot.keyPress(KeyEvent.VK_F3);
    robot.keyRelease(KeyEvent.VK_F3);
} catch (AWTException e) {
    e.printStackTrace();
}  
    }                                                

    private void menuItemSelectAllActionPerformed(java.awt.event.ActionEvent evt) {                                                  
         try {
    Robot robot = new Robot();
    // Simulate a key press
    robot.keyPress(KeyEvent.VK_CONTROL);
    robot.keyPress(KeyEvent.VK_A);
    robot.keyRelease(KeyEvent.VK_CONTROL);
    robot.keyRelease(KeyEvent.VK_A);
} catch (AWTException e) {
    e.printStackTrace();
}  
    }                                                 

    private void menuItemGoToActionPerformed(java.awt.event.ActionEvent evt) {                                             
        try {
    Robot robot = new Robot();
    // Simulate a key press
    robot.keyPress(KeyEvent.VK_CONTROL);
    robot.keyPress(KeyEvent.VK_G);
    robot.keyRelease(KeyEvent.VK_CONTROL);
    robot.keyRelease(KeyEvent.VK_G);
} catch (AWTException e) {
    e.printStackTrace();
}  
    }                                            

    private void menuItemUndoActionPerformed(java.awt.event.ActionEvent evt) {                                             
        try {
    Robot robot = new Robot();
    // Simulate a key press
    robot.keyPress(KeyEvent.VK_CONTROL);
    robot.keyPress(KeyEvent.VK_Z);
    robot.keyRelease(KeyEvent.VK_CONTROL);
    robot.keyRelease(KeyEvent.VK_Z);
} catch (AWTException e) {
    e.printStackTrace();
}  
    }                                            

    private void menuItemRedoActionPerformed(java.awt.event.ActionEvent evt) {                                             
         try {
    Robot robot = new Robot();
    // Simulate a key press
    robot.keyPress(KeyEvent.VK_CONTROL);
    robot.keyPress(KeyEvent.VK_Y);
    robot.keyRelease(KeyEvent.VK_CONTROL);
    robot.keyRelease(KeyEvent.VK_Y);
} catch (AWTException e) {
    e.printStackTrace();
}  
    }                                            

    private void menuItemIndentActionPerformed(java.awt.event.ActionEvent evt) {                                               
         try {
    Robot robot = new Robot();
    // Simulate a key press
    robot.keyPress(KeyEvent.VK_TAB);
    robot.keyRelease(KeyEvent.VK_TAB);
} catch (AWTException e) {
    e.printStackTrace();
}  
    }                                              

    private void menuItemUnindentActionPerformed(java.awt.event.ActionEvent evt) {                                                 
         try {
    Robot robot = new Robot();
    // Simulate a key press
    robot.keyPress(KeyEvent.VK_SHIFT);
    robot.keyPress(KeyEvent.VK_TAB);
    robot.keyRelease(KeyEvent.VK_SHIFT);
    robot.keyRelease(KeyEvent.VK_TAB);
} catch (AWTException e) {
    e.printStackTrace();
}  
    }                                                

    private void menuCheckBoxToggleLinesActionPerformed(java.awt.event.ActionEvent evt) {                                                        
        try {
    Robot robot = new Robot();
    // Simulate a key press
    robot.keyPress(KeyEvent.VK_CONTROL);
    robot.keyPress(KeyEvent.VK_F2);
    robot.keyRelease(KeyEvent.VK_CONTROL);
    robot.keyRelease(KeyEvent.VK_F2);
    robot.keyPress(KeyEvent.VK_TAB);
    robot.keyRelease(KeyEvent.VK_TAB);
    
} catch (AWTException e) {
    e.printStackTrace();
}  
    }                                                       

    private void menuItemSurroundWhileActionPerformed(java.awt.event.ActionEvent evt) {                                                      
         try {
    Robot robot = new Robot();
    // Simulate a key press
    robot.keyPress(KeyEvent.VK_CONTROL);
    robot.keyPress(KeyEvent.VK_W);
    robot.keyRelease(KeyEvent.VK_CONTROL);
    robot.keyRelease(KeyEvent.VK_W);
} catch (AWTException e) {
    e.printStackTrace();
}  
    }                                                     

    private void menuItemSurrondIfActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        try {
    Robot robot = new Robot();
    // Simulate a key press
    robot.keyPress(KeyEvent.VK_CONTROL);
    robot.keyPress(KeyEvent.VK_I);
    robot.keyRelease(KeyEvent.VK_CONTROL);
    robot.keyRelease(KeyEvent.VK_I);
} catch (AWTException e) {
    e.printStackTrace();
}  
    }                                                 

    private void menuSurroundActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }
    private void menuItemAboutActionPerformed(java.awt.event.ActionEvent evt) {
        about.setLocationRelativeTo(this);
			about.showDialog();
    }
private void save()
        {
		if (getTitle().equals("Untitled-JNoteIDE")) {
                   
			saveAs();
		}
		else {
			try {
				printWriter = new PrintWriter(new File(path));
				printWriter.println(ProgramArea.getText());
				printWriter.flush();
				printWriter.close();
                                setTitle(path+" JNote-ide");
			}
			catch (Exception exc) {
				exc.printStackTrace();
			}
		}
	}
	
	private void saveAs() {
		fileChooser.setDialogTitle("Save As");
		fileChooser.setMultiSelectionEnabled(false);
		
		if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			
			try {
                            if(file.getName().endsWith(".java")){
				printWriter = new PrintWriter(file);
				printWriter.println(ProgramArea.getText());
				printWriter.flush();
				printWriter.close();
				
                                FileName=fileChooser.getSelectedFile().getName();
                                path=fileChooser.getSelectedFile().getPath();
			}
                            else
                            {
                                printWriter = new PrintWriter(file+".java");
				printWriter.println(ProgramArea.getText());
				printWriter.flush();
				printWriter.close();
				
                                FileName=fileChooser.getSelectedFile().getName()+".txt";
                                path=fileChooser.getSelectedFile().getPath();
                            }
                        }
			catch (Exception exc) {
				JOptionPane.showMessageDialog(this, exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
                        setTitle(path+" JNote-ide");
		}
	}
        
    private void menuItemCutActionPerformed(java.awt.event.ActionEvent evt) {
                    try {
    Robot robot = new Robot();
    // Simulate a key press
    robot.keyPress(KeyEvent.VK_CONTROL);
    robot.keyPress(KeyEvent.VK_X);
    robot.keyRelease(KeyEvent.VK_CONTROL);
    robot.keyRelease(KeyEvent.VK_X);
} catch (AWTException e) {
    e.printStackTrace();
}        // TODO add your handling code here:
    }

    private void menuItemCopyActionPerformed(java.awt.event.ActionEvent evt) {
        try {
    Robot robot = new Robot();
    // Simulate a key press
    robot.keyPress(KeyEvent.VK_CONTROL);
    robot.keyPress(KeyEvent.VK_C);
    robot.keyRelease(KeyEvent.VK_CONTROL);
    robot.keyRelease(KeyEvent.VK_C);
} catch (AWTException e) {
    e.printStackTrace();
    }
    }

    private void menuItemPasteActionPerformed(java.awt.event.ActionEvent evt) {
         try {
    Robot robot = new Robot();
    // Simulate a key press
    robot.keyPress(KeyEvent.VK_CONTROL);
    robot.keyPress(KeyEvent.VK_V);
    robot.keyRelease(KeyEvent.VK_CONTROL);
    robot.keyRelease(KeyEvent.VK_V);
} catch (AWTException e) {
    e.printStackTrace();
}        // TODO add your handling code here:
    }
          
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JNote_ide.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JNote_ide.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JNote_ide.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JNote_ide.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new JNote_ide().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify
    private javax.swing.JButton Compile;
    private javax.swing.JTextArea MessageArea;
    private javax.swing.JButton New;
    private javax.swing.JButton Open;
    private javax.swing.JEditorPane ProgramArea;
    private javax.swing.JButton Run;
    private javax.swing.JButton Save;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    
    private javax.swing.JMenuItem menuItemExitJNote;
    private javax.swing.JMenuItem menuItemExitWindow;
    private javax.swing.JMenu menuItemNew;
    private javax.swing.JMenuItem menuItemOpen;
    private javax.swing.JMenuItem menuItemSave;
    private javax.swing.JMenuItem menuItemSaveAs;
    private javax.swing.JMenuItem menuItemCopy;
    private javax.swing.JMenuItem menuItemCut;
    private javax.swing.JMenuItem menuItemPaste;
    private javax.swing.JMenuItem menuItemUndo;
    private javax.swing.JMenuItem menuItemRedo;
     private javax.swing.JMenuItem menuItemFind;
     private javax.swing.JMenuItem menuItemFindNext;
    private javax.swing.JMenuItem menuItemFindReplace;
    private javax.swing.JMenuItem menuItemGoTo;
    private javax.swing.JMenuItem menuItemSelectAll;
    
    private javax.swing.JMenuItem menuItemIndent;
     private javax.swing.JMenuItem menuItemSurrondIf;
    private javax.swing.JMenuItem menuItemSurrondTry;
    private javax.swing.JMenuItem menuItemSurroundWhile;
    private javax.swing.JMenuItem menuItemToggleComments;
    private javax.swing.JMenuItem menuItemUnindent;
    private javax.swing.JMenu menuSurround;
    private javax.swing.JCheckBoxMenuItem menuCheckBoxToggleLines;
    
     private javax.swing.JMenu menuHelp;
    private javax.swing.JMenuItem menuItemAbout;
    // End of variables declaration
String path;
String FileName;
String classname="";
private static JFileChooser fileChooser = new JFileChooser();
private static About about = new About();
private static PrintWriter printWriter;
File f;
    private void runp(String classname, File f) {
    {
        try
        {
   String cmdarray[]={"cmd", "/k", "start","cmd","/k","java",classname};
   Runtime.getRuntime().exec(cmdarray, null, f);
    }catch(Exception e)
    {
        System.err.println(e);
    }
}
    }
    private void newFile() {
        try
        {
          ProgramArea.setText("");
	  MessageArea.setText("");
	  setTitle("Untitled-JNoteIDE");
	  path="";
	  FileName="";
	  Compile.setEnabled(false);
	  Run.setEnabled(false);
        }
        catch(Exception e)
        {
           System.err.println(e.getMessage()) ;
        }
    }

    private void openFile() {
                fileChooser.setDialogTitle("Open");
		fileChooser.setMultiSelectionEnabled(false);
                if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                File file = fileChooser.getSelectedFile();
                                            String tempText = "";
                                            Scanner scanner = new Scanner(file);
                                            setTitle(file.getName());
                                            FileName = file.getName();
                                            path = file.getAbsolutePath();
                                            while (scanner.hasNextLine()) {
                                                    tempText += scanner.nextLine() + "\n";
                                            }
                                            ProgramArea.setText(tempText);
                                            scanner.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(JNote_ide.class.getName()).log(Level.SEVERE, null, ex);
            }
                }
                Compile.setEnabled(true);
                Run.setEnabled(true);
                setTitle(path+"  JNote-IDE");
    }
        }
