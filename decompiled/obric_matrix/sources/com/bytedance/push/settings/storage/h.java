package com.bytedance.push.settings.storage;

import android.content.Context;
import android.util.Log;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class h implements com.bytedance.push.settings.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ConcurrentHashMap<String, i> f5519a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<String, i> f5520b = null;

    static {
        f5519a = new ConcurrentHashMap();
        f5520b = new ConcurrentHashMap();
    }

    public h() {
    }

    @Override // com.bytedance.push.settings.f
    public i a(Context r2, boolean r3, String r4) {
        if (r3 == false) goto L10;
        ConcurrentHashMap<String, i> r1 = f5520b;
        i r5 = r1.get(r4);
        if (r5 == null) goto L6;
        return r5;
    L6:
        Log.d("PushProvider", "SharedPreferenceStorageFactory#create");
        if (PushProvider.f(r2) == false) goto L9;
        i r6 = new c(r2, r4);
    L14:
        r1.put(r4, r6);
        return r6;
    L9:
        r6 = new d(r2, r4);
        goto L14
    L10:
        r1 = f5519a;
        i r7 = r1.get(r4);
        if (r7 == null) goto L13;
        return r7;
    L13:
        r6 = new g(r2, r4);
        goto L14
    }
}
