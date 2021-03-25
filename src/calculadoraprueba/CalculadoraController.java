/*
 * Necesita jdk 15
 * y JavaFx 17
 * 
 */
package calculadoraprueba;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 * JavaFx17, JDK-15
 * @author Clemente Quintana
 */
public class CalculadoraController implements Initializable {

    
    //Variables que usaremos
    private boolean digito = false;
    private boolean punto = false;
    private int numOperandos = 0;
    private double operando1, operando2;
    private char operacion = ' ';
    private boolean signo = false;
    
    @FXML
    private Label labPantalla;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    // Acciones que realizaremos cuando se pulse una tecla de la calculadora
    @FXML
    private void pulsa7(ActionEvent event) {
        digitoPantalla("7");
    }

    @FXML
    private void pulsa9(ActionEvent event) {
        digitoPantalla("9");
    }

    @FXML
    private void pulsa4(ActionEvent event) {
        digitoPantalla("4");
    }

    @FXML
    private void pulsa5(ActionEvent event) {
        digitoPantalla("5");
    }

    @FXML
    private void pulsa6(ActionEvent event) {
        digitoPantalla("6");
    }

    @FXML
    private void pulsa1(ActionEvent event) {
        digitoPantalla("1");
    }

    @FXML
    private void pulsa2(ActionEvent event) {
        digitoPantalla("2");
    }

    @FXML
    private void pulsa3(ActionEvent event) {
        digitoPantalla("3");
    }

    @FXML
    private void pulsa0(ActionEvent event) {
        digitoPantalla("0");
    }
    
    @FXML
    private void pulsa8(ActionEvent event) {
        digitoPantalla("8");
    }

    //Metodo para poner la coma de los decimales
    @FXML
    private void pulsaPunto(ActionEvent event) {
        if (!punto && !digito) {
            labPantalla.setText("0.");
            digito = true;
        } else if (!punto) {
            String valActual = labPantalla.getText();
            labPantalla.setText(valActual + ".");
        }
        punto = true;
    }

    
    //mostrar por pantalla los numeros que vamos escribiendo
    private void digitoPantalla(String numero) {
        if (!digito && numero.equals("0")) {
            //no hacemos nada, evitamos 0 a la izquierda           
        }else if(!digito) {
            labPantalla.setText(numero);
            digito=true;
        }else if(digito){
            labPantalla.setText(labPantalla.getText()+numero);
        }
    }

    //borrado de pantalla y de operaciones en variables
    @FXML
    private void borrado(ActionEvent event) {
        digito = false;
        punto = false;
        numOperandos = 0;
        operando1 = 0;
        operando2 = 0;
        labPantalla.setText("0");
        signo=false;

    }

    //para cambiar a negativo un operando o volverlo a positivo
    @FXML
    private void cambiaSigno(ActionEvent event) {
        if (digito && !signo) {
            labPantalla.setText("-" + labPantalla.getText());
            signo = true;
        }else if(digito && signo){
            labPantalla.setText(labPantalla.getText().substring(1));
            signo=false;
        }

    }

    
    //Calcular el tanto por ciento de un numero
    @FXML
    private void porCiento(ActionEvent event) {
        if (numOperandos == 0) {
            labPantalla.setText("0");
        }
        operando2 = Double.parseDouble(labPantalla.getText());
        labPantalla.setText(String.valueOf(operando2));
        operando2=operando2/100;
        labPantalla.setText(String.valueOf(operando2));
        operando1 = operando1*operando2;
        operacion=' ';
        digito = true;
        punto = true;
        signo=false;

    }
    
    //Metodos para recoger y realizar la operacion deseada
    @FXML
    private void dividir(ActionEvent event) {
        operacion("/");

    }

    @FXML
    private void multiplica(ActionEvent event) {
        operacion("x");
    }

    @FXML
    private void resta(ActionEvent event) {
        operacion("-");
    }

    @FXML
    private void suma(ActionEvent event) {
        operacion("+");
    }

    @FXML
    private void resulOperacion(ActionEvent event) {
        operacion("=");
    }

    //realiza las operaciones elementales
    private void operacion(String op) {
        signo=false;
        if (digito) {
            numOperandos++;
        }
        if (numOperandos == 1) {
            operando1 = Double.parseDouble(labPantalla.getText());
            punto = false;
        }

        if (numOperandos == 2) {
            operando2 = Double.parseDouble(labPantalla.getText());

            switch (operacion) {
                case '+':
                    operando1 = operando1 + operando2;
                    break;
                case '-':
                    operando1 = operando1 - operando2;
                    break;
                case '/':
                    operando1 = operando1 / operando2;
                    break;
                case 'x':
                    operando1 = operando1 * operando2;
                    break;
                case '=':
                    labPantalla.setText(String.valueOf(operando1));
                    signo=false;
                    break;

            }
            labPantalla.setText(String.valueOf(operando1));
            numOperandos = 1;
            punto = false;
        }
        digito = false;
        operacion = op.charAt(0);

    }
}
