/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package semana1;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Giacomo
 */
public class Semana1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        boolean flag = true;
        int n;
         
        //Iniciar bucle de control: controla que el valor solicitado sea un número natural impar
        while(flag){         
        //pedir numero impar
            System.out.println("Ingrese un numero natural impar:");           
            //manejo de excepciones (por si el valor ingresado no es un número natural)
            try{
                n = cin.nextInt();
                //verificar que sea impar y natural
                if(n%2 != 0 && n>0){
                    flag = false; //si es impar y natural se rompe el bucle de verificación
                    
                    //se crea la matriz cuadrada M de nxn con el número impar n
                    int M[][] = new int[n][n];
                    
                    //crear lista con numeros naturales de 1 a n
                    List<Integer> lista = new ArrayList<>(); 
                    
                    //llenar la lista de 1 a n^2
                    for(int i = 1; i<Math.pow(n, 2)+1; i++){
                        lista.add(i);
                    }
                    
                    //llenar la matriz con 0
                    for(int i = 0; i<n; i++){
                        for(int j=0; j<n; j++){
                            M[i][j] = 0;
                        }
                    }
                    
                    //Se halla la constante mágica S
                    int S = (int) ((n*(Math.pow(n, 2)+1))/(2));
                    
                    //Se halla el número central:
                    int centro = (int) (Math.pow(n,2)/2) + 1;
                    int posCentral = (n+1)/2;
                    
                    //llenar el cuadrado:
                    int contador = 1;
                    int fila = 0;
                    int columna = n/2;
                    while(contador <= lista.getLast()){
                        M[fila][columna] = contador;
                        contador++;
                        
                        if(contador % n != 1){
                            fila--;
                            if(fila < 0){
                                fila = n-1;
                            }
                            
                            columna++;
                            if(columna == n){
                                columna = 0;
                            }      
                            
                        }else{
                            fila++;
                        }
                    }
                    
                    //Imprimir datos
                    System.out.println("");
                    System.out.println("-------------------------------------------");
                    System.out.println("Numero: "+n);
                    System.out.println("Termino central: "+centro);
                    System.out.println("Matriz 'M':");
                    System.out.println("-------------------------------------------");
                    for(int i=0; i<n;i++){
                        for(int j=0; j<n; j++){
                            System.out.print(M[i][j]+"\t");
                        }
                        System.out.println("");
                    }
                    System.out.println("-------------------------------------------");
                    

                }else{
                    System.out.println("El número proporcionado no es impar.\n");
                }
            }catch(InputMismatchException | IllegalStateException ex){
                System.out.println("El valor ingresado no es un número natural.\n");
                // limpiar el buffer para que no quede el dato inválido
                cin.next();
            }
                        
        }
        
        cin.close();
        
        
        
        
    }
    
    public void subir(int matriz[][], List<Integer> lista){
        for(Integer i : lista){
            
        }
    }
}
