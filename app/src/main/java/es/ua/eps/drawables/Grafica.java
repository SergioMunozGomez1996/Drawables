package es.ua.eps.drawables;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class Grafica extends View {

    Paint paint;
    int porcentaje = 25;

    public Grafica(Context context) {
        super(context);
        init(null);
    }

    public Grafica(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public Grafica(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs){
        if( attrs == null )
            return;
        TypedArray ta = this.getContext().obtainStyledAttributes(attrs, R.styleable.Grafica);
        porcentaje = ta.getInt(R.styleable.Grafica_percentage, 0);


    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.FILL);

        canvas.drawCircle(canvas.getClipBounds().centerX(),canvas.getClipBounds().centerY(),canvas.getClipBounds().height()/2,paint);

        paint.setColor(Color.RED);

        float grados = (porcentaje*360)/100;

        int arriba = canvas.getClipBounds().centerY() - canvas.getClipBounds().height()/2;
        int abajo = canvas.getClipBounds().centerY() + canvas.getClipBounds().height()/2;
        int izquierda = canvas.getClipBounds().centerX() - canvas.getClipBounds().height()/2;
        int derecha = canvas.getClipBounds().centerX() + canvas.getClipBounds().height()/2;

        canvas.drawArc(izquierda,arriba,derecha,abajo,270f,grados,true , paint);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int width = 500; //si pones wrap_content en el XML
        int height = 500;

        switch(widthMode)
        {
            case MeasureSpec.EXACTLY: //si pones el tamaño exacto de la vista en el XML
                width = widthSize;
                break;
            case MeasureSpec.AT_MOST: //si pones match_parent en el XML
                if(width > widthSize) {
                    width = widthSize;
                }
                break;
        }

        height = width;

        switch(heightMode)
        {
            case MeasureSpec.EXACTLY:
                height = heightSize;
                break;
            case MeasureSpec.AT_MOST:
                if(height > heightSize) {
                    height = heightSize;
                }
                break;
        }
        this.setMeasuredDimension(width, height);


    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }
}
