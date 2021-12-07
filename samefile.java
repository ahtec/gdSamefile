package gdsamefile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class samefile extends javax.swing.JFrame
{

    public static boolean recursief;
    public static Vector filesInDirectory;
    public static Vector needles;
    public static int searchDepht = 3000;
    public static String zoekfilestr;
    public static String argumenten[];
    static int aantalgevonden, aantalDoorzocht;
    public static String versie = "7 dec  2021";

    private static boolean filesAreEqual(File files) throws IOException
    {
        boolean out = false;

        FileInputStream fisa = new FileInputStream(files);
        FileInputStream fisb = new FileInputStream(new File(zoekfilestr));
//        int c;
        byte[] byteA;
        byte[] byteB;
//        byte[] byteT;
        byteA = new byte[searchDepht];
        byteB = new byte[searchDepht];
//        byteT = new byte[1048];
        fisa.read(byteA);
        fisb.read(byteB);
//        System.out.println("byteA.length");
//        System.out.print(byteA.length);
//        System.out.print(" inhoud");
//        System.out.print(byteA);
//        System.out.print(" byteB.length");
//        System.out.print(byteB.length);
//        System.out.print(" inhoud");
//        System.out.print(byteB);

        if (java.util.Arrays.equals(byteA, byteB))
        {
            out = true;
//            System.out.println(zoekfilestr + " " + files.getCanonicalPath()+   " zijn gelijk");

        } else
        {
//            System.out.println(zoekfilestr + " ongelijk aan: " + files.getCanonicalPath()   );

        }
        fisa.close();
        fisb.close();
        return out;

    }

    public samefile()
    {
        initComponents();

        new FileDrop(inputFileString, new FileDrop.Listener()
        {
            public void filesDropped(java.io.File[] files)
            {
                inputFileString.setText(files[0].getAbsolutePath());
//                System.out.println("file Dropped()" + files[0].getAbsolutePath());
            }   // end filesDropped
        }); // end FileDrop.Listener
        new FileDrop(inputDirString, new FileDrop.Listener()
        {
            public void filesDropped(java.io.File[] files)
            {
                inputDirString.setText(files[0].getAbsolutePath());
//                System.out.println("dis Dropped()");
            }   // end filesDropped
        }); // end FileDrop.Listener
        recursief = Boolean.TRUE;
        if (argumenten.length == 2)
        {
            inputDirString.setText(argumenten[1]);
            inputFileString.setText(argumenten[0]);
        } else
        {
//            inputDirString.setText("/Users/gerard/Pictures/2021/02");
//            inputFileString.setText("/Users/gerard/_DSC6100.png");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        inputFileString = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        inputDirString = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        fileChooser = new javax.swing.JButton();
        dirChooser = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("run");
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }
        });

        inputFileString.setColumns(20);
        inputFileString.setRows(5);
        jScrollPane1.setViewportView(inputFileString);

        inputDirString.setColumns(20);
        inputDirString.setRows(5);
        jScrollPane2.setViewportView(inputDirString);

        jButton2.setLabel("quit");
        jButton2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton2ActionPerformed(evt);
            }
        });

        fileChooser.setLabel("File");
        fileChooser.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                fileChooserActionPerformed(evt);
            }
        });

        dirChooser.setLabel("Dir");
        dirChooser.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                dirChooserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(fileChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(dirChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 701, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fileChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dirChooser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
    {//GEN-HEADEREND:event_jButton1ActionPerformed
        filesInDirectory = new Vector();
        needles = new Vector();
        zoekfilestr = inputFileString.getText();
        File zoekFiles = new File(zoekfilestr);
        if (zoekFiles.isDirectory())
        {
            //als de input file een dir is dan loop over alle images in de directory
            // gebruik zoekfistr als waarde die ingevuld wordt
            //begin loop over files in dir 
            for (File zoekFile : zoekFiles.listFiles())
            {
                if (isImage(zoekFile))
                {
                    zoekfilestr = zoekFile.getAbsolutePath();
                    System.out.println("needle = " + zoekfilestr);
//                System.out.println("haystack= " + inputDirString.getText());
                    aantalgevonden = 0;
                    aantalDoorzocht = 0;
                    checkFilesRecursive(new File(inputDirString.getText()));
                }
                // endloop
            }

        } else
        {
            zoekfilestr = inputFileString.getText();
            System.out.println("needle = " + zoekfilestr);
            System.out.println("haystack= " + inputDirString.getText());
            aantalgevonden = 0;
            aantalDoorzocht = 0;
            checkFilesRecursive(new File(inputDirString.getText()));

        }
        if (aantalgevonden == 0)
        {
            JOptionPane.showMessageDialog(null, "Geen imgages gevonden, doorzocht " + aantalDoorzocht, versie, 1);
        } else
        {
            JOptionPane.showMessageDialog(null, aantalDoorzocht + " doorzocht, gevonden " + aantalgevonden, versie, 1);

        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton2ActionPerformed
    {//GEN-HEADEREND:event_jButton2ActionPerformed
        System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void fileChooserActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_fileChooserActionPerformed
    {//GEN-HEADEREND:event_fileChooserActionPerformed
//        String eruit = "";
        JFileChooser fc = new JFileChooser();
        fc.setCurrentDirectory(new File(inputFileString.getText()));

//        if (recursief)
//        {
//            fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
//        } else
//        {
        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
//        FileNameExtensionFilter filter = new FileNameExtensionFilter(
//                "JPG & GIF Images", "jpg", "gif", "png", "jpeg", "tiff");
//        fc.setFileFilter(filter);
//        }
        int returnVal = fc.showOpenDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION)
        {
            try
            {
                File file = fc.getSelectedFile();
                inputFileString.setText(file.getCanonicalPath());
            } catch (IOException ex)
            {
//                java.util.logging.Logger.getLogger(samefile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_fileChooserActionPerformed

    private void dirChooserActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_dirChooserActionPerformed
    {//GEN-HEADEREND:event_dirChooserActionPerformed

//        String eruit = "";
        JFileChooser fc = new JFileChooser();
        fc.setCurrentDirectory(new File(inputDirString.getText()));
//        if (recursief)
//        {
//            fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

//        } else
//        {
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
//        FileNameExtensionFilter filter = new FileNameExtensionFilter(
//                "JPG & GIF Images", "jpg", "gif", "png", "jpeg", "tiff");
//        fc.setFileFilter(filter);
//        }
        int returnVal = fc.showOpenDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION)
        {
            try
            {
                File file = fc.getSelectedFile();
                inputDirString.setText(file.getCanonicalPath());
            } catch (IOException ex)
            {
                java.util.logging.Logger.getLogger(samefile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_dirChooserActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(samefile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(samefile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(samefile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(samefile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
//                if (args.length == 2)
//                {
                argumenten = args;
//                    inputDirString.setText(args[0]);

//                }
                new samefile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton dirChooser;
    private javax.swing.JButton fileChooser;
    private javax.swing.JTextArea inputDirString;
    private javax.swing.JTextArea inputFileString;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

    private static void getFilesInDirectory(File pFile)
    {
        for (File files : pFile.listFiles())
        {
            if (files.isDirectory())
            {
                // doen we nix mee
            } else
            {
                if (isImage(files))
                {

                }

            }

        }
    }

    private static void checkFilesRecursive(File pFile)

    {
        for (File files : pFile.listFiles())
        {
            {
                if (files.isDirectory())
                {
                    if (recursief)
                    {
                        checkFilesRecursive(files);
                    }
                } else
                {

                    if (isImage(files))
                    {
                        aantalDoorzocht++;
                        try
                        {
                            //                    filesInDirectory.addElement(files);
                            if (filesAreEqual(files))
                            {
                                System.out.println("gdView.sh " + files.getCanonicalPath());

                                aantalgevonden++;
                            } else
                            {
//                            System.out.println("NOT " + files.getCanonicalPath());
                            }
                        } catch (IOException ex)
                        {
//                        System.out.println("checkFiles"+  ex.toString());
//                        java.util.logging.Logger.getLogger(samefile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                        }
                    }
                }
            }

        }
    }

    static boolean isImage(File erin)
    {

        //        System.out.println("gdview.viewClass.isImage()" + erin.getAbsolutePath());
        Boolean eruit = Boolean.FALSE;
        try
        {
//            Path target = Path.of(erin.getCanonicalPath());
//            if (Files.isSymbolicLink(target))
//            {

            String naamFile = erin.getName();
            if (naamFile.lastIndexOf(".") > 0)
            {

//                String extension = erin.getName().substring(erin.getName().lastIndexOf("."));
                String extension = naamFile.substring(naamFile.lastIndexOf("."));
                if (extension.toLowerCase().contains(".png"))
                {
                    eruit = Boolean.TRUE;
                } else
                {
                    if (extension.toLowerCase().contains(".jpg"))
                    {
                        eruit = Boolean.TRUE;
                    } else
                    {
                        if (extension.toLowerCase().contains(".jpeg"))
                        {
                            eruit = Boolean.TRUE;
                        } else
                        {
                            if (extension.toLowerCase().contains(".tiff"))
                            {
                                eruit = Boolean.TRUE;
                            } else
                            {
                                if (extension.toLowerCase().contains(".gif"))
                                {
                                    eruit = Boolean.TRUE;
                                }

                            }
                        }
                    }
                }
            }
//            }
        } catch (java.lang.StringIndexOutOfBoundsException e)
        {
            System.out.println("gdview.viewClass.getFilesInDirectory() out of bounds exception " + e.toString());

        }
//        catch (IOException ex)
//        {
//            System.out.println("gdsamefile.samefile.isImage() io exception " + ex.toString());
//                    Logger.getLogger(viewClass.class.getName()).log(Level.SEVERE, null, ex);
//        }

        return eruit;
    }
}
