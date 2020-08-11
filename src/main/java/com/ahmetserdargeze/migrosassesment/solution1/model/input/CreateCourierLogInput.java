package com.ahmetserdargeze.migrosassesment.solution1.model.input;

import java.util.Date;

public class CreateCourierLogInput {
    private Date logTime;
    private long courierId;
    private double lng;
    private double lat;

    public CreateCourierLogInput(Builder builder) {
        this.logTime = builder.logTime;
        this.courierId = builder.courierId;
        this.lng = builder.lng;
        this.lat = builder.lat;
    }

    public Date getLogTime() {
        return logTime;
    }

    public void setLogTime(Date logTime) {
        this.logTime = logTime;
    }

    public long getCourierId() {
        return courierId;
    }

    public void setCourierId(long courierId) {
        this.courierId = courierId;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public static class Builder{

        private Date logTime;
        private long courierId;
        private double lng;
        private double lat;
        public Builder(){ }

        public Builder logTime(Date logTime){
            this.logTime = logTime;
            return this;
        }

        public Builder courierId(long courierId){
            this.courierId = courierId;
            return this;
        }

        public Builder lng(double lng){
            this.lng = lng;
            return this;
        }

        public Builder lat(double lat){
            this.lat = lat;
            return this;
        }

        public CreateCourierLogInput build(){
            return new CreateCourierLogInput(this);
        }

    }


}
