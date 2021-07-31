package utilLib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigPropertyReader {
	Properties prop;
	FileInputStream fis;

	public Properties getProperty() {
		try {
			fis = new FileInputStream(CONSTANTS.config_path);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		prop = new Properties();
		try {
			prop.load(fis);
		} catch (IOException e) {

			e.printStackTrace();
		}
		return prop;
	}

}
