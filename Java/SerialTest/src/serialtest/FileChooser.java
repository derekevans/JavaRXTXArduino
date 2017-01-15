/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serialtest;

import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author derekevans
 */
public class FileChooser {
    public String chooseFile() {
            String file = null;
            try {
                JFileChooser chooser = new JFileChooser();
                //filter by .csv
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Comma Delimited Files", "csv");
                chooser.setFileFilter(filter);
                
                //0=ok, 1=cancel, -1=exit
                int returnVal = chooser.showSaveDialog(null);

                //if return val = 0
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    //make sure the file selected or input has .csv extension
                    file = chooser.getSelectedFile().toString();
                    file = replaceExtension(file,"csv"); 
                    File chosenSelection = new File(file);
                    //if file exist show dialog that confirms overwrite
                    if (chosenSelection.exists()) {
                        int result = JOptionPane.showConfirmDialog(null, "The file exists, overwrite?", "Existing file", JOptionPane.YES_NO_OPTION);
                        //if users chooses cancel or exit return null file string
                        switch (result) {
                            case 1:
                                file = null;
                                break;
                            case -1:
                                file = null;
                                break;
                        }
                    } 
                }
            } catch (Exception e) {
                e.printStackTrace();
            } 
            return file;
        }
    
    private ArrayList splitExtension(String file) {
        ArrayList al = new ArrayList();
        int i = file.lastIndexOf('.');
        //if i > 0, then has extension
        if (i > 0) {
            al.add(file.substring(i+1));
            al.add(file.substring(0,i));
        } else {
            al.add(file);
        }
        return al;
    }
    
    //replace file path extension with user input extension
    private String replaceExtension(String file, String extension) {
        ArrayList fileExt = splitExtension(file);
        if(fileExt.size()>=2) {
            return fileExt.get(1).toString() + "." + extension;
        } else {
            return fileExt.get(0).toString() + "." + extension;
        }
    }
}
