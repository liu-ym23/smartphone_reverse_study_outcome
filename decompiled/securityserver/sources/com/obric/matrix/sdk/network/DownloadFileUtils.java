package com.obric.matrix.sdk.network;

import com.bytedance.retrofit2.mime.TypedInput;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class DownloadFileUtils {

    @NotNull
    public static final DownloadFileUtils INSTANCE = null;

    static {
        INSTANCE = new DownloadFileUtils();
    }

    private DownloadFileUtils() {
    }

    public final void writeTypedInputToDisk(@NotNull TypedInput r9, @NotNull File r10, @NotNull HttpRequestManager.DownloadCallback r11) {
        Intrinsics.f(r9, "input");
        Intrinsics.f(r10, "saveFile");
        Intrinsics.f(r11, "callback");
        File r8 = r10.getParentFile();     // Catch: Exception -> L6
        InputStream r0 = null;
        if (r8 == null) goto L8;
        Boolean r12 = Boolean.valueOf(r8.exists());     // Catch: Exception -> L6
    L9:
        Intrinsics.c(r12);     // Catch: Exception -> L6
        if (r12.booleanValue() == true) goto L83;
        File r13 = r10.getParentFile();     // Catch: Exception -> L6
        if (r13 == null) goto L83;
        r13.mkdirs();     // Catch: Exception -> L6
    L83:
        InputStream r14 = r9.in();     // Catch: Throwable -> L39 Exception -> L41
    L87:
        FileOutputStream r1 = new FileOutputStream(r10);     // Catch: Throwable -> L35 Exception -> L37
    L85:
        byte[] r2 = new byte[4096];     // Catch: Throwable -> L21 Exception -> L23
        long r3 = r9.length();     // Catch: Throwable -> L21 Exception -> L23
        long r4 = 0;
    L18:
        int r15 = r14.read(r2);     // Catch: Throwable -> L21 Exception -> L23
        if (r15 == (-1)) goto L25;
        r1.write(r2, 0, r15);     // Catch: Throwable -> L21 Exception -> L23
        r4 = r4 + ((long) r15);     // Catch: Throwable -> L21 Exception -> L23
        r11.onProgress(r4, r3);     // Catch: Throwable -> L21 Exception -> L23
        goto L18
    L25:
        r1.flush();     // Catch: Throwable -> L21 Exception -> L23
        r11.onSuccess(r10);     // Catch: Throwable -> L21 Exception -> L23
        r14.close();     // Catch: Exception -> L28
    L74:
        r1.close();     // Catch: Exception -> L32
        return;
    L32:
        e = e;
    L33:
        r11.onError(e);     // Catch: Exception -> L6
        return;
    L28:
        e = move-exception;
        r11.onError(e);     // Catch: Exception -> L6
        goto L74
    L23:
        e = e;
    L24:
        r0 = r14;
    L79:
        r11.onError(e);     // Catch: Throwable -> L54
        if (r0 != null) goto L68;
    L49:
        if (r1 == null) goto L92;
        r1.close();     // Catch: Exception -> L52
        return;
    L52:
        e = e;
        goto L33
    L92:
        return;
    L68:
        r0.close();     // Catch: Exception -> L47
    L47:
        e = move-exception;
        r11.onError(e);     // Catch: Exception -> L6
    L54:
        th = th;
    L55:
        if (r0 != null) goto L77;
    L60:
        if (r1 == null) goto L90;
        r1.close();     // Catch: Exception -> L63
    L91:
        throw th;     // Catch: Exception -> L6
    L63:
        e = move-exception;
        r11.onError(e);     // Catch: Exception -> L6
        throw th;     // Catch: Exception -> L6
    L90:
        throw th;     // Catch: Exception -> L6
    L77:
        r0.close();     // Catch: Exception -> L58
    L58:
        e = move-exception;
        r11.onError(e);     // Catch: Exception -> L6
    L21:
        th = th;
    L22:
        r0 = r14;
    L37:
        e = e;
        r1 = null;
    L35:
        th = th;
        r1 = null;
    L41:
        e = e;
        r1 = null;
    L39:
        th = th;
        r1 = null;
        goto L55
    L8:
        r12 = null;
    L6:
        e = move-exception;
        r11.onError(e);
    }
}
