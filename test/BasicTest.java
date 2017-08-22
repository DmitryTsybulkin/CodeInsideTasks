import models.User;
import org.junit.Test;
import play.test.UnitTest;

public class BasicTest extends UnitTest {

    @Test
    public void createAndRetrieveUser() {
        new User("bob@gmail.com", "secret", "Bob").save();
        User bob = User.find("byEmail", "bob@gmail.com").first();
        assertNotNull(bob);
        assertEquals("Bob", bob.fullname);
    }
}
