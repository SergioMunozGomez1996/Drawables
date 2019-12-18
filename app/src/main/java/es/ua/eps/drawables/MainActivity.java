package es.ua.eps.drawables;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button drawables = findViewById(R.id.drawable_button);
        Button style = findViewById(R.id.style_button);
        Button personalizacion = findViewById(R.id.personalizacion_button);

        drawables.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,DrawableActivity.class);
                startActivity(intent);
            }
        });

        style.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,StyleMainActivity.class);
                startActivity(intent);
            }
        });

        personalizacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Personalizacion1Activity.class);
                startActivity(intent);
            }
        });
    }
}
