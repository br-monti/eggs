package br.inatel.fetin.fetindoctor.session;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.log.Log;
import org.jboss.seam.security.Credentials;
import org.jboss.seam.security.Identity;

import br.inatel.fetin.fetindoctor.serial.SerialComm;
import br.inatel.fetin.fetindoctor.serial.SerialListener;

@Name("authenticator")
@Scope(ScopeType.SESSION)
public class Authenticator implements SerialListener
{
	@Logger private Log log;

	@In Identity identity;
	@In Credentials credentials;

	private String dataSerial;
	private boolean enableButton = true;
	private boolean enableAuthenticate = false;

	private SerialComm serial = null;

	public boolean authenticate()
	{
		log.info("authenticating {0}", credentials.getUsername());

		if (("admin".equals(credentials.getUsername())) && ("admin".equals(credentials.getPassword())))
		{
			identity.addRole("admin");
			return true;
		}
		return false;        

	}

	public void openSerial(){

		System.out.println("---ABRINDO SERIAL---");
		serial = new SerialComm(this);
		serial.executeSerialPort();

	}	
	
	

	public String getDataSerial() {
		return dataSerial;
	}

	public void setDataSerial(String dataSerial) {
		this.dataSerial = dataSerial;
	}

	public void updateField(String value) {
		setDataSerial(value);
		System.out.println(value);
		
	}
}
