package msb.wxgzh.exception;

import lombok.Getter;
import msb.wxgzh.enums.ResultEnum;

/**
 * Created by
 *
 */
@Getter
public class SellException extends RuntimeException{

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }

    public SellException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
