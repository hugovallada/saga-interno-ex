package com.github.hugovallada.sagaevent.dto;

public record Payload(String data, String desc) {

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        String data;
        String desc;

        public Builder data(String data) {
            this.data = data;
            return this;
        }

        public Builder desc(String desc) {
            this.desc = desc;
            return this;
        }

        public Payload build() {
            return new Payload(data, desc);
        }
    }


}
