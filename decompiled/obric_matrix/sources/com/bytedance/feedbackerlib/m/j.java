package com.bytedance.feedbackerlib.m;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.feedbackerlib.Feedbacker;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static MediaPlayer f4292a;

    static {
        f4292a = new MediaPlayer();
    }

    private static ContentValues a(@NonNull File r3, long r4) {
        ContentValues r0 = new ContentValues();
        r0.put("title", r3.getName());
        r0.put("_display_name", r3.getName());
        r0.put("date_modified", Long.valueOf(r4));
        r0.put("date_added", Long.valueOf(r4));
        r0.put("_size", Long.valueOf(r3.length()));
        return r0;
    }

    public static String b(@NonNull Uri r8) {
        ContentResolver r1 = Feedbacker.getApplicationContext().getContentResolver();
        if (r1 != null) goto L5;
        return null;
    L5:
        Cursor r9 = r1.query(r8, new String[]{"_data"}, null, null, null);
        if (r9 != null) goto L9;
        return null;
    L9:
        if (r9.moveToFirst() == true) goto L12;
        r9.close();
        return null;
    L12:
        String r0 = r9.getString(r9.getColumnIndex("_data"));
        r9.close();
        return r0;
    }

    public static long c(String r3) {
        MediaPlayer r0 = new MediaPlayer();
        r0.reset();     // Catch: Throwable -> L17
    L21:
        r0.setDataSource(r3);     // Catch: Throwable -> L8 IOException -> L10
        r0.prepare();     // Catch: Throwable -> L8 IOException -> L10
        long r1 = r0.getDuration();     // Catch: Throwable -> L8 IOException -> L10
        r0.reset();     // Catch: Throwable -> L18
    L7:
        return r1;
    L10:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L8
        r0.reset();     // Catch: Throwable -> L20
    L14:
        return -1;
    L8:
        th = move-exception;
        r0.reset();     // Catch: Throwable -> L19
    L16:
        throw th;
    }

    public static synchronized long d(Context r4, Uri r5) {
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
            java.lang.Class<com.bytedance.feedbackerlib.m.j> r0 = com.bytedance.feedbackerlib.m.j.class
            monitor-enter(r0)
            r1 = -1
            if (r4 == 0) goto L41
            boolean r3 = i(r5)     // Catch: java.lang.Throwable -> L3e
            if (r3 != 0) goto Le
            goto L41
        Le:
            android.media.MediaPlayer r3 = com.bytedance.feedbackerlib.m.j.f4292a     // Catch: java.lang.Throwable -> L13
            r3.reset()     // Catch: java.lang.Throwable -> L13
        L13:
            android.media.MediaPlayer r3 = com.bytedance.feedbackerlib.m.j.f4292a     // Catch: java.lang.Throwable -> L2b java.io.IOException -> L2d
            r3.setDataSource(r4, r5)     // Catch: java.lang.Throwable -> L2b java.io.IOException -> L2d
            android.media.MediaPlayer r4 = com.bytedance.feedbackerlib.m.j.f4292a     // Catch: java.lang.Throwable -> L2b java.io.IOException -> L2d
            r4.prepare()     // Catch: java.lang.Throwable -> L2b java.io.IOException -> L2d
            android.media.MediaPlayer r4 = com.bytedance.feedbackerlib.m.j.f4292a     // Catch: java.lang.Throwable -> L2b java.io.IOException -> L2d
            int r4 = r4.getDuration()     // Catch: java.lang.Throwable -> L2b java.io.IOException -> L2d
            long r4 = (long) r4
            android.media.MediaPlayer r1 = com.bytedance.feedbackerlib.m.j.f4292a     // Catch: java.lang.Throwable -> L29
            r1.reset()     // Catch: java.lang.Throwable -> L29
        L29:
            monitor-exit(r0)
            return r4
        L2b:
            r4 = move-exception
            goto L38
        L2d:
            r4 = move-exception
            r4.printStackTrace()     // Catch: java.lang.Throwable -> L2b
            android.media.MediaPlayer r4 = com.bytedance.feedbackerlib.m.j.f4292a     // Catch: java.lang.Throwable -> L36
            r4.reset()     // Catch: java.lang.Throwable -> L36
        L36:
            monitor-exit(r0)
            return r1
        L38:
            android.media.MediaPlayer r5 = com.bytedance.feedbackerlib.m.j.f4292a     // Catch: java.lang.Throwable -> L3d
            r5.reset()     // Catch: java.lang.Throwable -> L3d
        L3d:
            throw r4     // Catch: java.lang.Throwable -> L3e
        L3e:
            r4 = move-exception
            monitor-exit(r0)
            throw r4
        L41:
            monitor-exit(r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.feedbackerlib.m.j.d(android.content.Context, android.net.Uri):long");
    }

    @RequiresApi(api = 16)
    public static Uri e(@NonNull Context r6, @NonNull File r7, long r8, int r10, int r11) {
        if (r7.exists() == true) goto L5;
        return null;
    L5:
        ContentValues r2 = a(r7, r8);
        r2.put("width", Integer.valueOf(r10));
        r2.put("height", Integer.valueOf(r11));
        r2.put("mime_type", "image/jpeg");
        if (Build.VERSION.SDK_INT < 29) goto L8;
        r2.put("datetaken", Long.valueOf(r8));
        r2.put("orientation", 0);
        r2.put("relative_path", "Pictures/");
    L8:
        ContentResolver r9 = r6.getContentResolver();
        Uri r12 = r9.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, r2);
        if (r12 != null) goto L55;
        return null;
    L55:
        OutputStream r13 = r9.openOutputStream(r12);     // Catch: Throwable -> L38 IOException -> L40
        if (r13 != null) goto L18;
        r9.delete(r12, null, null);     // Catch: Throwable -> L38 IOException -> L40
        c.a("MediaUtils", "insertImageToMediaStore failed: contentResolver.openOutputStream failed", null);     // Catch: Throwable -> L38 IOException -> L40
        s.a(null);
        s.a(null);
        if (r7.delete() == true) goto L17;
        c.a("MediaUtils", "delete image file failed", null);
    L17:
        return null;
    L18:
        BufferedOutputStream r14 = new BufferedOutputStream(r13);     // Catch: Throwable -> L38 IOException -> L40
        BufferedInputStream r15 = new BufferedInputStream(new FileInputStream(r7));     // Catch: Throwable -> L34 IOException -> L36
    L56:
        byte[] r16 = new byte[8192];     // Catch: Throwable -> L30 IOException -> L32
    L22:
        int r3 = r15.read(r16);     // Catch: Throwable -> L30 IOException -> L32
        if (r3 <= 0) goto L25;
        r14.write(r16, 0, r3);     // Catch: Throwable -> L30 IOException -> L32
        goto L22
    L25:
        r14.flush();     // Catch: Throwable -> L30 IOException -> L32
        s.a(r15);
        s.a(r14);
        if (r7.delete() == true) goto L29;
        c.a("MediaUtils", "delete image file failed", null);
    L29:
        return r12;
    L32:
        e = move-exception;
        BufferedInputStream r17 = r15;
        e = e;
        BufferedOutputStream r18 = r14;
    L53:
        r9.delete(r12, null, null);     // Catch: Throwable -> L47
        c.a("MediaUtils", "insertImageToMediaStore failed", e);     // Catch: Throwable -> L47
        s.a(r17);
        s.a(r18);
        if (r7.delete() == true) goto L46;
        c.a("MediaUtils", "delete image file failed", null);
    L46:
        return null;
    L47:
        th = th;
        r15 = r17;
        r14 = r18;
    L49:
        s.a(r15);
        s.a(r14);
        if (r7.delete() == true) goto L52;
        c.a("MediaUtils", "delete image file failed", null);
    L52:
        throw th;
    L30:
        th = th;
    L36:
        e = e;
        r18 = r14;
        r17 = null;
    L34:
        th = th;
        r15 = null;
    L40:
        e = e;
        r17 = null;
        r18 = null;
    L38:
        th = th;
        r15 = null;
        r14 = null;
        goto L49
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [long] */
    /* JADX WARN: Type inference failed for: r10v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r9v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v5, types: [java.io.BufferedInputStream, java.io.Closeable] */
    @RequiresApi(api = 16)
    public static Uri f(@NonNull Context r4, @NonNull File r5, long r6, int r8, int r9, long r10) {
        ?? r1 = 0;
        if (r5.exists() == true) goto L5;
        return null;
    L5:
        ContentValues r0 = a(r5, r6);
        r0.put("mime_type", "video/mp4");
        if (r8 <= 0) goto L8;
        r0.put("width", Integer.valueOf(r8));
    L8:
        if (r9 <= 0) goto L10;
        r0.put("height", Integer.valueOf(r9));
    L10:
        Long r11 = Long.valueOf(r10);
        ?? r12 = TypedValues.TransitionType.S_DURATION;
        r0.put(TypedValues.TransitionType.S_DURATION, r11);
        r0.put("datetaken", Long.valueOf(r6));
        if (Build.VERSION.SDK_INT < 29) goto L13;
        r0.put("datetaken", Long.valueOf(r6));
        r0.put(TypedValues.TransitionType.S_DURATION, Long.valueOf(r10));
        r0.put("relative_path", null);
    L13:
        ContentResolver r7 = r4.getContentResolver();
        Uri r13 = r7.insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, r0);
        if (r13 != null) goto L56;
        c.a("MediaUtils", "insert video failed: contentResolver.insert failed", null);
        return null;
    L56:
        OutputStream r14 = r7.openOutputStream(r13);     // Catch: Throwable -> L40 IOException -> L42
        if (r14 != null) goto L22;
        r7.delete(r13, null, null);     // Catch: Throwable -> L40 IOException -> L42
        c.a("MediaUtils", "contentResolver.openOutputStream return null", null);     // Catch: Throwable -> L40 IOException -> L42
        s.a(null);
        s.a(null);
        return null;
    L22:
        r12 = new BufferedInputStream(new FileInputStream(r5));     // Catch: Throwable -> L40 IOException -> L42
        BufferedOutputStream r15 = new BufferedOutputStream(r14);     // Catch: Throwable -> L36 IOException -> L38
    L52:
        byte[] r16 = new byte[8192];     // Catch: IOException -> L34 Throwable -> L47
    L26:
        int r17 = r12.read(r16);     // Catch: IOException -> L34 Throwable -> L47
        if (r17 <= 0) goto L29;
        r15.write(r16, 0, r17);     // Catch: IOException -> L34 Throwable -> L47
        goto L26
    L29:
        r15.flush();     // Catch: IOException -> L34 Throwable -> L47
        if (r5.delete() == true) goto L32;
        c.a("MediaUtils", "video file delete failed!", null);     // Catch: IOException -> L34 Throwable -> L47
    L32:
        s.a(r12);
        s.a(r15);
        return r13;
    L34:
        e = e;
    L44:
        r7.delete(r13, null, null);     // Catch: Throwable -> L47
        c.a("MediaUtils", "insertVideoToMediaStore failed.", e);     // Catch: Throwable -> L47
        Uri r18 = g(r7, r0, r5);     // Catch: Throwable -> L47
        s.a(r12);
        s.a(r15);
        return r18;
    L38:
        e = e;
        r15 = null;
    L36:
        th = th;
        r10 = 0;
    L48:
        r1 = r12;
        ?? r19 = r10;
    L49:
        s.a(r1);
        s.a(r19);
        throw th;
    L42:
        e = e;
        r12 = 0;
        r15 = null;
    L40:
        th = th;
        r19 = 0;
    L47:
        th = th;
        goto L48
    }

    private static Uri g(@NonNull ContentResolver r3, @NonNull ContentValues r4, @NonNull File r5) {
        if (Build.VERSION.SDK_INT < 29) goto L5;
        return null;
    L5:
        r4.put("_data", r5.getPath());
        return r3.insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, r4);
    L8:
        th = move-exception;
        c.a("MediaUtils", "insertVideoToMediaStoreCompat failed", th);
        return null;
    }

    public static boolean h(Uri r1) {
        if (r1 != null) goto L6;
        return false;
    L6:
        return r1.toString().startsWith(MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString());
    }

    public static boolean i(Uri r1) {
        if (r1 != null) goto L6;
        return false;
    L6:
        return r1.toString().startsWith(MediaStore.Video.Media.EXTERNAL_CONTENT_URI.toString());
    }
}
