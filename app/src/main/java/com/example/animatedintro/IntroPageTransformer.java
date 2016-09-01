package com.example.animatedintro;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by Pushpendra on 5/8/16.
 */
public class IntroPageTransformer implements ViewPager.PageTransformer {

    @Override
    public void transformPage(View page, float position) {

        // Get the page index from the tag. This makes
        // it possible to know which page index you're
        // currently transforming - and that can be used
        // to make some important performance improvements.
        int pagePosition = (int) page.getTag();

        // Here you can do all kinds of stuff, like get the
        // width of the page and perform calculations based
        // on how far the user has swiped the page.
        int pageWidth = page.getWidth();
        float pageWidthTimesPosition = pageWidth * position;
        float absPosition = Math.abs(position);

        // Now it's time for the effects
        if (position <= -1.0f || position >= 1.0f) {

            // The page is not visible. This is a good place to stop
            // any potential work / animations you may have running.

        } else if (position == 0.0f) {

            // The page is selected. This is a good time to reset Views
            // after animations as you can't always count on the PageTransformer
            // callbacks to match up perfectly.

        } else {

            // The page is currently being scrolled / swiped. This is
            // a good place to show animations that react to the user's
            // swiping as it provides a good user experience.

            // Let's start by animating the title.
            // We want it to fade as it scrolls out
            View title = page.findViewById(R.id.title);
            title.setAlpha(1.0f - absPosition);

            // Now the description. We also want this one to
            // fade, but the animation should also slowly move
            // down and out of the screen
            /*View description = page.findViewById(R.id.description);
            description.setTranslationY(-pageWidthTimesPosition / 2f);
            description.setAlpha(1.0f - absPosition);*/

            // Now, we want the image to move to the right,
            // i.e. in the opposite direction of the rest of the
            // content while fading out
            View fish1 = page.findViewById(R.id.fish1);
            View fish2 = page.findViewById(R.id.fish2);
            View fish3 = page.findViewById(R.id.fish3);
            View fish4 = page.findViewById(R.id.fish4);
            View whale = page.findViewById(R.id.whale);

            // We're attempting to create an effect for a View
            // specific to one of the pages in our ViewPager.
            // In other words, we need to check that we're on
            // the correct page and that the View in question
            // isn't null.
            if (whale != null) {
                whale.setAlpha(1.0f - absPosition);
                whale.setTranslationX(-pageWidthTimesPosition * 1f);
            }
            if(fish1 !=null){
                fish1.setAlpha(1.0f - absPosition);
                fish1.setTranslationX(pageWidthTimesPosition * 0.2f);
            }

            if(fish2 !=null){
                fish2.setAlpha(1.0f - absPosition);
                fish2.setTranslationX(-pageWidthTimesPosition * 1f);
            }

            if(fish3 !=null){
                fish3.setAlpha(1.0f - absPosition);
                fish3.setTranslationX(-pageWidthTimesPosition * 1f);
            }
            if(fish4 !=null){
                fish4.setAlpha(1.0f - absPosition);
                fish4.setTranslationX(pageWidthTimesPosition * 0.4f);
            }

            // Finally, it can be useful to know the direction
            // of the user's swipe - if we're entering or exiting.
            // This is quite simple:
            if (position < 0) {
                // Create your out animation here
            } else {
                // Create your in animation here
            }
        }
    }

}
