package api;

import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;

public class ApiConfig {

    String HTTP_URL = "https://java-library-api.herokuapp.com/";
    HttpClient client = HttpClient.newHttpClient();

    public String registration(String username, String password, String email) throws Exception {

        JSONObject json = new JSONObject();
        json.put("username", username);
        json.put("password", password);
        json.put("email", email);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(HTTP_URL + "register"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json.toString()))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) { // status code 200 oznacza, że zapytanie się udało
                return response.body();
            } else if (response.statusCode() == 409) {
                throw new Exception("dany username lub email już istnieje");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String login(String username, String password) throws Exception {

        JSONObject json = new JSONObject();
        json.put("username", username);
        json.put("password", password);


        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(HTTP_URL + "login"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json.toString()))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response != null) {
                if (response.statusCode() == 200) {
                    Optional<String> authorization = response.headers().firstValue("authorization");

                    if (authorization.isPresent()) {
                        String token = authorization.get();
                        return token;
                    } else {
                        return null;
                    }
                } else if (response.statusCode() == 403) {
                    throw new Exception("Incorrect login or password");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }
}
