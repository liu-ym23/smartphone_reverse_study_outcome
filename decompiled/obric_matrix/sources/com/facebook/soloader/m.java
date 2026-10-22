package com.facebook.soloader;

import android.content.Context;
import android.os.Parcel;
import android.os.StrictMode;
import android.util.Log;
import java.io.Closeable;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class m extends com.facebook.soloader.c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final Context f6827c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected String f6828d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Map<String, Object> f6829e;

    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ File f6830f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ byte[] f6831g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ c f6832h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ File f6833i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ g f6834j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ m f6835k;

        a(m r1, File r2, byte[] r3, c r4, File r5, g r6) {
            this.f6835k = r1;
            this.f6830f = r2;
            this.f6831g = r3;
            this.f6832h = r4;
            this.f6833i = r5;
            this.f6834j = r6;
        }

        @Override // java.lang.Runnable
        public void run() {
            Log.v("fb-UnpackingSoSource", "starting syncer worker");     // Catch: Throwable -> L26
            RandomAccessFile r4 = new RandomAccessFile(this.f6830f, "rw");     // Catch: Throwable -> L26
            r4.write(this.f6831g);     // Catch: Throwable -> L18
            r4.setLength(r4.getFilePointer());     // Catch: Throwable -> L18
            r4.close();     // Catch: Throwable -> L26
            RandomAccessFile r5 = new RandomAccessFile(new File(this.f6835k.f6809a, "dso_manifest"), "rw");     // Catch: Throwable -> L26
            this.f6832h.b(r5);     // Catch: Throwable -> L10
            r5.close();     // Catch: Throwable -> L26
            SysUtil.e(this.f6835k.f6809a);     // Catch: Throwable -> L26
            m.f(this.f6833i, (byte) 1);     // Catch: Throwable -> L26
            Log.v("fb-UnpackingSoSource", "releasing dso store lock for " + this.f6835k.f6809a + " (from syncer thread)");     // Catch: IOException -> L29
            this.f6834j.close();     // Catch: IOException -> L29
            return;
        L10:
            th = move-exception;
            throw th;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            r5.close();     // Catch: Throwable -> L15
        L17:
            throw th;     // Catch: Throwable -> L26
        L15:
            th = move-exception;
            th.addSuppressed(th);     // Catch: Throwable -> L26
            goto L17
        L18:
            th = move-exception;
            throw th;     // Catch: Throwable -> L20
        L20:
            th = move-exception;
            r4.close();     // Catch: Throwable -> L23
        L25:
            throw th;     // Catch: Throwable -> L26
        L23:
            th = move-exception;
            th.addSuppressed(th);     // Catch: Throwable -> L26
        L29:
            e = move-exception;
            throw new RuntimeException(e);
        L26:
            th = move-exception;
            Log.v("fb-UnpackingSoSource", "releasing dso store lock for " + this.f6835k.f6809a + " (from syncer thread)");     // Catch: IOException -> L29
            this.f6834j.close();     // Catch: IOException -> L29
            throw th;     // Catch: IOException -> L29
        }
    }

    public static class b {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f6836f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f6837g;

        public b(String r1, String r2) {
            this.f6836f = r1;
            this.f6837g = r2;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b[] f6838a;

        public c(b[] r1) {
            this.f6838a = r1;
        }

        static final c a(DataInput r6) {
            if (r6.readByte() != 1) goto L14;
            int r0 = r6.readInt();
            if (r0 < 0) goto L12;
            b[] r1 = new b[r0];
            int r2 = 0;
        L7:
            if (r2 >= r0) goto L10;
            r1[r2] = new b(r6.readUTF(), r6.readUTF());
            r2 = r2 + 1;
            goto L7
        L10:
            return new c(r1);
        L12:
            throw new RuntimeException("illegal number of shared libraries");
        L14:
            throw new RuntimeException("wrong dso manifest version");
        }

        public final void b(DataOutput r4) {
            r4.writeByte(1);
            r4.writeInt(this.f6838a.length);
            int r0 = 0;
        L3:
            b[] r1 = this.f6838a;
            if (r0 >= r1.length) goto L6;
            r4.writeUTF(r1[r0].f6836f);
            r4.writeUTF(this.f6838a[r0].f6837g);
            r0 = r0 + 1;
            goto L3
        }
    }

    protected static final class d implements Closeable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final b f6839f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final InputStream f6840g;

        public d(b r1, InputStream r2) {
            this.f6839f = r1;
            this.f6840g = r2;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f6840g.close();
        }
    }

    protected static abstract class e implements Closeable {
        protected e() {
        }

        public abstract boolean a();

        public abstract d b();

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }
    }

    protected static abstract class f implements Closeable {
        protected f() {
        }

        protected abstract c a();

        protected abstract e b();

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }
    }

    protected m(Context r2, String r3) {
        super(k(r2, r3), 1);
        this.f6829e = new HashMap();
        this.f6827c = r2;
    }

    static /* synthetic */ void f(File r0, byte r1) {
        q(r0, r1);
    }

    private void g(b[] r8) {
        String[] r0 = this.f6809a.list();
        if (r0 == null) goto L29;
        int r2 = 0;
    L6:
        if (r2 >= r0.length) goto L27;
        String r3 = r0[r2];
        if (r3.equals("dso_state") == true) goto L26;
        if (r3.equals("dso_lock") == true) goto L26;
        if (r3.equals("dso_deps") == true) goto L26;
        if (r3.equals("dso_manifest") == true) goto L26;
        boolean r4 = false;
        int r5 = 0;
    L17:
        if (r4 == true) goto L24;
        if (r5 >= r8.length) goto L24;
        if (r8[r5].f6836f.equals(r3) == false) goto L23;
        r4 = true;
    L23:
        r5 = r5 + 1;
    L24:
        if (r4 == true) goto L26;
        File r6 = new File(this.f6809a, r3);
        Log.v("fb-UnpackingSoSource", "deleting unaccounted-for file " + r6);
        SysUtil.b(r6);
    L26:
        r2 = r2 + 1;
        goto L6
    L27:
        return;
    L29:
        throw new IOException("unable to list directory " + this.f6809a);
    }

    private void h(d r7, byte[] r8) {
        Log.i("fb-UnpackingSoSource", "extracting DSO " + r7.f6839f.f6836f);
        if (this.f6809a.setWritable(true, true) == false) goto L26;
        File r1 = new File(this.f6809a, r7.f6839f.f6836f);
        RandomAccessFile r6 = new RandomAccessFile(r1, "rw");     // Catch: IOException -> L7
    L29:
        int r0 = r7.f6840g.available();     // Catch: Throwable -> L18 IOException -> L20
        if (r0 <= 1) goto L12;
        SysUtil.c(r6.getFD(), r0);     // Catch: Throwable -> L18 IOException -> L20
    L12:
        SysUtil.a(r6, r7.f6840g, Integer.MAX_VALUE, r8);     // Catch: Throwable -> L18 IOException -> L20
        r6.setLength(r6.getFilePointer());     // Catch: Throwable -> L18 IOException -> L20
        if (r1.setExecutable(true, false) == false) goto L17;
        r6.close();
        return;
    L17:
        throw new IOException("cannot make file executable: " + r1);     // Catch: Throwable -> L18 IOException -> L20
    L18:
        th = move-exception;
        r6.close();
        throw th;
    L20:
        e = move-exception;
        SysUtil.b(r1);     // Catch: Throwable -> L18
        throw e;     // Catch: Throwable -> L18
    L7:
        e = move-exception;
        Log.w("fb-UnpackingSoSource", "error overwriting " + r1 + " trying to delete and start over", e);
        SysUtil.b(r1);
        r6 = new RandomAccessFile(r1, "rw");
        goto L29
    L26:
        throw new IOException("cannot make directory writable for us: " + this.f6809a);
    }

    private Object j(String r3) {
        Map<String, Object> r0 = this.f6829e;
        monitor-enter(r0);
        Object r1 = this.f6829e.get(r3);     // Catch: Throwable -> L9
        if (r1 != null) goto L7;
        r1 = new Object();     // Catch: Throwable -> L9
        this.f6829e.put(r3, r1);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L9:
        th = move-exception;
        throw th;
    }

    public static File k(Context r2, String r3) {
        return new File(r2.getApplicationInfo().dataDir + "/" + r3);
    }

    private boolean n(g r12, int r13, byte[] r14) {
        File r6 = new File(this.f6809a, "dso_state");
        RandomAccessFile r1 = new RandomAccessFile(r6, "rw");
        byte r4 = r1.readByte();     // Catch: EOFException -> L69 Throwable -> L7
        if (r4 == 1) goto L15;
        Log.v("fb-UnpackingSoSource", "dso store " + this.f6809a + " regeneration interrupted: wiping clean");     // Catch: EOFException -> L69 Throwable -> L7
    L15:
        r1.close();
        File r5 = new File(this.f6809a, "dso_deps");
        c r2 = null;
        RandomAccessFile r7 = new RandomAccessFile(r5, "rw");
        int r3 = (int) r7.length();     // Catch: Throwable -> L61
        byte[] r9 = new byte[r3];     // Catch: Throwable -> L61
        if (r7.read(r9) == r3) goto L20;
        Log.v("fb-UnpackingSoSource", "short read of so store deps file: marking unclean");     // Catch: Throwable -> L61
        r4 = 0;
    L20:
        if (Arrays.equals(r9, r14) == true) goto L22;
        Log.v("fb-UnpackingSoSource", "deps mismatch on deps store: regenerating");     // Catch: Throwable -> L61
        r4 = 0;
    L22:
        if (r4 != 0) goto L24;
    L27:
        Log.v("fb-UnpackingSoSource", "so store dirty: regenerating");     // Catch: Throwable -> L61
        q(r6, (byte) 0);     // Catch: Throwable -> L61
        f r0 = l();     // Catch: Throwable -> L61
        r2 = r0.a();     // Catch: Throwable -> L52
        e r8 = r0.b();     // Catch: Throwable -> L52
        o(r4, r2, r8);     // Catch: Throwable -> L43
        if (r8 == null) goto L32;
        r8.close();     // Catch: Throwable -> L52
    L32:
        if (r0 != null) goto L33;
    L26:
        c r10 = r2;
        r7.close();
        if (r10 != null) goto L38;
        return false;
    L38:
        a r11 = new a(this, r5, r14, r10, r6, r12);
        if ((r13 & 1) == 0) goto L41;
        new Thread(r11, "SoSync:" + this.f6809a.getName()).start();
    L42:
        return true;
    L41:
        r11.run();
        goto L42
    L33:
        r0.close();     // Catch: Throwable -> L61
        goto L26
    L43:
        th = move-exception;
        throw th;     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        if (r8 != null) goto L70;
    L51:
        throw th;     // Catch: Throwable -> L52
    L70:
        r8.close();     // Catch: Throwable -> L49
    L49:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L52
    L52:
        th = move-exception;
        throw th;     // Catch: Throwable -> L54
    L54:
        th = move-exception;
        if (r0 != null) goto L88;
    L60:
        throw th;     // Catch: Throwable -> L61
    L88:
        r0.close();     // Catch: Throwable -> L58
    L58:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L61
        goto L60
    L24:
        if ((r13 & 2) == 0) goto L26;
    L61:
        th = move-exception;
        throw th;     // Catch: Throwable -> L63
    L63:
        th = move-exception;
        r7.close();     // Catch: Throwable -> L66
    L68:
        throw th;
    L66:
        th = move-exception;
        th.addSuppressed(th);
    L7:
        th = move-exception;
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        r1.close();     // Catch: Throwable -> L12
    L14:
        throw th;
    L12:
        th = move-exception;
        th.addSuppressed(th);
    L6:
        r4 = 0;
        goto L15
    }

    private void o(byte r10, c r11, e r12) {
        Log.v("fb-UnpackingSoSource", "regenerating DSO store " + getClass().getName());
        RandomAccessFile r2 = new RandomAccessFile(new File(this.f6809a, "dso_manifest"), "rw");
        if (r10 == 1) goto L59;
    L10:
        c r13 = null;
    L12:
        if (r13 != null) goto L14;
        r13 = new c(new b[0]);     // Catch: Throwable -> L6
    L14:
        g(r11.f6838a);     // Catch: Throwable -> L6
        byte[] r14 = new byte[32768];     // Catch: Throwable -> L6
    L16:
        if (r12.a() == false) goto L44;
        d r4 = r12.b();     // Catch: Throwable -> L6
        boolean r5 = true;
        int r6 = 0;
    L19:
        if (r5 == false) goto L30;
        b[] r7 = r13.f6838a;     // Catch: Throwable -> L28
        if (r6 >= r7.length) goto L30;
        if (r7[r6].f6836f.equals(r4.f6839f.f6836f) == false) goto L27;
        if (r13.f6838a[r6].f6837g.equals(r4.f6839f.f6837g) == false) goto L27;
        r5 = false;
    L27:
        r6 = r6 + 1;     // Catch: Throwable -> L28
        goto L19
    L28:
        th = move-exception;
        throw th;     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        if (r4 != null) goto L61;
    L40:
        throw th;     // Catch: Throwable -> L6
    L61:
        r4.close();     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L6
    L30:
        if (r5 == false) goto L41;
        h(r4, r14);     // Catch: Throwable -> L28
    L41:
        if (r4 == null) goto L16;
        r4.close();     // Catch: Throwable -> L6
        goto L16
    L44:
        r2.close();
        Log.v("fb-UnpackingSoSource", "Finished regenerating DSO store " + getClass().getName());
        return;
    L59:
        r13 = c.a(r2);     // Catch: Throwable -> L6 Exception -> L8
    L8:
        e = move-exception;
        Log.i("fb-UnpackingSoSource", "error reading existing DSO manifest", e);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L47
    L47:
        th = move-exception;
        r2.close();     // Catch: Throwable -> L50
    L52:
        throw th;
    L50:
        th = move-exception;
        th.addSuppressed(th);
        goto L52
    }

    private static void q(File r3, byte r4) {
        RandomAccessFile r0 = new RandomAccessFile(r3, "rw");
        r0.seek(0);     // Catch: Throwable -> L6
        r0.write(r4);     // Catch: Throwable -> L6
        r0.setLength(r0.getFilePointer());     // Catch: Throwable -> L6
        r0.getFD().sync();     // Catch: Throwable -> L6
        r0.close();
        return;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        r0.close();     // Catch: Throwable -> L11
    L13:
        throw th;
    L11:
        th = move-exception;
        th.addSuppressed(th);
        goto L13
    }

    @Override // com.facebook.soloader.c, com.facebook.soloader.k
    public int a(String r3, int r4, StrictMode.ThreadPolicy r5) {
        Object r0 = j(r3);
        monitor-enter(r0);
        int r2 = e(r3, r4, this.f6809a, r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r2;
    L7:
        th = move-exception;
        throw th;
    }

    /*  JADX ERROR: ConcurrentModificationException in pass: ConstructorVisitor
        java.util.ConcurrentModificationException
        	at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1104)
        	at java.base/java.util.ArrayList$Itr.next(ArrayList.java:1058)
        	at jadx.core.dex.visitors.ConstructorVisitor.insertPhiInsn(ConstructorVisitor.java:139)
        	at jadx.core.dex.visitors.ConstructorVisitor.processInvoke(ConstructorVisitor.java:91)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:56)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:42)
        */
    @Override // com.facebook.soloader.k
    protected void b(
    /*  JADX ERROR: ConcurrentModificationException in pass: ConstructorVisitor
        java.util.ConcurrentModificationException
        	at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1104)
        	at java.base/java.util.ArrayList$Itr.next(ArrayList.java:1058)
        	at jadx.core.dex.visitors.ConstructorVisitor.insertPhiInsn(ConstructorVisitor.java:139)
        	at jadx.core.dex.visitors.ConstructorVisitor.processInvoke(ConstructorVisitor.java:91)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:56)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r8v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:215)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
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

    protected byte[] i() {
        Parcel r0 = Parcel.obtain();
        f r4 = l();
        b[] r1 = r4.a().f6838a;     // Catch: Throwable -> L12
        r0.writeByte((byte) 1);     // Catch: Throwable -> L12
        r0.writeInt(r1.length);     // Catch: Throwable -> L12
        int r2 = 0;
    L5:
        if (r2 >= r1.length) goto L8;
        r0.writeString(r1[r2].f6836f);     // Catch: Throwable -> L12
        r0.writeString(r1[r2].f6837g);     // Catch: Throwable -> L12
        r2 = r2 + 1;
        goto L5
    L8:
        if (r4 == null) goto L10;
        r4.close();
    L10:
        byte[] r5 = r0.marshall();
        r0.recycle();
        return r5;
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        if (r4 != null) goto L21;
    L20:
        throw th;
    L21:
        r4.close();     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        th.addSuppressed(th);
        goto L20
    }

    protected abstract f l();

    protected synchronized void m(String r2) {
        monitor-enter(this);
        Object r0 = j(r2);     // Catch: Throwable -> L12
        monitor-enter(r0);     // Catch: Throwable -> L12
        this.f6828d = r2;     // Catch: Throwable -> L9
        b(2);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    public void p(String[] r1) {
    }
}
