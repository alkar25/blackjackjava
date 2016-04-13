package test;

import main.IRandomWrapper;

/**
 * 
 * @author Stephen Gentles
 *
 */
public class StubbedRandomWrapper implements IRandomWrapper {

	 int numberOfCalls = 0;
	   public int nextInt(int n){
	  	 return this.numberOfCalls++;
	  }
	   
	   public int nextInt(int min, int max){
		  	 return this.numberOfCalls++;
		  }

}
