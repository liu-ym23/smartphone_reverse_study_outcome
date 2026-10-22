package com.android.settings.utils;

import android.content.Context;
import android.view.View;
import com.obric.oui.dialog.base.OBaseDialog;
import com.obric.oui.dialog.v2.misc.StatusDialog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StatusDialogUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JB\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007¨\u0006\u000f"}, d2 = {"Lcom/android/settings/utils/StatusDialogUtils;", "", "()V", "createStatusDialog", "Lcom/obric/oui/dialog/v2/misc/StatusDialog;", "context", "Landroid/content/Context;", "title", "", "subtitle", "buttonText", "showButton", "", "onClick", "Landroid/view/View$OnClickListener;", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class StatusDialogUtils {
    public static final StatusDialogUtils INSTANCE = null;

    static {
        INSTANCE = new StatusDialogUtils();
    }

    @JvmStatic
    public static final StatusDialog createStatusDialog(Context r9, String r10) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "title");
        return createStatusDialog$default(r9, r10, null, null, false, null, 60, null);
    }

    @JvmStatic
    public static final StatusDialog createStatusDialog(Context r9, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "title");
        Intrinsics.checkNotNullParameter(r11, "subtitle");
        return createStatusDialog$default(r9, r10, r11, null, false, null, 56, null);
    }

    @JvmStatic
    public static final StatusDialog createStatusDialog(Context r9, String r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "title");
        Intrinsics.checkNotNullParameter(r11, "subtitle");
        Intrinsics.checkNotNullParameter(r12, "buttonText");
        return createStatusDialog$default(r9, r10, r11, r12, false, null, 48, null);
    }

    @JvmStatic
    public static final StatusDialog createStatusDialog(Context r9, String r10, String r11, String r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "title");
        Intrinsics.checkNotNullParameter(r11, "subtitle");
        Intrinsics.checkNotNullParameter(r12, "buttonText");
        return createStatusDialog$default(r9, r10, r11, r12, r13, null, 32, null);
    }

    private StatusDialogUtils() {
    }

    public static /* synthetic */ StatusDialog createStatusDialog$default(Context r7, String r8, String r9, String r10, boolean r11, View.OnClickListener r12, int r13, Object r14) {
        if ((r13 & 4) == 0) goto L5;
        String r3 = "";
    L7:
        if ((r13 & 8) == 0) goto L9;
        String r4 = "";
    L11:
        if ((r13 & 16) == 0) goto L13;
        r11 = false;
    L13:
        boolean r5 = r11;
        if ((r13 & 32) == 0) goto L17;
        r12 = null;
    L17:
        return createStatusDialog(r7, r8, r3, r4, r5, r12);
    L9:
        r4 = r10;
        goto L11
    L5:
        r3 = r9;
        goto L7
    }

    @JvmStatic
    public static final StatusDialog createStatusDialog(Context r8, String r9, String r10, String r11, boolean r12, final View.OnClickListener r13) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "title");
        Intrinsics.checkNotNullParameter(r10, "subtitle");
        Intrinsics.checkNotNullParameter(r11, "buttonText");
        if (r12 == false) goto L5;
        OBaseDialog.ButtonConfig r14 = new OBaseDialog.ButtonConfig(r11, new StatusDialogUtils$createStatusDialog$modifier$1(r13), null, 4, null);
    L7:
        return new StatusDialog(r8, new StatusDialog.Modifier(r9, r10, null, r14));
    L5:
        r14 = null;
        goto L7
    }
}
