package fr.m4104.calculatrice_v_2;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Display;
import org.mariuszgromada.math.mxparser.* ;
import android.view.View;

import android.widget.EditText;

import android.widget.TextView;

/**
 * Created by B. LEMAIRE on 2019.
 */

    public class Calcul extends Activity {


    // Affichage du résultat du calcul
    private EditText tv_calcul;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            setContentView(R.layout.layout_calcul);
            tv_calcul = findViewById(R.id.tv_res);
            tv_calcul.setShowSoftInputOnFocus(false);
        }else{
            setContentView(R.layout.layout_calcul_landscape);
            tv_calcul = findViewById(R.id.tv_res);
            tv_calcul.setShowSoftInputOnFocus(false);

        }







    }


    private void deserialiserRessources() {

    }
    private void updateText(String text){

        String ch = tv_calcul.getText().toString();
       int posCurseur = tv_calcul.getSelectionStart();
       String ch1 = ch.substring(0,posCurseur);
       String ch2 = ch.substring(posCurseur);

       tv_calcul.setText(String.format("%s%s%s",ch1,text,ch2));
       tv_calcul.setSelection(posCurseur + text.length());

    }

    /**
     * Mise en place des écouteurs
     */
    private void initConnection() {
        // A compléter
    }
    public void zero(View vue ){
       updateText("0");
    }
    public void un(View vue ){
        updateText("1");
    }
    public void deux(View vue ){
        updateText("2");
    }
    public void trois(View vue ){
        updateText("3");
    }
    public void quatre(View vue ){
        updateText("4");
    }
    public void cinq(View vue ){
        updateText("5");
    }
    public void six(View vue ){
        updateText("6");
    }
    public void sept(View vue ){
        updateText("7");
    }
    public void huit(View vue ){
        updateText("8");
    }
    public void neuf(View vue ){
        updateText("9");
    }
    public void div(View vue ){
        updateText("/");
    }
    public void plus(View vue ){
        updateText("+");
    }
    public void fois(View vue ){
        updateText("×");
    }
    public void moins(View vue){
        updateText("-");
    }
    public void mod(View vue ){
        updateText("%");

    }
    public void parenthG(View vue ){
        updateText("(");

    }
    public void parenthD(View vue ){
        updateText(")");

    }
    public void exp(View vue ){
        updateText("exp(");

    }
    public void pi(View vue ){
        updateText("π");

    }
    public void ln(View vue ){
        updateText("ln(");


    }
    public void fact(View vue ){
        updateText("!");


    }
    public void cos(View vue ){
        updateText("cos(");


    }
    public void sin(View vue ){
        updateText("sin(");
    }
    public void tan(View vue ){
        updateText("tan(");
    }
    public void racine(View vue ){
        updateText("√"+"(");
    }
    public void puissance(View vue ){
        updateText("^");
    }





    public void res(View vue ){
        String expression = tv_calcul.getText().toString();
        expression = expression.replaceAll("÷","/");
        expression = expression.replaceAll("×","*");
        expression = expression.replaceAll("%","#");
        expression = expression.replaceAll("π","pi");
        expression = expression.replaceAll("√","sqrt");
        Expression exp = new Expression(expression);
        String resultat = String.valueOf(exp.calculate());
        tv_calcul.setText(resultat);
        tv_calcul.setSelection(resultat.length()  );

    }

    public void effacer(View vue ){
        tv_calcul.setText("");
    }
    public void vergule(View vue ){
        updateText(".");

    }



}
