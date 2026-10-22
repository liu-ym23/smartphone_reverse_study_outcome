package com.obric.netdetect.Modules.HttpProbe;

import android.net.Network;
import android.os.AsyncTask;
import com.obric.netdetect.API.Callback.HttpProbeCallback;
import com.obric.netdetect.API.NetDetectConfig;
import com.obric.netdetect.Utils.NetDetectLog;

/* JADX INFO: loaded from: classes3.dex */
public class HttpProbeTask extends AsyncTask<String, Void, Void> implements HttpConnectionProbe.HttpProbeListener {
    private static final String TAG = "HttpDetectTask";
    private HttpProbeCallback mCallback;
    private HttpConnectionProbe mHttpConnectionProbe;
    private final int mNetworkType;
    private String mProbeUrl;

    @Override // android.os.AsyncTask
    protected /* bridge */ /* synthetic */ Void doInBackground(String[] r1) {
        return doInBackground2(r1);
    }

    public HttpProbeTask(int r1, Network r2, NetDetectConfig r3, HttpProbeCallback r4) {
        this.mNetworkType = r1;
        this.mCallback = r4;
        this.mHttpConnectionProbe = new HttpConnectionProbe(this, r2, r3.httpProbeTimeout);
    }

    /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
    protected Void doInBackground2(String... r2) {
        String r3 = r2[0];
        this.mProbeUrl = r3;
        this.mHttpConnectionProbe.executeHttpProbe(r3);
        return null;
    }

    @Override // com.obric.netdetect.Modules.HttpProbe.HttpConnectionProbe.HttpProbeListener
    public void onProbeSuccess(int r3, int r4) {
        NetDetectLog.d(TAG, "http probe result success. response code: " + r3 + ", rtt: " + r4);
        HttpProbeCallback r0 = this.mCallback;
        if (r0 == null) goto L6;
        r0.onHttpProbeResult(HttpProbeResult.success(this.mNetworkType, this.mProbeUrl, r4, r3));
        return;
    }

    @Override // com.obric.netdetect.Modules.HttpProbe.HttpConnectionProbe.HttpProbeListener
    public void onProbeFailure(int r3, int r4) {
        NetDetectLog.d(TAG, "http probe result failed. response code: " + r3 + ", errorCode: " + r4);
        HttpProbeCallback r0 = this.mCallback;
        if (r0 == null) goto L6;
        r0.onHttpProbeResult(HttpProbeResult.failed(this.mNetworkType, this.mProbeUrl, r3, r4));
        return;
    }

    @Override // com.obric.netdetect.Modules.HttpProbe.HttpConnectionProbe.HttpProbeListener
    public void onProbePortal(int r3, String r4) {
        NetDetectLog.d(TAG, "http probe result portal. response code: " + r3 + ", redirectUrl: " + r4);
        HttpProbeCallback r0 = this.mCallback;
        if (r0 == null) goto L6;
        r0.onHttpProbeResult(HttpProbeResult.portal(this.mNetworkType, this.mProbeUrl, r4, r3));
        return;
    }
}
