package com.sample.enil;

import android.os.Bundle;
import timber.log.Timber;

public class StartUpActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Timber.d("Start");
        if (ActivityLifecycleUtility.getInstance().isFinishing()) {
            return;
        }}

}
