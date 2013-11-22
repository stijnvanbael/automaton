package be.appify.automaton.test.client;

import be.appify.automaton.api.Event;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class TrainTest {

    @Test
    public void shouldAddEventHandlers() throws IOException, URISyntaxException {
        Train train = new Train();
        train.eventReceived(new Event("event-handler", readResource("/topology.js", Charset.defaultCharset())));
        train.eventReceived(new Event("topology",
                "straight:200",
                "curve:100",
                "straight:200",
                "curve:100",
                "straight:200",
                "curve:100",
                "straight:200",
                "curve:100",
                "loop"));
        Object topology = train.variable("topology");
        assertThat(topology, notNullValue());
    }

    static String readResource(String location, Charset encoding) throws IOException, URISyntaxException {
        byte[] encoded = Files.readAllBytes(Paths.get(TrainTest.class.getResource(location).toURI()));
        return encoding.decode(ByteBuffer.wrap(encoded)).toString();
    }
}
