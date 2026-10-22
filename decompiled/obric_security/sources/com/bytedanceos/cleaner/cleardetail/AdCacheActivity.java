package com.bytedanceos.cleaner.cleardetail;

import android.os.Bundle;
import com.bytedanceos.cleaner.CleanerActivity;
import com.obric.security.cleaner.CleanerDetail2Activity;

/* JADX INFO: loaded from: classes2.dex */
public class AdCacheActivity extends CleanerDetail2Activity {
    public AdCacheActivity() {
    }

    @Override // com.obric.security.cleaner.CleanerDetail2Activity, com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        getIntent().putExtra(CleanerActivity.TYPE, -1);
        super.onCreate(savedInstanceState);
    }
}
