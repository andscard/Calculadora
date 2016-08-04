/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora1;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;

/**
 *
 * @author User
 */
public class ArregloBotones {
   private Button [][] botones;
   private Boton button;
   private VBox vbox_botones_numeros;
   
   public ArregloBotones(){
   botones =new Button[4][3];
   this.llenarArrelgoBotones();
   this.vbox_botones_numeros=new VBox(10);
   this.agregarAVbox();
   }
   
   public void llenarArrelgoBotones(){
       int cont=1;
   for (int i=0; i<3; i ++){
            for(int j=0;j<3;j++){
            String id=String.valueOf(cont);
            button=new Boton(id);
            botones[i][j]=button.getBoton();
            cont++;
        }
   }
    button=new Boton("0");
    //button.setSize(20, 10);
    botones[3][1]=button.getBoton();
   }
   

    private void agregarAVbox() {
        HBox f1=new HBox(10);
        f1.getChildren().addAll(this.botones[0][0],this.botones[0][1],this.botones[0][2]);
        HBox f2=new HBox(10);
        f2.getChildren().addAll(this.botones[1][0],this.botones[1][1],this.botones[1][2]);

        HBox f3=new HBox(10);
        f3.getChildren().addAll(this.botones[2][0],this.botones[2][1],this.botones[2][2]);
        
        HBox f4=new HBox(10);
        f4.getChildren().addAll(this.botones[3][1]);
        this.botones[3][1].setPrefWidth(150);
   
        this.vbox_botones_numeros.getChildren().addAll(f1, f2, f3,f4);
        
    }

    public VBox getVbox_botones_numeros() {
        return vbox_botones_numeros;
    }

    public void setVbox_botones_numeros(VBox vbox_botones_numeros) {
        this.vbox_botones_numeros = vbox_botones_numeros;
    }

    public Button[][] getBotones() {
        return botones;
    }
    
    
 
    
}
