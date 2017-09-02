import models.User;
import org.junit.Test;
import play.mvc.Http.Response;
import play.test.Fixtures;
import play.test.FunctionalTest;

public class ApplicationTest extends FunctionalTest {

    @Test
    public void testThatIndexPageWorks() {
        Response response = GET("/");
        assertIsOk(response);
        assertContentType("text/html", response);
        assertCharset(play.Play.defaultWebEncoding, response);
    }

    @org.junit.Before
    public void setUp() {
        Fixtures.deleteAllModels();
        Fixtures.loadModels("data.yml");
    }

    @Test
    public void saveUser() {
        User user = new User("demo", "demo", "demo");
        User expectedUser = User.findByUsername("demo");
        assertEquals(expectedUser.fullname, user.fullname);
    }
    
}