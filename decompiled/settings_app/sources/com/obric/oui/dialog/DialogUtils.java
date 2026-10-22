package com.obric.oui.dialog;

import android.app.Activity;
import android.view.Window;
import android.view.WindowManager;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DialogUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004H\u0007¨\u0006\n"}, d2 = {"Lcom/obric/oui/dialog/DialogUtils;", "", "()V", "clearDimBeforeDialogShow", "", "activity", "Landroid/app/Activity;", "restoreDimAfterDialogDismiss", "", "originalActivityDim", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DialogUtils {
    public static final DialogUtils INSTANCE = null;

    static {
        INSTANCE = new DialogUtils();
    }

    private DialogUtils() {
    }

    @JvmStatic
    public static final float clearDimBeforeDialogShow(Activity r3) {
        Intrinsics.checkNotNullParameter(r3, "activity");
        Window r4 = r3.getWindow();
        if (r4 != null) goto L5;
        return 0.0f;
    L5:
        float r1 = r4.getAttributes().dimAmount;
        WindowManager.LayoutParams r2 = r4.getAttributes();
        r2.dimAmount = 0.0f;
        r4.setAttributes(r2);
        r4.clearFlags(2);
        return r1;
    }

    @JvmStatic
    public static final void restoreDimAfterDialogDismiss(Activity r1, float r2) {
        Intrinsics.checkNotNullParameter(r1, "activity");
        Window r3 = r1.getWindow();
        if (r3 != null) goto L5;
        return;
    L5:
        WindowManager.LayoutParams r0 = r3.getAttributes();
        r0.dimAmount = r2;
        r3.setAttributes(r0);
        r3.addFlags(2);
    }
}
