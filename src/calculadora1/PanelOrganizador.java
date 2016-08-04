/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora1;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 *
 * @author User
 */
public class PanelOrganizador {
      private Pane panel;
      private VBox vbox_operaciones;
      private VBox vbox_auxiliares;
      private ArregloBotones numeros;
      private Operaciones operaciones;
      private HBox hbox;
      private TextField text;
      public enum TipoOperacion{SUMA, RESTA, MULT, DIV}
      private Integer num1=null;
      private Integer num2=null;
      public TipoOperacion tipo_operacion=null;
      
    public PanelOrganizador(){
    panel= new Pane();
    numeros = new ArregloBotones();
    vbox_operaciones= this.vboxOperaciones();
    vbox_auxiliares=this.vboxAuxiliares();
    text= new TextField();
    text.setPrefSize(150, 15);
    text.relocate(50, 10);
    panel.setStyle("-fx-background-color: #CEF6F5;");
    hbox=new HBox(15);
    hbox.setPadding(new Insets(50));
    hbox.setPrefSize(150,150);
    
    hbox.getChildren().addAll(vbox_auxiliares, vbox_operaciones, numeros.getVbox_botones_numeros());
    panel.getChildren().addAll(hbox,text);
    
    ////////agregar eventos
    
    Button b1=numeros.getBotones()[0][0];
    b1.setOnAction(new ClickHandler02(1));
     Button b2=numeros.getBotones()[0][1];
    b2.setOnAction(new ClickHandler02(2));
     Button b3=numeros.getBotones()[0][2];
    b3.setOnAction(new ClickHandler02(3));
      Button b4=numeros.getBotones()[1][0];
    b4.setOnAction(new ClickHandler02(4));
    Button b5=numeros.getBotones()[1][1];
    b5.setOnAction(new ClickHandler02(5));
    Button b6=numeros.getBotones()[1][2];
    b6.setOnAction(new ClickHandler02(6));
    Button b7=numeros.getBotones()[2][0];
    b7.setOnAction(new ClickHandler02(7));
    Button b8=numeros.getBotones()[2][1];
    b8.setOnAction(new ClickHandler02(8));
    Button b9=numeros.getBotones()[2][2];
    b9.setOnAction(new ClickHandler02(9));
    Button b0=numeros.getBotones()[3][1];
    b0.setOnAction(new ClickHandler02(0));
    }
    
     public VBox vboxOperaciones(){
     vbox_operaciones = new VBox(10);
     Button bt_sumar = new Button(String.valueOf('+'));
     Button bt_restar = new Button("-");
     Button bt_multiplicar = new Button("*");
     Button bt_dividir=new Button("/");
     vbox_operaciones.getChildren().addAll(bt_sumar,bt_restar,bt_multiplicar,bt_dividir);
    
     bt_sumar.setOnAction(new ClickHandler4()); 
     bt_restar.setOnAction(new ClickHandler5());
     bt_multiplicar.setOnAction(new ClickHandler6());
     bt_dividir.setOnAction(new ClickHandler7());

        return vbox_operaciones;
    }
     
     public VBox vboxAuxiliares(){
     vbox_auxiliares = new VBox(10);
     Button bt_delete = new Button("DEL");
     bt_delete.setPrefWidth(60);
     Button bt_reset = new Button("AC");
     Button bt_result = new Button("=");
     bt_result.setPrefSize(60, 100);

     vbox_auxiliares.getChildren().addAll(bt_delete,bt_reset,bt_result);
     bt_reset.setOnAction(new ClickHandler1()); 
     bt_result.setOnAction(new ClickHandler2()); 
     
        return vbox_auxiliares;
    }
     
      
    public Pane getPanel(){
    return this.panel;}
    
    private class ClickHandler1 implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            text.setText("");
        }
    }
     private class ClickHandler2 implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            try{
            Operaciones op=new Operaciones(num1.intValue(), num2.intValue());
            switch(tipo_operacion){
                case SUMA:
                    op.operSumar();
                    text.setText(String.valueOf(op.getResultado()));
                    num1=null;
                    num2=null;
                    break;
                    
                 case RESTA:
                    op.operRestar();
                    text.setText(String.valueOf(op.getResultado()));
                    num1=null;
                    num2=null;
                    break;   
                     
                case MULT:
                    op.operMultiplicar();
                    text.setText(String.valueOf(op.getResultado()));
                    num1=null;
                    num2=null;
                    break;
                      
                case DIV:
                    op.operDividir();
                    text.setText(String.valueOf(op.getResultado()));
                    num1=null;
                    num2=null;
                    break;
   
                default:
                    break;           
            }
            }catch(Exception e){
                num1=null;
                num2=null;    
            }
        }
    }
    
    private class ClickHandler4 implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            tipo_operacion=TipoOperacion.SUMA;
        }
    }
    
    private class ClickHandler5 implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            tipo_operacion=TipoOperacion.RESTA;
        }
    }
        
      private class ClickHandler6 implements EventHandler<ActionEvent> {
         @Override
        public void handle(ActionEvent event) {
            tipo_operacion=TipoOperacion.MULT;
        }
    }
    
      private class ClickHandler7 implements EventHandler<ActionEvent> {
         @Override
        public void handle(ActionEvent event) {
            tipo_operacion=TipoOperacion.DIV;
        }
    }
      
      private class ClickHandler01 implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            if(num1==null){
            num1=new Integer(1);}
            else{num2=new Integer(1);
            }
        }
    }
      private class ClickHandler02 implements EventHandler<ActionEvent> {
        int  numero_boton;
        
        public ClickHandler02(int num) {
            numero_boton=num;
           // this.super();
        }
        
          @Override
            public void handle(ActionEvent event) {
            if(num1==null){
                num1=new Integer(numero_boton);
                text.setText(String.valueOf(numero_boton));}
            else{
                num2=new Integer(numero_boton);
                text.setText(String.valueOf(numero_boton));
            }
        }
    }
    
    
}
