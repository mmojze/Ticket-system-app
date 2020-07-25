package tablemodels;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public abstract class AbstractTemplateTableModel extends AbstractTableModel {
	
	protected String[] nombresColumnas;
	protected Class[] tiposColumnas;
	
	public String getColumnName(String[] columnas, int col) {

		return columnas[col];

	}
	
	public int getColumnCount(String[] nombresColumnas) {

		return nombresColumnas.length;

	}
	
	public int getRowCount(List<?> contenido) { 
		
	    int result = 0;
		   
	      if(contenido != null) {
	        result = contenido.size();
	      }
	    
	    return result;
		
	};
	
	public abstract List<?> getContenido();
	
	public abstract void setContenido(List<?> contenido);
	
	public abstract Object getValueAt(int rowIndex, int columnIndex);

}

