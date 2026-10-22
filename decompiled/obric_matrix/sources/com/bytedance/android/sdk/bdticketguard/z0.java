package com.bytedance.android.sdk.bdticketguard;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.Log;
import android.util.Pair;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.wschannel.WsConstants;
import com.ttnet.org.chromium.base.TimeUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ kotlin.s0.l[] f1098a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static kotlin.n0.c.a<Boolean> f1099b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f1100c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final kotlin.h f1101d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final z0 f1102e = null;

    static final class a extends kotlin.n0.d.q implements kotlin.n0.c.a<SharedPreferences> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f1103f = null;

        static {
            f1103f = new a();
        }

        a() {
            super(0);
        }

        @Proxy("getSharedPreferences")
        @TargetClass(scope = Scope.SELF, value = "android.content.Context")
        public static SharedPreferences a(Context r0, String r1, int r2) {
            return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
        }

        public final SharedPreferences b() {
            f1 r2 = d1.f706b.a();
            if (r2 == null) goto L9;
            c1 r3 = r2.G();
            if (r3 == null) goto L9;
            Context r4 = r3.e();
            if (r4 == null) goto L9;
            return a(r4, "TicketGuardEventHelper_didReport", 0);
        L9:
            return null;
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ SharedPreferences invoke() {
            return b();
        }
    }

    public static final class b implements kotlin.n0.c.a<String> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ o f1104f;

        b(o r1) {
            this.f1104f = r1;
        }

        public String a() {
            String r2 = y0.a().v(new l1(this.f1104f));
            kotlin.n0.d.o.b(r2, "gson.toJson(UseTicketSna…consumerResponseContent))");
            return r2;
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ String invoke() {
            return a();
        }
    }

    static final class c extends kotlin.n0.d.q implements kotlin.n0.c.a<String> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f1105f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f1106g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ long f1107h;

        c(int r1, String r2, long r3) {
            this.f1105f = r1;
            this.f1106g = r2;
            this.f1107h = r3;
            super(0);
        }

        public final String a() {
            JSONObject r0 = new JSONObject();
            r0.put("attempt_count", this.f1105f);
            r0.put("scene", this.f1106g);
            r0.put(TypedValues.TransitionType.S_DURATION, this.f1107h);
            return r0.toString();
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ String invoke() {
            return a();
        }
    }

    static final class d extends kotlin.n0.d.q implements kotlin.n0.c.a<String> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ JSONObject f1108f;

        d(JSONObject r1) {
            this.f1108f = r1;
            super(0);
        }

        public final String a() {
            return this.f1108f.toString();
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ String invoke() {
            return a();
        }
    }

    public static final class e implements kotlin.n0.c.a<String> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ f0 f1109f;

        e(f0 r1) {
            this.f1109f = r1;
        }

        public String a() {
            return y0.a().v(new q(this.f1109f));
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ String invoke() {
            return a();
        }
    }

    static final class f extends kotlin.n0.d.q implements kotlin.n0.c.a<String> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f1110f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f1111g;

        f(String r1, String r2) {
            this.f1110f = r1;
            this.f1111g = r2;
            super(0);
        }

        public final String a() {
            JSONObject r0 = new JSONObject();
            r0.put("ticket", p0.b(this.f1110f));
            r0.put("ts_sign", p0.b(this.f1111g));
            return r0.toString();
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ String invoke() {
            return a();
        }
    }

    static final class g extends kotlin.n0.d.q implements kotlin.n0.c.a<String> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f1112f;

        g(String r1) {
            this.f1112f = r1;
            super(0);
        }

        public final String a() {
            JSONObject r0 = new JSONObject();
            r0.put("client_cert", p0.b(this.f1112f));
            return r0.toString();
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ String invoke() {
            return a();
        }
    }

    static final class h extends kotlin.n0.d.q implements kotlin.n0.c.a<String> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f1113f;

        h(String r1) {
            this.f1113f = r1;
            super(0);
        }

        public final String a() {
            JSONObject r0 = new JSONObject();
            r0.put("sn", p0.b(this.f1113f));
            return r0.toString();
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ String invoke() {
            return a();
        }
    }

    static final class i extends kotlin.n0.d.q implements kotlin.n0.c.a<String> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ w0 f1114f;

        i(w0 r1) {
            this.f1114f = r1;
            super(0);
        }

        public final String a() {
            JSONObject r0 = new JSONObject();
            r0.put("ticket", p0.b(this.f1114f.b()));
            return r0.toString();
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ String invoke() {
            return a();
        }
    }

    static final class j extends kotlin.n0.d.q implements kotlin.n0.c.a<String> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f1115f;

        j(String r1) {
            this.f1115f = r1;
            super(0);
        }

        public final String a() {
            JSONObject r0 = new JSONObject();
            r0.put("client_cert", this.f1115f);
            return r0.toString();
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ String invoke() {
            return a();
        }
    }

    static {
        f1098a = new kotlin.s0.l[]{kotlin.n0.d.e0.g(new kotlin.n0.d.y(kotlin.n0.d.e0.b(z0.class), "didReportSp", "getDidReportSp()Landroid/content/SharedPreferences;"))};
        f1102e = new z0();
        f1101d = kotlin.i.b(a.f1103f);
    }

    private z0() {
    }

    public static final void A() {
        T("bd_ticket_guard_key_cert_not_match", new JSONObject());
    }

    public static final void E(String r9) {
        q(f1102e, "load_remote_cert_finish", null, -1, r9, null, null, 50, null);
    }

    public static final void F() {
        q(f1102e, "load_remote_cert_start", null, 0, null, null, null, 62, null);
    }

    public static final void G(String r10) {
        kotlin.n0.d.o.g(r10, "sn");
        q(f1102e, "load_remote_cert_finish", null, 0, null, null, new h(r10), 30, null);
    }

    public static final void H(String r5, String r6, String r7) {
        kotlin.n0.d.o.g(r5, "path");
        kotlin.n0.d.o.g(r6, "logid");
        kotlin.n0.d.o.g(r7, "remote_error");
        String r3 = f1102e.f(r5, false);
        JSONObject r4 = new JSONObject();
        r4.put("path", r5);
        r4.put("logid", r6);
        r4.put("remote_error", r7);
        T(r3, r4);
    }

    public static final void I(String r3, String r4, String r5) {
        kotlin.n0.d.o.g(r3, "scene");
        kotlin.n0.d.o.g(r4, "originalText");
        kotlin.n0.d.o.g(r5, "stacktrace");
        JSONObject r2 = new JSONObject();
        r2.put("scene", r3);
        r2.put("original_text", r4);
        r2.put("stacktrace", r5);
        T("bd_ticket_guard_parse_json_error", r2);
    }

    public static final void J(boolean r2, String r3) {
        JSONObject r0 = new JSONObject();
        if (r2 == false) goto L5;
        int r4 = 0;
    L6:
        r0.put(WsConstants.ERROR_CODE, r4);
        r0.put("error_desc", r3);
        T("bd_ticket_guard_parse_server", r0);
        return;
    L5:
        r4 = -1;
        goto L6
    }

    public static final void K(boolean r3, Throwable r4, int r5, long r6, String r8) {
        kotlin.n0.d.o.g(r8, "path");
        JSONObject r1 = new JSONObject();
        if (r3 == false) goto L5;
        int r7 = 0;
    L6:
        r1.put(WsConstants.ERROR_CODE, r7);
        r1.put("error_desc", f1102e.d(r4));
        r1.put("attempt_count", r5);
        r1.put(TypedValues.TransitionType.S_DURATION, r6);
        r1.put("path", r8);
        r1.put("key_type", "tee");
        T("bd_ticket_guard_create_signature", r1);
        return;
    L5:
        r7 = -1;
        goto L6
    }

    public static final void L(boolean r3, String r4, long r5, long r7, String r9, boolean r10, boolean r11) {
        kotlin.n0.d.o.g(r9, "path");
        JSONObject r1 = new JSONObject();
        if (r3 == false) goto L5;
        int r6 = 0;
    L6:
        r1.put(WsConstants.ERROR_CODE, r6);
        r1.put("error_desc", r4);
        r1.put(TypedValues.TransitionType.S_DURATION, r5);
        r1.put("elapsed_nano_time", r7);
        r1.put("is_in_foreground", f1102e.e());
        r1.put("path", r9);
        r1.put("key_type", "ree_ecdh_hmac");
        r1.put("is_standardized_hmac", r10 ? 1 : 0);
        r1.put("is_hmac_cache_enabled", r11 ? 1 : 0);
        T("bd_ticket_guard_create_signature", r1);
        return;
    L5:
        r6 = -1;
        goto L6
    }

    public static final void M(boolean r3, String r4, long r5, String r7) {
        kotlin.n0.d.o.g(r7, "path");
        JSONObject r1 = new JSONObject();
        if (r3 == false) goto L5;
        int r6 = 0;
    L6:
        r1.put(WsConstants.ERROR_CODE, r6);
        r1.put("error_desc", r4);
        r1.put(TypedValues.TransitionType.S_DURATION, r5);
        r1.put("path", r7);
        r1.put("key_type", "ree");
        T("bd_ticket_guard_create_signature", r1);
        return;
    L5:
        r6 = -1;
        goto L6
    }

    public static final void O(boolean r3, String r4, long r5, String r7, String r8, boolean r9, boolean r10, boolean r11, boolean r12, boolean r13) {
        kotlin.n0.d.o.g(r7, "scene");
        JSONObject r1 = new JSONObject();
        if (r3 == false) goto L5;
        int r6 = 0;
    L6:
        r1.put(WsConstants.ERROR_CODE, r6);
        r1.put("error_desc", r4);
        r1.put(TypedValues.TransitionType.S_DURATION, r5);
        r1.put("scene", r7);
        r1.put("logid", r8);
        z0 r14 = f1102e;
        r14.W(r9);
        r1.put("local_client_cert", r9 ? 1 : 0);
        r14.W(r10);
        r1.put("local_server_cert", r10 ? 1 : 0);
        r14.W(r10);
        r1.put("local_server_cert_sn", r10 ? 1 : 0);
        r14.W(r11);
        r1.put("remote_client_cert", r11 ? 1 : 0);
        r14.W(r12);
        r1.put("remote_server_cert", r12 ? 1 : 0);
        r14.W(r13);
        r1.put("remote_server_cert_sn", r13 ? 1 : 0);
        T("bd_ticket_guard_get_cert", r1);
        return;
    L5:
        r6 = -1;
        goto L6
    }

    public static final void P() {
        JSONObject r0 = new JSONObject();
        r0.put("sdk_aid", 31749);
        r0.put("sdk_version", "2.1.15-alpha.229");
        T("sdk_session_launch", r0);
    }

    public static final void Q(int r3, String r4, long r5, int r7, String r8) {
        kotlin.n0.d.o.g(r8, "path");
        JSONObject r1 = new JSONObject();
        r1.put(WsConstants.ERROR_CODE, r3);
        r1.put("error_desc", r4);
        r1.put(TypedValues.TransitionType.S_DURATION, r5);
        r1.put("attempt_count", r7);
        r1.put("path", r8);
        T("bd_ticket_guard_sign_client_data", r1);
    }

    public static final void S(o r10) {
        kotlin.n0.d.o.g(r10, "consumerResponseContent");
        r r0 = r10.b();
        if (r0 == null) goto L7;
        l r1 = r0.a();
        if (r1 == null) goto L7;
        String r2 = r1.f();
    L8:
        String r3 = r10.d();
        String r4 = r10.c();
        boolean r5 = false;
        if (r2 != null) goto L11;
    L14:
        boolean r6 = true;
    L15:
        if (r6 == true) goto L17;
    L33:
        boolean r7 = true;
    L34:
        if (r7 == true) goto L36;
        return;
    L36:
        r r8 = r10.b();
        String r9 = "";
        if (r8 == null) goto L45;
        l r11 = r8.a();
        if (r11 == null) goto L45;
        m r12 = r11.b();
        if (r12 == null) goto L45;
        String r13 = r12.b();
        if (r13 == null) goto L45;
    L46:
        r r14 = r10.b();
        if (r14 == null) goto L53;
        l r15 = r14.a();
        if (r15 == null) goto L53;
        String r16 = r15.g();
        if (r16 == null) goto L53;
    L54:
        z0 r17 = f1102e;
        if (r16.length() <= 0) goto L57;
        r5 = true;
    L57:
        String r18 = r17.f(r13, r5);
        JSONObject r19 = new JSONObject();
        r19.put("path", r13);
        r19.put("logid", r10.a());
        r19.put("local_error", r2);
        r19.put("remote_error", r3);
        r19.put("attest_error", r4);
        r19.put("sign_type", r16);
        d1 r20 = d1.f706b;
        f1 r21 = r20.a();
        if (r21 == null) goto L62;
        String r22 = r21.C();
        if (r22 == null) goto L62;
    L63:
        r19.put("tee_private_key_create_log", r22);
        f1 r23 = r20.a();
        if (r23 == null) goto L68;
        String r24 = r23.B();
        if (r24 == null) goto L68;
        r9 = r24;
    L68:
        r19.put("ree_private_key_create_log", r9);
        T(r18, r19);
        r17.o(r10);
        return;
    L62:
        r22 = "";
    L53:
        r16 = "";
    L45:
        r13 = "";
        goto L46
    L17:
        if (r3.length() <= 0) goto L19;
        boolean r25 = true;
    L21:
        if (r25 == false) goto L25;
        if ((!kotlin.n0.d.o.a(r3, BDLocationException.ERROR_TIMEOUT)) == true) goto L33;
    L25:
        if (r4.length() <= 0) goto L27;
        boolean r26 = true;
    L28:
        if (r26 == true) goto L30;
    L32:
        r7 = false;
        goto L34
    L30:
        if ((!kotlin.n0.d.o.a(r4, BDLocationException.ERROR_TIMEOUT)) == false) goto L32;
    L27:
        r26 = false;
        goto L28
    L19:
        r25 = false;
        goto L21
    L11:
        if (r2.length() == 0) goto L14;
        r6 = false;
    L7:
        r2 = null;
        goto L8
    }

    public static final void T(String r2, JSONObject r3) {
        kotlin.n0.d.o.g(r2, NotificationCompat.CATEGORY_EVENT);
        kotlin.n0.d.o.g(r3, "params");
        r3.put("params_for_special", "uc_login");
        r3.put("bd_ticket_sdk_version", "2.1.15-alpha.229");
        r3.put("ticket_guard_config_version", com.bytedance.android.sdk.bdticketguard.p1.k.f1023J.N().b());
        f1 r0 = d1.f706b.a();
        if (r0 == null) goto L6;
        r0.P(r2, r3);
        return;
    }

    private final int W(boolean r1) {
        return r1 ? 1 : 0;
    }

    private final boolean a(int r12, int r13) {
        String r0 = com.bytedance.android.sdk.bdticketguard.p1.k.f1023J.L().b();
        if (r0.length() <= 0) goto L5;
        boolean r11 = true;
    L7:
        if (r11 == false) goto L19;
        List r14 = kotlin.u0.k.n0(r0, new String[]{","}, false, 0, 6, null);
        ArrayList r1 = new ArrayList(kotlin.i0.r.q(r14, 10));
        Iterator r15 = r14.iterator();
    L10:
        if (r15.hasNext() == false) goto L17;
        String r2 = (String) r15.next();
        if (r2 == null) goto L15;
        r1.add(kotlin.u0.k.G0(r2).toString());
        goto L10
    L15:
        throw new kotlin.b0("null cannot be cast to non-null type kotlin.CharSequence");
    L17:
        if (kotlin.i0.r.D0(r1).contains(String.valueOf(r12)) == false) goto L19;
        return true;
    L19:
        String r3 = com.bytedance.android.sdk.bdticketguard.p1.k.f1023J.M().b();
        if (r3.length() <= 0) goto L22;
        boolean r16 = true;
    L23:
        if (r16 == false) goto L35;
        List r17 = kotlin.u0.k.n0(r3, new String[]{","}, false, 0, 6, null);
        ArrayList r18 = new ArrayList(kotlin.i0.r.q(r17, 10));
        Iterator r19 = r17.iterator();
    L26:
        if (r19.hasNext() == false) goto L33;
        String r4 = (String) r19.next();
        if (r4 == null) goto L31;
        r18.add(kotlin.u0.k.G0(r4).toString());
        goto L26
    L31:
        throw new kotlin.b0("null cannot be cast to non-null type kotlin.CharSequence");
    L33:
        if (kotlin.i0.r.D0(r18).contains(String.valueOf(r13)) == false) goto L35;
        return true;
    L35:
        return false;
    L22:
        r16 = false;
        goto L23
    L5:
        r11 = false;
        goto L7
    }

    private final SharedPreferences c() {
        kotlin.h r2 = f1101d;
        kotlin.s0.l r0 = f1098a[0];
        return (SharedPreferences) r2.getValue();
    }

    private final int e() {
        kotlin.n0.c.a<Boolean> r1 = f1099b;
        if (r1 == null) goto L5;
        Boolean r2 = r1.invoke();
    L7:
        if (kotlin.n0.d.o.a(r2, Boolean.TRUE) == false) goto L10;
        return 1;
    L10:
        if (kotlin.n0.d.o.a(r2, Boolean.FALSE) == false) goto L12;
        return 0;
    L12:
        if (r2 != null) goto L16;
        return -1;
    L16:
        throw new kotlin.m();
    L5:
        r2 = null;
        goto L7
    }

    private final String f(String r4, boolean r5) {
        boolean r3 = kotlin.u0.k.A(r4, "/passport/", false, 2, null);
        if (r5 == true) goto L8;
        if (r3 == false) goto L6;
        return "bd_ticket_guard_use_ticket_fail_no_sign";
    L6:
        return "bd_ticket_guard_downstream_use_ticket_fail_no_sign";
    L8:
        if (r3 == false) goto L10;
        return "bd_ticket_guard_use_ticket_fail";
    L10:
        return "bd_ticket_guard_downstream_use_ticket_fail";
    }

    public static final void h(String r2, Throwable r3) {
        kotlin.n0.d.o.g(r2, "scene");
        kotlin.n0.d.o.g(r3, "e");
        JSONObject r1 = new JSONObject();
        r1.put("scene", r2);
        r1.put("error_desc", f1102e.d(r3));
        T("bd_ticket_guard_contains_alias_error", r1);
    }

    public static final void i() {
        T("bd_ticket_guard_contains_alias_not_match", new JSONObject());
    }

    public static final void n(Throwable r2) {
        kotlin.n0.d.o.g(r2, "e");
        JSONObject r0 = new JSONObject();
        r0.put("error_desc", f1102e.d(r2));
        T("bd_ticket_guard_delta_instance_fail", r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void q(z0 r7, String r8, String r9, int r10, String r11, String r12, kotlin.n0.c.a r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L5;
        r9 = "all";
    L5:
        String r2 = r9;
        if ((r14 & 4) == 0) goto L8;
        r10 = 0;
    L8:
        int r3 = r10;
        if ((r14 & 8) == 0) goto L11;
        String r4 = null;
    L13:
        if ((r14 & 16) == 0) goto L15;
        String r5 = null;
    L17:
        if ((r14 & 32) == 0) goto L19;
        kotlin.n0.c.a r6 = null;
    L20:
        r7.p(r8, r2, r3, r4, r5, r6);
        return;
    L19:
        r6 = r13;
        goto L20
    L15:
        r5 = r12;
        goto L17
    L11:
        r4 = r11;
        goto L13
    }

    public static final void r(int r2, Throwable r3, int r4) {
        JSONObject r0 = new JSONObject();
        r0.put(WsConstants.ERROR_CODE, r2);
        r0.put("error_desc", f1102e.d(r3));
        r0.put("attempt_count", r4);
        T("bd_ticket_guard_get_csr", r0);
    }

    public static final void s(int r18, Throwable r19, long r20, boolean r22, int r23, String r24) {
        kotlin.n0.d.o.g(r24, "scene");
        JSONObject r7 = new JSONObject();
        r7.put(WsConstants.ERROR_CODE, r18);
        z0 r9 = f1102e;
        r7.put("error_desc", r9.d(r19));
        r7.put(TypedValues.TransitionType.S_DURATION, r20);
        r7.put("is_first_generate", r22 ? 1 : 0);
        r7.put("attempt_count", r23);
        r7.put("scene", r24);
        r7.put("key_type", "tee");
        T("bd_ticket_guard_get_private_key", r7);
        c r15 = new c(r23, r24, r20);
        String r13 = r9.d(r19);
        if (r22 == false) goto L5;
        String r10 = "create_tee_private_key";
    L6:
        q(r9, r10, null, r18, r13, null, r15, 18, null);
        return;
    L5:
        r10 = "load_tee_private_key";
        goto L6
    }

    public static final void t(String r2) {
        kotlin.n0.d.o.g(r2, "stacktrace");
        JSONObject r1 = new JSONObject();
        r1.put("stacktrace", r2);
        T("bd_ticket_guard_get_package_process_name_error", r1);
    }

    public static final void u(int r11, String r12, long r13, long r15, long r17, boolean r19, String r20) {
        kotlin.n0.d.o.g(r20, "scene");
        JSONObject r3 = new JSONObject();
        r3.put(WsConstants.ERROR_CODE, r11);
        if (r12 == null) goto L5;
        r3.put("error_desc", r12);
    L5:
        r3.put(TypedValues.TransitionType.S_DURATION, r13);
        r3.put("delta_duration", r15);
        r3.put("sp_duration", r17);
        z0 r5 = f1102e;
        r5.W(r19);
        r3.put("is_first_generate", r19 ? 1 : 0);
        r3.put("scene", r20);
        r3.put("key_type", "ree");
        d r7 = new d(r3);
        T("bd_ticket_guard_get_private_key", r3);
        if (r19 == false) goto L8;
        String r1 = "create_ree_private_key";
    L9:
        q(r5, r1, null, r11, r12, null, r7, 18, null);
        return;
    L8:
        r1 = "load_ree_private_key";
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r12v7, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r12v9 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static final void v(f0 r11, boolean r12) {
        kotlin.n0.d.o.g(r11, "providerResponseContent");
        s r0 = r11.b();
        String r1 = null;
        if (r0 == null) goto L5;
        Long r2 = Long.valueOf(r0.c());
    L6:
        r2.longValue();
        s r3 = r11.b();
        if (r3 == null) goto L11;
        d0 r4 = r3.a();
        if (r4 == null) goto L11;
        Long r5 = Long.valueOf(r4.c());
    L12:
        r5.longValue();
        s r6 = r11.b();
        if (r6 == null) goto L21;
        d0 r7 = r6.a();
        if (r7 == null) goto L21;
        e0 r8 = r7.b();
        if (r8 == null) goto L21;
        String r9 = r8.b();
        if (r9 == null) goto L21;
    L22:
        if (r12 == true) goto L47;
        List<Pair<String, String>> r13 = r11.b().a().a();
        if (r13 == null) goto L35;
        Iterator<T> r14 = r13.iterator();
    L27:
        if (r14.hasNext() == false) goto L31;
        Object r10 = r14.next();
        if (kotlin.n0.d.o.a((String) ((Pair) r10).first, "bd-ticket-guard-server-cert-sn") == false) goto L27;
    L32:
        Pair r15 = (Pair) r10;
        if (r15 == null) goto L35;
        r1 = (String) r15.second;
        goto L35
    L31:
        r10 = null;
    L35:
        ?? r16 = 0;
        if (r1 != null) goto L38;
    L41:
        boolean r17 = true;
    L42:
        if (r17 == false) goto L47;
        s0.f1065a.a("TicketGuardEventHelper", "Server cert SN is null or empty but no server cert returned from server");
        JSONObject r18 = new JSONObject();
        r18.put("path", r9);
        r18.put("logid", r11.a());
        z0 r19 = f1102e;
        if (r11.d().length() <= 0) goto L46;
        r16 = 1;
    L46:
        r19.W(r16);
        r18.put("response_has_server_data", r16);
        T("bd_ticket_guard_get_ticket_no_server_cert", r18);
        goto L47
    L38:
        if (r1.length() == 0) goto L41;
        r17 = false;
    L47:
        q(f1102e, "get_ticket_response", null, 0, null, null, new e(r11), 30, null);
        return;
    L21:
        r9 = "";
    L11:
        r5 = null;
        goto L12
    L5:
        r2 = null;
        goto L6
    }

    public static final void x(Map<com.bytedance.android.sdk.bdticketguard.n1.b, com.bytedance.android.sdk.bdticketguard.n1.c> r2, boolean r3) {
        kotlin.n0.d.o.g(r2, "taskStates");
        JSONObject r0 = new JSONObject(com.bytedance.android.sdk.bdticketguard.n1.k.a());
        f1102e.W(r3);
        r0.put("is_enable_init_opt", r3 ? 1 : 0);
        T("bd_ticket_guard_init_finish", r0);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        s0.f1065a.c("TicketGuardEventHelper", "Monitor init finish failed! ", e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v47 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static final void z(Object r26, int r27, boolean r28) {
        if (kotlin.v.g(r26) == true) goto L5;
        s0.f1065a.e("TicketGuardEventHelper", "key attestation failed: " + Log.getStackTraceString(kotlin.v.d(r26)));
    L5:
        boolean r1 = kotlin.v.d(r26) instanceof com.bytedance.android.sdk.bdticketguard.b;
        if (kotlin.v.g(r26) == true) goto L10;
        if (r1 == true) goto L10;
        ?? r3 = 0;
    L11:
        if (r1 == false) goto L13;
        Throwable r7 = null;
    L14:
        boolean r8 = r7 instanceof com.bytedance.android.sdk.bdticketguard.c;
        if (r8 == false) goto L17;
        int r10 = ((com.bytedance.android.sdk.bdticketguard.c) r7).a();
    L20:
        boolean r11 = r7 instanceof com.bytedance.android.sdk.bdticketguard.e;
        if (r11 == false) goto L23;
        int r12 = ((com.bytedance.android.sdk.bdticketguard.e) r7).a();
    L27:
        if (com.bytedance.android.sdk.bdticketguard.p1.k.f1023J.p().b().booleanValue() == false) goto L30;
        if (r1 == true) goto L30;
        boolean r13 = f1102e.a(r10, r12);
    L31:
        if (r13 == false) goto L34;
        s0.f1065a.e("TicketGuardEventHelper", "key attestation need snapshot, localErrorCode=" + r10 + ", remoteErrorCode=" + r12);
    L34:
        if (kotlin.v.g(r26) == true) goto L36;
        if (r8 == false) goto L46;
        com.bytedance.android.sdk.bdticketguard.i r4 = ((com.bytedance.android.sdk.bdticketguard.c) r7).b();
    L49:
        if (r3 == 0) goto L51;
        int r9 = 0;
    L57:
        if ((r7 instanceof com.bytedance.android.sdk.bdticketguard.b) == false) goto L61;
        com.bytedance.android.sdk.bdticketguard.g r14 = ((com.bytedance.android.sdk.bdticketguard.b) r7).a();
        if (r14 == null) goto L63;
        String r15 = r14.a();
    L64:
        if (r15 != null) goto L67;
        r15 = "null";
    L67:
        JSONObject r16 = new JSONObject();
        z0 r6 = f1102e;
        r6.W(r3);
        r16.put(LocationMonitorConst.IS_SUCCESS, r3);
        r6.W(r1);
        r16.put("is_already_completed", r1 ? 1 : 0);
        r16.put(WsConstants.ERROR_CODE, r12);
        r16.put("unified_error_code", r9);
        r16.put("localized_error_code", r10);
        r16.put("error_desc", r6.b(r7));
        r16.put("attempt_count", r27);
        r16.put("attestation_adapter", r15);
        r16.put("display_os_version", Build.DISPLAY);
        String r2 = "";
        if (r11 == false) goto L71;
        String r5 = ((com.bytedance.android.sdk.bdticketguard.e) r7).b();
    L81:
        r16.put("logid", r5);
        r6.W(r28);
        r16.put("is_last_attempt", r28 ? 1 : 0);
        if (kotlin.v.g(r26) == true) goto L84;
    L114:
        if (r4 == null) goto L116;
        Throwable r0 = r4.c();
    L118:
        if ((r0 instanceof com.bytedance.android.sdk.bdticketguard.c) == false) goto L120;
        int r17 = ((com.bytedance.android.sdk.bdticketguard.c) r0).a();
    L121:
        if (r4 == null) goto L123;
        Throwable r18 = r4.d();
    L125:
        if ((r18 instanceof com.bytedance.android.sdk.bdticketguard.c) == false) goto L127;
        int r19 = ((com.bytedance.android.sdk.bdticketguard.c) r18).a();
    L130:
        if (r4 == null) goto L132;
        Throwable r20 = r4.d();
    L133:
        String r21 = r6.b(r20);
        r16.put("alt_error_code", r17);
        r16.put("alt_error_desc", r6.b(r0));
        r16.put("cert_chain_error_code", r19);
        r16.put("cert_chain_error_desc", r21);
        if (r4 == null) goto L140;
        Set<String> r110 = r4.h();
        if (r110 == null) goto L140;
        String r22 = kotlin.i0.r.Z(r110, ",", null, null, 0, null, null, 62, null);
        if (r22 == null) goto L140;
    L141:
        r16.put("request_type", r22);
        if (r13 == false) goto L169;
        if (r4 == null) goto L169;
        String r23 = r4.b();
        if (r23 != null) goto L149;
        r23 = "";
    L149:
        if (r23.length() > 1000) goto L151;
    L179:
        String r24 = y0.a().v(r4);     // Catch: Exception -> L161
    L162:
        r16.put("snapshot", r24);
        r16.put("snapshot_tee_public_key", r4.i());
        r16.put("snapshot_ree_public_key", r4.g());
        r16.put("snapshot_client_cert", r23);
        if (r2.length() <= 0) goto L165;
        boolean r111 = true;
    L166:
        if (r111 == false) goto L168;
        r16.put("snapshot_client_cert_1", r2);
    L168:
        r16.put("snapshot_record_tee_public_key", r4.f());
        r16.put("snapshot_record_ree_public_key", r4.e());
        goto L169
    L165:
        r111 = false;
    L161:
        r24 = "<snapshot toJson error>";
        goto L162
    L151:
        if (r23 == null) goto L158;
        String r25 = r23.substring(0, 1000);
        kotlin.n0.d.o.b(r25, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        if (r23 == null) goto L156;
        r2 = r23.substring(1000);
        kotlin.n0.d.o.b(r2, "(this as java.lang.String).substring(startIndex)");
        r23 = r25;
        goto L179
    L156:
        throw new kotlin.b0("null cannot be cast to non-null type java.lang.String");
    L158:
        throw new kotlin.b0("null cannot be cast to non-null type java.lang.String");
    L169:
        T("bd_ticket_guard_key_attestation_result", r16);
        s0 r29 = s0.f1065a;
        StringBuilder r30 = new StringBuilder();
        r30.append("key attestation result: ");
        r30.append(kotlin.v.h(r26));
        r30.append("\n monitorData: ");
        if (kotlin.v.f(r26) == false) goto L172;
        Object r31 = null;
    L173:
        com.bytedance.android.sdk.bdticketguard.g r32 = (com.bytedance.android.sdk.bdticketguard.g) r31;
        if (r32 == null) goto L176;
        Object r33 = r32.c();
    L177:
        r30.append(r33);
        r29.e("TicketGuardEventHelper", r30.toString());
        return;
    L176:
        r33 = null;
        goto L177
    L172:
        r31 = r26;
    L140:
        r22 = "";
        goto L141
    L132:
        r20 = null;
        goto L133
    L127:
        if (r18 != null) goto L129;
        r19 = 0;
        goto L130
    L129:
        r19 = -1;
        goto L130
    L123:
        r18 = null;
        goto L125
    L120:
        r17 = 0;
        goto L121
    L116:
        r0 = null;
        goto L118
    L84:
        if (kotlin.v.f(r26) == false) goto L86;
        Object r34 = null;
    L87:
        com.bytedance.android.sdk.bdticketguard.g r35 = (com.bytedance.android.sdk.bdticketguard.g) r34;
        if (r35 == null) goto L92;
        com.bytedance.android.sdk.bdticketguard.g.a r36 = r35.c();
        if (r36 == null) goto L92;
        Long r37 = Long.valueOf(r36.a());
    L93:
        r16.put("local_duration", r37);
        if (kotlin.v.f(r26) == false) goto L96;
        Object r38 = null;
    L97:
        com.bytedance.android.sdk.bdticketguard.g r39 = (com.bytedance.android.sdk.bdticketguard.g) r38;
        if (r39 == null) goto L102;
        com.bytedance.android.sdk.bdticketguard.g.a r40 = r39.c();
        if (r40 == null) goto L102;
        Long r41 = Long.valueOf(r40.b());
    L103:
        r16.put("remote_duration", r41);
        if (kotlin.v.f(r26) == false) goto L106;
        Object r42 = null;
    L107:
        com.bytedance.android.sdk.bdticketguard.g r43 = (com.bytedance.android.sdk.bdticketguard.g) r42;
        if (r43 == null) goto L112;
        com.bytedance.android.sdk.bdticketguard.g.a r44 = r43.c();
        if (r44 == null) goto L112;
        Long r45 = Long.valueOf(r44.a() + r44.b());
    L113:
        r16.put("total_duration", r45);
    L112:
        r45 = null;
        goto L113
    L106:
        r42 = r26;
    L102:
        r41 = null;
        goto L103
    L96:
        r38 = r26;
    L92:
        r37 = null;
        goto L93
    L86:
        r34 = r26;
        goto L87
    L71:
        if (kotlin.v.g(r26) == true) goto L73;
        r5 = "";
        goto L81
    L73:
        if (kotlin.v.f(r26) == false) goto L75;
        Object r46 = null;
    L76:
        com.bytedance.android.sdk.bdticketguard.g r47 = (com.bytedance.android.sdk.bdticketguard.g) r46;
        if (r47 == null) goto L79;
        r5 = r47.b();
        goto L81
    L79:
        r5 = null;
        goto L81
    L75:
        r46 = r26;
    L63:
        r15 = null;
        goto L64
    L61:
        if (r4 == null) goto L63;
        r15 = r4.a();
        goto L64
    L51:
        if (r11 == false) goto L53;
        r9 = ((com.bytedance.android.sdk.bdticketguard.e) r7).a();
        goto L57
    L53:
        if (r8 == false) goto L55;
        r9 = ((com.bytedance.android.sdk.bdticketguard.c) r7).a();
        goto L57
    L55:
        r9 = -1;
        goto L57
    L46:
        if (r11 == false) goto L48;
        r4 = ((com.bytedance.android.sdk.bdticketguard.e) r7).c();
    L48:
        r4 = null;
        goto L49
    L36:
        if (kotlin.v.f(r26) == false) goto L38;
        Object r48 = null;
    L39:
        com.bytedance.android.sdk.bdticketguard.g r49 = (com.bytedance.android.sdk.bdticketguard.g) r48;
        if (r49 == null) goto L48;
        com.bytedance.android.sdk.bdticketguard.g.a r50 = r49.c();
        if (r50 == null) goto L48;
        r4 = r50.c();
        goto L49
    L38:
        r48 = r26;
    L30:
        r13 = false;
        goto L31
    L23:
        if (r3 == 0) goto L25;
        r12 = 0;
        goto L27
    L25:
        r12 = -1;
        goto L27
    L17:
        if (r3 == 0) goto L19;
        r10 = 0;
        goto L20
    L19:
        r10 = -1;
        goto L20
    L13:
        r7 = kotlin.v.d(r26);
    L10:
        r3 = 1;
        goto L11
    }

    public final void B(String r12) {
        JSONObject r0 = new JSONObject();
        r0.put(WsConstants.ERROR_CODE, -1);
        r0.put("error_desc", r12);
        T("bd_ticket_guard_load_local_cert_fail", r0);
        q(this, "load_local_cert_finish", null, -1, r12, null, null, 50, null);
    }

    public final void C() {
        q(this, "load_local_cert_start", null, 0, null, null, null, 62, null);
    }

    public final void D(String r11) {
        kotlin.n0.d.o.g(r11, "client_cert");
        q(this, "load_local_cert_finish", null, 0, null, null, new g(r11), 30, null);
    }

    public final void N(w0 r11) {
        kotlin.n0.d.o.g(r11, "ticketDataBean");
        i r7 = new i(r11);
        q(this, "remove_ticket_data", r11.e(), 0, "cert not match key", null, r7, 20, null);
    }

    public final void R(String r11) {
        kotlin.n0.d.o.g(r11, "client_cert");
        q(this, "update_local_cert", null, 0, null, null, new j(r11), 30, null);
    }

    public final void U(kotlin.n0.c.a<Boolean> r1) {
        f1099b = r1;
    }

    public final void V(boolean r1) {
        f1100c = r1;
    }

    public final String b(Throwable r5) {
        if (r5 != null) goto L4;
        return "null";
    L4:
        if ((r5 instanceof com.bytedance.android.sdk.bdticketguard.e) == true) goto L6;
        String r0 = r5.getMessage();
        if (r0 != null) goto L10;
    L13:
        boolean r1 = true;
    L14:
        if (r1 == true) goto L16;
        String r2 = r5.getMessage();
    L17:
        String r3 = "";
        if (r5.getCause() == null) goto L20;
        String r4 = " [Cause: " + b(r5.getCause()) + "]";
    L22:
        if ((r5 instanceof com.bytedance.android.sdk.bdticketguard.c) == true) goto L26;
        r3 = r5.getClass().getName().toString() + ": ";
    L26:
        return r3 + r2 + r4;
    L20:
        r4 = "";
        goto L22
    L16:
        r2 = d(r5);
        goto L17
    L10:
        if (r0.length() == 0) goto L13;
        r1 = false;
        goto L14
    L6:
        return "AttestationFailedException: " + ((com.bytedance.android.sdk.bdticketguard.e) r5).a();
    }

    public final String d(Throwable r1) {
        if (r1 != null) goto L4;
        return "";
    L4:
        String r0 = Log.getStackTraceString(r1);
        kotlin.n0.d.o.b(r0, "Log.getStackTraceString(throwable)");
        return r0;
    }

    public final void g(boolean r3, boolean r4) {
        JSONObject r2 = new JSONObject();
        z0 r0 = f1102e;
        r0.W(r3);
        r2.put("is_tee_changed", r3 ? 1 : 0);
        r0.W(r4);
        r2.put("is_ree_changed", r4 ? 1 : 0);
        T("bd_ticket_guard_key_attestation_sign_key_changed", r2);
    }

    public final void j(String r3, com.bytedance.android.sdk.bdticketguard.m1.c.b r4) {
        kotlin.n0.d.o.g(r3, "path");
        kotlin.n0.d.o.g(r4, "result");
        kotlin.u[] r1 = new kotlin.u[4];
        r1[0] = kotlin.a0.a("path", r3);
        if (kotlin.n0.d.o.a(r4.a(), "null") == false) goto L5;
        int r5 = -2;
    L6:
        r1[1] = kotlin.a0.a(WsConstants.ERROR_CODE, Integer.valueOf(r5));
        r1[2] = kotlin.a0.a("error_desc", b(r4.c()));
        r1[3] = kotlin.a0.a("attestation_adapter", r4.a());
        T("bd_ticket_guard_attest_sign_error", a1.a(r1));
        return;
    L5:
        r5 = -1;
        goto L6
    }

    public final void k(String r4, com.bytedance.android.sdk.bdticketguard.m1.c.d r5) {
        kotlin.n0.d.o.g(r4, "path");
        kotlin.n0.d.o.g(r5, "result");
        T("bd_ticket_guard_attest_sign_success", a1.a(new kotlin.u[]{kotlin.a0.a("path", r4), kotlin.a0.a(WsConstants.ERROR_CODE, 0), kotlin.a0.a("attestation_adapter", r5.a()), kotlin.a0.a(TypedValues.TransitionType.S_DURATION, Long.valueOf(r5.d() / TimeUtils.NANOSECONDS_PER_MILLISECOND)), kotlin.a0.a("duration_ns", Long.valueOf(r5.d()))}));
    }

    public final void l(String r3, long r4) {
        JSONObject r2 = new JSONObject();
        int r0 = 0;
        if (r3 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L12;
        r0 = -1;
    L12:
        r2.put(WsConstants.ERROR_CODE, r0);
        r2.put("error_desc", r3);
        r2.put(TypedValues.TransitionType.S_DURATION, r4);
        T("bd_ticket_guard_decrypt_result", r2);
        return;
    L5:
        if (r3.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public final void m(String r2) {
        kotlin.n0.d.o.g(r2, NotificationCompat.CATEGORY_MESSAGE);
        JSONObject r1 = new JSONObject();
        r1.put("error_desc", r2);
        T("bd_ticket_guard_delta_instance_fail", r1);
    }

    public final void o(o r11) {
        kotlin.n0.d.o.g(r11, "consumerResponseContent");
        boolean r2 = false;
        if (kotlin.u0.k.A(r11.d(), "12", false, 2, null) == true) goto L5;
        return;
    L5:
        String r0 = r11.b().a().b().i();
        if (r0.length() != 0) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return;
    L11:
        SharedPreferences r3 = c();
        if (r3 != null) goto L14;
    L16:
        if (r2 == false) goto L18;
        return;
    L18:
        SharedPreferences r4 = c();
        if (r4 == null) goto L25;
        SharedPreferences.Editor r5 = r4.edit();
        if (r5 == null) goto L25;
        SharedPreferences.Editor r6 = r5.putBoolean(r0, true);
        if (r6 == null) goto L25;
        r6.apply();
    L25:
        q(this, "sign_verify_fail_info_update", r11.b().a().b().j(), 0, null, null, new b(r11), 28, null);
        return;
    L14:
        if (r3.getBoolean(r0, false) != true) goto L16;
        r2 = true;
        goto L16
    L8:
        r1 = false;
        goto L9
    }

    public final void p(String r4, String r5, int r6, String r7, String r8, kotlin.n0.c.a<String> r9) {
        kotlin.n0.d.o.g(r4, "event_type");
        kotlin.n0.d.o.g(r5, "ticket_name");
        if (f1100c == true) goto L5;
        return;
    L5:
        if (r8 != null) goto L10;
        if (r9 == null) goto L9;
        r8 = r9.invoke();
        goto L10
    L9:
        r8 = null;
    L10:
        String r10 = String.valueOf(r8);
        s0.f1065a.a("TicketGuardEventHelper", "ticket full log: event_type=" + r4 + ", error_code=" + r6 + ", error_desc=" + r7 + ", extraInfo=" + r10);
        JSONObject r11 = new JSONObject();
        r11.put("event_type", r4);
        r11.put("ticket_name", r5);
        r11.put(WsConstants.ERROR_CODE, r6);
        r11.put("error_desc", r7);
        r11.put("extra_info", r10);
        T("bd_ticket_guard_full_path", r11);
    }

    public final void w(String r11, String r12, String r13) {
        kotlin.n0.d.o.g(r11, "ticket_name");
        kotlin.n0.d.o.g(r12, "ticket");
        kotlin.n0.d.o.g(r13, "ts_sign");
        q(this, "ticket_sign_update", r11, 0, null, null, new f(r12, r13), 28, null);
    }

    public final void y() {
        s0.f1065a.a("TicketGuardEventHelper", "invalidate server cert");
        T("bd_ticket_guard_invalidate_server_cert", new JSONObject());
    }
}
