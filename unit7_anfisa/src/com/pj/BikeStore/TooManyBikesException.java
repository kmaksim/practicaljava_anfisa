package com.pj.BikeStore;

class TooManyBikesException extends Exception {
  TooManyBikesException() {
  }
   
  TooManyBikesException(String message) {
    super(message);
    BikesStore1.log.info ("Too many bikes !!!!" + message);
  }
}