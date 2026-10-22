package com.obric.matrix.osettings;

import android.content.Context;
import com.obric.matrix.osettings_api.IOSettings;
import com.obric.matrix.r.e.f;
import d.g.e.a.d;
import d.g.e.a.e;
import h.a.b1;
import h.a.h;
import h.a.m0;
import h.a.n0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.i0.r;
import kotlin.n0.c.l;
import kotlin.n0.c.p;
import kotlin.n0.d.g;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.w;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0005H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/obric/matrix/osettings/OSettingsImpl;", "Lcom/obric/matrix/osettings_api/IOSettings;", "()V", "listeners", "", "Lcom/obric/matrix/osettings_api/OnSettingsUpdateListener;", "doInit", "", "context", "Landroid/content/Context;", "getString", "", "key", "defaultValue", "init", "registerSettingsUpdate", "listener", "Companion", "osettings_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OSettingsImpl implements IOSettings {
    public static final a Companion = null;
    private static final String TAG = "OSettingsImpl";
    private final List<com.obric.matrix.osettings_api.a> listeners;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/matrix/osettings/OSettingsImpl$Companion;", "", "()V", "TAG", "", "osettings_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0016¨\u0006\t"}, d2 = {"com/obric/matrix/osettings/OSettingsImpl$doInit$1", "Lcom/obric/sdk/osettings/OnSettingsUpdateListener;", "getInterestedKeys", "", "", "onSettingsUpdate", "", "key", "value", "osettings_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OSettingsImpl f9449a;

        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/obric/matrix/osettings_api/OnSettingsUpdateListener;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
        static final class a extends q implements l<com.obric.matrix.osettings_api.a, f0> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ String f9450f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ String f9451g;

            a(String r1, String r2) {
                this.f9450f = r1;
                this.f9451g = r2;
                super(1);
            }

            public final void a(com.obric.matrix.osettings_api.a r2) {
                o.f(r2, "it");
                r2.a(this.f9450f, this.f9451g);
            }

            @Override // kotlin.n0.c.l
            public /* bridge */ /* synthetic */ f0 invoke(com.obric.matrix.osettings_api.a r1) {
                a(r1);
                return f0.f18324a;
            }
        }

        b(OSettingsImpl r1) {
            this.f9449a = r1;
        }

        @Override // d.g.e.a.e
        public void a(String r5, String r6) {
            o.f(r5, "key");
            com.obric.matrix.r.c.c.b(OSettingsImpl.TAG, "OSettings onSettingsUpdate, key = " + r5 + ", value = " + r6);
            String r0 = d.j("network.env", "online");
            if (r0 != null) goto L5;
            r0 = "online";
        L5:
            String r1 = d.j("network.headers", "");
            HashMap r2 = new HashMap();
            com.obric.matrix.r.e.l.f9944a.a(r1, r2);
            com.obric.matrix.base.env.d.f8838a.k(r0, r2);
            List r3 = OSettingsImpl.access$getListeners$p(this.f9449a);
            OSettingsImpl r4 = this.f9449a;
            monitor-enter(r3);
            f.f9940a.b(OSettingsImpl.access$getListeners$p(r4), new a(r5, r6));     // Catch: Throwable -> L10
            f0 r7 = f0.f18324a;     // Catch: Throwable -> L10
            monitor-exit(r3);
            return;
        L10:
            th = move-exception;
            throw th;
        }

        @Override // d.g.e.a.e
        public List<String> b() {
            ArrayList r0 = new ArrayList();
            List r1 = OSettingsImpl.access$getListeners$p(this.f9449a);
            OSettingsImpl r4 = this.f9449a;
            monitor-enter(r1);
            List r5 = OSettingsImpl.access$getListeners$p(r4);     // Catch: Throwable -> L16
            ArrayList r2 = new ArrayList();     // Catch: Throwable -> L16
            Iterator r6 = r5.iterator();     // Catch: Throwable -> L16
        L6:
            if (r6.hasNext() == false) goto L8;
            r.v(r2, ((com.obric.matrix.osettings_api.a) r6.next()).b());     // Catch: Throwable -> L16
            goto L6
        L8:
            Iterator r7 = r2.iterator();     // Catch: Throwable -> L16
        L10:
            if (r7.hasNext() == false) goto L12;
            f.f9940a.a(r0, (String) r7.next());     // Catch: Throwable -> L16
            goto L10
        L12:
            f0 r8 = f0.f18324a;     // Catch: Throwable -> L16
            monitor-exit(r1);
            com.obric.matrix.r.c.c.b(OSettingsImpl.TAG, "getInterestedKeys: " + r0);
            return r0;
        L16:
            th = move-exception;
            throw th;
        }
    }

    @kotlin.k0.j.a.f(c = "com.obric.matrix.osettings.OSettingsImpl$init$1", f = "OSettingsImpl.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class c extends kotlin.k0.j.a.l implements p<m0, kotlin.k0.d<? super f0>, Object> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f9452f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ OSettingsImpl f9453g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ Context f9454h;

        c(OSettingsImpl r1, Context r2, kotlin.k0.d<? super c> r3) {
            this.f9453g = r1;
            this.f9454h = r2;
            super(2, r3);
        }

        @Override // kotlin.k0.j.a.a
        public final kotlin.k0.d<f0> create(Object r2, kotlin.k0.d<?> r3) {
            return new c(this.f9453g, this.f9454h, r3);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(m0 r1, kotlin.k0.d<? super f0> r2) {
            return ((c) create(r1, r2)).invokeSuspend(f0.f18324a);
        }

        @Override // kotlin.n0.c.p
        public /* bridge */ /* synthetic */ Object invoke(m0 r1, kotlin.k0.d<? super f0> r2) {
            return invoke2(r1, r2);
        }

        @Override // kotlin.k0.j.a.a
        public final Object invokeSuspend(Object r2) {
            kotlin.k0.i.b.c();
            if (this.f9452f != 0) goto L7;
            w.b(r2);
            OSettingsImpl.access$doInit(this.f9453g, this.f9454h);
            return f0.f18324a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        Companion = new a(null);
    }

    public OSettingsImpl() {
        this.listeners = new ArrayList();
    }

    public static final /* synthetic */ void access$doInit(OSettingsImpl r0, Context r1) {
        r0.doInit(r1);
    }

    public static final /* synthetic */ List access$getListeners$p(OSettingsImpl r0) {
        return r0.listeners;
    }

    private final synchronized void doInit(Context r4) {
        monitor-enter(this);
        d.l(r4);     // Catch: Throwable -> L5
        d.s(new b(this));     // Catch: Throwable -> L5
        com.obric.matrix.r.c.c.s(TAG, "getNetEnv: " + d.f16950a.i());     // Catch: Throwable -> L5
    L7:
        monitor-exit(this);
        return;
    L5:
        th = move-exception;
        com.obric.matrix.r.c.c.g(TAG, "init, error", th);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.matrix.osettings_api.IOSettings
    public String getString(String r2, String r3) {
        o.f(r2, "key");
        o.f(r3, "defaultValue");
        String r1 = d.j(r2, r3);     // Catch: Exception -> L7
        if (r1 != null) goto L12;
        return r3;
    L12:
        return r1;
    L7:
        e = move-exception;
        com.obric.matrix.r.c.c.g(TAG, "getString, error", e);
        return r3;
    }

    @Override // com.obric.matrix.osettings_api.IOSettings
    public void init(Context r8) {
        o.f(r8, "context");
        h.b(n0.b(), b1.a(), null, new c(this, r8, null), 2, null);
    }

    @Override // com.obric.matrix.osettings_api.IOSettings
    public void registerSettingsUpdate(com.obric.matrix.osettings_api.a r3) {
        o.f(r3, "listener");
        com.obric.matrix.r.c.c.b(TAG, "registerSettingsUpdate");
        List<com.obric.matrix.osettings_api.a> r0 = this.listeners;
        monitor-enter(r0);
        f.f9940a.a(this.listeners, r3);     // Catch: Throwable -> L7
        f0 r2 = f0.f18324a;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
