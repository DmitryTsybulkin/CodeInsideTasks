

/*Created by Dmitry on 26.08.2017.*/


import models.*;
import play.jobs.*;
import play.jobs.OnApplicationStart;
import play.test.*;

@OnApplicationStart
public class Bootstrap extends Job {
    public void doJob() {
        if (User.count() == 0) {
            Fixtures.loadModels("initial-data.yml");
        }
    }
}