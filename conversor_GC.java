import java.lang.NumberFormatException;
import java.lang.NullPointerException;
import javax.swing.JOptionPane;
import java.text.DecimalFormat;
class conversor_GC{
public static void main(String[]Args){
int cont = 0;
try{
    while(cont == 0){   
        try{
             String TG1 =(JOptionPane.showInputDialog(null,"Seecciona el tipo grados a convertir","Menu",JOptionPane.PLAIN_MESSAGE,null,new Object[] {"Cº","Fº"},"Seleciona")).toString();
             String TG2 =(JOptionPane.showInputDialog(null,"Convertir grados "+TG1+" a: ","Menu",JOptionPane.PLAIN_MESSAGE,null,new Object[] {"Cº","Fº"},"Seleciona")).toString();
             Double valor = Double.parseDouble(JOptionPane.showInputDialog(null,"Ingresa los grados "+TG1+" para convertir en grados "+TG2+": "));
Double valor2 = 0.0;
DecimalFormat f1 = new DecimalFormat("###.##");
if(TG1 == TG2){
valor2  = valor;
}else if( TG1 == "Cº" && TG2 == "Fº"){
    valor2 = ((valor * 1.8)+32);
}else if( TG1 == "Fº" && TG2 == "Cº"){
    valor2 = ((valor - 32)*5/9);
}

JOptionPane.showMessageDialog(null,valor+" "+TG1+" es igual a "+f1.format(valor2)+" "+TG2);

             cont = JOptionPane.showConfirmDialog(null,"Deseas realizar otra conversion ?");                
            }catch(java.lang.NumberFormatException ex){
                JOptionPane.showMessageDialog(null,"Valor Incorrecto");
            }
    }
}catch(java.lang.NullPointerException ex){
    JOptionPane.showMessageDialog(null,"Cancelado");
}
if (cont == 1){
    JOptionPane.showMessageDialog(null,"Prgrama terminado");
}
}
}


