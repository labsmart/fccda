package com.example.lucas.appfinal;


        import android.app.Activity;
        import android.content.Intent;
        import android.os.Bundle;
        import android.os.Handler;


/**
 * Created by LUCAS on 22/06/2015.
 */
public class Splash extends Activity implements Runnable{



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_layout);

        Handler handler = new Handler();
        handler.postDelayed(this, 3000);
    }

    @Override
    public void run() {

        startActivity(new Intent(this, MainActivity.class));
        finish();

    }


}
