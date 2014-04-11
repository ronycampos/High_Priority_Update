package com.randomtech.high_priority;

import com.randomtech.temp_high_priority.R;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;

public class DynamicActivity extends Activity {

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Remove title bar
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		// Remove notification bar
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		this.setContentView(R.layout.activity_main);

		AbsoluteLayout ll = (AbsoluteLayout) findViewById(R.id.ll);
		// add new color category

		// Gets screen dimensions
		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		final int width = dm.widthPixels;
		final int height = dm.heightPixels;
		int dens = dm.densityDpi;
		double wi = (double) width / (double) dens;
		double hi = (double) height / (double) dens;
		double x = Math.pow(wi, 2);
		double y = Math.pow(hi, 2);
		double screenInches = Math.sqrt(x + y);

		final Button background = new Button(this);

		background.setBackgroundResource(R.drawable.hp_background);
		background.setLayoutParams(new AbsoluteLayout.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT, 0, 0));

		// ----------------------------------- Category
		// Menu---------------------------------------------//

		background.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				LayoutInflater inflator = (LayoutInflater) getBaseContext()
						.getSystemService(LAYOUT_INFLATER_SERVICE);

				View taskmenu = inflator.inflate(R.layout.categories, null);

				final PopupWindow popupWindow = new PopupWindow(taskmenu,
						LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);

				Button backButton = (Button) taskmenu
						.findViewById(R.id.background2);

				Button newCategory = (Button) taskmenu
						.findViewById(R.id.addCategoryBubble);

				backButton.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						popupWindow.dismiss();
					}

				});
				// ----------------------------------- New Category
				// ---------------------------------------------//
				newCategory.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						popupWindow.dismiss();

						LayoutInflater inflator = (LayoutInflater) getBaseContext()
								.getSystemService(LAYOUT_INFLATER_SERVICE);

						View taskmenu = inflator.inflate(R.layout.new_category,
								null);

						final PopupWindow popupWindow = new PopupWindow(
								taskmenu, LayoutParams.MATCH_PARENT,
								LayoutParams.MATCH_PARENT);

						popupWindow.showAtLocation(v, 50, 25, 75);

						Button backButton = (Button) taskmenu
								.findViewById(R.id.cancleCategoryBubble);

						backButton.setOnClickListener(new OnClickListener() {

							@Override
							public void onClick(View arg0) {
								// TODO Auto-generated method stub
								popupWindow.dismiss();
							}

						});
					}

				});
				// ----------------------------------- New Category
				// ---------------------------------------------//
				popupWindow.showAtLocation(v, 50, 25, 75);

			}

		});
		// ----------------------------------- Category Menu
		// ---------------------------------------------//

		ll.addView(background);
		addBubble();
	}

	// ----------------------------------- Dynamicly add Bubble
	// ---------------------------------------------//
	@SuppressWarnings("deprecation")
	private void addBubble() {
		// TODO Auto-generated method stub

		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		final int width = dm.widthPixels;
		final int height = dm.heightPixels;
		int dens = dm.densityDpi;
		double wi = (double) width / (double) dens;
		double hi = (double) height / (double) dens;
		double x = Math.pow(wi, 2);
		double y = Math.pow(hi, 2);
		double screenInches = Math.sqrt(x + y);

		@SuppressWarnings("deprecation")
		AbsoluteLayout ll = (AbsoluteLayout) findViewById(R.id.ll);
		for (int i = 0; i < 4; i++) {
			Button bubble = new Button(this);
			bubble.setBackgroundResource(R.drawable.bluebubble);
			bubble.setLayoutParams(new AbsoluteLayout.LayoutParams(85, 85,
					(i + 1) * 100, (i + 1) * 100));

			// Bubble Properties
			bubble.setTextColor(Color.parseColor("#ffffff"));
			bubble.setTextSize(12);
			bubble.setText("Bubble Task " + i);
			bubble.setPadding(0, 0, 0, 0);
			
			bubble.setOnLongClickListener(new OnLongClickListener() {

				@Override
				public boolean onLongClick(View v) {
					LayoutInflater inflator = (LayoutInflater) getBaseContext()
							.getSystemService(LAYOUT_INFLATER_SERVICE);

					View taskmenu = inflator.inflate(R.layout.edit_task, null);

					final PopupWindow popupWindow = new PopupWindow(taskmenu,
							LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);

					Button cancelbutton = (Button) taskmenu
							.findViewById(R.id.cancleCategoryBubble);

					cancelbutton.setOnClickListener(new OnClickListener() {

						@Override
						public void onClick(View arg0) {
							// TODO Auto-generated method stub
							popupWindow.dismiss();
						}

					});

					popupWindow.showAtLocation(v, 50, 25, 75);
					return true;
				}
			});
			
			bubble.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub

					LayoutInflater inflator = (LayoutInflater) getBaseContext()
							.getSystemService(LAYOUT_INFLATER_SERVICE);
					View taskmenu = inflator.inflate(R.layout.task_menu, null);
					final PopupWindow popupWindow = new PopupWindow(taskmenu,
							LayoutParams.WRAP_CONTENT,
							LayoutParams.WRAP_CONTENT);

					// Closes popup window when pressed outside window
					popupWindow.setBackgroundDrawable(new BitmapDrawable());
					popupWindow.setOutsideTouchable(true);
					popupWindow.setFocusable(true);

					// Get taskmenu view dimensions

					Button cancelbutton = (Button) taskmenu
							.findViewById(R.id.cancleCategoryBubble);

					Button cancelbutton2 = (Button) taskmenu
							.findViewById(R.id.saveCategoryBubble);

	
					cancelbutton2.setOnClickListener(new OnClickListener() {

						@Override
						public void onClick(View v) {
							// TODO Auto-generated method stub

							popupWindow.dismiss();
							LayoutInflater inflator = (LayoutInflater) getBaseContext()
									.getSystemService(LAYOUT_INFLATER_SERVICE);
							View taskmenu = inflator.inflate(
									R.layout.new_category, null);
							final PopupWindow popupWindow = new PopupWindow(
									taskmenu, LayoutParams.MATCH_PARENT,
									LayoutParams.MATCH_PARENT);

							int x = (int) ((width - 400) / 2);
							int y = (int) (height * (.10));
							popupWindow.showAtLocation(v, 0, x, y);

						}

					});

					cancelbutton.setOnClickListener(new OnClickListener() {

						@Override
						public void onClick(View arg0) {
							// TODO Auto-generated method stub
							popupWindow.dismiss();

						}

					});
					int x = (int) ((width - 400) / 2);
					int y = (int) (height * (.10));
					popupWindow.showAtLocation(v, 0, x, y);
				}
			});

			ll.addView(bubble);
		}
	}
	// ----------------------------------- Dynamicly add Bubble
	// ---------------------------------------------//

}
