/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sanjeevaniapp.dbutil;

import java.util.Base64;

/**
 *
 * @author ACER
 */
public class password {
    public static void main(String[] args) {
        Base64.Encoder en=Base64.getEncoder();
        String pwd="harsh";
        byte [] arr=pwd.getBytes();
        String encPwd=en.encodeToString(arr);
        System.out.println("Original string:"+pwd);
        System.out.println("Encrypted string:"+encPwd);
    }
}