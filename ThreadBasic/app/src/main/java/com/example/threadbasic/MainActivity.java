package com.example.threadbasic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    Thread wr;
    WorkerThread wt;
    boolean running = true;
    String TAG2 = "THREAD2";
    String TAG3 = "THREAD3";


    class WorkerThread extends  Thread{
        @Override
        public void run() {
            int i =0;
            for(i = 0; i<20 && running; i++){
                try{
                    Thread.sleep(1000);

                }catch (InterruptedException e){

                }
                Log.v(TAG2,"Thread time = "+i);
            }
        }
    }

    class WorkerRunnable implements Runnable{


        @Override
        public void run() {
            int i =0;
            for(i = 0; i<20 && running; i++){
                try{
                    Thread.sleep(1000);

                }catch (InterruptedException e){

                }
                Log.v(TAG3,"Runnable time="+i);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        running = true;
        wt= new WorkerThread();
        wr = new Thread(new WorkerRunnable());

        wt.start();
        wr.start();

        Log.v(TAG3,"Now I am in onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        running = false;
        Log.v(TAG3,"Now I am in onStop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TAG3,"Now I am in onPause");
    }
}