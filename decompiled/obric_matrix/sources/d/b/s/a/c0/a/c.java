package d.b.s.a.c0.a;

import android.os.Looper;
import android.os.Message;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.utility.k;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public abstract class c implements e, Runnable, Comparable<e>, WeakHandler.IHandler {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static f f14681l;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected final AtomicBoolean f14682f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected final AtomicBoolean f14683g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private WeakHandler f14684h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f14685i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final String f14686j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected final e.a f14687k;

    static {
        f14681l = f.c();
    }

    protected c(String r3, e.a r4) {
        this.f14682f = new AtomicBoolean(false);
        this.f14683g = new AtomicBoolean(false);
        this.f14684h = new WeakHandler(Looper.getMainLooper(), this);
        this.f14687k = r4;
        if (k.c(r3) == false) goto L5;
        r3 = getClass().getSimpleName();
    L5:
        this.f14686j = r3;
    }

    @Override // d.b.s.a.c0.a.e
    public e.a b() {
        return this.f14687k;
    }

    @Override // d.b.s.a.c0.a.e
    public int c() {
        return this.f14685i;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(e r1) {
        return l(r1);
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r1) {
        if (r1 != null) goto L14;
        return;
    L14:
        int r0 = r1.what;     // Catch: Throwable -> L12
        if (r0 != 0) goto L7;
        f14681l.f();     // Catch: Throwable -> L12
    L13:
        return;
    L7:
        if (r0 != 1) goto L13;
        f14681l.e();     // Catch: Throwable -> L12
    }

    public void j() {
        this.f14684h.removeMessages(1);
    }

    public void k() {
        this.f14684h.removeMessages(0);
    }

    public int l(e r3) {
        e.a r0 = b();
        e.a r1 = r3.b();
        if (r0 != null) goto L5;
        r0 = e.a.f14689g;
    L5:
        if (r1 != null) goto L7;
        r1 = e.a.f14689g;
    L7:
        if (r0 != r1) goto L9;
        int r2 = c();
        int r4 = r3.c();
    L11:
        return r2 - r4;
    L9:
        r2 = r1.ordinal();
        r4 = r0.ordinal();
        goto L11
    }

    public String m() {
        return this.f14686j;
    }

    public boolean n() {
        return this.f14683g.get();
    }

    public boolean o() {
        return false;
    }

    public boolean p() {
        return false;
    }

    public boolean q() {
        return false;
    }

    public void r() {
        j();
        this.f14684h.sendEmptyMessageDelayed(1, 1000);
    }

    public void run() {
    }

    public void s() {
        k();
        this.f14684h.sendEmptyMessageDelayed(0, 1000);
    }

    public final c t(int r1) {
        this.f14685i = r1;
        return this;
    }

    public final void u() {
        if (this.f14682f.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        if (f14681l != null) goto L8;
        f14681l = f.c();
    L8:
        if (o() == false) goto L10;
        f14681l.b(this);
        return;
    L10:
        f14681l.a(this);
    }
}
