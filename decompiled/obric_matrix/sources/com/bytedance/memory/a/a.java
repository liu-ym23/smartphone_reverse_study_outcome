package com.bytedance.memory.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.crash.Npth;
import com.bytedance.memory.b.d;
import com.bytedance.memory.b.e;
import com.bytedance.memory.b.g;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static volatile a f4985h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f4986a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.bytedance.memory.f.a f4987b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f4988c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile boolean f4989d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.bytedance.memory.b.a f4990e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile boolean f4991f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile boolean f4992g;

    /* JADX INFO: renamed from: com.bytedance.memory.a.a$a, reason: collision with other inner class name */
    class C0153a implements com.bytedance.memory.b.a {
        C0153a(a r1) {
        }

        @Override // com.bytedance.memory.b.a
        public boolean a() {
            return a.l().i();
        }

        @Override // com.bytedance.memory.b.a
        public boolean b() {
            if (a.l().i() == false) goto L5;
        L7:
            return false;
        L5:
            if (com.bytedance.memory.heap.a.o().v() == false) goto L7;
            return true;
        }

        @Override // com.bytedance.memory.b.a
        public boolean c() {
            return com.bytedance.memory.c.b.d().k();
        }

        @Override // com.bytedance.memory.b.a
        public void d() {
            com.bytedance.memory.c.c.i().f(System.currentTimeMillis());
        }
    }

    class b extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f4993a;

        b(a r1) {
            this.f4993a = r1;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r6, Intent r7) {
            com.bytedance.memory.b.c.c("ResultReceiver onReceive", new Object[0]);
            a.b(this.f4993a, false);
            if (r7.hasExtra("Key_Result_Client_Memory") == false) goto L17;
            String r8 = r7.getStringExtra("Key_Result_Client_Memory");
        L12:
            e = move-exception;
            com.bytedance.memory.b.c.c("deleteCache catch", new Object[0]);
            e.printStackTrace();
            return;
        L6:
            if (TextUtils.isEmpty(r8) == false) goto L8;
        L10:
            com.bytedance.memory.b.c.c("deleteCache", new Object[0]);     // Catch: Exception -> L12
            com.bytedance.memory.heap.a.o().i();     // Catch: Exception -> L12
            return;
        L8:
            if (TextUtils.isEmpty(new JSONObject(r8).optString("memory_object")) == true) goto L10;
            com.bytedance.memory.b.c.c("can upload", new Object[0]);     // Catch: Exception -> L12
            com.bytedance.memory.d.a.d("client_analyze_end");     // Catch: Exception -> L12
            com.bytedance.memory.d.a.f("client_analyze_time", System.currentTimeMillis() - a.c(this.f4993a));     // Catch: Exception -> L12
            com.bytedance.memory.h.a.c(r8);     // Catch: Exception -> L12
            goto L10
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a f4994f;

        c(a r1) {
            this.f4994f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.d(this.f4994f).e() == 2) goto L5;
        L7:
            a.f(this.f4994f);
            a.g(this.f4994f, false);
            return;
        L5:
            if (com.bytedance.memory.c.c.i().b() == false) goto L7;
            com.bytedance.memory.i.a.i().k(a.d(this.f4994f), a.e(this.f4994f));
            goto L7
        }
    }

    private a() {
        this.f4988c = 0;
        this.f4990e = new C0153a(this);
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer"})
    public static Intent a(Context r1, BroadcastReceiver r2, IntentFilter r3) {
        return r1.registerReceiver(r2, r3);
    L4:
        e = move-exception;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L8;
        throw e;
    L8:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r2, r3);
    }

    static /* synthetic */ boolean b(a r0, boolean r1) {
        r0.f4989d = r1;
        return r1;
    }

    static /* synthetic */ long c(a r2) {
        return r2.f4988c;
    }

    static /* synthetic */ com.bytedance.memory.f.a d(a r0) {
        return r0.f4987b;
    }

    static /* synthetic */ com.bytedance.memory.b.a e(a r0) {
        return r0.f4990e;
    }

    static /* synthetic */ void f(a r0) {
        r0.h();
    }

    static /* synthetic */ boolean g(a r0, boolean r1) {
        r0.f4992g = r1;
        return r1;
    }

    private void h() {
        if (com.bytedance.memory.heap.a.o().u() == false) goto L5;
        return;
    L5:
        com.bytedance.memory.heap.a.o().f();
        if (this.f4987b.a() == false) goto L17;
        com.bytedance.memory.b.c.c("client analyze mode", new Object[0]);
        if (this.f4989d == false) goto L10;
        return;
    L10:
        if (com.bytedance.memory.c.b.d().k() == false) goto L21;
        d.e(this.f4986a, Class.forName("com.bytedance.apm.momory.analyzer.AnalyzerService"), true);     // Catch: Throwable -> L14
        Intent r1 = new Intent(this.f4986a, Class.forName("com.bytedance.apm.momory.analyzer.AnalyzerService"));     // Catch: Throwable -> L14
        r1.putExtra("hprofFilePath", com.bytedance.memory.c.b.d().f().getAbsolutePath());     // Catch: Throwable -> L14
        r1.putExtra("debug", this.f4987b.g());     // Catch: Throwable -> L14
        this.f4986a.startService(r1);     // Catch: Throwable -> L14
        this.f4988c = System.currentTimeMillis();     // Catch: Throwable -> L14
        com.bytedance.memory.b.c.c("start Service success", new Object[0]);     // Catch: Throwable -> L14
        com.bytedance.memory.d.a.d("client_analyze_begin");     // Catch: Throwable -> L14
        this.f4989d = true;     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        com.bytedance.memory.b.c.c("start Service failed", new Object[0]);
        this.f4987b.h(false);
        th.printStackTrace();
        return;
    L21:
        return;
    L17:
        com.bytedance.memory.b.c.c("upload mode", new Object[0]);
        com.bytedance.memory.h.a.b();
    }

    public static a l() {
        if (f4985h != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f4985h != null) goto L9;
        f4985h = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f4985h;
    }

    private void n(@NonNull Context r2, @Nullable com.bytedance.memory.i.b r3) {
        a(r2.getApplicationContext(), new b(this), new IntentFilter("Action_Result_Memory_Client_Analyzer"));
    }

    public boolean i() {
        com.bytedance.memory.f.a r1 = this.f4987b;     // Catch: Exception -> L10
        if (r1 != null) goto L6;
        return false;
    L6:
        if (r1.g() == false) goto L16;
        if (d.d(this.f4986a) == true) goto L18;
        return false;
    L18:
        return true;
    L16:
        return false;
    L10:
        e = move-exception;
        com.bytedance.memory.b.c.c(Log.getStackTraceString(e), new Object[0]);
        return false;
    }

    @NonNull
    public Context j() {
        g.a(this.f4986a, "You must call init() first before using !!!");
        return this.f4986a;
    }

    @NonNull
    public com.bytedance.memory.f.a k() {
        g.a(this.f4987b, com.bytedance.memory.f.a.class.getSimpleName() + " mustn't be null");
        return this.f4987b;
    }

    @MainThread
    public void m(@NonNull Context r4, @NonNull com.bytedance.memory.f.a r5, @Nullable com.bytedance.memory.i.b r6) {
        if (this.f4991f == false) goto L5;
        return;
    L5:
        g.a(r4, Context.class.getSimpleName() + " mustn't be null");
        g.a(r5, com.bytedance.memory.f.a.class.getSimpleName() + " mustn't be null");
        this.f4986a = r4;
        this.f4987b = r5;
        e.f4999a = r5.g();
        if (r5.a() == false) goto L8;
        n(r4, r6);
    L8:
        Npth.registerOOMCallback(new com.bytedance.memory.e.a());
        this.f4991f = true;
    }

    public void o(Context r1) {
        this.f4986a = r1;
    }

    public void p() {
        if (this.f4992g == false) goto L5;
        return;
    L5:
        com.bytedance.memory.b.c.c("MemoryApi start", new Object[0]);
        this.f4992g = true;
        g.b(this.f4991f, "You must call init() first before using !!!");
        com.bytedance.memory.b.b.f4995a.a(new c(this), "MemoryApi-start");
    }
}
