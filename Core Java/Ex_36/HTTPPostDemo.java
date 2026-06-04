package Ex_36;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class HTTPPostDemo {

    public static void main(String[] args) {

        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║       HTTP POST Request Demo         ║");
        System.out.println("╚══════════════════════════════════════╝\n");

        try {
            // Step 1 — Create HttpClient
            HttpClient client = HttpClient.newBuilder()
                    .connectTimeout(Duration.ofSeconds(10))
                    .build();

            // ─────────────────────────────────────────
            // POST REQUEST — Create a new post
            // ─────────────────────────────────────────
            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
            System.out.println("📤 POST Request — Create New Post");
            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

            // Step 2 — JSON body to send
            String jsonBody = """
                    {
                        "title": "My Java Post",
                        "body": "This post was created using Java HttpClient",
                        "userId": 1
                    }
                    """;

            System.out.println("📦 Sending Body:");
            System.out.println(jsonBody);

            // Step 3 — Build POST request
            HttpRequest postRequest = HttpRequest.newBuilder()
                    .uri(URI.create(
                        "https://jsonplaceholder.typicode.com/posts"))
                    .header("Content-Type", "application/json")
                    .header("Accept", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                    .build();

            // Step 4 — Send and get response
            HttpResponse<String> postResponse = client.send(
                    postRequest,
                    HttpResponse.BodyHandlers.ofString());

            System.out.println("✅ Status Code : "
                    + postResponse.statusCode());
            System.out.println("\n📥 Response Body:");
            System.out.println(postResponse.body());

            // ─────────────────────────────────────────
            // PUT REQUEST — Update a post
            // ─────────────────────────────────────────
            System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
            System.out.println("✏️  PUT Request — Update Post");
            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

            String updateBody = """
                    {
                        "id": 1,
                        "title": "Updated Title",
                        "body": "Updated body content",
                        "userId": 1
                    }
                    """;

            HttpRequest putRequest = HttpRequest.newBuilder()
                    .uri(URI.create(
                        "https://jsonplaceholder.typicode.com/posts/1"))
                    .header("Content-Type", "application/json")
                    .PUT(HttpRequest.BodyPublishers.ofString(updateBody))
                    .build();

            HttpResponse<String> putResponse = client.send(
                    putRequest,
                    HttpResponse.BodyHandlers.ofString());

            System.out.println("✅ Status Code : "
                    + putResponse.statusCode());
            System.out.println("\n📥 Response Body:");
            System.out.println(putResponse.body());

            // ─────────────────────────────────────────
            // DELETE REQUEST
            // ─────────────────────────────────────────
            System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
            System.out.println("🗑️  DELETE Request — Delete Post");
            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

            HttpRequest deleteRequest = HttpRequest.newBuilder()
                    .uri(URI.create(
                        "https://jsonplaceholder.typicode.com/posts/1"))
                    .DELETE()
                    .build();

            HttpResponse<String> deleteResponse = client.send(
                    deleteRequest,
                    HttpResponse.BodyHandlers.ofString());

            System.out.println("✅ Status Code : "
                    + deleteResponse.statusCode());
            System.out.println("📥 Response    : "
                    + (deleteResponse.body().isEmpty()
                       ? "Post deleted successfully!"
                       : deleteResponse.body()));

        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
}