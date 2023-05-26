/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sanjeevaniapp.utility;

import kong.unirest.GetRequest;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

/**
 *
 * @author ACER
 */
public class OTPSender implements Sender {

    public boolean send(String number, String data) throws Exception {
        String mobNo = number;
        int otp = Integer.parseInt(data);
        String url = "https://2factor.in/API/V1/2c1c7f8b-ac87-11ed-813b-0200cd936042/SMS/" + mobNo + "/" + otp + "/OTP1";
        System.out.println("OTP is:" + otp);
        GetRequest gr = Unirest.get(url);
        HttpResponse<String> response = gr.asString();
        String result = response.getBody();
        return result.contains("Success");
    }
}
