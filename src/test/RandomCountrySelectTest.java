package test;

import junit.framework.Assert;
import main.RandomPersonPickerFromCountry;
import org.junit.Test;

import java.util.HashMap;

public class RandomCountrySelectTest {

    @Test
    public void OneCountry(){
        HashMap<String, Long> countries = new HashMap<String, Long>();
        countries.put("A", (long) 10);
        Assert.assertEquals("A", new RandomPersonPickerFromCountry(countries).selectRandomCountry());
    }


    @Test
    public void RandomTwoCountries(){
        HashMap<String, Long> countries = new HashMap<String, Long>();
        countries.put("A", (long) 10);
        countries.put("B", (long) 20);
        String selectedCountry = new RandomPersonPickerFromCountry(countries).selectRandomCountry();
        Assert.assertTrue("A".equals(selectedCountry) || "B".equals(selectedCountry));
    }

    @Test
    public void TwoCountries1(){
        HashMap<String, Long> countries = new HashMap<String, Long>();
        countries.put("A", (long) 10);
        countries.put("B", (long) 20);
        String selectedCountry = new RandomPersonPickerFromCountry(countries).findCountryWherePersonIs((long) 5);
        Assert.assertTrue("A".equals(selectedCountry));
    }
    @Test
    public void TwoCountries2(){
        HashMap<String, Long> countries = new HashMap<String, Long>();
        countries.put("A", (long) 10);
        countries.put("B", (long) 20);
        String selectedCountry = new RandomPersonPickerFromCountry(countries).findCountryWherePersonIs((long) 15);
        Assert.assertTrue("B".equals(selectedCountry));
    }

    @Test
    public void RandomCountry() {
        HashMap<String, Long> countries = new HashMap<String, Long>();
        countries.put("A", (long) 10);
        countries.put("B", (long) 20);
        countries.put("C", (long) 30);
        countries.put("D", (long) 40);
        countries.put("E", (long) 40);
        countries.put("F", (long) 50);
        String selectedCountry = new RandomPersonPickerFromCountry(countries).selectRandomCountry();
        System.out.println(selectedCountry);
        Assert.assertTrue(selectedCountry != null && !selectedCountry.isEmpty() && countries.containsKey(selectedCountry));
    }
}
