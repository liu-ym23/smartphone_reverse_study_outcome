package ms.bd.c;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.provider.Settings;
import android.view.View;
import android.view.WindowManager;
import com.google.android.material.badge.BadgeDrawable;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingDeque;

/* JADX INFO: loaded from: classes2.dex */
public class u2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f22501a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f22502b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private WindowManager f22503c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f22504d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f22505e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final LinkedBlockingDeque<w2> f22506f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final w2 f22507g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Object f22508h;

    static {
        String r0 = (String) m.a(16777217, 0, 0, "cb7d6d", new byte[]{86, 111, 81, 41, 0, 125, 76, 74, 112, 49});
        String r1 = (String) m.a(16777217, 0, 0, "f4bc25", new byte[]{123, 63, 7, 18, 50, 54, 96, 6});
    }

    public u2(Context r8) {
        this.f22505e = false;
        this.f22507g = new w2();
        this.f22506f = new LinkedBlockingDeque();
        this.f22508h = new Object();
        boolean r0 = d(r8);
        this.f22501a = r0;
        if (r0 == true) goto L6;
        String r7 = (String) m.a(16777217, 0, 0, "11c7da", new byte[]{4, 60, 5, 122, 82, 120, 30, 25, 36, 98});
        String r9 = (String) m.a(16777217, 0, 0, "89683e", new byte[]{6, 45, 64, 94, 0, 115, 34, 88, 119, 109, 59, 54, 76, 95, 31, 123, 52, 22, 39, 97, 58, 123, 75, 67, 24, 50, 60, 10, 102, 102, 61, 62, 65, 2});
        return;
    L6:
        this.f22502b = r8;
        this.f22503c = (WindowManager) r8.getSystemService((String) m.a(16777217, 0, 0, "dcb1be", new byte[]{98, 104, 31, 65, 82, 101}));
    }

    static /* synthetic */ w2 a(u2 r0) {
        return r0.f22507g;
    }

    public static boolean d(Context r2) {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return true;
    L5:
        return Settings.canDrawOverlays(r2);
    }

    public void b(boolean r3) {
        if (this.f22501a == false) goto L16;
        View r0 = this.f22504d;
        if (r0 != null) goto L7;
    L10:
        if (r3 == false) goto L17;
        this.f22504d = null;
        w2 r2 = this.f22507g;
        r2.f22532g = 0;
        r2.f22533h = 0;
        r2.f22531f = 0;
        return;
    L17:
        return;
    L7:
        if (this.f22505e == false) goto L10;
        this.f22503c.removeView(r0);     // Catch: Exception -> L13
    L9:
        this.f22505e = false;
        goto L10
    }

    public boolean c() {
        return this.f22501a;
    }

    public void e() {
        if (this.f22501a == true) goto L5;
        return;
    L5:
        if (this.f22504d != null) goto L8;
        this.f22504d = new t2(this, this.f22502b);
    L8:
        if (this.f22505e == false) goto L11;
        return;
    L11:
        if (Build.VERSION.SDK_INT < 26) goto L13;
        int r1 = 2038;
    L14:
        WindowManager.LayoutParams r0 = new WindowManager.LayoutParams(1, 1, r1, 262152, -3);
        r0.gravity = BadgeDrawable.TOP_END;
        this.f22503c.addView(this.f22504d, r0);     // Catch: Exception -> L18
    L16:
        this.f22505e = true;
        return;
    L13:
        r1 = 2002;
        goto L14
    }

    public String f() {
        if (this.f22501a == true) goto L7;
        w2 r14 = this.f22507g;
        r14.f22532g = -1;
        return r14.toString();
    L7:
        if (this.f22506f.isEmpty() == true) goto L32;
        Object r0 = this.f22508h;
        monitor-enter(r0);
        int r8 = 0;
        String r1 = (String) m.a(16777217, 0, 0, "f5532a", new byte[]{50, 51, 6, 85, 8, 123, 100, 29, 106, 102, 115, 119, 82, 72, 77, 116, 96, 84, 118, 102, 103, 56, 84, 83, 8, 114, 43});     // Catch: Throwable -> L29
        this.f22506f.size();     // Catch: Throwable -> L29
        LinkedBlockingDeque<w2> r2 = this.f22506f;     // Catch: Throwable -> L29
        int r3 = r4.f22479a;     // Catch: Throwable -> L29
        if (r2 != null) goto L14;
    L25:
        String r4 = "";
    L26:
        this.f22506f.clear();     // Catch: Throwable -> L29
        monitor-exit(r0);     // Catch: Throwable -> L29
        return r4;
    L14:
        if (r2.isEmpty() == true) goto L25;
        StringBuilder r5 = new StringBuilder();     // Catch: Throwable -> L29
        Iterator<w2> r6 = r2.iterator();     // Catch: Throwable -> L29
    L18:
        if (r6.hasNext() == false) goto L23;
        r5.append(r6.next().toString());     // Catch: Throwable -> L29
        if (r8 >= (r2.size() - 1)) goto L22;
        r5.append('|');     // Catch: Throwable -> L29
    L22:
        r8 = r8 + 1;     // Catch: Throwable -> L29
        goto L18
    L23:
        r4 = r5.toString();     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        throw th;
    L32:
        return "";
    }

    public void g() {
        if (this.f22501a == false) goto L15;
        this.f22507g.f22536k = SystemClock.uptimeMillis();
        this.f22507g.f22531f++;
        String r0 = (String) m.a(16777217, 0, 0, "532dc6", new byte[]{121, 108, 28, 77, 1, 124, 107, 79, 62, 105, 100, 116, 82, 80, 1, 124, 107, 79, 62, 105, 121, 108, 28, 77, 28});
        w2 r1 = this.f22507g.a();
        Object r2 = this.f22508h;
        monitor-enter(r2);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (this.f22506f.size() <= 50) goto L9;
        this.f22506f.pop();     // Catch: Throwable -> L12
    L9:
        this.f22506f.add(r1);     // Catch: Throwable -> L12
        monitor-exit(r2);     // Catch: Throwable -> L12
        w2 r7 = this.f22507g;
        r7.f22532g = 0;
        r7.f22533h = 0;
        return;
    }
}
