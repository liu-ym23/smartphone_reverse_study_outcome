package com.obric.oui.picker.reels.views;

import a.a;
import android.widget.OverScroller;
import com.obric.oui.utils.log.L;
import java.lang.reflect.Method;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class ScrollerExt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Class f258a;
    public static Method b;
    public static Method c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f259d;

    public static int a(WheelScroller r7, int r8) {
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
            java.lang.String r0 = "ScrollerExt"
            r1 = 0
            r2 = 0
            java.lang.reflect.Method r3 = com.obric.oui.picker.reels.views.ScrollerExt.c     // Catch: java.lang.Exception -> L19
            if (r3 != 0) goto L1b
            java.lang.Class<android.widget.OverScroller> r3 = android.widget.OverScroller.class
            java.lang.String r4 = "disableDynamicScroll"
            java.lang.reflect.Method r3 = r3.getDeclaredMethod(r4, r2)     // Catch: java.lang.Exception -> L19
            com.obric.oui.picker.reels.views.ScrollerExt.c = r3     // Catch: java.lang.Exception -> L19
            if (r3 == 0) goto L1b
            r4 = 1
            r3.setAccessible(r4)     // Catch: java.lang.Exception -> L19
            goto L1b
        L19:
            r3 = move-exception
            goto L23
        L1b:
            java.lang.reflect.Method r3 = com.obric.oui.picker.reels.views.ScrollerExt.c     // Catch: java.lang.Exception -> L19
            if (r3 == 0) goto L2c
            r3.invoke(r7, r2)     // Catch: java.lang.Exception -> L19
            goto L2c
        L23:
            java.lang.String r4 = "disableDynamicScroll, failed"
            r5 = 8
            r6 = 16
            com.obric.oui.utils.log.L.e(r0, r5, r4, r3, r6)     // Catch: java.lang.Exception -> L3d
        L2c:
            java.lang.reflect.Method r3 = com.obric.oui.picker.reels.views.ScrollerExt.b     // Catch: java.lang.Exception -> L3d
            if (r3 == 0) goto L3f
            java.lang.Integer r2 = java.lang.Integer.valueOf(r8)     // Catch: java.lang.Exception -> L3d
            java.lang.Object[] r2 = new java.lang.Object[]{r2}     // Catch: java.lang.Exception -> L3d
            java.lang.Object r2 = r3.invoke(r7, r2)     // Catch: java.lang.Exception -> L3d
            goto L3f
        L3d:
            r7 = move-exception
            goto L50
        L3f:
            if (r2 == 0) goto L48
            java.lang.Double r2 = (java.lang.Double) r2     // Catch: java.lang.Exception -> L3d
            double r2 = r2.doubleValue()     // Catch: java.lang.Exception -> L3d
            goto L6a
        L48:
            java.lang.NullPointerException r7 = new java.lang.NullPointerException     // Catch: java.lang.Exception -> L3d
            java.lang.String r2 = "null cannot be cast to non-null type kotlin.Double"
            r7.<init>(r2)     // Catch: java.lang.Exception -> L3d
            throw r7     // Catch: java.lang.Exception -> L3d
        L50:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "reflectGetSplineFlingDistance, velocity: "
            r2.<init>(r3)
            r2.append(r8)
            java.lang.String r3 = ", error"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.obric.oui.utils.log.L.c(r0, r2, r7)
            com.obric.oui.picker.reels.views.ScrollerExt.f259d = r1
            r2 = 0
        L6a:
            if (r8 != 0) goto L71
            java.lang.Integer r7 = java.lang.Integer.valueOf(r1)
            goto L7d
        L71:
            if (r8 <= 0) goto L78
            java.lang.Double r7 = java.lang.Double.valueOf(r2)
            goto L7d
        L78:
            double r7 = -r2
            java.lang.Double r7 = java.lang.Double.valueOf(r7)
        L7d:
            int r7 = r7.intValue()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.obric.oui.picker.reels.views.ScrollerExt.a(com.obric.oui.picker.reels.views.WheelScroller, int):int");
    }

    public static void b(WheelScroller r17, int r18, int r19, int r20, int r21, int r22) {
        WheelScroller r0 = r17;
        if (f259d == true) goto L5;
        L.b("ScrollerExt", "calculateSnapVelocity, reflect failed, use original velocityY: " + r20);
        int r4 = r20;
    L47:
        r17.fling(0, r19, 0, r4, 0, 0, r21, r22, 0, 0);
        return;
    L5:
        if (r20 == 0) goto L45;
        float r5 = r19;
        float r6 = r18;
        float r7 = a(r0, r20) + r5;
        double r8 = r7 / r6;
        float r9 = ((float) Math.floor(r8)) * r6;
        float r10 = ((float) Math.ceil(r8)) * r6;
        if (Math.abs(r7 - r9) < Math.abs(r10 - r7)) goto L10;
        r9 = r10;
    L10:
        if (r20 <= 0) goto L12;
        byte r11 = 1;
    L13:
        if (r20 <= 0) goto L15;
        int r12 = 40000;
        int r13 = 0;
    L16:
        float r14 = Float.MAX_VALUE;
        int r15 = r20;
        int r16 = 0;
    L18:
        if (r16 >= 20) goto L46;
        int r110 = (r13 + r12) / 2;
        float r111 = a(r0, r110) + r5;
        float r112 = r111 - r9;
        if (Math.abs(r112) >= r14) goto L22;
        r14 = Math.abs(r112);
        r15 = r110;
    L22:
        StringBuilder r1 = a.r("calculateSnapVelocity, iteration: ", r16, ", mid: ", r110, ", low: ");
        r1.append(r13);
        r1.append(", high: ");
        r1.append(r12);
        r1.append(", diff: ");
        r1.append(r112);
        r1.append(", dist: ");
        r1.append(r111);
        r1.append(", targetDistance: ");
        r1.append(r9);
        r1.append(", bestDiff: ");
        r1.append(r14);
        r1.append(", bestVelocity: ");
        r1.append(r15);
        r1.append(", velocityY: ");
        r1.append(r20);
        r1.append(", currentOffset: ");
        r1.append(r5);
        L.f("ScrollerExt", r1.toString());
        if (r11 <= 0) goto L29;
        int r2 = 0;
        if (r112 >= 0) goto L27;
    L34:
        if (r11 <= 0) goto L40;
        if (r112 <= r2) goto L38;
    L37:
        r12 = r110 - 1;
    L42:
        if (r13 > r12) goto L46;
        r16 = r16 + 1;
        r0 = r17;
    L38:
        r13 = r110 + 1;
        goto L42
    L40:
        if (r112 >= r2) goto L37;
    L27:
        if (Math.abs(r112) > 0.3f) goto L34;
    L29:
        r2 = 0;
        if (r112 > 0) goto L34;
        if (Math.abs(r112) > 0.3f) goto L34;
    L46:
        r4 = r15;
        goto L47
    L15:
        r13 = -40000;
        r12 = 0;
        goto L16
    L12:
        r11 = -1;
        goto L13
    L45:
        r15 = r20;
        goto L46
    }
}
