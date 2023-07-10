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

public class menu_principal{

public static void main(String[]Args) throws MalformedURLException {

try{
String opcion =(JOptionPane.showInputDialog(null,"Escoge un conversor: ","Menu principal",JOptionPane.PLAIN_MESSAGE,null,new Object[] {"Conversor de divisas","Conversor de grados Cº,Fº"},"Seleciona")).toString();

if (opcion == "Conversor de divisas"){

conversor_divisa mnudiv = new conversor_divisa();
mnudiv.main(null);

}
else if(opcion == "Conversor de grados Cº,Fº"){

conversor_GC mnuGC = new conversor_GC();
mnuGC.main(null);

}
}catch(java.lang.NullPointerException ex){
       JOptionPane.showMessageDialog(null,"Cancelado");
}
}
}
