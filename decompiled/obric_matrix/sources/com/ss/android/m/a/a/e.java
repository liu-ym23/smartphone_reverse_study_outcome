package com.ss.android.m.a.a;

import android.os.SystemClock;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static ExecutorService f12114d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Object f12115a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<com.ss.android.m.a.a.b, Object> f12116b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ReentrantLock f12117c;

    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ WeakReference f12118f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f12119g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f12120h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ int f12121i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ long f12122j;

        a(e r1, WeakReference r2, String r3, int r4, int r5, long r6) {
            this.f12118f = r2;
            this.f12119g = r3;
            this.f12120h = r4;
            this.f12121i = r5;
            this.f12122j = r6;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject r6 = e.a(this.f12118f, this.f12119g, this.f12120h, this.f12121i, this.f12122j);
            if (r6 == null) goto L6;
            f.h().c(r6);
            return;
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ WeakReference f12123f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f12124g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f12125h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ int f12126i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ long f12127j;

        b(e r1, WeakReference r2, String r3, int r4, int r5, long r6) {
            this.f12123f = r2;
            this.f12124g = r3;
            this.f12125h = r4;
            this.f12126i = r5;
            this.f12127j = r6;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject r6 = e.a(this.f12123f, this.f12124g, this.f12125h, this.f12126i, this.f12127j);
            if (r6 == null) goto L6;
            f.h().h(r6);
            return;
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Runnable f12128f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ ThreadPoolExecutor f12129g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ Exception f12130h;

        c(e r1, Runnable r2, ThreadPoolExecutor r3, Exception r4) {
            this.f12128f = r2;
            this.f12129g = r3;
            this.f12130h = r4;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject r0 = new JSONObject();
            Runnable r1 = this.f12128f;     // Catch: Exception -> L11
            if ((r1 instanceof com.ss.android.m.a.a.b) == false) goto L7;
            r1 = ((com.ss.android.m.a.a.b) r1).g();     // Catch: Exception -> L11
        L7:
            r0.put("task_name", r1);     // Catch: Exception -> L11
            ThreadPoolExecutor r2 = this.f12129g;     // Catch: Exception -> L11
            if ((r2 instanceof com.ss.android.m.a.a.a) == false) goto L13;
            r0.put("pool_type", ((com.ss.android.m.a.a.a) r2).b().name());     // Catch: Exception -> L11
            r0.put("pool_size", this.f12129g.getPoolSize());     // Catch: Exception -> L11
            r0.put("task_stack", l.e(this.f12130h));     // Catch: Exception -> L11
        L13:
            f.h().f(r0);
            return;
        L11:
            e = move-exception;
            e.printStackTrace();
            goto L13
        }
    }

    private static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static e f12131a;

        static {
            f12131a = new e(null);
        }

        static /* synthetic */ e a() {
            return f12131a;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.m.a.a.e$e, reason: collision with other inner class name */
    class RunnableC0317e implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ e f12132f;

        RunnableC0317e(e r1) {
            this.f12132f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
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
                	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
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
                Method dump skipped, instruction units count: 299
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ss.android.m.a.a.e.RunnableC0317e.run():void");
        }
    }

    private e() {
        this.f12115a = new Object();
        this.f12117c = new ReentrantLock();
        this.f12116b = new WeakHashMap();
        h.b r0 = h.a(k.f12174i);
        r0.i(1);
        r0.j("TaskMonitor");
        f12114d = f.a(r0.h());
        Log.d("ThreadPool-TaskMonitor", String.format("taskBlockedTimeOut=%d", new Object[]{Long.valueOf(f.c().c())}));
        ((ScheduledExecutorService) f12114d).scheduleAtFixedRate(new RunnableC0317e(this), f.c().c(), f.c().c(), TimeUnit.MILLISECONDS);
    }

    /* synthetic */ e(a r1) {
        this();
    }

    static /* synthetic */ JSONObject a(WeakReference r0, String r1, int r2, int r3, long r4) {
        return d(r0, r1, r2, r3, r4);
    }

    static /* synthetic */ ReentrantLock b(e r0) {
        return r0.f12117c;
    }

    static /* synthetic */ Map c(e r0) {
        return r0.f12116b;
    }

    private static JSONObject d(WeakReference<Object> r3, String r4, int r5, int r6, long r7) {
        Object r8 = r3.get();
        if (r8 != null) goto L5;
        return null;
    L5:
        JSONObject r1 = new JSONObject();
        String r9 = l.d(r8);     // Catch: Exception -> L11
        if (f.i(r9) == false) goto L9;
        return null;
    L9:
        r1.put("task_name", r9);     // Catch: Exception -> L11
        r1.put("pool_type", r4);     // Catch: Exception -> L11
        r1.put("pool_size", r5);     // Catch: Exception -> L11
        r1.put("queue_size", r6);     // Catch: Exception -> L11
        r1.put(TypedValues.TransitionType.S_DURATION, r7);     // Catch: Exception -> L11
    L13:
        return r1;
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L13
    }

    static e e() {
        return d.a();
    }

    void f(Object r10, String r11, int r12, int r13, long r14) {
        WeakReference r2 = new WeakReference(r10);
        f12114d.execute(new b(this, r2, r11, r12, r13, r14));
    }

    void g(Runnable r4, ThreadPoolExecutor r5) {
        if (f.h().b() == true) goto L5;
        return;
    L5:
        Exception r0 = new Exception();
        f12114d.execute(new c(this, r4, r5, r0));
    }

    void h(Object r10, String r11, int r12, int r13, long r14) {
        WeakReference r2 = new WeakReference(r10);
        f12114d.execute(new a(this, r2, r11, r12, r13, r14));
    }

    void i(com.ss.android.m.a.a.b r3) {
        if (f.h().g() == true) goto L5;
        return;
    L5:
        this.f12117c.lock();
        this.f12116b.put(r3, this.f12115a);     // Catch: Throwable -> L9
        this.f12117c.unlock();
        return;
    L9:
        th = move-exception;
        this.f12117c.unlock();
        throw th;
    }

    void j(com.ss.android.m.a.a.b r2) {
        if (f.h().g() == true) goto L5;
        return;
    L5:
        this.f12117c.lock();
        this.f12116b.remove(r2);     // Catch: Throwable -> L9
        this.f12117c.unlock();
        return;
    L9:
        th = move-exception;
        this.f12117c.unlock();
        throw th;
    }
}
