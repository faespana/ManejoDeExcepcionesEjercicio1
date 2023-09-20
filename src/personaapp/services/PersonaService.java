package personaapp.services;

import java.util.Scanner;
import personaapp.entities.Persona;

public class PersonaService {

    private final Scanner leer;

    public PersonaService() {
        this.leer = new Scanner(System.in).useDelimiter("\n");
    }

    public Persona crearPersona() {

        Persona per = new Persona();

        System.out.print("Ingrese el nombre de la persona: ");
        per.setName(leer.next());
        System.out.println("");

        System.out.print("Ahora digite la edad: ");
        per.setEdad(leer.nextInt());
        System.out.println("");

        per.setSexo(verficarSexo());
        System.out.println("");

        System.out.print("Ingrese el peso de la persona en kg: ");
        per.setPesoKg(leer.nextInt());
        System.out.println("");

        System.out.print("Finalmente, ingrese la altura en cm: ");
        per.setAlturaCm(leer.nextInt());
        System.out.println("");

        //calcularIMC(per.getPesoKg(), per.getAlturaCm());
        //System.out.println("");
        return per;

    }

    public String verficarSexo() {

        String sexo = null;
        boolean bandera = false;

        do {
            System.out.print("Seleccione el sexo de la persona (M: mujer, H: hombre & O: otro): ");
            sexo = leer.next();

            if (sexo.equalsIgnoreCase("m") || sexo.equalsIgnoreCase("h") || sexo.equalsIgnoreCase("o")) {
                bandera = true;
            } else {
                System.out.println("La opcion escogida es incorrecta, intentelo nuevamente");

            }
        } while (bandera == false);

        return sexo;

    }

    public int calcularIMC(int pesoKg, int alturaCm) {

        int value = 0;
        double IMC = pesoKg / ((alturaCm / 100) ^ 2);
        System.out.print("El indice de masa corporal es: " + IMC);
        System.out.println("");

        if (IMC < 20) {
            System.out.println("La persona esta por debajo de su peso ideal");
            value = -1;
        }
        if (IMC >= 20 && IMC <= 25) {
            System.out.println("La persona esta en su peso ideal");
            value = 0;
        } if(IMC > 25) {
            System.out.println("La persona tiene sobrepeso");
            value = 1;
        }

        return value;
    }
    
    public boolean esMayorDeEdad(int edad) {
        boolean bandera = true;
        
        if(edad >=18){
            System.out.println("La persona es mayor de edad");
        }else{
            System.out.println("La persona es menor de edad");
            bandera = false;
        }
        
        return bandera;
    }
}
