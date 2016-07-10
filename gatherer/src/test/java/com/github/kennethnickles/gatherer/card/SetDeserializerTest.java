package com.github.kennethnickles.gatherer.card;

import android.util.Log;
import com.github.kennethnickles.gatherer.util.CardGsonFactory;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

/**
 * @author kenneth.nickles
 * @since 2016-04-04.
 */
public class SetDeserializerTest {

	@org.junit.Rule
	public MockitoRule rule = MockitoJUnit.rule();

	@Mock
	Log log;

    @Test
    public void sets() throws Exception {
        final InputStream inputStream = getResourceAsStream("sets.json", this);
        final JsonReader jsonReader = new JsonReader(new InputStreamReader(inputStream, "UTF-8"));
        final Gson gson = new CardGsonFactory().createCardGson();
        final Set[] sets = gson.fromJson(jsonReader, Set[].class);
        Assert.assertNotNull(sets);
        Assert.assertEquals(194, sets.length);
    }

    private static InputStream getResourceAsStream(String fileName, Object source) {
        try {
            return source.getClass().getResourceAsStream(fileName);
        } catch (Exception e) {
            return null;
        }
    }
}
