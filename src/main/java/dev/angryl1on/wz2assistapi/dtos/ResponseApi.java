package dev.angryl1on.wz2assistapi.dtos;

import java.util.List;

/**
 * Represents a generic API response with a body and a list of errors.
 * @param <T> The type of the body of the response.
 */
public class ResponseApi<T> {
    private List<T> body;
    private List<String> errors;

    protected ResponseApi() {}

    /**
     * Constructs a ResponseApi with the given body and errors.
     * @param body The body of the response.
     * @param errors The list of errors in the response.
     */
    public ResponseApi(List<T> body, List<String> errors) {
        this.body = body;
        this.errors = errors;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public List<T> getBody() {
        return body;
    }

    public void setBody(List<T> body) {
        this.body = body;
    }
}
