package com.example.aliothman.seehbar_thread;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

//    SeekBar seekBar;
//    int maxcounter = 100;
//    TextView textView;
//    myhandler myhandler;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        seekBar = (SeekBar) findViewById(R.id.seekBar);
//        textView = (TextView) findViewById(R.id.textView);
//        seekBar.setMax(maxcounter);
//        myhandler = new myhandler();
//    }
//    boolean isrunning = false;
//    int counterup = 0;
//
//    public void startbtn(View view) {
//        isrunning = true;
//        mythread mythread = new mythread();
//        mythread.start();
//    }
//
//    public void stopbtn(View view) {
//        isrunning = false;
//    }
//
//    class mythread extends Thread {
//
//        @Override
//        public void run() {
//            while (isrunning) {
//                if (counterup < maxcounter) {
//
////                    runOnUiThread(new Runnable() {
////                        @Override
////                        public void run() {
////                            seekBar.setProgress(counterup);
////                            textView.setText("Counter " + counterup);
////                        }
////                    });
//                    Message message = myhandler.obtainMessage();
//                    Bundle  bundle = new Bundle();
//                    bundle.putInt("counter",counterup);
//                    message.setData(bundle);
//                    myhandler.sendMessage(message);
//
//                    counterup = counterup + 1;
//                }
//                try {
//                    Thread.sleep(1000);
//
//                }catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//            }
//
//        }
//    }
//
//    class myhandler extends Handler{
//        @Override
//        public void handleMessage(Message msg) {
//            int count=  msg.getData().getInt("counter");
//            seekBar.setProgress(counterup);
//            textView.setText("Counter " + count);
//        }
//    }

    SeekBar seekBar;
    TextView textView;
    boolean isrunning = false;
    int maxvalue = 50;
    int beginvalue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        textView = (TextView) findViewById(R.id.textView);
        seekBar.setMax(maxvalue);

    }

    public void startbtn(View view) {
        isrunning  = true;
        mythread mythread = new mythread();
        mythread.start();

    }

    public void stopbtn(View view) {
        isrunning =false;
    }

    class mythread extends  Thread{

        @Override
        public void run() {

            while (isrunning){
                if(beginvalue<maxvalue){

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            seekBar.setProgress(beginvalue);
                            textView.setText("Counter "+ beginvalue);
                        }
                    });

                    beginvalue = beginvalue+1;
                }try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

}


