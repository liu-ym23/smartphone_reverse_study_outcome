package y2;

import a3.f;
import android.content.Context;
import com.bytedance.ai.model.widgets.m;
import com.bytedance.ai.settings.AISDKSettingConfigManager;
import com.bytedance.ai.utils.h;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap;
import com.relax.BackendWorker;
import com.relax.RelaxEnv;
import com.relax.RuntimeType;
import com.relax.loader.RelaxLibraryLoader;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f23232c = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BackendWorker f23233b;

    static {
        f23232c = LazyKt.a(new s1.b(5));
    }

    public d(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "application");
        this.f23233b = i();
    }

    public static final void g(d r5, h r10, String r11, f r12, a2.c r13) {
        BackendWorker r14 = r5.f23233b;
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type com.bytedance.ai.utils.ResponseData.BinaryResponse");
        if (r14.loadFile(((com.bytedance.ai.utils.f) r10).f2849a, r11) == false) goto L6;
        r12.invoke();
        return;
    L6:
        r13.invoke("Failed load");
    }

    public static final void h(d r5, String r10) {
        r5.f23233b.callRTSFunction("onMessage", r10);
    }

    public static final Unit j() {
        RelaxLibraryLoader.startLoadLibrary();
        RelaxEnv.inst().setRenderType(c3.e.a(AISDKSettingConfigManager.INSTANCE.getRELAX_CONFIG().getValue().c()));
        return Unit.INSTANCE;
    }

    @Override // y2.e
    public final void a() {
        this.f23234a = false;
        this.f23233b.destroy();
    }

    @Override // y2.e
    public final void b(h r10, String r11, f r12, a2.c r13) {
        Intrinsics.checkNotNullParameter(r10, "script");
        Intrinsics.checkNotNullParameter(r11, "url");
        Intrinsics.checkNotNullParameter(r12, "onSuccess");
        Intrinsics.checkNotNullParameter(r13, "onFailure");
        if (this.f23234a == true) goto L8;
        Intrinsics.checkNotNullParameter("WorkerRuntime", "tag");
        t0.d r14 = com.bytedance.ai.utils.c.f2846a;
        if (r14 == null) goto L10;
        r14.d("WorkerRuntime", "evaluateScript Failed by RelaxWorker isn't initialized");
        return;
    L10:
        return;
    L8:
        this.f23233b.setErrorReceiver(new c());
        this.f23233b.executeOnWorker(new m(this, r10, r11, r12, r13, 6));
    }

    @Override // y2.e
    public final void c(JavaOnlyMap r5) {
        Intrinsics.checkNotNullParameter(r5, "param");
        f(z0.c.c(r5));
    }

    @Override // y2.e
    public final void d(Function0 r5) {
        Intrinsics.checkNotNullParameter(r5, "block");
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L5
        r5.invoke();     // Catch: Throwable -> L5
        Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
    }

    @Override // y2.e
    public final String e() {
        return String.valueOf(this.f23233b.hashCode());
    }

    public final void f(String r5) {
        Intrinsics.checkNotNullParameter(r5, "param");
        if (this.f23234a == true) goto L8;
        Intrinsics.checkNotNullParameter("WorkerRuntime", "tag");
        t0.d r10 = com.bytedance.ai.utils.c.f2846a;
        if (r10 == null) goto L10;
        r10.d("WorkerRuntime", "sendToWorkerJS Failed by RelaxWorker isn't initialized");
        return;
    L10:
        return;
    L8:
        this.f23233b.executeOnWorker(new kh.b(10, this, r5));
    }

    public final BackendWorker i() {
        f23232c.getValue();     // Catch: Exception -> L4
        Unit r5 = Unit.INSTANCE;     // Catch: Exception -> L4
        BackendWorker r10 = new BackendWorker(true, RuntimeType.RuntimeTypeVM);     // Catch: Exception -> L4
        this.f23234a = true;     // Catch: Exception -> L4
        return r10;
    L4:
        e = move-exception;
        throw new RuntimeException("Failed to initialize RelaxWorker", e);
    }
}
