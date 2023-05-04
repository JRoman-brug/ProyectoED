package Logic;

import TDADiccionario.*;;

public class Alumno {
	//instance variables
	int lu;
	String apellido;
	String nombre;
	Dictionary<String,Integer> dicMatNota;
	
	//Constructor
	public Alumno(int lu,String apellido,String nombre) {
		this.lu=lu;
		this.apellido=apellido;
		this.nombre=nombre;
		dicMatNota = new DiccionarioConLista<String,Integer>(); 
	}
	
	//Setters
	/**
	 * Establece el numero de lu del alumno
	 */
	public void setLu(int lu) {
		if(lu!=0)this.lu=lu;
	}
	
	/**
	 * Establece el apellido del alumno
	 */
	public void setApellido(String apellido) {
		if(apellido!=null)this.apellido=apellido;
	}
	
	/**
	 * Establece el nombre del alumno
	 */
	public void setNombre(String nombre) {
		if(nombre!=null)this.nombre=nombre;
	}
	
	/**
	 * Inserta una materia con su nota en el diccionario
	 * @param materia 
	 * @param nota de la materia
	 */
	public void setNota(String materia,int nota) {
		try{
			dicMatNota.insert(materia, nota);
		}catch(InvalidKeyException e) {
			System.out.println(e.getMessage());
		}
	}
		
	//Getters
	/**
	 * @return Retorna el lu del alumno
	 */
	public int getLu() {
		return lu;
	}
	
	/**
	 * @return Retorna el apellido del alumno
	 */
	public String getApellido() {
		return apellido;
	}
	
	/**
	 * Retorna el nombre del alumno
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Busca la nota de la materia dada y la devuelve, si no existe retorna nulo.
	 * @return Entrada con la materia y nota
	 */
	public Entry<String,Integer> encontrarNota(String materia){
		Entry<String,Integer> toRet = null;
		if(materia!=null) {
			try {
				dicMatNota.find(materia);
			}catch(InvalidKeyException e) {
				System.out.println(e.getMessage());
			}
		}
		return toRet;
	}
	
	/**
	 * Elimina la nota correspondiente a la materia, si no existe retorna null
	 * @param e Entry Entrada de la materia con su nota
	 * @return Una entrada con la materia y su nota
	 */
	public Entry<String,Integer> eliminarNota(Entry<String,Integer> e){
		Entry<String,Integer> toRet = null;
		if(e!=null) {
			try {
				dicMatNota.remove(e);
			}catch(InvalidEntryException e1) {
				System.out.println(e1.getMessage());
			}
		}
		return toRet;
	}
	
	/**
	 * Devuelve todas las materias en que esta el alumno
	 * @return coleccion iterable de materias
	 */
	public Iterable<Entry<String,Integer>> coleccionMaterias(){
		return dicMatNota.entries();
	}
}
