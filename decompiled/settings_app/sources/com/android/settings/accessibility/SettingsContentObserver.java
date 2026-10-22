package com.android.settings.accessibility;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.provider.Settings;

/* JADX INFO: loaded from: classes2.dex */
abstract class SettingsContentObserver extends ContentObserver {
    @Override // android.database.ContentObserver
    public abstract void onChange(boolean r1, Uri r2);

    public SettingsContentObserver(Handler r1) {
        super(r1);
    }

    public void register(ContentResolver r3) {
        r3.registerContentObserver(Settings.Secure.getUriFor("accessibility_enabled"), false, this);
        r3.registerContentObserver(Settings.Secure.getUriFor("enabled_accessibility_services"), false, this);
    }

    public void unregister(ContentResolver r1) {
        r1.unregisterContentObserver(this);
    }
}
