package com.obric.settingcommon;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import com.android.settings.ISettingsSearchService;
import com.android.settings.IUpdateViewListener;

/* JADX INFO: loaded from: classes5.dex */
public class SearchService {
    private static final String TAG = "SearchService";
    private static volatile SearchService mService;
    private static final ServiceConnection mServiceConnection = null;
    private static ISettingsSearchService mSettingsSearchService;

    static /* synthetic */ ISettingsSearchService access$002(ISettingsSearchService r0) {
        mSettingsSearchService = r0;
        return r0;
    }

    SearchService(Context r1) {
        initSettingsSearchServiceClient(r1);
    }

    public static SearchService getInstance(Context r2) {
        if (mService != null) goto L15;
        monitor-enter(SearchService.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mService != null) goto L9;
        mService = new SearchService(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(SearchService.class);     // Catch: Throwable -> L11
    L15:
        return mService;
    }

    static {
        mServiceConnection = new AnonymousClass1();
    }

    public static void initSettingsSearchServiceClient(Context r3) {
        Intent r0 = new Intent();
        r0.setAction("com.android.settings.SETTINGS_SEARCH_SERVICE");
        r0.setPackage("com.android.settings");
        if (r3.bindService(r0, mServiceConnection, 1) == false) goto L6;
        Log.d(TAG, "initSettingsSearchServiceClient success");
        return;
    }

    public static void setSettingsEnabled(String r2, boolean r3) {
        Log.d(TAG, "setSettingsEnabled key = " + r2 + ", enabled = " + r3);
        ISettingsSearchService r0 = mSettingsSearchService;
        if (r0 != null) goto L10;
        Log.d(TAG, "mSettingsSearchService is null, key = " + r2);
        return;
    L10:
        r0.setSettingsEnabled(r2, r3);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }

    public static boolean isSettingsEnabled(String r3) {
        Log.d(TAG, "isSettingsEnabled key = " + r3);
        ISettingsSearchService r0 = mSettingsSearchService;
        if (r0 != null) goto L11;
        Log.d(TAG, "mSettingsSearchService is null, key = " + r3);
        return false;
    L11:
        return r0.isSettingsEnabled(r3);
    L6:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public static void setOnUpdateViewListener(String r2, IUpdateViewListener r3) {
        Log.d(TAG, "setOnUpdateViewListener key = " + r2);
        ISettingsSearchService r0 = mSettingsSearchService;
        if (r0 != null) goto L10;
        Log.d(TAG, "mSettingsSearchService is null, key = " + r2);
        return;
    L10:
        r0.setOnUpdateViewListener(r2, r3);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }
}
