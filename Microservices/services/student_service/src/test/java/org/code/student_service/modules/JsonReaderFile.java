package org.code.student_service.modules;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;

import javax.swing.text.html.Option;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JsonReaderFile {

    public static List<JsonNode> readJsonFile(String fileName) throws RuntimeException {
        List<JsonNode> jsonList = new ArrayList<>();
        try {
            ClassPathResource resource = new ClassPathResource(fileName);
            try (InputStream inputStream = resource.getInputStream()) {
                Optional.ofNullable(new ObjectMapper().readTree(inputStream))
                        .map(node -> node.get("data"))
                        .orElseThrow(() -> new RuntimeException("Error reading file: " + fileName))
                        .forEach(jsonList::add);

            }
        } catch (Exception e) {
            throw new RuntimeException("Error reading file: " + fileName, e);
        }

        return jsonList;
    }

}
