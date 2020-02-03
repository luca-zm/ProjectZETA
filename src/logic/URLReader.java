package logic;

import java.io.*;


import java.net.URL;

public class URLReader {

    private String url;

    public URLReader(String url) {
        this.url = url;
    }

    public String read() throws Exception {
        StringBuilder sb = new StringBuilder();
        URL u = new URL(this.url);
        InputStreamReader in = new InputStreamReader(u.openStream());
        BufferedReader buf = new BufferedReader(in);
        String line;
        while ((line = buf.readLine()) != null) {
            sb.append(line);
        }
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        URLReader rd = new URLReader("http://192.168.1.130");
        rd.read();
    }
}