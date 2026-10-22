package rh;

import ai.j0;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.pia.core.api.bridge.PiaMethod$Error;
import com.bytedance.pia.core.api.bridge.PiaMethod$SettingDisableError;
import com.bytedance.pia.core.api.services.IPiaWorkerService$NoJSRuntimeException;
import com.bytedance.pia.core.setting.Settings;
import com.bytedance.pia.core.tracing.EventName;
import com.bytedance.pia.core.utils.j;
import com.bytedance.pia.core.utils.m;
import com.bytedance.pia.core.worker.Worker$Status;
import com.bytedance.pia.core.worker.binding.BaseModule;
import com.bytedance.pia.core.worker.network.WorkerDelegate;
import com.bytedance.vmsdk.jsbridge.JSModuleManager;
import com.bytedance.vmsdk.monitor.VmSdkMonitor;
import com.bytedance.vmsdk.worker.JsWorker;
import com.google.common.reflect.w;
import com.google.gson.JsonObject;
import com.lynx.tasm.p;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class i implements fh.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.pia.core.utils.a f21761b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.pia.core.utils.a f21762c;
    public final com.bytedance.pia.core.utils.a d;
    public final com.bytedance.pia.core.utils.a e;
    public final BaseModule f;
    public final String g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f21763h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Uri f21764i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f21765j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Uri f21766k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final com.bytedance.pia.core.utils.f f21767l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f21768m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final JsWorker f21769n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final JSModuleManager f21770o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Map f21771p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final gh.c f21772q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final nh.d f21773r;
    public final fh.a s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public fh.c f21774t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Worker$Status f21775u;

    public i(g r19) {
        this.f21761b = new com.bytedance.pia.core.utils.a();
        com.bytedance.pia.core.utils.a r5 = new com.bytedance.pia.core.utils.a();
        this.f21762c = r5;
        this.d = new com.bytedance.pia.core.utils.a();
        this.e = new com.bytedance.pia.core.utils.a();
        r19.f21752a.f20246q.a("initialize_worker.start", System.currentTimeMillis());
        Lazy r10 = Settings.B;
        if (p.a().x() == true) goto L5;
        r19.f21752a.f20239j.b(-1, "worker", "");
        throw new PiaMethod$SettingDisableError();
    L5:
        if (TextUtils.isEmpty(r19.f21753b) == false) goto L7;
        this.g = "Worker";
    L8:
        String r11 = j0.q(new StringBuilder("["), this.g, "] ");
        this.f21763h = r11;
        nh.d r12 = r19.f21752a;
        this.f21773r = r12;
        a(EventName.f7092b).a();
    L14:
        th = move-exception;
        String r13 = this.f21763h + " Worker create failed (Reason: " + th + ")";     // Catch: Throwable -> L56
        Intrinsics.checkNotNullParameter(r13, "message");     // Catch: Throwable -> L56
        j.w(4, r13, th);     // Catch: Throwable -> L56
        throw th;     // Catch: Throwable -> L56
    L56:
        th = move-exception;
        a(EventName.f7093c).a();
        r19.f21752a.f20246q.a("initialize_worker.end", System.currentTimeMillis());
        throw th;
    L10:
        if (TextUtils.isEmpty(r19.f21754c) == false) goto L12;
        r19.f21752a.f20239j.b(-2, "worker", "script url is empty.");     // Catch: Throwable -> L14
        throw new PiaMethod$Error(-10001);     // Catch: Throwable -> L14
    L12:
        if (r19.f21754c.startsWith("javascript:") == false) goto L16;
        String r14 = r19.f21754c.substring(11);     // Catch: Throwable -> L14
        this.f21764i = Uri.EMPTY;     // Catch: Throwable -> L14
    L17:
        JsWorker.EngineType r15 = JsWorker.EngineType.QUICKJS;     // Catch: Throwable -> L14
        AtomicBoolean r16 = h.f21759a;     // Catch: Throwable -> L14
        monitor-enter(b.class);     // Catch: Throwable -> L14
        monitor-exit(b.class);     // Catch: Throwable -> L14
        boolean r17 = false;
        r12.f20246q.f18645b.a("pia_is_warmup", 0);     // Catch: Throwable -> L14
        JSModuleManager r18 = new JSModuleManager(nh.d.E);     // Catch: Throwable -> L14
        this.f21770o = r18;     // Catch: Throwable -> L14
        this.f21769n = new JsWorker(r18, r15, null, false, "PIA");     // Catch: Throwable -> L46
    L67:
        new JSONObject().put("use_vmsdk_worker", Boolean.TRUE);     // Catch: Throwable -> L24
        VmSdkMonitor.a();     // Catch: Throwable -> L24
        throw null;     // Catch: Throwable -> L24
    L24:
        this.f21766k = r19.d;     // Catch: Throwable -> L14
        this.f21767l = r19.e;     // Catch: Throwable -> L14
        this.f21765j = r14;     // Catch: Throwable -> L14
        this.s = r19.f21755h;     // Catch: Throwable -> L14
        this.f21771p = r19.f21758k;     // Catch: Throwable -> L14
        this.f21775u = Worker$Status.f7162a;     // Catch: Throwable -> L14
        StringBuilder r20 = new StringBuilder();     // Catch: Throwable -> L14
        r20.append(r12.f20242m);     // Catch: Throwable -> L14
        r20.append("PIANativeWorker ");     // Catch: Throwable -> L14
        if (r19.f21756i == false) goto L27;
        r20.append(" PIAWarmup");     // Catch: Throwable -> L14
    L27:
        String r21 = r20.toString();     // Catch: Throwable -> L14
        this.f21768m = r21;     // Catch: Throwable -> L14
        gh.c r22 = r19.f;     // Catch: Throwable -> L14
        this.f21772q = r22;     // Catch: Throwable -> L14
        m.b(new a2.b(21, r22, new ym.p(this)));     // Catch: Throwable -> L14
        this.f21770o.b(BaseModule.class, this, BaseModule.NAME);     // Catch: Throwable -> L14
        BaseModule r23 = (BaseModule) this.f21770o.a(BaseModule.NAME).getModule();     // Catch: Throwable -> L14
        this.f = r23;     // Catch: Throwable -> L14
        r23.setMessageHandle(new d(this, 2));     // Catch: Throwable -> L14
        r23.setBridgeMessageHandle(new d(this, 3));     // Catch: Throwable -> L14
        if (r19.f21757j == false) goto L35;
        String r24 = a.f21738a;     // Catch: Throwable -> L14
        if (TextUtils.isEmpty(r24) == true) goto L32;
        this.f21769n.evaluateJavaScript(r24);     // Catch: Throwable -> L14
        goto L35
    L32:
        r19.f21752a.f20239j.b(-4, "worker", "");     // Catch: Throwable -> L14
        throw new RuntimeException("Polyfill load failed!");     // Catch: Throwable -> L14
    L35:
        if (p.a().v() == false) goto L40;
        com.bytedance.ai.resource.core.net.a r25 = r19.g;     // Catch: Throwable -> L14
        if (r25 == null) goto L39;
        this.f21769n.setWorkerDelegate(new WorkerDelegate(r11, r21, r25, r19.e));     // Catch: Throwable -> L14
        j.A(r11.concat("Initialize Fetch-API successfully"));     // Catch: Throwable -> L14
        goto L40
    L39:
        j.s(r11 + "Initialize Fetch-API failed (Reason: 'Retrofit is null')");     // Catch: Throwable -> L14
    L40:
        this.f21769n.setOnErrorCallback(new com.lynx.animax.a(2, this, r19));     // Catch: Throwable -> L14
        this.f21769n.setOnMessageCallback(new androidx.core.view.inputmethod.a(r5, 15));     // Catch: Throwable -> L14
        j.A(r11 + "Worker create successfully (URL: " + r19.d + ")");     // Catch: Throwable -> L14
        StringBuilder r26 = new StringBuilder();     // Catch: Throwable -> L14
        r26.append(r11);     // Catch: Throwable -> L14
        r26.append("Create PIA worker (UserAgent: '");     // Catch: Throwable -> L14
        r26.append(r21);     // Catch: Throwable -> L14
        r26.append("', RuntimeType: ");     // Catch: Throwable -> L14
        r26.append(r15);     // Catch: Throwable -> L14
        r26.append(", URL: ");     // Catch: Throwable -> L14
        r26.append(this.f21764i);     // Catch: Throwable -> L14
        r26.append(", Debuggable: ");     // Catch: Throwable -> L14
        if (r15 != JsWorker.EngineType.V8) goto L43;
        r17 = true;
    L43:
        r26.append(r17);     // Catch: Throwable -> L14
        r26.append(")");     // Catch: Throwable -> L14
        j.A(r26.toString());     // Catch: Throwable -> L14
        a(EventName.f7093c).a();
        r19.f21752a.f20246q.a("initialize_worker.end", System.currentTimeMillis());
        return;
    L46:
        th = move-exception;
        new JSONObject().put("use_vmsdk_worker", Boolean.FALSE);     // Catch: Throwable -> L50
        VmSdkMonitor.a();     // Catch: Throwable -> L50
        throw null;     // Catch: Throwable -> L50
    L50:
        r19.f21752a.f20239j.b(-3, "worker", Log.getStackTraceString(th));     // Catch: Throwable -> L14
        throw new IPiaWorkerService$NoJSRuntimeException(th);     // Catch: Throwable -> L14
    L16:
        this.f21764i = Uri.parse(r19.f21754c);     // Catch: Throwable -> L14
        r14 = null;
        goto L17
    L7:
        this.g = r19.f21753b;
        goto L8
    }

    public final com.bytedance.pia.core.tracing.d a(EventName r10) {
        nh.d r5 = this.f21773r;
        w r11 = r5.f20247r;
        r11.getClass();
        com.bytedance.pia.core.tracing.d r12 = new com.bytedance.pia.core.tracing.d(r11, r10, System.currentTimeMillis());
        r5.getClass();
        r12.d.put("worker", hashCode() + String.valueOf(r5.hashCode()));
        return r12;
    }

    public final void b(JsonObject r5) {
        if (e() == true) goto L5;
        return;
    L5:
        fh.a r10 = this.s;
        if (r10 == null) goto L8;
        r10.accept(r5);
    L8:
        j.A(this.f21763h + "PIA worker was terminated (URL: " + this.f21766k + ")");
        fh.c r11 = this.f21774t;
        if (r11 == null) goto L11;
        r11.release();
        this.f21774t = null;
    L11:
        this.f21775u = Worker$Status.d;
        gh.c r12 = this.f21772q;
        r12.getClass();
        m.b(new com.obric.oui.lisitem.a(r12, 7));
        this.f21769n.terminate();
    }

    public final void c(fh.a r5) {
        e r10 = new e(this, r5, 0);
        this.f21761b.b(r10);
    }

    public final void d(String r5, Boolean r10) {
        this.f21773r.f20246q.a("request_worker.end", System.currentTimeMillis());
        StringBuilder r11 = new StringBuilder();
        r11.append(this.f21763h);
        r11.append("PIA worker fetches script successfully(URL: ");
        Uri r12 = this.f21764i;
        r11.append(r12);
        r11.append(", Mode: ");
        if (r10.booleanValue() == false) goto L5;
        String r13 = "Offline";
    L6:
        r11.append(r13);
        r11.append(")");
        j.A(r11.toString());
        com.bytedance.pia.core.tracing.d r14 = a(EventName.e);
        String r15 = r12.toString();
        r14.d.put("url", r15);
        r14.d.put("flag", "success");
        if (r10.booleanValue() == false) goto L9;
        String r16 = "offline";
    L10:
        r14.d.put("mode", r16);
        r14.d.put("f", 1);
        Integer r17 = Integer.valueOf(r10.booleanValue() ? 1 : 0);
        r14.d.put("m", r17);
        r14.a();
        ((Handler) m.f7156b.getValue()).post(new kh.b(7, this, r5));
        return;
    L9:
        r16 = "online";
        goto L10
    L5:
        r13 = "Network";
        goto L6
    }

    public final boolean e() {
        if (this.f21775u != Worker$Status.d) goto L5;
        return false;
    L5:
        if (this.f21769n.isRunning() == false) goto L10;
        return true;
    L10:
        return false;
    }

    public final void f(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L6;
        return;
    L6:
        if (e() == false) goto L9;
        this.f21769n.evaluateJavaScript(r5);
        return;
    }

    public final void g(Throwable r10) {
        nh.d r5 = this.f21773r;
        r5.f20246q.a("request_worker.end", System.currentTimeMillis());
        kh.c r11 = r5.f20239j;
        StringBuilder r12 = new StringBuilder("url=");
        Uri r13 = this.f21764i;
        r12.append(r13);
        r12.append(", error=");
        r12.append(Log.getStackTraceString(r10));
        r11.b(-6, "worker", r12.toString());
        String r14 = this.f21763h + "PIA worker fails to fetch script(URL:" + r13 + ", Reason: " + r10 + ")";
        Intrinsics.checkNotNullParameter(r14, "message");
        j.w(4, r14, r10);
        this.f21775u = Worker$Status.d;
        com.bytedance.pia.core.tracing.d r15 = a(EventName.e);
        r15.d.put("url", r13.toString());
        r15.d.put("flag", MessageIndication.STATUS_FAILED);
        r15.d.put("mode", "online");
        r15.d.put("f", 0);
        r15.d.put("m", 0);
        r15.a();
        ((Handler) m.f7156b.getValue()).post(new kh.b(8, this, r10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void h() {
        boolean r5 = false;
        Object[] r10 = 0;
        this.f21773r.f20246q.a("request_worker.start", System.currentTimeMillis());
        AtomicBoolean r11 = h.f21759a;
        if (this.f21775u == Worker$Status.f7162a) goto L5;
        return;
    L5:
        this.f21775u = Worker$Status.f7163b;
        com.bytedance.pia.core.tracing.d r12 = a(EventName.d);
        String r13 = this.f21764i.toString();
        r12.d.put("url", r13);
        w r14 = r12.f;
        r14.getClass();
        m.b(new com.bytedance.pia.core.tracing.c(r14, r12, r5));
        String r15 = this.f21765j;
        if (r15 == null) goto L9;
        d(r15, Boolean.TRUE);
        return;
    L9:
        androidx.core.view.inputmethod.a r16 = new androidx.core.view.inputmethod.a(this, 13);
        d r17 = new d(this, r10 == true ? 1 : 0);
        d r18 = new d(this, 1);
        this.f21774t = this.f21767l.a(r16, r17, r18);
    }

    @Override // fh.c
    public final void release() {
        b(null);
    }
}
