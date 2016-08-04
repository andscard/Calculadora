/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora1;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

/**
 *
 * @author User
 */
public class Boton {
    private  Button button;
    
    public Boton (String id){
    this.button=new Button(id);
    ClickHandler click= new ClickHandler();
    button.addEventHandler(ActionEvent.ACTION, click);
    }
    
    public void setSize(double x, double y){
    this.button.resize(x, y);
    }
    
    public Button getBoton(){
    return this.button;}
    

    private class ClickHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
           
        }
    }
}
