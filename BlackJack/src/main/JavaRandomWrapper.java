package main;

import java.util.Random;
/**
 * 
 * @author Stephen Gentles
 *
 */
public class JavaRandomWrapper implements IRandomWrapper {
	 private Random random;
	  
	  public JavaRandomWrapper(){
	   	random = new Random();
	  }
	  
	  public int nextInt(int n){
	  	 return random.nextInt(n);
	  }
	  
	  public int nextInt(int min, int max){
		  
		   
		 
		  return random.nextInt((max - min) + 1) + min;
		  }
	  
	  
}
