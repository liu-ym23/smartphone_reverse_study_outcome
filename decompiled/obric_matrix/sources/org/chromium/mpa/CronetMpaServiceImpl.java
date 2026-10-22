package org.chromium.mpa;

import com.bytedance.common.utility.reflect.Reflect;
import com.ttnet.org.chromium.net.CronetEngine;
import com.ttnet.org.chromium.net.TTMpaService;
import java.util.List;
import org.chromium.CronetClient;

/* JADX INFO: loaded from: classes2.dex */
public class CronetMpaServiceImpl {
    private static final String PRE_CNIT_KETNEL_FUNC = "preInitCronetKernel";
    private static final String TTNET_INIT_CLASS = "com.bytedance.ttnet.TTNetInit";
    private TTMpaService.ICallback mCronetAccAddressCallback;
    private CronetEngine mCronetEngine;
    private TTMpaService.ICallback mCronetInitCallback;
    private com.bytedance.frameworks.baselib.network.http.cronet.f.a mOuterAccAddressCallback;
    private com.bytedance.frameworks.baselib.network.http.cronet.f.a mOuterInitCallback;
    private TTMpaService mTTNetMpaService;

    class a implements TTMpaService.ICallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ CronetMpaServiceImpl f22673a;

        a(CronetMpaServiceImpl r1) {
            this.f22673a = r1;
        }

        @Override // com.ttnet.org.chromium.net.TTMpaService.ICallback
        public void onFinish(boolean r2, String r3) {
            if (CronetMpaServiceImpl.access$000(this.f22673a) == null) goto L6;
            CronetMpaServiceImpl.access$000(this.f22673a).onFinish(r2, r3);
            return;
        }
    }

    class b implements TTMpaService.ICallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ CronetMpaServiceImpl f22674a;

        b(CronetMpaServiceImpl r1) {
            this.f22674a = r1;
        }

        @Override // com.ttnet.org.chromium.net.TTMpaService.ICallback
        public void onFinish(boolean r3, String r4) {
            monitor-enter(CronetMpaServiceImpl.class);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (CronetMpaServiceImpl.access$100(this.f22674a) == null) goto L7;
            CronetMpaServiceImpl.access$100(this.f22674a).onFinish(r3, r4);     // Catch: Throwable -> L9
            CronetMpaServiceImpl.access$102(this.f22674a, null);     // Catch: Throwable -> L9
        L7:
            monitor-exit(CronetMpaServiceImpl.class);     // Catch: Throwable -> L9
        }
    }

    public CronetMpaServiceImpl() {
        this.mCronetInitCallback = new a(this);
        this.mCronetAccAddressCallback = new b(this);
    }

    static /* synthetic */ com.bytedance.frameworks.baselib.network.http.cronet.f.a access$000(CronetMpaServiceImpl r0) {
        return r0.mOuterInitCallback;
    }

    static /* synthetic */ com.bytedance.frameworks.baselib.network.http.cronet.f.a access$100(CronetMpaServiceImpl r0) {
        return r0.mOuterAccAddressCallback;
    }

    static /* synthetic */ com.bytedance.frameworks.baselib.network.http.cronet.f.a access$102(CronetMpaServiceImpl r0, com.bytedance.frameworks.baselib.network.http.cronet.f.a r1) {
        r0.mOuterAccAddressCallback = r1;
        return r1;
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

    public void command(String r1, String r2) {
        TTMpaService r0 = this.mTTNetMpaService;
        if (r0 == null) goto L6;
        r0.command(r1, r2);
        return;
    }

    public void init(com.bytedance.frameworks.baselib.network.http.cronet.f.a r2) {
        if (createMpaService() == true) goto L6;
        r2.onFinish(false, "Create MpaService Failed");
        return;
    L6:
        this.mOuterInitCallback = r2;
        this.mTTNetMpaService.init(this.mCronetInitCallback);
    }

    public void setAccAddress(List<String> r4, com.bytedance.frameworks.baselib.network.http.cronet.f.a r5) {
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

    public void start() {
        TTMpaService r0 = this.mTTNetMpaService;
        if (r0 == null) goto L6;
        r0.start();
        return;
    }

    public void stop() {
        TTMpaService r0 = this.mTTNetMpaService;
        if (r0 == null) goto L6;
        r0.stop();
        return;
    }
}
