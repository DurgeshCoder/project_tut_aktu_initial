package com.project.payload;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ApiResponse {
    private String message;
    private Boolean success;
    private HttpStatus status;

    public static ApiResponse getDefaultDeleteInstance(String entityName) {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage(entityName + " is deleted successfully");
        apiResponse.setStatus(HttpStatus.OK);
        apiResponse.setSuccess(true);
        return apiResponse;
    }

}
