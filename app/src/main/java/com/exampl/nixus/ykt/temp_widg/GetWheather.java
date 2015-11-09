package com.exampl.nixus.ykt.temp_widg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetWheather {
    public String getInet(String uri)
    {
        BufferedReader reader = null;
        try {
            URL url = new URL(uri);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            StringBuilder sb = new StringBuilder();
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                 // String numberOnly= line.replaceAll("[^0-9-+]", "");
                 sb.append(line);
            }
                return sb.toString();

        } catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }finally {
            if (reader !=null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
    }
}