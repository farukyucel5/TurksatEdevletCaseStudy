
package stepDefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import utilities.ReuseableMethods;
public class TrelloSteps {
    public String fullPath;
    ReuseableMethods reuseableMethods=new ReuseableMethods();

    @Given("setting the endpoint with path parameter {string} and query parameter {string}")
    public void settingTheEndpointWithPathParameterAndQueryParameter(String rawPaths, String operation) {
        fullPath =reuseableMethods.setTheEndPoint(rawPaths,operation);
    }
    @And("send the query associated with {string}")
    public void sendTheQueryAssociatedWith(String operation) {
        reuseableMethods.sendTheQuery(operation,fullPath);
    }


}
