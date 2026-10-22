package d.c.f.b;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final b f15548b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f15549c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Queue<a> f15550a;

    public static final enum a extends Enum<a> {
        public static final a A = null;
        public static final a B = null;
        public static final a C = null;
        private static final /* synthetic */ a[] D = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f15551f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f15552g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final a f15553h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final a f15554i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final a f15555j = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final a f15556k = null;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final a f15557l = null;
        public static final a m = null;
        public static final a n = null;
        public static final a o = null;
        public static final a p = null;
        public static final a q = null;
        public static final a r = null;
        public static final a s = null;
        public static final a t = null;
        public static final a u = null;
        public static final a v = null;
        public static final a w = null;
        public static final a x = null;
        public static final a y = null;
        public static final a z = null;

        static {
            a r0 = new a("ON_SET_HIERARCHY", 0);
            f15551f = r0;
            a r1 = new a("ON_CLEAR_HIERARCHY", 1);
            f15552g = r1;
            a r3 = new a("ON_SET_CONTROLLER", 2);
            f15553h = r3;
            a r5 = new a("ON_CLEAR_OLD_CONTROLLER", 3);
            f15554i = r5;
            a r7 = new a("ON_CLEAR_CONTROLLER", 4);
            f15555j = r7;
            a r9 = new a("ON_INIT_CONTROLLER", 5);
            f15556k = r9;
            a r11 = new a("ON_ATTACH_CONTROLLER", 6);
            f15557l = r11;
            a r13 = new a("ON_DETACH_CONTROLLER", 7);
            m = r13;
            a r15 = new a("ON_RELEASE_CONTROLLER", 8);
            n = r15;
            a r14 = new a("ON_DATASOURCE_SUBMIT", 9);
            o = r14;
            a r12 = new a("ON_DATASOURCE_RESULT", 10);
            p = r12;
            a r10 = new a("ON_DATASOURCE_RESULT_INT", 11);
            q = r10;
            a r8 = new a("ON_DATASOURCE_FAILURE", 12);
            r = r8;
            a r6 = new a("ON_DATASOURCE_FAILURE_INT", 13);
            s = r6;
            a r4 = new a("ON_HOLDER_ATTACH", 14);
            t = r4;
            a r2 = new a("ON_HOLDER_DETACH", 15);
            u = r2;
            a r16 = new a("ON_DRAWABLE_SHOW", 16);
            v = r16;
            a r17 = new a("ON_DRAWABLE_HIDE", 17);
            w = r17;
            a r18 = new a("ON_ACTIVITY_START", 18);
            x = r18;
            a r19 = new a("ON_ACTIVITY_STOP", 19);
            y = r19;
            a r20 = new a("ON_RUN_CLEAR_CONTROLLER", 20);
            z = r20;
            a r21 = new a("ON_SCHEDULE_CLEAR_CONTROLLER", 21);
            A = r21;
            a r22 = new a("ON_SAME_CONTROLLER_SKIPPED", 22);
            B = r22;
            a r23 = new a("ON_SUBMIT_CACHE_HIT", 23);
            C = r23;
            D = new a[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16, r17, r18, r19, r20, r21, r22, r23};
        }

        private a(String r1, int r2) {
            super(r1, r2);
        }

        public static a valueOf(String r1) {
            return (a) Enum.valueOf(a.class, r1);
        }

        public static a[] values() {
            return (a[]) D.clone();
        }
    }

    static {
        f15548b = new b();
        f15549c = true;
    }

    private b() {
        this.f15550a = new ArrayBlockingQueue(20);
    }

    public static b a() {
        if (f15549c == false) goto L6;
        return new b();
    L6:
        return f15548b;
    }

    public void b(a r3) {
        if (f15549c == true) goto L6;
        return;
    L6:
        if ((this.f15550a.size() + 1) <= 20) goto L8;
        this.f15550a.poll();
    L8:
        this.f15550a.add(r3);
    }

    public String toString() {
        return this.f15550a.toString();
    }
}
