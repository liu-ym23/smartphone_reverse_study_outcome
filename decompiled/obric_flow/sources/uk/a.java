package uk;

import android.util.Log;
import java.util.Collections;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {
    static {
        Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));
    }

    public static void a() {
        Log.w(qo.a.a("EventManager"), "context is null");
    }
}
