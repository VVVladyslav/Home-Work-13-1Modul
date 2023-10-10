import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.internal.LinkedTreeMap;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Utilki {

    private static final HttpClient CLIENT = HttpClient.newHttpClient();
    private static final Gson GSON = new Gson();

    public static String sendGet(URI uri) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();
        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public static User sendPost(URI uri, User user) throws IOException, InterruptedException {

        final String requestBody = GSON.toJson(user);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .header("Content-type", "application/json")
                .build();

        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        return GSON.fromJson(response.body(), User.class);
    }

    public static int sendDel(URI uri) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .DELETE()
                .build();

        HttpResponse<String> sen = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        return sen.statusCode();
    }

    public static void  GetTask(URI uri) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();
        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());

        final ArrayList<?> js = GSON.fromJson(response.body().toString(), ArrayList.class);

        for (int i = 0; i < js.size(); i++) {
            LinkedTreeMap f = (LinkedTreeMap) js.get(i);
            Boolean stsus  = (Boolean) f.get("completed");
            double idd  = (double) f.get("id");
            String text  = (String) f.get("title");
            if (!stsus){
                System.out.println("user id = " + idd + ". task = " + text);
            }
        }
    }

    public static void  GetComets(URI uri) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();
        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());

        final ArrayList<?> js = GSON.fromJson(response.body().toString(), ArrayList.class);

        double idd = 0;

        for (int i = 0; i < js.size(); i++) {
            LinkedTreeMap fg = (LinkedTreeMap) js.get(i);
            if (i == js.size() - 1) {
                idd = (double) fg.get("id");
            }
        }
        int idint = (int) idd;
        String uri1 = "https://jsonplaceholder.typicode.com/posts/" + Integer.toString(idint) + "/comments";
        HttpRequest requestSecond = HttpRequest.newBuilder()
                .uri(URI.create(uri1))
                .GET()
                .build();
        HttpResponse<String> responseSecond = CLIENT.send(requestSecond, HttpResponse.BodyHandlers.ofString());

        final ArrayList<?> jsSecond = GSON.fromJson(responseSecond.body().toString(), ArrayList.class);
        String text1 = "";
        for (int i = 0; i < jsSecond.size(); i++) {
            LinkedTreeMap fr = (LinkedTreeMap) jsSecond.get(i);
            text1  = text1 + (String) fr.get("body");
        }
        BufferedWriter write = new BufferedWriter(new FileWriter("user-" + 1 + "-post-" + idint + "-comments.json"));
        write.write("Body = ");
        write.write(text1);
        write.close();
    }
}
