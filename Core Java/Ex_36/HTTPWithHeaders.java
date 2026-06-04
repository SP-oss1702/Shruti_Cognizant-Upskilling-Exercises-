package Ex_36;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Map;

public class HTTPWithHeaders {

    public static void main(String[] args) {

        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║    HTTP Status Codes & Headers Demo  ║");
        System.out.println("╚══════════════════════════════════════╝\n");

        try {
            HttpClient client = HttpClient.newBuilder()
                    .connectTimeout(Duration.ofSeconds(10))
                    .build();

            // ─────────────────────────────────────────
            // Test different status codes
            // ─────────────────────────────────────────
            String[] urls = {
                "https://jsonplaceholder.typicode.com/posts/1",
                "https://jsonplaceholder.typicode.com/posts/999",
                "https://httpstat.us/200",
                "https://httpstat.us/404"
            };

            for (String url : urls) {
                System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
                System.out.println("🌐 URL: " + url);

                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(url))
                        .header("User-Agent", "Java-HttpClient/11")
                        .GET()
                        .build();

                HttpResponse<String> response = client.send(
                        request,
                        HttpResponse.BodyHandlers.ofString());

                int statusCode = response.statusCode();
                System.out.println("📊 Status : "
                        + statusCode + " "
                        + getStatusMessage(statusCode));
                System.out.println("📋 Headers:");

                // Print selected response headers
                Map<String, java.util.List<String>> headers
                        = response.headers().map();
                String[] importantHeaders = {
                    "content-type",
                    "content-length",
                    "server",
                    "date"
                };

                for (String h : importantHeaders) {
                    if (headers.containsKey(h)) {
                        System.out.println("   " + h
                                + " : " + headers.get(h));
                    }
                }
            }

            // ─────────────────────────────────────────
            // Status Code Reference
            // ─────────────────────────────────────────
            System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
            System.out.println("📖 HTTP Status Code Reference:");
            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
            System.out.println("  ✅ 200 — OK (Success)");
            System.out.println("  ✅ 201 — Created");
            System.out.println("  ✅ 204 — No Content");
            System.out.println("  ⚠️  301 — Moved Permanently");
            System.out.println("  ⚠️  302 — Found (Redirect)");
            System.out.println("  ❌ 400 — Bad Request");
            System.out.println("  ❌ 401 — Unauthorized");
            System.out.println("  ❌ 403 — Forbidden");
            System.out.println("  ❌ 404 — Not Found");
            System.out.println("  ❌ 500 — Internal Server Error");

        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    static String getStatusMessage(int code) {
        return switch (code) {
            case 200 -> "✅ OK";
            case 201 -> "✅ Created";
            case 204 -> "✅ No Content";
            case 301 -> "⚠️  Moved Permanently";
            case 302 -> "⚠️  Found";
            case 400 -> "❌ Bad Request";
            case 401 -> "❌ Unauthorized";
            case 403 -> "❌ Forbidden";
            case 404 -> "❌ Not Found";
            case 500 -> "❌ Internal Server Error";
            default  -> "ℹ️  Unknown";
        };
    }
}