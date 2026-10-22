package com.bytedance.ttnet.diagnosis;

import a.a;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.constraintlayout.core.state.b;
import com.bytedance.common.utility.Logger;

/* JADX INFO: loaded from: classes.dex */
public class TTGameDiagnosisService {
    private static final String TAG = "TTGameDiagnosisService";
    private static volatile TTGameDiagnosisService sInstance;
    private IDiagnosisCallback mDiagnosisCallback;
    private volatile boolean mIsMonitoring;
    private IDiagnosisRequest mRequest;

    private TTGameDiagnosisService() {
        this.mRequest = null;
        this.mIsMonitoring = false;
        this.mDiagnosisCallback = new b(8);
    }

    public static /* synthetic */ void a(String r0) {
        lambda$new$0(r0);
    }

    public static TTGameDiagnosisService inst() {
        if (sInstance != null) goto L16;
        monitor-enter(TTGameDiagnosisService.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L11;
        sInstance = new TTGameDiagnosisService();     // Catch: Throwable -> L9
    L11:
        monitor-exit(TTGameDiagnosisService.class);     // Catch: Throwable -> L9
    L16:
        return sInstance;
    }

    private static /* synthetic */ void lambda$new$0(String r2) {
        if (Logger.debug() == false) goto L6;
        a.y("onDiagnosisComplete: ", r2, TAG);
        return;
    }

    public void doDiagnosisDuringGaming(String r3) {
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L4:
        if (this.mIsMonitoring == true) goto L9;
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L9:
        this.mRequest.doExtraCommand("diagnosis", r3);     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
    }

    public boolean isMonitoring() {
        return this.mIsMonitoring;
    }

    public void monitorBegin(String r4, String r5) {
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L4:
        if (this.mIsMonitoring == false) goto L9;
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L9:
        IDiagnosisRequest r6 = TTNetDiagnosisService.createRequest(4, r4, 0, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);     // Catch: Throwable -> L7
        this.mRequest = r6;     // Catch: Throwable -> L7
        r6.start(this.mDiagnosisCallback);     // Catch: Throwable -> L7
        this.mRequest.doExtraCommand("extra_info", r5);     // Catch: Throwable -> L7
        this.mIsMonitoring = true;     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
    }

    public void monitorEnd() {
        monitorEnd(null);
    }

    public void monitorEnd(String r3) {
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L4:
        if (this.mIsMonitoring == true) goto L9;
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L9:
        if (r3 == null) goto L11;
        this.mRequest.doExtraCommand("extra_info", r3);     // Catch: Throwable -> L7
    L11:
        this.mRequest.doExtraCommand("finish", "");     // Catch: Throwable -> L7
        this.mIsMonitoring = false;     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
    }
}
