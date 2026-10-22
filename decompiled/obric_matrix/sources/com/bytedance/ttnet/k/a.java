package com.bytedance.ttnet.k;

import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetDepend;
import com.bytedance.ttnet.TTMultiNetwork;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.clientkey.ClientKeyManager;
import com.ttnet.org.chromium.net.urlconnection.CronetHttpURLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements ICronetDepend, ICronetAppProvider {

    /* JADX INFO: renamed from: com.bytedance.ttnet.k.a$a, reason: collision with other inner class name */
    class C0200a extends com.bytedance.common.utility.m.c {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ int f6435k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ int f6436l;
        final /* synthetic */ a m;

        C0200a(a r1, String r2, int r3, int r4) {
            this.m = r1;
            this.f6435k = r3;
            this.f6436l = r4;
            super(r2);
        }

        @Override // com.bytedance.common.utility.m.c, java.lang.Runnable
        public void run() {
            this.m.onMultiNetworkStateChanged(this.f6435k, this.f6436l);
        }
    }

    class b extends com.bytedance.common.utility.m.c {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ int f6437k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ a f6438l;

        b(a r1, String r2, int r3) {
            this.f6438l = r1;
            this.f6437k = r3;
            super(r2);
        }

        @Override // com.bytedance.common.utility.m.c, java.lang.Runnable
        public void run() {
            this.f6438l.onNetworkQualityLevelChanged(this.f6437k);
        }
    }

    class c extends com.bytedance.common.utility.m.c {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ int f6439k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ int f6440l;
        final /* synthetic */ int m;
        final /* synthetic */ a n;

        c(a r1, String r2, int r3, int r4, int r5) {
            this.n = r1;
            this.f6439k = r3;
            this.f6440l = r4;
            this.m = r5;
            super(r2);
        }

        @Override // com.bytedance.common.utility.m.c, java.lang.Runnable
        public void run() {
            this.n.onNetworkQualityRttAndThroughputNotified(this.f6439k, this.f6440l, this.m);
        }
    }

    class d extends com.bytedance.common.utility.m.c {
        d(a r1, String r2) {
            super(r2);
        }

        @Override // com.bytedance.common.utility.m.c, java.lang.Runnable
        public void run() {
            TTNetInit.notifyColdStartFinish();
        }
    }

    class e extends com.bytedance.common.utility.m.c {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ String f6441k;

        e(a r1, String r2, String r3) {
            this.f6441k = r3;
            super(r2);
        }

        @Override // com.bytedance.common.utility.m.c, java.lang.Runnable
        public void run() {
            TTNetInit.onClientIPChanged(this.f6441k);
        }
    }

    class f extends com.bytedance.common.utility.m.c {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ List f6442k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ List f6443l;

        f(a r1, String r2, List r3, List r4) {
            this.f6442k = r3;
            this.f6443l = r4;
            super(r2);
        }

        @Override // com.bytedance.common.utility.m.c, java.lang.Runnable
        public void run() {
            TTNetInit.onPublicIPsChanged(this.f6442k, this.f6443l);
        }
    }

    class g extends com.bytedance.common.utility.m.c {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ String f6444k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ String f6445l;
        final /* synthetic */ String m;
        final /* synthetic */ String n;
        final /* synthetic */ String o;
        final /* synthetic */ String p;

        g(a r1, String r2, String r3, String r4, String r5, String r6, String r7, String r8) {
            this.f6444k = r3;
            this.f6445l = r4;
            this.m = r5;
            this.n = r6;
            this.o = r7;
            this.p = r8;
            super(r2);
        }

        @Override // com.bytedance.common.utility.m.c, java.lang.Runnable
        public void run() {
            com.bytedance.ttnet.k.b.a().c(this.f6444k, this.f6445l, this.m, this.n, this.o, this.p);
            d.b.h.a.a.h.r.b.n().r(this.f6444k, this.f6445l, this.m, this.n, this.o, this.p);
        }
    }

    class h extends com.bytedance.common.utility.m.c {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ boolean f6446k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ List f6447l;

        h(a r1, String r2, boolean r3, List r4) {
            this.f6446k = r3;
            this.f6447l = r4;
            super(r2);
        }

        @Override // com.bytedance.common.utility.m.c, java.lang.Runnable
        public void run() {
            com.bytedance.ttnet.k.c.a().c(this.f6446k, this.f6447l);
        }
    }

    class i extends com.bytedance.common.utility.m.c {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ ArrayList f6448k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ String f6449l;

        i(a r1, String r2, ArrayList r3, String r4) {
            this.f6448k = r3;
            this.f6449l = r4;
            super(r2);
        }

        @Override // com.bytedance.common.utility.m.c, java.lang.Runnable
        public void run() {
            com.bytedance.ttnet.j.b.a().b(this.f6448k, this.f6449l);
        }
    }

    class j extends com.bytedance.common.utility.m.c {
        j(a r1, String r2) {
            super(r2);
        }

        @Override // com.bytedance.common.utility.m.c, java.lang.Runnable
        public void run() {
            com.bytedance.ttnet.j.a.s(TTNetInit.getTTNetDepend().getContext()).D();
            com.bytedance.ttnet.d.d(true);
        }
    }

    class k extends com.bytedance.common.utility.m.c {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ String f6450k;

        k(a r1, String r2, String r3) {
            this.f6450k = r3;
            super(r2);
        }

        @Override // com.bytedance.common.utility.m.c, java.lang.Runnable
        public void run() {
            com.bytedance.ttnet.j.a.s(TTNetInit.getTTNetDepend().getContext()).F(this.f6450k);     // Catch: Throwable -> L4
            return;
        }
    }

    class l extends com.bytedance.common.utility.m.c {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ boolean f6451k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ boolean f6452l;
        final /* synthetic */ int m;

        l(a r1, boolean r2, boolean r3, int r4) {
            this.f6451k = r2;
            this.f6452l = r3;
            this.m = r4;
        }

        @Override // com.bytedance.common.utility.m.c, java.lang.Runnable
        public void run() {
            com.bytedance.ttnet.j.f.b(TTNetInit.getTTNetDepend().getContext()).c(this.f6451k, this.f6452l, this.m);     // Catch: Throwable -> L4
            return;
        }
    }

    class m extends com.bytedance.common.utility.m.c {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ String f6453k;

        m(a r1, String r2, String r3) {
            this.f6453k = r3;
            super(r2);
        }

        @Override // com.bytedance.common.utility.m.c, java.lang.Runnable
        public void run() {
            com.bytedance.ttnet.j.a.s(TTNetInit.getTTNetDepend().getContext()).E(this.f6453k);     // Catch: Throwable -> L4
            return;
        }
    }

    class n extends com.bytedance.common.utility.m.c {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ String f6454k;

        n(a r1, String r2, String r3) {
            this.f6454k = r3;
            super(r2);
        }

        @Override // com.bytedance.common.utility.m.c, java.lang.Runnable
        public void run() {
            boolean r0 = false;
            com.bytedance.ttnet.j.e.b r1 = null;
            if (com.bytedance.ttnet.j.e.a() == false) goto L8;
            r1 = new com.bytedance.ttnet.j.e.b(this.f6454k, new JSONObject(this.f6454k));     // Catch: Throwable -> L12
            com.bytedance.ttnet.j.c.g(r1);     // Catch: Throwable -> L12
            if (com.bytedance.ttnet.j.c.d() == false) goto L8;
            r0 = true;
        L8:
            if (r0 == false) goto L10;
            com.bytedance.ttnet.j.a.s(TTNetInit.getTTNetDepend().getContext()).w(this.f6454k, r1);     // Catch: Throwable -> L12
            ClientKeyManager.k().c(r1);     // Catch: Throwable -> L12
            return;
        L10:
            com.bytedance.ttnet.j.a r2 = com.bytedance.ttnet.j.a.s(TTNetInit.getTTNetDepend().getContext());     // Catch: Throwable -> L12
            String r3 = this.f6454k;     // Catch: Throwable -> L12
            r2.w(r3, r3);     // Catch: Throwable -> L12
            ClientKeyManager.k().c(this.f6454k);     // Catch: Throwable -> L12
            return;
        }
    }

    class o extends com.bytedance.common.utility.m.c {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ String f6455k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ String f6456l;
        final /* synthetic */ int m;
        final /* synthetic */ int n;
        final /* synthetic */ int o;
        final /* synthetic */ List p;
        final /* synthetic */ String q;

        o(a r1, String r2, String r3, String r4, int r5, int r6, int r7, List r8, String r9) {
            this.f6455k = r3;
            this.f6456l = r4;
            this.m = r5;
            this.n = r6;
            this.o = r7;
            this.p = r8;
            this.q = r9;
            super(r2);
        }

        @Override // com.bytedance.common.utility.m.c, java.lang.Runnable
        public void run() {
            com.bytedance.ttnet.n.a.c().a(this.f6455k, this.f6456l, this.m, this.n, this.o, this.p, this.q);
        }
    }

    class p extends com.bytedance.common.utility.m.c {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ String f6457k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ a f6458l;

        p(a r1, String r2, String r3) {
            this.f6458l = r1;
            this.f6457k = r3;
            super(r2);
        }

        @Override // com.bytedance.common.utility.m.c, java.lang.Runnable
        public void run() {
            this.f6458l.d(this.f6457k);     // Catch: Throwable -> L4
            return;
        }
    }

    class q extends com.bytedance.common.utility.m.c {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ int f6459k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ a f6460l;

        q(a r1, String r2, int r3) {
            this.f6460l = r1;
            this.f6459k = r3;
            super(r2);
        }

        @Override // com.bytedance.common.utility.m.c, java.lang.Runnable
        public void run() {
            this.f6460l.onEffectiveConnectionTypeChanged(this.f6459k);
            this.f6460l.a(this.f6459k);
        }
    }

    class r extends com.bytedance.common.utility.m.c {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ int f6461k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ int f6462l;
        final /* synthetic */ int m;
        final /* synthetic */ a n;

        r(a r1, String r2, int r3, int r4, int r5) {
            this.n = r1;
            this.f6461k = r3;
            this.f6462l = r4;
            this.m = r5;
            super(r2);
        }

        @Override // com.bytedance.common.utility.m.c, java.lang.Runnable
        public void run() {
            this.n.onRTTOrThroughputEstimatesComputed(this.f6461k, this.f6462l, this.m);
            this.n.c(this.f6461k, this.f6462l, this.m);
        }
    }

    class s extends com.bytedance.common.utility.m.c {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ int f6463k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ double f6464l;
        final /* synthetic */ double m;
        final /* synthetic */ double n;
        final /* synthetic */ double o;
        final /* synthetic */ a p;

        s(a r1, String r2, int r3, double r4, double r6, double r8, double r10) {
            this.p = r1;
            this.f6463k = r3;
            this.f6464l = r4;
            this.m = r6;
            this.n = r8;
            this.o = r10;
            super(r2);
        }

        @Override // com.bytedance.common.utility.m.c, java.lang.Runnable
        public void run() {
            this.p.onPacketLossComputed(this.f6463k, this.f6464l, this.m, this.n, this.o);
            this.p.b(this.f6463k, this.f6464l, this.m, this.n, this.o);
        }
    }

    protected a() {
    }

    public void a(int r1) {
    }

    public void b(int r1, double r2, double r4, double r6, double r8) {
    }

    public void c(int r1, int r2, int r3) {
    }

    public void d(String r1) {
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void doLoadLibrary(String r1) {
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getAbClient() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getAbFeature() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getAbFlag() {
        return "-1";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public List<String> getAbSdkVersion() {
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getAbVersion() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getAbi() {
        if (Build.VERSION.SDK_INT >= 21) goto L6;
        return Build.CPU_ABI;
    L6:
        return Build.SUPPORTED_ABIS[0];
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public com.bytedance.frameworks.baselib.network.http.cronet.b getAppInfoSubset() {
        com.bytedance.frameworks.baselib.network.http.cronet.b r0 = new com.bytedance.frameworks.baselib.network.http.cronet.b();
        List<String> r1 = getAbSdkVersion();
        String r4 = "";
        if (r1 == null) goto L13;
        Iterator<String> r2 = r1.iterator();
        int r5 = 0;
    L6:
        if (r2.hasNext() == false) goto L13;
        String r6 = r2.next();
        r5 = r5 + 1;
        if (r5 > 5) goto L13;
        if (TextUtils.isEmpty(r6) == true) goto L6;
        r4 = r4 + r6 + ",";
    L13:
        r0.f4684a = r4;
        String[] r3 = TTNetInit.getTTNetDepend().f();
        if (r3 != null) goto L16;
    L24:
        Map<String, String> r7 = TTNetInit.getTTNetDepend().j();
        String r8 = r7.get(TTNetInit.DOMAIN_HTTPDNS_KEY);
        if (r8 != null) goto L27;
    L29:
        String r9 = r7.get(TTNetInit.DOMAIN_BOE_KEY);
        if (r9 != null) goto L32;
    L34:
        String r10 = r7.get(TTNetInit.DOMAIN_BOE_HTTPS_KEY);
        if (r10 != null) goto L37;
    L39:
        r0.f4691h = getAppInitialRegionInfo();
        return r0;
    L37:
        if (TextUtils.isEmpty(r10) == true) goto L39;
        r0.f4690g = r10;
        goto L39
    L32:
        if (TextUtils.isEmpty(r9) == true) goto L34;
        r0.f4689f = r9;
        goto L34
    L27:
        if (TextUtils.isEmpty(r8) == true) goto L29;
        r0.f4688e = r8;
        goto L29
    L16:
        if (r3.length <= 0) goto L19;
        r0.f4685b = r3[0];
    L19:
        if (r3.length <= 1) goto L22;
        r0.f4686c = r3[1];
    L22:
        if (r3.length <= 2) goto L24;
        r0.f4687d = r3[2];
        goto L24
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getAppInitialRegionInfo() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public long getAppStartTime() {
        return -1;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getCityName() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public Map<String[], Pair<byte[], byte[]>> getClientOpaqueData() {
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getCronetSoPath() {
        return com.bytedance.ttnet.j.a.s(TTNetInit.getTTNetDepend().getContext()).r();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getDPI() {
        int r0 = com.bytedance.common.utility.l.b(TTNetInit.getTTNetDepend().getContext());
        if (r0 > 0) goto L5;
        return "";
    L5:
        return String.valueOf(r0);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getDeviceBrand() {
        return Build.BRAND;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getDeviceModel() {
        return Build.MODEL;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getDevicePlatform() {
        return "android";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getDeviceType() {
        return Build.MODEL;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public Map<String, String> getGetDomainDependHostMap() {
        LinkedHashMap r5 = new LinkedHashMap();
        String[] r0 = TTNetInit.getTTNetDepend().f();
        boolean r1 = false;
        if (r0 != null) goto L5;
    L13:
        Map<String, String> r2 = TTNetInit.getTTNetDepend().j();
        if (TextUtils.isEmpty(r2.get(TTNetInit.DOMAIN_HTTPDNS_KEY)) == false) goto L16;
    L19:
        r1 = true;
    L20:
        if (r1 == true) goto L24;
        r5.putAll(r2);
        return r5;
    L24:
        throw new IllegalArgumentException("You must set HttpDns, NetLog and BOE service domain, please refer to TTNet access documents.");
    L16:
        if (TextUtils.isEmpty(r2.get(TTNetInit.DOMAIN_BOE_KEY)) == false) goto L20;
        if (TextUtils.isEmpty(r2.get(TTNetInit.DOMAIN_BOE_HTTPS_KEY)) == false) goto L20;
    L5:
        if (r0.length <= 0) goto L8;
        r5.put("first", r0[0]);
    L8:
        if (r0.length <= 1) goto L11;
        r5.put("second", r0[1]);
    L11:
        if (r0.length <= 2) goto L13;
        r5.put("third", r0[2]);
        goto L13
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getHttpDnsRequestFlags() {
        return BDLocationException.ERROR_TIMEOUT;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getIId() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getIsDropFirstTnc() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getLanguage() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public boolean getLazyInitCronetIPC() {
        return false;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getManifestVersionCode() {
        return "-1";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getNetAccessType() {
        return com.bytedance.common.utility.i.g(TTNetInit.getTTNetDepend().getContext());
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getNetworkOperator() {
        if (TTNetInit.getSystemApiSandbox() != null) goto L7;
        return "";
    L7:
        return TTNetInit.getSystemApiSandbox().getNetworkOperator();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getOSApi() {
        return String.valueOf(Build.VERSION.SDK_INT);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getOSVersion() {
        String r2 = Build.VERSION.RELEASE;     // Catch: Exception -> L8
        if (r2 != null) goto L5;
        return r2;
    L5:
        if (r2.length() <= 10) goto L13;
        return r2.substring(0, 10);
    L13:
        return r2;
    L8:
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public ArrayList<byte[]> getOpaqueData() {
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getOpenUdid() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public boolean getOptInit() {
        return false;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public boolean getOptNqeDefault() {
        return false;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public boolean getOptNqePersist() {
        return false;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final int getProcessFlag() {
        return d.b.h.a.a.h.s.h.f();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public Map<String, Pair<Integer, Integer>> getQuicHint() {
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getResolution() {
        String r1 = com.bytedance.common.utility.l.d(TTNetInit.getTTNetDepend().getContext());
        if (com.bytedance.common.utility.k.c(r1) == true) goto L5;
        return r1;
    L5:
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getRticket() {
        return String.valueOf(System.currentTimeMillis());
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getSdkAppId() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getSdkVersion() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getSimOperator() {
        if (TTNetInit.getSystemApiSandbox() != null) goto L7;
        return "";
    L7:
        return TTNetInit.getSystemApiSandbox().getSimOperator();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetDepend
    public String getSsCookieKey() {
        return CronetHttpURLConnection.SS_COOKIE;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getSsmix() {
        return "a";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getStoreIdcRuleJSON() {
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getTNCRequestFlags() {
        return BDLocationException.ERROR_TIMEOUT;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public Map<String, String> getTNCRequestHeader() {
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public Map<String, String> getTNCRequestQuery() {
        Object r1 = TTNetInit.getTTNetDepend();
        if (r1 != null) goto L5;
        return null;
    L5:
        if ((r1 instanceof com.bytedance.ttnet.b) == true) goto L7;
        return null;
    L7:
        return ((com.bytedance.ttnet.b) r1).c();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getUUID() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getUpdateVersionCode() {
        return "-1";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public int getWifiFrequency() {
        if (TTNetInit.getSystemApiSandbox() != null) goto L7;
        return 0;
    L7:
        return TTNetInit.getSystemApiSandbox().getWifiFrequency();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public int getWifiRssi() {
        if (TTNetInit.getSystemApiSandbox() != null) goto L7;
        return 0;
    L7:
        return TTNetInit.getSystemApiSandbox().getWifiRssi();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void handleApiResult(boolean r11, String r12, String r13, String r14, long r15, long r17, long r19, long r21, long r23, long r25, long r27, long r29, long r31, long r33, boolean r35, long r36, long r38, String r40, String r41, String r42, Exception r43) {
        Logger.debug();
        d.b.h.a.a.h.b r8 = d.b.h.a.a.h.b.a();
        r8.Z = r13;
        r8.f13357d = r14;
        r8.f13359f = r15;
        r8.f13360g = r15;
        r8.f13361h = r17;
        r8.f13362i = r19;
        r8.f13365l = r21;
        r8.m = r23;
        r8.o = r25;
        r8.p = r27;
        r8.q = r29;
        r8.r = r31;
        r8.t = r33;
        r8.u = r35;
        r8.v = r36;
        r8.w = r23 - r17;
        r8.y = r38;
        r8.E = r40;
        r8.H = r41;
        r8.I = r42;
        r8.B = 0;
        if (r11 == false) goto L5;
        d.b.h.a.a.h.g.t(r12, r8);
        d.b.h.a.a.h.g.A(r12, r8);
        return;
    L5:
        d.b.h.a.a.h.g.s(r12, r43, r8);
        d.b.h.a.a.h.g.y(r12, r8, r43);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public boolean handleApiSample(String r1, String r2) {
        Logger.debug();
        return d.b.h.a.a.h.g.u(r1, r2);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public boolean isBOEProxyEnabled() {
        return false;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public boolean isEnableBrotli() {
        return false;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public boolean isEnableHttp2() {
        return true;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public boolean isEnableQuic() {
        return false;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetDepend
    public void loggerD(String r1, String r2) {
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public boolean needCustomLoadLibrary() {
        return false;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public Map<String, String> onCallToAddSecurityFactor(String r4, Map<String, String> r5) {
        HashMap r3 = new HashMap();
        Iterator<Map.Entry<String, String>> r6 = r5.entrySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L7;
        Map.Entry<String, String> r0 = r6.next();
        ArrayList r1 = new ArrayList();
        r1.add(r0.getValue());
        r3.put(r0.getKey(), r1);
        goto L4
    L7:
        return d.b.h.a.a.h.g.b0(r4, r3);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final void onClientIPChanged(String r3) {
        Logger.debug();
        new e(this, "NetWork-Event", r3).b();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final void onColdStartFinish() {
        Logger.debug();
        new d(this, "NetWork-Event").b();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void onCronetBootSucceed() {
        Logger.debug();
        new j(this, "NetWork-Event").b();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void onDropReasonChanged(boolean r3, List<Integer> r4) {
        Logger.debug();
        new h(this, "NetWork-Event", r3, r4).b();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void onEffectiveConnectionTypeChanged(int r1) {
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final void onEffectiveConnectionTypeChangedOnIOThread(int r3) {
        Logger.debug();
        new q(this, "NetWork-Event", r3).b();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final void onMultiNetStateChanged(int r7, int r8) {
        Logger.debug();
        Reflect r6 = Reflect.on(TTMultiNetwork.class);     // Catch: Throwable -> L5
        Class<?> r3 = Integer.TYPE;     // Catch: Throwable -> L5
        r6.call("notifyMultiNetState", new Class[]{r3, r3}, new Object[]{Integer.valueOf(r7), Integer.valueOf(r8)});     // Catch: Throwable -> L5
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void onMultiNetworkStateChanged(int r1, int r2) {
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void onNetworkQualityLevelChanged(int r1) {
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final void onNetworkQualityLevelChangedOnIOThread(int r3) {
        Logger.debug();
        new b(this, "NetWork-Event", r3).b();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void onNetworkQualityRttAndThroughputNotified(int r1, int r2, int r3) {
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void onNetworkQualityRttAndThroughputNotifiedOnIOThread(int r8, int r9, int r10) {
        Logger.debug();
        new c(this, "NetWork-Event", r8, r9, r10).b();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void onPacketLossComputed(int r1, double r2, double r4, double r6, double r8) {
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final void onPacketLossComputedOnIOThread(int r14, double r15, double r17, double r19, double r21) {
        Logger.debug();
        new s(this, "NetWork-Event", r14, r15, r17, r19, r21).b();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void onPublicIPsChanged(List<String> r3, List<String> r4) {
        Logger.debug();
        new f(this, "NetWork-Event", r3, r4).b();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void onRTTOrThroughputEstimatesComputed(int r1, int r2, int r3) {
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final void onRTTOrThroughputEstimatesComputedOnIOThread(int r8, int r9, int r10) {
        Logger.debug();
        new r(this, "NetWork-Event", r8, r9, r10).b();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void onServerConfigABTestChanged(String r3) {
        new m(this, "NetWork-Event", r3).b();     // Catch: Throwable -> L4
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void onServerConfigEtagChanged(String r3) {
        new k(this, "NetWork-Event", r3).b();     // Catch: Throwable -> L4
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void onServerConfigUpdated(String r3) {
        Logger.debug();     // Catch: Throwable -> L4
        new n(this, "NetWork-Event", r3).b();     // Catch: Throwable -> L4
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final void onStoreIdcChanged(String r11, String r12, String r13, String r14, String r15, String r16) {
        Logger.debug();
        new g(this, "NetWork-Event", r11, r12, r13, r14, r15, r16).b();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final void onTNCUpdateFailed(ArrayList<String> r3, String r4) {
        Logger.debug();
        new i(this, "NetWork-Event", r3, r4).b();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final void onTTDnsResolveResult(String r12, String r13, int r14, int r15, int r16, List<String> r17, String r18) {
        Logger.debug();
        new o(this, "NetWork-Event", r12, r13, r14, r15, r16, r17, r18).b();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final void onTTNetDetectInfoChanged(String r3) {
        Logger.debug();
        new p(this, "NetWork-Event", r3).b();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void onTncRequestSucceeded(boolean r2, boolean r3, int r4) {
        Logger.debug();     // Catch: Throwable -> L4
        new l(this, r2, r3, r4).b();     // Catch: Throwable -> L4
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final void onUserSpecifiedNetworkEnabled(boolean r6) {
        Logger.debug();
        Reflect.on(TTMultiNetwork.class).call("notifyUserSpecifiedNetworkEnabled", new Class[]{Boolean.TYPE}, new Object[]{Boolean.valueOf(r6)});     // Catch: Throwable -> L5
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public final void onWiFiToCellStateChangedOnIOThread(int r3, int r4) {
        Logger.debug();
        new C0200a(this, "NetWork-Event", r3, r4).b();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetDepend
    public void setAdapter(ICronetDepend r1) {
    }
}
