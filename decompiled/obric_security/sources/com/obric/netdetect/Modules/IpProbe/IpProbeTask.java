package com.obric.netdetect.Modules.IpProbe;

import android.os.AsyncTask;
import com.obric.netdetect.API.Callback.IpProbeCallback;
import com.obric.netdetect.API.NetDetectConfig;

/* JADX INFO: loaded from: classes3.dex */
public class IpProbeTask extends AsyncTask<String, Void, Void> implements IpProbe.IpProbeListener {
    private static final String TAG = "IpProbeTask";
    private String ip;
    private final IpProbeCallback mCallback;
    private IpProbe mIpProbe;
    private int mNetworkType;

    @Override // android.os.AsyncTask
    protected /* bridge */ /* synthetic */ Void doInBackground(String[] r1) {
        return doInBackground2(r1);
    }

    public IpProbeTask(IpProbeCallback r1, NetDetectConfig r2, int r3, String r4) {
        this.mCallback = r1;
        this.mIpProbe = new IpProbe(this, r2.ipProbeTimeout);
        this.ip = r4;
        this.mNetworkType = r3;
    }

    /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
    protected Void doInBackground2(String... r2) {
        this.mIpProbe.executeIpProbe(r2[0]);
        return null;
    }

    @Override // com.obric.netdetect.Modules.IpProbe.IpProbe.IpProbeListener
    public void onIpProbeFail() {
        IpProbeCallback r0 = this.mCallback;
        if (r0 == null) goto L6;
        r0.onIpProbeResult(new IpProbeResult(this.mNetworkType, 1, this.ip, null));
        return;
    }

    @Override // com.obric.netdetect.Modules.IpProbe.IpProbe.IpProbeListener
    public void onIpConflict(String r5) {
        IpProbeCallback r0 = this.mCallback;
        if (r0 == null) goto L6;
        r0.onIpProbeResult(new IpProbeResult(this.mNetworkType, 3, this.ip, r5));
        return;
    }

    @Override // com.obric.netdetect.Modules.IpProbe.IpProbe.IpProbeListener
    public void onIpAvailable() {
        IpProbeCallback r0 = this.mCallback;
        if (r0 == null) goto L6;
        r0.onIpProbeResult(new IpProbeResult(this.mNetworkType, 2, this.ip, null));
        return;
    }
}
