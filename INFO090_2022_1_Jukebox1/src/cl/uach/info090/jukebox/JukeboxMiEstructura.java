package cl.uach.info090.jukebox;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Este ejemplo esta adaptado del Capitulo 15 
 * del libro Head First Java, Second Edition.
 * 
 * @author J Guerra
 */
public class JukeboxMiEstructura {
	
	
	private HashMap <String, Song> songMap;
	private String jukeFilePath;
	private ArrayList<Song> ordered;
	
	public JukeboxMiEstructura(String jukeFilePath){
		songMap = new HashMap<String,Song>();
		this.jukeFilePath = jukeFilePath;
	}
	
	private void loadSongs(){
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(jukeFilePath);
			br = new BufferedReader(fr);
			String linea = "";
			while((linea = br.readLine()) != null) {
				addView(linea);
			}
			br.close();
			fr.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void addView(String lineToParse){
		String[] parts = lineToParse.split("@@");
		String title = parts[1].replaceAll("\"","").trim();
		String artist = parts[0];
		Song s = songMap.get(title+" "+artist);
		if(s != null) {
			s.incrementRating();
		}else {
			s = new Song(title,artist);
			songMap.put(title+" "+artist,s);
		}
	}
	
	public int countSongs() {
		return songMap.size();
	}
	
	
	public void printSongs(){
		for (Song s : ordered) System.out.println(s);
	}

	public void rankSongs(){
		ordered = new ArrayList<Song>(songMap.values());
		Collections.sort(ordered);
	}

	
	public static void main(String[] args) {
		JukeboxMiEstructura j = new JukeboxMiEstructura("data/song_list_gen.juke");
		long date1 = System.currentTimeMillis();
		
		j.loadSongs();
		System.out.println("Numero de canciones distintas: " + j.countSongs());
		
		long date2 = System.currentTimeMillis();
		System.out.println("Milisegundos en leer y organizar los registros: " + (date2-date1));
		
		j.rankSongs();
		long date3 = System.currentTimeMillis();
		System.out.println("Milisegundos en ordenar las canciones: " + (date3-date2));
		
		j.printSongs(); //PUEDE COMENTAR AQUI PARA VER RESULTADOS
		long date4 = System.currentTimeMillis();
		System.out.println("Milisegundos en mostrar las canciones: " + (date4-date3));
	}

}
