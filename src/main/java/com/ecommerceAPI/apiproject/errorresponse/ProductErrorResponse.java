package com.ecommerceAPI.apiproject.errorresponse;

import lombok.Getter;
import lombok.Setter;

//-------------This is a Response Body (custom error response)-------------//
/*What is a  response body?
the part of a HTTP response that contains the actual response data. 
It is typically in the form of JSON, XML, or plain text.
The response body is returned after the HTTP headers have been sent. 
The headers contain information about the response, such as the status code, content type, and length.
*/

@Getter
@Setter

public class ProductErrorResponse {



    
    // Define error response with status, message, and timeStamp
    private int status;
    private String message;
    private long timeStamp;

    public ProductErrorResponse(int status, String message, long timeStamp) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public ProductErrorResponse() {
    }






    
}
