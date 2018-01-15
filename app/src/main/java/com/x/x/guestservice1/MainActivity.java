/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.x.x.guestservice1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.x.x.guestservice1.R;

/*
 * MainActivity class that loads {@link MainFragment}.
 */
public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        getActionBar().setDisplayHomeAsUpEnabled(true);

        WebView wb = (WebView) findViewById(R.id.web_view_ad);
        wb.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE);
        wb.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        wb.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        wb.setSystemUiVisibility(View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        wb.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
        wb.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        WebSettings settings = wb.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setMediaPlaybackRequiresUserGesture(false);
        settings.setUseWideViewPort(true);
        settings.setBuiltInZoomControls(false);
        settings.setLoadWithOverviewMode(true);

        wb.setWebChromeClient(new WebChromeClient());
        wb.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                Toast.makeText(MainActivity.this, url, Toast.LENGTH_SHORT).show();
                return super.shouldOverrideUrlLoading(view, url);
            }
        });
        wb.setInitialScale(1);
        wb.loadUrl("http://www.experienceavalon.com/events/featured-events/");

    }
}
