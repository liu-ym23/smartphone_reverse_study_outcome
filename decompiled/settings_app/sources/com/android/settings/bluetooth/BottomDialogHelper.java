package com.android.settings.bluetooth;

import android.content.Context;
import android.view.View;
import com.android.settings.R;
import com.obric.oui.button.OButton;
import com.obric.oui.sheet.v2.OSheet;
import com.obric.oui.sheet.v2.OSheetBase;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BottomDialogHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0007¨\u0006\f"}, d2 = {"Lcom/android/settings/bluetooth/BottomDialogHelper;", "", "()V", "showPairDialog", "Lcom/obric/oui/sheet/v2/OSheet;", "context", "Landroid/content/Context;", "customView", "Landroid/view/View;", "positiveBtnListener", "Landroid/view/View$OnClickListener;", "negativeBtnListener", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class BottomDialogHelper {
    public static final BottomDialogHelper INSTANCE = null;

    static {
        INSTANCE = new BottomDialogHelper();
    }

    private BottomDialogHelper() {
    }

    @JvmStatic
    public static final OSheet showPairDialog(Context r33, View r34, View.OnClickListener r35, View.OnClickListener r36) {
        Intrinsics.checkNotNullParameter(r33, "context");
        Intrinsics.checkNotNullParameter(r34, "customView");
        Intrinsics.checkNotNullParameter(r35, "positiveBtnListener");
        Intrinsics.checkNotNullParameter(r36, "negativeBtnListener");
        OSheet r14 = new OSheet(r33, 0, 0, false, false, 28, null);
        OSheet r0 = r14;
        OSheetBase.DefaultImpls.setHeader$default(r0, OSheet.Header.ONLY_TITLE, null, null, r33.getString(R.string.bluetooth_pairing_request), null, false, null, null, null, null, null, null, null, null, 16150, null);
        r14.setBodyView(r34);
        OSheetBase.DefaultImpls.setFooterButton$default(r0, r33.getString(R.string.bluetooth_pairing_decline), false, r36, r33.getString(R.string.bluetooth_pairing_accept), false, r35, 2, null);
        View r1 = r14.getPositiveButton();
        if ((r1 instanceof OButton) == false) goto L5;
        OButton r2 = (OButton) r1;
    L6:
        if (r2 == null) goto L8;
        r2.setTextColor(r33.getColor(R.color.oui_accent_6));
    L8:
        return r14;
    L5:
        r2 = null;
        goto L6
    }
}
