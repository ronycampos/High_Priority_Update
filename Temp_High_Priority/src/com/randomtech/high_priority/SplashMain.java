package com.randomtech.high_priority;

import com.randomtech.temp_high_priority.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.os.CountDownTimer;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;

@SuppressWarnings("deprecation")
public class SplashMain extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		// Remove title bar
				this.requestWindowFeature(Window.FEATURE_NO_TITLE);
				// Remove notification bar
				this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
						WindowManager.LayoutParams.FLAG_FULLSCREEN);
				this.setContentView(R.layout.activity_main);
		setContentView(R.layout.splachscreen);
		
		Thread splashTimer = new Thread(){
			public void run(){
				try{
					sleep(3000);
					Intent dynamicIntent = new Intent("com.randomtech.high_priority.DYNAMIC");
					startActivity(dynamicIntent);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally{
					finish();
				}
			}
		};
		splashTimer.start();//starts thread
	}
	

}
