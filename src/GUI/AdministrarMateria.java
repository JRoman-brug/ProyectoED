package GUI;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.NumberFormatter;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.GridLayout;
import java.awt.Component;
import javax.swing.Box;

public class AdministrarMateria extends JPanel {

	//Objeto frame para podes modificar y el mismo objeto para pasar por parametros
	private JPanel anterior;
	private JFrame ventana;
	//Paneles

	private JPanel panel = new JPanel();
	private JPanel panelAdministrarMateria = new JPanel();
	private JPanel panelMenu = new JPanel();
	private JPanel panelMateria = new JPanel();
	private JPanel botones = new JPanel();

	private JPanel panelDatos = new JPanel();
	private JPanel panelInfo = new JPanel();		
	private JPanel panelTabla = new JPanel();

	private JPanel espacio = new JPanel();

	//Etiquetas panel de info
	private JLabel lblPromedio = new JLabel("El promedio de los alumnos es: 75");
	private JLabel lblMenorNota = new JLabel("La menor nora de los estudiantes es:0");
	private JButton btnVolver = new JButton("Volver");
	private final Component horizontalStrut = Box.createHorizontalStrut(60);
	private final JLabel lblPhoto = new JLabel("");


	/**
	 * Create the panel.
	 */
	public AdministrarMateria(JPanel a,JFrame v,String materia) {
		ventana = v;
		anterior = a;

		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setSize(1000,700);

		add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] {800, 200};
		gbl_panel.rowHeights = new int[] {700};
		gbl_panel.columnWeights = new double[]{1.0, 1.0};
		gbl_panel.rowWeights = new double[]{1.0};
		panel.setLayout(gbl_panel);
		panelInfo.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		panelInfo.add(lblPromedio);
		
		panelInfo.add(horizontalStrut);
		panelInfo.add(lblMenorNota);

		panelAdministrarMateria.setBorder(new EmptyBorder(20,20,20,20));

		panelAdministrarMateria.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panelAdministrarMateria = new GridBagConstraints();
		gbc_panelAdministrarMateria.insets = new Insets(0, 0, 0, 5);
		gbc_panelAdministrarMateria.fill = GridBagConstraints.BOTH;
		gbc_panelAdministrarMateria.gridx = 0;
		gbc_panelAdministrarMateria.gridy = 0;
		panel.add(panelAdministrarMateria, gbc_panelAdministrarMateria);
		GridBagLayout gbl_panelAdministrarMateria = new GridBagLayout();
		gbl_panelAdministrarMateria.columnWidths = new int[] {700};
		gbl_panelAdministrarMateria.rowHeights = new int[] {250, 550, 0};
		gbl_panelAdministrarMateria.columnWeights = new double[]{1.0};
		gbl_panelAdministrarMateria.rowWeights = new double[]{1.0, 1.0, 1.0};
		panelAdministrarMateria.setLayout(gbl_panelAdministrarMateria);


		GridBagConstraints gbc_panelMenu = new GridBagConstraints();
		gbc_panelMenu.insets = new Insets(0, 0, 5, 0);
		gbc_panelMenu.fill = GridBagConstraints.BOTH;
		gbc_panelMenu.gridx = 0;
		gbc_panelMenu.gridy = 0;
		panelAdministrarMateria.add(panelMenu, gbc_panelMenu);
		GridBagLayout gbl_panelMenu = new GridBagLayout();
		gbl_panelMenu.columnWidths = new int[] {700};
		gbl_panelMenu.rowHeights = new int[] {75, 75};
		gbl_panelMenu.columnWeights = new double[]{0.0};
		gbl_panelMenu.rowWeights = new double[]{0.0, 0.0};
		panelMenu.setLayout(gbl_panelMenu);

		panelMateria.setSize(200,700);
		GridBagConstraints gbc_panelMateria = new GridBagConstraints();
		gbc_panelMateria.anchor = GridBagConstraints.WEST;
		gbc_panelMateria.insets = new Insets(0, 0, 5, 5);
		gbc_panelMateria.gridx = 0;
		gbc_panelMateria.gridy = 0;
		panelMenu.add(panelMateria, gbc_panelMateria);
		panelMateria.setLayout(new BoxLayout(panelMateria, BoxLayout.Y_AXIS));


