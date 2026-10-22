package com.obric.matrix.platform.sdk.ones.commonmonitor.fps;

import android.os.Looper;
import android.util.Printer;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class CommonUtil {

    @NotNull
    public static final CommonUtil INSTANCE = null;

    static {
        INSTANCE = new CommonUtil();
    }

    private CommonUtil() {
    }

    @Nullable
    public final Printer getCurrentPrinter() {
        Field r1 = Class.forName("android.os.Looper").getDeclaredField("mLogging");     // Catch: Exception -> L7
        r1.setAccessible(true);     // Catch: Exception -> L7
        Object r2 = r1.get(Looper.getMainLooper());     // Catch: Exception -> L7
        if (r2 == null) goto L6;
        return (Printer) r2;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type android.util.Printer");     // Catch: Exception -> L7
    L7:
        return null;
    }

    @NotNull
    public final JSONObject toDropFrameJson(@NotNull FpsBean r4) {
        Intrinsics.f(r4, "<this>");
        JSONObject r3 = new JSONObject();
        r3.put("drop_rate", r4.getDropRate());
        r3.put("drop_3", r4.getDrop3());
        r3.put("drop_7", r4.getDrop7());
        r3.put("drop_25", r4.getDrop25());
        return r3;
    }
}
