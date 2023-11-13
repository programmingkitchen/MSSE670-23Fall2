import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.fleetrental.model.business.AllBusinessTests;
import com.fleetrental.model.domain.AllDomainTests;
import com.fleetrental.model.services.AllServicesTests;


@RunWith(Suite.class)
@SuiteClasses({AllBusinessTests.class, AllServicesTests.class, AllDomainTests.class})
public class ApplicationTestSuite {

}
