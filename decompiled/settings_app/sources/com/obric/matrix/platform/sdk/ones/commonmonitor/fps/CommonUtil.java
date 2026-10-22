package com.obric.matrix.platform.sdk.ones.commonmonitor.fps;

import android.os.Looper;
import android.util.Printer;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: CommonUtil.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004J\n\u0010\u0005\u001a\u00020\u0006*\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/commonmonitor/fps/CommonUtil;", "", "()V", "getCurrentPrinter", "Landroid/util/Printer;", "toDropFrameJson", "Lorg/json/JSONObject;", "Lcom/obric/matrix/platform/sdk/ones/commonmonitor/fps/FpsBean;", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CommonUtil {
    public static final CommonUtil INSTANCE = null;

    static {
        INSTANCE = new CommonUtil();
    }

    private CommonUtil() {
    }

    public final Printer getCurrentPrinter() {
        Field r1 = Class.forName("android.os.Looper").getDeclaredField("mLogging");     // Catch: Exception -> L7
        r1.setAccessible(true);     // Catch: Exception -> L7
        Object r2 = r1.get(Looper.getMainLooper());     // Catch: Exception -> L7
        if (r2 == null) goto L6;
        return (Printer) r2;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type android.util.Printer");     // Catch: Exception -> L7
    L7:
        Printer r0 = (Printer) null;
        return null;
    }

    public final JSONObject toDropFrameJson(FpsBean r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        JSONObject r3 = new JSONObject();
        r3.put("drop_rate", r4.getDropRate());
        r3.put("drop_3", r4.getDrop3());
        r3.put("drop_7", r4.getDrop7());
        r3.put("drop_25", r4.getDrop25());
        return r3;
    }
}
