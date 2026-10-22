package com.obric.matrix.push.m.l;

import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.mpaas.app.AppInfo;
import com.obric.matrix.base.env.d;
import com.obric.matrix.push.base.network.c;
import com.obric.matrix.push.r.e;
import com.obric.matrix.push.r.j;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import org.json.JSONArray;
import os.teatracker.IBdInstall;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u0000  2\u00020\u0001:\u0001 B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J<\u0010\b\u001a\u00020\t2\"\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f0\u000bj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f`\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\fH\u0002J0\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0004H\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0018\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J9\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0002\u0010\u001f¨\u0006!"}, d2 = {"Lcom/obric/matrix/push/base/request/PushRequestService;", "Lcom/obric/matrix/push/base/request/IPushRequestService;", "()V", "getHost", "", "getRegisterAppTokenUrl", "getReportEventUrl", "getUpdateDeviceUrl", "putParams", "", "params", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "key", "value", "registerAppToken", "pkgName", "appId", "appKey", "requestCallback", "Lcom/obric/matrix/push/base/network/IRequestCallback;", "forceUpdateToken", "reportEvent", "events", "Lorg/json/JSONArray;", "updateDeviceInfo", "sdkVersionName", "sdkVersionCode", "", "updateType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ILcom/obric/matrix/push/base/network/IRequestCallback;)V", "Companion", "push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class b implements com.obric.matrix.push.m.l.a {

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class a extends q implements kotlin.n0.c.a<f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f9735f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ HashMap<String, Object> f9736g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ c f9737h;

        a(String r1, HashMap<String, Object> r2, c r3) {
            this.f9735f = r1;
            this.f9736g = r2;
            this.f9737h = r3;
            super(0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ f0 invoke() {
            invoke2();
            return f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            com.obric.matrix.push.m.b.f9633a.u().c(this.f9735f, this.f9736g, this.f9737h);
        }
    }

    /* JADX INFO: renamed from: com.obric.matrix.push.m.l.b$b, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class C0274b extends q implements kotlin.n0.c.a<f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ b f9738f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ HashMap<String, Object> f9739g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ c f9740h;

        C0274b(b r1, HashMap<String, Object> r2, c r3) {
            this.f9738f = r1;
            this.f9739g = r2;
            this.f9740h = r3;
            super(0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ f0 invoke() {
            invoke2();
            return f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            com.obric.matrix.push.m.b.f9633a.u().c(b.d(this.f9738f), this.f9739g, this.f9740h);
        }
    }

    static {
    }

    public b() {
    }

    public static final /* synthetic */ String d(b r0) {
        return r0.h();
    }

    private final String e() {
        if (d.f8838a.e() == false) goto L5;
        return "http://cloudpush-boe.bytedance.net";
    L5:
        return "https://os.obriccloud.com";
    }

    private final String f() {
        return e() + "/xrcloudpush/get_token";
    }

    private final String g() {
        return e() + "/xrcloudpush/report_event";
    }

    private final String h() {
        return e() + "/xrcloudpush/update_device";
    }

    private final void i(HashMap<String, Object> r1, String r2, Object r3) {
        if (TextUtils.isEmpty(r2) == false) goto L6;
        return;
    L6:
        if ((r3 instanceof String) == true) goto L8;
    L10:
        r1.put(r2, r3);
        return;
    L8:
        if (TextUtils.isEmpty((CharSequence) r3) == false) goto L10;
    }

    @Override // com.obric.matrix.push.m.l.a
    public void a(String r6, String r7, String r8, c r9, String r10) {
        o.f(r6, "pkgName");
        o.f(r7, "appId");
        o.f(r8, "appKey");
        o.f(r9, "requestCallback");
        o.f(r10, "forceUpdateToken");
        com.obric.matrix.r.c.c.b("PushRequestService", "registerAppToken, pkgName=" + r6 + ", appId=" + r7 + ",  forceUpdateToken=" + r10);
        HashMap<String, Object> r0 = new HashMap();
        com.obric.matrix.push.p.b r1 = com.obric.matrix.push.p.b.h0;
        String r2 = r1.e();
        e r3 = e.f9794a;
        i(r0, r2, r3.a());
        i(r0, r1.R(), r3.n());
        String r4 = r1.h();
        com.obric.matrix.push.m.b r5 = com.obric.matrix.push.m.b.f9633a;
        i(r0, r4, r5.b().getDeviceId());
        i(r0, "package_name", r6);
        i(r0, IBdInstall.PARAM_APP_ID, r7);
        i(r0, WsConstants.KEY_APP_KEY, r8);
        i(r0, r1.n(), r10);
        String r11 = f();
        if (o.a(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        j.f9798a.j(new a(r11, r0, r9));
        return;
    L5:
        r5.u().c(r11, r0, r9);
    }

    @Override // com.obric.matrix.push.m.l.a
    public String b(JSONArray r7) {
        o.f(r7, "events");
        com.obric.matrix.r.c.c.b("PushRequestService", "reportEvent, events=" + r7);
        HashMap<String, Object> r0 = new HashMap();
        com.obric.matrix.push.p.b r1 = com.obric.matrix.push.p.b.h0;
        String r2 = r1.e();
        e r3 = e.f9794a;
        i(r0, r2, r3.a());
        String r4 = r1.h();
        com.obric.matrix.push.m.b r5 = com.obric.matrix.push.m.b.f9633a;
        i(r0, r4, r5.b().getDeviceId());
        i(r0, r1.R(), r3.n());
        String r6 = r1.g();
        String r8 = r7.toString();
        o.e(r8, "events.toString()");
        i(r0, r6, r8);
        return r5.u().b(g(), r0);
    }

    @Override // com.obric.matrix.push.m.l.a
    public void c(String r11, String r12, Integer r13, int r14, c r15) {
        o.f(r11, "pkgName");
        o.f(r12, "sdkVersionName");
        com.obric.matrix.r.c.c.b("PushRequestService", "updateDeviceInfo, pkgName=" + r11 + ", updateType=" + r14);
        HashMap<String, Object> r0 = new HashMap();
        com.obric.matrix.push.p.b r4 = com.obric.matrix.push.p.b.h0;
        String r5 = r4.e();
        e r6 = e.f9794a;
        i(r0, r5, r6.a());
        i(r0, r4.R(), r6.n());
        String r7 = r4.h();
        com.obric.matrix.push.m.b r8 = com.obric.matrix.push.m.b.f9633a;
        i(r0, r7, r8.b().getDeviceId());
        i(r0, "package_name", r11);
        String r9 = AppInfo.getInstatnce().getVersionName();
        o.e(r9, "getInstatnce().versionName");
        i(r0, WsConstants.KEY_APP_VERSION, r9);
        i(r0, r4.E(), r6.m());
        i(r0, r4.u(), r6.g());
        i(r0, r4.t(), String.valueOf(r6.f()));
        i(r0, r4.f(), r6.b());
        i(r0, r4.B(), r6.l());
        i(r0, r4.q(), r6.c());
        i(r0, r4.T(), r6.q());
        i(r0, r4.U(), String.valueOf(r6.r()));
        i(r0, r4.A(), r12);
        i(r0, r4.s(), r6.d());
        i(r0, r4.w(), r6.i());
        i(r0, r4.V(), Long.valueOf(System.currentTimeMillis()));
        i(r0, r4.v(), r6.h());
        if (r13 == null) goto L5;
        i(r0, r4.z(), Integer.valueOf(r13.intValue()));
    L5:
        i(r0, r4.W(), Integer.valueOf(r14));
        com.obric.matrix.r.c.c.b("PushRequestService", "updateDeviceInfo, pkgName=" + r11 + ", updateType=" + r14);
        if (o.a(Looper.myLooper(), Looper.getMainLooper()) == false) goto L8;
        j.f9798a.j(new C0274b(this, r0, r15));
        return;
    L8:
        r8.u().c(h(), r0, r15);
    }
}
