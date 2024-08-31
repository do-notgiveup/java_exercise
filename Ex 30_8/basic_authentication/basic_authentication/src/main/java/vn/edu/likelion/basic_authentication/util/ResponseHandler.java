package vn.edu.likelion.basic_authentication.util;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ResponseHandler {

    String status;
    String message;
    Object data;

}
