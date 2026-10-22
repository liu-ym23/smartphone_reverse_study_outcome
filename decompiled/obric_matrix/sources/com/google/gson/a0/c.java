package com.google.gson.a0;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class c implements Closeable, Flushable {
    private static final Pattern o = null;
    private static final String[] p = null;
    private static final String[] q = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Writer f6876f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int[] f6877g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f6878h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f6879i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f6880j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f6881k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f6882l;
    private String m;
    private boolean n;

    static {
        o = Pattern.compile("-?(?:0|[1-9][0-9]*)(?:\\.[0-9]+)?(?:[eE][-+]?[0-9]+)?");
        p = new String[128];
        int r1 = 0;
    L4:
        if (r1 > 31) goto L6;
        p[r1] = String.format("\\u%04x", new Object[]{Integer.valueOf(r1)});
        r1 = r1 + 1;
        goto L4
    L6:
        String[] r0 = p;
        r0[34] = "\\\"";
        r0[92] = "\\\\";
        r0[9] = "\\t";
        r0[8] = "\\b";
        r0[10] = "\\n";
        r0[13] = "\\r";
        r0[12] = "\\f";
        String[] r2 = (String[]) r0.clone();
        q = r2;
        r2[60] = "\\u003c";
        r2[62] = "\\u003e";
        r2[38] = "\\u0026";
        r2[61] = "\\u003d";
        r2[39] = "\\u0027";
    }

    public c(Writer r2) {
        this.f6877g = new int[32];
        this.f6878h = 0;
        V(6);
        this.f6880j = ":";
        this.n = true;
        Objects.requireNonNull(r2, "out == null");
        this.f6876f = r2;
    }

    private static boolean L(Class<? extends Number> r1) {
        if (r1 != Integer.class) goto L5;
    L24:
        return true;
    L5:
        if (r1 == Long.class) goto L24;
        if (r1 == Double.class) goto L24;
        if (r1 == Float.class) goto L24;
        if (r1 == Byte.class) goto L24;
        if (r1 == Short.class) goto L24;
        if (r1 == BigDecimal.class) goto L24;
        if (r1 == BigInteger.class) goto L24;
        if (r1 == AtomicInteger.class) goto L24;
        if (r1 == AtomicLong.class) goto L24;
        return false;
    }

    private void N() {
        if (this.f6879i != null) goto L5;
        return;
    L5:
        this.f6876f.write(10);
        int r0 = this.f6878h;
        int r1 = 1;
    L6:
        if (r1 >= r0) goto L8;
        this.f6876f.write(this.f6879i);
        r1 = r1 + 1;
        goto L6
    }

    private c Q(int r1, char r2) {
        b();
        V(r1);
        this.f6876f.write(r2);
        return this;
    }

    private int S() {
        int r0 = this.f6878h;
        if (r0 == 0) goto L7;
        return this.f6877g[r0 - 1];
    L7:
        throw new IllegalStateException("JsonWriter is closed.");
    }

    private void V(int r4) {
        int r0 = this.f6878h;
        int[] r1 = this.f6877g;
        if (r0 != r1.length) goto L5;
        this.f6877g = Arrays.copyOf(r1, r0 * 2);
    L5:
        int[] r2 = this.f6877g;
        int r3 = this.f6878h;
        this.f6878h = r3 + 1;
        r2[r3] = r4;
    }

    private void X(int r2) {
        this.f6877g[this.f6878h - 1] = r2;
    }

    private void a() {
        int r0 = S();
        if (r0 != 5) goto L6;
        this.f6876f.write(44);
    L7:
        N();
        X(4);
        return;
    L6:
        if (r0 == 3) goto L7;
        throw new IllegalStateException("Nesting problem.");
    }

    private void b() {
        int r0 = S();
        if (r0 == 1) goto L20;
        if (r0 != 2) goto L6;
        this.f6876f.append(',');
    L21:
        N();
        return;
    L6:
        if (r0 != 4) goto L8;
        this.f6876f.append(this.f6880j);
        X(5);
        return;
    L8:
        if (r0 == 6) goto L17;
        if (r0 != 7) goto L16;
        if (this.f6881k == true) goto L17;
        throw new IllegalStateException("JSON must have only one top-level value.");
    L16:
        throw new IllegalStateException("Nesting problem.");
    L17:
        X(7);
        return;
    L20:
        X(2);
        goto L21
    }

    private void i0(String r9) {
        if (this.f6882l == false) goto L5;
        String[] r0 = q;
    L6:
        this.f6876f.write(34);
        int r1 = r9.length();
        int r3 = 0;
        int r4 = 0;
    L7:
        if (r3 >= r1) goto L23;
        char r5 = r9.charAt(r3);
        if (r5 >= 128) goto L14;
        String r6 = r0[r5];
        if (r6 == null) goto L22;
    L19:
        if (r4 >= r3) goto L21;
        this.f6876f.write(r9, r4, r3 - r4);
    L21:
        this.f6876f.write(r6);
        r4 = r3 + 1;
    L22:
        r3 = r3 + 1;
        goto L7
    L14:
        if (r5 != 8232) goto L17;
        r6 = "\\u2028";
        goto L19
    L17:
        if (r5 != 8233) goto L22;
        r6 = "\\u2029";
        goto L19
    L23:
        if (r4 >= r1) goto L25;
        this.f6876f.write(r9, r4, r1 - r4);
    L25:
        this.f6876f.write(34);
        return;
    L5:
        r0 = p;
        goto L6
    }

    private void p0() {
        if (this.m == null) goto L6;
        a();
        i0(this.m);
        this.m = null;
        return;
    }

    private c s(int r2, int r3, char r4) {
        int r0 = S();
        if (r0 == r3) goto L9;
        if (r0 == r2) goto L9;
        throw new IllegalStateException("Nesting problem.");
    L9:
        if (this.m != null) goto L16;
        this.f6878h--;
        if (r0 != r3) goto L13;
        N();
    L13:
        this.f6876f.write(r4);
        return this;
    L16:
        throw new IllegalStateException("Dangling name: " + this.m);
    }

    public c A() {
        s(3, 5, '}');
        return this;
    }

    public final boolean C() {
        return this.n;
    }

    public final boolean E() {
        return this.f6882l;
    }

    public boolean F() {
        return this.f6881k;
    }

    public c M(String r2) {
        Objects.requireNonNull(r2, "name == null");
        if (this.m != null) goto L11;
        if (this.f6878h == 0) goto L9;
        this.m = r2;
        return this;
    L9:
        throw new IllegalStateException("JsonWriter is closed.");
    L11:
        throw new IllegalStateException();
    }

    public c O() {
        if (this.m != null) goto L5;
    L9:
        b();
        this.f6876f.write("null");
        return this;
    L5:
        if (this.n == false) goto L7;
        p0();
        goto L9
    L7:
        this.m = null;
        return this;
    }

    public final void Y(boolean r1) {
        this.f6882l = r1;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f6876f.close();
        int r0 = this.f6878h;
        if (r0 > 1) goto L10;
        if (r0 == 1) goto L6;
    L7:
        this.f6878h = 0;
        return;
    L6:
        if (this.f6877g[r0 - 1] == 7) goto L7;
    L10:
        throw new IOException("Incomplete document");
    }

    public final void d0(String r2) {
        if (r2.length() != 0) goto L5;
        this.f6879i = null;
        String r3 = ":";
    L6:
        this.f6880j = r3;
        return;
    L5:
        this.f6879i = r2;
        r3 = ": ";
        goto L6
    }

    @Override // java.io.Flushable
    public void flush() {
        if (this.f6878h == 0) goto L7;
        this.f6876f.flush();
        return;
    L7:
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public c g() {
        p0();
        Q(1, '[');
        return this;
    }

    public final void g0(boolean r1) {
        this.f6881k = r1;
    }

    public final void h0(boolean r1) {
        this.n = r1;
    }

    public c j0(double r3) {
        p0();
        if (this.f6881k == false) goto L5;
    L11:
        b();
        this.f6876f.append(Double.toString(r3));
        return this;
    L5:
        if (Double.isNaN(r3) == true) goto L10;
        if (Double.isInfinite(r3) == false) goto L11;
    L10:
        throw new IllegalArgumentException("Numeric values must be finite, but was " + r3);
    }

    public c k0(long r2) {
        p0();
        b();
        this.f6876f.write(Long.toString(r2));
        return this;
    }

    public c l() {
        p0();
        Q(3, '{');
        return this;
    }

    public c l0(Boolean r2) {
        if (r2 == null) goto L4;
        p0();
        b();
        Writer r0 = this.f6876f;
        if (r2.booleanValue() == false) goto L8;
        String r3 = "true";
    L9:
        r0.write(r3);
        return this;
    L8:
        r3 = "false";
        goto L9
    L4:
        return O();
    }

    public c m0(Number r4) {
        if (r4 == null) goto L4;
        p0();
        String r0 = r4.toString();
        if (r0.equals("-Infinity") == true) goto L20;
        if (r0.equals("Infinity") == true) goto L20;
        if (r0.equals("NaN") == true) goto L20;
        Class<?> r5 = r4.getClass();
        if (L(r5) == false) goto L15;
    L21:
        b();
        this.f6876f.append(r0);
        return this;
    L15:
        if (o.matcher(r0).matches() == true) goto L21;
        throw new IllegalArgumentException("String created by " + r5 + " is not a valid JSON number: " + r0);
    L20:
        if (this.f6881k == true) goto L21;
        throw new IllegalArgumentException("Numeric values must be finite, but was " + r0);
    L4:
        return O();
    }

    public c n0(String r1) {
        if (r1 == null) goto L4;
        p0();
        b();
        i0(r1);
        return this;
    L4:
        return O();
    }

    public c o0(boolean r2) {
        p0();
        b();
        Writer r0 = this.f6876f;
        if (r2 == false) goto L5;
        String r3 = "true";
    L6:
        r0.write(r3);
        return this;
    L5:
        r3 = "false";
        goto L6
    }

    public c x() {
        s(1, 2, ']');
        return this;
    }
}
