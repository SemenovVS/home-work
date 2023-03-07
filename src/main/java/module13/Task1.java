package module13;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Task1 {
    private static  String url ="https://jsonplaceholder.typicode.com/users";
    public static void main(String[] args) throws InterruptedException, IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

  //          RequestMethods.post(url, gson.toJson(new NewObject()));
  //      RequestMethods.put(url, 1, gson.toJson(new NewObject()));
  //          RequestMethods.delete(url, 1);
  //          RequestMethods.getAll(url);
  //         RequestMethods.getOneId(url, 1);
       RequestMethods.getOneName(url, "Bret");
    }
}



class NewObject {

    int id = 1;
    String name = "Leanne Graham";
    String username = "Bret";
    String email = "Sincere@april.biz";
    Address address = new Address();
    String phone = "1-770-736-8031 x56442";
    String website = "hildegard.org";
    Company company = new Company();
    class Address {
        String street = "Kulas Light";
        String suite = "Apt. 556";
        String city = "Gwenborough";
        String zipcode = "92998-3874";
        Geo geo = new Geo();

        class Geo {
            double lat = -37.3159;
            double lng = 81.1496;
        }
    }

    class Company {
        String name = "Romaguera-Crona";
        String catchPhrase = "Multi-layered client-server neural-net";
        String bs = "harness real-time e-markets";
    }
}



 class RequestMethods {

    public static void post(String url, String body) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .method("POST", HttpRequest.BodyPublishers.ofString(body))
                .build();
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }

    public static void put(String url, int id, String body) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url + "/" + id))
                .header("Content-Type", "application/json")
                .method("PUT", HttpRequest.BodyPublishers.ofString(body))
                .build();
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }

    public static void delete(String url, int id) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url + "/" + id))
                .DELETE()
                .build();
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
    }

    public static void getAll(String url) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }

    public static void getOneId(String url, int id) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url + "/" + id))
                .GET()
                .build();
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }

    public static void getOneName(String url, String userName) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url + "?username=" + userName))
                .GET()
                .build();
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }
}



