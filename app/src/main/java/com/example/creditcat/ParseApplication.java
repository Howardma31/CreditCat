package com.example.creditcat;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {

    // Initializes Parse SDK as soon as the application is created
    @Override
    public void onCreate() {
        super.onCreate();

        // Register your parse models

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("ncIMApbCoojZdgP1H05YJCFUvCW5Mx6rr5waVFci")
                .clientKey("D0inawROlThCdZLk0HUTtKH7ikLMAfuv3CCEvVNW")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
