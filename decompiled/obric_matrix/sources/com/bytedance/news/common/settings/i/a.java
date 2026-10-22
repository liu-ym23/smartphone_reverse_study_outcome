package com.bytedance.news.common.settings.i;

import androidx.annotation.NonNull;
import com.bytedance.news.common.settings.g.f;
import com.bytedance.news.common.settings.g.g;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class a implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ConcurrentHashMap<String, b> f5334a = null;

    static {
        f5334a = new ConcurrentHashMap();
    }

    public a() {
    }

    @Override // com.bytedance.news.common.settings.g.g
    public f a(@NonNull String r3) {
        ConcurrentHashMap<String, b> r2 = f5334a;
        b r0 = r2.get(r3);
        if (r0 == null) goto L5;
        return r0;
    L5:
        b r1 = new b(com.bytedance.news.common.settings.h.a.b(), r3);
        r2.put(r3, r1);
        return r1;
    }
}
