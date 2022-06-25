package cl.uach.info090.jukebox;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Este ejemplo esta adaptado del Capitulo 15 
 * del libro Head First Java, Second Edition.
 * 
 * @author J Guerra
 */
public class Jukebox {
	
	
	private ArrayList<Song> songList;
	private String jukeFilePath;
	
	public Jukebox(String jukeFilePath){
		songList = new ArrayList<Song>();
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
		Song s = songExists(title, artist);
		if(s != null) {
			s.incrementRating();
		}else {
			s = new Song(title,artist);
			songList.add(s);
		}
	}
	
	public Song songExists(String title, String artist) {
		for(Song s: songList) {
			if(s.getArtist().equalsIgnoreCase(artist) 
					&& s.getTitle().equalsIgnoreCase(title)) return s;
		}
		return null;
	}
	
	
	public int countSongs() {
		return songList.size();
	}
	
	
	public void printSongs(){
		int i = 0;
		for(Song s: songList) {
			System.out.println(" - " + s);
			if(i==25) break;
			i++;
		}
	}

	/**
	 * Falta completar esto!!!!
	 */
	public void rankSongs(){
		Collections.sort(songList);
	}

	
	public static void main(String[] args) {
		Jukebox j = new Jukebox("data/song_list_gen.juke");
		long date1 = System.currentTimeMillis();
		
		j.loadSongs();
		System.out.println("Numero de canciones distintas: " + j.countSongs());
		
		long date2 = System.currentTimeMillis();
		System.out.println("Milisegundos en leer y organizar los registros: " + (date2-date1));
		
		j.rankSongs();
		long date3 = System.currentTimeMillis();
		System.out.println("Milisegundos en ordenar las canciones: " + (date3-date2));
		
		j.printSongs();
		long date4 = System.currentTimeMillis();
		System.out.println("Milisegundos en mostrar las canciones: " + (date4-date3));
	}

}
