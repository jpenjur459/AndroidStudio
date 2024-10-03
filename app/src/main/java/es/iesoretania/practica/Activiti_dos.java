package es.iesoretania.practica;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import es.iesoretania.practica.databinding.ActivityActivitiDosBinding;

public class Activiti_dos extends AppCompatActivity {
    private ActivityActivitiDosBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_activiti_dos);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        binding = ActivityActivitiDosBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Bundle bundle = getIntent().getExtras();
        int value1 = bundle.getInt("mates");
        int value2 = bundle.getInt("fisica");
        int value3 = bundle.getInt("quimica");

        int media = (value1 + value2 + value3)/3;

        binding.textView.setText("Nota de Matematicas " + value1);
        binding.textView2.setText("Nota de Física " + value2);
        binding.textView3.setText("Nota de Química " + value3);

        if (media >= 5){
            binding.textView4.setText("Aprobado con "+media+" de media");
        }else {
            binding.textView4.setText("Suspenso con "+media+" de media");
        }
    }
}