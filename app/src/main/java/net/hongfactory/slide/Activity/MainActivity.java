package net.hongfactory.slide.Activity;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import net.hongfactory.slide.R;

public class MainActivity extends AppCompatActivity {

    boolean isClicked = false;

    Animation translateLeftAnim;
    Animation translateRightAnim;

    RelativeLayout sliding;
    ImageView img_setting;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set StatusBar Color and font-color;
        setStatusBar(getWindow(),"#FFFFFF",true);


        //UI
        sliding = findViewById(R.id.sliding);
        img_setting = findViewById(R.id.setting);

        //animation
        translateLeftAnim = AnimationUtils.loadAnimation(this,R.anim.anim_left);
        translateRightAnim = AnimationUtils.loadAnimation(this,R.anim.anim_right);

        translateLeftAnim = AnimationUtils.loadAnimation(this,R.anim.anim_left_over);
        translateRightAnim = AnimationUtils.loadAnimation(this,R.anim.anim_right_over);

    }


    public void onButton_click(View v){



        if(isClicked){
            Toast.makeText(this,"Expand",Toast.LENGTH_SHORT).show();
            sliding.startAnimation(translateRightAnim);
            isClicked = false;
        }else{
            Toast.makeText(this,"Shrink",Toast.LENGTH_SHORT).show();
            sliding.startAnimation(translateLeftAnim);
            isClicked = true;
        }
    }


    private class SlidingPageAnimationListener implements Animation.AnimationListener{


        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {

            if(isClicked){
                isClicked = false;
            }else{
                isClicked = true;
            }
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }


    /*==============================================================================================
    Set StatusBar Color
    ==============================================================================================*/
    public void setStatusBar(Window window, String color, Boolean isGrey){
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                window.setStatusBarColor(Color.parseColor(color));
                if(isGrey) {
                    window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                }
            }
        }catch (Exception e){
        }
    }


}

