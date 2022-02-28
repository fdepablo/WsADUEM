package beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Cliente extends Persona{
	private String codigo;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	
}
