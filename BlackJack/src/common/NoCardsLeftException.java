package common;

public class NoCardsLeftException extends Exception{
	
	private static final long serialVersionUID = 1997753363232807009L;
	
	public NoCardsLeftException(String message){
		super(message);
	}
	
	 public NoCardsLeftException()
     {
     }

    
     public NoCardsLeftException(Throwable cause)
     {
         super(cause);
     }

     
     
}


//throw new NoCardsLeftException