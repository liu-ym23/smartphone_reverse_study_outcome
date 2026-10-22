package ms.bd.c;

import android.content.Context;
import android.content.SharedPreferences;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
final class g1 extends b.a {
    g1() {
    }

    @Proxy("getSharedPreferences")
    @TargetClass(scope = Scope.SELF, value = "android.content.Context")
    public static SharedPreferences c(Context r0, String r1, int r2) {
        return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
    }

    @Override // ms.bd.c.b.a
    public Object b(int r7, long r8, String r10, Object r11) {
        Context r6 = a.a().c();
        String[] r9 = r10.split((String) m.a(16777217, 0, 0, "68dcbf", new byte[]{27, 38}));
        String r12 = r9[0];
        String r13 = r9[1];
        SharedPreferences.Editor r14 = c(r6, r12, 0).edit();
        r14.putString(r13, (String) r11);
        r14.commit();
        return null;
    }
}
