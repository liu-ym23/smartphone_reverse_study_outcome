package tmsdkobf;

import android.app.Application;
import android.content.Context;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.bytedance.frameworks.baselib.network.http.util.HttpStatus;
import com.tencent.tmsecure.vd.TNative$aa;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.WeakHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public abstract class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f256a = null;
    public static final String b = null;
    public static final AtomicReference c = null;

    public static class a implements Callable {
        public static final HashMap d = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f257a;
        public final Map b;
        public final boolean c;

        /* JADX INFO: renamed from: tmsdkobf.i0$a$a, reason: collision with other inner class name */
        public class C0100a implements Comparator {
            public C0100a(a r1) {
            }

            @Override // java.util.Comparator
            public int compare(Object r1, Object r2) {
                return ((Integer) r1).intValue() - ((Integer) r2).intValue();
            }
        }

        static {
            d = new HashMap();
        }

        public a(Map r3, boolean r4) {
            this.b = r3;
            this.c = r4;
            if (r3 != null) goto L5;
        L11:
            this.f257a = "";
            return;
        L5:
            if (r3.isEmpty() == true) goto L11;
            TreeMap r5 = new TreeMap(new C0100a(this));
            r5.putAll(r3);
            Iterator r6 = r5.keySet().iterator();
            StringBuilder r0 = new StringBuilder();
        L8:
            if (r6.hasNext() == false) goto L10;
            r0.append((String) r5.get((Integer) r6.next()));
            goto L8
        L10:
            this.f257a = r0.toString();
        }

        public FutureTask a() {
            HashMap r0 = d;
            monitor-enter(r0);
            Iterator r1 = r0.entrySet().iterator();     // Catch: Throwable -> L17
        L6:
            if (r1.hasNext() == false) goto L10;
            if (((FutureTask) ((Map.Entry) r1.next()).getValue()).isDone() == false) goto L6;
            r1.remove();     // Catch: Throwable -> L17
            goto L6
        L10:
            HashMap r2 = d;     // Catch: Throwable -> L17
            FutureTask r3 = (FutureTask) r2.get(this.f257a);     // Catch: Throwable -> L17
            if (r3 != null) goto L13;
        L14:
            r3 = new FutureTask(this);     // Catch: Throwable -> L17
            xh.f623a.submit(r3);     // Catch: Throwable -> L17
            r2.put(this.f257a, r3);     // Catch: Throwable -> L17
        L15:
            monitor-exit(r0);     // Catch: Throwable -> L17
            return r3;
        L13:
            if (r3.isDone() == false) goto L15;
        L17:
            th = move-exception;
            throw th;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            monitor-enter(mh.class);
            Context r1 = mh.f353a;     // Catch: Throwable -> L11
            monitor-exit(mh.class);
            x r0 = new x();
            q5.f.a(r1);     // Catch: Throwable -> L9
            r0.b = 0;     // Catch: Throwable -> L9
            r0.e = System.currentTimeMillis();     // Catch: Throwable -> L9
            byte[] r4 = i0.a(r1, this.b, r0, this.c);     // Catch: Throwable -> L9
            r0.f = System.currentTimeMillis();     // Catch: Throwable -> L9
            r0.c = r4.length;     // Catch: Throwable -> L9
            j0 r5 = i0.a(r1, r4, r0);     // Catch: Throwable -> L9
            i0.a(r1, r5);     // Catch: Throwable -> L9
            i0.a(r1, r0);     // Catch: Throwable -> L9
            return r5;
        L10:
            return new j0(-10015);
        L11:
            th = move-exception;
            throw th;
        }
    }

    static {
        f256a = xk.a(xk.Y0);
        b = xk.a(xk.c1);
        c = new AtomicReference(null);
    }

    public static void a() {
        e4 r0 = w.f587a;
        if (o5.f.a("enable_risk_click", n0.b) == true) goto L5;
        return;
    L5:
        if (fh.a() == true) goto L8;
        tf.a();
    L8:
        Log.i("TRCDM", "erc");
        m8 r1 = w.e;
        monitor-enter(wk.class);
        WeakHashMap r2 = wk.f606a;     // Catch: Throwable -> L37
        if (r1 != null) goto L14;
    L19:
        monitor-exit(wk.class);
        return;
    L14:
        monitor-enter(mh.class);     // Catch: Throwable -> L37
        Context r3 = mh.f353a;     // Catch: Throwable -> L34
        monitor-exit(mh.class);     // Catch: Throwable -> L37
        if ((r3 instanceof Application) == false) goto L19;
        Application r4 = (Application) r3;     // Catch: Throwable -> L37
        AtomicReference r5 = wk.b;     // Catch: Throwable -> L37
        monitor-enter(r5);     // Catch: Throwable -> L37
    L31:
        th = move-exception;
        throw th;     // Catch: Throwable -> L37
    L24:
        if (r5.get() == null) goto L27;
        monitor-exit(r5);     // Catch: Throwable -> L31
    L29:
        monitor-exit(wk.class);
        return;
    L27:
        HandlerThread r6 = new HandlerThread("TuringDispatch");     // Catch: Throwable -> L31
        r6.start();     // Catch: Throwable -> L31
        wk.a r7 = new wk.a(new ph(r6.getLooper(), r1));     // Catch: Throwable -> L31
        r5.set(r7);     // Catch: Throwable -> L31
        r4.registerActivityLifecycleCallbacks(r7);     // Catch: Throwable -> L31
        monitor-exit(r5);     // Catch: Throwable -> L31
        goto L29
    L34:
        th = move-exception;
        throw th;     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        throw th;
    }

    public static j0 a(Context r10, byte[] r11, x r12) {
        if (r11.length == 0) goto L29;
        x5 r13 = s5.b.a(r11, 8123, 18123);
        int r14 = r13.f613a;
        if (r14 != 0) goto L30;
        byte[] r15 = r13.b;
        m0 r0 = new m0();     // Catch: Throwable -> L26
        r0.f344a = -999;     // Catch: Throwable -> L26
        if (r12.b != 1) goto L12;
        r0 = (m0) z8.a(r0, r15);     // Catch: Throwable -> L26
    L13:
        if (r0 == null) goto L31;
        int r16 = r0.f344a;     // Catch: Throwable -> L26
        if (r16 != 0) goto L34;
        if (TextUtils.isEmpty(r0.b) == true) goto L32;
        o0.a(r0.f, r0.e);     // Catch: Throwable -> L26
        int r17 = (int) TimeUnit.MINUTES.toSeconds(10);     // Catch: Throwable -> L26
        if (r0.c >= 0) goto L33;
        r0.c = r17;     // Catch: Throwable -> L26
    L33:
        return new j0(0, r0.b, System.currentTimeMillis(), ((long) r0.c) * 1000, r0.d, r0.e);
    L32:
        return new j0(-1001);
    L34:
        return new j0((-2000) - r16);
    L31:
        return new j0(-1002);
    L12:
        y1 r18 = new y1(r15);     // Catch: Throwable -> L26
        r18.b = "UTF-8";     // Catch: Throwable -> L26
        r0.a(r18);     // Catch: Throwable -> L26
        goto L13
    L27:
        return new j0(-999);
    L30:
        return new j0(r14);
    L29:
        return new j0(-1000);
    }

    public static void a(Context r6, x r7) {
        StringBuilder r0 = p.a("5_").append(r7.b).append("_").append(r7.d).append("_").append(System.currentTimeMillis() - r7.f608a).append("_").append(r7.c).append("_");
        long r1 = r7.e;
        if (r1 < 0) goto L7;
        long r3 = r7.f;
        if (r3 < r1) goto L7;
        long r2 = r3 - r1;
    L9:
        String r8 = r0.append(r2).toString();
        String r4 = d5.b;
        HashMap r5 = new HashMap();
        r5.put("703", r8);
        d5.a(r6, r5);
        return;
    L7:
        r2 = -1;
        goto L9
    }

    public static String a(Context r6, int r7, li r8, boolean r9, boolean r10) {
        HashMap r0 = new HashMap();
        r0.put("3", "" + r7);
        if (r9 == false) goto L5;
        String r2 = "1";
    L6:
        r0.put("3005", r2);
        if (r10 == false) goto L9;
        String r11 = "1";
    L10:
        r0.put("3006", r11);
        if (r7 != 17) goto L13;
    L14:
        long r1 = System.currentTimeMillis();
        monitor-enter(k3.class);
        k3 r3 = k3.D;     // Catch: Throwable -> L45
        monitor-exit(k3.class);
        r3.getClass();
        List r12 = od.a(null);
        r8.a(-r7, System.currentTimeMillis() - r1);
        HashSet r4 = new HashSet();
        if (r12 != null) goto L21;
    L24:
        if (r9 == false) goto L30;
        Set r13 = o5.f.c();
        if (r13 == null) goto L28;
        r4.addAll(r13);
    L28:
        r4.add(r6.getPackageName());
    L30:
        if (r4.isEmpty() == true) goto L32;
        r0.put("277", od.a(r4));
    L32:
        long r14 = System.currentTimeMillis();
        SparseArray<Object> r15 = TNative$aa.h90_A43184BF099FF466(new SparseArray(), r6, r0, 0);     // Catch: Throwable -> L43
        if (ca.b(r15) == 0) goto L38;
        return "";
    L38:
        String r16 = (String) ca.a(r15, HttpStatus.SC_RESET_CONTENT, String.class);
        int r5 = z1.f651a;
        if (r16 != null) goto L41;
        r16 = "";
    L41:
        r8.f333a.put(Integer.valueOf(r7), Long.valueOf(System.currentTimeMillis() - r14));
        return r16;
    L43:
        return "";
    L21:
        if (((ArrayList) r12).isEmpty() == true) goto L24;
        r4.addAll(r12);
    L45:
        th = move-exception;
        throw th;
    L13:
        if (r7 != 40) goto L32;
    L9:
        r11 = "0";
        goto L10
    L5:
        r2 = "0";
        goto L6
    }

    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r15v1 ??, new type: boolean
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryPossibleTypes(FixTypesVisitor.java:186)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:245)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException
        */
    public static byte[] a(android.content.Context r21, java.util.Map r22, tmsdkobf.x r23, boolean r24) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x02e3: MOVE (r9v24 ?? I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r5v2 boolean) A[DECLARE_VAR] in method: tmsdkobf.i0.a(android.content.Context, java.util.Map, tmsdkobf.x, boolean):byte[], file: classes5.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:348)
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
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.ArgType.getPrimitiveType()" because "type" is null
            	at jadx.core.codegen.ClassGen.useType(ClassGen.java:564)
            	at jadx.core.codegen.InsnGen.useType(InsnGen.java:269)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:166)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:159)
            	at jadx.core.codegen.InsnGen.assignVar(InsnGen.java:152)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:299)
            	... 31 more
            */
        /*
            Method dump skipped, instruction units count: 2333
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: tmsdkobf.i0.a(android.content.Context, java.util.Map, tmsdkobf.x, boolean):byte[]");
    }

    public static j0 a(Context r11) {
        AtomicReference r0 = c;
        monitor-enter(r0);
        j0 r1 = (j0) r0.get();     // Catch: Throwable -> L31
        if (r1 != null) goto L29;
        String r4 = d5.b(r11, "1001");     // Catch: Throwable -> L31
        if (TextUtils.isEmpty(r4) == false) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L31
        return null;
    L11:
        long r2 = 0;
        long r5 = Long.parseLong(d5.b(r11, "1002"));     // Catch: Throwable -> L14
    L35:
        r2 = Long.parseLong(d5.b(r11, "1003"));     // Catch: Throwable -> L34
    L16:
        long r7 = r2;
        int r12 = Integer.parseInt(d5.b(r11, "1004"));     // Catch: Throwable -> L19
    L20:
        int r9 = r12;
        monitor-enter(mh.class);     // Catch: Throwable -> L31
        Context r3 = mh.f353a;     // Catch: Throwable -> L26
        monitor-exit(mh.class);     // Catch: Throwable -> L31
        r1 = new j0(0, r4, r5, r7, r9, d5.b(r3, "1005"));     // Catch: Throwable -> L31
        c.set(r1);     // Catch: Throwable -> L31
        goto L29
    L26:
        th = move-exception;
        throw th;     // Catch: Throwable -> L31
    L19:
        r12 = 0;
    L14:
        r5 = 0;
    L29:
        monitor-exit(r0);     // Catch: Throwable -> L31
        return r1;
    L31:
        th = move-exception;
        throw th;
    }

    public static void a(Context r3, j0 r4) {
        AtomicReference r0 = c;
        monitor-enter(r0);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (r4.f279a == 0) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L18
        return;
    L8:
        r0.set(r4);     // Catch: Throwable -> L18
        monitor-exit(r0);     // Catch: Throwable -> L18
        String r1 = d5.b;
        if (TextUtils.isEmpty(r4.b) == true) goto L23;
        HashMap r2 = new HashMap();
        r2.put("1001", r4.b);
        r2.put("1002", String.valueOf(r4.c));
        r2.put("1003", String.valueOf(r4.d));
        r2.put("1004", String.valueOf(r4.e));
        String r5 = r4.f;
        int r6 = z1.f651a;
        if (r5 != null) goto L16;
        r5 = "";
    L16:
        r2.put("1005", r5);
        d5.a(r3, r2);
        return;
    }
}
