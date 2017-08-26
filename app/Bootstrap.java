

/*Created by Dmitry on 26.08.2017.*/

import models.Books;
import models.User;
import play.jobs.Job;
import play.jobs.OnApplicationStart;
import play.test.Fixtures;

@OnApplicationStart
public class Bootstrap extends Job {
    public void testdata() {
        if (User.count() == 0 || Books.count() == 0) {
            Fixtures.loadModels("data.yml");
        }
    }
}
