/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora1;

/**
 *
 * @author User
 */
public class Operaciones {
    private int a;
    private int b;
    private double result;
    
    public Operaciones(int a, int b){
    this.a=a;
    this.b=b;
    this.result=0;
    }
    
    public void operSumar(){    
        this.result=a+b;}
    
    public void operRestar(){
    this.result=a-b;}
    
    public void operMultiplicar(){
    this.result=a*b;}
    
    public void operDividir(){
    this.result=a/b;
    }
    
    public double getResultado(){
    return this.result;}
    
    
    
    
}
