package androidx.transition;

import android.graphics.Canvas;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
class CanvasUtils {
    private static Method sInorderBarrierMethod;
    private static boolean sOrderMethodsFetched;
    private static Method sReorderBarrierMethod;

    static void enableZ(Canvas r0, boolean r1) {
        if (r1 == false) goto L4;
        r0.enableZ();
        return;
    L4:
        r0.disableZ();
    }

    private CanvasUtils() {
    }
}
