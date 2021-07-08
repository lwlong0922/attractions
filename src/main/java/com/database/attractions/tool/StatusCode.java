package com.database.attractions.tool;

import org.springframework.stereotype.Component;

@Component
public class StatusCode {
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    private int status;
    private Object object;
}
