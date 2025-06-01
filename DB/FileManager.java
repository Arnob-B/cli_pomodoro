import java.io.FileInputStream;
package DB

/**
 * FileManager
 */
public class FileManager {
	FileManager(String filepath) {
		FileInputStream fis = new FileInputStream(filepath);
		fis.write();
	}
}
