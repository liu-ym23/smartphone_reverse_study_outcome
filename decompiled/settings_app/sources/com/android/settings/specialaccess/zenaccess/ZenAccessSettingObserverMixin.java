package com.android.settings.specialaccess.zenaccess;

import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import com.android.settingslib.core.lifecycle.LifecycleObserver;
import com.android.settingslib.core.lifecycle.events.OnStart;
import com.android.settingslib.core.lifecycle.events.OnStop;

/* JADX INFO: loaded from: classes2.dex */
public class ZenAccessSettingObserverMixin extends ContentObserver implements LifecycleObserver, OnStart, OnStop {
    private final Context mContext;
    private final Listener mListener;

    public interface Listener {
        void onZenAccessPolicyChanged();
    }

    public ZenAccessSettingObserverMixin(Context r3, Listener r4) {
        super(new Handler(Looper.getMainLooper()));
        this.mContext = r3;
        this.mListener = r4;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean r1, Uri r2) {
        Listener r0 = this.mListener;
        if (r0 == null) goto L6;
        r0.onZenAccessPolicyChanged();
        return;
    }

    @Override // com.android.settingslib.core.lifecycle.events.OnStart
    public void onStart() {
        this.mContext.getContentResolver().registerContentObserver(Settings.Secure.getUriFor("enabled_notification_listeners"), false, this);
    }

    @Override // com.android.settingslib.core.lifecycle.events.OnStop
    public void onStop() {
        this.mContext.getContentResolver().unregisterContentObserver(this);
    }
}
