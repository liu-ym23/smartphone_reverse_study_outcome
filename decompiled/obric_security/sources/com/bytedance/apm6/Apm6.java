package com.bytedance.apm6;

import android.content.Context;
import com.bytedance.apm6.hub.Apm;
import com.bytedance.services.slardar.config.IResponseConfigListener;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class Apm6 {
    static final String OUTSIDE_MAX_SIZE_MB_TODAY = "max_size_mb_today";
    private static List<IResponseConfigListener> mConfigListeners;

    public Apm6() {
    }

    public static Runnable init(final Context r1) {
        return Apm.initWithAsync(new AnonymousClass1(r1));
    }

    public static void registerResponseConfigListener(IResponseConfigListener r1) {
        if (r1 != null) goto L5;
        return;
    L5:
        if (mConfigListeners != null) goto L8;
        mConfigListeners = new CopyOnWriteArrayList();
    L8:
        if (mConfigListeners.contains(r1) == true) goto L11;
        mConfigListeners.add(r1);
        return;
    }

    public static void unregisterResponseConfigListener(IResponseConfigListener r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        List<IResponseConfigListener> r0 = mConfigListeners;
        if (r0 == null) goto L8;
        r0.remove(r1);
        return;
    }

    public static void dispatchSlardarResponse(JSONObject r2) {
        List<IResponseConfigListener> r0 = mConfigListeners;
        if (r0 == null) goto L8;
        Iterator<IResponseConfigListener> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        r1.next().onResponse(r2);
        goto L6
    L10:
        return;
    }
}
