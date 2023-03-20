package module13;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class Task2 {

    public static void main(String[] args) throws IOException, InterruptedException {
        String url = "https://jsonplaceholder.typicode.com";
        int idUser = 4;
        int idPost = CommentResearcher.getIdLastPost(idUser, url);
        CommentResearcher.printCommentsToFile(idUser, idPost, url);
    }
}
class CommentResearcher {

    public static String getComments(int id, String url) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url + "/posts/" + id + "/comments"))
                .GET()
                .build();
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }


    public static int getIdLastPost(int usersId, String url) throws IOException, InterruptedException {
        return getPosts(usersId, url).stream()
                .max((post1, post2) -> post1.getUserId() - post2.getId())
                .get()
                .getId();

    }

    public static List<Post> getPosts(int usersId, String url) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url + "/users/" + usersId + "/posts"))
                .GET()
                .build();
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        Type type = TypeToken
                .getParameterized(List.class, Post.class)
                .getType();

        List<Post> posts = new Gson().fromJson(response.body(), type);

        return posts;

    }


    public static void printCommentsToFile(int idUser, int idPost, String url) throws IOException, InterruptedException {
        System.out.println("getComments(id, url) = " + getComments(idPost, url));
        try (FileWriter fw = new FileWriter("user-" + idUser + "-post-" + idPost + "-comments.json")) {
            fw.write(getComments(idPost, url));
        }catch (Exception e){
        }
    }
}
 class Post {
    private int userId;
    private int id;
    private String title;
    private String body;

    public Post(int userId, int id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Post{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
