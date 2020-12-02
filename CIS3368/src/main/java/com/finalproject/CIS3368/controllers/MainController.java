package com.finalproject.CIS3368.controllers;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Controller
public class MainController {


    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ModelAndView get (@RequestParam("id") String id){
        ModelAndView mv = new ModelAndView("redirect:/");
        String covid = getCovidinfo(id);
        try{
            JSONObject json = new JSONObject(covid);

            mv.addObject("Country", json.getString("Country"));
            mv.addObject("Confirmed", json.getString("Confirmed"));
            mv.addObject("Deaths", json.getString("Deaths"));
            mv.addObject("Recovered", json.getString("Recovered"));
            mv.addObject("Active", json.getString("Active"));



        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return mv;
    }


    private String getCovidinfo(String id){
        try {
            //String apiKey = "cfc6ae8e";
            URL urlForGetRequest = new URL("api.covid19api.com/live/country/" + id );

            HttpURLConnection connection = (HttpURLConnection) urlForGetRequest.openConnection();
            connection.setRequestMethod("GET");
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = in.readLine()) != null) {
                    response.append(line);
                }
                in.close();
                return response.toString();
            } else {
                return "Unexpected HTTP response";
            }
        } catch (Exception e){
            return "Exception: " + e.getMessage();
        }
    }




}
