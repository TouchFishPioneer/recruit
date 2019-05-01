package cn.herculas.recruit.data.VO;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ResultVO<T> {
    private Integer code;
    private String message;
    private T data;

    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(200);
        resultVO.setMessage("success");
        resultVO.setData(object);
        return resultVO;
    }

    public static ResultVO success() {
        return ResultVO.success(null);
    }

    public static ResultVO error(Integer code, String message) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMessage(message);
        resultVO.setData(null);
        return resultVO;
    }

    public static ResultVO error(HttpStatus httpStatus) {
        return ResultVO.error(httpStatus.value(), httpStatus.getReasonPhrase());
    }
}
