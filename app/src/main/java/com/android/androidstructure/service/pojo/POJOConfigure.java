package com.android.androidstructure.service.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public abstract class POJOConfigure {

    @Expose
    @SerializedName("data")
    private Data data;
    @Expose
    @SerializedName("error")
    private Error error;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public static class Data {
        @Expose
        @SerializedName("android-latest-version")
        private String latestVersion;
        @Expose
        @SerializedName("android-min-version")
        private String minVersion;
        @Expose
        @SerializedName("baseUrl")
        private String baseUrl;

        public String getLatestVersion() {
            return latestVersion;
        }

        public void setLatestVersion(String latestVersion) {
            this.latestVersion = latestVersion;
        }

        public String getMinVersion() {
            return minVersion;
        }

        public void setMinVersion(String minVersion) {
            this.minVersion = minVersion;
        }

        public String getBaseUrl() {
            return baseUrl;
        }

        public void setBaseUrl(String baseUrl) {
            this.baseUrl = baseUrl;
        }
    }

    public static class Error {
        @Expose
        @SerializedName("message")
        private String message;
        @Expose
        @SerializedName("code")
        private int code;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }
    }
}
