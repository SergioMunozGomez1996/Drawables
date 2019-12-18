package es.ua.eps.drawables;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

public class EdicionBorrable extends LinearLayout {

    EditText editText;
    Button button;

    public EdicionBorrable(Context context) {
        super(context);
        inicializacion();
    }

    public EdicionBorrable(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        inicializacion();
    }

    private void inicializacion(){
        // Creamos la interfaz a partir del layout
        String infService = Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater li;
        li = (LayoutInflater)getContext().getSystemService(infService);
        li.inflate(R.layout.edicion_borrable, this, true);
        // Obtenemos las referencias a las vistas hijas
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);

        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText("");
            }
        });

    }
}
