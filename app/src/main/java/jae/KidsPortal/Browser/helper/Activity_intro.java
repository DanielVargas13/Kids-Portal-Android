package jae.KidsPortal.Browser.helper;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;

import com.chyrta.onboarder.OnboarderActivity;
import com.chyrta.onboarder.OnboarderPage;
import com.google.firebase.FirebaseApp;

import java.util.ArrayList;
import java.util.List;

import jae.KidsPortal.Browser.ParentAuth;
import jae.KidsPortal.Browser.R;


public class Activity_intro extends OnboarderActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        List<OnboarderPage> onboarderPages = new ArrayList<>();
        // Create your first page
        OnboarderPage onboarderPage1 = new OnboarderPage(getString(R.string.intro1_title), getString(R.string.intro1_text), R.drawable.ic_launcher_intro);
        OnboarderPage onboarderPage2 = new OnboarderPage(getString(R.string.intro2_title), getString(R.string.intro2_text), R.drawable.s_1);
        OnboarderPage onboarderPage3 = new OnboarderPage(getString(R.string.intro3_title), getString(R.string.intro3_text), R.drawable.s_2);
        OnboarderPage onboarderPage4 = new OnboarderPage(getString(R.string.intro4_title), getString(R.string.intro4_text), R.drawable.s_3);
        OnboarderPage onboarderPage5 = new OnboarderPage(getString(R.string.intro5_title), getString(R.string.intro5_text), R.drawable.s_4);


        // You can define title and description colors (by default white)
        onboarderPage1.setTitleColor(R.color.colorAccent);
        onboarderPage1.setBackgroundColor(R.color.colorPrimary_blue);
        onboarderPage2.setTitleColor(R.color.colorAccent);
        onboarderPage2.setBackgroundColor(R.color.colorPrimary_blue);
        onboarderPage3.setTitleColor(R.color.colorAccent);
        onboarderPage3.setBackgroundColor(R.color.colorPrimary_blue);
        onboarderPage4.setTitleColor(R.color.colorAccent);
        onboarderPage4.setBackgroundColor(R.color.colorPrimary_blue);
        onboarderPage5.setTitleColor(R.color.colorAccent);
        onboarderPage5.setBackgroundColor(R.color.colorPrimary_blue);

        // Add your pages to the fragments
        onboarderPages.add(onboarderPage1);
        onboarderPages.add(onboarderPage2);
        onboarderPages.add(onboarderPage3);
        onboarderPages.add(onboarderPage4);
        onboarderPages.add(onboarderPage5);
        // And pass your pages to 'setOnboardPagesReady' method
        setActiveIndicatorColor(R.color.colorLight);
        setInactiveIndicatorColor(R.color.colorLight_trans);
        shouldDarkenButtonsLayout(true);
        setSkipButtonHidden();
        setFinishButtonTitle(getString(R.string.intro_finish));
        setOnboardPagesReady(onboarderPages);
    }

    @Override
    public void onFinishButtonPressed() {
        // Define your actions when the user press 'Finish' button
        PreferenceManager.setDefaultValues(this, R.xml.user_settings, false);
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        sharedPref.edit().putBoolean("introShowDo_notShow", false).apply();
        Intent intent = new Intent(this, ParentAuth.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onSkipButtonPressed() {
     //
    }
}
