package m2iformation.fr.convertisseureurofranc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static java.lang.Double.parseDouble;

public class MainActivity extends AppCompatActivity {
    private EditText etSaisie;
    private Button btCalculer;
    private EditText etConversion;
    final Double TAUX_FRF_EUR = 6.55957;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etSaisie = findViewById(R.id.saisie);
        btCalculer = findViewById(R.id.button);
        etConversion = findViewById(R.id.conversion);


    }

    public void calcul(View view) {
        //if(etSaisie.getText().length() > 0){
        try{
            String saisie = etSaisie.getText().toString();
            Double conversion = parseDouble(saisie) * TAUX_FRF_EUR;
            //etConversion.setText(conversion.toString());
            etConversion.setText(String.format("%.2f", conversion)); // (pour limiter à deux décimales)
        }catch (Exception ex){
            etConversion.setText("");
            Toast.makeText(this,"Saisie incorrecte", Toast.LENGTH_LONG).show();
        }
    }
}

