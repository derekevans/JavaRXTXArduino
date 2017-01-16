/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serialtest;

/**
 *
 * @author derekevans
 */
import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import gnu.io.UnsupportedCommOperationException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.TooManyListenersException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.ListModel;

/**
 *
 * @author derekevans
 */
public class Serial {
    
    private SerialPort serialPort;
    private PrintWriter pw;
    private BufferedReader br;
    private PrintWriter filepw = null;
    
    private Thread write;
    private Thread read;
    private Thread reads;
    
    public String in = new String();
    
    public DefaultListModel listPorts() {
        ArrayList portID = new ArrayList();
        java.util.Enumeration<CommPortIdentifier> portEnum = CommPortIdentifier.getPortIdentifiers();
        while (portEnum.hasMoreElements()) {
            CommPortIdentifier portIdentifier = portEnum.nextElement();
            if (portIdentifier.PORT_SERIAL == 1) {
                String portName = portIdentifier.getName();
                //for Mac
                /*if (portName.contains("/dev/tty.usbmodem")) {
                    portID.add(portName);
                }*/
                
                //for PC
                /*if (portName.contains("COM3")) {
                    portID.add(portName);
                }*/
                portID.add(portName);
            }
        }
        DefaultListModel lm = new DefaultListModel();
        for(int i=0;i<portID.size();i++) {
            lm.addElement(portID.get(i));
        }
        return lm;
    }
//Connect to the port that has the Arduino.     

    public void connect(String portName, int baudRate) {
        try {
            // Obtain a CommPortIdentifier object for the port you want to open
                CommPortIdentifier portId = CommPortIdentifier.getPortIdentifier(portName);
                // Get the port's ownership
                serialPort = (SerialPort) portId.open("ArduinoUno", 2000);
                // Set the parameters of the connection.
                serialPort.setSerialPortParams(baudRate, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
                serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_NONE);
                
        } catch (NoSuchPortException e) {
            if (serialPort != null) {
                serialPort.close();
            }
            e.printStackTrace();
        } catch (PortInUseException e) {
            if (serialPort != null) {
                serialPort.close();
            }
            e.printStackTrace();
            System.out.println(serialPort);
            System.out.println("closing serial port");
        } catch (UnsupportedCommOperationException ex) {
            if (serialPort != null) {
                serialPort.close();
            }
            ex.printStackTrace();
        }
    }
    
    //Initialize input and output streams for the connected port.    
    public boolean initIOStream() {
        try {
            if (serialPort != null) {
                pw = new PrintWriter(serialPort.getOutputStream(), true);
                br = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
                return true;
            }
        } catch (IOException e) {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException ex) {
                    Logger.getLogger(Serial.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (pw != null) {
                try {
                    pw.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
        }
        return false;
    }
    public void writeLine(String command, boolean println) {
        write = new Thread(serialWrite(command,println));
        try{
            
            write.start();
            write.join();
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Serial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void readLine(String command, boolean println) {
        write = new Thread(serialWrite(command,println));
        read = new Thread(serialReadLine());
        try{
            
            write.start();
            write.join();
            read.start();
            read.join(3000); //wait 3 seconds for thread to finish
            read = null; //stops thread if still running
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Serial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void writeToFile(String command, boolean println, String file) {
        
        write = new Thread(serialWrite(command,println));
        reads = new Thread(serialWriteToFile(file));
        try{
            
            write.start();
            write.join();
            reads.start();
            reads.join(); 
            reads = null; //stops thread if still running
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Serial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private Runnable serialWrite(String out, boolean println) {
        return new Runnable(){
            public void run() {
                try {
                    if (!println) {
                        pw.print(out);
                        pw.flush();
                    } else {
                        pw.println(out);
                        pw.flush();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
    }
    
    private Runnable serialReadLine() {
        return new Runnable() {
            public void run() {
                try {
                    in = null;
                    Thread thisThread = Thread.currentThread();
                    while(!br.ready() && read == thisThread){
                    }
                    
                    in = br.readLine();
                } catch (IOException ex) {
                    Logger.getLogger(Serial.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
    }
    
    private Runnable serialWriteToFile(String file) {
        return new Runnable() {
            public void run() {
                try {
                    filepw = new PrintWriter(file);
                    filepw.println("Variable1,Variable2,Variable3");
                    filepw.flush();
                    in = null;

                    try {
                        Thread thisThread = Thread.currentThread();
                        while (!br.ready() && reads == thisThread) {
                        }
                        //write to file until input is "end"
                        while (!(in = br.readLine()).equals("end") && reads == thisThread) {
                            filepw.println(in);
                            filepw.flush();
                            System.out.println(in);
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(Serial.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Serial.class.getName()).log(Level.SEVERE, null, ex);
                } 
            }
        };
    }
    
    public void disconnect() {
        try {
            if (serialPort != null) {
                serialPort.close();
                serialPort = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (br != null) {
                br.close();
                br = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (pw != null) {
                pw.close();
                pw = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
