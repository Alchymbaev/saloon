package kg.mega.saloon.models.responses;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Response {
    private String message;
    private String description;
    private Object data;

    public Response(String message) {
        this.message = message;
    }


}
