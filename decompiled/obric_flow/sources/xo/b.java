package xo;

import android.content.Intent;
import com.lynx.tasm.behavior.ui.utils.p;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements to.a {
    public static String b(Intent r5) {
        if (r5 != null) goto L4;
        return "null";
    L4:
        StringBuilder r10 = new StringBuilder(128);
        r10.append("Intent { ");
        p.t(r5, r10);
        r10.append(" }");
        return r10.toString();
    }

    @Override // to.a
    public final /* bridge */ /* synthetic */ String a(Object r5) {
        return b((Intent) r5);
    }
}
