package com.obric.netdetect.Modules.PingProbe;

import android.os.AsyncTask;
import com.obric.netdetect.API.Callback.PingCallback;
import com.obric.netdetect.API.NetDetectConfig;

/* JADX INFO: loaded from: classes3.dex */
public class PingProbeTask extends AsyncTask<String, Void, Void> implements PingProbe.PingProbeListener {
    private static final String TAG = "PingProbeTask";
    private PingCallback mCallback;
    private String mHostIp;
    private int mNetworkType;
    private PingNative mPingNative;
    private PingProbe mPingProbe;

    @Override // android.os.AsyncTask
    protected /* bridge */ /* synthetic */ Void doInBackground(String[] r1) {
        return doInBackground2(r1);
    }

    public PingProbeTask(int r2, NetDetectConfig r3, PingCallback r4) {
        this.mNetworkType = r2;
        this.mCallback = r4;
        this.mPingNative = new PingNative();
        this.mPingProbe = new PingProbe(this, this.mPingNative, r3.pingProbeCount, r3.pingProbeTimeout);
    }

    /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
    protected Void doInBackground2(String... r2) {
        String r3 = r2[0];
        this.mHostIp = r3;
        this.mPingProbe.executePingProbe(r3);
        return null;
    }

    @Override // com.obric.netdetect.Modules.PingProbe.PingProbe.PingProbeListener
    public void onPingProbeSuccess(int r9, int r10, int r11, int r12, int r13) {
        PingCallback r0 = this.mCallback;
        if (r0 == null) goto L6;
        r0.onPingResult(PingResult.success(this.mNetworkType, this.mHostIp, r9, r10, r12, r13, r11));
        return;
    }

    @Override // com.obric.netdetect.Modules.PingProbe.PingProbe.PingProbeListener
    public void onPingPartialSuccess(int r10, int r11, int r12, int r13, int r14, int r15) {
        PingCallback r0 = this.mCallback;
        if (r0 == null) goto L6;
        r0.onPingResult(PingResult.partial(this.mNetworkType, this.mHostIp, r10, r11, r13, r14, r12, r15));
        return;
    }

    @Override // com.obric.netdetect.Modules.PingProbe.PingProbe.PingProbeListener
    public void onPingProbeFailure(int r3, int r4) {
        PingCallback r0 = this.mCallback;
        if (r0 == null) goto L6;
        r0.onPingResult(PingResult.failed(this.mNetworkType, this.mHostIp, r3, r4));
        return;
    }
}
