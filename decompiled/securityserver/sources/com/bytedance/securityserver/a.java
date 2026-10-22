package com.bytedance.securityserver;

import android.app.Application;
import com.bytedance.securityserver.trustcircle.TrustCircleManager;
import com.bytedance.securityserver.trustcircle.account.AccountUtils;
import com.bytedance.securityserver.utils.NetworkMonitor;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements NetworkMonitor.NetworkTask, TrustCircleManager.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f38a;
    public final /* synthetic */ Object b;

    public /* synthetic */ a(Object r1, Object r2) {
        this.f38a = r1;
        this.b = r2;
    }

    @Override // com.bytedance.securityserver.utils.NetworkMonitor.NetworkTask
    public int a() {
        return SecurityAppDelegateImpl.a((SecurityAppDelegateImpl) this.f38a, (Application) this.b);
    }

    @Override // com.bytedance.securityserver.trustcircle.TrustCircleManager.Callback
    public void b(int r2) {
        Object r0 = AccountUtils.f72a;
        ((AtomicInteger) this.f38a).set(r2);
        ((CountDownLatch) this.b).countDown();
    }
}
