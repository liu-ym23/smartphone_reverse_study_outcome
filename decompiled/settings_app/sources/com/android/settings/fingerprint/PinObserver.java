package com.android.settings.fingerprint;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.provider.Settings;

/* JADX INFO: loaded from: classes2.dex */
public class PinObserver extends ContentObserver {
    private static final String PINNED_IN_KEYGUARD_TASK_ID = "PINNED_TASK_ID";
    private Context mContext;
    private OnPinListener mPinListener;
    private Uri mUri;

    public interface OnPinListener {
        void onPinChanged(boolean r1);
    }

    public PinObserver(Context r1, Handler r2) {
        super(r2);
        this.mContext = r1;
        this.mUri = Settings.Global.getUriFor(PINNED_IN_KEYGUARD_TASK_ID);
    }

    public void registerObserver(boolean r3) {
        ContentResolver r0 = this.mContext.getContentResolver();
        if (r3 == false) goto L5;
        r0.registerContentObserver(this.mUri, false, this);
        return;
    L5:
        r0.unregisterContentObserver(this);
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean r2, Uri r3) {
        super.onChange(r2, r3);
        if (this.mPinListener == null) goto L12;
        Context r4 = this.mContext;
        if (r4 != null) goto L8;
        return;
    L8:
        if (Settings.Global.getInt(r4.getContentResolver(), PINNED_IN_KEYGUARD_TASK_ID, -1) == (-1)) goto L10;
        this.mPinListener.onPinChanged(true);
        return;
    L10:
        this.mPinListener.onPinChanged(false);
        return;
    }

    public void setOnPinListener(OnPinListener r1) {
        this.mPinListener = r1;
    }
}
