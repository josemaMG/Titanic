package fp.accidentes.navales;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FactoriaAccidentesNaval {
	
	
	public static List<String> leeCSV(String path) {
		List<String> result=null;
		try {
			result=Files.readAllLines(Paths.get(path),StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
			result=new ArrayList<>();
		}
		return result;
	}
	
}
