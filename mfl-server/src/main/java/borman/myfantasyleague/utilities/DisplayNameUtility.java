package borman.myfantasyleague.utilities;

public class DisplayNameUtility {

    public static String displayName(String xName) {
        if(xName.contains(",")){
            String[] x = xName.split(",");
            return x[1] + " " + x[0];
        }
        return xName;
    }

}