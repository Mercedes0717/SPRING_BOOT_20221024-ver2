
package com.example.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Controller for handling file upload requests.
 */
@Controller
@RequiredArgsConstructor
public class FileController {

    @Value("${spring.servlet.multipart.location}")
    private String uploadFolder; // Directory for file uploads

    /**
     * Handles email upload requests and saves the email, subject, and message to a file.
     *
     * @param email               The email address of the sender.
     * @param subject             The subject of the email.
     * @param message             The body of the email.
     * @param redirectAttributes  Redirect attributes for user feedback.
     * @return Redirect to success or error page.
     */
    @PostMapping("/upload-email")
    public String uploadEmail(@RequestParam("email") String email,
                              @RequestParam("subject") String subject,
                              @RequestParam("message") String message,
                              RedirectAttributes redirectAttributes) {
        try {
            Path uploadPath = Paths.get(uploadFolder).toAbsolutePath();
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath); // Ensure upload folder exists
            }
            // Sanitize the email for use in a filename
            String sanitizedEmail = email.replaceAll("[^a-zA-Z0-9]", "_");
            Path filePath = uploadPath.resolve(sanitizedEmail + "_" + System.currentTimeMillis() + ".txt");
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath.toFile()))) {
                writer.write("메일 제목: " + subject);
                writer.newLine();
                writer.write("요청 메시지:");
                writer.newLine();
                writer.write(message);
            }
            redirectAttributes.addFlashAttribute("message", "메일 내용이 성공적으로 업로드되었습니다!");
        } catch (IOException e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("message", "업로드 중 오류가 발생했습니다.");
            return "redirect:/error_page";
        }
        return "redirect:/upload_end";
    }
}
