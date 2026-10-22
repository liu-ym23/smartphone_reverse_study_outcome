package d.b.i.a.b;

import android.content.Context;
import java.util.LinkedList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d implements d.b.i.a.b.h.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c f13842a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LinkedList<d.b.i.a.b.f.a> f13843b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f13844c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f13845d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f13846e;

    public d(Context r3, String r4) {
        this.f13843b = new LinkedList();
        this.f13844c = 0;
        this.f13846e = false;
        this.f13842a = c.e(r3);
        this.f13845d = r4;
    }

    public void a() {
        LinkedList<d.b.i.a.b.f.a> r0 = this.f13843b;
        monitor-enter(r0);
        this.f13843b.clear();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    protected void b(d.b.i.a.b.f.a r4) {
        if (this.f13843b.size() < 200) goto L5;
        e(System.currentTimeMillis(), true);
    L5:
        this.f13843b.add(r4);
    }

    public void c() {
        d.b.i.a.b.h.a.e().d(this);
    }

    public void d(String r9, String r10, JSONObject r11) {
        if (this.f13846e == true) goto L8;
        if (r11 == null) goto L9;
        b(new d.b.i.a.b.f.a(this.f13845d, r9, r10, r11.toString(), System.currentTimeMillis()));
        return;
    L9:
        return;
    }

    public boolean e(long r5, boolean r7) {
        int r0 = this.f13843b.size();
        if (r0 <= 0) goto L21;
        if (r7 == false) goto L6;
    L9:
        this.f13844c = r5;
        LinkedList<d.b.i.a.b.f.a> r6 = this.f13843b;
        monitor-enter(r6);
        LinkedList r8 = new LinkedList(this.f13843b);     // Catch: Throwable -> L18
        this.f13843b.clear();     // Catch: Throwable -> L18
        monitor-exit(r6);     // Catch: Throwable -> L18
        if (d.b.i.a.b.i.c.a(r8) == true) goto L28;
        this.f13842a.j(this.f13845d, r8);     // Catch: Exception -> L23
        return true;
    L29:
        return true;
    L28:
        return true;
    L18:
        th = move-exception;
        throw th;
    L6:
        if (r0 >= 5) goto L9;
        if ((r5 - this.f13844c) > 120000) goto L9;
        return false;
    L21:
        return false;
    }

    public void f(boolean r1) {
        this.f13846e = r1;
    }

    @Override // d.b.i.a.b.h.b
    public void onTimeEvent(long r2) {
        if (this.f13846e == true) goto L6;
        e(r2, false);
        return;
    }
}
