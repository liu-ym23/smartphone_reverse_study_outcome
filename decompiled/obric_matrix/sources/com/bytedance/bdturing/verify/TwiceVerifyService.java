package com.bytedance.bdturing.verify;

import androidx.annotation.NonNull;
import com.bytedance.bdturing.e;
import com.bytedance.bdturing.twiceverify.c;

/* JADX INFO: loaded from: classes.dex */
public class TwiceVerifyService implements com.bytedance.bdturing.verify.a {
    private boolean isOnVerify;

    class a implements c.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.bytedance.bdturing.c f3223a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ TwiceVerifyService f3224b;

        a(TwiceVerifyService r1, com.bytedance.bdturing.c r2) {
            this.f3224b = r1;
            this.f3223a = r2;
        }

        @Override // com.bytedance.bdturing.twiceverify.c.b
        public void a(int r2, String r3) {
            this.f3224b.setOnVerify(false);
            this.f3223a.a(r2, null);
        }

        @Override // com.bytedance.bdturing.twiceverify.c.b
        public void onSuccess() {
            this.f3224b.setOnVerify(false);
            this.f3223a.b(0, null);
        }
    }

    public TwiceVerifyService() {
    }

    @Override // com.bytedance.bdturing.verify.a
    public boolean execute(@NonNull com.bytedance.bdturing.verify.b.a r5, @NonNull com.bytedance.bdturing.c r6) {
        if (c.d().a() == true) goto L6;
        return false;
    L6:
        setOnVerify(true);
        e.u();
        c.d().i(r5, null, new a(this, r6));
        return true;
    }

    public synchronized boolean isOnVerify() {
        monitor-enter(this);
        boolean r0 = this.isOnVerify;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.bdturing.verify.a
    public boolean isProcess(int r1) {
        switch(r1) {
            case 6: goto L5;
            case 7: goto L5;
            case 8: goto L5;
            case 9: goto L5;
            case 10: goto L5;
            case 11: goto L5;
            case 12: goto L3;
            case 13: goto L5;
            default: goto L3;
        };
    L3:
        return false;
    L5:
        return true;
    }

    public synchronized void setOnVerify(boolean r1) {
        monitor-enter(this);
        this.isOnVerify = r1;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
