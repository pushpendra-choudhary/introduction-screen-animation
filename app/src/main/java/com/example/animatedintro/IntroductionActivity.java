package com.example.animatedintro;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class IntroductionActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private ImageView img_page1, img_page2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);

        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        img_page1 = (ImageView) findViewById(R.id.img1);
        img_page2 = (ImageView) findViewById(R.id.img2);

        // Set an Adapter on the ViewPager
        mViewPager.setAdapter(new IntroAdapter(getSupportFragmentManager()));

        // Set a PageTransformer
        mViewPager.setPageTransformer(false, new IntroPageTransformer());

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        img_page1.setImageResource(R.drawable.dot_selected);
                        img_page2.setImageResource(R.drawable.dot);
                        break;

                    case 1:
                        img_page1.setImageResource(R.drawable.dot);
                        img_page2.setImageResource(R.drawable.dot_selected);
                        break;

                    default:
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
}
