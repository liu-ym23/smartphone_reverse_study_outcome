package com.obric.matrix.platform.sdk.ones.env;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.obric.matrix.platform.sdk.ones.internal.util.MLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class BoeSDKApi {

    @NotNull
    private static final String AUTHORITY = "com.obric.matrix.boe";

    @NotNull
    private static final String BOE_URI = "content://com.obric.matrix.boe/get_boe";

    @NotNull
    private static final String FIELD_IS_BOE = "is_boe";

    @NotNull
    private static final String FIELD_IS_PPE = "is_ppe";

    @NotNull
    public static final BoeSDKApi INSTANCE = null;

    @NotNull
    private static final String PPE_URI = "content://com.obric.matrix.boe/get_ppe";

    @NotNull
    private static final String TAG = "BoeSDKApi";

    static {
        INSTANCE = new BoeSDKApi();
    }

    private BoeSDKApi() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v3 */
    public final int getBoe(@NotNull Context r10) {
        Intrinsics.f(r10, "context");
        ?? r1 = 0;
        Cursor r11 = r10.getContentResolver().query(Uri.parse(BOE_URI), null, null, null, null);     // Catch: Throwable -> L21 Exception -> L23
    L33:
        if (r11 != null) goto L12;
        MLog.e$default(TAG, "getBoe() is null", null, 4, null);     // Catch: Throwable -> L8 Exception -> L10
        return 0;
    L12:
        int r3 = 0;
    L14:
        if (r11.moveToNext() == false) goto L18;
        int r4 = r11.getColumnIndex(FIELD_IS_BOE);     // Catch: Throwable -> L8 Exception -> L10
        if (r4 < 0) goto L14;
        r3 = r11.getInt(r4);     // Catch: Throwable -> L8 Exception -> L10
        goto L14
    L18:
        MLog.d$default(TAG, "getBoe() isBoe: " + r3, null, 4, null);     // Catch: Throwable -> L8 Exception -> L10
        r11.close();
        return r3;
    L10:
        Exception e = e;
    L25:
        MLog.e(TAG, "getBoe Exception ", e);     // Catch: Throwable -> L8
        if (r11 == null) goto L28;
        r11.close();
    L28:
        return 0;
    L8:
        th = th;
        r1 = r10;
    L29:
        if (r1 == 0) goto L31;
        r1.close();
    L31:
        throw th;
    L23:
        e = move-exception;
        e = e;
        r11 = null;
    L21:
        th = th;
        goto L29
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v3 */
    public final int getPpe(@NotNull Context r10) {
        Intrinsics.f(r10, "context");
        ?? r1 = 0;
        Cursor r11 = r10.getContentResolver().query(Uri.parse(PPE_URI), null, null, null, null);     // Catch: Throwable -> L21 Exception -> L23
    L33:
        if (r11 != null) goto L12;
        MLog.e$default(TAG, "getPpe() is null", null, 4, null);     // Catch: Throwable -> L8 Exception -> L10
        return 0;
    L12:
        int r3 = 0;
    L14:
        if (r11.moveToNext() == false) goto L18;
        int r4 = r11.getColumnIndex(FIELD_IS_PPE);     // Catch: Throwable -> L8 Exception -> L10
        if (r4 < 0) goto L14;
        r3 = r11.getInt(r4);     // Catch: Throwable -> L8 Exception -> L10
        goto L14
    L18:
        MLog.d$default(TAG, "getPpe() isPpe: " + r3, null, 4, null);     // Catch: Throwable -> L8 Exception -> L10
        r11.close();
        return r3;
    L10:
        Exception e = e;
    L25:
        MLog.e(TAG, "getPpe Exception ", e);     // Catch: Throwable -> L8
        if (r11 == null) goto L28;
        r11.close();
    L28:
        return 0;
    L8:
        th = th;
        r1 = r10;
    L29:
        if (r1 == 0) goto L31;
        r1.close();
    L31:
        throw th;
    L23:
        e = move-exception;
        e = e;
        r11 = null;
    L21:
        th = th;
        goto L29
    }
}
