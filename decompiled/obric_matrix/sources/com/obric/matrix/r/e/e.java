package com.obric.matrix.r.e;

import androidx.annotation.Nullable;
import com.google.gson.Gson;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Gson f9939a;

    class a extends com.google.gson.z.a<Map<String, Object>> {
        a() {
        }
    }

    @Nullable
    public static <T> T a(String r1, Class<T> r2) {
        return (T) b().m(r1, r2);
    L4:
        return null;
    }

    public static synchronized Gson b() {
        monitor-enter(e.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f9939a != null) goto L7;
        f9939a = new Gson();     // Catch: Throwable -> L10
    L7:
        Gson r1 = f9939a;     // Catch: Throwable -> L10
        monitor-exit(e.class);
        return r1;
    }

    @Nullable
    public static Map<String, Object> c(String r2) {
        return (Map) b().n(r2, new a().getType());
    L4:
        return null;
    }

    public static <T> String d(T r1) {
        return b().v(r1);
    L4:
        return "";
    }
}
