package cl.uach.info090.jukebox;

public class Song implements Comparable<Song> {
	private String title;
	private String artist;
	private int rating;
	
	public Song(String title, String artist) {
		this.title = title;
		this.artist = artist;
		this.rating = 1;
	}
	
	public void incrementRating(){
		rating++;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	@Override
	public String toString() {
		return getTitle()+" ("+getArtist()+") : "+getRating()+" vistas";
	}
	
	@Override
	public int compareTo(Song s) {
		//return this.getRating() - s.getRating();
		return s.getRating() - this.getRating();
	}
	
}