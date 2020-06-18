package tablemodels;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import entidades.Lugar;

public class ListarLugaresTableModel extends AbstractTableModel {

	private static final int COLUMNA_NOMBRE = 0;
	private static final int COLUMNA_CAPACIDAD = 1;
	private static final int COLUMNA_DIRECCION = 2;
	private static final int COLUMNA_IMAGEN = 3;

	private String[] nombresColumnas = { "Nombre de lugar", "Capacidad total", "Direccion", "Nombre de imagen" };

	private Class[] tiposColumnas = { String.class, int.class, String.class, String.class };

	private List<Lugar> contenido;

	public ListarLugaresTableModel(List<Lugar> contenidoInicial) {

		contenido = contenidoInicial;
	}
	
	public int getColumnCount() { 
		
		return nombresColumnas.length;
		
	}
	
	public int getRowCount() { 
		
	    int result = 0;
	   
	      if(contenido != null) {
	        result = contenido.size();
	      }
	    
	    return result;
		
	}
	
	public String getColumnName(int col) { 

		return nombresColumnas[col];
		
	}

	public Object getValueAt(int rowIndex, int columnIndex) {

		Lugar u = contenido.get(rowIndex);

		Object result = null;

		switch (columnIndex) {

		case COLUMNA_NOMBRE:
			result = u.getNombre();
			break;
		case COLUMNA_CAPACIDAD:
			result = u.getCapacidadTotal();
			break;
		case COLUMNA_IMAGEN:
			result = u.getFotoLugar();
			break;
		case COLUMNA_DIRECCION:
			result = u.getDireccion();
			break;
		}

		return result;

	}
	
	public List<Lugar> getContenido() { 
		
		return contenido; 
		
	}


	public void setContenido (List<Lugar> contenido) { 
		
		this.contenido = contenido; 
		
	}

}
