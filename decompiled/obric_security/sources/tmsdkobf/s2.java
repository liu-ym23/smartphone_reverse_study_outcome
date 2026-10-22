package tmsdkobf;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public class s2 {
    private static s2 b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private v2.b f497a;

    class a extends v2.b {
        final /* synthetic */ s2 b;

        a(s2 r1) {
            this.b = r1;
        }

        @Override // tmsdkobf.v2.b
        public synchronized void a(v2.a r8) {
            monitor-enter(this);
            if (r8 != null) goto L76;
        L74:
            monitor-exit(this);
            return;
        L76:
            r2 r0 = r8.c;     // Catch: Throwable -> L71
            if (r0 == null) goto L74;
            v2.c r1 = r8.d;     // Catch: Throwable -> L71
            if (r1 != null) goto L10;
            int r2 = r0.f465a;     // Catch: Throwable -> L71
        L11:
            v2 r3 = (v2) qd.a(17);     // Catch: Throwable -> L71
            boolean r5 = false;
            if (1445 != r2) goto L32;
            if (r8.d == null) goto L17;
            monitor-exit(this);
            return;
        L17:
            l9 r4 = (l9) z7.a(r8.c.b, new l9(), false);     // Catch: Throwable -> L71
            if (r4 == null) goto L28;
            ArrayList r6 = r4.f325a;     // Catch: Throwable -> L71
            if (r6 == null) goto L28;
            if (r6.size() <= 1) goto L28;
            if (d3.b((String) r4.f325a.get(0)) != 1) goto L27;
            r5 = true;
        L27:
            m9.e().a(Boolean.valueOf(r5));     // Catch: Throwable -> L71
        L68:
            r3.a(r8, 3, 1);     // Catch: Throwable -> L71
            monitor-exit(this);
            return;
        L28:
            r3.a(r8, 3, 2);     // Catch: Throwable -> L71
            monitor-exit(this);
            return;
        L32:
            if (519 != r2) goto L36;
            monitor-exit(this);
            return;
        L36:
            if (1589 != r2) goto L52;
            if (r8.d != null) goto L68;
            l9 r7 = (l9) z7.a(r8.c.b, new l9(), false);     // Catch: Throwable -> L71
            if (r7 == null) goto L48;
            ArrayList r9 = r7.f325a;     // Catch: Throwable -> L71
            if (r9 == null) goto L48;
            if (r9.size() < 1) goto L48;
            f0.a(r7.f325a);     // Catch: Throwable -> L71
        L48:
            r3.a(r8, 3, 2);     // Catch: Throwable -> L71
            monitor-exit(this);
            return;
        L52:
            if (1628 != r2) goto L68;
            if (r8.d == null) goto L57;
            monitor-exit(this);
            return;
        L57:
            l9 r10 = (l9) z7.a(r8.c.b, new l9(), false);     // Catch: Throwable -> L71
            if (r10 == null) goto L65;
            ArrayList r11 = r10.f325a;     // Catch: Throwable -> L71
            if (r11 == null) goto L65;
            if (r11.size() < 1) goto L65;
            i4.b(r10.f325a);     // Catch: Throwable -> L71
        L65:
            r3.a(r8, 3, 2);     // Catch: Throwable -> L71
            monitor-exit(this);
            return;
        L10:
            r2 = r1.f566a;     // Catch: Throwable -> L71
        L71:
            th = move-exception;
            throw th;
        }
    }

    static {
    }

    public s2() {
        this.f497a = new a(this);
        v2 r0 = (v2) qd.a(17);
        r0.a(-1, this.f497a);
        r0.a(1445, this.f497a);
        r0.a(519, this.f497a);
        r0.a(1589, this.f497a);
        r0.a(1628, this.f497a);
    }

    public static s2 a() {
        if (b != null) goto L15;
        monitor-enter(s2.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (b != null) goto L9;
        b = new s2();     // Catch: Throwable -> L11
    L9:
        monitor-exit(s2.class);     // Catch: Throwable -> L11
    L15:
        return b;
    }
}