		//Funcion para volver al inicio
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarVentana();
			}
		});

		panelMateria.add(btnVolver);
		
		JLabel lblMateria = new JLabel("Estructuras de datos");
		lblMateria.setText(materia);
		lblMateria.setFont(new Font("Tahoma", Font.PLAIN, 40));
		panelMateria.add(lblMateria);

		GridBagConstraints gbc_botones = new GridBagConstraints();
		gbc_botones.anchor = GridBagConstraints.WEST;
		gbc_botones.insets = new Insets(0, 0, 0, 5);
		gbc_botones.gridx = 0;
		gbc_botones.gridy = 1;
		panelMenu.add(botones, gbc_botones);
		botones.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));

		JButton btnNuevoAlumno = new JButton("Nuevo alumno");
		botones.add(btnNuevoAlumno);

		JButton btnMayorMenor = new JButton("Mayor a menor");
		botones.add(btnMayorMenor);

		JButton btnAlumnosAprobados = new JButton("Alumnos aprobados");
		botones.add(btnAlumnosAprobados);

		JButton btnAlumnosDesaprobados = new JButton("Alumnos desaprobados");
		botones.add(btnAlumnosDesaprobados);

		panelDatos.setBackground(new Color(240, 240, 240));
		GridBagConstraints gbc_panelDatos = new GridBagConstraints();
		gbc_panelDatos.insets = new Insets(0, 0, 5, 0);
		gbc_panelDatos.fill = GridBagConstraints.BOTH;
		gbc_panelDatos.gridx = 0;
		gbc_panelDatos.gridy = 1;
		panelAdministrarMateria.add(panelDatos, gbc_panelDatos);
		GridBagLayout gbl_panelDatos = new GridBagLayout();
		gbl_panelDatos.columnWidths = new int[] {700};
		gbl_panelDatos.rowHeights = new int[] {450, 50};
		gbl_panelDatos.columnWeights = new double[]{1.0};
		gbl_panelDatos.rowWeights = new double[]{1.0, 1.0};
		panelDatos.setLayout(gbl_panelDatos);

		GridBagConstraints gbc_panelTabla = new GridBagConstraints();
		gbc_panelTabla.insets = new Insets(0, 0, 5, 0);
		gbc_panelTabla.fill = GridBagConstraints.BOTH;
		gbc_panelTabla.gridx = 0;
		gbc_panelTabla.gridy = 0;
		panelDatos.add(panelTabla, gbc_panelTabla);


		//Panel de datos del promedio y nota minima
		panelInfo.setSize(400,200);
		GridBagConstraints gbc_panelInfo = new GridBagConstraints();
		gbc_panelInfo.anchor = GridBagConstraints.WEST;
		gbc_panelInfo.fill = GridBagConstraints.VERTICAL;
		gbc_panelInfo.gridx = 0;
		gbc_panelInfo.gridy = 1;
		panelDatos.add(panelInfo, gbc_panelInfo);



		espacio.setBackground(new Color(0, 64, 64));
		GridBagConstraints gbc_espacio = new GridBagConstraints();
		gbc_espacio.fill = GridBagConstraints.BOTH;
		gbc_espacio.gridx = 1;
		gbc_espacio.gridy = 0;
		panel.add(espacio, gbc_espacio);
		lblPhoto.setIcon(new ImageIcon(AdministrarMateria.class.getResource("/Recs/Universidad_Nacional_del_Sur_sede_Alem3.png")));
		
		espacio.add(lblPhoto);
		Image imagen = new ImageIcon(IngresarMateria.class.getResource("/Recs/Universidad_Nacional_del_Sur_sede_Alem4.png")).getImage().getScaledInstance(932, 700, Image.SCALE_SMOOTH);
		lblPhoto.setIcon(new ImageIcon(imagen));
		lblPhoto.setAlignmentX(JLabel.CENTER);
		lblPhoto.setAlignmentY(JLabel.CENTER);
		
		


		//Lo copie de stackoverflow, es un formato para los textfield
		NumberFormat format = NumberFormat.getInstance();
		NumberFormatter formatter = new NumberFormatter(format);
		formatter.setValueClass(Integer.class);
		formatter.setMinimum(0);
		formatter.setMaximum(Integer.MAX_VALUE);
		formatter.setAllowsInvalid(false);
		// If you want the value to be committed on each keystroke instead of focus lost
		formatter.setCommitsOnValidEdit(true);


	}
	private void cambiarVentana() {
		ventana.getContentPane().removeAll();
		ventana.getContentPane().add(anterior);
		ventana.getContentPane().repaint();
		ventana.getContentPane().revalidate();
	}
}
