package Actividad3;

import java.util.ArrayList;

public class Campo {
	private char original[][];
	private char resultado[][];
	private int N_fil,N_col;
	
	public Campo(ArrayList<String> lineas,int m,int n) {
		int i = 0;
		original = new char[m][n];
		resultado = new char[m][n];
		for(String s : lineas) {
			for (int j = 0; j < s.length(); j++) {
				original[i][j] = s.charAt(j);		
			}
			i++;
		}
		N_fil = m;
		N_col = n;
	}
	
	public boolean compruebaIndices(int i,int j){
		return i<N_fil && i>=0 && j>=0 && j<N_col && original[i][j]=='*';
	}
	
	public int compruebaMinas(int i,int j) {
		int c = 0;
		if(compruebaIndices(i-1,j-1)){c++;}
		if(compruebaIndices(i-1,j  )){c++;}
		if(compruebaIndices(i-1,j+1)){c++;}
		if(compruebaIndices(i  ,j-1)){c++;}
		if(compruebaIndices(i  ,j+1)){c++;}
		if(compruebaIndices(i+1,j-1)){c++;}
		if(compruebaIndices(i+1,j  )){c++;}
		if(compruebaIndices(i+1,j+1)){c++;}
		return c;
	}
	
	public String campoListo(){
		for (int i = 0; i < N_fil; i++) {
			for (int j = 0; j < N_col; j++) {
				if(original[i][j]=='*') {
					resultado[i][j]='*';
				} else {
					resultado[i][j] = (char)compruebaMinas(i,j);
				}
			}
		}
		
		String str="";
		for (int i = 0; i < N_fil; i++) {
			for (int j = 0; j < N_col; j++) {
				str+=resultado[i][j];
			}
			str+="\n";
		}
		return str;
	}
}
	

