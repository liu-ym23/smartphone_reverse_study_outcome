package com.bytedance.apm.q;

import android.app.Activity;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm.agent.v2.instrumentation.BatteryAgent;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.q.j.i;
import com.bytedance.apm.q.j.j;
import com.bytedance.apm.q.j.k;
import com.bytedance.apm.q.j.l;
import com.bytedance.apm.util.o;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdlocation.trace.TraceCons;
import com.bytedance.services.apm.api.EnsureManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a extends com.bytedance.apm.a0.a implements com.bytedance.apm.q.k.a.b {
    private static final Object B = null;
    private final d.b.l.a.h.e A;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Map<String, l> f1682g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile long f1683h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private volatile boolean f1684i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private volatile boolean f1685j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private volatile long f1686k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private volatile long f1687l;
    private volatile long m;
    private List<String> n;
    private boolean o;
    private volatile boolean p;
    private int q;
    private String r;
    private String[] s;
    private String t;
    private HashMap<Integer, com.bytedance.apm.a0.j.a> u;
    private HashMap<Integer, com.bytedance.apm.a0.j.a> v;
    private long w;
    private HashMap<String, Integer> x;
    private boolean y;
    private final d.b.l.a.h.e z;

    /* JADX INFO: renamed from: com.bytedance.apm.q.a$a, reason: collision with other inner class name */
    class RunnableC0052a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f1688f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ a f1689g;

        RunnableC0052a(a r1, boolean r2) {
            this.f1689g = r1;
            this.f1688f = r2;
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
                this = this;
                java.lang.Object r0 = com.bytedance.apm.q.a.v()
                monitor-enter(r0)
                boolean r1 = com.bytedance.apm.d.C()     // Catch: java.lang.Throwable -> L4f
                if (r1 == 0) goto L29
                java.lang.String r1 = com.bytedance.apm.x.b.f2126b     // Catch: java.lang.Throwable -> L4f
                r2 = 1
                java.lang.String[] r2 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> L4f
                r3 = 0
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4f
                r4.<init>()     // Catch: java.lang.Throwable -> L4f
                java.lang.String r5 = "ChargingStatusChange:"
                r4.append(r5)     // Catch: java.lang.Throwable -> L4f
                boolean r5 = r6.f1688f     // Catch: java.lang.Throwable -> L4f
                r4.append(r5)     // Catch: java.lang.Throwable -> L4f
                java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L4f
                r2[r3] = r4     // Catch: java.lang.Throwable -> L4f
                com.bytedance.apm.x.e.d(r1, r2)     // Catch: java.lang.Throwable -> L4f
            L29:
                com.bytedance.apm.q.a r1 = r6.f1689g     // Catch: java.lang.Throwable -> L4f
                boolean r1 = com.bytedance.apm.q.a.w(r1)     // Catch: java.lang.Throwable -> L4f
                com.bytedance.apm.q.a r2 = r6.f1689g     // Catch: java.lang.Throwable -> L4f
                java.util.Map r2 = com.bytedance.apm.q.a.x(r2)     // Catch: java.lang.Throwable -> L4f
                java.util.Collection r2 = r2.values()     // Catch: java.lang.Throwable -> L4f
                java.util.Iterator r2 = r2.iterator()     // Catch: java.lang.Throwable -> L4f
            L3d:
                boolean r3 = r2.hasNext()     // Catch: java.lang.Throwable -> L4f
                if (r3 == 0) goto L55
                java.lang.Object r3 = r2.next()     // Catch: java.lang.Throwable -> L4f
                com.bytedance.apm.q.j.l r3 = (com.bytedance.apm.q.j.l) r3     // Catch: java.lang.Throwable -> L4f
                boolean r4 = r6.f1688f     // Catch: java.lang.Throwable -> L4f
                r3.d(r4, r1)     // Catch: java.lang.Throwable -> L4f
                goto L3d
            L4f:
                r1 = move-exception
                java.lang.String r2 = "ChargingStatusChange"
                com.bytedance.services.apm.api.EnsureManager.ensureNotReachHere(r1, r2)     // Catch: java.lang.Throwable -> L5e
            L55:
                com.bytedance.apm.q.a r1 = r6.f1689g     // Catch: java.lang.Throwable -> L5e
                boolean r6 = r6.f1688f     // Catch: java.lang.Throwable -> L5e
                com.bytedance.apm.q.a.y(r1, r6)     // Catch: java.lang.Throwable -> L5e
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L5e
                return
            L5e:
                r6 = move-exception
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L5e
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.apm.q.a.RunnableC0052a.run():void");
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a f1690f;

        b(a r1) {
            this.f1690f = r1;
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
                this = this;
                java.lang.Object r0 = com.bytedance.apm.q.a.v()
                monitor-enter(r0)
                r1 = 1
                boolean r2 = com.bytedance.apm.d.C()     // Catch: java.lang.Throwable -> L42
                if (r2 == 0) goto L17
                java.lang.String r2 = com.bytedance.apm.x.b.f2126b     // Catch: java.lang.Throwable -> L42
                java.lang.String r3 = "onChangeToFront, record data"
                java.lang.String[] r3 = new java.lang.String[]{r3}     // Catch: java.lang.Throwable -> L42
                com.bytedance.apm.x.e.d(r2, r3)     // Catch: java.lang.Throwable -> L42
            L17:
                java.lang.String r2 = "APM-Battery"
                java.lang.String r3 = "ToFrontIn"
                com.bytedance.apm.x.a.d(r2, r3)     // Catch: java.lang.Throwable -> L42
                com.bytedance.apm.q.a r2 = r5.f1690f     // Catch: java.lang.Throwable -> L42
                boolean r2 = com.bytedance.apm.q.a.z(r2, r1)     // Catch: java.lang.Throwable -> L42
                com.bytedance.apm.q.a r3 = r5.f1690f     // Catch: java.lang.Throwable -> L42
                java.util.Map r3 = com.bytedance.apm.q.a.x(r3)     // Catch: java.lang.Throwable -> L42
                java.util.Collection r3 = r3.values()     // Catch: java.lang.Throwable -> L42
                java.util.Iterator r3 = r3.iterator()     // Catch: java.lang.Throwable -> L42
            L32:
                boolean r4 = r3.hasNext()     // Catch: java.lang.Throwable -> L42
                if (r4 == 0) goto L48
                java.lang.Object r4 = r3.next()     // Catch: java.lang.Throwable -> L42
                com.bytedance.apm.q.j.l r4 = (com.bytedance.apm.q.j.l) r4     // Catch: java.lang.Throwable -> L42
                r4.f(r2)     // Catch: java.lang.Throwable -> L42
                goto L32
            L42:
                r2 = move-exception
                java.lang.String r3 = "recordFrontData"
                com.bytedance.services.apm.api.EnsureManager.ensureNotReachHere(r2, r3)     // Catch: java.lang.Throwable -> L5e
            L48:
                com.bytedance.apm.q.i.a r2 = com.bytedance.apm.q.i.a.h()     // Catch: java.lang.Throwable -> L5e
                com.bytedance.apm.core.ActivityLifeObserver r3 = com.bytedance.apm.core.ActivityLifeObserver.getInstance()     // Catch: java.lang.Throwable -> L5e
                java.lang.String r3 = r3.getTopActivityClassName()     // Catch: java.lang.Throwable -> L5e
                r2.p(r3)     // Catch: java.lang.Throwable -> L5e
                com.bytedance.apm.q.a r5 = r5.f1690f     // Catch: java.lang.Throwable -> L5e
                com.bytedance.apm.q.a.B(r5, r1)     // Catch: java.lang.Throwable -> L5e
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L5e
                return
            L5e:
                r5 = move-exception
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L5e
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.apm.q.a.b.run():void");
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a f1691f;

        c(a r1) {
            this.f1691f = r1;
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
                this = this;
                java.lang.Object r0 = com.bytedance.apm.q.a.v()
                monitor-enter(r0)
                boolean r1 = com.bytedance.apm.d.C()     // Catch: java.lang.Throwable -> L42
                if (r1 == 0) goto L16
                java.lang.String r1 = com.bytedance.apm.x.b.f2126b     // Catch: java.lang.Throwable -> L42
                java.lang.String r2 = "onChangeToBack, record data"
                java.lang.String[] r2 = new java.lang.String[]{r2}     // Catch: java.lang.Throwable -> L42
                com.bytedance.apm.x.e.d(r1, r2)     // Catch: java.lang.Throwable -> L42
            L16:
                java.lang.String r1 = "APM-Battery"
                java.lang.String r2 = "ToBackIn"
                com.bytedance.apm.x.a.d(r1, r2)     // Catch: java.lang.Throwable -> L42
                com.bytedance.apm.q.a r1 = r4.f1691f     // Catch: java.lang.Throwable -> L42
                r2 = 1
                boolean r1 = com.bytedance.apm.q.a.z(r1, r2)     // Catch: java.lang.Throwable -> L42
                com.bytedance.apm.q.a r2 = r4.f1691f     // Catch: java.lang.Throwable -> L42
                java.util.Map r2 = com.bytedance.apm.q.a.x(r2)     // Catch: java.lang.Throwable -> L42
                java.util.Collection r2 = r2.values()     // Catch: java.lang.Throwable -> L42
                java.util.Iterator r2 = r2.iterator()     // Catch: java.lang.Throwable -> L42
            L32:
                boolean r3 = r2.hasNext()     // Catch: java.lang.Throwable -> L42
                if (r3 == 0) goto L48
                java.lang.Object r3 = r2.next()     // Catch: java.lang.Throwable -> L42
                com.bytedance.apm.q.j.l r3 = (com.bytedance.apm.q.j.l) r3     // Catch: java.lang.Throwable -> L42
                r3.b(r1)     // Catch: java.lang.Throwable -> L42
                goto L32
            L42:
                r1 = move-exception
                java.lang.String r2 = "recordBackgroundData"
                com.bytedance.services.apm.api.EnsureManager.ensureNotReachHere(r1, r2)     // Catch: java.lang.Throwable -> L50
            L48:
                com.bytedance.apm.q.a r4 = r4.f1691f     // Catch: java.lang.Throwable -> L50
                r1 = 0
                com.bytedance.apm.q.a.B(r4, r1)     // Catch: java.lang.Throwable -> L50
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L50
                return
            L50:
                r4 = move-exception
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L50
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.apm.q.a.c.run():void");
        }
    }

    class d implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a f1692f;

        d(a r1) {
            this.f1692f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object r0 = a.v();
            monitor-enter(r0);
            boolean r3 = true;
            if (com.bytedance.apm.d.C() == false) goto L7;
            com.bytedance.apm.x.e.d(com.bytedance.apm.x.b.f2126b, new String[]{"onTimer record, current is background? : " + ActivityLifeObserver.getInstance().isForeground()});     // Catch: Throwable -> L22
        L7:
            com.bytedance.apm.x.a.d("APM-Battery", "OnTimerIn");     // Catch: Throwable -> L22
            boolean r1 = a.z(this.f1692f, true);     // Catch: Throwable -> L22
            Iterator r4 = a.x(this.f1692f).values().iterator();     // Catch: Throwable -> L22
        L9:
            if (r4.hasNext() == false) goto L11;
            ((l) r4.next()).a(r1);     // Catch: Throwable -> L22
            goto L9
        L11:
            long r5 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L22
            if (a.o(this.f1692f) == true) goto L14;
        L24:
            monitor-exit(r0);     // Catch: Throwable -> L26
            return;
        L14:
            if ((r5 - a.p(this.f1692f)) > (a.r(this.f1692f) * 60000)) goto L18;
            r3 = false;
        L18:
            if (com.bytedance.apm.d.G() == false) goto L24;
            if (r3 == false) goto L24;
            com.bytedance.apm.q.i.a.h().k(false);     // Catch: Throwable -> L22
            a.q(this.f1692f, r5);     // Catch: Throwable -> L22
        L22:
            th = move-exception;
            EnsureManager.ensureNotReachHere(th, "onStart");     // Catch: Throwable -> L26
        L26:
            th = move-exception;
            throw th;
        }
    }

    class e implements d.b.l.a.h.e {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a f1693f;

        e(a r1) {
            this.f1693f = r1;
        }

        @Override // d.b.l.a.h.e
        public d.b.l.a.h.b S() {
            return d.b.l.a.h.b.f14114h;
        }

        @Override // d.b.l.a.h.e
        public String X() {
            return "BatteryCollector-mTimerRunnable";
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f1693f.i();
        }
    }

    class f implements Comparator<com.bytedance.apm.a0.j.a> {
        f(a r1) {
        }

        public int a(com.bytedance.apm.a0.j.a r3, com.bytedance.apm.a0.j.a r4) {
            return (int) (r4.f1189c - r3.f1189c);
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(com.bytedance.apm.a0.j.a r1, com.bytedance.apm.a0.j.a r2) {
            return a(r1, r2);
        }
    }

    class g implements d.b.l.a.h.e {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a f1694f;

        g(a r1) {
            this.f1694f = r1;
        }

        @Override // d.b.l.a.h.e
        public d.b.l.a.h.b S() {
            return d.b.l.a.h.b.f14114h;
        }

        @Override // d.b.l.a.h.e
        public String X() {
            return "BatteryCollector-UpdateThreadRecord";
        }

        @Override // java.lang.Runnable
        public void run() {
            a.s(this.f1694f);     // Catch: Throwable -> L15
            if (a.A(this.f1694f) == false) goto L10;
            if (a.t(this.f1694f).containsKey("cpu_monitor_thread_front_capture_period") == false) goto L8;
            Integer r0 = (Integer) a.t(this.f1694f).get("cpu_monitor_thread_front_capture_period");     // Catch: Throwable -> L15
        L7:
            int r1 = r0.intValue();     // Catch: Throwable -> L15
        L13:
            com.bytedance.apm.f0.b.f().e(a.u(this.f1694f), r1 * 1000);     // Catch: Throwable -> L15
            return;
        L8:
            r1 = 5;
            goto L13
        L10:
            if (a.t(this.f1694f).containsKey("cpu_monitor_thread_background_capture_period") == false) goto L12;
            r0 = (Integer) a.t(this.f1694f).get("cpu_monitor_thread_background_capture_period");     // Catch: Throwable -> L15
            goto L7
        L12:
            r1 = 20;
        L15:
            th = move-exception;
            EnsureManager.ensureNotReachHere(th, "mUpdateThreadRecordRunnable");
        }
    }

    private static final class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f1695a = null;

        static {
            f1695a = new a(null);
        }

        static /* synthetic */ a a() {
            return f1695a;
        }
    }

    static {
        B = new Object();
    }

    private a() {
        this.f1682g = new ConcurrentHashMap();
        this.f1683h = -1;
        this.f1685j = false;
        this.f1687l = 30;
        this.m = -1;
        this.q = 32;
        this.s = new String[2];
        new ArrayList();
        this.u = new HashMap();
        this.v = new HashMap();
        this.x = new HashMap();
        this.z = new e(this);
        this.A = new g(this);
        this.f1122e = "battery";
    }

    /* synthetic */ a(RunnableC0052a r1) {
        this();
    }

    static /* synthetic */ boolean A(a r0) {
        return r0.f1684i;
    }

    static /* synthetic */ boolean B(a r0, boolean r1) {
        r0.f1684i = r1;
        return r1;
    }

    private boolean C() {
        if (BatteryAgent.hasHook() == true) goto L5;
    L9:
        return false;
    L5:
        if (this.x.containsKey("cpu_monitor_enable") == true) goto L7;
    L8:
        return true;
    L7:
        if (this.x.get("cpu_monitor_enable").intValue() == 0) goto L9;
        goto L8
    }

    public static a F() {
        return h.a();
    }

    private boolean H() {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 >= 21) goto L5;
    L8:
        return true;
    L5:
        if (r0 > this.q) goto L8;
        return false;
    }

    private boolean J(long r6) {
        if (this.f1684i == false) goto L12;
        int r0 = 20;
        if (this.x.containsKey("cpu_monitor_front_valid_duration") == false) goto L8;
        r0 = this.x.get("cpu_monitor_front_valid_duration").intValue();
    L8:
        if (r6 <= (r0 * 1000)) goto L11;
        return true;
    L11:
        return false;
    L12:
        int r1 = 60;
        if (this.x.containsKey("cpu_monitor_background_duration") == false) goto L16;
        r1 = this.x.get("cpu_monitor_background_duration").intValue();
    L16:
        if (r6 <= (r1 * 1000)) goto L19;
        return true;
    L19:
        return false;
    }

    private void K(long r12) {
        int r1 = 5;
        if (this.f1684i == false) goto L5;
    L11:
        String r2 = "cpu_monitor_function_front_threshold";
        if (this.x.containsKey("cpu_monitor_function_front_threshold") == false) goto L14;
    L13:
        int r0 = this.x.get(r2).intValue();
    L15:
        Map<String, BatteryAgent.a> r3 = BatteryAgent.filterResultAndClear((((long) r0) * r12) / 100);
        if (J(r12) == false) goto L41;
        JSONObject r4 = new JSONObject();
        int r5 = 0;
        boolean r6 = true;
        if (r3.isEmpty() == true) goto L24;
        JSONArray r7 = new JSONArray();
        Iterator<Map.Entry<String, BatteryAgent.a>> r8 = r3.entrySet().iterator();
    L21:
        if (r8.hasNext() == false) goto L23;
        Map.Entry<String, BatteryAgent.a> r9 = r8.next();
        JSONObject r10 = new JSONObject();
        r10.putOpt("method", r9.getKey());
        r10.putOpt("exe_count", Integer.valueOf(r9.getValue().d()));
        r10.putOpt("cpu_cost", Integer.valueOf(r9.getValue().c()));
        r7.put(r10);
        goto L21
    L23:
        r4.putOpt("functions", r7);
        boolean r11 = true;
    L26:
        if (this.v.isEmpty() == true) goto L34;
        ArrayList r13 = new ArrayList(this.v.values());
        Collections.sort(r13, new f(this));
        JSONArray r14 = new JSONArray();
        if (this.x.containsKey("cpu_monitor_thread_count") == false) goto L31;
        r1 = this.x.get("cpu_monitor_thread_count").intValue();
    L31:
        if (r5 >= Math.min(r13.size(), r1)) goto L33;
        com.bytedance.apm.a0.j.a r15 = (com.bytedance.apm.a0.j.a) r13.get(r5);
        JSONObject r16 = new JSONObject();
        r5 = r5 + 1;
        r16.putOpt("rank", Integer.valueOf(r5));
        r16.putOpt("thread_name", r15.f1188b);
        r16.putOpt("cpu_cost", Long.valueOf(r15.f1189c));
        r14.put(r16);
        goto L31
    L33:
        r4.putOpt("threads", r14);
    L35:
        if (r6 == false) goto L41;
        if (this.f1684i == false) goto L39;
        String r17 = com.bytedance.apm.q.i.a.h().g();
    L40:
        JSONObject r18 = new JSONObject();
        r18.putOpt("scene", r17);
        JSONObject r19 = new JSONObject();
        r19.putOpt("stay_duration", Long.valueOf(r12));
        com.bytedance.apm.x.a.d("APM-BatteryLocal", "scene:" + r17 + " stayDuration:" + r12 + " data:" + r4.toString());
        com.bytedance.apm.c.l("monitor_expend_function", r18, r19, r4);
        goto L41
    L39:
        r17 = TraceCons.METRIC_BACKGROUND;
        goto L40
    L34:
        r6 = r11;
        goto L35
    L24:
        r11 = false;
    L41:
        P();
        return;
    L14:
        r0 = 5;
        goto L15
    L5:
        if (TextUtils.isEmpty(this.t) == false) goto L11;
        r2 = "cpu_monitor_function_background_threshold";
        if (this.x.containsKey("cpu_monitor_function_background_threshold") == true) goto L13;
        r0 = 2;
        goto L15
    }

    private void L() {
        if (H() == false) goto L5;
        return;
    L5:
        com.bytedance.apm.x.a.d("APM-Battery", "ToBack");
        com.bytedance.apm.q.i.a.h().p(ActivityLifeObserver.getInstance().getTopActivityClassName());
        com.bytedance.apm.f0.b.f().d(new c(this));
    }

    private void M(String r3) {
        if (H() == false) goto L5;
        return;
    L5:
        com.bytedance.apm.x.a.d("APM-Battery", "ToFront:" + r3);
        com.bytedance.apm.q.i.a.h().p(r3);
        com.bytedance.apm.f0.b.f().d(new b(this));
    }

    private boolean N() {
        return O(false);
    }

    private boolean O(boolean r19) {
        long r1 = SystemClock.elapsedRealtime();
        long r3 = r1 - this.f1683h;
        if (r3 <= 2000) goto L5;
        boolean r5 = true;
    L6:
        boolean r14 = r5;
        if (this.f1683h == (-1)) goto L14;
        if (r14 == false) goto L14;
        boolean r17 = r14;
        com.bytedance.apm.q.i.a.h().l(new com.bytedance.apm.u.a(this.f1684i, System.currentTimeMillis(), "ground_record", this.y, r3, this.t));
        if (this.f1684i == false) goto L16;
        if (r3 <= 7200000) goto L16;
        HashMap r6 = new HashMap();
        r6.put(TypedValues.TransitionType.S_DURATION, String.valueOf(r3));
        EnsureManager.ensureNotReachHere("BatterErrorDuration", r6);
    L16:
        if (this.f1683h == (-1)) goto L21;
        if (r19 == false) goto L21;
        if (C() == false) goto L21;
        K(r3);
    L21:
        this.f1683h = r1;
        return r17;
    L14:
        r17 = r14;
        goto L16
    L5:
        r5 = false;
        goto L6
    }

    private void P() {
        this.u.clear();
        this.v.clear();
        LinkedList<com.bytedance.apm.a0.j.a> r0 = com.bytedance.apm.a0.j.b.a(Process.myPid());
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isEmpty() == true) goto L13;
        Iterator<com.bytedance.apm.a0.j.a> r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L14;
        com.bytedance.apm.a0.j.a r2 = r1.next();
        this.u.put(Integer.valueOf(r2.f1187a), r2);
        goto L9
    L14:
        return;
    }

    private void Q() {
        if (this.u.isEmpty() == false) goto L5;
        return;
    L5:
        LinkedList<com.bytedance.apm.a0.j.a> r0 = com.bytedance.apm.a0.j.b.a(Process.myPid());
        if (r0 != null) goto L8;
        return;
    L8:
        if (r0.isEmpty() == true) goto L32;
        Iterator<com.bytedance.apm.a0.j.a> r1 = r0.iterator();
    L12:
        if (r1.hasNext() == false) goto L33;
        com.bytedance.apm.a0.j.a r2 = r1.next();
        if (this.u.containsKey(Integer.valueOf(r2.f1187a)) == false) goto L16;
        long r3 = r2.f1189c - this.u.get(Integer.valueOf(r2.f1187a)).f1189c;
    L18:
        if (r3 <= 0) goto L12;
        long r4 = (long) ((r3 / this.w) * 1000.0d);
        if (this.v.containsKey(Integer.valueOf(r2.f1187a)) == true) goto L21;
        this.v.put(Integer.valueOf(r2.f1187a), new com.bytedance.apm.a0.j.a(r2.f1187a, r2.f1188b, r4));
        goto L12
    L21:
        this.v.get(Integer.valueOf(r2.f1187a)).a(r4);
        goto L12
    L16:
        r3 = r2.f1189c;
        goto L18
    L33:
        return;
    }

    static /* synthetic */ boolean o(a r0) {
        return r0.f1685j;
    }

    static /* synthetic */ long p(a r2) {
        return r2.m;
    }

    static /* synthetic */ long q(a r0, long r1) {
        r0.m = r1;
        return r1;
    }

    static /* synthetic */ long r(a r2) {
        return r2.f1687l;
    }

    static /* synthetic */ void s(a r0) {
        r0.Q();
    }

    static /* synthetic */ HashMap t(a r0) {
        return r0.x;
    }

    static /* synthetic */ d.b.l.a.h.e u(a r0) {
        return r0.A;
    }

    static /* synthetic */ Object v() {
        return B;
    }

    static /* synthetic */ boolean w(a r0) {
        return r0.N();
    }

    static /* synthetic */ Map x(a r0) {
        return r0.f1682g;
    }

    static /* synthetic */ boolean y(a r0, boolean r1) {
        r0.y = r1;
        return r1;
    }

    static /* synthetic */ boolean z(a r0, boolean r1) {
        return r0.O(r1);
    }

    public Map<String, l> D() {
        return this.f1682g;
    }

    public String E() {
        return this.t;
    }

    public void G(boolean r1) {
        this.o = r1;
        d();
    }

    public boolean I() {
        return this.p;
    }

    @Override // com.bytedance.apm.q.k.a.b
    public void a(boolean r3) {
        if (this.f1682g.isEmpty() == false) goto L5;
        return;
    L5:
        com.bytedance.apm.q.i.a.h().p(ActivityLifeObserver.getInstance().getTopActivityClassName());
        com.bytedance.apm.f0.b.f().d(new RunnableC0052a(this, r3));
    }

    @Override // com.bytedance.apm.a0.a
    protected void c(JSONObject r14) {
        this.f1686k = r14.optLong("battery_record_interval", 10);
        this.f1687l = r14.optLong("battery_report_interval", 30);
        int r0 = r14.optInt("enable_upload", 0);
        if (r0 == 1) goto L5;
    L7:
        boolean r3 = false;
    L8:
        this.f1685j = r3;
        this.q = r14.optInt("support_max_api_level", this.q);
        if (com.bytedance.apm.d.C() == false) goto L12;
        com.bytedance.apm.x.e.c(com.bytedance.apm.x.b.f2126b, new String[]{"mRecordInterval:" + this.f1686k + ",mBatteryCollectEnabled" + r0});
    L12:
        if (this.f1685j == true) goto L17;
        if (this.o == true) goto L17;
        this.f1682g.clear();
        ActivityLifeObserver.getInstance().unregister(this);
        com.bytedance.apm.q.k.a.h(com.bytedance.apm.d.h(), this);
    L20:
        if (r14.optInt("trace_enable", 0) != 1) goto L22;
        boolean r1 = true;
    L23:
        this.p = r1;
        if (this.p == false) goto L26;
        com.bytedance.apm.q.g.a.k(r14.optLong("max_single_wake_lock_hold_time_second", 120) * 1000);
        com.bytedance.apm.q.g.a.n(r14.optInt("max_total_wake_lock_acquire_count", 5));
        com.bytedance.apm.q.g.a.o(r14.optLong("max_total_wake_lock_hold_time_second", 240) * 1000);
        com.bytedance.apm.q.g.a.p(r14.optInt("max_wake_up_alarm_invoke_count", 5));
        com.bytedance.apm.q.g.a.i(r14.optInt("max_normal_alarm_invoke_count", 10));
        com.bytedance.apm.q.g.a.j(r14.optLong("max_single_loc_request_time_second", 120) * 1000);
        com.bytedance.apm.q.g.a.l(r14.optInt("max_total_loc_request_count", 5));
        com.bytedance.apm.q.g.a.m(r14.optLong("max_total_loc_request_time_second", 240) * 1000);
    L26:
        JSONObject r2 = r14.optJSONObject("cpu_monitor_config");
        if (r2 == null) goto L37;
        Iterator<String> r4 = r2.keys();
    L30:
        if (r4.hasNext() == false) goto L37;
        String r5 = r4.next();
        if ("cpu_monitor_enable".equals(r5) == true) goto L33;
        int r6 = r2.optInt(r5, 0);
        if (r6 <= 0) goto L30;
        this.x.put(r5, Integer.valueOf(r6));
        goto L30
    L33:
        this.x.put(r5, Integer.valueOf(r2.optInt(r5, 1)));
    L37:
        this.n = o.d(r14, "scene_black_list");
        if (C() == false) goto L49;
        com.bytedance.apm.f0.b.f().d(this.A);
        P();
        return;
    L49:
        return;
    L22:
        r1 = false;
    L17:
        if (r14.optInt("battery_net_for_all_interface_enable", 0) != 1) goto L20;
        this.f1682g.put("traffic_all_interface", new i());
        goto L20
    L5:
        if (this.f1686k <= 0) goto L7;
        r3 = true;
        goto L8
    }

    @Override // com.bytedance.apm.a0.a
    protected boolean f() {
        return false;
    }

    @Override // com.bytedance.apm.a0.a
    public void h() {
        if (H() == false) goto L5;
        return;
    L5:
        com.bytedance.apm.x.a.d("APM-Battery", "Battery init process" + com.bytedance.apm.d.i());
        this.f1684i = ActivityLifeObserver.getInstance().isForeground();
        this.s[1] = ActivityLifeObserver.getInstance().getTopActivityClassName();
        this.w = com.bytedance.apm.util.b.j(100);
        this.y = com.bytedance.apm.q.k.a.e(com.bytedance.apm.d.h(), this);
        com.bytedance.apm.q.j.d r3 = new com.bytedance.apm.q.j.d();
        com.bytedance.apm.q.j.g r5 = new com.bytedance.apm.q.j.g();
        k r6 = new k();
        com.bytedance.apm.q.h.a r7 = new com.bytedance.apm.q.h.a();     // Catch: Throwable -> L8
        r7.a(NotificationCompat.CATEGORY_ALARM, r3);     // Catch: Throwable -> L8
        r7.a(LocationMonitorConst.LOCATION, r5);     // Catch: Throwable -> L8
        r7.a("power", r6);     // Catch: Throwable -> L8
        r7.b();     // Catch: Throwable -> L8
        this.f1682g.put(NotificationCompat.CATEGORY_ALARM, r3);     // Catch: Throwable -> L8
        this.f1682g.put(LocationMonitorConst.LOCATION, r5);     // Catch: Throwable -> L8
        this.f1682g.put("power", r6);     // Catch: Throwable -> L8
    L10:
        com.bytedance.apm.q.j.f r0 = new com.bytedance.apm.q.j.f();
        j r1 = new j();
        com.bytedance.apm.q.j.h r2 = new com.bytedance.apm.q.j.h();
        com.bytedance.apm.q.j.e r4 = new com.bytedance.apm.q.j.e();
        this.f1682g.put("cpu_active_time", r0);
        this.f1682g.put("traffic", r1);
        this.f1682g.put("traffic_packets", r2);
        this.f1682g.put("battery_consume", r4);
        this.m = SystemClock.elapsedRealtime();
        return;
    L8:
        th = move-exception;
        com.bytedance.apm.x.a.a("APM-Battery", "SYSTEM_SERVICE_FETCHERS hook failed: " + th.getMessage());
        goto L10
    }

    @Override // com.bytedance.apm.a0.a
    public void i() {
        if (H() == false) goto L5;
        return;
    L5:
        if (this.f1682g.isEmpty() == true) goto L13;
        com.bytedance.apm.x.a.d("APM-Battery", "OnTimer");
        long r0 = n();
        if (r0 <= 0) goto L10;
        com.bytedance.apm.f0.b.f().e(this.z, r0);
    L10:
        com.bytedance.apm.q.i.a.h().p(ActivityLifeObserver.getInstance().getTopActivityClassName());
        com.bytedance.apm.f0.b.f().d(new d(this));
        return;
    }

    @Override // com.bytedance.apm.a0.a
    protected long n() {
        return this.f1686k * 60000;
    }

    @Override // com.bytedance.apm.a0.a, com.bytedance.services.apm.api.IActivityLifeObserver
    public void onActivityResume(Activity r5) {
        super.onActivityResume(r5);
        String[] r0 = this.s;
        r0[0] = r0[1];
        r0[1] = r5.getClass().getName();
        if (TextUtils.equals(r5.getClass().getName(), this.r) == false) goto L5;
    L7:
        this.r = null;
        return;
    L5:
        if (TextUtils.isEmpty(this.s[0]) == true) goto L7;
        M(this.s[0]);
        goto L7
    }

    @Override // com.bytedance.apm.a0.a, com.bytedance.services.apm.api.IActivityLifeObserver
    public void onBackground(Activity r1) {
        super.onBackground(r1);
        L();
    }

    @Override // com.bytedance.apm.a0.a, com.bytedance.services.apm.api.IActivityLifeObserver
    public void onFront(Activity r1) {
        super.onFront(r1);
        this.r = r1.getClass().getName();
        M(ActivityLifeObserver.getInstance().getTopActivityClassName());
    }

    @Override // com.bytedance.apm.a0.a, com.bytedance.services.slardar.config.IConfigListener
    public void onReady() {
        super.onReady();
        if (com.bytedance.apm.d.G() == true) goto L5;
        return;
    L5:
        if (this.f1685j == false) goto L9;
        com.bytedance.apm.q.i.a.h().k(true);
        this.m = SystemClock.elapsedRealtime();
        return;
    }
}
