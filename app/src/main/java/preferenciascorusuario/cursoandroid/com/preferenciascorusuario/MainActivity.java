package preferenciascorusuario.cursoandroid.com.preferenciascorusuario;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton radioButtonSelecionado;
    private Button botaoSalvar;
    private RelativeLayout layout;
    private static final String ARQUIVO_PREFERENCIA = "ArqPreferencia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup= (RadioGroup) findViewById(R.id.radioGroupId);
        botaoSalvar = (Button) findViewById(R.id.botaoSalvarId);
        layout = (RelativeLayout) findViewById(R.id.layoutId);

        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int idRadioButtonEscolhido = radioGroup.getCheckedRadioButtonId();


              if(idRadioButtonEscolhido >0){
                  radioButtonSelecionado = (RadioButton) findViewById(idRadioButtonEscolhido);


                  SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA,0);
                  SharedPreferences.Editor editor = sharedPreferences.edit();
                  String corEscolhida = radioButtonSelecionado.getText().toString();

//                  salva a cor selecionada dentro da corEscolhida
                  editor.putString("corEscolhida",corEscolhida );
                  editor.commit();

                  setBackground( corEscolhida);
              }
            }
        });


//        Recupera a cor Salva
        SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA,0);
        if(sharedPreferences.contains("corEscolhida")){

            String corRecuperada = sharedPreferences.getString("corEscolhida","Laranja");
            setBackground(corRecuperada);

        }

    }

    private void setBackground(String cor){

        if(cor.equals("Azul")){
//            o parse color vai converter a cor para um  inteiro
            layout.setBackgroundColor(Color.parseColor("#74b9ff"));

        }else if(cor.equals("Laranja")){
            layout.setBackgroundColor(Color.parseColor("#e67e22"));
        }else if(cor.equals("Verde")){
            layout.setBackgroundColor(Color.parseColor("#2ecc71"));

        }



    }



}
