package ms.bd.c;

import android.content.Context;
import android.content.SharedPreferences;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
final class e1 extends b.a {
    e1() {
    }

    @Proxy("getSharedPreferences")
    @TargetClass(scope = Scope.SELF, value = "android.content.Context")
    public static SharedPreferences c(Context r0, String r1, int r2) {
        return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
    }

    @Override // ms.bd.c.b.a
    public Object b(int r1, long r2, String r4, Object r5) {
        SharedPreferences r0 = c(a.a().c(), r4, 0);
        return r0.getString((String) r5, null);
    }
}
