package y2;

import a3.f;
import android.content.Context;
import com.bytedance.ai.model.AppletJSModule;
import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.model.JSWorkerRuntime;
import com.bytedance.ai.utils.g;
import com.bytedance.ai.utils.h;
import com.bytedance.vmsdk.jsbridge.JSModuleManager;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap;
import com.bytedance.vmsdk.worker.JsWorker;
import com.lynx.jsbridge.LynxResourceModule;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JsWorker f23230b;

    public a(Context r5, JSWorkerRuntime r10) {
        Intrinsics.checkNotNullParameter(r5, "application");
        Intrinsics.checkNotNullParameter(r10, "runtime");
    L6:
        e = move-exception;
        throw new RuntimeException("Failed to initialize JSWorker", e);
    L4:
        if (JsWorker.isIsInitialised() == true) goto L8;
        JsWorker.initialize();     // Catch: Exception -> L6
    L8:
        JSModuleManager r11 = new JSModuleManager(r5);     // Catch: Exception -> L6
        r11.b(AppletJSModule.class, r10, AppletJSModule.NAME);     // Catch: Exception -> L6
        JsWorker.EngineType r12 = JsWorker.EngineType.QUICKJS;     // Catch: Exception -> L6
        com.bytedance.vmsdk.worker.a r13 = new com.bytedance.vmsdk.worker.a();     // Catch: Exception -> L6
        r13.f7563c = false;     // Catch: Exception -> L6
        r13.f7562b = "BotUI_Applet";     // Catch: Exception -> L6
        r13.d = r11;     // Catch: Exception -> L6
        r13.f7561a = r12;     // Catch: Exception -> L6
        r13.f7563c = s0.c.f21802b;     // Catch: Exception -> L6
        com.bytedance.vmsdk.worker.b r14 = new com.bytedance.vmsdk.worker.b(r13);     // Catch: Exception -> L6
        Intrinsics.checkNotNull(r14);     // Catch: Exception -> L6
        Intrinsics.checkNotNullParameter(r14, LynxResourceModule.PARAMS_KEY);     // Catch: Exception -> L6
        JsWorker r15 = new JsWorker(r14);     // Catch: Exception -> L6
        JavaOnlyMap r16 = new JavaOnlyMap();     // Catch: Exception -> L6
        r16.put("__AI_SDK_VERSION__", "0.90.0-rc.37-miniapp");     // Catch: Exception -> L6
        r15.setGlobalProperties(r16);     // Catch: Exception -> L6
        this.f23234a = true;     // Catch: Exception -> L6
        this.f23230b = r15;
    }

    @Override // y2.e
    public final void a() {
        this.f23234a = false;
        this.f23230b.terminate();
    }

    @Override // y2.e
    public final void b(h r5, String r10, f r11, a2.c r12) {
        Intrinsics.checkNotNullParameter(r5, "script");
        Intrinsics.checkNotNullParameter(r10, "url");
        Intrinsics.checkNotNullParameter(r11, "onSuccess");
        Intrinsics.checkNotNullParameter(r12, "onFailure");
        if (this.f23234a == false) goto L8;
        String r13 = ((g) r5).f2850a;
        JsWorker r14 = this.f23230b;
        r14.evaluateJavaScript(r13, r10);
        Ref.BooleanRef r15 = new Ref.BooleanRef();
        r15.element = true;
        r14.setOnErrorCallback(new com.lynx.animax.a(3, r12, r15));
        if (r15.element == false) goto L10;
        int r16 = AppletRuntime.f2196x;
        Unit r17 = Unit.INSTANCE;
        return;
    L10:
        return;
    L8:
        r12.invoke("JSWorker not initialized");
        throw new IllegalStateException("JSWorker not initialized");
    }

    @Override // y2.e
    public final void c(JavaOnlyMap r5) {
        Intrinsics.checkNotNullParameter(r5, "param");
        kh.b r10 = new kh.b(9, this, r5);
        this.f23230b.postOnJSRunner(r10);
    }

    @Override // y2.e
    public final void d(Function0 r5) {
        Intrinsics.checkNotNullParameter(r5, "block");
        a3.g r10 = new a3.g(4, r5);
        this.f23230b.postOnWorkerRunner(r10);
    }

    @Override // y2.e
    public final String e() {
        return String.valueOf(this.f23230b.id());
    }
}
