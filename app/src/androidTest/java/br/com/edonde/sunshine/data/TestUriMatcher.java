/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package br.com.edonde.sunshine.data;

import android.content.UriMatcher;
import android.net.Uri;
import android.test.AndroidTestCase;

import br.com.edonde.sunshine.data.WeatherContract.LocationEntry;
import br.com.edonde.sunshine.data.WeatherContract.WeatherEntry;

/*
    Uncomment this class when you are ready to test your UriMatcher.  Note that this class utilizes
    constants that are declared with package protection inside of the UriMatcher, which is why
    the test must be in the same data package as the Android app code.  Doing the test this way is
    a nice compromise between data hiding and testability.
 */
public class TestUriMatcher extends AndroidTestCase {
    private static final String LOCATION_QUERY = "London, UK";
    private static final long TEST_DATE = 1419033600L;  // December 20th, 2014
    private static final long TEST_LOCATION_ID = 10L;

    // content://com.example.android.sunshine.app/weather"
    private static final Uri TEST_WEATHER_DIR = WeatherEntry.CONTENT_URI;
    private static final Uri TEST_WEATHER_WITH_LOCATION_DIR = WeatherEntry.buildWeatherLocation(LOCATION_QUERY);
    private static final Uri TEST_WEATHER_WITH_LOCATION_AND_DATE_DIR = WeatherEntry.buildWeatherLocationWithDate(LOCATION_QUERY, TEST_DATE);
    // content://com.example.android.sunshine.app/location"
    private static final Uri TEST_LOCATION_DIR = LocationEntry.CONTENT_URI;

    /*
        Students: This function tests that your UriMatcher returns the correct integer value
        for each of the Uri types that our ContentProvider can handle.  Uncomment this when you are
        ready to test your UriMatcher.
     */
    public void testUriMatcher() {
        UriMatcher testMatcher = WeatherProvider.buildUriMatcher();

        assertEquals("Error: The WEATHER URI was matched incorrectly.",
                WeatherProvider.WEATHER, testMatcher.match(TEST_WEATHER_DIR));
        assertEquals("Error: The WEATHER WITH LOCATION URI was matched incorrectly.",
                WeatherProvider.WEATHER_WITH_LOCATION, testMatcher.match(TEST_WEATHER_WITH_LOCATION_DIR));
        assertEquals("Error: The WEATHER WITH LOCATION AND DATE URI was matched incorrectly.",
                WeatherProvider.WEATHER_WITH_LOCATION_AND_DATE, testMatcher.match(TEST_WEATHER_WITH_LOCATION_AND_DATE_DIR));
        assertEquals("Error: The LOCATION URI was matched incorrectly.",
                WeatherProvider.LOCATION, testMatcher.match(TEST_LOCATION_DIR));
    }
}
