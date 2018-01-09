package com.example.cuteu.utils;

public class ASCIIUtil {
    public static String toASCII(String url){
        url= url.replaceAll(" ", "%20");
        url = url.replaceAll("&", "%26");
        //url = url.replaceAll("=", "%3D");
        url = url.replaceAll("}", "%7D");
        url = url.replaceAll("[{]", "%7B");
        url = url.replaceAll("\"", "%22");
        //url = url.replaceAll(":", "%3A");
        return url;
    }
}
