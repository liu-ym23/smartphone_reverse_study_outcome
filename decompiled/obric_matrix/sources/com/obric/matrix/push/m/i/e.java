package com.obric.matrix.push.m.i;

import android.app.Application;
import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import com.obric.matrix.push.g;
import com.obric.matrix.push.r.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\bH\u0016J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0016\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0004H\u0002J\u0018\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0004H\u0002J\"\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0018\u0010!\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004H\u0016J\u001a\u0010\"\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010#\u001a\u00020\bH\u0002J\u0018\u0010$\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020&H\u0002J\u0018\u0010'\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020&H\u0002J\u0018\u0010(\u001a\u00020\u00122\u0006\u0010%\u001a\u00020&2\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/obric/matrix/push/base/message/PushMsgHandlerService;", "Lcom/obric/matrix/push/base/message/IPushMsgHandleService;", "()V", "TAG", "", "lastDeDuplicationTimestamp", "", "checkPackagePushEnable", "", "pkg", "notificationType", "convertToMessage", "Lcom/obric/matrix/push_api/Message;", "push", "Lcom/obric/matrix/push/Push;", "convertToNotification", "Lcom/obric/matrix/push_api/Notification;", "handleExpiredHistoryMsg", "", "handleInterceptor", "", "passThough", "handlePush", "isPassThoughSupportBinder", "targetPkg", "action", "isPassThoughSupportProvider", "authority", "onHandlePushClick", "msgId", "pkgName", "intent", "Landroid/content/Intent;", "onHandlePushShow", "onReceivePushEvent", "sentResultCode", "sendMessageByBinder", "context", "Landroid/app/Application;", "sendMessageByBroadcast", "sendMessageByProvider", "push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class e implements com.obric.matrix.push.m.i.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f9703a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9704b;

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class a extends q implements kotlin.n0.c.a<f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ e f9705f;

        a(e r1) {
            this.f9705f = r1;
            super(0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ f0 invoke() {
            invoke2();
            return f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            long r0 = System.currentTimeMillis();
            com.obric.matrix.push.m.i.a.f9696a.a(r0 - ((long) com.obric.matrix.push.p.b.h0.r()));
            e.e(this.f9705f, r0);
            com.obric.matrix.push.m.b.f9633a.B().a().a(r0);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class b extends q implements kotlin.n0.c.a<f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f9706f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f9707g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ Intent f9708h;

        b(String r1, String r2, Intent r3) {
            this.f9706f = r1;
            this.f9707g = r2;
            this.f9708h = r3;
            super(0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ f0 invoke() {
            invoke2();
            return f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            com.obric.matrix.push.m.b r0 = com.obric.matrix.push.m.b.f9633a;
            r0.c().a(this.f9706f, this.f9707g);
            r0.x().c(this.f9706f, this.f9707g, this.f9708h);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class c extends q implements kotlin.n0.c.a<f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f9709f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f9710g;

        c(String r1, String r2) {
            this.f9709f = r1;
            this.f9710g = r2;
            super(0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ f0 invoke() {
            invoke2();
            return f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            com.obric.matrix.push.m.b r0 = com.obric.matrix.push.m.b.f9633a;
            r0.c().c(this.f9709f, this.f9710g);
            r0.x().d(this.f9709f, this.f9710g);
        }
    }

    public e() {
        this.f9704b = "PushMsgHandleService";
    }

    public static final /* synthetic */ void e(e r0, long r1) {
        r0.f9703a = r1;
    }

    private final com.obric.matrix.push_api.d g(g r4) {
        return new com.obric.matrix.push_api.d(r4.f9564f, r4.f9565g, r4.f9569k, r4.D);
    L4:
        return null;
    }

    private final com.obric.matrix.push_api.e h(g r12) {
        String r1 = r12.f9564f;     // Catch: Throwable -> L8
        String r2 = r12.f9565g;     // Catch: Throwable -> L8
        String r3 = r12.f9567i;     // Catch: Throwable -> L8
        String r4 = r12.f9566h;     // Catch: Throwable -> L8
        String r5 = r12.m;     // Catch: Throwable -> L8
        Integer r0 = r12.r;     // Catch: Throwable -> L8
        if (r0 != null) goto L5;
        int r6 = 0;
    L6:
        return new com.obric.matrix.push_api.e(r1, r2, r3, r4, r5, r6, r12.o, r12.f9570l, r12.D, r12.q);
    L5:
        r6 = r0.intValue();     // Catch: Throwable -> L8
    L8:
        return null;
    }

    private final boolean j(String r3, String r4) {
        PackageManager r0 = com.bytedance.mpaas.app.a.b().getPackageManager();     // Catch: Throwable -> L4
        Intent r1 = new Intent();     // Catch: Throwable -> L4
        r1.setPackage(r3);     // Catch: Throwable -> L4
        r1.setAction(r4);     // Catch: Throwable -> L4
        List<ResolveInfo> r5 = r0.queryIntentServices(r1, 131072);     // Catch: Throwable -> L4
        o.e(r5, "mPkg.queryIntentServices…PackageManager.MATCH_ALL)");     // Catch: Throwable -> L4
        return !r5.isEmpty();
    L4:
        th = move-exception;
        com.obric.matrix.push.n.c.c.e(this.f9704b, "pass though support service error: " + th, null, 4, null);
        return false;
    }

    private final boolean k(String r7, String r8) {
        ProviderInfo[] r9 = com.bytedance.mpaas.app.a.b().getPackageManager().getPackageInfo(r7, 8).providers;     // Catch: Throwable -> L11
        o.e(r9, "mPackageInfo.providers");     // Catch: Throwable -> L11
        ArrayList r1 = new ArrayList();     // Catch: Throwable -> L11
        int r2 = r9.length;     // Catch: Throwable -> L11
        int r3 = 0;
    L4:
        if (r3 >= r2) goto L9;
        ProviderInfo r4 = r9[r3];     // Catch: Throwable -> L11
        if (o.a(r4.authority, r8) == false) goto L8;
        r1.add(r4);     // Catch: Throwable -> L11
    L8:
        r3 = r3 + 1;     // Catch: Throwable -> L11
        goto L4
    L9:
        return !r1.isEmpty();
    L11:
        th = move-exception;
        com.obric.matrix.push.n.c.c.e(this.f9704b, "pass though support provider error: " + th, null, 4, null);
        return false;
    }

    private final void l(g r3, int r4) {
        com.obric.matrix.push.m.d.c r2 = com.obric.matrix.push.m.b.f9633a.c();
        String r0 = r3.f9564f;
        o.e(r0, "push.id");
        String r5 = r3.f9565g;
        o.e(r5, "push.package_name");
        r2.d(r0, r5, r4);
    }

    static /* synthetic */ void m(e r0, g r1, int r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = com.obric.matrix.push.p.b.h0.Q();
    L5:
        r0.l(r1, r2);
    }

    private final void n(g r4, Application r5) {
        com.obric.matrix.push.n.c.c.i(this.f9704b, "pass though msg by binder");     // Catch: Throwable -> L4
        ArrayList<Object> r0 = new ArrayList();     // Catch: Throwable -> L4
        r0.add(r4.f9564f);     // Catch: Throwable -> L4
        r0.add(r4.f9569k);     // Catch: Throwable -> L4
        com.obric.matrix.push.n.b.d.c r6 = com.obric.matrix.push.n.a.f9741a.a(r5);     // Catch: Throwable -> L4
        String r7 = r4.f9565g;     // Catch: Throwable -> L4
        o.e(r7, "push.package_name");     // Catch: Throwable -> L4
        r6.b(r7, ".action.MESSAGE_EVENT", r0, null);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        com.obric.matrix.push.n.c.c.d(this.f9704b, "pass though aidl error: ", th);
    }

    private final void o(g r4, Application r5) {
        com.obric.matrix.push.n.c.c.i(this.f9704b, "pass though msg by broadcast");     // Catch: Throwable -> L4
        Intent r0 = new Intent();     // Catch: Throwable -> L4
        r0.setPackage(r4.f9565g);     // Catch: Throwable -> L4
        r0.setAction(r4.f9565g + ".action.MESSAGE_EVENT");     // Catch: Throwable -> L4
        r0.putExtra("pass_though_data", r4.f9569k);     // Catch: Throwable -> L4
        r0.putExtra("msg_id", r4.f9564f);     // Catch: Throwable -> L4
        r5.sendBroadcast(r0);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        com.obric.matrix.push.n.c.c.d(this.f9704b, "pass though broadcast error: ", th);
    }

    private final void p(Application r8, g r9) {
        ContentProviderClient r0 = null;
        Uri r1 = Uri.parse("content://" + r9.f9565g + ".push.provider");     // Catch: Throwable -> L6
        r0 = r8.getContentResolver().acquireUnstableContentProviderClient(r1);     // Catch: Throwable -> L6
        com.obric.matrix.push.n.c.c.i(this.f9704b, "pass though msg by provider");     // Catch: Throwable -> L6
        ContentResolver r10 = r8.getContentResolver();     // Catch: Throwable -> L6
        Bundle r4 = new Bundle();     // Catch: Throwable -> L6
        r4.putString("msg_id", r9.f9564f);     // Catch: Throwable -> L6
        r4.putString("pass_though_data", r9.f9569k);     // Catch: Throwable -> L6
        f0 r11 = f0.f18324a;     // Catch: Throwable -> L6
        r10.call(r1, ".action.MESSAGE_EVENT", "", r4);     // Catch: Throwable -> L6
        if (r0 == null) goto L10;
    L5:
        r0.close();
        return;
    L10:
        return;
    L6:
        th = move-exception;
        com.obric.matrix.push.n.c.c.d(this.f9704b, "pass though provider error: ", th);     // Catch: Throwable -> L11
        if (r0 != null) goto L5;
        return;
    L11:
        th = move-exception;
        if (r0 == null) goto L14;
        r0.close();
    L14:
        throw th;
    }

    @Override // com.obric.matrix.push.m.i.c
    public void a(String r2, String r3) {
        o.f(r2, "msgId");
        o.f(r3, "pkgName");
        j.f9798a.j(new c(r2, r3));
    }

    @Override // com.obric.matrix.push.m.i.c
    public void b() {
        if (this.f9703a != 0) goto L5;
        this.f9703a = com.obric.matrix.push.m.b.f9633a.B().a().c();
    L5:
        com.obric.matrix.push.n.c.c.b(this.f9704b, "handleExpiredHistoryMsg , lastDeDuplicationTimestamp is " + this.f9703a + " , System.currentTimeMillis() - lastDeDuplicationTimestamp is " + (System.currentTimeMillis() - this.f9703a));
        if ((System.currentTimeMillis() - this.f9703a) < com.obric.matrix.push.p.b.h0.r()) goto L9;
        com.obric.matrix.push.n.c.c.b(this.f9704b, "handleExpiredHistoryMsg , try delete expired history msg info");
        j.f9798a.j(new a(this));
        return;
    }

    @Override // com.obric.matrix.push.m.i.c
    public void c(String r2, String r3, Intent r4) {
        o.f(r2, "msgId");
        o.f(r3, "pkgName");
        j.f9798a.j(new b(r2, r3, r4));
    }

    @Override // com.obric.matrix.push.m.i.c
    public void d(g r13) {
        o.f(r13, "push");
        b();
        com.obric.matrix.push.m.i.a r0 = com.obric.matrix.push.m.i.a.f9696a;
        String r1 = r13.f9564f;
        o.e(r1, "push.id");
        com.obric.matrix.push.m.i.b r2 = r0.b(r1);
        if (r2 == null) goto L9;
        com.obric.matrix.push.n.c.c.b(this.f9704b, "historyMsgInfo is not null for " + r13.f9564f + " , historyMsgInfo.timeStamp is " + r2.a());
        if ((System.currentTimeMillis() - r2.a()) >= com.obric.matrix.push.p.b.h0.r()) goto L8;
        com.obric.matrix.push.n.c.c.e(this.f9704b, "on push repeated:" + r13.f9564f, null, 4, null);
        com.obric.matrix.push.m.d.c r12 = com.obric.matrix.push.m.b.f9633a.c();
        String r14 = r13.f9564f;
        o.e(r14, "push.id");
        r12.b(r14);
        return;
    L8:
        com.obric.matrix.push.n.c.c.b(this.f9704b, "historyMsgInfo is not null for " + r13.f9564f + " , and System.currentTimeMillis() - historyMsgInfo.timeStamp >= PushServiceConstants.MESSAGE_DEDUPLICATION_TIME_WINDOW_IN_MS");
    L9:
        com.obric.matrix.push.n.c.c.b(this.f9704b, "insert it to db");
        String r3 = r13.f9564f;
        o.e(r3, "push.id");
        r0.c(r3, System.currentTimeMillis());
        com.obric.matrix.push.r.e r4 = com.obric.matrix.push.r.e.f9794a;
        String r5 = r13.f9565g;
        o.e(r5, "push.package_name");
        if (r4.s(r5) == true) goto L13;
        com.obric.matrix.push.n.c.c.e(this.f9704b, "onHandler error, target pkg no exists, [" + r13.f9565g + ']', null, 4, null);
        l(r13, com.obric.matrix.push.p.b.h0.I());
        return;
    L13:
        Boolean r6 = r13.z;
        if (r6 != null) goto L16;
    L17:
        com.obric.matrix.push.m.f.b r7 = com.obric.matrix.push.m.b.f9633a.d();
        String r8 = r13.f9565g;
        o.e(r8, "push.package_name");
        if (r7.c(r8) == true) goto L22;
        com.obric.matrix.push.n.c.c.e(this.f9704b, "onHandler error, lack of token", null, 4, null);
        l(r13, com.obric.matrix.push.p.b.h0.J());
        return;
    L22:
        if (r13.H == null) goto L30;
        com.obric.matrix.push.m.h.a r9 = com.obric.matrix.push.m.b.f9633a.y();
        String r10 = r13.H.get("language");
        if (r10 != null) goto L27;
        r10 = "";
    L27:
        if (r9.a(r10) == true) goto L30;
        com.obric.matrix.push.n.c.c.e(this.f9704b, "onHandler error, language is not valid", null, 4, null);
        l(r13, com.obric.matrix.push.p.b.h0.H());
        return;
    L30:
        Map<String, String> r11 = r13.C;
        o.e(r11, "push.filter_rules");
        Iterator<Map.Entry<String, String>> r15 = r11.entrySet().iterator();
    L32:
        if (r15.hasNext() == false) goto L43;
        Map.Entry<String, String> r16 = r15.next();
        String r17 = r16.getKey();
        String r18 = r16.getValue();
        com.obric.matrix.push.p.b r19 = com.obric.matrix.push.p.b.h0;
        if (o.a(r17, r19.m()) == false) goto L32;
        com.obric.matrix.push.r.e r20 = com.obric.matrix.push.r.e.f9794a;     // Catch: Throwable -> L41
        String r21 = r13.f9565g;     // Catch: Throwable -> L41
        o.e(r21, "push.package_name");     // Catch: Throwable -> L41
        long r22 = r20.p(r21);     // Catch: Throwable -> L41
        JSONArray r23 = new JSONArray(r18);     // Catch: Throwable -> L41
        if (r22 < r23.getLong(0)) goto L39;
        if (r22 <= r23.getLong(1)) goto L32;
    L39:
        l(r13, r19.O());     // Catch: Throwable -> L41
        return;
    L41:
        l(r13, com.obric.matrix.push.p.b.h0.L());
        return;
    L43:
        Integer r24 = r13.f9568j;
        if (r24 == null) goto L86;
        com.obric.matrix.push.p.b r25 = com.obric.matrix.push.p.b.h0;
        int r26 = r25.y();
        if (r24 != null) goto L49;
    L51:
        Integer r27 = r13.f9568j;
        int r28 = r25.x();
        if (r27 != null) goto L55;
    L95:
        m(this, r13, 0, 2, null);
        return;
    L55:
        if (r27.intValue() != r28) goto L95;
        Application r29 = com.bytedance.mpaas.app.a.b();
        Integer r30 = r13.G;
        if (r30 == null) goto L65;
        if (r30 == null) goto L65;
        if (r30.intValue() != 1) goto L65;
        String r31 = r13.f9565g;
        o.e(r31, "push.package_name");
        if (k(r31, r13.f9565g + ".push.provider") == false) goto L65;
    L85:
        o.e(r29, "context");
        p(r29, r13);
    L65:
        Integer r32 = r13.G;
        if (r32 == null) goto L74;
        if (r32 == null) goto L74;
        if (r32.intValue() != 2) goto L74;
        String r33 = r13.f9565g;
        o.e(r33, "push.package_name");
        if (j(r33, r13.f9565g + ".action.CROSS_PROCESS") == false) goto L74;
        o.e(r29, "context");
        n(r13, r29);
    L74:
        Integer r34 = r13.G;
        if (r34 == null) goto L85;
        if (r34 == null) goto L85;
        if (r34.intValue() != 0) goto L85;
        if (i(r13, true) == false) goto L84;
        com.obric.matrix.push.n.c.c.i(this.f9704b, "handleInterceptor return true, this don't send to application ");
        l(r13, r25.K());
        return;
    L84:
        o.e(r29, "context");
        o(r13, r29);
        goto L95
    L49:
        if (r24.intValue() != r26) goto L51;
    L86:
        String r35 = r13.f9565g;
        o.e(r35, "push.package_name");
        Integer r36 = r13.A;
        o.e(r36, "push.notification_type");
        int r37 = f(r35, r36.intValue());
        if (r37 == 0) goto L91;
        com.obric.matrix.push.n.c.c.b(this.f9704b, "package = " + r13.f9565g + " notify " + r37 + " is close");
        l(r13, r37);
        return;
    L91:
        if (i(r13, false) == false) goto L94;
        com.obric.matrix.push.n.c.c.i(this.f9704b, "handleInterceptor return true, this don't show in notificaiton center ");
        l(r13, com.obric.matrix.push.p.b.h0.K());
        return;
    L94:
        com.obric.matrix.push.m.b.f9633a.v().a(r13);
        goto L95
    L16:
        if (r6.booleanValue() == true) goto L22;
        goto L17
    }

    public int f(String r4, int r5) {
        o.f(r4, "pkg");
        Application r0 = com.bytedance.mpaas.app.a.b();
        com.obric.matrix.push.m.k.b r1 = com.obric.matrix.push.m.k.b.f9715a;     // Catch: Throwable -> L11
        if (r1.a(r0, r4) == true) goto L8;
        return com.obric.matrix.push.p.b.h0.N();
    L8:
        if (r1.b(r0, r4, r5) == false) goto L10;
        return 0;
    L10:
        return com.obric.matrix.push.p.b.h0.M();
    L11:
        th = move-exception;
        com.obric.matrix.push.n.c.c.d(this.f9704b, "checkPackagePushEnable error ", th);
        return 0;
    }

    public boolean i(g r2, boolean r3) {
        o.f(r2, "push");
        if (r3 == false) goto L9;
        com.obric.matrix.push_api.d r1 = g(r2);
        if (r1 != null) goto L8;
        return false;
    L8:
        return com.obric.matrix.push.m.b.f9633a.x().a(r1);
    L9:
        com.obric.matrix.push_api.e r4 = h(r2);
        if (r4 != null) goto L13;
        return false;
    L13:
        return com.obric.matrix.push.m.b.f9633a.x().b(r4);
    }
}
