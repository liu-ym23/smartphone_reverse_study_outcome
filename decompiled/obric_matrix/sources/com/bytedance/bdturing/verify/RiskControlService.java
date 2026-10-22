package com.bytedance.bdturing.verify;

import android.app.Activity;
import android.content.DialogInterface;
import com.bytedance.bdturing.c;
import com.bytedance.bdturing.e;
import com.bytedance.bdturing.p;
import com.bytedance.bdturing.v.g;
import com.bytedance.bdturing.v.h;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0011J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/bytedance/bdturing/verify/RiskControlService;", "Lcom/bytedance/bdturing/verify/a;", "", "verifyType", "", "isProcess", "(I)Z", "Lcom/bytedance/bdturing/verify/b/a;", "request", "Lcom/bytedance/bdturing/c;", "callback", "execute", "(Lcom/bytedance/bdturing/verify/b/a;Lcom/bytedance/bdturing/c;)Z", "isOnVerify", "()Z", "Lkotlin/f0;", "dismissVerifyDialog", "()V", "Lcom/bytedance/bdturing/p;", "mDialogShowing", "Lcom/bytedance/bdturing/p;", "<init>", "BdTuringSdk_cnRelease"}, k = 1, mv = {1, 1, 15})
public final class RiskControlService implements com.bytedance.bdturing.verify.a {
    private p mDialogShowing;

    public static final class a implements g.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ RiskControlService f3218a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.bytedance.bdturing.verify.b.a f3219b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ c f3220c;

        /* JADX INFO: renamed from: com.bytedance.bdturing.verify.RiskControlService$a$a, reason: collision with other inner class name */
        static final class RunnableC0088a implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ a f3221f;

            /* JADX INFO: renamed from: com.bytedance.bdturing.verify.RiskControlService$a$a$a, reason: collision with other inner class name */
            static final class DialogInterfaceOnDismissListenerC0089a implements DialogInterface.OnDismissListener {

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                final /* synthetic */ RunnableC0088a f3222f;

                DialogInterfaceOnDismissListenerC0089a(RunnableC0088a r1) {
                    this.f3222f = r1;
                }

                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface r2) {
                    if (r2 != RiskControlService.access$getMDialogShowing$p(this.f3222f.f3221f.f3218a)) goto L6;
                    RiskControlService.access$setMDialogShowing$p(this.f3222f.f3221f.f3218a, null);
                    return;
                }
            }

            RunnableC0088a(a r1) {
                this.f3221f = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                e.u();
                RiskControlService r0 = this.f3221f.f3218a;
                a r2 = this.f3221f;
                RiskControlService.access$setMDialogShowing$p(r0, new p(r2.f3219b, r2.f3220c));
                p r1 = RiskControlService.access$getMDialogShowing$p(this.f3221f.f3218a);
                if (r1 == null) goto L5;
                r1.setOnDismissListener(new DialogInterfaceOnDismissListenerC0089a(this));
            L5:
                p r4 = RiskControlService.access$getMDialogShowing$p(this.f3221f.f3218a);
                if (r4 == null) goto L8;
                r4.show();
            L8:
                e.k();
            }
        }

        a(RiskControlService r1, com.bytedance.bdturing.verify.b.a r2, c r3) {
            this.f3218a = r1;
            this.f3219b = r2;
            this.f3220c = r3;
        }

        @Override // com.bytedance.bdturing.v.g.a
        public void a(int r1, String r2, long r3) {
            Activity r4 = this.f3219b.b();
            if (r4 != null) goto L5;
        L7:
            Activity r5 = this.f3219b.b();
            if (r5 == null) goto L11;
            r5.runOnUiThread(new RunnableC0088a(this));
            return;
        L11:
            return;
        L5:
            if (r4.isFinishing() != true) goto L7;
        }
    }

    public RiskControlService() {
    }

    public static final /* synthetic */ p access$getMDialogShowing$p(RiskControlService r0) {
        return r0.mDialogShowing;
    }

    public static final /* synthetic */ void access$setMDialogShowing$p(RiskControlService r0, p r1) {
        r0.mDialogShowing = r1;
    }

    public final void dismissVerifyDialog() {
        p r0 = this.mDialogShowing;     // Catch: Exception -> L15
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0 != null) goto L7;
        o.p();     // Catch: Exception -> L15
        throw null;
    L7:
        if (r0.isShowing() == false) goto L19;
        p r2 = this.mDialogShowing;     // Catch: Exception -> L15
        if (r2 == null) goto L11;
        r2.dismiss();     // Catch: Exception -> L15
        return;
    L11:
        o.p();     // Catch: Exception -> L15
        throw null;
    L19:
        return;
    L15:
        com.bytedance.bdturing.g.f("BdTuring", "an exception caught in the stage of VerifyDialog dismissing.");
    }

    @Override // com.bytedance.bdturing.verify.a
    public boolean execute(com.bytedance.bdturing.verify.b.a r5, c r6) {
        o.g(r5, "request");
        o.g(r6, "callback");
        if (isOnVerify() == false) goto L6;
        com.bytedance.bdturing.g.c("BdTuring", "verifyDialog still showing skip this request");
        r6.a(998, null);
        return true;
    L6:
        h.f3217l.x(false, new a(this, r5, r6));
        return true;
    }

    public final synchronized boolean isOnVerify() {
        monitor-enter(this);
        p r0 = this.mDialogShowing;     // Catch: Throwable -> L15
        if (r0 == null) goto L12;
        if (r0 != null) goto L7;
        o.p();     // Catch: Throwable -> L15
        throw null;
    L7:
        if (r0.isShowing() == false) goto L12;
        boolean r1 = true;
    L13:
        monitor-exit(this);
        return r1;
    L12:
        r1 = false;
    L15:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.bdturing.verify.a
    public boolean isProcess(int r2) {
        if (r2 != 1) goto L5;
        return true;
    L5:
        if (r2 != 2) goto L7;
        return true;
    L7:
        if (r2 != 3) goto L9;
        return true;
    L9:
        if (r2 != 5) goto L11;
        return true;
    L11:
        if (r2 == 12) goto L18;
        return false;
    L18:
        return true;
    }
}
