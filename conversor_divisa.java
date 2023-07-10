import javax.swing.JOptionPane;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.MalformedURLException;
import java.io.*;
import org.json.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.lang.NumberFormatException;
import java.lang.NullPointerException;
import java.lang.ClassCastException;
class conversor_divisa{
public conversor_divisa(){

}
public static void main(String[]Args) throws MalformedURLException{
int cont = 0;
    try{
    while(cont == 0){
        String divisa1 =(JOptionPane.showInputDialog(null,"Seecciona divisa a convertir","Menu",JOptionPane.PLAIN_MESSAGE,null,new Object[] {"MXN","USD","EUR","CAD","ARS","BRL","CNY","COP","CLP","CUP","JPY"},"Seleciona")).toString();
        try{
            Double valor = Double.parseDouble(JOptionPane.showInputDialog(null,"Ingresa canidad a convertir en "+divisa1+": "));
            String divisa2 =(JOptionPane.showInputDialog(null,"Convertir $"+valor+" "+ divisa1 +" a: ","Menu",JOptionPane.PLAIN_MESSAGE,null,new Object[] {"MXN","USD","EUR","CAD","ARS","BRL","CNY","COP","CLP","CUP"."JPY"},"Seleciona")).toString();
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
Double D1;
Double D2;
String e1;
String e2; 
DecimalFormat f2 = new DecimalFormat("###.##");
try{    
                    BigDecimal d1 = (BigDecimal) jo.getJSONObject("rates").get(divisa1);
                    D1 =  d1.setScale(2,RoundingMode.HALF_DOWN).doubleValue();
}catch(java.lang.ClassCastException ex){
                    e1 = jo.getJSONObject("rates").get(divisa1).toString();    
                    D1= Double.parseDouble(e1);
}
try{    
                    BigDecimal d2= (BigDecimal) jo.getJSONObject("rates").get(divisa2);
                    D2 = d2.setScale(2,RoundingMode.HALF_DOWN).doubleValue();
}catch(java.lang.ClassCastException ex){
                    e2 = jo.getJSONObject("rates").get(divisa2).toString();    
                    D2= Double.parseDouble(e2);
}
                    Double div = (D2 / D1);             
                    Double mdiv = div * valor;
                    DecimalFormat f1 = new DecimalFormat("###.##");
                    JOptionPane.showMessageDialog(null,"$"+f1.format(valor)+" "+divisa1+" es igual a:$"+f1.format(mdiv)+" "+divisa2);   
                    cont = JOptionPane.showConfirmDialog(null,"Deseas realizar otra conversion ?");
}                                 
                
            }catch (Exception e){
                System.out.println(e);
            }
          }catch(java.lang.NumberFormatException ex){
            JOptionPane.showMessageDialog(null,"Valor Incorrecto");
           }
    }}catch(java.lang.NullPointerException ex){
    JOptionPane.showMessageDialog(null,"Cancelado");
    }
if (cont == 1){
    JOptionPane.showMessageDialog(null,"Prgrama terminado");
}
}
}
//Coded by: XxrrxX

