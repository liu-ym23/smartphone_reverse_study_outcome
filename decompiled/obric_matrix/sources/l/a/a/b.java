package l.a.a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b f21481a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private b f21482b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f21483c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<d> f21484d;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f21485a = null;

        static {
            int[] r0 = new int[EnumC0592b.values().length];
            f21485a = r0;
            r0[EnumC0592b.f21486f.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f21485a[EnumC0592b.f21487g.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    /* JADX INFO: renamed from: l.a.a.b$b, reason: collision with other inner class name */
    private static final enum EnumC0592b extends Enum<EnumC0592b> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final EnumC0592b f21486f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final EnumC0592b f21487g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final /* synthetic */ EnumC0592b[] f21488h = null;

        static {
            EnumC0592b r0 = new EnumC0592b("LEFT", 0);
            f21486f = r0;
            EnumC0592b r1 = new EnumC0592b("RIGHT", 1);
            f21487g = r1;
            f21488h = new EnumC0592b[]{r0, r1};
        }

        private EnumC0592b(String r1, int r2) {
            super(r1, r2);
        }

        public static EnumC0592b valueOf(String r1) {
            return (EnumC0592b) Enum.valueOf(EnumC0592b.class, r1);
        }

        public static EnumC0592b[] values() {
            return (EnumC0592b[]) f21488h.clone();
        }
    }

    public b(List<d> r6) {
        this.f21481a = null;
        this.f21482b = null;
        this.f21484d = new ArrayList();
        this.f21483c = e(r6);
        ArrayList r0 = new ArrayList();
        ArrayList r1 = new ArrayList();
        Iterator<d> r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L13;
        d r2 = r7.next();
        if (r2.h() < this.f21483c) goto L7;
        if (r2.getStart() > this.f21483c) goto L10;
        this.f21484d.add(r2);
        goto L4
    L10:
        r1.add(r2);
        goto L4
    L7:
        r0.add(r2);
        goto L4
    L13:
        if (r0.size() <= 0) goto L16;
        this.f21481a = new b(r0);
    L16:
        if (r1.size() <= 0) goto L28;
        this.f21482b = new b(r1);
        return;
    }

    protected void a(d r2, List<d> r3, List<d> r4) {
        Iterator<d> r1 = r4.iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        d r5 = r1.next();
        if (r5.equals(r2) == true) goto L4;
        r3.add(r5);
        goto L4
    }

    protected List<d> b(d r5, EnumC0592b r6) {
        ArrayList r0 = new ArrayList();
        Iterator<d> r4 = this.f21484d.iterator();
    L4:
        if (r4.hasNext() == false) goto L16;
        d r1 = r4.next();
        int r2 = a.f21485a[r6.ordinal()];
        if (r2 != 1) goto L8;
        if (r1.getStart() > r5.h()) goto L4;
    L15:
        r0.add(r1);
        goto L4
    L8:
        if (r2 != 2) goto L4;
        if (r1.h() < r5.getStart()) goto L4;
    L16:
        return r0;
    }

    protected List<d> c(d r2) {
        return b(r2, EnumC0592b.f21486f);
    }

    protected List<d> d(d r2) {
        return b(r2, EnumC0592b.f21487g);
    }

    public int e(List<d> r5) {
        Iterator<d> r4 = r5.iterator();
        int r0 = -1;
        int r1 = -1;
    L4:
        if (r4.hasNext() == false) goto L13;
        d r2 = r4.next();
        int r3 = r2.getStart();
        int r6 = r2.h();
        if (r0 == (-1)) goto L8;
        if (r3 < r0) goto L8;
    L9:
        if (r1 == (-1)) goto L11;
        if (r6 <= r1) goto L4;
    L11:
        r1 = r6;
    L8:
        r0 = r3;
        goto L9
    L13:
        return (r0 + r1) / 2;
    }

    protected List<d> f(b r1, d r2) {
        if (r1 == null) goto L6;
        return r1.g(r2);
    L6:
        return Collections.emptyList();
    }

    public List<d> g(d r4) {
        ArrayList r0 = new ArrayList();
        if (this.f21483c >= r4.getStart()) goto L7;
        a(r4, r0, f(this.f21482b, r4));
        List<d> r1 = d(r4);
    L5:
        a(r4, r0, r1);
        return r0;
    L7:
        if (this.f21483c <= r4.h()) goto L9;
        a(r4, r0, f(this.f21481a, r4));
        r1 = c(r4);
        goto L5
    L9:
        a(r4, r0, this.f21484d);
        a(r4, r0, f(this.f21481a, r4));
        r1 = f(this.f21482b, r4);
        goto L5
    }
}
