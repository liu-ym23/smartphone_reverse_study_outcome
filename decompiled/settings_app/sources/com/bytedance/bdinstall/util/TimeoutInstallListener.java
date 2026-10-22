package com.bytedance.bdinstall.util;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.bdinstall.IInstallListener;
import com.bytedance.bdinstall.InstallInfo;
import com.bytedance.bdinstall.OnResetListener;

/* JADX INFO: loaded from: classes3.dex */
public class TimeoutInstallListener implements IInstallListener {
    private final Handler mHandler;
    private OnResetListener mListener;
    private final long mTimeout;

    static /* synthetic */ OnResetListener access$000(TimeoutInstallListener r0) {
        return r0.mListener;
    }

    static /* synthetic */ OnResetListener access$002(TimeoutInstallListener r0, OnResetListener r1) {
        r0.mListener = r1;
        return r1;
    }

    public TimeoutInstallListener(long r3, OnResetListener r5) {
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mTimeout = r3;
        this.mListener = r5;
    }

    @Override // com.bytedance.bdinstall.IInstallListener
    public void installFinished(final InstallInfo r3) {
        this.mHandler.post(new AnonymousClass1(this, r3));
    }

    public void startTiming() {
        this.mHandler.postDelayed(new AnonymousClass2(this), this.mTimeout);
    }
}
