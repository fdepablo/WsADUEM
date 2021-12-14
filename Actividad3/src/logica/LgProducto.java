package logica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import accesoDatos.ConsultaVideojuego;
import accesoDatos.Videojuego;
import vista.CRUD;

public class LgProducto implements ActionListener {

	private Videojuego vdj;
	private ConsultaVideojuego vdjC;
	private CRUD vista;

	public LgProducto(Videojuego vdj, ConsultaVideojuego vdjC, CRUD vista) {
		super();
		this.vdj = vdj;
		this.vdjC = vdjC;
		this.vista = vista;
		this.vista.btnBuscar.addActionListener(this);
		this.vista.btnEliminar.addActionListener(this);
		this.vista.btnGuardar.addActionListener(this);
		this.vista.btnModificar.addActionListener(this);
	}

	public void iniciar() {
		vista.setTitle("Videojuegos");
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == vista.btnGuardar) {
			if (vista.txtNombre.getText().length() >= 5 && Integer.parseInt(vista.txtPrecio.getText()) >= 0) {

				vdj.setNombre(vista.txtNombre.getText());
				vdj.setPrecio(Integer.parseInt(vista.txtPrecio.getText()));
				vdj.setCompany(vista.txtCompania.getText());

				if (vdjC.guardar(vdj)) {
					JOptionPane.showMessageDialog(null, "Guardado");
					vista.limpiarTxt();
				} else {
					JOptionPane.showMessageDialog(null, "Error");
					vista.limpiarTxt();
				}

			}else {
				JOptionPane.showMessageDialog(null, "El nombre del videjuego no puede ser menos de 5 caracteres y el precio no puede ser negativo");
			}
		}

		if (e.getSource() == vista.btnModificar) {
			vdj.setId(Integer.parseInt(vista.txtID.getText()));
			vdj.setNombre(vista.txtNombre.getText());
			vdj.setPrecio(Integer.parseInt(vista.txtPrecio.getText()));
			vdj.setCompany(vista.txtCompania.getText());

			if (vdjC.modificar(vdj)) {
				JOptionPane.showMessageDialog(null, "Modificado");
				vista.limpiarTxt();
			} else {
				JOptionPane.showMessageDialog(null, "Error");
				vista.limpiarTxt();
			}

		}
		if (e.getSource() == vista.btnEliminar) {
			vdj.setId(Integer.parseInt(vista.txtID.getText()));

			if (vdjC.eliminar(vdj)) {
				JOptionPane.showMessageDialog(null, "Eliminado");
				vista.limpiarTxt();
			} else {
				JOptionPane.showMessageDialog(null, "Error");
				vista.limpiarTxt();
			}

		}
		if (e.getSource() == vista.btnBuscar) {
			vdj.setNombre(vista.txtNombre.getText());

			if (vdjC.buscar(vdj)) {
				vista.txtID.setText(String.valueOf(vdj.getId()));
				vista.txtNombre.setText(vdj.getNombre());
				vista.txtPrecio.setText(String.valueOf(vdj.getPrecio()));
				vista.txtCompania.setText(vdj.getCompany());
				JOptionPane.showMessageDialog(null, "Buscado");
			} else {
				JOptionPane.showMessageDialog(null, "No encontrado");
				vista.limpiarTxt();
			}

		}

	}

}
