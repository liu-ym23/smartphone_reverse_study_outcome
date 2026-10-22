package com.obric.securitycenter.nodisturb.utils;

import android.content.Context;
import com.obric.securitycenter.nodisturb.R;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: FileUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0007¨\u0006\b"}, d2 = {"Lcom/obric/securitycenter/nodisturb/utils/FileUtils;", "", "()V", "getKey", "", "context", "Landroid/content/Context;", "key", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class FileUtils {
    public static final FileUtils INSTANCE = null;

    static {
        INSTANCE = new FileUtils();
    }

    private FileUtils() {
    }

    @JvmStatic
    public static final String getKey(Context r9, String r10) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "key");
        InputStream r11 = r9.getResources().openRawResource(R.raw.information);
        BufferedReader r2 = new BufferedReader(new InputStreamReader(r11, StandardCharsets.UTF_8));     // Catch: Throwable -> L28
        BufferedReader r1 = r2;     // Catch: Throwable -> L23
    L5:
        String r3 = r1.readLine();     // Catch: Throwable -> L23
        if (r3 == null) goto L8;
        Intrinsics.checkNotNullExpressionValue(r3, "reader.readLine() ?: break");     // Catch: Throwable -> L23
        if (r3.length() <= 0) goto L15;
        boolean r6 = true;
    L16:
        if (r6 == false) goto L5;
        if (StringsKt.startsWith$default(r3, r10 + ":", false, 2, null) == false) goto L5;
        String r12 = StringsKt.substringAfter(r3, ":", "");     // Catch: Throwable -> L23
        CloseableKt.closeFinally(r2, null);     // Catch: Throwable -> L28
        CloseableKt.closeFinally(r11, null);
        return r12;
    L15:
        r6 = false;
        goto L16
    L8:
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L23
        CloseableKt.closeFinally(r2, null);     // Catch: Throwable -> L28
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L28
        CloseableKt.closeFinally(r11, null);
        return "";
    L23:
        th = move-exception;
        throw th;     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        CloseableKt.closeFinally(r2, th);     // Catch: Throwable -> L28
        throw th;     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        throw th;     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        CloseableKt.closeFinally(r11, th);
        throw th;
    }
}
