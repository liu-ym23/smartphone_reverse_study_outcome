package com.obric.securitycenter.nodisturb.utils;

import android.app.Activity;
import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.obric.oui.toast.OToast;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ToastUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Lcom/obric/securitycenter/nodisturb/utils/ToastUtils;", "", "()V", "showToast", "", "context", "Landroid/content/Context;", NotificationCompat.CATEGORY_MESSAGE, "", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ToastUtils {
    public static final ToastUtils INSTANCE = null;

    static {
        INSTANCE = new ToastUtils();
    }

    private ToastUtils() {
    }

    @JvmStatic
    public static final void showToast(Context r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, NotificationCompat.CATEGORY_MESSAGE);
        OToast.Companion.show$default(OToast.Companion, (Activity) r7, r8, 0, 4, null);
    }
}
