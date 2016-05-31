package com.devsh.libfileupload;

public class ServerUploadResponse {
    private boolean success;
    private String resource_url;

    public String getResourceUrl() {
        return resource_url;
    }

    public boolean isSuccess() {
        return success;
    }
}
