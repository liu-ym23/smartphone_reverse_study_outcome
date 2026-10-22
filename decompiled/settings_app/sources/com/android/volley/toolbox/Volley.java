package com.android.volley.toolbox;

import android.content.Context;
import com.android.volley.Network;
import com.android.volley.RequestQueue;

/* JADX INFO: loaded from: classes.dex */
public class Volley {
    private static final String DEFAULT_CACHE_DIR = "volley";

    public Volley() {
    }

    public static RequestQueue newRequestQueue(Context r1, BaseHttpStack r2) {
        if (r2 != null) goto L4;
        BasicNetwork r3 = new BasicNetwork(new HurlStack());
    L6:
        return newRequestQueue(r1, r3);
    L4:
        r3 = new BasicNetwork(r2);
        goto L6
    }

    @Deprecated
    public static RequestQueue newRequestQueue(Context r1, HttpStack r2) {
        if (r2 != null) goto L6;
        BaseHttpStack r0 = (BaseHttpStack) null;
        return newRequestQueue(r1, null);
    L6:
        return newRequestQueue(r1, new BasicNetwork(r2));
    }

    private static RequestQueue newRequestQueue(Context r2, Network r3) {
        final Context r4 = r2.getApplicationContext();
        RequestQueue r5 = new RequestQueue(new DiskBasedCache(new AnonymousClass1(r4)), r3);
        r5.start();
        return r5;
    }

    public static RequestQueue newRequestQueue(Context r2) {
        BaseHttpStack r1 = (BaseHttpStack) null;
        return newRequestQueue(r2, null);
    }
}
