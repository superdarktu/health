package com.health.model.ro;

public class ResultRO {

    private Object data;

    private boolean status;

    private String href;

    private String message;

    public ResultRO() {
        super();
    }

    public ResultRO(Object data, String href) {
        super();
        this.data = data;
        this.status = true;
        this.href = href;
    }

    public ResultRO(boolean status, String href) {
        super();
        this.status = status;
        this.href = href;
    }

    public ResultRO(String message) {
        super();
        this.status = false;
        this.message = message;
    }

    public ResultRO(boolean status) {
        super();
        this.status = status;
    }

    public ResultRO(Object data) {
        super();
        this.data = data;
        this.status = true;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }


}
