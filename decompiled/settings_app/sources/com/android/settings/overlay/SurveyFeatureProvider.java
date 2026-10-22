package com.android.settings.overlay;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

/* JADX INFO: loaded from: classes2.dex */
public interface SurveyFeatureProvider {
    @Deprecated
    BroadcastReceiver createAndRegisterReceiver(Activity r1);

    @Deprecated
    void downloadSurvey(Activity r1, String r2, String r3);

    @Deprecated
    long getSurveyExpirationDate(Context r1, String r2);

    @Deprecated
    String getSurveyId(Context r1, String r2);

    void sendActivityIfAvailable(String r1);

    @Deprecated
    boolean showSurveyIfAvailable(Activity r1, String r2);

    @Deprecated
    static void unregisterReceiver(Activity r0, BroadcastReceiver r1) {
        if (r0 == null) goto L6;
        LocalBroadcastManager.getInstance(r0).unregisterReceiver(r1);
        return;
    L6:
        throw new IllegalStateException("Cannot unregister receiver if activity is null");
    }
}
