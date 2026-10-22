package com.facebook.imageutils;

import androidx.annotation.Nullable;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile Class f6771a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Class f6772b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static d.c.h.d f6773c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static d.c.h.d f6774d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Method f6775e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Method f6776f;

    static {
        f6772b = Class.forName("com.bytedance.fresco.heif.HeifDecoder");     // Catch: ClassNotFoundException -> L4
        return;
    L4:
        e = move-exception;
        d.c.c.e.a.k("HeifFormatUtil", "Heif init ", e);
    }

    public static boolean a(d.c.i.l.e r10) {
        if (r10 != null) goto L5;
    L19:
        return false;
    L5:
        if (d.c.h.c.d(r10.N()) == false) goto L19;
        int r2 = r10.O().available();     // Catch: IOException -> L17
        int[] r3 = h(r10.O());     // Catch: IOException -> L17
        if (r3 == null) goto L19;
        if (r3.length < 8) goto L19;
        if (r3[5] != 1) goto L19;
        d.c.c.e.a.c("HeifFormatUtil", "fresco_parseThumbData available len:" + r2 + " thumb:" + (r3[6] + r3[7]));     // Catch: IOException -> L17
        if ((r3[6] + r3[7]) >= r2) goto L16;
        r10.E0(true);     // Catch: IOException -> L17
    L16:
        return true;
    L17:
        e = move-exception;
        d.c.c.e.a.k("HeifFormatUtil", "canParseThumbData ", e);
        goto L19
    }

    private static synchronized Class b() {
        monitor-enter(d.class);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (f6771a == null) goto L16;
    L10:
        Class r1 = f6771a;     // Catch: Throwable -> L13
        monitor-exit(d.class);
        return r1;
    L16:
        f6771a = Class.forName("com.bytedance.fresco.nativeheif.Heif");     // Catch: ClassNotFoundException -> L8 Throwable -> L13
    L8:
        e = move-exception;
        d.c.c.e.a.k("HeifFormatUtil", "Heif init ", e);     // Catch: Throwable -> L13
        goto L10
    }

    @Nullable
    public static d.c.h.d c() {
        d.c.h.d r2 = f6773c;
        if (r2 == null) goto L5;
        return r2;
    L5:
        Class r3 = f6772b;
        if (r3 != null) goto L16;
        return null;
    L16:
        f6773c = (d.c.h.d) r3.getDeclaredField("HEIF_FORMAT").get(null);     // Catch: Exception -> L10 Throwable -> L12
    L15:
        return f6773c;
    L12:
        e = move-exception;
        d.c.c.e.a.k("HeifFormatUtil", "HeifFormat init ", e);
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L15
    }

    public static d.c.h.d d() {
        d.c.h.d r2 = f6774d;
        if (r2 == null) goto L5;
        return r2;
    L5:
        Class r3 = f6772b;
        if (r3 != null) goto L16;
        return null;
    L16:
        f6774d = (d.c.h.d) r3.getDeclaredField("HEIF_FORMAT_ANIMATED").get(null);     // Catch: Exception -> L10 Throwable -> L12
    L15:
        return f6774d;
    L12:
        e = move-exception;
        d.c.c.e.a.k("HeifFormatUtil", "HEIF_FORMAT_ANIMATED init ", e);
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L15
    }

    public static int[] e(byte[] r8, int r9) {
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
            java.lang.Class r0 = b()
            r1 = 0
            if (r0 != 0) goto L8
            return r1
        L8:
            java.lang.reflect.Method r2 = com.facebook.imageutils.d.f6775e     // Catch: java.lang.Exception -> L3b java.lang.reflect.InvocationTargetException -> L40 java.lang.IllegalAccessException -> L45 java.lang.NoSuchMethodException -> L4a
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 != 0) goto L21
            java.lang.String r2 = "parseSimpleMeta"
            java.lang.Class[] r6 = new java.lang.Class[r4]     // Catch: java.lang.Exception -> L3b java.lang.reflect.InvocationTargetException -> L40 java.lang.IllegalAccessException -> L45 java.lang.NoSuchMethodException -> L4a
            java.lang.Class<byte[]> r7 = byte[].class
            r6[r3] = r7     // Catch: java.lang.Exception -> L3b java.lang.reflect.InvocationTargetException -> L40 java.lang.IllegalAccessException -> L45 java.lang.NoSuchMethodException -> L4a
            java.lang.Class r7 = java.lang.Integer.TYPE     // Catch: java.lang.Exception -> L3b java.lang.reflect.InvocationTargetException -> L40 java.lang.IllegalAccessException -> L45 java.lang.NoSuchMethodException -> L4a
            r6[r5] = r7     // Catch: java.lang.Exception -> L3b java.lang.reflect.InvocationTargetException -> L40 java.lang.IllegalAccessException -> L45 java.lang.NoSuchMethodException -> L4a
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r2, r6)     // Catch: java.lang.Exception -> L3b java.lang.reflect.InvocationTargetException -> L40 java.lang.IllegalAccessException -> L45 java.lang.NoSuchMethodException -> L4a
            com.facebook.imageutils.d.f6775e = r0     // Catch: java.lang.Exception -> L3b java.lang.reflect.InvocationTargetException -> L40 java.lang.IllegalAccessException -> L45 java.lang.NoSuchMethodException -> L4a
        L21:
            java.lang.reflect.Method r0 = com.facebook.imageutils.d.f6775e     // Catch: java.lang.Exception -> L3b java.lang.reflect.InvocationTargetException -> L40 java.lang.IllegalAccessException -> L45 java.lang.NoSuchMethodException -> L4a
            if (r0 == 0) goto L4e
            r0.setAccessible(r5)     // Catch: java.lang.Exception -> L3b java.lang.reflect.InvocationTargetException -> L40 java.lang.IllegalAccessException -> L45 java.lang.NoSuchMethodException -> L4a
            java.lang.reflect.Method r0 = com.facebook.imageutils.d.f6775e     // Catch: java.lang.Exception -> L3b java.lang.reflect.InvocationTargetException -> L40 java.lang.IllegalAccessException -> L45 java.lang.NoSuchMethodException -> L4a
            java.lang.Object[] r2 = new java.lang.Object[r4]     // Catch: java.lang.Exception -> L3b java.lang.reflect.InvocationTargetException -> L40 java.lang.IllegalAccessException -> L45 java.lang.NoSuchMethodException -> L4a
            r2[r3] = r8     // Catch: java.lang.Exception -> L3b java.lang.reflect.InvocationTargetException -> L40 java.lang.IllegalAccessException -> L45 java.lang.NoSuchMethodException -> L4a
            java.lang.Integer r8 = java.lang.Integer.valueOf(r9)     // Catch: java.lang.Exception -> L3b java.lang.reflect.InvocationTargetException -> L40 java.lang.IllegalAccessException -> L45 java.lang.NoSuchMethodException -> L4a
            r2[r5] = r8     // Catch: java.lang.Exception -> L3b java.lang.reflect.InvocationTargetException -> L40 java.lang.IllegalAccessException -> L45 java.lang.NoSuchMethodException -> L4a
            java.lang.Object r8 = r0.invoke(r1, r2)     // Catch: java.lang.Exception -> L3b java.lang.reflect.InvocationTargetException -> L40 java.lang.IllegalAccessException -> L45 java.lang.NoSuchMethodException -> L4a
            int[] r8 = (int[]) r8     // Catch: java.lang.Exception -> L3b java.lang.reflect.InvocationTargetException -> L40 java.lang.IllegalAccessException -> L45 java.lang.NoSuchMethodException -> L4a
            return r8
        L3b:
            r8 = move-exception
            r8.printStackTrace()
            goto L4e
        L40:
            r8 = move-exception
            r8.printStackTrace()
            goto L4e
        L45:
            r8 = move-exception
            r8.printStackTrace()
            goto L4e
        L4a:
            r8 = move-exception
            r8.printStackTrace()
        L4e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imageutils.d.e(byte[], int):int[]");
    }

    public static int[] f(byte[] r8, int r9) {
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
            java.lang.Class r0 = b()
            r1 = 0
            if (r0 != 0) goto L8
            return r1
        L8:
            java.lang.reflect.Method r2 = com.facebook.imageutils.d.f6776f     // Catch: java.lang.Exception -> L3b java.lang.reflect.InvocationTargetException -> L40 java.lang.IllegalAccessException -> L45 java.lang.NoSuchMethodException -> L4a
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 != 0) goto L21
            java.lang.String r2 = "parseThumbMeta"
            java.lang.Class[] r6 = new java.lang.Class[r4]     // Catch: java.lang.Exception -> L3b java.lang.reflect.InvocationTargetException -> L40 java.lang.IllegalAccessException -> L45 java.lang.NoSuchMethodException -> L4a
            java.lang.Class<byte[]> r7 = byte[].class
            r6[r3] = r7     // Catch: java.lang.Exception -> L3b java.lang.reflect.InvocationTargetException -> L40 java.lang.IllegalAccessException -> L45 java.lang.NoSuchMethodException -> L4a
            java.lang.Class r7 = java.lang.Integer.TYPE     // Catch: java.lang.Exception -> L3b java.lang.reflect.InvocationTargetException -> L40 java.lang.IllegalAccessException -> L45 java.lang.NoSuchMethodException -> L4a
            r6[r5] = r7     // Catch: java.lang.Exception -> L3b java.lang.reflect.InvocationTargetException -> L40 java.lang.IllegalAccessException -> L45 java.lang.NoSuchMethodException -> L4a
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r2, r6)     // Catch: java.lang.Exception -> L3b java.lang.reflect.InvocationTargetException -> L40 java.lang.IllegalAccessException -> L45 java.lang.NoSuchMethodException -> L4a
            com.facebook.imageutils.d.f6776f = r0     // Catch: java.lang.Exception -> L3b java.lang.reflect.InvocationTargetException -> L40 java.lang.IllegalAccessException -> L45 java.lang.NoSuchMethodException -> L4a
        L21:
            java.lang.reflect.Method r0 = com.facebook.imageutils.d.f6776f     // Catch: java.lang.Exception -> L3b java.lang.reflect.InvocationTargetException -> L40 java.lang.IllegalAccessException -> L45 java.lang.NoSuchMethodException -> L4a
            if (r0 == 0) goto L4e
            r0.setAccessible(r5)     // Catch: java.lang.Exception -> L3b java.lang.reflect.InvocationTargetException -> L40 java.lang.IllegalAccessException -> L45 java.lang.NoSuchMethodException -> L4a
            java.lang.reflect.Method r0 = com.facebook.imageutils.d.f6776f     // Catch: java.lang.Exception -> L3b java.lang.reflect.InvocationTargetException -> L40 java.lang.IllegalAccessException -> L45 java.lang.NoSuchMethodException -> L4a
            java.lang.Object[] r2 = new java.lang.Object[r4]     // Catch: java.lang.Exception -> L3b java.lang.reflect.InvocationTargetException -> L40 java.lang.IllegalAccessException -> L45 java.lang.NoSuchMethodException -> L4a
            r2[r3] = r8     // Catch: java.lang.Exception -> L3b java.lang.reflect.InvocationTargetException -> L40 java.lang.IllegalAccessException -> L45 java.lang.NoSuchMethodException -> L4a
            java.lang.Integer r8 = java.lang.Integer.valueOf(r9)     // Catch: java.lang.Exception -> L3b java.lang.reflect.InvocationTargetException -> L40 java.lang.IllegalAccessException -> L45 java.lang.NoSuchMethodException -> L4a
            r2[r5] = r8     // Catch: java.lang.Exception -> L3b java.lang.reflect.InvocationTargetException -> L40 java.lang.IllegalAccessException -> L45 java.lang.NoSuchMethodException -> L4a
            java.lang.Object r8 = r0.invoke(r1, r2)     // Catch: java.lang.Exception -> L3b java.lang.reflect.InvocationTargetException -> L40 java.lang.IllegalAccessException -> L45 java.lang.NoSuchMethodException -> L4a
            int[] r8 = (int[]) r8     // Catch: java.lang.Exception -> L3b java.lang.reflect.InvocationTargetException -> L40 java.lang.IllegalAccessException -> L45 java.lang.NoSuchMethodException -> L4a
            return r8
        L3b:
            r8 = move-exception
            r8.printStackTrace()
            goto L4e
        L40:
            r8 = move-exception
            r8.printStackTrace()
            goto L4e
        L45:
            r8 = move-exception
            r8.printStackTrace()
            goto L4e
        L4a:
            r8 = move-exception
            r8.printStackTrace()
        L4e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imageutils.d.f(byte[], int):int[]");
    }

    public static int[] g(InputStream r3) {
        int r0 = r3.available();
        byte[] r1 = new byte[r0];
        r3.reset();
        if (r3.read(r1, 0, r0) != (-1)) goto L5;
        return null;
    L5:
        return e(r1, r0);
    }

    public static int[] h(InputStream r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        int r1 = r4.available();
        byte[] r2 = new byte[r1];
        r4.reset();
        if (r4.read(r2, 0, r1) != (-1)) goto L8;
        return null;
    L8:
        return f(r2, r1);
    }
}
