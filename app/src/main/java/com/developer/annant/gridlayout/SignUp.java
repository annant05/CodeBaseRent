package com.developer.annant.gridlayout;

import android.animation.AnimatorInflater;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

public class SignUp extends AppCompatActivity {

    Context context = this;
    /*private RelativeLayout layoutMain;
    private RelativeLayout layoutButtons;
    private RelativeLayout layoutContent;
    private boolean isOpen = false;

    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        CardView card = (CardView) findViewById(R.id.cardview_signup);
       // layoutMain = (RelativeLayout) findViewById(R.id.layoutMain);
        //layoutButtons = (RelativeLayout) findViewById(R.id.layout_goneshow);
        //layoutContent = (RelativeLayout) findViewById(R.id.layoutContent);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            StateListAnimator stateListAnimator = AnimatorInflater.loadStateListAnimator(context, R.animator.lift_on_touch);
            card.setStateListAnimator(stateListAnimator);
        }






        // add a click handler to ensure the CardView handles touch events
        // otherwise the animation won't work

        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //startActivity(new Intent(SignUp.this, TermsAndWindow.class));
                startActivity(new Intent(SignUp.this, MainActivity.class));
            }
        });


    }

    //

    /*Below is test animation Code
    private void viewMenu() {

        if (!isOpen) {

            int right = layoutContent.getRight();
            int left = layoutContent.getLeft();
            int x = (left + right) / 2;
            int y = layoutContent.getBottom();

            int startRadius = 0;
            int endRadius = (int) Math.hypot(layoutMain.getWidth(), layoutMain.getHeight());


            Animator anim = ViewAnimationUtils.createCircularReveal(layoutButtons, x, y, startRadius, endRadius);

            layoutButtons.setVisibility(View.VISIBLE);
            anim.start();

            isOpen = true;

        } else {

            int right = layoutContent.getRight();
            int left = layoutContent.getLeft();
            int x = (left + right) / 2;
            int y = layoutButtons.getBottom();

            int startRadius = Math.max(layoutContent.getWidth(), layoutContent.getHeight());
            int endRadius = 0;

            Animator anim = ViewAnimationUtils.createCircularReveal(layoutButtons, x, y, startRadius, endRadius);
            anim.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animator) {

                }

                @Override
                public void onAnimationEnd(Animator animator) {
                    layoutButtons.setVisibility(View.GONE);
                }

                @Override
                public void onAnimationCancel(Animator animator) {

                }

                @Override
                public void onAnimationRepeat(Animator animator) {

                }
            });
            anim.start();

            isOpen = false;
        }


    }

    */
}