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
//            "www.onlineshoes.com",
            "www.shoebuy.com",
//            "www.shoebacca.com",
            "www.planetshoes.com",
            "www.shoemall.com",
            "www.zappos.com",
            "www.payless.com",
//            "www.amazon.com",
//            "www.barnesandnoble.com",
            "www.tulipworld.com",
            "www.hollandbulbfarms.com",
            "www.brecks.com",
            "www.americanmeadows.com",
            "bananarepublic.gap.com",
            "www.woot.com"
    );

    public static String getRandomResource(){

        Random generator = new Random();
        int index = generator.nextInt(targetSites.size()) ;

        return "https://"+ targetSites.get(index);
    }
}
