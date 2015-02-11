package helpers;

/**
 * Created by dell on 11.02.2015.
 */
public class GetCurrentClassName {

    public static String getCurrentClassName(Class classParam){
        Class<?> enclosingClass = classParam.getEnclosingClass();
        String className="";
        if (enclosingClass != null) {
            className = enclosingClass.getName();
        } else {
            className= classParam.getName();
        }

        return  className;
    }
}
