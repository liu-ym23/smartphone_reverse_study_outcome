package com.bytedance.news.common.service.manager.e;

import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.d;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static final <T extends IService> T a(Class<T> r1) {
        o.g(r1, "clazz");
        return (T) d.a(r1);
    }
}
