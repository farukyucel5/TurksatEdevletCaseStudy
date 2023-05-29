package utilities;
import Pojos.CreatingBoardExpectedBody;
import Pojos.CreatingListExpectedBody;
import Pojos.CreatingTwoCardsExpectedBody;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.util.ArrayList;
import java.util.List;
import static hooks.api.HooksAPI.spec;
import static io.restassured.RestAssured.given;

public class ReuseableMethods {
    Response response;
    public String fullPath;

    private String boardId;
    private String listId;
    private final List<String> cardIdLists = new ArrayList<>();

    public  String setTheEndPoint(String rawPaths, String operation) {
        String[] paths = rawPaths.split(",");
        StringBuilder tempPath = new StringBuilder("{");

        for (int i = 0; i < paths.length; i++) {
            String key = "pp" + i;
            String value = paths[i].trim();
            spec.pathParam(key, value);
            tempPath.append(key).append("}/{");
        }

        tempPath.deleteCharAt(tempPath.lastIndexOf("{"));
        tempPath.deleteCharAt(tempPath.lastIndexOf("/"));

        addingQueryParams(operation,tempPath);
        return tempPath.toString();
    }

    public void addingQueryParams(String operation,StringBuilder tempPath){
        switch (operation) {
            case "Creation" -> spec.queryParam("token", ConfigReader.getProperty("Token"))
                                   .queryParam("name", ConfigReader.getProperty("BoardName"))
                                   .queryParam("key", ConfigReader.getProperty("ApiKey"));

            case "Lists" -> spec.queryParam("key", ConfigReader.getProperty("ApiKey"))
                                .queryParam("idBoard", boardId)
                                .queryParam("name", ConfigReader.getProperty("ListName"))
                                .queryParam("token", ConfigReader.getProperty("Token"));

            case "Cards" -> spec.queryParam("idList", listId)
                                .queryParam("token", ConfigReader.getProperty("Token"))
                                .queryParam("key", ConfigReader.getProperty("ApiKey"));

            case "Card update" -> {
                    spec.pathParam("pp3", cardIdLists.get(1));
                    tempPath.append("/{pp3}");
                    spec.queryParam("key", ConfigReader.getProperty("ApiKey"))
                        .queryParam("token", ConfigReader.getProperty("Token"))
                        .queryParam("name", "query1")
                        .queryParam("desc", "First Query");
            }

            case "Delete cart" -> {
                    spec.pathParam("pp3", cardIdLists.get(1));
                         tempPath.append("/{pp3}");
                    spec.queryParam("key", ConfigReader.getProperty("ApiKey"))
                        .queryParam("token", ConfigReader.getProperty("Token"));

            }
            case "Delete board" -> {
                    spec.pathParam("pp3", boardId);
                         tempPath.append("/{pp3}");
                    spec.queryParam("key", ConfigReader.getProperty("ApiKey"))
                        .queryParam("token", ConfigReader.getProperty("Token"));

            }


        }
    }

    public void sendTheQuery(String operation,String fullPath){
        switch (operation){
            case "creating a board"->{
                response = given()
                        .accept(ContentType.JSON)
                        .contentType(ContentType.JSON)
                        .spec(spec)
                        .when()
                        .post(fullPath);
                CreatingBoardExpectedBody responseBody=response.as(CreatingBoardExpectedBody.class);
                boardId=responseBody.getId();
            }
            case "creating a list"->{
                response = given()
                        .accept(ContentType.JSON)
                        .contentType(ContentType.JSON)
                        .spec(spec)
                        .when()
                        .post(fullPath);
                CreatingListExpectedBody responseBody=response.as(CreatingListExpectedBody.class);
                listId=responseBody.getId();
            }
            case "creating two cards"->{
                for (int i = 0; i < 2; i++) {
                    CreatingTwoCardsExpectedBody responseBody=response.as(CreatingTwoCardsExpectedBody.class);
                    response = given()
                            .accept(ContentType.JSON)
                            .contentType(ContentType.JSON)
                            .spec(spec)
                            .when()
                            .post(fullPath);
                    cardIdLists.add(responseBody.getId());
                }

            }

            case "updating cards" -> response = given()
                    .accept(ContentType.JSON)
                    .contentType(ContentType.JSON)
                    .spec(spec)
                    .when()
                    .put(fullPath);
            case "deleting cards", "deleting board" ->response = given()
                    .accept(ContentType.JSON)
                    .contentType(ContentType.JSON)
                    .spec(spec)
                    .when()
                    .delete(fullPath);

        }
    }

}
