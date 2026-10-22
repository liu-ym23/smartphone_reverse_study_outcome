package com.obric.matrix.push.m.d;

import android.text.TextUtils;
import com.obric.matrix.dataanalysis.j;
import com.squareup.wire.internal.Internal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J*\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0004H\u0016J \u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0004H\u0016J \u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0004H\u0016J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\bH\u0016J\u0018\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0012\u0010\u0019\u001a\u00020\u00062\b\b\u0002\u0010\u001a\u001a\u00020\u000fH\u0002J\u0012\u0010\u001b\u001a\u00020\u00062\b\b\u0002\u0010\u001a\u001a\u00020\u000fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/obric/matrix/push/base/event/EventService;", "Lcom/obric/matrix/push/base/event/IEventService;", "()V", "curEventSize", "", "onClickPushEvent", "", "msgId", "", "pkgName", "onEvent", "eventName", "params", "Lorg/json/JSONObject;", "needNetReport", "", "needAppLog", "onNotifyEnableEvent", "id", "reason", "onReceiveMessageEvent", "sentResultCode", "onReceivePushEvent", "onRepeatPushEvent", "onShowPushEvent", "reportEventInternal", "isRetry", "tryReportEvent", "push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class b implements com.obric.matrix.push.m.d.c {

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class a extends q implements kotlin.n0.c.a<f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ b f9667f;

        a(b r1) {
            this.f9667f = r1;
            super(0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ f0 invoke() {
            invoke2();
            return f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            b.j(this.f9667f, false, 1, null);
        }
    }

    /* JADX INFO: renamed from: com.obric.matrix.push.m.d.b$b, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class C0267b extends q implements kotlin.n0.c.a<f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f9668f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ JSONObject f9669g;

        C0267b(String r1, JSONObject r2) {
            this.f9668f = r1;
            this.f9669g = r2;
            super(0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ f0 invoke() {
            invoke2();
            return f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            j r0 = j.f9071a;
            String r1 = "matrix_" + this.f9668f;
            JSONObject r3 = this.f9669g;
            if (r3 != null) goto L5;
            r3 = new JSONObject();
        L5:
            r0.b(r1, r3);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class c extends q implements kotlin.n0.c.a<f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ b f9670f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ boolean f9671g;

        c(b r1, boolean r2) {
            this.f9670f = r1;
            this.f9671g = r2;
            super(0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ f0 invoke() {
            invoke2();
            return f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            b.g(this.f9670f, this.f9671g);
        }
    }

    public b() {
        com.obric.matrix.push.r.j.f9798a.h(new a(this), com.obric.matrix.push.p.b.h0.k());
    }

    public static final /* synthetic */ void g(b r0, boolean r1) {
        r0.h(r1);
    }

    private final void h(boolean r11) {
        com.obric.matrix.push.m.d.a r12 = com.obric.matrix.push.m.d.a.f9664a;
        com.obric.matrix.push.p.b r0 = com.obric.matrix.push.p.b.h0;
        HashMap<Long, JSONObject> r13 = r12.b(r0.l());
        if (r13.size() > 0) goto L5;
        return;
    L5:
        com.obric.matrix.push.n.c.c.h("report events batch = " + r13);
        long r1 = System.currentTimeMillis();
        if (r13.size() < r0.l()) goto L8;
        boolean r2 = true;
    L9:
        List r3 = Internal.newMutableList();
        JSONArray r6 = new JSONArray();
        Iterator<Map.Entry<Long, JSONObject>> r14 = r13.entrySet().iterator();
    L11:
        if (r14.hasNext() == false) goto L13;
        Map.Entry<Long, JSONObject> r7 = r14.next();
        long r8 = r7.getKey().longValue();
        JSONObject r9 = r7.getValue();
        r3.add(Long.valueOf(r8));
        r6.put(r9);
        goto L11
    L13:
        String r15 = com.obric.matrix.push.m.b.f9633a.A().b(r6);
        if (r15 == null) goto L29;
        JSONObject r10 = new JSONObject(r15);
        if (r10.optInt("code", -1) == 0) goto L18;
        return;
    L18:
        if (TextUtils.equals(r10.optString("message"), "success") == false) goto L31;
        Iterator r16 = r3.iterator();
    L21:
        if (r16.hasNext() == false) goto L23;
        com.obric.matrix.push.m.d.a.f9664a.a(((Number) r16.next()).longValue());
        goto L21
    L23:
        com.obric.matrix.push.m.b.f9633a.B().a().e(r1);
        if (r2 == false) goto L32;
        j(this, false, 1, null);
        return;
    L32:
        return;
    L31:
        return;
    L29:
        return;
    L8:
        r2 = false;
        goto L9
    }

    private final void i(boolean r3) {
        com.obric.matrix.push.r.j.f9798a.l(new c(this, r3));
    }

    static /* synthetic */ void j(b r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = false;
    L5:
        r0.i(r1);
    }

    @Override // com.obric.matrix.push.m.d.c
    public void a(String r3, String r4) {
        o.f(r3, "msgId");
        o.f(r4, "pkgName");
        JSONObject r0 = new JSONObject();
        r0.put("msg_id", r3);
        r0.put("pkg_name", r4);
        e(com.obric.matrix.push.p.b.h0.j(), r0, true, false);
    }

    @Override // com.obric.matrix.push.m.d.c
    public void b(String r1) {
        o.f(r1, "id");
    }

    @Override // com.obric.matrix.push.m.d.c
    public void c(String r1, String r2) {
        o.f(r1, "msgId");
        o.f(r2, "pkgName");
    }

    @Override // com.obric.matrix.push.m.d.c
    public void d(String r1, String r2, int r3) {
        o.f(r1, "msgId");
        o.f(r2, "pkgName");
    }

    @Override // com.obric.matrix.push.m.d.c
    public void e(String r1, JSONObject r2, boolean r3, boolean r4) {
        o.f(r1, "eventName");
        com.obric.matrix.push.r.j.f9798a.j(new C0267b(r1, r2));
    }

    @Override // com.obric.matrix.push.m.d.c
    public void f(String r3, String r4, int r5) {
        o.f(r3, "msgId");
        o.f(r4, "pkgName");
        JSONObject r0 = new JSONObject();
        r0.put("msg_id", r3);
        r0.put("pkg_name", r4);
        r0.put("sent_result_code", r5);
        e(com.obric.matrix.push.p.b.h0.i(), r0, true, false);
    }
}
