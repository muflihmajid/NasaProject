package com.CleanArc.ProjectNasa.Application.Interface.Base;

public class BaseDto {
    public Boolean Success;
    public String Message;

    public Boolean getSuccess() {
        return Success;
    }
    public void setSuccess(Boolean success) {
        Success = success;
    }
    public String getMessage() {
        return Message;
    }
    public void setMessage(String message) {
        Message = message;
    }
}
