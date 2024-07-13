package com.aluracursos.conversormonedas.conversor;


import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Conversor {
    private String privatekey= "bd00e17f9e5ab26384c97961";

    public double convertir(String monedaInicial, String monedaFinal) throws IOException {
        String url_str = "https://v6.exchangerate-api.com/v6/" + privatekey + "/latest/" + monedaInicial;

        URL url = new URL(url_str);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

        // Convert to JSON
        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject jsonobj = root.getAsJsonObject();

        // Accessing object
        JsonElement req_result = jsonobj.get("conversion_rates");
        JsonObject jsonObject = req_result.getAsJsonObject();
        JsonElement moneda = jsonObject.get(monedaFinal);
        return (double) (Double.parseDouble(String.valueOf(moneda)) );
    }

}

