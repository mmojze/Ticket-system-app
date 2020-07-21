package tablemodels;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import entidades.Lugar;

public class LugarTableModel extends AbstractTemplateTableModel {

	protected static final int COLUMNA_NOMBRE = 0;

	private String[] nombresColumnas = { "Nombre de ubicación" };
	private Class[] tiposColumnas = { String.class };
	private List<?> contenido;

	public LugarTableModel(List<?> contenidoInicial) {
		contenido = contenidoInicial;
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

		}

		return result;

	}

	public List<Lugar> getContenido() {

		return (List<Lugar>) contenido;

	}

	public void setContenido(List<?> contenido) {

		this.contenido = (List<Lugar>) contenido;

	}

}
