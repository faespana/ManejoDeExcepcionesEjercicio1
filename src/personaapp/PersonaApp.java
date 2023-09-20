package personaapp;

import java.util.ArrayList;
import personaapp.entities.Persona;
import personaapp.services.PersonaService;

public class PersonaApp {

    public static void main(String[] args) {
        
        //Este cambio en el main lo fusionare con el de experimento
        PersonaService ps = new PersonaService();
        ArrayList<Integer> contadorIMC = new ArrayList();
        ArrayList<Boolean> contadorMayorDeEdad = new ArrayList();

        //Persona per1 = ps.crearPersona(); 
        Persona per1 = new Persona("Felipe", 30, "h", 80, 170);
        System.out.println(per1);
        contadorIMC.add(ps.calcularIMC(per1.getPesoKg(), per1.getAlturaCm()));
        contadorMayorDeEdad.add(ps.esMayorDeEdad(per1.getEdad()));
        System.out.println("");

        Persona per2 = new Persona("Monica", 57, "m", 60, 150);
        System.out.println(per2);
        contadorIMC.add(ps.calcularIMC(per2.getPesoKg(), per2.getAlturaCm()));
        contadorMayorDeEdad.add(ps.esMayorDeEdad(per2.getEdad()));
        System.out.println("");

        Persona per3 = new Persona("Pepin", 7, "h", 30, 80);
        System.out.println(per3);
        contadorIMC.add(ps.calcularIMC(per3.getPesoKg(), per3.getAlturaCm()));
        contadorMayorDeEdad.add(ps.esMayorDeEdad(per3.getEdad()));
        System.out.println("");

        Persona per4 = new Persona("Aleja", 34, "m", 90, 160);
        System.out.println(per4);
        contadorIMC.add(ps.calcularIMC(per4.getPesoKg(), per4.getAlturaCm()));
        contadorMayorDeEdad.add(ps.esMayorDeEdad(per4.getEdad()));
        System.out.println("");
        
        int contMayores = 0;
        for (Boolean boolean1 : contadorMayorDeEdad) {
            if(boolean1 == true) {
                contMayores = contMayores + 1;
            }
        }
        System.out.println("Hay " + (contMayores*100)/4 + "%" + " de mayores de edad");
        
        int contPesoIdeal = 0;
        int contSobrePeso = 0;
        int contBajoPeso = 0;

        for (Integer imc : contadorIMC) {
            if(imc == 0) {
                contPesoIdeal = contPesoIdeal + 1;
            }if(imc == 1) {
                contSobrePeso = contSobrePeso + 1;
            }if (imc == -1) {
                contBajoPeso = contBajoPeso +1;
            }
        }
        System.out.println("Existe un " + (contPesoIdeal*100)/4 + "% de personas con peso ideal" + ", ademas hay " + (contSobrePeso*100)/4 + "% de personas con sobrepeso y finalmente hay, " + (contBajoPeso*100)/4 + "% de bajo peso");
    }
}
