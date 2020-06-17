package dao;

import entidades.Lugar;

public interface LugarDAO {
	
	public int crearLugar(Lugar lugar);
	public void modificarLugar();
	public void eliminarLugar(int idLugar);
	public void visualizarLugar();

}
