package com.obric.netdetect.Modules.IpProbe;

import android.os.RemoteException;
import com.cae.caed.IIpDetcCallback;
import com.cae.caed.INefiService;
import com.obric.netdetect.Utils.NetDetectLog;

/* JADX INFO: loaded from: classes3.dex */
public class IpProbe {
    private static final String CAED_SERVICE_NAME = "caed";
    private static final int GET_SERVER_INTERVAL_MS = 100;
    private static final int RETRY_GET_SERVER_COUNT = 30;
    private static final String TAG = "IpProbe";
    private final IIpDetcCallback.Stub mIpDetcCallback;
    private final IpProbeListener mIpProbeListener;
    private final int mIpProbeTimeout;
    private INefiService mNefiService;

    public interface IpProbeListener {
        void onIpAvailable();

        void onIpConflict(String r1);

        void onIpProbeFail();
    }

    static /* synthetic */ INefiService access$000(IpProbe r0) {
        return r0.mNefiService;
    }

    static /* synthetic */ INefiService access$002(IpProbe r0, INefiService r1) {
        r0.mNefiService = r1;
        return r1;
    }

    static /* synthetic */ void access$100(IpProbe r0) {
        r0.setBinderDeath();
    }

    static /* synthetic */ IpProbeListener access$200(IpProbe r0) {
        return r0.mIpProbeListener;
    }

    public IpProbe(IpProbeListener r2, int r3) {
        this.mNefiService = null;
        this.mIpDetcCallback = new AnonymousClass3(this);
        this.mIpProbeListener = r2;
        this.mIpProbeTimeout = r3;
        doBindServiceThread();
    }

    public void executeIpProbe(String r5) {
        if (r5 != null) goto L6;
        NetDetectLog.e(TAG, "iface is null");
        this.mIpProbeListener.onIpProbeFail();
        return;
    L6:
        int r1 = 0;
    L7:
        INefiService r2 = this.mNefiService;
        if (r2 != null) goto L17;
        if (r1 >= 30) goto L17;
        Thread.sleep(100);     // Catch: InterruptedException -> L14
        r1 = r1 + 1;
    L14:
        e = move-exception;
        throw new RuntimeException(e);
    L17:
        if (r2 != null) goto L23;
        NetDetectLog.e(TAG, "NefiService bind failed.");
        this.mIpProbeListener.onIpProbeFail();
        return;
    L23:
        r2.StartDetectIP(this.mIpDetcCallback, r5, this.mIpProbeTimeout);     // Catch: RemoteException -> L21
        return;
    L21:
        NetDetectLog.e(TAG, "NefiService StartDetectIP failed.");
    }

    private void doBindServiceThread() {
        new Thread(new AnonymousClass1(this)).start();
    }

    private void setBinderDeath() {
        this.mNefiService.asBinder().linkToDeath(new AnonymousClass2(this), 0);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        NetDetectLog.e(TAG, "mNefiService linkToDeath! :" + e);
    }
}
