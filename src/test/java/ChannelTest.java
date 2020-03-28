import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ChannelTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getName() {
        // Given
        Channel channel = new Channel();

        // When
        String actual = channel.setName("John");
        String expected = channel.getName();

        // Then
        Assert.assertEquals(expected, actual);
        }

    @Test
    public void setName() {
        // Given
        Channel channel = new Channel();
        String expected = "Leon";

        // When
        channel.setName(expected);
        String actual = channel.getName();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAdmins() {
    }

    @Test
    public void setAdmins() {
    }

    @Test
    public void getTopic() {
    }

    @Test
    public void setTopic() {
    }

    @Test
    public void getColors() {
    }

    @Test
    public void setColors() {
    }

    @Test
    public void members() {
    }

    @Test
    public void messages() {
    }
}