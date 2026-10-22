package com.android.settings.fingerprint;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.provider.Settings;

/* JADX INFO: loaded from: classes2.dex */
public class FingerprintCallObserver extends ContentObserver {
    private static final String SHOW_FINGERPRINT_ENROLL_ICON = "SHOW_FINGERPRINT_ENROLL_ICON";
    private Context mContext;
    private OnFingerCallListener mFingerCallListener;
    private Uri mUri;

    public interface OnFingerCallListener {
        void onFingerCall(boolean r1);
    }

    public FingerprintCallObserver(Context r1, Handler r2) {
        super(r2);
        this.mContext = r1;
        this.mUri = Settings.Global.getUriFor(SHOW_FINGERPRINT_ENROLL_ICON);
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
        if (this.mFingerCallListener == null) goto L14;
        Context r4 = this.mContext;
        if (r4 == null) goto L17;
        int r5 = Settings.Global.getInt(r4.getContentResolver(), SHOW_FINGERPRINT_ENROLL_ICON, 0);
        if (r5 != 1) goto L11;
        this.mFingerCallListener.onFingerCall(true);
        return;
    L11:
        if (r5 != (-1)) goto L16;
        this.mFingerCallListener.onFingerCall(false);
        return;
    L16:
        return;
    L17:
        return;
    }

    public void setOnFingerCallListener(OnFingerCallListener r1) {
        this.mFingerCallListener = r1;
    }
}
