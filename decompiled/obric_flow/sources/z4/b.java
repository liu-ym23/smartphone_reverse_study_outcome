package z4;

import ai.p;
import com.bytedance.ai.model.l;
import com.bytedance.android.monitorV2.hybridSetting.entity.CheckFilter;
import com.bytedance.ttnet.TTNetInit;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Timer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import mn.h;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile a5.d f23392a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f23393b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ExecutorService f23394c;
    public Timer d;
    public com.obric.flow.cardlistpage.mvi.c e;
    public final a5.c f;

    public b(a5.c r5) {
        this.f23393b = false;
        this.f23394c = Executors.newSingleThreadExecutor();
        this.f = r5;
        this.f23392a = new a5.d();
    }

    @Override // z4.d
    public final p a() {
        if (this.f23392a == null) goto L9;
        if (this.f23392a.f106a == null) goto L9;
        return this.f23392a.f106a;
    L9:
        return new p(1);
    }

    @Override // z4.d
    public final ArrayList b() {
        if (this.f23392a == null) goto L12;
        if (this.f23392a.f106a == null) goto L12;
        if (((ArrayList) this.f23392a.f106a.f288c) == null) goto L12;
        return (ArrayList) this.f23392a.f106a.f288c;
    L12:
        return new ArrayList();
    }

    public final void c(a5.c r5) {
        Field r10 = TTNetInit.class.getDeclaredField("sNotifiedColdStartFinsish");     // Catch: Throwable -> L7
        r10.setAccessible(true);     // Catch: Throwable -> L7
        if (r10.getBoolean(null) == false) goto L9;
        this.e = new i5.c(r5);     // Catch: Throwable -> L7
        d5.b.f("HybridSettingRequestService_init", "setting request use ttnet");     // Catch: Throwable -> L7
        return;
    L9:
        this.e = new c(r5);     // Catch: Throwable -> L7
        d5.b.f("HybridSettingRequestService_init", "setting request use default cause by ttnet not init");     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        h.g("startup_handle", th);
        this.e = new c(r5);
        d5.b.e("HybridSettingRequestService_init", "setting request use default cause by Throwable");
    }

    @Override // z4.d
    public final f9.a d() {
        if (this.f23392a == null) goto L9;
        if (this.f23392a.f107b == null) goto L9;
        return this.f23392a.f107b;
    L9:
        return new f9.a(1);
    }

    @Override // z4.d
    public final HashMap e() {
        if (this.f23392a.f == null) goto L7;
        return this.f23392a.f;
    L7:
        return new HashMap();
    }

    @Override // z4.d
    public final HashSet f() {
        if (this.f23392a.g == null) goto L7;
        return this.f23392a.g;
    L7:
        return new HashSet();
    }

    @Override // z4.d
    public final a5.c getInitConfig() {
        return this.f;
    }

    public final void b(int r5) {
        if (r5 > 0) goto L4;
        return;
    L4:
        if (this.d != null) goto L6;
        this.d = new Timer();
    L6:
        d5.b.f("HybridSettingRequestService_update", "monitor setting update after " + r5 + " secs");
        this.d.schedule(new l(this, 1), (long) (r5 * 1000));
    }

    @Override // z4.d
    public final CheckFilter c() {
        if (this.f23392a.f109h == null) goto L7;
        return this.f23392a.f109h;
    L7:
        return new CheckFilter();
    }
}
