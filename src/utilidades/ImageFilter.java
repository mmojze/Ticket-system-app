package utilidades;

import java.io.File;

import javax.swing.filechooser.FileFilter;

class ImageFilter extends FileFilter {
	
	public final static String JPEG = "jpeg";
	public final static String JPG = "jpg";
	public final static String PNG = "png";

	public boolean accept(File f) {
		if (f.isDirectory()) {
			return true;
		}

		String extension = getExtension(f);
		if (extension != null) {
			if (extension.equals(JPEG) || extension.equals(JPG) || extension.equals(PNG)) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	public String getDescription() {
		return "Solo archivos .jpg, .jpeg o .png";
	}

	String getExtension(File f) {
		String ext = null;
		String s = f.getName();
		int i = s.lastIndexOf('.');

		if (i > 0 && i < s.length() - 1) {
			ext = s.substring(i + 1).toLowerCase();
		}
		return ext;
	}
}