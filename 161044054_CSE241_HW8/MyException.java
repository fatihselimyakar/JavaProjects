/**
 * The exception class that is extend Exception.
 * @author fatihselimyakar
 * @version 1.0.0
 */
public class MyException extends Exception{
    private String error;
    /**
     * Default constructor.
     */
    public MyException(){
        error="ERROR OCCURED";
    }

    /**
     * One parameter constructor.
     * @param str that is Error information.
     */
    public MyException(String str){
        error=str;
    }
    /**
     * Extending what method.
     * @return error information returnin.
     */
    public String what(){
        return error;
    }
}
