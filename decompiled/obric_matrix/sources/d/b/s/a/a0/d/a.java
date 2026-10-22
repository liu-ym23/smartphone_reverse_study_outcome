package d.b.s.a.a0.d;

import androidx.core.app.NotificationCompat;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.util.Arrays;
import kotlin.n0.d.o;
import kotlin.u;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile C0394a f14635a;

    /* JADX INFO: renamed from: d.b.s.a.a0.d.a$a, reason: collision with other inner class name */
    public static final class C0394a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f14636a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final b f14637b;

        public C0394a(String r2, b r3) {
            o.g(r2, "name");
            o.g(r3, "eventTime");
            this.f14636a = r2;
            this.f14637b = r3;
        }

        public final b a() {
            return this.f14637b;
        }

        public final String b() {
            return this.f14636a;
        }
    }

    static {
    }

    public a() {
    }

    private final void g(String r11, int r12, Throwable r13, boolean r14, u<String, ? extends Object>... r15) {
        C0394a r3 = this.f14635a;
        b r4 = b.f14638c.a();
        StringBuilder r6 = new StringBuilder();
        if (r12 != 1) goto L5;
        StringBuilder r8 = new StringBuilder();
        String r9 = "[WARN] ";
    L9:
        r8.append(r9);
        r8.append(r11);
        r6.append(r8.toString());
        if (r15.length != 0) goto L12;
        boolean r10 = true;
    L14:
        if ((true ^ r10) == false) goto L17;
        r6.append("\n");
        r6.append(f.f14648a.b(r15));
    L17:
        if (r3 == null) goto L19;
        c r5 = r4.a(r3.a());
        r6.append("\n  >> Time elapsed since ");
        r6.append(r3.b());
        r6.append(": ");
        r6.append(r5);
    L20:
        String r16 = e();
        String r7 = r6.toString();
        o.b(r7, "sb.toString()");
        f(r12, r16, r7, r13);
        if (r14 == false) goto L27;
        if (r3 == null) goto L24;
        String r17 = r3.b();
    L25:
        h(r11, r12, r17, r5, r15);
        return;
    L24:
        r17 = null;
        goto L25
    L27:
        return;
    L19:
        r5 = null;
        goto L20
    L12:
        r10 = false;
        goto L14
    L5:
        if (r12 == 2) goto L7;
        r8 = new StringBuilder();
        r9 = "[Record] ";
        goto L9
    L7:
        r8 = new StringBuilder();
        r9 = "[ERROR] ";
        goto L9
    }

    @Override // d.b.s.a.a0.d.e
    public final void a(String r5) {
        o.g(r5, "checkpointName");
        b.a r0 = b.f14638c;
        b r1 = r0.a();
        monitor-enter(this);
        C0394a r2 = this.f14635a;     // Catch: Throwable -> L11
        this.f14635a = new C0394a(r5, r0.a());     // Catch: Throwable -> L11
        monitor-exit(this);
        String r6 = "[Checkpoint] " + r5 + ' ';
        if (r2 == null) goto L9;
        r6 = r6 + "\n  >> last checkpoint: " + r2.b() + " Duration: " + r1.a(r2.a());
    L9:
        f(0, e(), r6, null);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // d.b.s.a.a0.d.e
    public final void b(String r4) {
        o.g(r4, "recordName");
        d(r4, 0, null, new u[0]);
    }

    @Override // d.b.s.a.a0.d.e
    public final e.a c(String r2) {
        o.g(r2, "recordName");
        return new e.a(r2, this);
    }

    @Override // d.b.s.a.a0.d.e
    public final void d(String r7, int r8, Throwable r9, u<String, ? extends Object>... r10) {
        o.g(r7, "recordName");
        o.g(r10, "params");
        g(r7, r8, r9, false, (u[]) Arrays.copyOf(r10, r10.length));
    }

    public abstract String e();

    public void f(int r2, String r3, String r4, Throwable r5) {
        o.g(r3, LocationMonitorConst.TAG);
        o.g(r4, NotificationCompat.CATEGORY_MESSAGE);
        if (r2 != 1) goto L5;
        d.b.s.a.a0.a.i("Profiler/" + r3, r4, r5);
        return;
    L5:
        if (r2 == 2) goto L7;
        d.b.s.a.a0.a.d("Profiler/" + r3, r4);
        return;
    L7:
        d.b.s.a.a0.a.c("Profiler/" + r3, r4, r5);
    }

    public abstract void h(String r1, int r2, String r3, c r4, u<String, ? extends Object>[] r5);
}
