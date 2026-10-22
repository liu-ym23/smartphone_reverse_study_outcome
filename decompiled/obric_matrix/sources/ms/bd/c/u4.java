package ms.bd.c;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: classes2.dex */
public class u4 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile u4 f22512d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Handler f22513a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private HandlerThread f22514b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    c f22515c;

    class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ u4 f22516a;

        a(u4 r1, Looper r2) {
            this.f22516a = r1;
            super(r2);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r3) {
            int r0 = b.b()[r3.what].ordinal();
            if (r0 != 1) goto L5;
        L7:
            c r2 = this.f22516a.f22515c;
            if (r2 == null) goto L16;
            z3 r4 = (z3) r2;     // Catch: Exception -> L11
            r4.c(r3.what, (String) r3.obj);     // Catch: Exception -> L11
            return;
        L11:
            e = move-exception;
            e.getMessage();
            return;
        L16:
            return;
        L5:
            if (r0 == 2) goto L7;
        }
    }

    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final b f22517g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final b f22518h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final b f22519i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final /* synthetic */ b[] f22520j = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f22521f;

        static {
            b r0 = new b((String) m.a(16777217, 0, 0, "061b6c", new byte[]{5, 13, 125, 59, 58, 83, 12, 35, 89, 2, 4, 11, 108, 57, 39, 81}), 0, 0);
            b r1 = new b((String) m.a(16777217, 0, 0, "67c602", new byte[]{3, 12, 47, 111, 60, 2, 10, 34, 11, 86, 2, 10, 52, 123}), 1, 1);
            f22517g = r1;
            b r3 = new b((String) m.a(16777217, 0, 0, "dc54fc", new byte[]{81, 88, 121, 109, 106, 83, 88, 118, 93, 84, 80, 94, 98, 121, 102, 92, 83, 118, 84, 91, 69, 64, 114, 104}), 2, 2);
            f22518h = r3;
            b r5 = new b((String) m.a(16777217, 0, 0, "d3a296", new byte[]{81, 8, 45, 107, 53, 6, 88, 38, 9, 82, 80, 14, 54, 127, 57, 2, 75, 55, 17, 80, 74, 0, 39, 99, 51, 4}), 3, 3);
            f22519i = r5;
            f22520j = new b[]{r0, r1, r3, r5, new b((String) m.a(16777217, 0, 0, "4833c4", new byte[]{19, 27, 108, 114, 121, 28, 20, 52, 70, 92, 0, 20, 100}), 4, 4)};
        }

        private b(String r1, int r2, int r3) {
            super(r1, r2);
            this.f22521f = r3;
        }

        public static b[] b() {
            return (b[]) f22520j.clone();
        }

        public int a() {
            return this.f22521f;
        }
    }

    public interface c {
    }

    static {
        String r0 = (String) m.a(16777217, 0, 0, "667e3b", new byte[]{3, 45, 105, 2, 11, 68, 32, 18, 115, 48});
        f22512d = null;
    }

    private u4() {
        HandlerThread r0 = new HandlerThread((String) m.a(16777217, 0, 0, "a7fd1c", new byte[]{84, 44, 56, 3, 9, 69, 119, 19, 34, 49}));
        this.f22514b = r0;
        r0.start();
        this.f22513a = new a(this, this.f22514b.getLooper());
    }

    public static u4 a() {
        if (f22512d != null) goto L15;
        monitor-enter(u4.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f22512d != null) goto L9;
        f22512d = new u4();     // Catch: Throwable -> L11
    L9:
        monitor-exit(u4.class);     // Catch: Throwable -> L11
    L15:
        return f22512d;
    }

    public void b(c r1) {
        this.f22515c = r1;
    }

    public boolean c(b r3, String r4) {
        Handler r0 = this.f22513a;
        if (r0 != null) goto L6;
        return false;
    L6:
        if (r3 != b.f22519i) goto L8;
        r0.removeMessages(r3.a());
        return true;
    L8:
        Message r1 = new Message();
        r1.what = r3.ordinal();
        r1.obj = r4;
        return this.f22513a.sendMessage(r1);
    }
}
