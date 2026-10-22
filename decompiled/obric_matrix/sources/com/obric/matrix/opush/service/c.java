package com.obric.matrix.opush.service;

import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import java.util.List;
import kotlin.Metadata;
import kotlin.i0.i;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/matrix/opush/service/BaseCrossProcessService;", "", "()V", "TAG", "", "mBinder", "Lcom/obric/matrix/push/common/cross_process/ICrossProcessInterface$Stub;", "onBind", "Landroid/os/IBinder;", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "resolveUserId", "", "callingUid", "o_push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f9446a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static com.obric.matrix.push.n.b.c.a f9447b;

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J9\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0010\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096\u0002¨\u0006\f"}, d2 = {"com/obric/matrix/opush/service/BaseCrossProcessService$onBind$1", "Lcom/obric/matrix/push/common/cross_process/ICrossProcessInterface$Stub;", "invoke", "", "method", "", "originPkgName", "args", "", "", "callback", "Lcom/obric/matrix/push/common/cross_process/ICrossProcessCallbackInterface;", "o_push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a extends com.obric.matrix.push.n.b.c.a {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Context f9448f;

        a(Context r1) {
            this.f9448f = r1;
        }

        @Override // com.obric.matrix.push.n.b.c
        public void d0(String r6, String r7, List<Object> r8, com.obric.matrix.push.n.b.b r9) {
            if (r6 == null) goto L19;
            Context r5 = this.f9448f;
            int r0 = Binder.getCallingUid();
            int r1 = c.a(c.f9446a, r0);
            if (r0 == 1000) goto L10;
            String[] r2 = r5.getPackageManager().getPackagesForUid(r0);
            if (r2 == null) goto L10;
            String r3 = (String) i.x(r2);
            if (r3 == null) goto L10;
        L12:
            if (o.a(r6, "register_channel") == false) goto L15;
            if (r8 == null) goto L15;
            r8.add(Integer.valueOf(r1));
        L15:
            com.obric.matrix.push.n.c.c.i("BaseCrossProcessSvc", "invoke method=" + r6 + ", callingUid=" + r0 + ", userId=" + r1 + ", originPkgName=" + r7 + ", realPkgName=" + r3);
            if (r3 == null) goto L20;
            com.obric.matrix.push.n.a.f9741a.a(r5).c(r6, r3, r8, r9);
            return;
        L20:
            return;
        L10:
            r3 = r7;
            goto L12
        }
    }

    static {
        f9446a = new c();
    }

    private c() {
    }

    public static final /* synthetic */ int a(c r0, int r1) {
        return r0.c(r1);
    }

    private final int c(int r6) {
        Object r0 = Class.forName("android.os.UserHandle").getMethod("getUserId", new Class[]{Integer.TYPE}).invoke(null, new Object[]{Integer.valueOf(r6)});     // Catch: Throwable -> L8
        if (r0 == null) goto L7;
        return ((Integer) r0).intValue();
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        com.obric.matrix.push.n.c.c.k("BaseCrossProcessSvc", "resolveUserId by reflection failed, fallback userId=0, callingUid=" + r6, th);
        return 0;
    }

    public final IBinder b(Context r1, Intent r2) {
        o.f(r1, "context");
        if (f9447b != null) goto L6;
        f9447b = new a(r1);
    L6:
        return f9447b;
    }
}
