package module13;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.stream.Collectors;

public class Task3 {
    public static void main(String[] args) {
        String url = "https://jsonplaceholder.typicode.com";
        int idUser = 1;
        ManagerTask managerTask = new ManagerTask();
        managerTask.printOpenTask(idUser, url);

    }
}
class ManagerTask {

    public List<Task> getTasks(int userId, String url) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url + "/users/" + userId + "/todos"))
                .GET()
                .build();
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        Type type = TypeToken
                .getParameterized(List.class, Task.class)
                .getType();

        return new Gson().fromJson(response.body(), type);
    }

    public List<Task> getOpenTask(int userId, String url) throws IOException, InterruptedException {
        return getTasks(userId, url).stream()
                .filter((task) -> !task.isCompleted())
                .collect(Collectors.toList());
    }

    public void printOpenTask(int userId, String url){
        List<Task> openTask;

        try {
            openTask = getOpenTask(userId, url);
        } catch (IOException|InterruptedException e) {
            throw new RuntimeException(e);
        }

        for (Task task : openTask) {
            System.out.println(task);
        }
    }
}
class Task {
    int userId;
    int id;
    String title;
    boolean completed;

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return completed;
    }

    @Override
    public String toString() {
        return "NotCompletedTask{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }
}