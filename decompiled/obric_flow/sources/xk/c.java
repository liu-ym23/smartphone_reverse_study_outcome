package xk;

import android.os.Handler;
import android.os.SystemClock;
import com.bytedance.ies.bullet.kit.web.SSWebView;
import com.bytedance.ies.web.jsbridge2.i;
import java.lang.ref.SoftReference;
import kotlin.jvm.internal.Intrinsics;
import zm.z;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SoftReference f23157a;

    public c(SSWebView r5) {
        this.f23157a = new SoftReference(r5);
    }

    public static int e(c r5, int r10) {
        r5.getClass();
        if (r10 != 1) goto L5;
        return 1;
    L5:
        if (r10 == 2) goto L9;
        return 3;
    L9:
        return 2;
    }

    @Override // com.bytedance.ies.web.jsbridge2.i
    public final void a(int r5, String r10) {
        SystemClock.elapsedRealtime();
        Handler r11 = com.bytedance.android.monitorV2.executor.b.f3573a;
        a7.a r12 = new a7.a(this, r10, r5);
        Intrinsics.checkNotNullParameter(r12, "runnable");
        com.bytedance.android.monitorV2.executor.b.a().execute(new c1.a(r12, 2));
    }

    @Override // com.bytedance.ies.web.jsbridge2.i
    public final void b(int r5, String r10) {
        a(r5, r10);
    }

    @Override // com.bytedance.ies.web.jsbridge2.i
    public final void c(String r10, z r11) {
        long r5 = SystemClock.elapsedRealtime();
        Handler r12 = com.bytedance.android.monitorV2.executor.b.f3573a;
        a r13 = new a(this, r10, r11, r5);
        Intrinsics.checkNotNullParameter(r13, "runnable");
        com.bytedance.android.monitorV2.executor.b.a().execute(new c1.a(r13, 2));
    }

    @Override // com.bytedance.ies.web.jsbridge2.i
    public final void d(String r10, String r11, int r12, String r13, z r14) {
        long r15 = SystemClock.elapsedRealtime();
        Handler r16 = com.bytedance.android.monitorV2.executor.b.f3573a;
        b r17 = new b(this, r11, r14, r12, r13, r15);
        Intrinsics.checkNotNullParameter(r17, "runnable");
        com.bytedance.android.monitorV2.executor.b.a().execute(new c1.a(r17, 2));
    }
}
