package com.bytedance.apm.trace.model.cross;

import androidx.annotation.Keep;
import com.bytedance.apm.trace.api.TracingContext;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class TracingCrossManager {
    private static Map<Long, TracingContext> sCrossTracingContext;

    static {
        sCrossTracingContext = new ConcurrentHashMap();
    }

    public TracingCrossManager() {
    }

    public static void onPassBackAsChild(String r4, String r5, ArrayList<NativeSpan> r6) {
        TracingContext r0 = sCrossTracingContext.get(Long.valueOf(Long.parseLong(r4)));
        if (r0 == null) goto L6;
        sCrossTracingContext.remove(Long.valueOf(Long.parseLong(r4)));
        r0.assembleAsChild(r5, r6);
        return;
    }

    @Keep
    public static void onPassBackAsReference(String r4, String r5, ArrayList<NativeSpan> r6) {
        TracingContext r0 = sCrossTracingContext.get(Long.valueOf(Long.parseLong(r4)));
        if (r0 == null) goto L6;
        sCrossTracingContext.remove(Long.valueOf(Long.parseLong(r4)));
        r0.assembleAsReference(r5, r6);
        return;
    }

    public static void registerCross(long r1, TracingContext r3) {
        sCrossTracingContext.put(Long.valueOf(r1), r3);
    }

    public static void unRegisterCross(long r1) {
        sCrossTracingContext.remove(Long.valueOf(r1));
    }
}
