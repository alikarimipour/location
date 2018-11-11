package com.devglan.dto;

import java.io.InputStream;
import java.io.Serializable;

public class Test implements Serializable {

    private InputStream inputStream;

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }
}
