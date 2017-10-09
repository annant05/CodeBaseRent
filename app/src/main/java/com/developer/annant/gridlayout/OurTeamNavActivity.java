package com.developer.annant.gridlayout;

import android.animation.AnimatorInflater;
import android.animation.StateListAnimator;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Toast;

public class OurTeamNavActivity extends AppCompatActivity {

    Context context = OurTeamNavActivity.this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_our_team);

        CardView card = (CardView) findViewById(R.id.cardview_ourteam);
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
                Toast.makeText(context,"Our Team Member ",Toast.LENGTH_LONG).show();
            }
        });


    }
}
