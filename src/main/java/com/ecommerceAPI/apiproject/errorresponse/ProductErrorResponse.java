package com.ecommerceAPI.apiproject.errorresponse;

import lombok.Getter;
import lombok.Setter;

public class ProductErrorResponse {


    @Getter
    @Setter
// define error response with status, message and timeStamp
    private int status;

    private String message;

    private long timeStamp;

    public ProductErrorResponse(int status, String message, long timeStamp) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }


    
}
