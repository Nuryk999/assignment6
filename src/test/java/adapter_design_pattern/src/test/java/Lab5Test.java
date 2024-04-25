package adapter_design_pattern.src.test.java;

import adapter_design_pattern.apis.OpenMeteoWeather;
import adapter_design_pattern.geoLocation.GeoLocationService;
import adapter_design_pattern.geoLocation.Location;
import adapter_design_pattern.weather.WeatherGeo;
import adapter_design_pattern.weather.WeatherInfo;
import adapter_design_pattern.weather.WeatherAdapter;
import adapter_design_pattern.weather.WeatherCity;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.testng.Assert.*;

public class Lab5Test {

    // WeatherGeo interface should have one method that takes two parameters latitude and longitude of type double
    // and returns a WeatherInfo object
    @org.testng.annotations.Test
    public void assertWeatherGeoInterface() {
        Assert.assertEquals(1, WeatherGeo.class.getDeclaredMethods().length);
        Method method = WeatherGeo.class.getDeclaredMethods()[0];
        Assert.assertEquals(WeatherInfo.class, method.getReturnType());
        Assert.assertEquals(2, method.getParameters().length);
        for (Parameter p : method.getParameters()) {
            assertEquals(double.class.getName(), p.getType().getTypeName());
        }
    }

    // WeatherCity interface should have one method that takes one parameter (city name) of type String
    // and returns a WeatherInfo object
    @org.testng.annotations.Test
    public void assertWeatherCityInterface() {
        Assert.assertEquals(1, WeatherCity.class.getDeclaredMethods().length);
        Method method = WeatherCity.class.getDeclaredMethods()[0];
        Assert.assertEquals(WeatherInfo.class, method.getReturnType());
        Assert.assertEquals(1, method.getParameters().length);
        assertEquals(String.class.getName(), method.getParameters()[0].getType().getTypeName());
    }


    // Should have an adapter class, WeatherAdapter, that implements the WeatherCity interface
    @org.testng.annotations.Test
    public void assertAdapterImplementsInterfaces() {
        List<Class<?>> interfaces = Arrays.asList(WeatherAdapter.class.getInterfaces());
        Assert.assertEquals(1, interfaces.size());
        Assert.assertTrue(interfaces.contains(WeatherCity.class));
    }

    // Should have an adapter class, WeatherAdapter, that has a method that takes city name and returns weather info
    @org.testng.annotations.Test
    public void assertAdapterMethod() {
        boolean passed = false;
        for (Method method : WeatherAdapter.class.getDeclaredMethods()) {
            if (method.getParameterCount() == 1 && method.getName().equalsIgnoreCase("getWeatherInfo")) {
                Assert.assertEquals(1, method.getParameters().length);
                assertEquals(method.getReturnType().getTypeName(), WeatherInfo.class.getName());
                passed = true;
            }
        }
        Assert.assertTrue(passed);
    }

    // assert that OpenMeteo Weather API is working
    @org.testng.annotations.Test
    public void testOpenMeteoWeatherAPI() {
        OpenMeteoWeather openMeteoWeather = new OpenMeteoWeather();
        WeatherInfo weatherInfo = openMeteoWeather.getWeatherInfo(52.52, 13.41);
        Assert.assertNotNull(weatherInfo);
        Assert.assertTrue(weatherInfo.getDates().size() > 0);
        Assert.assertTrue(weatherInfo.getMaxTemps().length > 0);
        Assert.assertTrue(weatherInfo.getMinTemps().length > 0);
    }

    // GeoLocationService should take a city name and returns a geo coordinates.
    @org.testng.annotations.Test
    public void assertGeoLocationServiceReturnsCity() {
        GeoLocationService geoLocationService = new GeoLocationService();
        Location expectedLocation = new Location(24.466667, 39.6);
        Assert.assertEquals(expectedLocation, geoLocationService.search("Medina"));
    }

    // Test using the Adapter pattern
    @Test
    public void getWeatherInfo() {
        // Get the weather for Jeddah (21.543333, 39.172778)
        WeatherGeo weatherGeo = new OpenMeteoWeather();
        WeatherCity weatherAdapter = new WeatherAdapter(weatherGeo);
        WeatherInfo weatherInfo = weatherAdapter.getWeatherInfo("Jeddah");

        Assert.assertNotNull(weatherInfo);
        Assert.assertTrue(weatherInfo.getDates().size() > 0);
        Assert.assertTrue(weatherInfo.getMaxTemps().length > 0);
        Assert.assertTrue(weatherInfo.getMinTemps().length > 0);
    }
}


