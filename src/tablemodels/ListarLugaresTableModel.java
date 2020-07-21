package tablemodels;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import entidades.Lugar;

public class ListarLugaresTableModel extends AbstractTemplateTableModel {

	private static final int COLUMNA_NOMBRE = 0;
	private static final int COLUMNA_CAPACIDAD = 1;
	private static final int COLUMNA_DIRECCION = 2;
	private static final int COLUMNA_IMAGEN = 3;

	private String[] nombresColumnas = { "Nombre de lugar", "Capacidad total", "Direccion", "Nombre de imagen" };
	private Class[] tiposColumnas = { String.class, int.class, String.class, String.class };
	private List<?> contenido;
	
	public ListarLugaresTableModel(List<?> contenidoInicial) {

		this.contenido = contenidoInicial;
		
	}
	
	public int getColumnCount() { 
		
		return super.getColumnCount(nombresColumnas);
		
	}
	
	public int getRowCount() { 
		
	    return super.getRowCount(this.contenido);
		
	}
	
	public String getColumnName(int col) { 

		return super.getColumnName(this.nombresColumnas, col);
		
	}

	public Object getValueAt(int rowIndex, int columnIndex) {

		Lugar u = (Lugar) contenido.get(rowIndex);

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
	
	public List<?> getContenido() { 
		
		return (List<Lugar>) contenido; 
		
	}


	public void setContenido(List<?> contenido) { 
		
		this.contenido = contenido; 
		
	}

}
