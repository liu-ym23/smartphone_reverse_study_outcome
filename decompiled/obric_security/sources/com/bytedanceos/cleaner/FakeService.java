package com.bytedanceos.cleaner;

import android.app.IntentService;
import android.content.Intent;
import bytedanceos.util.LogTag;

/* JADX INFO: loaded from: classes2.dex */
public class FakeService extends IntentService {
    private static final String TAG = "FakeService";

    public FakeService() {
        super(TAG);
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        LogTag.d(TAG, "FakeService onHandleIntent " + intent);
    }
}
