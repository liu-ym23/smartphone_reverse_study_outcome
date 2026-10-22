package f.a.h;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends RuntimeException {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List<Throwable> f17046f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f17047g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Throwable f17048h;

    /* JADX INFO: renamed from: f.a.h.a$a, reason: collision with other inner class name */
    static final class C0450a extends RuntimeException {
        C0450a() {
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return "Chain of Causes for CompositeException In Order Received =>";
        }
    }

    static abstract class b {
        b() {
        }

        abstract void a(Object r1);
    }

    static final class c extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final PrintStream f17049a;

        c(PrintStream r1) {
            this.f17049a = r1;
        }

        @Override // f.a.h.a.b
        void a(Object r1) {
            this.f17049a.println(r1);
        }
    }

    static final class d extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final PrintWriter f17050a;

        d(PrintWriter r1) {
            this.f17050a = r1;
        }

        @Override // f.a.h.a.b
        void a(Object r1) {
            this.f17050a.println(r1);
        }
    }

    public a(Iterable<? extends Throwable> r5) {
        LinkedHashSet r0 = new LinkedHashSet();
        ArrayList r1 = new ArrayList();
        if (r5 == null) goto L14;
        Iterator<? extends Throwable> r6 = r5.iterator();
    L6:
        if (r6.hasNext() == false) goto L16;
        Object r2 = (Throwable) r6.next();
        if ((r2 instanceof a) == true) goto L9;
        if (r2 != null) goto L13;
        r2 = new NullPointerException("Throwable was null!");
    L13:
        r0.add(r2);
        goto L6
    L9:
        r0.addAll(((a) r2).b());
    L16:
        if (r0.isEmpty() == true) goto L20;
        r1.addAll(r0);
        List<Throwable> r7 = Collections.unmodifiableList(r1);
        this.f17046f = r7;
        this.f17047g = r7.size() + " exceptions occurred. ";
        return;
    L20:
        throw new IllegalArgumentException("errors is empty");
    L14:
        r0.add(new NullPointerException("errors was null"));
        goto L16
    }

    public a(Throwable... r2) {
        if (r2 != null) goto L4;
        List r3 = Collections.singletonList(new NullPointerException("exceptions was null"));
    L5:
        this(r3);
        return;
    L4:
        r3 = Arrays.asList(r2);
        goto L5
    }

    private void a(StringBuilder r6, Throwable r7, String r8) {
        r6.append(r8);
        r6.append(r7);
        r6.append('\n');
        StackTraceElement[] r0 = r7.getStackTrace();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L6;
        StackTraceElement r3 = r0[r2];
        r6.append("\t\tat ");
        r6.append(r3);
        r6.append('\n');
        r2 = r2 + 1;
        goto L3
    L6:
        if (r7.getCause() == null) goto L10;
        r6.append("\tCaused by: ");
        a(r6, r7.getCause(), "");
        return;
    }

    private List<Throwable> c(Throwable r2) {
        ArrayList r1 = new ArrayList();
        Throwable r0 = r2.getCause();
        if (r0 == null) goto L11;
        if (r0 == r2) goto L11;
    L6:
        r1.add(r0);
        Throwable r3 = r0.getCause();
        if (r3 == null) goto L11;
        if (r3 == r0) goto L11;
        r0 = r3;
    L11:
        return r1;
    }

    private void e(b r8) {
        StringBuilder r0 = new StringBuilder(128);
        r0.append(this);
        r0.append('\n');
        StackTraceElement[] r2 = getStackTrace();
        int r3 = r2.length;
        int r4 = 0;
    L3:
        if (r4 >= r3) goto L5;
        StackTraceElement r5 = r2[r4];
        r0.append("\tat ");
        r0.append(r5);
        r0.append('\n');
        r4 = r4 + 1;
        goto L3
    L5:
        Iterator<Throwable> r1 = this.f17046f.iterator();
        int r6 = 1;
    L7:
        if (r1.hasNext() == false) goto L9;
        Throwable r7 = r1.next();
        r0.append("  ComposedException ");
        r0.append(r6);
        r0.append(" :\n");
        a(r0, r7, "\t");
        r6 = r6 + 1;
        goto L7
    L9:
        r8.a(r0.toString());
    }

    public List<Throwable> b() {
        return this.f17046f;
    }

    Throwable d(Throwable r1) {
        Throwable r0 = r1.getCause();
        if (r0 == null) goto L12;
        if (r1 == r0) goto L12;
    L6:
        Throwable r2 = r0.getCause();
        if (r2 == null) goto L11;
        if (r2 == r0) goto L11;
        r0 = r2;
    L11:
        return r0;
    L12:
        return r1;
    }

    @Override // java.lang.Throwable
    public synchronized Throwable getCause() {
        monitor-enter(this);
    L25:
        th = move-exception;
        throw th;
    L4:
        if (this.f17048h != null) goto L22;
        C0450a r0 = new C0450a();     // Catch: Throwable -> L25
        HashSet r1 = new HashSet();     // Catch: Throwable -> L25
        Iterator<Throwable> r2 = this.f17046f.iterator();     // Catch: Throwable -> L25
        Throwable r3 = r0;
    L7:
        if (r2.hasNext() == false) goto L21;
        Throwable r4 = r2.next();     // Catch: Throwable -> L25
        if (r1.contains(r4) == true) goto L7;
        r1.add(r4);     // Catch: Throwable -> L25
        Iterator<Throwable> r5 = c(r4).iterator();     // Catch: Throwable -> L25
    L13:
        if (r5.hasNext() == false) goto L31;
        Throwable r6 = r5.next();     // Catch: Throwable -> L25
        if (r1.contains(r6) == true) goto L16;
        r1.add(r6);     // Catch: Throwable -> L25
        goto L13
    L16:
        r4 = new RuntimeException("Duplicate found in causal chain so cropping to prevent loop ...");     // Catch: Throwable -> L25
        goto L13
    L31:
        r3.initCause(r4);     // Catch: Throwable -> L28
    L20:
        r3 = d(r3);     // Catch: Throwable -> L25
        goto L7
    L21:
        this.f17048h = r0;     // Catch: Throwable -> L25
    L22:
        Throwable r7 = this.f17048h;     // Catch: Throwable -> L25
        monitor-exit(this);
        return r7;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.f17047g;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream r2) {
        e(new c(r2));
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter r2) {
        e(new d(r2));
    }
}
