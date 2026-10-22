package d.g.e.a;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import androidx.annotation.RequiresApi;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.google.gson.Gson;
import com.google.gson.j;
import com.google.gson.m;
import h.a.h;
import h.a.m0;
import h.a.n0;
import h.a.n1;
import h.a.p1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.k0.j.a.l;
import kotlin.n0.c.p;
import kotlin.n0.d.o;
import kotlin.w;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J,\u0010\u0016\u001a\u0004\u0018\u0001H\u0017\"\u0006\b\u0000\u0010\u0017\u0018\u00012\u0006\u0010\u0018\u001a\u00020\u00042\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u0001H\u0017H\u0086\b¢\u0006\u0002\u0010\u001aJ\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0018\u001a\u00020\u00042\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001cH\u0002J\u0006\u0010\u001d\u001a\u00020\u0004J\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001fJ\u001e\u0010 \u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0018\u001a\u00020\u00042\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010!\u001a\u00020\"2\u0006\u0010\u0018\u001a\u00020\u0004H\u0007J\u0010\u0010#\u001a\u00020\u00122\u0006\u0010$\u001a\u00020%H\u0007J!\u0010&\u001a\u00020\r2\u0012\u0010'\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0(\"\u00020\rH\u0002¢\u0006\u0002\u0010)J\u001c\u0010*\u001a\u00020\u00122\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u0011\u0010-\u001a\u00020\u0012H\u0083@ø\u0001\u0000¢\u0006\u0002\u0010.J\b\u0010/\u001a\u00020\u0012H\u0002J\n\u00100\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u00101\u001a\u00020\u00122\u0006\u0010$\u001a\u00020%H\u0003J\u0010\u00102\u001a\u00020\u00122\u0006\u00103\u001a\u00020\u0010H\u0007J\n\u00104\u001a\u0004\u0018\u00010\u0004H\u0007J\u001e\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001f2\b\u00106\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u00107\u001a\u00020\u00122\u0006\u00103\u001a\u00020\u0010H\u0007J\b\u00108\u001a\u000209H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R.\u0010\t\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\nj\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004`\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006:"}, d2 = {"Lcom/obric/sdk/osettings/OSettingsManager;", "Landroid/content/BroadcastReceiver;", "()V", "TAG", "", "dispatcher", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "gson", "Lcom/google/gson/Gson;", "lastKVRecord", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "mainSettings", "Lcom/obric/sdk/osettings/OSettingsData;", "settingsUpdateListeners", "", "Lcom/obric/sdk/osettings/OnSettingsUpdateListener;", "dfsMergeJson", "", "s1", "Lcom/google/gson/JsonObject;", "s2", "get", "T", "key", "defaultValue", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "getAny", "", "getNetEnv", "getNetHeader", "", "getString", "has", "", "init", "context", "Landroid/content/Context;", "mergeSettings", "settings", "", "([Lcom/obric/sdk/osettings/OSettingsData;)Lcom/obric/sdk/osettings/OSettingsData;", "onReceive", "intent", "Landroid/content/Intent;", "onSettingsUpdate", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onUpdateLastKVRecord", "printConfig", "register", "registerSettingsUpdate", "listener", "showConfig", "stringToMap", "input", "unregisterSettingsUpdate", "updateTime", "", "osettings_sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class d extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f16950a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Gson f16951b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile d.g.e.a.c f16952c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static List<e> f16953d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static HashMap<String, String> f16954e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static n1 f16955f;

    @kotlin.k0.j.a.f(c = "com.obric.sdk.osettings.OSettingsManager$init$3", f = "OSettingsManager.kt", l = {47}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class a extends l implements p<m0, kotlin.k0.d<? super Integer>, Object> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f16956f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Context f16957g;

        a(Context r1, kotlin.k0.d<? super a> r2) {
            this.f16957g = r1;
            super(2, r2);
        }

        @Override // kotlin.k0.j.a.a
        public final kotlin.k0.d<f0> create(Object r1, kotlin.k0.d<?> r2) {
            return new a(this.f16957g, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(m0 r1, kotlin.k0.d<? super Integer> r2) {
            return ((a) create(r1, r2)).invokeSuspend(f0.f18324a);
        }

        @Override // kotlin.n0.c.p
        public /* bridge */ /* synthetic */ Object invoke(m0 r1, kotlin.k0.d<? super Integer> r2) {
            return invoke2(r1, r2);
        }

        @Override // kotlin.k0.j.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = kotlin.k0.i.b.c();
            int r1 = this.f16956f;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            w.b(r5);
        L11:
            d.e(d.f16950a, this.f16957g);
            return kotlin.k0.j.a.b.b(Log.i("OSettings sdk", "init: dispatcher, end"));
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            w.b(r5);
            Log.i("OSettings sdk", "init: dispatcher");
            d r6 = d.f16950a;
            this.f16956f = 1;
            if (d.d(r6, this) != r0) goto L11;
            return r0;
        }
    }

    @kotlin.k0.j.a.f(c = "com.obric.sdk.osettings.OSettingsManager$onReceive$1", f = "OSettingsManager.kt", l = {138}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class b extends l implements p<m0, kotlin.k0.d<? super f0>, Object> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f16958f;

        b(kotlin.k0.d<? super b> r2) {
            super(2, r2);
        }

        @Override // kotlin.k0.j.a.a
        public final kotlin.k0.d<f0> create(Object r1, kotlin.k0.d<?> r2) {
            return new b(r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(m0 r1, kotlin.k0.d<? super f0> r2) {
            return ((b) create(r1, r2)).invokeSuspend(f0.f18324a);
        }

        @Override // kotlin.n0.c.p
        public /* bridge */ /* synthetic */ Object invoke(m0 r1, kotlin.k0.d<? super f0> r2) {
            return invoke2(r1, r2);
        }

        @Override // kotlin.k0.j.a.a
        public final Object invokeSuspend(Object r4) {
            Object r0 = kotlin.k0.i.b.c();
            int r1 = this.f16958f;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            w.b(r4);
        L12:
            return f0.f18324a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            w.b(r4);
            d r5 = d.f16950a;
            this.f16958f = 1;
            if (d.d(r5, this) != r0) goto L12;
            return r0;
        }
    }

    @kotlin.k0.j.a.f(c = "com.obric.sdk.osettings.OSettingsManager", f = "OSettingsManager.kt", l = {62, 63, 64}, m = "onSettingsUpdate")
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    static final class c extends kotlin.k0.j.a.d {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Object f16959f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Object f16960g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        Object f16961h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        /* synthetic */ Object f16962i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ d f16963j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        int f16964k;

        c(d r1, kotlin.k0.d<? super c> r2) {
            this.f16963j = r1;
            super(r2);
        }

        @Override // kotlin.k0.j.a.a
        public final Object invokeSuspend(Object r2) {
            this.f16962i = r2;
            this.f16964k |= Integer.MIN_VALUE;
            return d.d(this.f16963j, this);
        }
    }

    /* JADX INFO: renamed from: d.g.e.a.d$d, reason: collision with other inner class name */
    @kotlin.k0.j.a.f(c = "com.obric.sdk.osettings.OSettingsManager$registerSettingsUpdate$1", f = "OSettingsManager.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class C0446d extends l implements p<m0, kotlin.k0.d<? super f0>, Object> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f16965f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ e f16966g;

        C0446d(e r1, kotlin.k0.d<? super C0446d> r2) {
            this.f16966g = r1;
            super(2, r2);
        }

        @Override // kotlin.k0.j.a.a
        public final kotlin.k0.d<f0> create(Object r1, kotlin.k0.d<?> r2) {
            return new C0446d(this.f16966g, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(m0 r1, kotlin.k0.d<? super f0> r2) {
            return ((C0446d) create(r1, r2)).invokeSuspend(f0.f18324a);
        }

        @Override // kotlin.n0.c.p
        public /* bridge */ /* synthetic */ Object invoke(m0 r1, kotlin.k0.d<? super f0> r2) {
            return invoke2(r1, r2);
        }

        @Override // kotlin.k0.j.a.a
        public final Object invokeSuspend(Object r5) {
            kotlin.k0.i.b.c();
            if (this.f16965f != 0) goto L18;
            w.b(r5);
            Log.i("OSettings sdk", "registerSettingsUpdate: ");
            if (this.f16966g.b().isEmpty() == true) goto L16;
            if (d.c().contains(this.f16966g) == true) goto L16;
            Iterator<String> r6 = this.f16966g.b().iterator();
        L11:
            if (r6.hasNext() == false) goto L13;
            String r0 = r6.next();
            d.b().put(r0, d.k(r0, null, 2, null));
            goto L11
        L13:
            d.c().add(this.f16966g);
            return f0.f18324a;
        L16:
            return f0.f18324a;
        L18:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        f16950a = new d();
        com.google.gson.e r0 = new com.google.gson.e();
        r0.h();
        Gson r1 = r0.d();
        o.e(r1, "GsonBuilder()\n        .s…nting()\n        .create()");
        f16951b = r1;
        f16953d = new ArrayList();
        f16954e = new HashMap();
    }

    private d() {
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

    public static final /* synthetic */ HashMap b() {
        return f16954e;
    }

    public static final /* synthetic */ List c() {
        return f16953d;
    }

    public static final /* synthetic */ Object d(d r0, kotlin.k0.d r1) {
        return r0.p(r1);
    }

    public static final /* synthetic */ void e(d r0, Context r1) {
        r0.r(r1);
    }

    private final void f(m r6, m r7) {
        Iterator<String> r0 = r7.A().iterator();
    L4:
        if (r0.hasNext() == false) goto L13;
        String r1 = r0.next();
        if (r6.z(r1) == false) goto L12;
        j r2 = r6.v(r1);
        j r3 = r7.v(r1);
        if (r2.o() == false) goto L12;
        if (r3.o() == false) goto L12;
        m r4 = r2.c();
        o.e(r4, "v1.asJsonObject");
        m r5 = r3.c();
        o.e(r5, "v2.asJsonObject");
        f(r4, r5);
    L12:
        r6.q(r1, r7.v(r1));
        goto L4
    }

    private final Object g(String r2, Object r3) {
        if (f16952c != null) goto L6;
        Log.e("OSettings sdk", "osm must be init");
        return null;
    L6:
        d.g.e.a.c r1 = f16952c;
        if (r1 == null) goto L13;
        j r4 = r1.a(r2);
        if (r4 != null) goto L12;
        return r3;
    L12:
        return r4;
    L13:
        o.v("mainSettings");
        throw null;
    }

    static /* synthetic */ Object h(d r0, String r1, Object r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        return r0.g(r1, r2);
    }

    public static final String j(String r3, String r4) {
        o.f(r3, "key");
        Object r5 = h(f16950a, r3, null, 2, null);
        if (r5 != null) goto L6;
        return r4;
    L6:
        if ((r5 instanceof com.google.gson.p) == false) goto L10;
        return ((com.google.gson.p) r5).l();
    L10:
        return r5.toString();
    }

    public static /* synthetic */ String k(String r0, String r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L6;
        r1 = null;
    L6:
        return j(r0, r1);
    }

    public static final void l(Context r3) {
        o.f(r3, "context");
        if (f16952c != null) goto L9;
        ExecutorService r0 = Executors.newSingleThreadExecutor(d.g.e.a.a.f16943f);
        o.e(r0, "newSingleThreadExecutor …on = true }\n            }");
        n1 r1 = p1.b(r0);
        f16955f = r1;
        if (r1 == null) goto L7;
        h.c(r1, new a(r3, null));
        return;
    L7:
        o.v("dispatcher");
        throw null;
    }

    private static final Thread m(Runnable r2) {
        Thread r0 = new Thread(r2, "oSetting_sdk_thread");
        r0.setDaemon(true);
        return r0;
    }

    public static /* synthetic */ Thread n(Runnable r0) {
        return m(r0);
    }

    private final d.g.e.a.c o(d.g.e.a.c... r9) {
        m r0 = new m();
        int r1 = r9.length;
        long r2 = 0;
        int r4 = 0;
    L3:
        if (r4 >= r1) goto L6;
        d.g.e.a.c r5 = r9[r4];
        r4 = r4 + 1;
        r2 = kotlin.r0.e.d(r2, r5.c());
        f(r0, r5.b());
        goto L3
    L6:
        return new d.g.e.a.c(f.f16972k, r0, r2);
    }

    @RequiresApi(26)
    private final Object p(kotlin.k0.d<? super f0> r20) {
        d r1 = this;
        if ((r20 instanceof c) == false) goto L7;
        c r3 = (c) r20;
        int r4 = r3.f16964k;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.f16964k = r4 - Integer.MIN_VALUE;
    L8:
        Object r0 = r3.f16962i;
        Object r5 = kotlin.k0.i.b.c();
        int r6 = r3.f16964k;
        if (r6 == 0) goto L28;
        if (r6 == 1) goto L25;
        if (r6 == 2) goto L20;
        if (r6 != 3) goto L19;
        String r2 = (String) r3.f16961h;
        String r7 = (String) r3.f16960g;
        d r8 = (d) r3.f16959f;
        w.b(r0);     // Catch: Exception -> L16
        String r9 = r2;
        r1 = r8;
    L40:
        String r10 = (String) r0;     // Catch: Exception -> L58
        if (r7 != null) goto L43;
        d.g.e.a.c r11 = null;
    L44:
        if (r11 != null) goto L46;
        r11 = new d.g.e.a.c(f.f16971j, null, 0, 6, null);     // Catch: Exception -> L58
    L46:
        if (r9 != null) goto L48;
        d.g.e.a.c r12 = null;
    L49:
        if (r12 != null) goto L51;
        r12 = new d.g.e.a.c(f.f16970i, null, 0, 6, null);     // Catch: Exception -> L58
    L51:
        if (r10 != null) goto L53;
        d.g.e.a.c r13 = null;
    L54:
        if (r13 != null) goto L56;
        r13 = new d.g.e.a.c(f.f16967f, null, 0, 6, null);     // Catch: Exception -> L58
    L56:
        f16952c = r1.o(new d.g.e.a.c[]{r11, r12, r13});     // Catch: Exception -> L58
    L60:
        Iterator<e> r14 = f16953d.iterator();
    L62:
        if (r14.hasNext() == false) goto L73;
        e r15 = r14.next();
        Iterator<String> r16 = r15.b().iterator();
    L65:
        if (r16.hasNext() == false) goto L62;
        String r17 = r16.next();
        if (f16954e.containsKey(r17) == false) goto L69;
        String r18 = (String) kotlin.i0.m0.i(f16954e, r17);
    L70:
        String r19 = k(r17, null, 2, null);
        if (o.a(r18, r19) == true) goto L65;
        r15.a(r17, r19);
        goto L65
    L69:
        r18 = null;
        goto L70
    L73:
        r1.q();
        return f0.f18324a;
    L53:
        r13 = (d.g.e.a.c) f16951b.m(r10, d.g.e.a.c.class);     // Catch: Exception -> L58
        goto L54
    L48:
        r12 = (d.g.e.a.c) f16951b.m(r9, d.g.e.a.c.class);     // Catch: Exception -> L58
        goto L49
    L43:
        r11 = (d.g.e.a.c) f16951b.m(r7, d.g.e.a.c.class);     // Catch: Exception -> L58
    L16:
        e = e;
        r1 = r8;
    L59:
        Log.e("OSettings sdk", "onSettingsUpdate error: ", e);
        f16952c = new d.g.e.a.c(f.f16972k, null, 0, 6, null);
        goto L60
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        String r21 = (String) r3.f16960g;
        d r22 = (d) r3.f16959f;
        w.b(r0);     // Catch: Exception -> L23
        String r23 = r21;
        r1 = r22;
    L36:
        String r24 = (String) r0;     // Catch: Exception -> L58
        d.g.e.a.b r110 = d.g.e.a.b.f16944a;     // Catch: Exception -> L58
        r3.f16959f = r1;     // Catch: Exception -> L58
        r3.f16960g = r23;     // Catch: Exception -> L58
        r3.f16961h = r24;     // Catch: Exception -> L58
        r3.f16964k = 3;     // Catch: Exception -> L58
        Object r25 = r110.a("/data/settings/local_config.conf", r3);     // Catch: Exception -> L58
        if (r25 != r5) goto L39;
        return r5;
    L39:
        r7 = r23;
        r9 = r24;
        r0 = r25;
    L23:
        e = e;
        r1 = r22;
        goto L59
    L25:
        r1 = (d) r3.f16959f;
        w.b(r0);     // Catch: Exception -> L58
    L32:
        String r26 = (String) r0;     // Catch: Exception -> L58
        d.g.e.a.b r27 = d.g.e.a.b.f16944a;     // Catch: Exception -> L58
        r3.f16959f = r1;     // Catch: Exception -> L58
        r3.f16960g = r26;     // Catch: Exception -> L58
        r3.f16964k = 2;     // Catch: Exception -> L58
        Object r28 = r27.a("/data/settings/remote_config.conf", r3);     // Catch: Exception -> L58
        if (r28 != r5) goto L35;
        return r5;
    L35:
        r23 = r26;
        r0 = r28;
        goto L36
    L28:
        w.b(r0);
        Log.d("OSettings sdk", "onSettingsUpdate: ");
        d.g.e.a.b r29 = d.g.e.a.b.f16944a;     // Catch: Exception -> L58
        r3.f16959f = r1;     // Catch: Exception -> L58
        r3.f16964k = 1;     // Catch: Exception -> L58
        r0 = r29.a("/data/settings/default_config.conf", r3);     // Catch: Exception -> L58
        if (r0 != r5) goto L32;
        return r5;
    L58:
        e = e;
    L7:
        r3 = new c(r1, r20);
        goto L8
    }

    private final void q() {
        Iterator<String> r4 = f16954e.keySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        String r0 = r4.next();
        HashMap<String, String> r1 = f16954e;
        o.e(r0, "key");
        r1.put(r0, k(r0, null, 2, null));
        goto L4
    }

    @SuppressLint({"UnspecifiedRegisterReceiverFlag"})
    private final void r(Context r3) {
        a(r3, this, new IntentFilter("os.teatracker.settings.UPDATE_SETTINGS"));
    }

    public static final void s(e r3) {
        o.f(r3, "listener");
        n1 r0 = f16955f;
        if (r0 == null) goto L6;
        h.c(r0, new C0446d(r3, null));
        return;
    L6:
        o.v("dispatcher");
        throw null;
    }

    public final String i() {
        String r2 = k("network.env", null, 2, null);
        if (r2 != null) goto L6;
        return "online";
    L6:
        return r2;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r7, Intent r8) {
        Log.d("OSettings sdk", o.m("receive settings update intent: ", r8));
        if (r8 != null) goto L5;
        return;
    L5:
        n1 r6 = f16955f;
        if (r6 == null) goto L9;
        h.b(n0.a(r6), null, null, new b(null), 3, null);
        return;
    L9:
        o.v("dispatcher");
        throw null;
    }
}
