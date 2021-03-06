package demo.okhttp;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zacconding
 * @Date 2018-09-05
 * @GitHub : https://github.com/zacscoding
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class PostRequestTest {

    @LocalServerPort
    private int port;
    private OkHttpClient client;

    @Before
    public void setUp() {
        this.client = new OkHttpClient();
    }

    // Basic POST
    @Test
    public void whenSendPostRequestThenCorrect() throws IOException {
        RequestBody formBody = new FormBody.Builder().add("username", "zaccoding").add("hobby", "coding").build();

        Request request = new Request.Builder().url("http://localhost:" + port + "/okhttp/users").post(formBody).build();

        Call call = client.newCall(request);
        Response response = call.execute();
        displayResponse(response);
    }

    // POST with Authorization
    // CustomToken Authentication
    // RETRY AFTER SPRING SECURITY CHAPTER!!
    /*@Test
    public void whenSendPostRequestWithAuthorizationThenCorrect() throws IOException {
        String postBody = "{\"name\" : \"zaccoding\"}";

        Request request = new Request.Builder().url("http://localhost:" + port + "/okhttp/auth")
            .addHeader("Authorization", Credentials.basic("test1", "test1"))
            .post(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), postBody))
            .build();

        Call call = client.newCall(request);
        Response response = call.execute();
        displayResponse(response);
    }*/

    @Test
    public void whenPostJsonThenCorrect() throws IOException {
        String json = "{\"id\" : 1, \"name\" : \"hivava\"}";

        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);

        Request request = new Request.Builder().url("http://localhost:" + port + "/okhttp/details").post(body).build();

        Call call = client.newCall(request);
        Response response = call.execute();
        displayResponse(response);
    }

    @Test
    public void whenSendMultipartRequestThenCorrect() throws IOException {
        RequestBody requestBody = new MultipartBody.Builder().setType(MultipartBody.FORM).addFormDataPart("username", "hivava")
                                                             .addFormDataPart("file", "file.json", RequestBody
                                                                 .create(MediaType.parse("application/octet-stream"),
                                                                     new ClassPathResource("file.json").getFile())).build();

        Request request = new Request.Builder().url("http://localhost:" + port + "/okhttp/multipart").post(requestBody).build();

        Call call = client.newCall(request);
        Response response = call.execute();
        displayResponse(response);
    }


    private void displayResponse(Response response) throws IOException {
        System.out.println(">> Display response");
        System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(response));
        System.out.println(">> body : " + response.body().string());
    }
}
