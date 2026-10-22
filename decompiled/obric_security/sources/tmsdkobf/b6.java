package tmsdkobf;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.zip.InflaterInputStream;
import tmsdk.common.ErrorCode;
import tmsdk.common.exception.NetWorkException;
import tmsdk.common.exception.NetworkOnMainThreadException;

/* JADX INFO: loaded from: classes5.dex */
public class b6 extends a6 {
    private Context b;
    private String c;
    private String d;
    private String e;
    private String f;
    private int g;
    private boolean h;
    private long i;
    private long j;
    private boolean k;

    public interface a {
        boolean a(String r1);
    }

    public b6(Context r5) {
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = 0;
        this.h = false;
        this.i = 0;
        this.j = 0;
        this.k = false;
        if (k9.a() == false) goto L5;
    L9:
        this.b = r5;
        this.c = r5.getCacheDir().getAbsolutePath();
        this.d = r5.getFilesDir().getAbsolutePath();
        return;
    L5:
        if (Thread.currentThread().getId() != Looper.getMainLooper().getThread().getId()) goto L9;
        throw new NetworkOnMainThreadException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v17, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v8, types: [java.io.FileInputStream] */
    private int a(boolean r13) {
        StringBuilder r3 = new StringBuilder().append(this.c);
        String r4 = File.separator;
        q8.c("HttpGetFile", r3.append(r4).append(this.e).toString());
        q8.c("HttpGetFile", this.d + r4 + this.f);
        int r5 = -7001;
        int r6 = ErrorCode.ERR_FILE_OP;
        ?? r7 = 0;
        ?? r8 = 0;
        File r9 = new File(this.c, this.e);     // Catch: Throwable -> L68 Exception -> L70 IOException -> L74 FileNotFoundException -> L78
    L116:
    L65:
        e = e;
        FileOutputStream r10 = null;
    L67:
        FileNotFoundException e = e;
    L80:
        q8.b("HttpBase", "file not found");     // Catch: Throwable -> L82
        e.printStackTrace();     // Catch: Throwable -> L82
        throw new NetWorkException(-7001, e.getMessage());     // Catch: Throwable -> L82
    L62:
        e = e;
        FileOutputStream r11 = null;
    L64:
        IOException e2 = e;
    L76:
        q8.b("HttpBase", "file io error");     // Catch: Throwable -> L82
        e2.printStackTrace();     // Catch: Throwable -> L82
        throw new NetWorkException(-7056, e2.getMessage());     // Catch: Throwable -> L82
    L59:
        e = e;
        FileOutputStream r12 = null;
    L61:
        Exception e3 = e;
    L72:
        q8.b("HttpBase", "file op error");     // Catch: Throwable -> L82
        e3.printStackTrace();     // Catch: Throwable -> L82
        throw new NetWorkException(ErrorCode.ERR_FILE_OP, e3.getMessage());     // Catch: Throwable -> L82
    L56:
        th = th;
        FileOutputStream r14 = null;
    L58:
        FileOutputStream r15 = r14;
        Throwable th = th;
        FileOutputStream r16 = r15;
    L86:
        if (r7 != 0) goto L106;
    L91:
        if (r16 != null) goto L104;
    L96:
        if (r13 == false) goto L119;
        if (r9 != null) goto L99;
        throw th;
    L99:
        if (r9.exists() == false) goto L121;
        r9.delete();
        throw th;
    L121:
        throw th;
    L119:
        throw th;
    L104:
        r16.close();     // Catch: IOException -> L94
    L94:
        e = move-exception;
        q8.b("HttpBase", "fosclose file error");
        e.printStackTrace();
        goto L96
    L106:
        r7.close();     // Catch: IOException -> L89
    L89:
        e = move-exception;
        q8.b("HttpBase", "fis close file error");
        e.printStackTrace();
        goto L91
    L5:
        if (r9.exists() == true) goto L7;
        r16 = null;
    L40:
        if (r8 != 0) goto L102;
    L45:
        if (r16 != null) goto L108;
    L50:
        r6 = r5;
    L51:
        if (r13 == true) goto L53;
    L55:
        return r6;
    L53:
        if (r9.exists() == false) goto L55;
        r9.delete();
        goto L55
    L108:
        r16.close();     // Catch: IOException -> L48
    L48:
        e = move-exception;
        q8.b("HttpBase", "fosclose file error");
        e.printStackTrace();
        goto L51
    L102:
        r8.close();     // Catch: IOException -> L43
    L43:
        e = move-exception;
        q8.b("HttpBase", "fis close file error");
        e.printStackTrace();
        r5 = -7000;
        goto L45
    L7:
        if (this.g == 1) goto L9;
    L11:
        File r17 = new File(this.d + r4 + this.f);     // Catch: Throwable -> L56 Exception -> L59 IOException -> L62 FileNotFoundException -> L65
        if (r17.exists() == false) goto L14;
        r17.delete();     // Catch: Throwable -> L56 Exception -> L59 IOException -> L62 FileNotFoundException -> L65
        r16 = new FileOutputStream(r17);     // Catch: Throwable -> L56 Exception -> L59 IOException -> L62 FileNotFoundException -> L65
    L114:
        ?? r18 = new FileInputStream(r9);     // Catch: Throwable -> L31 Exception -> L33 IOException -> L35 FileNotFoundException -> L37
    L111:
        byte[] r19 = new byte[1024];     // Catch: Throwable -> L23 Exception -> L25 IOException -> L27 FileNotFoundException -> L29
    L18:
        int r20 = r18.read(r19);     // Catch: Throwable -> L23 Exception -> L25 IOException -> L27 FileNotFoundException -> L29
        if (r20 == (-1)) goto L22;
        r16.write(r19, 0, r20);     // Catch: Throwable -> L23 Exception -> L25 IOException -> L27 FileNotFoundException -> L29
    L22:
        r8 = r18;
        r5 = 0;
    L29:
        e = e;
    L27:
        e2 = e;
    L25:
        e3 = e;
    L23:
        th = th;
    L85:
        r7 = r18;
    L37:
        e = move-exception;
        r10 = r16;
        e = e;
    L35:
        e = move-exception;
        r11 = r16;
        e = e;
    L33:
        e = move-exception;
        r12 = r16;
        e = e;
    L31:
        th = move-exception;
        r14 = r16;
        th = th;
        goto L58
    L14:
        r17.getParentFile().mkdirs();     // Catch: Throwable -> L56 Exception -> L59 IOException -> L62 FileNotFoundException -> L65
        r17.createNewFile();     // Catch: Throwable -> L56 Exception -> L59 IOException -> L62 FileNotFoundException -> L65
        r16 = new FileOutputStream(r17);     // Catch: Throwable -> L56 Exception -> L59 IOException -> L62 FileNotFoundException -> L65
        goto L114
    L9:
        if (this.b.getFilesDir().getAbsolutePath().equals(this.d) == false) goto L11;
        r16 = this.b.openFileOutput(this.f, this.g);     // Catch: Throwable -> L56 Exception -> L59 IOException -> L62 FileNotFoundException -> L65
    L82:
        th = move-exception;
        th = th;
        r18 = r4;
    L84:
        r16 = null;
    L78:
        e = move-exception;
        e = e;
    L74:
        e = move-exception;
        e2 = e;
    L70:
        e = move-exception;
        e3 = e;
    L68:
        th = move-exception;
        th = th;
        r18 = 0;
        r9 = null;
        goto L84
    }

    public void b(String r1) {
        this.d = r1;
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 9241. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    public int a(java.lang.String r24, java.lang.String r25, boolean r26, tmsdkobf.b6.a r27) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: MOVE (r2v0 ?? I:??[OBJECT, ARRAY]) = (r27v0 tmsdkobf.b6$a) A[DECLARE_VAR] in method: tmsdkobf.b6.a(java.lang.String, java.lang.String, boolean, tmsdkobf.b6$a):int, file: classes5.dex
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
            Method dump skipped, instruction units count: 924
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: tmsdkobf.b6.a(java.lang.String, java.lang.String, boolean, tmsdkobf.b6$a):int");
    }

    public void a(String r1) {
        this.f = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r8v38 */
    /* JADX WARN: Type inference failed for: r8v39 */
    private int a(HttpURLConnection r18, Bundle r19, boolean r20) {
        Bundle r1 = r19;
        String r2 = "fos close file error";
        String r3 = "is close file error";
        byte[] r7 = new byte[8192];
        InputStream r8 = null;
        r8 = null;
        r8 = null;
        r8 = null;
        r8 = null;
        r8 = null;
        long r9 = r18.getContentLength();     // Catch: Throwable -> L80 Exception -> L82 IOException -> L86 SocketTimeoutException -> L90 SocketException -> L94 FileNotFoundException -> L98
        long r11 = this.i;     // Catch: Throwable -> L80 Exception -> L82 IOException -> L86 SocketTimeoutException -> L90 SocketException -> L94 FileNotFoundException -> L98
        long r10 = r9 + r11;     // Catch: Throwable -> L80 Exception -> L82 IOException -> L86 SocketTimeoutException -> L90 SocketException -> L94 FileNotFoundException -> L98
        this.j = r10;     // Catch: Throwable -> L80 Exception -> L82 IOException -> L86 SocketTimeoutException -> L90 SocketException -> L94 FileNotFoundException -> L98
        int r12 = (int) ((r11 * 100) / r10);     // Catch: Throwable -> L80 Exception -> L82 IOException -> L86 SocketTimeoutException -> L90 SocketException -> L94 FileNotFoundException -> L98
        File r13 = new File(this.c, this.e);     // Catch: Throwable -> L80 Exception -> L82 IOException -> L86 SocketTimeoutException -> L90 SocketException -> L94 FileNotFoundException -> L98
        if (r13.exists() == false) goto L124;
    L9:
        FileOutputStream r14 = new FileOutputStream(r13, true);     // Catch: Throwable -> L80 Exception -> L82 IOException -> L86 SocketTimeoutException -> L90 SocketException -> L94 FileNotFoundException -> L98
    L134:
        if (r20 == false) goto L12;
        r8 = new InflaterInputStream(r18.getInputStream());     // Catch: Throwable -> L63 Exception -> L65 IOException -> L68 SocketTimeoutException -> L71 SocketException -> L74 FileNotFoundException -> L77
    L13:
        int r15 = 0;
    L14:
        int r16 = r8.read(r7);     // Catch: Throwable -> L63 Exception -> L65 IOException -> L68 SocketTimeoutException -> L71 SocketException -> L74 FileNotFoundException -> L77
        if (r16 == (-1)) goto L36;
        if (this.h == true) goto L18;
        String r17 = r2;
        r3 = r3;
        long r110 = this.i + ((long) r16);
        this.i = r110;     // Catch: Throwable -> L51 Exception -> L53 IOException -> L55 SocketTimeoutException -> L57 SocketException -> L59 FileNotFoundException -> L61
        r15 = r15 + r16;     // Catch: Throwable -> L51 Exception -> L53 IOException -> L55 SocketTimeoutException -> L57 SocketException -> L59 FileNotFoundException -> L61
        int r4 = (int) ((r110 * 100) / this.j);     // Catch: Throwable -> L51 Exception -> L53 IOException -> L55 SocketTimeoutException -> L57 SocketException -> L59 FileNotFoundException -> L61
        if (r4 == r12) goto L35;
        r1.putInt("key_progress", r4);     // Catch: Throwable -> L51 Exception -> L53 IOException -> L55 SocketTimeoutException -> L57 SocketException -> L59 FileNotFoundException -> L61
        a(2, r1);     // Catch: Throwable -> L51 Exception -> L53 IOException -> L55 SocketTimeoutException -> L57 SocketException -> L59 FileNotFoundException -> L61
        r12 = r4;
    L35:
        r14.write(r7, 0, r16);     // Catch: Throwable -> L51 Exception -> L53 IOException -> L55 SocketTimeoutException -> L57 SocketException -> L59 FileNotFoundException -> L61
        r3 = r3;
        r2 = r17;
    L61:
        e = e;
        InputStream r21 = r8;
    L100:
        q8.b("HttpBase", "file not found");     // Catch: Throwable -> L102
        e.printStackTrace();     // Catch: Throwable -> L102
        throw new NetWorkException(-7001, e.getMessage());     // Catch: Throwable -> L102
    L59:
        e = e;
        InputStream r22 = r8;
    L96:
        q8.b("HttpBase", "socket error:" + e.getMessage());     // Catch: Throwable -> L102
        e.printStackTrace();     // Catch: Throwable -> L102
        throw new NetWorkException(-5054, e.getMessage());     // Catch: Throwable -> L102
    L57:
        e = e;
        InputStream r23 = r8;
    L92:
        q8.b("HttpBase", "socket timeout error:" + e.getMessage());     // Catch: Throwable -> L102
        e.printStackTrace();     // Catch: Throwable -> L102
        throw new NetWorkException(-5055, e.getMessage());     // Catch: Throwable -> L102
    L55:
        e = e;
        InputStream r24 = r8;
    L88:
        q8.b("HttpBase", "socket or file io error");     // Catch: Throwable -> L102
        e.printStackTrace();     // Catch: Throwable -> L102
        throw new NetWorkException(-5056, e.getMessage());     // Catch: Throwable -> L102
    L53:
        e = e;
        InputStream r25 = r8;
    L84:
        q8.b("HttpBase", e.toString());     // Catch: Throwable -> L102
        q8.b("HttpBase", "receive data error");     // Catch: Throwable -> L102
        e.printStackTrace();     // Catch: Throwable -> L102
        throw new NetWorkException(ErrorCode.ERR_RECEIVE, e.getMessage());     // Catch: Throwable -> L102
    L51:
        th = th;
        r3 = r17;
        ?? r26 = r8;
    L104:
        Throwable r5 = th;
        if (r26 == 0) goto L111;
        q8.c("HttpBase", "is closing file");
        r26.close();     // Catch: IOException -> L109
    L109:
        e = move-exception;
        q8.b("HttpBase", r3);
        e.printStackTrace();
    L111:
        if (r14 == null) goto L143;
        q8.c("HttpBase", "fos closing file");
        r14.close();     // Catch: IOException -> L115
        throw r5;
    L115:
        e = move-exception;
        q8.b("HttpBase", r3);
        e.printStackTrace();
        throw r5;
    L143:
        throw r5;
    L18:
        q8.c("HttpBase", "is closing file");
        r8.close();     // Catch: IOException -> L21
    L23:
        q8.c("HttpBase", "fos closing file");
        r14.close();     // Catch: IOException -> L26
        return -5003;
    L26:
        e = move-exception;
        q8.b("HttpBase", r2);
        e.printStackTrace();
        return -5003;
    L21:
        e = move-exception;
        q8.b("HttpBase", r3);
        e.printStackTrace();
        goto L23
    L36:
        r17 = r2;
        r3 = r3;
        r14.flush();     // Catch: Throwable -> L51 Exception -> L53 IOException -> L55 SocketTimeoutException -> L57 SocketException -> L59 FileNotFoundException -> L61
        q8.c("HttpBase", "mTotalSize: " + this.j + ", mCompletedSize: " + this.i + ", httpConn.getContentLength(): " + r18.getContentLength());     // Catch: Throwable -> L51 Exception -> L53 IOException -> L55 SocketTimeoutException -> L57 SocketException -> L59 FileNotFoundException -> L61
        if (r15 != r18.getContentLength()) goto L39;
        int r0 = 0;
    L40:
        q8.c("HttpBase", "is closing file");
        r8.close();     // Catch: IOException -> L43
    L45:
        q8.c("HttpBase", "fos closing file");
        r14.close();     // Catch: IOException -> L48
        return r0;
    L48:
        e = move-exception;
        q8.b("HttpBase", r17);
        e.printStackTrace();
        return ErrorCode.ERR_FILE_OP;
    L43:
        e = move-exception;
        q8.b("HttpBase", r3);
        e.printStackTrace();
        r0 = -7000;
        goto L45
    L39:
        r0 = -7;
        goto L40
    L12:
        r8 = r18.getInputStream();     // Catch: Throwable -> L63 Exception -> L65 IOException -> L68 SocketTimeoutException -> L71 SocketException -> L74 FileNotFoundException -> L77
    L77:
        e = e;
        r21 = r8;
    L74:
        e = e;
        r22 = r8;
    L71:
        e = e;
        r23 = r8;
    L68:
        e = e;
        r24 = r8;
    L65:
        e = e;
        r25 = r8;
    L63:
        th = th;
        r3 = r3;
        r3 = r2;
        r26 = r8;
        goto L104
    L124:
        r13.getParentFile().mkdirs();     // Catch: Throwable -> L7 Exception -> L82 IOException -> L86 SocketTimeoutException -> L90 SocketException -> L94 FileNotFoundException -> L98
        r13.createNewFile();     // Catch: Throwable -> L7 Exception -> L82 IOException -> L86 SocketTimeoutException -> L90 SocketException -> L94 FileNotFoundException -> L98
    L7:
        th = th;
        r1 = null;
        r3 = "fos close file error";
    L103:
        r14 = null;
        r26 = r1;
    L102:
        th = th;
    L80:
        th = th;
        r3 = "fos close file error";
        r1 = null;
    L98:
        e = e;
    L94:
        e = e;
    L90:
        e = e;
    L86:
        e = e;
    L82:
        e = e;
        goto L84
    }
}
