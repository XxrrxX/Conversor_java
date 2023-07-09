package Convesor_java;
import javax.swing.JOptionPane;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.MalformedURLException;
import java.io.*;
import org.json.*;    
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
class menu_Inicial{
    public static void main(String[]args) throws MalformedURLException{
    String divisa1 =(JOptionPane.showInputDialog(null,"Seecciona divisa a convertir","Menu",JOptionPane.PLAIN_MESSAGE,null,new Object[] {"MXN","USD"},"Seleciona")).toString();
    Double valor = Double.parseDouble(JOptionPane.showInputDialog(null,"Ingresa canidad a convertir en "+divisa1+": "));
    String divisa2 =(JOptionPane.showInputDialog(null,"Convertir $"+valor+" "+ divisa1 +" a: ","Menu",JOptionPane.PLAIN_MESSAGE,null,new Object[] {"MXN","USD","EUR","CAD","ARS","BRL","CNY","COP","CLP","CUP"},"Seleciona")).toString();
    String link = "http://api.exchangeratesapi.io/v1/latest?access_key=7e228ea51f62d79794c5041904121b10&symbols="+divisa1+","+divisa2;
    try{
        URL u = new URL(link);
        HttpURLConnection hr = (HttpURLConnection)u.openConnection();
        if(hr.getResponseCode()==200){
            InputStream im = hr.getInputStream();
            StringBuffer sb = new StringBuffer();
            BufferedReader br = new BufferedReader(new InputStreamReader(im));
            String line=br.readLine();
            JSONObject jo = new JSONObject(line);
           BigDecimal d1 = (BigDecimal) jo.getJSONObject("rates").get(divisa1);
           BigDecimal d2 = (BigDecimal) jo.getJSONObject("rates").get(divisa2);
           
           Double div =  d2.setScale(2,RoundingMode.HALF_DOWN).doubleValue() / d1.setScale(2,RoundingMode.HALF_DOWN).doubleValue();             
           Double mdiv = div * valor;
           DecimalFormat f1 = new DecimalFormat("###.##");
           JOptionPane.showMessageDialog(null,"$"+f1.format(valor)+" "+divisa1+" es igual a:$"+f1.format(mdiv)+" "+divisa2);             
        }
    }catch (Exception e){
     System.out.println(e);
    }

}
}   
