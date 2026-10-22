package d.b.b.e.a.k.h;

import android.content.Context;
import androidx.annotation.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile c f12701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private b f12702b;

    /* JADX INFO: renamed from: d.b.b.e.a.k.h.a$a, reason: collision with other inner class name */
    private static class C0332a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f12703a = null;

        static {
            f12703a = new a();
        }

        static /* synthetic */ a a() {
            return f12703a;
        }
    }

    public a() {
    }

    public static a a() {
        return C0332a.a();
    }

    public void b(Context r2) {
        b r0 = new b(r2);
        this.f12702b = r0;
        c(r0.b(), false);
    }

    public void c(@Nullable c r1, boolean r2) {
        if (r1 == null) goto L13;
        monitor-enter(this);
        this.f12701a = r1;     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        if (r2 == false) goto L16;
        b r0 = this.f12702b;
        if (r0 == null) goto L17;
        r0.c(r1);
        return;
    L17:
        return;
    L16:
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public boolean d(JSONObject r7, int r8) {
        boolean r1 = true;
        if (this.f12701a != null) goto L5;
    L46:
        return true;
    L5:
        if (System.currentTimeMillis() > this.f12701a.f12705a) goto L46;
        String r9 = String.valueOf(r8);
        String r0 = r7.optString("log_type");
        monitor-enter(this);
        c.a r2 = c.a.f12708h;     // Catch: Throwable -> L43
        if (r2.f12710f.equals(r0) == false) goto L26;
        String r10 = r7.optString("service");     // Catch: Throwable -> L43
        c.b r3 = this.f12701a.f12706b.get(r2);     // Catch: Throwable -> L43
        if (r3 == null) goto L41;
        JSONObject r11 = r3.f12712b.get(r9);     // Catch: Throwable -> L43
        if (r11 != null) goto L16;
    L23:
        boolean r12 = r3.f12711a;     // Catch: Throwable -> L43
        monitor-exit(this);     // Catch: Throwable -> L43
        return r12;
    L16:
        if (r11.optInt(r10, -1) == (-1)) goto L23;
        if (r11.optInt(r10, -1) == 1) goto L21;
        r1 = false;
    L21:
        monitor-exit(this);     // Catch: Throwable -> L43
        return r1;
    L41:
        monitor-exit(this);     // Catch: Throwable -> L43
        return true;
    L26:
        c.b r13 = this.f12701a.f12706b.get(c.a.f12707g);     // Catch: Throwable -> L43
        if (r13 == null) goto L41;
        JSONObject r14 = r13.f12712b.get(r9);     // Catch: Throwable -> L43
        if (r14 != null) goto L31;
    L38:
        boolean r15 = r13.f12711a;     // Catch: Throwable -> L43
        monitor-exit(this);     // Catch: Throwable -> L43
        return r15;
    L31:
        if (r14.optInt(r0, -1) == (-1)) goto L38;
        if (r14.optInt(r0, -1) == 1) goto L36;
        r1 = false;
    L36:
        monitor-exit(this);     // Catch: Throwable -> L43
        return r1;
    L43:
        th = move-exception;
        throw th;
    }
}
