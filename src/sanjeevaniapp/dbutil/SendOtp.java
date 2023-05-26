package sanjeevaniapp.dbutil;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

/**
 *
 * @author ACER
 */
public class SendOtp {

    public static void main(String[] args) {
        try {
            String url = "https://2factor.in/API/V1/2c1c7f8b-ac87-11ed-813b-0200cd936042/SMS/6260220389/1234/OTP1";
            HttpResponse<String> response = Unirest.get(url).asString();
            String reply = response.getBody();
            System.out.println(reply);
            System.out.println("OTP sended successfully");
        } catch (Exception ex) {
            System.out.println("error");
        }
    }
}
