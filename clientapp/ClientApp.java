import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class ClientApp {

    public static void main(String atgs[]) throws IOException {
try {
    URL url = new URL("http://localhost:8082/client1/dev/latest/");
    URLConnection uc = url.openConnection();

    String userpass = "user" + ":" + "password";
    String basicAuth = "Basic " + javax.xml.bind.DatatypeConverter.printBase64Binary(userpass.getBytes());

    uc.setRequestProperty("Authorization", basicAuth);
    BufferedReader reader = null;
    StringBuilder sb = new StringBuilder();
    reader = new BufferedReader(new InputStreamReader(uc.getInputStream()));
    String line="";
    while ((line = reader.readLine())!= null){
        sb.append(line);
        sb.append("\n");
    }

    System.out.println(sb.toString());


}catch(Exception e){
    e.printStackTrace();
}

    }
}
