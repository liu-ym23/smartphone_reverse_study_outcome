package com.obric.oui.common.util;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AppContext.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/obric/oui/common/util/AppContext;", "", "()V", "<set-?>", "Landroid/content/Context;", "context", "getContext", "()Landroid/content/Context;", "init", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AppContext {
    public static final AppContext INSTANCE = null;
    private static Context context;

    static {
        INSTANCE = new AppContext();
    }

    private AppContext() {
    }

    public final Context getContext() {
        return context;
    }

    @JvmStatic
    public static final void init(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        context = r1.getApplicationContext();
    }
}
