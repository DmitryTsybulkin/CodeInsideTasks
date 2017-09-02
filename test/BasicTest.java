import models.User;
import org.junit.Test;
import play.test.UnitTest;

public class BasicTest extends UnitTest {

    @Test
    public void createAndRetrieveUser() {
        new User("demo", "demo", "demo").save();
        User user = User.findByUsername("demo");
        assertNotNull(user);
        assertEquals("demo", user.fullname);
    }
}
