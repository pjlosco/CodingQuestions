package puzzle;

import junit.framework.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Random;

/**
 * Create a function which returns a randomly selected country weighted by the countries population size
 */
public class RandomPersonPickerFromCountry {

    HashMap<String, Long> countryMap;
    int totalPopulation = 0;

    public RandomPersonPickerFromCountry(HashMap<String, Long> countryMap) {
        this.countryMap = countryMap;
        for (HashMap.Entry<String, Long> entry : countryMap.entrySet()) {
            totalPopulation += entry.getValue();
        }

    }

    public String selectRandomCountry() {
        return findCountryWherePersonIs((long) (Math.random() * totalPopulation));
    }

    public String findCountryWherePersonIs(Long person) {
        for (HashMap.Entry<String, Long> country : countryMap.entrySet()) {
            person = person - country.getValue();
            if (person < 1) {
                return country.getKey();
            }
        }
        return "";
    }

}
