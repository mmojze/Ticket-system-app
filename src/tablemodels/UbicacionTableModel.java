package tablemodels;

import java.util.List;

import entidades.Ubicacion;

public class UbicacionTableModel extends AbstractTemplateTableModel {

	private static final int COLUMNA_NOMBRE = 0;
	private static final int COLUMNA_CAPACIDAD = 1;

	private String[] nombresColumnas = { "Nombre de ubicación", "Capacidad" };
	private Class[] tiposColumnas = { String.class, int.class };
	private List<Ubicacion> contenido;

	public UbicacionTableModel(List<?> contenidoInicial) {

		this.contenido = (List<Ubicacion>) contenidoInicial;

	}
	
	public int getColumnCount() {

		return super.getColumnCount(nombresColumnas);

	}

	public int getRowCount() {

		return super.getRowCount(this.contenido);

	}

	public List<Ubicacion> getContenido() {

		return this.contenido;

	}

	public void setContenido(List<?> contenido) {

		this.contenido = (List<Ubicacion>) contenido;

	}

	public Object getValueAt(int rowIndex, int columnIndex) {

		Ubicacion u = contenido.get(rowIndex);

		Object result = null;

		switch (columnIndex) {

		case COLUMNA_NOMBRE:
			result = u.getNombre();
			break;
		case COLUMNA_CAPACIDAD:
			result = u.getCapacidad();
			break;
		}

		return result;
	}
	
	public String getColumnName(int col) {

		return super.getColumnName(this.nombresColumnas, col);

	}

}
