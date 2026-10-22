package d.c.i.l;

import android.graphics.ColorSpace;
import android.graphics.Rect;
import android.util.Pair;
import com.facebook.imageutils.DngExifUtil;
import com.facebook.imageutils.HeifExifUtil;
import d.c.c.d.l;
import d.c.c.g.j;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class e implements Closeable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final d.c.c.h.a<d.c.c.g.h> f16178f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final l<FileInputStream> f16179g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private d.c.h.d f16180h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f16181i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f16182j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f16183k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f16184l;
    private int m;
    private int n;
    private d.c.i.f.a o;
    private ColorSpace p;
    private boolean q;
    private int r;
    private Rect s;
    private Map<String, String> t;
    private boolean u;
    private boolean v;
    private boolean w;
    private boolean x;

    public static class a implements d.c.c.g.h, d.c.c.h.c<a>, h {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final d.c.c.h.a<d.c.c.g.h> f16185f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private Map<String, String> f16186g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f16187h;

        public a(d.c.c.h.a<d.c.c.g.h> r1) {
            this.f16185f = r1;
        }

        static /* synthetic */ boolean b(a r0) {
            return r0.f16187h;
        }

        @Override // d.c.i.l.h
        public void a() {
            x(true);
        }

        @Override // d.c.c.g.h, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f16185f.N().close();
        }

        @Override // d.c.c.g.h
        public byte f(int r1) {
            return this.f16185f.N().f(r1);
        }

        public Map<String, String> g() {
            return this.f16186g;
        }

        @Override // d.c.c.g.h
        public int h(int r1, byte[] r2, int r3, int r4) {
            return this.f16185f.N().h(r1, r2, r3, r4);
        }

        @Override // d.c.c.g.h
        public ByteBuffer i() {
            return this.f16185f.N().i();
        }

        @Override // d.c.c.g.h
        public boolean isClosed() {
            return this.f16185f.N().isClosed();
        }

        @Override // d.c.c.g.h
        public long j() {
            return this.f16185f.N().j();
        }

        public void l(a r1) {
            r1.f16185f.close();
        }

        @Override // d.c.c.h.c
        public /* bridge */ /* synthetic */ void release(a r1) {
            l(r1);
        }

        public void s(Map<String, String> r1) {
            this.f16186g = r1;
        }

        @Override // d.c.c.g.h
        public int size() {
            return this.f16185f.N().size();
        }

        public void x(boolean r1) {
            this.f16187h = r1;
        }
    }

    public e(l<FileInputStream> r4) {
        this.f16180h = d.c.h.d.f15831b;
        this.f16181i = -1;
        this.f16182j = 0;
        this.f16183k = -1;
        this.f16184l = -1;
        this.m = 1;
        this.n = -1;
        this.q = true;
        this.r = 0;
        this.u = false;
        this.v = false;
        this.w = false;
        d.c.c.d.i.g(r4);
        this.f16178f = null;
        this.f16179g = r4;
    }

    public e(l<FileInputStream> r1, int r2) {
        this(r1);
        this.n = r2;
    }

    public e(d.c.c.h.a<d.c.c.g.h> r4) {
        this.f16180h = d.c.h.d.f15831b;
        this.f16181i = -1;
        this.f16182j = 0;
        this.f16183k = -1;
        this.f16184l = -1;
        this.m = 1;
        this.n = -1;
        this.q = true;
        this.r = 0;
        this.u = false;
        this.v = false;
        this.w = false;
        d.c.c.d.i.b(d.c.c.h.a.S(r4));
        d.c.c.g.h r0 = r4.N();
        if ((r0 instanceof a) == false) goto L7;
        this.f16178f = r4.a();
        a r1 = (a) r0;
        this.t = r1.g();
        if (a.b(r1) == false) goto L8;
        h0();
        r1.x(false);
    L8:
        this.f16179g = null;
        return;
    L7:
        this.f16178f = d.c.c.h.a.V(new a(r4.a()));
        goto L8
    }

    public static e b(e r0) {
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.a();
    }

    public static void g(e r0) {
        if (r0 == null) goto L5;
        r0.close();
        return;
    }

    private boolean j0() {
        int r1 = this.r;
        if (r1 != 0) goto L5;
    L8:
        return true;
    L5:
        if (r1 == 3) goto L8;
        return false;
    }

    public static boolean n0(e r1) {
        if (r1.f16181i >= 0) goto L5;
    L9:
        return false;
    L5:
        if (r1.f16183k < 0) goto L9;
        if (r1.f16184l < 0) goto L9;
        return true;
    }

    public static boolean q0(e r0) {
        if (r0 != null) goto L4;
    L6:
        return false;
    L4:
        if (r0.p0() == false) goto L6;
        return true;
    }

    private void s0() {
        if (this.f16183k >= 0) goto L5;
    L6:
        r0();
        return;
    L5:
        if (this.f16184l < 0) goto L6;
    }

    private Rect t0(Map<String, String> r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        if (r2.isEmpty() == true) goto L13;
        String r3 = r2.get("regionToDecode");
        if (r3 != null) goto L11;
        return null;
    L11:
        return Rect.unflattenFromString(r3);
    L13:
        return null;
    }

    private Pair<Integer, Integer> u0() {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            this = this;
            java.io.InputStream r0 = r5.O()
            boolean r1 = d.c.i.r.b.d()     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L50
            if (r1 == 0) goto Lf
            java.lang.String r1 = "EncodedImage#readAvifImageMetaData"
            d.c.i.r.b.a(r1)     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L50
        Lf:
            int[] r1 = com.facebook.imageutils.a.d(r0)     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L50
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L2e
            r4 = r1[r3]     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L50
            r5.f16183k = r4     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L50
            r4 = r1[r2]     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L50
            r5.f16184l = r4     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L50
            r4 = 2
            r4 = r1[r4]     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L50
            int r4 = com.facebook.imageutils.f.h(r4)     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L50
            r5.f16182j = r4     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L50
            int r4 = com.facebook.imageutils.f.a(r4)     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L50
            r5.f16181i = r4     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L50
        L2e:
            android.util.Pair r5 = new android.util.Pair     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L50
            r3 = r1[r3]     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L50
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L50
            r1 = r1[r2]     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L50
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L50
            r5.<init>(r3, r1)     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L50
            if (r0 == 0) goto L44
            r0.close()     // Catch: java.io.IOException -> L44
        L44:
            boolean r0 = d.c.i.r.b.d()
            if (r0 == 0) goto L4d
            d.c.i.r.b.b()
        L4d:
            return r5
        L4e:
            r5 = move-exception
            goto L64
        L50:
            r5 = move-exception
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L4e
            if (r0 == 0) goto L59
            r0.close()     // Catch: java.io.IOException -> L59
        L59:
            boolean r5 = d.c.i.r.b.d()
            if (r5 == 0) goto L62
            d.c.i.r.b.b()
        L62:
            r5 = 0
            return r5
        L64:
            if (r0 == 0) goto L69
            r0.close()     // Catch: java.io.IOException -> L69
        L69:
            boolean r0 = d.c.i.r.b.d()
            if (r0 == 0) goto L72
            d.c.i.r.b.b()
        L72:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: d.c.i.l.e.u0():android.util.Pair");
    }

    private Pair<Integer, Integer> v0() {
        InputStream r0 = O();
        int[] r1 = com.facebook.imageutils.d.g(r0);     // Catch: Throwable -> L11 Exception -> L13
        if (r1 == null) goto L8;
        this.f16183k = r1[0];     // Catch: Throwable -> L11 Exception -> L13
        this.f16184l = r1[1];     // Catch: Throwable -> L11 Exception -> L13
        int r2 = com.facebook.imageutils.f.g(r1[2]);     // Catch: Throwable -> L11 Exception -> L13
        this.f16181i = r2;     // Catch: Throwable -> L11 Exception -> L13
        this.f16182j = com.facebook.imageutils.f.b(r2);     // Catch: Throwable -> L11 Exception -> L13
        if (r1[3] != 0) goto L8;
        this.f16180h = com.facebook.imageutils.d.d();     // Catch: Throwable -> L11 Exception -> L13
    L8:
        if (r0 != null) goto L28;
        return null;
    L28:
        r0.close();     // Catch: IOException -> L22
        return null;
    L32:
        return null;
    L11:
        th = move-exception;
        if (r0 != null) goto L25;
    L21:
        throw th;
    L25:
        r0.close();     // Catch: IOException -> L23
    L13:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L11
        if (r0 != null) goto L28;
        return null;
    }

    private com.facebook.imageutils.e w0() {
        InputStream r0 = O();     // Catch: Throwable -> L11
        com.facebook.imageutils.e r1 = com.facebook.imageutils.b.b(r0);     // Catch: Throwable -> L9
        this.p = r1.a();     // Catch: Throwable -> L9
        Pair<Integer, Integer> r2 = r1.b();     // Catch: Throwable -> L9
        if (r2 == null) goto L6;
        this.f16183k = ((Integer) r2.first).intValue();     // Catch: Throwable -> L9
        this.f16184l = ((Integer) r2.second).intValue();     // Catch: Throwable -> L9
    L6:
        if (r0 != null) goto L22;
    L8:
        return r1;
    L22:
        r0.close();     // Catch: IOException -> L16
    L9:
        th = th;
    L13:
        if (r0 != null) goto L20;
    L15:
        throw th;
    L20:
        r0.close();     // Catch: IOException -> L17
    L11:
        th = th;
        r0 = null;
        goto L13
    }

    private Pair<Integer, Integer> x0() {
        Pair<Integer, Integer> r0 = com.facebook.imageutils.i.g(O());
        if (r0 == null) goto L5;
        this.f16183k = ((Integer) r0.first).intValue();
        this.f16184l = ((Integer) r0.second).intValue();
    L5:
        return r0;
    }

    public ColorSpace A() {
        s0();
        return this.p;
    }

    public void A0(int r1) {
        this.f16182j = r1;
    }

    public void B0(Map<String, String> r2) {
        this.t = r2;
        d.c.c.h.a<d.c.c.g.h> r0 = this.f16178f;
        if (r0 != null) goto L5;
        return;
    L5:
        if ((r0.N() instanceof a) == false) goto L9;
        ((a) this.f16178f.N()).s(r2);
        return;
    }

    public int C() {
        return this.r;
    }

    public void C0(int r1) {
        this.f16184l = r1;
    }

    public void D0(d.c.h.d r1) {
        this.f16180h = r1;
    }

    public int E() {
        s0();
        return this.f16182j;
    }

    public void E0(boolean r1) {
        this.x = r1;
    }

    public Map<String, String> F() {
        return this.t;
    }

    public void F0() {
        this.w = false;
        this.v = false;
        this.u = true;
    }

    public void G0(int r1) {
        this.f16181i = r1;
    }

    public void H0(int r1) {
        this.m = r1;
    }

    public void I0(int r1) {
        this.f16183k = r1;
    }

    public String L(int r6) {
        d.c.c.h.a<d.c.c.g.h> r0 = s();
        if (r0 != null) goto L5;
        return "";
    L5:
        int r5 = Math.min(X(), r6);
        byte[] r7 = new byte[r5];
        d.c.c.g.h r2 = r0.N();     // Catch: Throwable -> L17
        if (r2 != null) goto L11;
        r0.close();
        return "";
    L11:
        r2.h(0, r7, 0, r5);     // Catch: Throwable -> L17
        r0.close();
        StringBuilder r1 = new StringBuilder(r5 * 2);
        int r3 = 0;
    L13:
        if (r3 >= r5) goto L16;
        r1.append(String.format("%02X", new Object[]{Byte.valueOf(r7[r3])}));
        r3 = r3 + 1;
        goto L13
    L16:
        return r1.toString();
    L17:
        th = move-exception;
        r0.close();
        throw th;
    }

    public int M() {
        s0();
        return this.f16184l;
    }

    public d.c.h.d N() {
        s0();
        return this.f16180h;
    }

    public InputStream O() {
        l<FileInputStream> r0 = this.f16179g;
        if (r0 != null) goto L5;
        d.c.c.h.a r2 = d.c.c.h.a.E(this.f16178f);
        if (r2 != null) goto L16;
        return null;
    L16:
        j r1 = new j((d.c.c.g.h) r2.N());     // Catch: Throwable -> L11
        d.c.c.h.a.L(r2);
        return r1;
    L11:
        th = move-exception;
        d.c.c.h.a.L(r2);
        throw th;
    L5:
        return r0.get();
    }

    public Rect Q() {
        return this.s;
    }

    public int S() {
        s0();
        return this.f16181i;
    }

    public int V() {
        return this.m;
    }

    public int X() {
        d.c.c.h.a<d.c.c.g.h> r0 = this.f16178f;
        if (r0 == null) goto L9;
        if (r0.N() == null) goto L9;
        return this.f16178f.N().size();
    L9:
        return this.n;
    }

    public int Y() {
        s0();
        return this.f16183k;
    }

    public e a() {
        l<FileInputStream> r0 = this.f16179g;
        if (r0 == null) goto L5;
        e r1 = new e(r0, this.n);
    L10:
        if (r1 == null) goto L12;
        r1.l(this);
    L12:
        return r1;
    L5:
        d.c.c.h.a r2 = d.c.c.h.a.E(this.f16178f);
        if (r2 != null) goto L16;
        r1 = null;
    L9:
        d.c.c.h.a.L(r2);
        goto L10
    L16:
        r1 = new e(r2);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        d.c.c.h.a.L(r2);
        throw th;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        d.c.c.h.a.L(this.f16178f);
    }

    public boolean d0() {
        return this.q;
    }

    public void g0() {
        this.w = false;
        this.v = true;
        this.u = false;
    }

    public void h0() {
        this.w = true;
        this.v = false;
        this.u = false;
    }

    public boolean i0(int r5) {
        d.c.h.d r0 = this.f16180h;
        d.c.h.d r1 = d.c.h.c.f15819a;
        if (r0 == r1) goto L10;
        if (r0 == d.c.h.c.f15828j) goto L10;
        if (r0 == d.c.h.c.m) goto L10;
        return true;
    L10:
        if (this.f16179g == null) goto L12;
        return true;
    L12:
        d.c.c.d.i.g(this.f16178f);
        d.c.c.g.h r2 = this.f16178f.N();
        d.c.h.d r3 = this.f16180h;
        if (r3 != r1) goto L22;
        if (r2.f(r5 - 2) == (-1)) goto L17;
    L19:
        return false;
    L17:
        if (r2.f(r5 - 1) != (-39)) goto L19;
        return true;
    L22:
        if (r3 == d.c.h.c.f15828j) goto L24;
        return true;
    L24:
        return j0();
    }

    public boolean k0() {
        return this.x;
    }

    public void l(e r2) {
        this.f16180h = r2.N();
        this.f16183k = r2.Y();
        this.f16184l = r2.M();
        this.f16181i = r2.S();
        this.f16182j = r2.E();
        this.m = r2.V();
        this.n = r2.X();
        this.o = r2.x();
        this.p = r2.A();
        this.q = r2.d0();
        this.r = r2.C();
        this.s = r2.Q();
        this.t = r2.F();
        this.u = r2.u;
        this.v = r2.v;
        this.w = r2.w;
    }

    public boolean l0() {
        return this.v;
    }

    public boolean m0() {
        return this.w;
    }

    public boolean o0() {
        return this.u;
    }

    public synchronized boolean p0() {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (d.c.c.h.a.S(this.f16178f) == true) goto L9;
        if (this.f16179g != null) goto L9;
        boolean r0 = false;
    L10:
        monitor-exit(this);
        return r0;
    L9:
        r0 = true;
        goto L10
    }

    public void r0() {
        d.c.h.d r0 = d.c.h.e.c(O());
        this.f16180h = r0;
        if (d.c.h.c.g(r0) == false) goto L6;
        Pair<Integer, Integer> r1 = x0();
    L13:
        if (r0 != d.c.h.c.f15819a) goto L19;
        if (this.f16181i != (-1)) goto L19;
        if (r1 == null) goto L33;
        int r2 = com.facebook.imageutils.f.c(O());
    L23:
        this.f16182j = r2;
        int r3 = com.facebook.imageutils.f.a(r2);
    L24:
        this.f16181i = r3;
    L33:
        this.q = d.c.h.a.a(r0, O());
        this.s = t0(this.t);
        return;
    L19:
        if (r0 != d.c.h.c.f15829k) goto L26;
        if (this.f16181i != (-1)) goto L26;
        r2 = HeifExifUtil.a(O());
    L26:
        if (r0 != d.c.h.c.m) goto L31;
        if (this.f16181i != (-1)) goto L31;
        r2 = DngExifUtil.a(O());
    L31:
        if (this.f16181i != (-1)) goto L33;
        r3 = 0;
        goto L24
    L6:
        if (d.c.h.c.d(r0) == false) goto L9;
        r1 = v0();
        goto L13
    L9:
        if (d.c.h.c.c(r0) == false) goto L11;
        r1 = u0();
        goto L13
    L11:
        r1 = w0().b();
        goto L13
    }

    public d.c.c.h.a<d.c.c.g.h> s() {
        return d.c.c.h.a.E(this.f16178f);
    }

    public d.c.i.f.a x() {
        return this.o;
    }

    public void y0(d.c.i.f.a r1) {
        this.o = r1;
    }

    public void z0(int r1) {
        this.r = r1;
    }
}
