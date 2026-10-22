package com.obric.matrix.push.m.h;

import com.obric.matrix.push.r.e;
import kotlin.Metadata;
import kotlin.n0.d.o;
import kotlin.u0.k;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/obric/matrix/push/base/language/PushLanguageService;", "Lcom/obric/matrix/push/base/language/IPushLanguageService;", "()V", "init", "", "context", "Landroid/content/Context;", "isPushLanguageValid", "", "language", "", "push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class b implements a {
    public b() {
    }

    @Override // com.obric.matrix.push.m.h.a
    public boolean a(String r5) {
        o.f(r5, "language");
        if (r5.length() != 0) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == false) goto L8;
        return true;
    L8:
        if (k.F(r5, e.f9794a.c(), false, 2, null) == false) goto L11;
        return true;
    L11:
        return false;
    L5:
        r4 = false;
        goto L6
    }
}
