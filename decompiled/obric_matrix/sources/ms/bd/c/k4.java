package ms.bd.c;

import android.content.Context;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: classes2.dex */
public class k4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f22413a = null;

    static {
        String r0 = (String) m.a(16777217, 0, 0, "9b7fe0", new byte[]{19, 60, 5, 76, 103});
        f22413a = (String) m.a(16777217, 0, 0, "0a8a55", new byte[]{44, 102, 69, 17});
    }

    public static synchronized String a(Context r26) {
        monitor-enter(k4.class);
        StringBuilder r4 = new StringBuilder();     // Catch: Throwable -> L32
        r4.append(r26.getFilesDir().getAbsolutePath());     // Catch: Throwable -> L32
        r4.append((String) m.a(16777217, 0, 0, "5fcb17", new byte[]{107}));     // Catch: Throwable -> L32
        String r5 = f22413a;     // Catch: Throwable -> L32
        r4.append(r5);     // Catch: Throwable -> L32
        String r6 = r4.toString();     // Catch: Throwable -> L32
        if (new File(r6).exists() == false) goto L16;
        String r2 = c(r6);     // Catch: Throwable -> L32
        if (r2 == null) goto L16;
        if (r2.length() <= 0) goto L16;
        monitor-exit(k4.class);
        return r2;
    L16:
        InputStream r3 = r26.getResources().getAssets().open(r5);     // Catch: Throwable -> L32
        ByteArrayOutputStream r7 = new ByteArrayOutputStream();     // Catch: Throwable -> L32
        byte[] r15 = new byte[4096];     // Catch: Throwable -> L32
    L17:
        int r9 = r3.read(r15, 0, 4096);     // Catch: Throwable -> L32
        if (r9 == (-1)) goto L20;
        r7.write(r15, 0, r9);     // Catch: Throwable -> L32
        goto L17
    L20:
        FileOutputStream r8 = new FileOutputStream(r6);     // Catch: Throwable -> L32
        r8.write(r7.toByteArray());     // Catch: Throwable -> L32
        r8.close();     // Catch: Throwable -> L32
        StringBuilder r10 = new StringBuilder();     // Catch: Throwable -> L32
        r10.append((String) m.a(16777217, 0, 0, "de7156", new byte[]{118, 111, 73, 74, 14, 97, 48, 19, 49, 33}));     // Catch: Throwable -> L32
        r10.append(r6);     // Catch: Throwable -> L32
        c(r10.toString());     // Catch: Throwable -> L32
        String r11 = c(r6);     // Catch: Throwable -> L32
        if (r11 == null) goto L30;
        if (r11.length() == 0) goto L30;
    L34:
        if (r11 != null) goto L36;
    L37:
        r11 = (String) m.a(16777217, 0, 0, "9b0e4d", new byte[]{120, 91, 31, 80, 85, 78, 31, 113, 83, 26, 26, 91, 31, 80, 85, 78});     // Catch: Throwable -> L40
    L38:
        monitor-exit(k4.class);
        return r11;
    L36:
        if (r11.length() != 0) goto L38;
    L30:
        RandomAccessFile r12 = new RandomAccessFile(r6, (String) m.a(16777217, 0, 0, "2afab3", new byte[]{49, 116}));     // Catch: Throwable -> L32
        r12.seek(16);     // Catch: Throwable -> L32
        r12.write(new byte[]{2});     // Catch: Throwable -> L32
        r12.close();     // Catch: Throwable -> L32
        r11 = c(r6);     // Catch: Throwable -> L32
    L40:
        th = move-exception;
        throw th;
    L33:
        r11 = (String) m.a(16777217, 0, 0, "d032e8", new byte[]{37, 9, 28, 7, 4, 18, 66, 41, 65, 71, 69, 6, 105, 105, 116, 20, 59, 80, 60, 95});     // Catch: Throwable -> L40
        goto L34
    }

    private static String b(BufferedInputStream r9) {
        byte[] r1 = new byte[4096];
        StringBuilder r2 = new StringBuilder();
    L11:
        int r3 = r9.read(r1);     // Catch: Exception -> L8
        if (r3 <= 0) goto L6;
        r2.append(new String(r1, 0, r3));     // Catch: Exception -> L8
    L6:
        if (r3 >= 4096) goto L11;
    L10:
        return r2.toString();
    L8:
        String r10 = (String) m.a(16777217, 0, 0, "8cb4e1", new byte[]{44, 104, 18});
        goto L10
    }

    private static String c(String r14) {
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
            Method dump skipped, instruction units count: 361
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ms.bd.c.k4.c(java.lang.String):java.lang.String");
    }
}
