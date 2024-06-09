package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SimpleJavaApp {

    public static void main(String[] args) {
        SpringApplication.run(SimpleJavaApp.class, args);
    }
}

@RestController
class QueryController {

    @GetMapping("/query")
    public String query(@RequestParam(value = "string", defaultValue = "Please do it in this format: /query?string=(insert string here)") String query) {
        String response = "<html><head>"
                + "<style>"
                + "body {"
                + "  display: flex;"
                + "  justify-content: center;"
                + "  align-items: center;"
                + "  height: 100vh;"
                + "  margin: 0;"
                + "}"
                + "h1 {"
                + "  text-align: center;"
                + "}"
                + "</style>"
                + "</head><body>"
                + "<h1>Query String = " + query + "</h1>"
                + "<script>"
                + "const urlParams = new URLSearchParams(window.location.search);"
                + "console.log('Query String:', window.location.search);"
                + "for (const [key, value] of urlParams) {"
                + "  console.log(`${key}: ${value}`);"
                + "}"
                + "</script>"
                + "</body></html>";

        // Print query string to the server console
        System.out.println("Query String: " + query);
        
        return response;
    }
}
