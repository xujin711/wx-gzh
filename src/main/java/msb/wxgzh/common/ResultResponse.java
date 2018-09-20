package msb.wxgzh.common;

/*import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;*/


public class ResultResponse<T> {
   // private List<T> list;
    private T result;
    private Boolean status;
    private String message;
    private Integer statusCode;

    public ResultResponse() {
    }

    public ResultResponse(T result, Boolean status, String message, Integer statusCode) {
        this.result = result;
        this.status = status;
        this.message = message;
        this.statusCode = statusCode;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }
}
