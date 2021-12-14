package vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class CRUD extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4431218920329194609L;
	private JPanel contentPane;
	public JTextField txtNombre;
	public JTextField txtCompania;
	public JTextField txtPrecio;
	public JTextField txtID;
	public JButton btnGuardar;
	public JButton btnModificar;
	public JButton btnEliminar;
	public JButton btnLimpiar;
	public JButton btnBuscar;

	public void limpiarTxt() {
		txtNombre.setText(null);
		txtPrecio.setText(null);
		txtID.setText(null);
		txtCompania.setText(null);

	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CRUD frame = new CRUD();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CRUD() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(117, 64, 61, 16);
		contentPane.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setBounds(190, 59, 139, 26);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);

		JLabel lblCompania = new JLabel("Compañia:");
		lblCompania.setBounds(103, 104, 99, 16);
		contentPane.add(lblCompania);

		txtCompania = new JTextField();
		txtCompania.setColumns(10);
		txtCompania.setBounds(190, 99, 139, 26);
		contentPane.add(txtCompania);

		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(130, 144, 61, 16);
		contentPane.add(lblPrecio);

		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(190, 139, 139, 26);
		contentPane.add(txtPrecio);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(31, 199, 99, 29);
		contentPane.add(btnGuardar);

		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(130, 199, 99, 29);
		contentPane.add(btnModificar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(230, 199, 99, 29);
		contentPane.add(btnEliminar);

		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpiarTxt();
			}
		});
		btnLimpiar.setBounds(329, 199, 99, 29);
		contentPane.add(btnLimpiar);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(329, 17, 99, 29);
		contentPane.add(btnBuscar);

		txtID = new JTextField();
		txtID.setEnabled(false);
		txtID.setBounds(190, 21, 89, 26);
		contentPane.add(txtID);
		txtID.setColumns(10);
	}
}
