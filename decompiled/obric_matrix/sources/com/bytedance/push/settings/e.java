package com.bytedance.push.settings;

import android.content.Context;
import com.bytedance.push.settings.storage.h;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final h f5485a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final b f5486b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final c f5487c = null;

    static {
        h r0 = new h();
        f5485a = r0;
        f5486b = new b(r0);
        f5487c = new c();
    }

    public static f a() {
        return f5485a;
    }

    public static <T> T b(Context r1, Class<T> r2) {
        if (ISettings.class.isAssignableFrom(r2) == false) goto L7;
        return (T) f5487c.c(r1, r2);
    L7:
        if (ILocalSettings.class.isAssignableFrom(r2) == false) goto L11;
        return (T) f5486b.b(r1, r2);
    L11:
        throw new IllegalArgumentException("tClass must be child of ISettings or ILocalSettings");
    }
}
