package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.entidad.Videojuego;
import modelo.negocio.GestorVideojuego;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class CRUD_Grafico_Videojuegos extends JFrame {

	// Atributos del modelo
	private GestorVideojuego gestorvd;
	private Videojuego videojuego;
	// Atributos JFrame
	private String modoEntrada;
	private JLabel lblAppTitle;
	private JLabel lblIdVideojuego;
	private JLabel lblNombreVideojuego;
	private JLabel lblCompañia;
	private JLabel lblPrecioVideojuego;
	private JTextField campoIdVideojuego;
	private JTextField campoNombreVd;
	private JTextField campoCompañiaVd;
	private JTextField campoPrecioVd;
	private JButton btnBaja;
	private JButton btnModificar;
	private JButton btnObtener;
	private JButton btnListar;
	private JList<Videojuego> listaVideojuegos;
	private JLabel lblElijaModo;
	private JButton btnProcesarOrden;
	private JLabel lblListaDeTodos;
	private JLabel lblEstado;
	private JLabel lblRespuesta;
	private JLabel lblModo;
	private JButton btnBorrarCampos;
	private DefaultListModel<Videojuego> listModel;
	private JLabel lblListHeader;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CRUD_Grafico_Videojuegos frame = new CRUD_Grafico_Videojuegos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Metodo para borrar los campos de texto del video juego
	public void borrarCampos() {
		campoIdVideojuego.setText("");
		campoNombreVd.setText("");
		campoCompañiaVd.setText("");
		campoPrecioVd.setText("");
	}

	public DefaultListModel<Videojuego> getModel() {
		listModel = new DefaultListModel<>();
		for (Videojuego vd : gestorvd.listar()) {
			listModel.addElement(vd);
		}
		return listModel;
	}

	public void refrescarModel() {
		listaVideojuegos.setModel(getModel());
	}

	/**
	 * Create the frame.
	 */
	public CRUD_Grafico_Videojuegos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 463);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Inicializando objetos: Videojuego y GestorVideojuego
		gestorvd = new GestorVideojuego();
		videojuego = new Videojuego();

		lblAppTitle = new JLabel("El mejor CRUD de Videojuegos :)");
		lblAppTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblAppTitle.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblAppTitle.setBounds(112, 31, 367, 33);
		contentPane.add(lblAppTitle);

		lblIdVideojuego = new JLabel("Id Videojuego:");
		lblIdVideojuego.setHorizontalAlignment(SwingConstants.LEFT);
		lblIdVideojuego.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblIdVideojuego.setBounds(35, 204, 111, 20);
		contentPane.add(lblIdVideojuego);

		lblNombreVideojuego = new JLabel("Nombre:");
		lblNombreVideojuego.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombreVideojuego.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNombreVideojuego.setBounds(35, 236, 111, 20);
		contentPane.add(lblNombreVideojuego);

		lblCompañia = new JLabel("Compa\u00F1ia:");
		lblCompañia.setHorizontalAlignment(SwingConstants.LEFT);
		lblCompañia.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCompañia.setBounds(35, 267, 111, 20);
		contentPane.add(lblCompañia);

		lblPrecioVideojuego = new JLabel("Precio:");
		lblPrecioVideojuego.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrecioVideojuego.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPrecioVideojuego.setBounds(35, 298, 111, 20);
		contentPane.add(lblPrecioVideojuego);

		campoIdVideojuego = new JTextField();
		campoIdVideojuego.setBounds(156, 206, 96, 20);
		contentPane.add(campoIdVideojuego);
		campoIdVideojuego.setColumns(10);

		campoNombreVd = new JTextField();
		campoNombreVd.setColumns(10);
		campoNombreVd.setBounds(112, 235, 140, 20);
		contentPane.add(campoNombreVd);

		campoCompañiaVd = new JTextField();
		campoCompañiaVd.setColumns(10);
		campoCompañiaVd.setBounds(122, 267, 130, 20);
		contentPane.add(campoCompañiaVd);

		campoPrecioVd = new JTextField();
		campoPrecioVd.setColumns(10);
		campoPrecioVd.setBounds(94, 298, 158, 20);
		contentPane.add(campoPrecioVd);

		JButton btnAlta = new JButton("ALTA");
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrarCampos();
				lblRespuesta.setText("");
				lblModo.setText("Modo: alta");
				campoIdVideojuego.setEnabled(false);
				modoEntrada = "alta";
			}
		});
		btnAlta.setForeground(Color.WHITE);
		btnAlta.setBackground(Color.GRAY);
		btnAlta.setBounds(33, 103, 89, 23);
		contentPane.add(btnAlta);

		btnBaja = new JButton("BAJA");
		btnBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblRespuesta.setText("");
				lblModo.setText("Modo: baja");
				campoIdVideojuego.setEnabled(true);
				campoNombreVd.setEnabled(false);
				campoCompañiaVd.setEnabled(false);
				campoPrecioVd.setEnabled(false);
				modoEntrada = "baja";
			}
		});
		btnBaja.setForeground(Color.WHITE);
		btnBaja.setBackground(Color.GRAY);
		btnBaja.setBounds(132, 103, 89, 23);
		contentPane.add(btnBaja);

		btnModificar = new JButton("MODIFICAR");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblRespuesta.setText("");
				lblModo.setText("Modo: modificar");
				campoIdVideojuego.setEnabled(true);
				campoNombreVd.setEnabled(true);
				campoCompañiaVd.setEnabled(true);
				campoPrecioVd.setEnabled(true);
				modoEntrada = "modificar";
			}
		});
		btnModificar.setForeground(Color.WHITE);
		btnModificar.setBackground(Color.GRAY);
		btnModificar.setBounds(33, 128, 103, 23);
		contentPane.add(btnModificar);

		btnObtener = new JButton("OBTENER");
		btnObtener.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrarCampos();
				lblRespuesta.setText("");
				lblModo.setText("Modo: obtener");
				campoIdVideojuego.setEnabled(true);
				campoNombreVd.setEnabled(false);
				campoCompañiaVd.setEnabled(false);
				campoPrecioVd.setEnabled(false);
				modoEntrada = "obtener";
			}
		});
		btnObtener.setForeground(Color.WHITE);
		btnObtener.setBackground(Color.GRAY);
		btnObtener.setBounds(142, 128, 96, 23);
		contentPane.add(btnObtener);

		btnListar = new JButton("LISTAR");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refrescarModel();
			}
		});
		btnListar.setForeground(Color.WHITE);
		btnListar.setBackground(Color.BLUE);
		btnListar.setBounds(470, 364, 89, 23);
		contentPane.add(btnListar);

		JScrollPane scrollPaneLista = new JScrollPane();
		scrollPaneLista.setBounds(284, 101, 275, 252);
		contentPane.add(scrollPaneLista);

		JScrollBar scrollBar = new JScrollBar();
		scrollPaneLista.setRowHeaderView(scrollBar);

		listaVideojuegos = new JList<Videojuego>();
		listaVideojuegos.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {

				Videojuego vdLista = listaVideojuegos.getSelectedValue();
				// Comprobamos que el objeto sea distinto de null por si acabamos de borrar
				// el elemento y que asi no nos arroge un NullPointerExepcion
				if (vdLista != null) {
					campoIdVideojuego.setText(Integer.toString(vdLista.getId()));
					campoNombreVd.setText(vdLista.getNombre());
					campoCompañiaVd.setText(vdLista.getCompañia());
					campoPrecioVd.setText(Double.toString(vdLista.getPrecio()));
				}

			}
		});
		listaVideojuegos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaVideojuegos.setLayoutOrientation(JList.VERTICAL);
		scrollPaneLista.setViewportView(listaVideojuegos);

		lblListHeader = new JLabel("ID----NOMBRE----COMPA\u00D1IA----PRECIO");
		scrollPaneLista.setColumnHeaderView(lblListHeader);

		lblElijaModo = new JLabel("Elija primero un modo de entrada:");
		lblElijaModo.setHorizontalAlignment(SwingConstants.LEFT);
		lblElijaModo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblElijaModo.setBounds(35, 74, 217, 20);
		contentPane.add(lblElijaModo);

		btnProcesarOrden = new JButton("PROCESAR ORDEN");
		btnProcesarOrden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				lblModo.setText("Modo:");

				switch (modoEntrada) {
				case "alta":
					videojuego.setNombre(campoNombreVd.getText());
					videojuego.setCompañia(campoCompañiaVd.getText());
					videojuego.setPrecio(Double.parseDouble(campoPrecioVd.getText()));

					int alta = gestorvd.alta(videojuego);
					if (alta == 1)
						lblRespuesta.setText("El Videojuego se dio de alta");
					else if (alta == 2)
						lblRespuesta.setText("NO ALTA: ocurrió un problema en la Base de datos");
					else if (alta == 0)
						lblRespuesta.setText("NO ALTA: El nombre no puedes ser menor de 5 caracteres");
					else if (alta == -1)
						lblRespuesta.setText("NO ALTA: El precio debe ser mayor o igual a cero");

					break;
				case "baja":
					boolean baja = gestorvd.baja(Integer.parseInt(campoIdVideojuego.getText()));
					if (baja)
						lblRespuesta.setText("El Videojuego se dió de baja");
					else
						lblRespuesta.setText("El Videojuego NO se dió de baja");
					break;
				case "modificar":
					videojuego.setId(Integer.parseInt(campoIdVideojuego.getText()));
					videojuego.setNombre(campoNombreVd.getText());
					videojuego.setCompañia(campoCompañiaVd.getText());
					videojuego.setPrecio(Double.parseDouble(campoPrecioVd.getText()));
					int modifico = gestorvd.modificar(videojuego);
					if (modifico == 1)
						lblRespuesta.setText("El Videojuego se modificó");
					else if (modifico == 2)
						lblRespuesta.setText("NO MODIFICADO: ocurrió un problema en la Base de datos");
					else if (modifico == 0)
						lblRespuesta.setText("NO MODIFICADO: El nombre no puedes ser menor de 5 caracteres");
					else if (modifico == -1)
						lblRespuesta.setText("NO MODIFICADO: El precio debe ser mayor o igual a cero");
					break;
				case "obtener":
					videojuego = gestorvd.obtener(Integer.parseInt(campoIdVideojuego.getText()));
					campoNombreVd.setText(videojuego.getNombre());
					campoCompañiaVd.setText(videojuego.getCompañia());
					campoPrecioVd.setText(Double.toString(videojuego.getPrecio()));
					if (videojuego != null)
						lblRespuesta.setText("Se obtuvo el videojuego");
					break;
				default:
					break;
				}
				// Deseleccionamos la selecion en la lista por si hemos borrado algun elemento
				// para que no arroje un nullPointerException
				listaVideojuegos.clearSelection();
				refrescarModel();
			}
		});
		btnProcesarOrden.setBackground(Color.GREEN);
		btnProcesarOrden.setForeground(Color.WHITE);
		btnProcesarOrden.setBounds(35, 329, 217, 23);
		contentPane.add(btnProcesarOrden);

		lblListaDeTodos = new JLabel("Lista de todos los videojuegos");
		lblListaDeTodos.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaDeTodos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblListaDeTodos.setBounds(306, 74, 217, 20);
		contentPane.add(lblListaDeTodos);

		lblEstado = new JLabel("Estado:");
		lblEstado.setHorizontalAlignment(SwingConstants.LEFT);
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEstado.setBounds(35, 363, 64, 20);
		contentPane.add(lblEstado);

		lblRespuesta = new JLabel("");
		lblRespuesta.setHorizontalAlignment(SwingConstants.LEFT);
		lblRespuesta.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRespuesta.setBounds(94, 363, 338, 20);
		contentPane.add(lblRespuesta);

		lblModo = new JLabel("Modo: ");
		lblModo.setHorizontalAlignment(SwingConstants.LEFT);
		lblModo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblModo.setBounds(35, 162, 96, 20);
		contentPane.add(lblModo);

		btnBorrarCampos = new JButton("BORRAR CAMPOS");
		btnBorrarCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrarCampos();
			}
		});
		btnBorrarCampos.setFont(new Font("Tahoma", Font.BOLD, 9));
		btnBorrarCampos.setForeground(Color.WHITE);
		btnBorrarCampos.setBackground(Color.RED);
		btnBorrarCampos.setBounds(132, 163, 120, 19);
		contentPane.add(btnBorrarCampos);
	}
}
