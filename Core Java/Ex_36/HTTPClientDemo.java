package Ex_36;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class HTTPClientDemo {

    public static void main(String[] args) {

        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║      Java HTTP Client API Demo       ║");
        System.out.println("╚══════════════════════════════════════╝\n");

        try {
            // Step 1 — Create HttpClient
            HttpClient client = HttpClient.newBuilder()
                    .version(HttpClient.Version.HTTP_2)
                    .connectTimeout(Duration.ofSeconds(10))
                    .build();

            // ─────────────────────────────────────────
            // REQUEST 1 — GitHub User API
            // ─────────────────────────────────────────
            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
            System.out.println("📡 Request 1: GitHub User API");
            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

            // Step 2 — Build HttpRequest
            HttpRequest githubRequest = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.github.com/users/octocat"))
                    .header("Accept", "application/vnd.github.v3+json")
                    .header("User-Agent", "Java-HttpClient")
                    .GET()
                    .build();

            // Step 3 — Send request and get HttpResponse
            HttpResponse<String> githubResponse = client.send(
                    githubRequest,
                    HttpResponse.BodyHandlers.ofString());

            // Step 4 — Print status and body
            System.out.println("✅ Status Code : "
                    + githubResponse.statusCode());
            System.out.println("📋 Headers     : Content-Type = "
                    + githubResponse.headers()
                    .firstValue("content-type")
                    .orElse("N/A"));
            System.out.println("\n📦 Response Body:");
            System.out.println(prettyPrintJson(
                    githubResponse.body()));

            // ─────────────────────────────────────────
            // REQUEST 2 — Public REST API (JSONPlaceholder)
            // ─────────────────────────────────────────
            System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
            System.out.println("📡 Request 2: JSONPlaceholder Posts API");
            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

            HttpRequest postsRequest = HttpRequest.newBuilder()
                    .uri(URI.create(
                        "https://jsonplaceholder.typicode.com/posts/1"))
                    .GET()
                    .build();

            HttpResponse<String> postsResponse = client.send(
                    postsRequest,
                    HttpResponse.BodyHandlers.ofString());

            System.out.println("✅ Status Code : "
                    + postsResponse.statusCode());
            System.out.println("\n📦 Response Body:");
            System.out.println(prettyPrintJson(
                    postsResponse.body()));

            // ─────────────────────────────────────────
            // REQUEST 3 — GitHub Repos API
            // ─────────────────────────────────────────
            System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
            System.out.println("📡 Request 3: GitHub Repos API");
            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

            HttpRequest reposRequest = HttpRequest.newBuilder()
                    .uri(URI.create(
                        "https://api.github.com/users/octocat/repos"))
                    .header("User-Agent", "Java-HttpClient")
                    .GET()
                    .build();

            HttpResponse<String> reposResponse = client.send(
                    reposRequest,
                    HttpResponse.BodyHandlers.ofString());

            System.out.println("✅ Status Code : "
                    + reposResponse.statusCode());

            // Parse manually — extract repo names
            System.out.println("\n📦 Repositories Found:");
            String body = reposResponse.body();
            String[] parts = body.split("\"name\":");
            for (int i = 1; i < parts.length; i++) {
                String name = parts[i]
                        .split(",")[0]
                        .replace("\"", "")
                        .trim();
                System.out.println("   📁 " + name);
            }

        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    // Simple JSON pretty printer (no library needed)
    static String prettyPrintJson(String json) {
        StringBuilder sb     = new StringBuilder();
        int           indent = 0;
        boolean       inStr  = false;

        for (char c : json.toCharArray()) {
            switch (c) {
                case '"':
                    inStr = !inStr;
                    sb.append(c);
                    break;
                case '{': case '[':
                    sb.append(c);
                    if (!inStr) {
                        sb.append("\n")
                          .append("  ".repeat(++indent));
                    }
                    break;
                case '}': case ']':
                    if (!inStr) {
                        sb.append("\n")
                          .append("  ".repeat(--indent));
                    }
                    sb.append(c);
                    break;
                case ',':
                    sb.append(c);
                    if (!inStr) {
                        sb.append("\n")
                          .append("  ".repeat(indent));
                    }
                    break;
                case ':':
                    sb.append(c);
                    if (!inStr) sb.append(" ");
                    break;
                default:
                    sb.append(c);
            }
        }
        return sb.toString();
    }
}