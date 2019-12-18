package es.ua.eps.drawables;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TextViewCitas extends AppCompatTextView {

    private Random randomGenerator;
    private List<String> catalogue;

    public TextViewCitas(Context context) {
        super(context);
        inicializacion();
    }

    public TextViewCitas(Context context, AttributeSet attrs) {
        super(context, attrs);
        inicializacion();
    }

    public TextViewCitas(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inicializacion();
    }



    public void inicializacion(){
        randomGenerator = new Random();
        catalogue =  Arrays.asList("Ser o no ser, esa es la cuestión","En un lugar de la mancha cuyo nombre no quiero acordarme", "Pienso luego existo");
        int index = randomGenerator.nextInt(catalogue.size());
        setText(catalogue.get(index));

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        inicializacion();
        return super.onTouchEvent(event);
    }
}
