package com.obric.matrix.account.ui;

import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.i0.r;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/obric/matrix/account/ui/LoginConstant;", "", "()V", "DEFAULT_LOCALE", "Ljava/util/Locale;", "getDEFAULT_LOCALE", "()Ljava/util/Locale;", "SUPPORT_LOCALE_LIST", "", "", "getSUPPORT_LOCALE_LIST", "()Ljava/util/List;", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f8802a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Locale f8803b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final List<String> f8804c = null;

    static {
        f8802a = new n();
        Locale r0 = Locale.CHINA;
        kotlin.n0.d.o.e(r0, "CHINA");
        f8803b = r0;
        f8804c = r.d("zh");
    }

    private n() {
    }

    public final Locale a() {
        return f8803b;
    }

    public final List<String> b() {
        return f8804c;
    }
}
