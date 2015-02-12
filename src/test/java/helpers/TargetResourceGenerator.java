package helpers;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by ypolshchykau on 12.02.2015.
 */
public class TargetResourceGenerator {
    public final static List<String> targetSites = Arrays.asList(
            "www.shoes.com",
            "www.onlineshoes.com",
            "www.shoebuy.com",
            "www.shoebacca.com",
            "www.planetshoes.com",
            "www.woot.com"
    );

    public static String getRandomResource(){

        Random generator = new Random();
        int index = generator.nextInt(targetSites.size()) ;

        return "https://"+ targetSites.get(index);
    }
}
