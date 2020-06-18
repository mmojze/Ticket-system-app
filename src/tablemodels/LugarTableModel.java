package tablemodels;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import entidades.Lugar;

public class LugarTableModel extends AbstractTableModel {

	protected static final int COLUMNA_NOMBRE = 0;

	// Nombre de columnas

	private String[] nombresColumnas = { "Nombre de ubicación" };

	private Class[] tiposColumnas = { String.class };

	protected List<Lugar> contenido;

	// Constructor con contenido inicial

	public LugarTableModel(List<Lugar> contenidoInicial) {
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

		}

		return result;

	}

	public List<Lugar> getContenido() {

		return contenido;

	}

	public void setContenido(List<Lugar> contenido) {

		this.contenido = contenido;

	}

}
