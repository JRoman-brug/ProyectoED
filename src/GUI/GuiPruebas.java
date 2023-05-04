package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.print.DocFlavor.URL;
import javax.swing.AbstractListModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class GuiPruebas {

	private JFrame Interfaz1;
	private JButton addButton;
	private JTable tableAlumnos;
	private DefaultTableModel modelo;
	private JButton searchButton;
	private JButton deleteButton;
	private JComboBox sortButton;
	private JLabel labelPromedio;
	private JLabel labelMinNota;
	private JLabel labelImagen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiPruebas window = new GuiPruebas();
					window.Interfaz1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GuiPruebas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
			
		Interfaz1 = new JFrame();
		Interfaz1.setFont(null);
		Interfaz1.setTitle("Pruebas");
		Interfaz1.setBounds(100, 100, 925, 645);
		Interfaz1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Interfaz1.getContentPane().setLayout(null);
		
		//String nomMateria = JOptionPane.showInputDialog("Ingrese el nombre de la materia: ");
		//JLabel lblTitulo = new JLabel(nomMateria);
		
		JLabel lblTitulo = new JLabel("//Materia");
		
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 56));
		lblTitulo.setBounds(21, 22, 691, 121);
		Interfaz1.getContentPane().add(lblTitulo);
		
		
		//label Imagen
		//como hago el directorio para la imagen
		/*java.net.URL imageUrl = getClass().getResource("/DirectorioExtra/logo-transparente_UNS");
		ImageIcon imageIcon = new ImageIcon(imageUrl);
		labelImagen = new JLabel();
		labelImagen.setIcon(new ImageIcon("C:\\Users\\Matias\\Pictures\\logo-transparente_UNS.png"));
		labelImagen.setBounds(780, 56, 99, 108);
		Interfaz1.getContentPane().add(labelImagen);*/
		
		
		//texto de informacion
		//como pongo la info
		JLabel labelInfo = new JLabel("//Info de la materia");
		labelInfo.setBounds(780, 200, 106, 381);
		Interfaz1.getContentPane().add(labelInfo);
		
		
		//promedio de las notas
		//agrgar promedio por letras o numeros
		labelPromedio = new JLabel("El promedio de los alumnos es de: "+promedioTabla());
		labelPromedio.setBounds(21, 585, 223, 13);
		Interfaz1.getContentPane().add(labelPromedio);
		
		
		//minima nota de todos
		labelMinNota = new JLabel("La menor nota de los estudiantes es: "+minNota());
		labelMinNota.setBounds(302, 585, 344, 13);
		Interfaz1.getContentPane().add(labelMinNota);
		
		
		//scroll Pane
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 198, 735, 383);
		Interfaz1.getContentPane().add(scrollPane);
		
		
		//tabla/lista de alumnos
		modelo = new DefaultTableModel();
        modelo.addColumn("Nombre");
        modelo.addColumn("Lu");
        modelo.addColumn("Nota");
		tableAlumnos = new JTable(modelo);
		tableAlumnos.setRowSelectionAllowed(false);
		tableAlumnos.setFillsViewportHeight(true);
		tableAlumnos.setBounds(0, 0, 1, 1);
		scrollPane.setViewportView(tableAlumnos);
		
		
		//boton para agregar alumnos
		//si agrego se agregan segun el filtro?
		addButton = new JButton("Nuevo Alumno");
		addButton.setToolTipText("Agrega un nuevo alumno a la tabla");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Abrir un cuadro de diálogo para obtener los datos del estudiante
		        JTextField nameField = new JTextField();
		        JTextField lastNameField = new JTextField();
		        JTextField luField = new JTextField();
		        JTextField gradeField = new JTextField();

		        Object[] message = {
		                "Apellido:", lastNameField,
		                "Nombre:", nameField,
		                "Número de estudiante:", luField,
		                "Nota de cursado:", gradeField
		        };
		        
		        //busco si ya existe
		        //agregar el servicio xq se repite en varios botones
		        boolean flag=false;
		        for (int i = 0; i < modelo.getRowCount() && !flag; i++) {
		            flag = (modelo.getValueAt(i, 1).equals(luField));
		        }
		        
		        if(flag) {
		        	// Si se encuentra el estudiante, mostrar un mensaje de error
			        JOptionPane.showMessageDialog(null, "El Lu ya existe.");
		        }else {
		        	int option = JOptionPane.showConfirmDialog(null, message, "Agregar estudiante", JOptionPane.OK_CANCEL_OPTION);
		        	if (option == JOptionPane.OK_OPTION) {
			            // Agregar una nueva fila con los datos del estudiante
			            String name = lastNameField.getText()+" "+nameField.getText();
			            String lu = luField.getText();
			            String nota = gradeField.getText();

			            modelo.addRow(new Object[]{name, lu, nota});
		        	}
		        }
		        
			}
		});
		addButton.setBounds(31, 153, 118, 21);
		Interfaz1.getContentPane().add(addButton);
		
		//boton buscar alumno
		//las notas por numero?--> como garantizo q son int?
		//las notas por letra?--> como garantizo q son string?
		searchButton = new JButton("Buscar");
		searchButton.setToolTipText("Busca un alumno segun su Lu");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Obtener el número de estudiante que se va a buscar
		        String lu = JOptionPane.showInputDialog("Ingrese el Lu de estudiante:");
		        String nota = null;
		        String nombre = null;
		        boolean flag=false;
		        // Buscar en la tabla por el número de estudiante
		        for (int i = 0; i < modelo.getRowCount() && !flag; i++) {
		            if (modelo.getValueAt(i, 1).equals(lu)) {
		                // Mostrar la nota de cursado del estudiante encontrado
		                nota = (String) modelo.getValueAt(i, 2);
		                nombre = (String) modelo.getValueAt(i, 0);
		                JOptionPane.showMessageDialog(null, "La nota de cursado de "+nombre+" es: " + nota);
		                flag = true;
		            }
		        }
		        
		        if(!flag) {
		        	// Si no se encuentra el estudiante, mostrar un mensaje de error
		        	JOptionPane.showMessageDialog(null, "El Lu de estudiante no fue encontrado.");
		        }
		        
			}
		});
		searchButton.setBounds(159, 153, 85, 21);
		Interfaz1.getContentPane().add(searchButton);
		
		//boton para eliminar
		deleteButton = new JButton("Eliminar Alumno");
		deleteButton.setToolTipText("Elimina un alunmo segun su Lu");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Obtener el número de estudiante que se va a buscar
		        String lu = JOptionPane.showInputDialog("Ingrese el Lu de estudiante a eliminar:");
		        
		        boolean flag=false;
		        
		        int selectedRow = -1;
		        
		        String nombre=null;
		        // Buscar en la tabla por el número de estudiante
		        for (int i = 0; i < modelo.getRowCount() && !flag; i++) {
		            if (modelo.getValueAt(i, 1).equals(lu)) {
		            	selectedRow = i;
		            	nombre = (String) modelo.getValueAt(i, 0);
		                flag = true;
		            }
		        }

                // Verificar que se haya seleccionado una fila
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(null, "No se encontro ningún estuadiante a eliminar.");
                }else {
                	// Preguntar al usuario si realmente desea eliminar al estudiante
                	int option = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea eliminar a "+nombre+"?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
                	if (option == JOptionPane.YES_OPTION) {
                		// Eliminar al estudiante
                		modelo.removeRow(selectedRow);
                	}
                }

                
			}
		});
		deleteButton.setBounds(254, 153, 129, 21);
		Interfaz1.getContentPane().add(deleteButton);
		
		
		//boton para el filtro
		//se puede hacer q mientras este seleccionado uno se haga solo?
		sortButton = new JComboBox();
		sortButton.setToolTipText("Filtro de al tabla");
		sortButton.setModel(new DefaultComboBoxModel(new String[] {"Ordenar por nota (mayor a menor)", "Ordenar por misma nota", "Ordenar por aprobados"}));
		sortButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedOption = (String) sortButton.getSelectedItem();
		        switch (selectedOption) {
		            case "Ordenar por nota (mayor a menor)":
		                sortNotaMayor();
		                break;
		            case "Ordenar por misma nota":
		                sortPorMismaNota();
		                break;
		            case "Ordenar por aprobados":
		                sortPorAprobados();
		                break;
		            default:
		                break;
		        }
			}

			private void sortPorAprobados() {
				// TODO Auto-generated method stub
				
			}

			private void sortPorMismaNota() {
				// TODO Auto-generated method stub
				
			}

			private void sortNotaMayor() {
				// TODO Auto-generated method stub
				
			}
		});
		sortButton.setBounds(393, 153, 224, 21);
		Interfaz1.getContentPane().add(sortButton);
		
	}

	private int minNota() {
		// TODO Auto-generated method stub
		return 0;
	}

	private int promedioTabla() {
		// TODO Auto-generated method stub
		return 0;
	}
}



