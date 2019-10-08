import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import javax.json.JsonArray;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarDealerIT {
    private static Client client;
    private static WebTarget tut;

    @BeforeAll
    public static void init(){
        client = ClientBuilder.newClient();
        tut = client.target("http://localhost:8082/cardealer/getCars");
    }

    @Test
    public void test01_getFreeCars(){
        Response response =tut.request().get() ;
        assertEquals(response.getStatus(),200);
        JsonArray jsonArray  = response.readEntity(JsonArray.class);
        assertEquals(jsonArray.getJsonObject(0).getString("chassisNumber"), "WDD 169 007-1J-236589");
    }
}