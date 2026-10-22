package com.facebook.soloader;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes2.dex */
public class SoLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final boolean f6785a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static j f6786b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ReentrantReadWriteLock f6787c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static k[] f6788d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static int f6789e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static m[] f6790f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static com.facebook.soloader.b f6791g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final HashSet<String> f6792h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Map<String, Object> f6793i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Set<String> f6794j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static l f6795k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static int f6796l;

    @d
    @TargetApi(14)
    private static class Api14Utils {
        private Api14Utils() {
        }

        public static String a() {
            ClassLoader r0 = SoLoader.class.getClassLoader();
            if ((r0 instanceof BaseDexClassLoader) == false) goto L10;
            return (String) BaseDexClassLoader.class.getMethod("getLdLibraryPath", new Class[0]).invoke((BaseDexClassLoader) r0, new Object[0]);
        L6:
            e = move-exception;
            throw new RuntimeException("Cannot call getLdLibraryPath", e);
        L10:
            throw new IllegalStateException("ClassLoader " + r0.getClass().getName() + " should be of type BaseDexClassLoader");
        }
    }

    static class a implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f6797a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f6798b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f6799c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Runtime f6800d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ Method f6801e;

        a(boolean r1, String r2, String r3, Runtime r4, Method r5) {
            this.f6797a = r1;
            this.f6798b = r2;
            this.f6799c = r3;
            this.f6800d = r4;
            this.f6801e = r5;
        }

        private String b(String r6) {
            File r5 = new File(r6);     // Catch: NoSuchAlgorithmException -> L19 SecurityException -> L21 IOException -> L23
            MessageDigest r7 = MessageDigest.getInstance("MD5");     // Catch: NoSuchAlgorithmException -> L19 SecurityException -> L21 IOException -> L23
            FileInputStream r0 = new FileInputStream(r5);     // Catch: NoSuchAlgorithmException -> L19 SecurityException -> L21 IOException -> L23
            byte[] r8 = new byte[4096];     // Catch: Throwable -> L11
        L5:
            int r1 = r0.read(r8);     // Catch: Throwable -> L11
            if (r1 <= 0) goto L8;
            r7.update(r8, 0, r1);     // Catch: Throwable -> L11
            goto L5
        L8:
            String r9 = String.format("%32x", new Object[]{new BigInteger(1, r7.digest())});     // Catch: Throwable -> L11
            r0.close();     // Catch: NoSuchAlgorithmException -> L19 SecurityException -> L21 IOException -> L23
            return r9;
        L11:
            th = move-exception;
            throw th;     // Catch: Throwable -> L13
        L13:
            th = move-exception;
            r0.close();     // Catch: Throwable -> L16
        L18:
            throw th;     // Catch: NoSuchAlgorithmException -> L19 SecurityException -> L21 IOException -> L23
        L16:
            th = move-exception;
            th.addSuppressed(th);     // Catch: NoSuchAlgorithmException -> L19 SecurityException -> L21 IOException -> L23
        L23:
            e = move-exception;
            return e.toString();
        L21:
            e = move-exception;
            return e.toString();
        L19:
            e = move-exception;
            return e.toString();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v2 */
        @Override // com.facebook.soloader.j
        public void a(String r9, int r10) {
            if (this.f6797a == false) goto L39;
            String r1 = 1;
            if ((r10 & 4) != 4) goto L7;
            boolean r11 = true;
        L8:
            if (r11 == false) goto L10;
            String r12 = this.f6798b;
        L42:
            Runtime r3 = this.f6800d;     // Catch: Throwable -> L29 Throwable -> L31
            monitor-enter(r3);     // Catch: Throwable -> L29 Throwable -> L31
            String r2 = (String) this.f6801e.invoke(this.f6800d, new Object[]{r9, SoLoader.class.getClassLoader(), r12});     // Catch: Throwable -> L21
            if (r2 != null) goto L20;
            monitor-exit(r3);     // Catch: Throwable -> L27
            if (r2 == null) goto L48;
            Log.e("SoLoader", "Error when loading lib: " + r2 + " lib hash: " + b(r9) + " search path is " + r12);
            return;
        L48:
            return;
        L20:
            throw new UnsatisfiedLinkError(r2);     // Catch: Throwable -> L27
        L21:
            th = move-exception;
            th = th;
        L23:
            monitor-exit(r3);     // Catch: Throwable -> L27
            throw th;     // Catch: Throwable -> L25 Throwable -> L35
        L25:
            Throwable e2 = e;
        L34:
            throw new RuntimeException("Error: Cannot load " + r9, e2);     // Catch: Throwable -> L35
        L27:
            th = th;
        L35:
            Throwable th = th;
        L36:
            if (r1 == 0) goto L38;
            Log.e("SoLoader", "Error when loading lib: " + r1 + " lib hash: " + b(r9) + " search path is " + r12);
        L38:
            throw th;
        L31:
            e = move-exception;
            e2 = e;
        L29:
            th = move-exception;
            r1 = 0;
            th = th;
            goto L36
        L10:
            r12 = this.f6799c;
            goto L42
        L7:
            r11 = false;
            goto L8
        L39:
            System.load(r9);
        }
    }

    public static final class b extends UnsatisfiedLinkError {
        b(Throwable r2) {
            super("APK was built for a different platform");
            initCause(r2);
        }
    }

    static {
        f6787c = new ReentrantReadWriteLock();
        f6788d = null;
        boolean r1 = false;
        f6789e = 0;
        f6792h = new HashSet();
        f6793i = new HashMap();
        f6794j = Collections.newSetFromMap(new ConcurrentHashMap());
        f6795k = null;
        if (Build.VERSION.SDK_INT < 18) goto L7;
        r1 = true;
    L7:
        f6785a = r1;
    }

    public SoLoader() {
    }

    private static void a() {
        ReentrantReadWriteLock r0 = f6787c;
        r0.readLock().lock();
    L9:
        th = move-exception;
        f6787c.readLock().unlock();
        throw th;
    L4:
        if (f6788d == null) goto L8;
        r0.readLock().unlock();
        return;
    L8:
        throw new RuntimeException("SoLoader.init() not yet called");     // Catch: Throwable -> L9
    }

    private static void b(String r12, int r13, StrictMode.ThreadPolicy r14) {
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
            Method dump skipped, instruction units count: 391
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.SoLoader.b(java.lang.String, int, android.os.StrictMode$ThreadPolicy):void");
    }

    private static Method c() {
        int r1 = Build.VERSION.SDK_INT;
        if (r1 >= 23) goto L5;
    L11:
        return null;
    L5:
        if (r1 > 27) goto L11;
        Method r0 = Runtime.class.getDeclaredMethod("nativeLoad", new Class[]{String.class, ClassLoader.class, String.class});     // Catch: Throwable -> L9
        r0.setAccessible(true);     // Catch: Throwable -> L9
        return r0;
    L9:
        e = move-exception;
        Log.w("SoLoader", "Cannot get nativeLoad method", e);
        goto L11
    }

    public static void d(Context r1, int r2) {
        e(r1, r2, null);
    }

    private static void e(Context r1, int r2, j r3) {
        StrictMode.ThreadPolicy r0 = StrictMode.allowThreadDiskWrites();
        f(r3);     // Catch: Throwable -> L6
        g(r1, r2, r3);     // Catch: Throwable -> L6
        StrictMode.setThreadPolicy(r0);
        return;
    L6:
        th = move-exception;
        StrictMode.setThreadPolicy(r0);
        throw th;
    }

    private static synchronized void f(j r7) {
        monitor-enter(SoLoader.class);
        if (r7 == null) goto L8;
        f6786b = r7;     // Catch: Throwable -> L19
        monitor-exit(SoLoader.class);
        return;
    L8:
        Runtime r5 = Runtime.getRuntime();     // Catch: Throwable -> L19
        Method r6 = c();     // Catch: Throwable -> L19
        if (r6 == null) goto L11;
        boolean r8 = true;
    L12:
        boolean r2 = r8;
        if (r2 == false) goto L15;
        String r9 = Api14Utils.a();     // Catch: Throwable -> L19
    L16:
        String r3 = r9;
        f6786b = new a(r2, r3, l(r3), r5, r6);     // Catch: Throwable -> L19
        monitor-exit(SoLoader.class);
        return;
    L15:
        r9 = null;
        goto L16
    L11:
        r8 = false;
    L19:
        th = move-exception;
        throw th;
    }

    private static void g(Context r13, int r14, j r15) {
        int r16 = Build.VERSION.SDK_INT;
        f6787c.writeLock().lock();
    L49:
        th = move-exception;
        Log.d("SoLoader", "init exiting");
        f6787c.writeLock().unlock();
        throw th;
    L4:
        if (f6788d != null) goto L47;
        Log.d("SoLoader", "init start");     // Catch: Throwable -> L49
        f6796l = r14;     // Catch: Throwable -> L49
        ArrayList r2 = new ArrayList();     // Catch: Throwable -> L49
        String r3 = System.getenv("LD_LIBRARY_PATH");     // Catch: Throwable -> L49
        if (r3 != null) goto L8;
        r3 = "/vendor/lib:/system/lib";
    L8:
        String[] r4 = r3.split(":");     // Catch: Throwable -> L49
        int r5 = 0;
    L10:
        if (r5 >= r4.length) goto L14;
        Log.d("SoLoader", "adding system library source: " + r4[r5]);     // Catch: Throwable -> L49
        r2.add(new c(new File(r4[r5]), 2));     // Catch: Throwable -> L49
        r5 = r5 + 1;
        goto L10
    L14:
        if (r13 != null) goto L16;
    L42:
        k[] r17 = (k[]) r2.toArray(new k[r2.size()]);     // Catch: Throwable -> L49
        int r18 = m();     // Catch: Throwable -> L49
        int r19 = r17.length;     // Catch: Throwable -> L49
    L43:
        int r6 = r19 - 1;     // Catch: Throwable -> L49
        if (r19 <= 0) goto L46;
        Log.d("SoLoader", "Preparing SO source: " + r17[r6]);     // Catch: Throwable -> L49
        r17[r6].b(r18);     // Catch: Throwable -> L49
        r19 = r6;
        goto L43
    L46:
        f6788d = r17;     // Catch: Throwable -> L49
        f6789e++;     // Catch: Throwable -> L49
        Log.d("SoLoader", "init finish: " + f6788d.length + " SO sources prepared");     // Catch: Throwable -> L49
        goto L47
    L16:
        if ((r14 & 1) == 0) goto L18;
        f6790f = null;     // Catch: Throwable -> L49
        Log.d("SoLoader", "adding exo package source: lib-main");     // Catch: Throwable -> L49
        r2.add(0, new e(r13, "lib-main"));     // Catch: Throwable -> L49
        goto L42
    L18:
        int r110 = r13.getApplicationInfo().flags;     // Catch: Throwable -> L49
        if ((r110 & 1) != 0) goto L21;
    L23:
        boolean r111 = false;
    L24:
        if (r111 == false) goto L27;
        int r112 = 0;
    L32:
        if ((f6796l & 8) == 0) goto L34;
        f6790f = null;     // Catch: Throwable -> L49
        goto L42
    L34:
        File r7 = new File(r13.getApplicationInfo().sourceDir);     // Catch: Throwable -> L49
        ArrayList r8 = new ArrayList();     // Catch: Throwable -> L49
        com.facebook.soloader.a r9 = new com.facebook.soloader.a(r13, r7, "lib-main", r112);     // Catch: Throwable -> L49
        r8.add(r9);     // Catch: Throwable -> L49
        Log.d("SoLoader", "adding backup source from : " + r9.toString());     // Catch: Throwable -> L49
        if (r16 >= 21) goto L37;
    L41:
        f6790f = (m[]) r8.toArray(new m[r8.size()]);     // Catch: Throwable -> L49
        r2.addAll(0, r8);     // Catch: Throwable -> L49
        goto L42
    L37:
        if (r13.getApplicationInfo().splitSourceDirs == null) goto L41;
        Log.d("SoLoader", "adding backup sources from split apks");     // Catch: Throwable -> L49
        String[] r113 = r13.getApplicationInfo().splitSourceDirs;     // Catch: Throwable -> L49
        int r10 = r113.length;     // Catch: Throwable -> L49
        int r11 = 0;
        int r12 = 0;
    L39:
        if (r11 >= r10) goto L41;
        File r114 = new File(r113[r11]);     // Catch: Throwable -> L49
        StringBuilder r20 = new StringBuilder();     // Catch: Throwable -> L49
        r20.append("lib-");     // Catch: Throwable -> L49
        r20.append(r12);     // Catch: Throwable -> L49
        com.facebook.soloader.a r115 = new com.facebook.soloader.a(r13, r114, r20.toString(), r112);     // Catch: Throwable -> L49
        Log.d("SoLoader", "adding backup source: " + r115.toString());     // Catch: Throwable -> L49
        r8.add(r115);     // Catch: Throwable -> L49
        r11 = r11 + 1;     // Catch: Throwable -> L49
        r12 = r12 + 1;     // Catch: Throwable -> L49
        goto L39
    L27:
        if (r16 > 17) goto L29;
        int r116 = 1;
    L30:
        f6791g = new com.facebook.soloader.b(r13, r116);     // Catch: Throwable -> L49
        Log.d("SoLoader", "adding application source: " + f6791g.toString());     // Catch: Throwable -> L49
        r2.add(0, f6791g);     // Catch: Throwable -> L49
        r112 = 1;
        goto L32
    L29:
        r116 = 0;
        goto L30
    L21:
        if ((r110 & 128) != 0) goto L23;
        r111 = true;
    L47:
        Log.d("SoLoader", "init exiting");
        f6787c.writeLock().unlock();
    }

    public static boolean h(String r1) {
        return i(r1, 0);
    }

    public static boolean i(String r3, int r4) {
        ReentrantReadWriteLock r0 = f6787c;
        r0.readLock().lock();
    L28:
        th = move-exception;
        f6787c.readLock().unlock();
        throw th;
    L4:
        if (f6788d == null) goto L6;
    L22:
        r0.readLock().unlock();
        String r1 = h.b(r3);
        if (r1 == null) goto L25;
        String r2 = r1;
    L27:
        return k(System.mapLibraryName(r2), r3, r1, r4 | 2, null);
    L25:
        r2 = r3;
        goto L27
    L6:
        if ("http://www.android.com/".equals(System.getProperty("java.vendor.url")) == false) goto L9;
        a();     // Catch: Throwable -> L28
        goto L22
    L9:
        monitor-enter(SoLoader.class);     // Catch: Throwable -> L28
        boolean r5 = !f6792h.contains(r3);     // Catch: Throwable -> L19
        if (r5 == false) goto L16;
        l r6 = f6795k;     // Catch: Throwable -> L19
        if (r6 == null) goto L15;
        r6.loadLibrary(r3);     // Catch: Throwable -> L19
        goto L16
    L15:
        System.loadLibrary(r3);     // Catch: Throwable -> L19
    L16:
        monitor-exit(SoLoader.class);     // Catch: Throwable -> L19
        r0.readLock().unlock();
        return r5;
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L28
    }

    static void j(String r1, int r2, StrictMode.ThreadPolicy r3) {
        k(r1, null, null, r2, r3);
    }

    private static boolean k(String r9, String r10, String r11, int r12, StrictMode.ThreadPolicy r13) {
        boolean r2 = false;
        if (TextUtils.isEmpty(r10) == false) goto L5;
    L7:
        monitor-enter(SoLoader.class);
        HashSet<String> r1 = f6792h;     // Catch: Throwable -> L78
        if (r1.contains(r9) == false) goto L14;
        if (r11 != null) goto L13;
        monitor-exit(SoLoader.class);     // Catch: Throwable -> L78
        return false;
    L13:
        boolean r3 = true;
    L15:
        Map<String, Object> r5 = f6793i;     // Catch: Throwable -> L78
        if (r5.containsKey(r9) == false) goto L18;
        Object r6 = r5.get(r9);     // Catch: Throwable -> L78
    L19:
        monitor-exit(SoLoader.class);     // Catch: Throwable -> L78
        monitor-enter(r6);
        if (r3 == true) goto L55;
        monitor-enter(SoLoader.class);     // Catch: Throwable -> L75
    L51:
        th = move-exception;
        throw th;     // Catch: Throwable -> L75
    L24:
        if (r1.contains(r9) == false) goto L30;
        if (r11 != null) goto L29;
        monitor-exit(SoLoader.class);     // Catch: Throwable -> L51
        monitor-exit(r6);     // Catch: Throwable -> L75
        return false;
    L29:
        r3 = true;
    L30:
        monitor-exit(SoLoader.class);     // Catch: Throwable -> L51
        if (r3 == true) goto L55;
        Log.d("SoLoader", "About to load: " + r9);     // Catch: UnsatisfiedLinkError -> L40 IOException -> L48 Throwable -> L75
        b(r9, r12, r13);     // Catch: UnsatisfiedLinkError -> L40 IOException -> L48 Throwable -> L75
        monitor-enter(SoLoader.class);     // Catch: Throwable -> L75
        Log.d("SoLoader", "Loaded: " + r9);     // Catch: Throwable -> L37
        r1.add(r9);     // Catch: Throwable -> L37
        monitor-exit(SoLoader.class);     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        throw th;     // Catch: Throwable -> L75
    L48:
        e = move-exception;
        throw new RuntimeException(e);     // Catch: Throwable -> L75
    L40:
        e = move-exception;
        String r14 = e.getMessage();     // Catch: Throwable -> L75
        if (r14 != null) goto L44;
    L47:
        throw e;     // Catch: Throwable -> L75
    L44:
        if (r14.contains("unexpected e_machine:") == false) goto L47;
        throw new b(e);     // Catch: Throwable -> L75
    L75:
        th = move-exception;
        throw th;
    L55:
        if (TextUtils.isEmpty(r10) == false) goto L57;
    L59:
        if (r11 == null) goto L72;
        if (r2 == true) goto L72;
        if (f6785a == false) goto L85;
        Api18TraceUtils.a("MergedSoMapping.invokeJniOnload[" + r10 + "]");     // Catch: Throwable -> L75
    L85:
        Log.d("SoLoader", "About to merge: " + r10 + " / " + r9);     // Catch: Throwable -> L67
        h.a(r10);     // Catch: Throwable -> L67
    L66:
        throw null;
    L67:
        th = move-exception;
        if (f6785a == false) goto L71;
        Api18TraceUtils.b();     // Catch: Throwable -> L75
    L71:
        throw th;     // Catch: Throwable -> L75
    L72:
        monitor-exit(r6);     // Catch: Throwable -> L75
        return !r3;
    L57:
        if (f6794j.contains(r10) == false) goto L59;
        r2 = true;
        goto L59
    L18:
        Object r7 = new Object();     // Catch: Throwable -> L78
        r5.put(r9, r7);     // Catch: Throwable -> L78
        r6 = r7;
        goto L19
    L14:
        r3 = false;
    L78:
        th = move-exception;
        throw th;
    L5:
        if (f6794j.contains(r10) == false) goto L7;
        return false;
    }

    public static String l(String r6) {
        if (r6 != null) goto L5;
        return null;
    L5:
        String[] r7 = r6.split(":");
        ArrayList r1 = new ArrayList(r7.length);
        int r2 = r7.length;
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L13;
        String r4 = r7[r3];
        if (r4.contains("!") == true) goto L11;
        r1.add(r4);
    L11:
        r3 = r3 + 1;
        goto L6
    L13:
        return TextUtils.join(":", r1);
    }

    private static int m() {
        ReentrantReadWriteLock r0 = f6787c;
        r0.writeLock().lock();
        if ((f6796l & 2) == 0) goto L7;
        int r1 = 1;
    L8:
        r0.writeLock().unlock();
        return r1;
    L7:
        r1 = 0;
    L10:
        th = move-exception;
        f6787c.writeLock().unlock();
        throw th;
    }
}
