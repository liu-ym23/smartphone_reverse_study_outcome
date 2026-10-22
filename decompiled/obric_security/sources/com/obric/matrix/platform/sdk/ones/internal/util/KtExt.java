package com.obric.matrix.platform.sdk.ones.internal.util;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: KtExt.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J5\u0010\u0003\u001a\u0004\u0018\u0001H\u0004\"\u0004\b\u0000\u0010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\b\u0004\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00040\bH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\tJ=\u0010\n\u001a\u00020\u000b\"\u0004\b\u0000\u0010\f\"\u0004\b\u0001\u0010\r*\u0014\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u00020\u000b0\u000e2\u0006\u0010\u000f\u001a\u0002H\f2\u0006\u0010\u0010\u001a\u0002H\r¢\u0006\u0002\u0010\u0011J\f\u0010\u0012\u001a\u00020\u0013*\u0004\u0018\u00010\u0006\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0014"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/internal/util/KtExt;", "", "()V", "tryRun", ExifInterface.GPS_DIRECTION_TRUE, "sig", "", "block", "Lkotlin/Function0;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "invokeSafely", "", "P1", "P2", "Lkotlin/Function2;", "p1", "p2", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Ljava/lang/Object;)V", "toSafeJson", "Lorg/json/JSONObject;", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class KtExt {
    public static final KtExt INSTANCE = null;

    static {
        INSTANCE = new KtExt();
    }

    private KtExt() {
    }

    public static /* synthetic */ Object tryRun$default(KtExt r0, String r1, Function0 r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L5;
        r1 = "";
    L5:
        Intrinsics.checkNotNullParameter(r2, "block");
        return r2.invoke();
    L8:
        th = move-exception;
        MLog.e("tryRun " + r1 + ", failed, " + th);
        return null;
    }

    public final <T> T tryRun(String r2, Function0<? extends T> r3) {
        Intrinsics.checkNotNullParameter(r3, "block");
        return r3.invoke();
    L5:
        th = move-exception;
        MLog.e("tryRun " + r2 + ", failed, " + th);
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <P1, P2> void invokeSafely(Function2<? super P1, ? super P2, Unit> r1, P1 r2, P2 r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        r1.invoke(r2, r3);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        MLog.e("invoke failed, " + th);
    }

    public final JSONObject toSafeJson(String r1) {
        String r0 = r1;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L17;
        return new JSONObject(r1);
    L14:
        return new JSONObject();
    L17:
        return new JSONObject();
    L5:
        if (r0.length() == 0) goto L8;
        r2 = false;
        goto L9
    }
}
