package com.obric.matrix.opush.d.i;

import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.mpaas.app.AppInfo;
import com.obric.matrix.common_api.IPrivacySdkService;
import h.a.b1;
import h.a.h;
import h.a.m0;
import h.a.n0;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.k0.d;
import kotlin.k0.j.a.f;
import kotlin.k0.j.a.l;
import kotlin.n0.c.p;
import kotlin.n0.d.o;
import kotlin.v;
import kotlin.w;
import org.json.JSONObject;
import p000j.e0;
import p000j.y;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 &2\u00020\u0001:\u0001&B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\u0005H\u0002J<\u0010\u000b\u001a\u00020\f2\"\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000f0\u000ej\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000f`\u00102\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u000fH\u0002J8\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0005H\u0016J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0018\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\"\u0010\u001f\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J9\u0010!\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u00052\b\u0010#\u001a\u0004\u0018\u00010\u00182\u0006\u0010$\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0002\u0010%¨\u0006'"}, d2 = {"Lcom/obric/matrix/opush/base/request/PushRequestService;", "Lcom/obric/matrix/opush/base/request/IPushRequestService;", "()V", "getHeader", "", "", "getHost", "getRegisterAppTokenUrl", "getReportEventUrl", "getUnregisterAppTokenUrl", "getUpdateDeviceUrl", "putParams", "", "params", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "key", "value", "registerAppToken", "pkgName", "appId", "appKey", "userId", "", "requestCallback", "Lcom/obric/matrix/opush/base/network/IRequestCallback;", "forceUpdateToken", "reportEvent", "events", "Lorg/json/JSONArray;", "unregisterAppToken", "token", "updateDeviceInfo", "sdkVersionName", "sdkVersionCode", "updateType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ILcom/obric/matrix/opush/base/network/IRequestCallback;)V", "Companion", "o_push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class b implements com.obric.matrix.opush.d.i.a {

    @f(c = "com.obric.matrix.opush.base.request.PushRequestService$registerAppToken$2", f = "PushRequestService.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class a extends l implements p<m0, d<? super f0>, Object> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f9394f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ b f9395g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f9396h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ JSONObject f9397i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ com.obric.matrix.opush.base.network.b f9398j;

        a(b r1, String r2, JSONObject r3, com.obric.matrix.opush.base.network.b r4, d<? super a> r5) {
            this.f9395g = r1;
            this.f9396h = r2;
            this.f9397i = r3;
            this.f9398j = r4;
            super(2, r5);
        }

        @Override // kotlin.k0.j.a.a
        public final d<f0> create(Object r7, d<?> r8) {
            return new a(this.f9395g, this.f9396h, this.f9397i, this.f9398j, r8);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(m0 r1, d<? super f0> r2) {
            return ((a) create(r1, r2)).invokeSuspend(f0.f18324a);
        }

        @Override // kotlin.n0.c.p
        public /* bridge */ /* synthetic */ Object invoke(m0 r1, d<? super f0> r2) {
            return invoke2(r1, r2);
        }

        @Override // kotlin.k0.j.a.a
        public final Object invokeSuspend(Object r5) {
            kotlin.k0.i.b.c();
            if (this.f9394f != 0) goto L7;
            w.b(r5);
            Map<String, String> r6 = b.d(this.f9395g);
            com.obric.matrix.opush.base.network.a r0 = com.obric.matrix.opush.d.b.f9251a.p();
            String r1 = this.f9396h;
            e0 r2 = e0.c(y.d("application/json"), this.f9397i.toString());
            o.e(r2, "create(MediaType.parse(\"…json\"),params.toString())");
            r0.a(r1, r2, r6, this.f9398j);
            return f0.f18324a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.obric.matrix.opush.d.i.b$b, reason: collision with other inner class name */
    @f(c = "com.obric.matrix.opush.base.request.PushRequestService$unregisterAppToken$1", f = "PushRequestService.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class C0253b extends l implements p<m0, d<? super f0>, Object> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f9399f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ b f9400g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f9401h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ JSONObject f9402i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ com.obric.matrix.opush.base.network.b f9403j;

        C0253b(b r1, String r2, JSONObject r3, com.obric.matrix.opush.base.network.b r4, d<? super C0253b> r5) {
            this.f9400g = r1;
            this.f9401h = r2;
            this.f9402i = r3;
            this.f9403j = r4;
            super(2, r5);
        }

        @Override // kotlin.k0.j.a.a
        public final d<f0> create(Object r7, d<?> r8) {
            return new C0253b(this.f9400g, this.f9401h, this.f9402i, this.f9403j, r8);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(m0 r1, d<? super f0> r2) {
            return ((C0253b) create(r1, r2)).invokeSuspend(f0.f18324a);
        }

        @Override // kotlin.n0.c.p
        public /* bridge */ /* synthetic */ Object invoke(m0 r1, d<? super f0> r2) {
            return invoke2(r1, r2);
        }

        @Override // kotlin.k0.j.a.a
        public final Object invokeSuspend(Object r5) {
            kotlin.k0.i.b.c();
            if (this.f9399f != 0) goto L7;
            w.b(r5);
            Map<String, String> r6 = b.d(this.f9400g);
            com.obric.matrix.opush.base.network.a r0 = com.obric.matrix.opush.d.b.f9251a.p();
            String r1 = this.f9401h;
            e0 r2 = e0.c(y.d("application/json"), this.f9402i.toString());
            o.e(r2, "create(MediaType.parse(\"…json\"),params.toString())");
            r0.a(r1, r2, r6, this.f9403j);
            return f0.f18324a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @f(c = "com.obric.matrix.opush.base.request.PushRequestService$updateDeviceInfo$1", f = "PushRequestService.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class c extends l implements p<m0, d<? super f0>, Object> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f9404f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ b f9405g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ com.obric.matrix.opush.base.network.b f9406h;

        c(b r1, com.obric.matrix.opush.base.network.b r2, d<? super c> r3) {
            this.f9405g = r1;
            this.f9406h = r2;
            super(2, r3);
        }

        @Override // kotlin.k0.j.a.a
        public final d<f0> create(Object r2, d<?> r3) {
            return new c(this.f9405g, this.f9406h, r3);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(m0 r1, d<? super f0> r2) {
            return ((c) create(r1, r2)).invokeSuspend(f0.f18324a);
        }

        @Override // kotlin.n0.c.p
        public /* bridge */ /* synthetic */ Object invoke(m0 r1, d<? super f0> r2) {
            return invoke2(r1, r2);
        }

        @Override // kotlin.k0.j.a.a
        public final Object invokeSuspend(Object r7) {
            kotlin.k0.i.b.c();
            if (this.f9404f != 0) goto L7;
            w.b(r7);
            Map<String, String> r8 = b.d(this.f9405g);
            JSONObject r0 = new JSONObject();
            r0.put("Brand", Build.BRAND);
            r0.put("DeviceModel", Build.MODEL);
            com.obric.matrix.opush.d.b r1 = com.obric.matrix.opush.d.b.f9251a;
            r0.put("DeviceID", r1.b().getDeviceId());
            r0.put("OSName", LocationInfoConst.SYSTEM);
            com.obric.matrix.opush.g.d r2 = com.obric.matrix.opush.g.d.f9428a;
            r0.put("OSVersion", String.valueOf(r2.c()));
            r0.put("RomVersion", r2.d());
            r0.put("BuildType", "");
            r0.put("ClientVersion", AppInfo.getInstatnce().getVersionCode());
            r0.put("LastBootTime", System.currentTimeMillis() - SystemClock.elapsedRealtime());
            r0.put("AppCount", r1.u().e());
            com.obric.matrix.opush.base.network.a r3 = r1.p();
            String r4 = b.e(this.f9405g);
            e0 r5 = e0.c(y.d("application/json"), r0.toString());
            o.e(r5, "create(MediaType.parse(\"…json\"),params.toString())");
            r3.a(r4, r5, r8, this.f9406h);
            return f0.f18324a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
    }

    public b() {
    }

    public static final /* synthetic */ Map d(b r0) {
        return r0.f();
    }

    public static final /* synthetic */ String e(b r0) {
        return r0.j();
    }

    private final Map<String, String> f() {
        v.a r4 = v.f21457g;     // Catch: Throwable -> L4
        JSONObject r5 = new JSONObject();     // Catch: Throwable -> L4
        r5.put("did", com.obric.matrix.opush.d.b.f9251a.b().getDeviceId());     // Catch: Throwable -> L4
        Object r6 = r5.toString();     // Catch: Throwable -> L4
        v.b(r6);     // Catch: Throwable -> L4
    L6:
        String r1 = "";
        if (v.f(r6) == false) goto L9;
        r6 = "";
    L9:
        o.e(r6, "runCatching {\n          …       }.getOrDefault(\"\")");
        LinkedHashMap r0 = new LinkedHashMap();
        IPrivacySdkService r2 = (IPrivacySdkService) com.bytedance.news.common.service.manager.d.a(IPrivacySdkService.class);
        String r7 = r2.getIDAttestation((String) r6, "ocean_push");
        if (r7 == null) goto L13;
        r1 = r7;
    L13:
        r0.put("x-att-certchain", r1);
        return r0;
    L4:
        th = move-exception;
        v.a r3 = v.f21457g;
        r6 = w.a(th);
        v.b(r6);
        goto L6
    }

    private final String g() {
        if (com.obric.matrix.base.env.d.f8838a.e() == false) goto L5;
        return "http://platform-api-boe.bytedance.net";
    L5:
        return "https://platform-api.oceancloudapi.com";
    }

    private final String h() {
        return g() + "/cloud/push/token/register";
    }

    private final String i() {
        return g() + "/cloud/push/token/unregister";
    }

    private final String j() {
        return g() + "/cloud/push/device/sync";
    }

    @Override // com.obric.matrix.opush.d.i.a
    public void a(String r11, String r12, com.obric.matrix.opush.base.network.b r13) {
        o.f(r11, "pkgName");
        o.f(r13, "requestCallback");
        com.obric.matrix.r.c.c.b("PushRequestService", "unregisterAppToken, pkgName=" + r11);
        if (r12 != null) goto L6;
        r12 = com.obric.matrix.opush.d.b.f9251a.u().f(r11);
    L6:
        if (TextUtils.isEmpty(r12) == false) goto L8;
        return;
    L8:
        JSONObject r3 = new JSONObject();
        r3.put("PushToken", r12);
        h.b(n0.b(), b1.b(), null, new C0253b(this, i(), r3, r13, null), 2, null);
    }

    @Override // com.obric.matrix.opush.d.i.a
    public void b(String r7, String r8, String r9, int r10, com.obric.matrix.opush.base.network.b r11, String r12) {
        o.f(r7, "pkgName");
        o.f(r8, "appId");
        o.f(r9, "appKey");
        o.f(r11, "requestCallback");
        o.f(r12, "forceUpdateToken");
        com.obric.matrix.r.c.c.b("PushRequestService", "registerAppToken, pkgName=" + r7 + ", appId=" + r8 + ",  forceUpdateToken=" + r12);
        JSONObject r3 = new JSONObject();
        r3.put("AppID", r8);
        r3.put("DeviceID", com.obric.matrix.opush.d.b.f9251a.b().getDeviceId());
        r3.put("OSUserID", r10);
        r3.put("PackageName", r7);
        r3.put("CertFingerprint", com.obric.matrix.opush.g.b.f9424a.c(com.bytedance.mpaas.app.a.f5245g, r7));
        JSONObject r13 = new JSONObject();
        com.obric.matrix.opush.g.d r14 = com.obric.matrix.opush.g.d.f9428a;
        r13.put("Model", r14.a());
        r13.put("OSName", LocationInfoConst.SYSTEM);
        r13.put("OSVersion", String.valueOf(r14.c()));
        r13.put("RomVersion", r14.d());
        r13.put("PushClientVersion", AppInfo.getInstatnce().getVersionCode());
        f0 r15 = f0.f18324a;
        r3.put("DeviceInfo", r13);
        h.b(n0.b(), b1.b(), null, new a(this, h(), r3, r11, null), 2, null);
    }

    @Override // com.obric.matrix.opush.d.i.a
    public void c(String r7, String r8, Integer r9, int r10, com.obric.matrix.opush.base.network.b r11) {
        o.f(r7, "pkgName");
        o.f(r8, "sdkVersionName");
        com.obric.matrix.r.c.c.b("PushRequestService", "updateDeviceInfo, pkgName=" + r7 + ", updateType=" + r10);
        h.b(n0.b(), b1.b(), null, new c(this, r11, null), 2, null);
    }
}
