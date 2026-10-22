package com.obric.matrix.sdk.network;

import com.bytedance.retrofit2.mime.TypedInput;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DownloadFileUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lcom/obric/matrix/sdk/network/DownloadFileUtils;", "", "()V", "writeTypedInputToDisk", "", "input", "Lcom/bytedance/retrofit2/mime/TypedInput;", "saveFile", "Ljava/io/File;", "callback", "Lcom/obric/matrix/sdk/network/HttpRequestManager$DownloadCallback;", "sdk_network_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DownloadFileUtils {
    public static final DownloadFileUtils INSTANCE = null;

    static {
        INSTANCE = new DownloadFileUtils();
    }

    private DownloadFileUtils() {
    }

    public final void writeTypedInputToDisk(TypedInput r9, File r10, HttpRequestManager.DownloadCallback r11) {
        Intrinsics.checkNotNullParameter(r9, "input");
        Intrinsics.checkNotNullParameter(r10, "saveFile");
        Intrinsics.checkNotNullParameter(r11, "callback");
        File r8 = r10.getParentFile();     // Catch: Exception -> L69
        InputStream r0 = null;
        if (r8 == null) goto L6;
        Boolean r12 = Boolean.valueOf(r8.exists());     // Catch: Exception -> L69
    L7:
        Intrinsics.checkNotNull(r12);     // Catch: Exception -> L69
        if (r12.booleanValue() == true) goto L87;
        File r13 = r10.getParentFile();     // Catch: Exception -> L69
        if (r13 == null) goto L87;
        r13.mkdirs();     // Catch: Exception -> L69
    L87:
        InputStream r14 = r9.in();     // Catch: Throwable -> L41 Exception -> L43
    L91:
        FileOutputStream r1 = new FileOutputStream(r10);     // Catch: Throwable -> L35 Exception -> L38
    L89:
        byte[] r2 = new byte[4096];     // Catch: Throwable -> L31 Exception -> L33
        long r3 = r9.length();     // Catch: Throwable -> L31 Exception -> L33
        long r4 = 0;
    L16:
        int r15 = r14.read(r2);     // Catch: Throwable -> L31 Exception -> L33
        if (r15 == (-1)) goto L19;
        r1.write(r2, 0, r15);     // Catch: Throwable -> L31 Exception -> L33
        r4 = r4 + ((long) r15);     // Catch: Throwable -> L31 Exception -> L33
        r11.onProgress(r4, r3);     // Catch: Throwable -> L31 Exception -> L33
        goto L16
    L19:
        r1.flush();     // Catch: Throwable -> L31 Exception -> L33
        r11.onSuccess(r10);     // Catch: Throwable -> L31 Exception -> L33
        if (r14 == null) goto L80;
        r14.close();     // Catch: Exception -> L23
    L23:
        e = move-exception;
        r11.onError(e);     // Catch: Exception -> L69
    L80:
        r1.close();     // Catch: Exception -> L27
    L97:
        return;
    L27:
        e = move-exception;
        Exception r16 = e;     // Catch: Exception -> L69
    L29:
        r11.onError(r16);     // Catch: Exception -> L69
        return;
    L33:
        e = e;
    L40:
        r0 = r14;
    L76:
        r11.onError(e);     // Catch: Throwable -> L57
        if (r0 != null) goto L78;
    L51:
        if (r1 == null) goto L96;
        r1.close();     // Catch: Exception -> L54
    L99:
        return;
    L54:
        e = move-exception;
        r16 = e;     // Catch: Exception -> L69
        goto L29
    L96:
        return;
    L78:
        r0.close();     // Catch: Exception -> L49
    L49:
        e = move-exception;
        r11.onError(e);     // Catch: Exception -> L69
    L57:
        th = th;
    L58:
        if (r0 != null) goto L72;
    L63:
        if (r1 == null) goto L94;
        r1.close();     // Catch: Exception -> L66
    L95:
        throw th;     // Catch: Exception -> L69
    L66:
        e = move-exception;
        r11.onError(e);     // Catch: Exception -> L69
        throw th;     // Catch: Exception -> L69
    L94:
        throw th;     // Catch: Exception -> L69
    L72:
        r0.close();     // Catch: Exception -> L61
    L61:
        e = move-exception;
        r11.onError(e);     // Catch: Exception -> L69
    L31:
        th = th;
    L37:
        r0 = r14;
    L38:
        e = e;
        r1 = null;
    L35:
        th = th;
        r1 = null;
    L43:
        e = e;
        r1 = null;
    L41:
        th = th;
        r1 = null;
        goto L58
    L6:
        r12 = null;
    L69:
        e = move-exception;
        r11.onError(e);
    }
}
