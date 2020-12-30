package api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.LibraryBook;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
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

            if (response.statusCode() == 200) {
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
                } else if (response.statusCode() == 401) {
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

    public List<LibraryBook> getBooks(String token) {

        String HTTP_URL = "https://java-library-api.herokuapp.com/";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(HTTP_URL + "api/library/books/500"))
                .build();
        HttpResponse<String> response = null;

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());

            ObjectMapper mapper = new ObjectMapper();
            List<LibraryBook> bookList = mapper.readValue(response.body(), new TypeReference<>() {
            });

            return bookList;
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return new ArrayList<LibraryBook>();
    }
}
