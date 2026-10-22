package org.greenrobot.eventbus.util;

import android.util.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class ExceptionToResourceMapping {
    public final Map<Class<? extends Throwable>, Integer> throwableToMsgIdMap;

    public ExceptionToResourceMapping() {
        this.throwableToMsgIdMap = new HashMap();
    }

    public Integer mapThrowable(Throwable r4) {
        int r0 = 20;
        Throwable r1 = r4;
    L3:
        Integer r2 = mapThrowableFlat(r1);
        if (r2 != null) goto L5;
        r1 = r1.getCause();
        r0 = r0 - 1;
        if (r0 <= 0) goto L10;
        if (r1 == r4) goto L10;
        if (r1 != null) goto L3;
    L10:
        Log.d("EventBus", "No specific message resource ID found for " + r4);
        return null;
    L5:
        return r2;
    }

    protected Integer mapThrowableFlat(Throwable r6) {
        Class<?> r7 = r6.getClass();
        Integer r0 = this.throwableToMsgIdMap.get(r7);
        if (r0 != null) goto L13;
        Iterator<Map.Entry<Class<? extends Throwable>, Integer>> r5 = this.throwableToMsgIdMap.entrySet().iterator();
        Class<? extends Throwable> r1 = null;
    L6:
        if (r5.hasNext() == false) goto L13;
        Map.Entry<Class<? extends Throwable>, Integer> r2 = r5.next();
        Class<? extends Throwable> r3 = r2.getKey();
        if (r3.isAssignableFrom(r7) == false) goto L6;
        if (r1 == null) goto L12;
        if (r1.isAssignableFrom(r3) == false) goto L6;
    L12:
        r0 = r2.getValue();
        r1 = r3;
    L13:
        return r0;
    }

    public ExceptionToResourceMapping addMapping(Class<? extends Throwable> r2, int r3) {
        this.throwableToMsgIdMap.put(r2, Integer.valueOf(r3));
        return this;
    }
}
