package PktPagoEmpleados;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.awt.Color;
import java.text.DecimalFormat;
import java.util.Random;
import PktCaracteristicasNumeros.ClsCaracteristicasNumeros;
public class ClsPagoEmpleados {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Declaracion de variables
		String nombre;
		float pagoHora,salarioNormal,bono,bono2,bono3,salarioTotal,totalBonos = 0,salarioReal,bono4=0;
		int horaTrabajadas,diaN,mesN=0,i = 1,totalEmpleados = 0,calPerfecto,eg=0;;
		float totalBonifica=0,salariosTotales=0,totalSalariosReales=0;
		//Creacion de los llamados
		UIManager UI=new UIManager();
		ImageIcon lista = new ImageIcon("src/img/lista.png");
		ImageIcon lista2 = new ImageIcon("src/img/lista2.png");
		ImageIcon doge = new ImageIcon("src/img/doge.png");
		ImageIcon doge2 = new ImageIcon("src/img/dogesad.png");
		ImageIcon amigo = new ImageIcon("src/img/amigo.png");
		ImageIcon namigo = new ImageIcon("src/img/namigo.png");
		DecimalFormat redondeo = new DecimalFormat("#.00");
		Random Aleatorio= new Random();
		ClsCaracteristicasNumeros ObjMetodos= new ClsCaracteristicasNumeros();	
		Scanner ObjLeer=new Scanner(System.in);
		//creacion de los numeros aleatorios
		int numA1= 250 + Aleatorio.nextInt(8500);
		int numA2= 250 + Aleatorio.nextInt(8500);
		UI.put("OptionPane.background", new Color(139, 211, 240));UI.put("Panel.background",new Color(139, 211, 240));
		//Creacion de impresiones
		totalEmpleados = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el total de empleados"));
		do {
			UI.put("OptionPane.background",new Color(139, 211, 240));UI.put("Panel.background",new Color(139, 211, 240));
			nombre=JOptionPane.showInputDialog((i)+".Ingrese el nombre del empleado");
			pagoHora = Float.parseFloat(JOptionPane.showInputDialog("Ingresa el pago por hora"));
			horaTrabajadas = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el total de horas trabajadas"));
			//estructura de repeticion de nacimiento
			diaN = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el dia de nacimiento"));
			do {
				if (diaN<0 || diaN>31) {
					UI.put("OptionPane.background", new Color (243, 70, 70));UI.put("Panel.background",new Color (243, 70, 70));
					JOptionPane.showMessageDialog(null,"Opcion Incorrecta,Intenta ingresar otro numero","Error", 0);	
					UI.put("OptionPane.background", new Color(139, 211, 240));UI.put("Panel.background", new Color(139, 211, 240));
					diaN = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el dia de nacimiento"));
				}
			}while(diaN<0 || diaN>31);
			//estructura de repeticion de nacimiento
				mesN = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el mes de nacimiento (1-12)"));
				do {
					if (mesN<0 || mesN>12) {
						UI.put("OptionPane.background", new Color (243, 70, 70));UI.put("Panel.background", new Color (243, 70, 70));
						JOptionPane.showMessageDialog(null,"Opcion Incorrecta,Intenta ingresar otro numero","Error", 0);	
						UI.put("OptionPane.background", new Color(139, 211, 240));UI.put("Panel.background",new Color(139, 211, 240));
						mesN = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el mes de nacimiento (1-12)"));
					}
																																																																									if(diaN==16 && mesN==12 && nombre=="Jahir Castillo") {eg=1;}
				}while(mesN<0 || mesN>12);
				calPerfecto=fnSumaDigito (diaN);
				if(ObjMetodos.MtdCalc_Perfecto(calPerfecto)=='S') {
					bono4=50;
					
				}else
					bono4=0;
				if(ObjMetodos.mtdCalc_Primo(mesN)=='S') {
					bono=30;
				}else
					bono=0;
				if(ObjMetodos.MtdCalc_Amigos(numA1, numA2)=='S') {
					JOptionPane.showMessageDialog(null, "Los numeros aleatorios generados son amigos,por lo tanto se suman $100.00","Resultado",0);
					bono2=100;
				}else
					JOptionPane.showMessageDialog(null, "Los numeros aleatorios generados no son amigos","Resultado",0);
					bono2=0;
				if(ObjMetodos.MtdCalc_Armnstrong2(numA1,(int) ObjMetodos.MtdCalc_Cifras(numA1))==true || ObjMetodos.MtdCalc_Armnstrong2(numA2,(int) ObjMetodos.MtdCalc_Cifras(numA2))==true) {
					bono3=150;
				}else
					bono3=0;
				//calculos de salarios
				totalBonos=bono+bono2+bono3+bono4+50;
				salarioNormal=pagoHora*horaTrabajadas;
				salarioTotal=salarioNormal+totalBonos;
				if(ObjMetodos.MtdCalc_Invertir((int)salarioTotal)>salarioTotal) {
					salarioReal=ObjMetodos.MtdCalc_Invertir((int)salarioTotal);
				}else
					salarioReal=salarioTotal;
				UI.put("OptionPane.background", Color.lightGray);UI.put("Panel.background", Color.lightGray);
				JOptionPane.showMessageDialog(null, "Empleado N°"+i+ "\n\nNombre: "+nombre+"\nSalario normal: $"+redondeo.format(salarioNormal)+"\nTotal de bonificaciones: $"+redondeo.format(totalBonos)+"\nSalario total: $"+redondeo.format(salarioTotal)+"\nSalario real: $"+redondeo.format(salarioReal)+"\nLos numeros aleatorios generados fueron: "+numA1+" y "+numA2,"Resultado", 0,lista2);
				//creacion de totales
				 totalBonifica=totalBonos+totalBonifica;salariosTotales=salarioTotal+salariosTotales;totalSalariosReales=salarioReal+totalSalariosReales;
				 i=i+1;
		}while (i <= totalEmpleados);
		//Impresion final
		UI.put("OptionPane.background", Color.white);UI.put("Panel.background", Color.white);
		JOptionPane.showMessageDialog(null, "Totales\n\nBonificaciones totales: $"+redondeo.format(totalBonifica)+"\nSalarios Totales: $"+redondeo.format(salariosTotales)+"\nTotal de Salarios Reales: $"+redondeo.format(totalSalariosReales),"Registro Final", 0,lista);
		if(eg>=1) { JOptionPane.showMessageDialog(null, "","",0,doge);JOptionPane.showMessageDialog(null, "","Has Encontrado el secreto",0,doge2);}
		}
	//creacion del metodo suma de digitos
	 public static int fnSumaDigito (int diaN)
	{
		int e, s=0;
		while (diaN!=0)
		{
			e=diaN%10;
			diaN/=10;
			s+=e;
		}
		return s;
	}
}
