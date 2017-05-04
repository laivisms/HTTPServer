import java.io.File;
import java.util.HashMap;

/**
 * The PathFormatter class, part of the HTTPServer program. This class maps the information in an HTTP message to the 
 * 					location in the computer where the resource indicated by the message SHOULD be located (does not necessarily
 * 					check whether the resource exists or not). 
 * 
 * @author Laivi Malamut-Salvaggio
 *
 */

public class PathFormatter {
	
	
	/**
	 * This function finds the corresponding directory on the computer where the resource should exist.
	 * 				it first determines the file type of the requested resource, first by checking the path's
	 * 				extension. If that doesnt exist, check the content-type header. If that also doesnt exist, throw 400.
	 * 				This function then cycles through all the languages accepted by the client, and checks the database for 
	 * 				a copy of the requested resource for that language, stopping at the earliest match. If no copy
	 * 				is found in an accepted language, return 404. If no language type is specified, default to english.
	 * 
	 * 
	 * @param the directory of the target resource
	 * @param fields the map of header-fields from the message
	 * @return the absolute directory of the file
	 * @throws ErrorException 404 if file not found, or 400 if message incorrectly formatted (no file extension OR content-type field)
	 */
	public static String formatPath(String path, HashMap<String, String> fields) throws ErrorException{
		String fileType = "";
		String fileName = path.substring(path.lastIndexOf("/") + 1, path.length());
		if(fileName.contains(".")){
			fileType = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
			path = path.substring(0,path.lastIndexOf("."));
		}
		
		else if(fields.containsKey("Content-Type")){
			String media = fields.get("Content-Type");
			fileType = media.substring(media.lastIndexOf("/") + 1, media.length());
		}
		else{
			throw new ErrorException(StatusCodes.S400);
		}
		
		String resultPath = null;
		if(fields.containsKey("Accept-Language")){
			String languages = fields.get("Accept-Language");
			
			String temp;
			String[] langs = languages.split(",");
			for(String str : langs){
				if(str.contains(";")){
					str = str.substring(0, str.lastIndexOf(";"));
				}
				temp = getLangPath(str, path, fileType);
				if(temp != null){
					resultPath = temp;
					break;
				}
			}
		}
		else{
			FileHandle handle = new FileHandle();
			findFile("DB/", fileName, handle);
			if(handle.file != null){
				resultPath = handle.file.getAbsolutePath();
			}
		}
		
		if(resultPath == null){
			throw new ErrorException(StatusCodes.S404);
		}
		
		return resultPath;
	}
	
	public static String newPath(String path, HashMap<String, String> fields) throws ErrorException{
		String fileType = "";
		String fileName = path.substring(path.lastIndexOf("/") + 1, path.length());
		if(fileName.contains(".")){
			fileType = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
			path = path.substring(0,path.lastIndexOf("."));
		}
		
		else if(fields.containsKey("Content-Type")){
			String media = fields.get("Content-Type");
			if(media.contains(";")){
				media = media.substring(0, media.indexOf(";"));
			}
			if(media.equals("text/plain")){
				fileType = "txt";
			}
			else{
				fileType = media.substring(media.lastIndexOf("/") + 1, media.length());
			}
		}
		else{
			throw new ErrorException(StatusCodes.S400);
		}
		String result = "DB/en" + path + "." + fileType;
		
		if(fields.containsKey("Accept-Language")){
			String languages = fields.get("Accept-Language");
			
			String[] langs = languages.split(",");
			String langToUse = langs[0];
			String common = langToUse.substring(0, 2);
			String country = null;
			if(langToUse.length() > 2){
				country = langToUse.substring(3,5);
			}
			result = "DB/" + common;
			if(country != null){
				result = result + "/" + country;
			}
			result = result + path + "." + fileType;
		}
		return result;
		
	}
	
	
	private static String getLangPath(String lang, String path, String fileType){
		String fileName = path.substring(path.lastIndexOf("/") + 1, path.length());
		String directory = path.substring(0,path.lastIndexOf("/") + 1);
		String common = lang.substring(0, 2);
		String country = null;
		if(lang.length() > 2){
			country = lang.substring(3,5);
		}
		String result = "DB/" + common;
		if(country != null){
			result = result + "/" + country;
		}
		//result = result + path.substring(0, path.lastIndexOf("/"));
		
		FileHandle handle = new FileHandle();
		findFile(result + directory, fileName + "." + fileType, handle);
		if(handle.file != null && handle.file.exists()){
			return handle.file.getAbsolutePath();
		}
		else{
			return null;
		}
	}
	
	private static void findFile(String dName, String fileName, FileHandle output) {
	    File directory = new File(dName);

	    // get all the files from a directory
	    File[] fList = directory.listFiles();
	    for (File file : fList) {
	        if (file.isFile() && file.getName().equals(fileName)) {
	            output.file = file;
	            return;
	        } else if (file.isDirectory()) {
	            findFile(file.getAbsolutePath(), fileName, output);
	        }
	    }
	}
	
	static class FileHandle{
		File file;
		
		public FileHandle(){
			file = null;
		}
	}
}
