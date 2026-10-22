package d.b.m.e;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.bytedance.news.common.service.manager.IService;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static final <T extends IService> T a(Class<T> r1) {
        o.g(r1, "clazz");
        T r0 = (T) com.bytedance.news.common.service.manager.e.a.a(r1);
        if (r0 == null) goto L5;
        com.bytedance.news.common.service.manager.d.g(r1, r0);
    L5:
        return r0;
    }

    public static final boolean b(Context r3) {
        o.g(r3, "$this$isDebug");
        ApplicationInfo r4 = r3.getApplicationInfo();     // Catch: Exception -> L9
        o.b(r4, "applicationInfo");     // Catch: Exception -> L9
        if ((r4.flags & 2) == 0) goto L8;
        return true;
    L8:
        return false;
    L9:
        e = move-exception;
        d.b.m.d.a.c("isDebug", new Object[]{e});
        return false;
    }
}
