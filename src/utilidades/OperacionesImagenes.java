package utilidades;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

import exceptions.ArchivoNoExisteException;

public class OperacionesImagenes {

	private static final String DIR_FILEPATH = System.getProperty("user.dir") + "\\img";
	public static final String DIR_IMG_LUGAR = System.getProperty("user.dir") + "\\img-lugar";

	public static void copiarArchivo(String origen, String destino) throws ArchivoNoExisteException {

		File origenArchivo = new File(origen);
		File destinoArchivo = new File(destino);

		if (origenArchivo.exists()) {
			try {

				InputStream in = new FileInputStream(origenArchivo);
				OutputStream out = new FileOutputStream(destinoArchivo);

				// Usamos un buffer para copiar

				byte[] buf = new byte[1024];
				int len;
				while ((len = in.read(buf)) > 0) {
					out.write(buf, 0, len);
				}
				in.close();
				out.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}

		} else {

			throw new ArchivoNoExisteException();

		}
	}

	public static void moverArchivo(String origen, String destino) throws ArchivoNoExisteException {

		File origin = new File(origen);
		File destination = new File(destino);

		if (origin.exists()) {
			try {
				InputStream in = new FileInputStream(origin);
				OutputStream out = new FileOutputStream(destination);
				byte[] buf = new byte[1024];
				int len;
				while ((len = in.read(buf)) > 0) {
					out.write(buf, 0, len);
				}
				in.close();
				out.close();
				origin.delete();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		} else {
			throw new ArchivoNoExisteException();
		}

	}

	public static void borrarImagen(String archivo, String ruta) throws ArchivoNoExisteException {

		File archivoEliminar = new File(ruta + "//" + archivo);
		if (archivoEliminar.exists()) {
			archivoEliminar.delete();
		} else {
			throw new ArchivoNoExisteException();
		}

	}

	public static File cargarImagen(String destino) {

		JFileChooser fileChooser = new JFileChooser();
		fileChooser.addChoosableFileFilter(new ImageFilter());
		fileChooser.setAcceptAllFileFilterUsed(false);
		int seleccion = fileChooser.showOpenDialog(null);

		File fichero = null;
		File imagenCargada = null;

		if (seleccion == JFileChooser.APPROVE_OPTION) {
			fichero = fileChooser.getSelectedFile();
			String nombreFichero = fichero.getName();
			String extension = nombreFichero.substring(nombreFichero.lastIndexOf("."));
			String nuevoNombre = OperacionesImagenes.generarNombreUnico(extension);
			try {
				imagenCargada = OperacionesImagenes.copiarImagen(fichero, destino, nombreFichero, nuevoNombre);
			} catch (ArchivoNoExisteException e) {
				e.printStackTrace();
			}
		}

		return imagenCargada;

	}

	public static File copiarImagen(File origenArchivo, String destino, String nombreArchivo, String nuevoNombreArchivo)
			throws ArchivoNoExisteException {

		File destinoArchivo = new File(destino + "\\" + nuevoNombreArchivo);

		if (origenArchivo.exists()) {
			try {

				InputStream in = new FileInputStream(origenArchivo);
				OutputStream out = new FileOutputStream(destinoArchivo);

				// Usamos un buffer para copiar

				byte[] buf = new byte[1024];
				int len;
				while ((len = in.read(buf)) > 0) {
					out.write(buf, 0, len);
				}
				in.close();
				out.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}

			return destinoArchivo;

		} else {

			throw new ArchivoNoExisteException();

		}

	}

	public static String generarNombreUnico(String extension) {

		String nombre = UUID.randomUUID().toString();
		nombre = nombre + extension;
		return nombre;

	}

}
