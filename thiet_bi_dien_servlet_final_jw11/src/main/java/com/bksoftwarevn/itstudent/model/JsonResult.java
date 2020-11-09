package com.bksoftwarevn.itstudent.model;

public class JsonResult {

    private boolean success;

    private Object data;

    public JsonResult(boolean success, Object data) {
        this.success = success;
        this.data = data;
    }

    public JsonResult() {
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public JsonResult jsonSuccess(Object data) {
        return new JsonResult(true, data);
    }

    public JsonResult jsonFail(Object data) {
        return new JsonResult(false, data);
    }
}
