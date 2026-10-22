package com.android.settings;

import android.app.IntentService;
import android.content.Intent;
import com.android.settings.utils.SettingsProviderUtils;

/* JADX INFO: loaded from: classes2.dex */
public class ReduceScreenStrobeService extends IntentService {
    private static final String ACTION_REDUCE_SCREEN_STROBE = "com.bytedanceos.action.REDUCE_SCREEN_STROBE";
    private static final String SWITCH_STATUS = "switch_status";
    public static final String TAG = "ReduceScreenStrobeService";

    public ReduceScreenStrobeService() {
        super(TAG);
        setIntentRedelivery(true);
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent r3) {
        if (ACTION_REDUCE_SCREEN_STROBE.equals(r3.getAction()) == true) goto L5;
        return;
    L5:
        if (SettingsFeature.isDarwin() == true) goto L7;
    L9:
        Calibration.setReduceScreenStrobeEnable(r3.getBooleanExtra(SWITCH_STATUS, false));
        return;
    L7:
        if (SettingsProviderUtils.getSystemScreenBrightness(getApplicationContext()) > 0.275f) goto L9;
    }
}
