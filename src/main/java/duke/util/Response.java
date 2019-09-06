package duke.util;

public class Response {
    private String message;
    private ResponseCode responseCode;

    public Response(String message, ResponseCode responseCode) {
        this.message = message;
        this.responseCode = responseCode;
    }

    public String getMessage() {
        return message;
    }

    public ResponseCode getResponseCode() {
        return responseCode;
    }
}
