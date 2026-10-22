package y2;

import a3.f;
import android.content.Context;
import com.bytedance.ai.lynx.l;
import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.model.LynxWorkerRuntime;
import com.bytedance.ai.utils.g;
import com.bytedance.ai.utils.h;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap;
import com.lynx.tasm.LynxBackgroundRuntime;
import com.lynx.tasm.k;
import com.lynx.tasm.u;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LynxBackgroundRuntime f23231b;

    public b(Context r5, LynxWorkerRuntime r10, u r11) {
        Intrinsics.checkNotNullParameter(r5, "application");
        Intrinsics.checkNotNullParameter(r10, "runtime");
        Intrinsics.checkNotNullParameter(r11, "lynxGroup");
        k r12 = new k();
        r12.f10894c = r11;
        r12.f10895h = new l(r5);
        LynxBackgroundRuntime r13 = new LynxBackgroundRuntime(r5, r12);
        this.f23234a = true;
        this.f23231b = r13;
    }

    @Override // y2.e
    public final void a() {
        this.f23234a = false;
        this.f23231b.a();
    }

    @Override // y2.e
    public final void b(h r5, String r10, f r11, a2.c r12) {
        Intrinsics.checkNotNullParameter(r5, "script");
        Intrinsics.checkNotNullParameter(r10, "url");
        Intrinsics.checkNotNullParameter(r11, "onSuccess");
        Intrinsics.checkNotNullParameter(r12, "onFailure");
        if (this.f23234a == true) goto L5;
        r12.invoke("JSWorker not initialized");
        throw new IllegalStateException("JSWorker not initialized");
    L5:
        if (StringsKt.P(r10, "/") == true) goto L8;
        r10 = td.d.b("/", r10);
    L8:
        String r13 = ((g) r5).f2850a;
        this.f23231b.c(r10, r13);
        int r14 = AppletRuntime.f2196x;
        Unit r15 = Unit.INSTANCE;
    }

    @Override // y2.e
    public final void c(JavaOnlyMap r5) {
        Intrinsics.checkNotNullParameter(r5, "param");
    }

    @Override // y2.e
    public final void d(Function0 r5) {
        Intrinsics.checkNotNullParameter(r5, "block");
        r5.invoke();
    }

    @Override // y2.e
    public final String e() {
        return String.valueOf(this.f23231b.hashCode());
    }
}
