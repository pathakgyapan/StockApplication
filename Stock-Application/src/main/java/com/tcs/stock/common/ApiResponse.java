package com.tcs.stock.common;

public class ApiResponse {
	private int status;
    private String code;
    private String message;
    private Object result;

    public ApiResponse(int status, String code, String message){
        this.status = status;
        this.code = code;
        this.message = message;
        this.result = null;
    }
   
    public ApiResponse(int status, String code, String message, Object result){
        this.status = status;
        this.code = code;
        this.message = message;
        this.result = result;
    }

    public int getStatus() {
        return status;
    }
   
public String getCode() {
return code;
}
   
public String getMessage() {
return message;
}

public Object getResult() {
return result;
}
}
