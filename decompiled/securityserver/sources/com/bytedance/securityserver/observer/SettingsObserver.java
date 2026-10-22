package com.bytedance.securityserver.observer;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.provider.Settings;
import android.util.Log;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class SettingsObserver extends ContentObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ContentResolver f56a;
    public final HashMap b;

    public SettingsObserver(Context r1, Handler r2) {
        super(r2);
        this.b = new HashMap();
        this.f56a = r1.getContentResolver();
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean r4, Uri r5) {
        super.onChange(r4, r5);
        String r6 = r5.getLastPathSegment();
        if (r6 != null) goto L6;
        Log.e("SecurityServer-SettingsObserver", "cannot extract key from uri = " + r5);
        return;
    L6:
        OnSettingChangedListener r1 = (OnSettingChangedListener) this.b.get(r6);
        if (r1 != null) goto L10;
        Log.e("SecurityServer-SettingsObserver", "no listener registered for key=" + r6 + ", uri=" + r5);
        return;
    L10:
        boolean r0 = r5.toString().contains("global");
        ContentResolver r3 = this.f56a;
        if (r0 == false) goto L14;
        String r7 = Settings.Global.getString(r3, r6);
    L20:
        r1.a(r6, r7);
        return;
    L14:
        if (r5.toString().contains("secure") == false) goto L17;
        r7 = Settings.Secure.getString(r3, r6);
        goto L20
    L17:
        if (r5.toString().contains("system") == false) goto L19;
        r7 = Settings.System.getString(r3, r6);
        goto L20
    L19:
        r7 = null;
        goto L20
    }
}
