package br.inatel.fetin.fetindoctor.serial;

import gnu.io.CommPortIdentifier;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import gnu.io.UnsupportedCommOperationException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Enumeration;
import java.util.TooManyListenersException;

import javax.swing.JOptionPane;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

/**
 * 
 * @author Bruno Monti
 */


public class SerialComm implements SerialPortEventListener{

	
	private OutputStream outputStream;
	private InputStream inputStream;
	private ByteArrayOutputStream byteArrayOutputStream;
	private SerialListener listener;
	String dado;

	public SerialComm(SerialListener listener) {
		this.listener = listener;
	}
	
	public void executeSerialPort() {

		String portName = getPortNameByOS();

		CommPortIdentifier portId = getPortIdentifier(portName);

		if (portId != null) {

			try {
				// Abrindo porta serial
				SerialPort serialPort = (SerialPort) portId.open(this
						.getClass().getName(), 9600);

				inputStream = serialPort.getInputStream();
				outputStream = serialPort.getOutputStream();

				serialPort.addEventListener(this);

				serialPort.notifyOnDataAvailable(true);

				serialPort.setSerialPortParams(9600, SerialPort.DATABITS_8,
						SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);

			} catch (PortInUseException e) {
				System.out.println("Porta em uso");
			}

			catch (IOException e) {
			}

			catch (UnsupportedCommOperationException e) {
				e.printStackTrace();
			} catch (TooManyListenersException e) {
			}

		} else {
			System.out.println("Porta Serial não disponível");
		}
	}

	private String getPortNameByOS() {

		String osname = System.getProperty("os.name", "").toLowerCase();
		if (osname.startsWith("windows")) {
			// windows
			return "COM4";
		} else if (osname.startsWith("linux")) {
			// linux
			return "/dev/ttyS0";
		} else if (osname.startsWith("mac")) {
			// mac
			return "???";
		} else {
			System.out.println("Sorry, your operating system is not supported");
			System.exit(1);
			return null;
		}

	}

	private CommPortIdentifier getPortIdentifier(String portName) {

		Enumeration portList = CommPortIdentifier.getPortIdentifiers();
		Boolean portFound = false;
		while (portList.hasMoreElements()) {
			CommPortIdentifier portId = (CommPortIdentifier) portList
					.nextElement();

			if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL) {
				System.out.println("Available port: " + portId.getName());
				if (portId.getName().equals(portName)) {
					System.out.println("Found port: " + portName);
					portFound = true;
					return portId;
				}
			}

		}

		return null;

	}

	public void serialEvent(SerialPortEvent event) {

		StringBuffer bufferLeitura = new StringBuffer();

		int novoDado = 0;

		switch (event.getEventType()) {

		case SerialPortEvent.BI:

		case SerialPortEvent.OE:

		case SerialPortEvent.FE:

		case SerialPortEvent.PE:

		case SerialPortEvent.CD:

		case SerialPortEvent.CTS:

		case SerialPortEvent.DSR:

		case SerialPortEvent.RI:

		case SerialPortEvent.OUTPUT_BUFFER_EMPTY:
			break;

		case SerialPortEvent.DATA_AVAILABLE:

			while (novoDado != -1) {
				try {
					novoDado = inputStream.read();
					if (novoDado == -1) {
						break;
					}
					if ('\r' == (char) novoDado) {
						bufferLeitura.append('\n');
					} else {
						bufferLeitura.append((char) novoDado);
					}
				} catch (IOException ioe) {
					System.out.println("Erro de leitura serial: " + ioe);
				}
			}
			setDado(new String(bufferLeitura));
			recebeuDado();
			break;
		}

	}

	public void sendFrame(byte[] frame) {

		try {
			outputStream.write(frame);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void sendData(byte dado) {

		try {
			outputStream.write(dado);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void sendInt(int dado){
		try {
			outputStream.write(dado);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void sendFrame(Byte valueOf) {
		
		try {
			outputStream.write(valueOf);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void close() {
		try {
			outputStream.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,
					"Não foi possível fechar porta COM.", "Fechar porta COM",
					JOptionPane.PLAIN_MESSAGE);
		}
	}

	public void recebeuDado() {
		String dado = getDado();
		if (dado != null) {
			//System.out.print(getDado());
			listener.updateField(getDado());

		}
	}

	public String getDado() {
		return dado;
	}

	public void setDado(String dado) {
		this.dado = dado;
	}

	public void sendInteger(Integer valueOf) {
		try {
			outputStream.write(valueOf);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void sendByte(Byte data){
		byteArrayOutputStream.write(data);
	}

	public void sendByte(char c) {
		try {
			outputStream.write(c);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
