package org.chromium.mpa;

import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.frameworks.baselib.network.http.cronet.mpa.IMpaService;
import com.ttnet.org.chromium.net.CronetEngine;
import com.ttnet.org.chromium.net.TTMpaService;
import java.util.List;
import org.chromium.CronetClient;

/* JADX INFO: loaded from: classes6.dex */
public class CronetMpaServiceImpl implements IMpaService {
    private static final String PRE_CNIT_KETNEL_FUNC = "preInitCronetKernel";
    private static final String TTNET_INIT_CLASS = "com.bytedance.ttnet.TTNetInit";
    private TTMpaService.ICallback mCronetAccAddressCallback;
    private CronetEngine mCronetEngine;
    private TTMpaService.ICallback mCronetInitCallback;
    private IMpaService.ICallback mOuterAccAddressCallback;
    private IMpaService.ICallback mOuterInitCallback;
    private TTMpaService mTTNetMpaService;

    public CronetMpaServiceImpl() {
        this.mCronetInitCallback = new AnonymousClass1(this);
        this.mCronetAccAddressCallback = new AnonymousClass2(this);
    }

    static /* synthetic */ IMpaService.ICallback access$000(CronetMpaServiceImpl r0) {
        return r0.mOuterInitCallback;
    }

    static /* synthetic */ IMpaService.ICallback access$100(CronetMpaServiceImpl r0) {
        return r0.mOuterAccAddressCallback;
    }

    static /* synthetic */ IMpaService.ICallback access$102(CronetMpaServiceImpl r0, IMpaService.ICallback r1) {
        r0.mOuterAccAddressCallback = r1;
        return r1;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.mpa.IMpaService
    public void init(IMpaService.ICallback r2) {
        if (createMpaService() == true) goto L6;
        r2.onFinish(false, "Create MpaService Failed");
        return;
    L6:
        this.mOuterInitCallback = r2;
        this.mTTNetMpaService.init(this.mCronetInitCallback);
    }

    private boolean createMpaService() {
        if (loadCronetKernel() == true) goto L7;
        return false;
    L7:
        if (this.mTTNetMpaService != null) goto L11;
        this.mTTNetMpaService = this.mCronetEngine.createTTMpaService();
        return true;
    L11:
        return true;
    }

    private boolean loadCronetKernel() {
        if (this.mCronetEngine == null) goto L12;
        return true;
    L12:
        Reflect.on(Class.forName(TTNET_INIT_CLASS).newInstance()).call(PRE_CNIT_KETNEL_FUNC);     // Catch: Throwable -> L8
        CronetEngine r0 = CronetClient.getCronetEngine();     // Catch: Throwable -> L8
        this.mCronetEngine = r0;     // Catch: Throwable -> L8
        if (r0 == null) goto L14;
        return true;
    L14:
        return false;
    L8:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.mpa.IMpaService
    public void setAccAddress(List<String> r4, IMpaService.ICallback r5) {
        if (this.mTTNetMpaService != null) goto L5;
        if (r5 == null) goto L23;
        r5.onFinish(false, "TTNetMpaService is null");
        return;
    L23:
        return;
    L5:
        monitor-enter(CronetMpaServiceImpl.class);
    L15:
        th = move-exception;
        throw th;
    L7:
        if (this.mOuterAccAddressCallback == null) goto L12;
        if (r5 == null) goto L10;
        r5.onFinish(false, "setAccAddress is running");     // Catch: Throwable -> L15
    L10:
        monitor-exit(CronetMpaServiceImpl.class);     // Catch: Throwable -> L15
        return;
    L12:
        this.mOuterAccAddressCallback = r5;     // Catch: Throwable -> L15
        monitor-exit(CronetMpaServiceImpl.class);     // Catch: Throwable -> L15
        this.mTTNetMpaService.setAccAddress(r4, this.mCronetAccAddressCallback);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.mpa.IMpaService
    public void start() {
        TTMpaService r0 = this.mTTNetMpaService;
        if (r0 == null) goto L6;
        r0.start();
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.mpa.IMpaService
    public void stop() {
        TTMpaService r0 = this.mTTNetMpaService;
        if (r0 == null) goto L6;
        r0.stop();
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.mpa.IMpaService
    public void command(String r1, String r2) {
        TTMpaService r0 = this.mTTNetMpaService;
        if (r0 == null) goto L6;
        r0.command(r1, r2);
        return;
    }
}
