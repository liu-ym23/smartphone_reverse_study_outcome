package com.obric.oui.dialog.v2.alert.style;

import android.content.Context;
import com.obric.common.oui.R;
import com.obric.oui.utils.ViewUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ButtonGroupDangerStyleController.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"Lcom/obric/oui/dialog/v2/alert/style/ButtonGroupDangerStyleController;", "Lcom/obric/oui/dialog/v2/alert/style/DefaultButtonStyleController;", "context", "Landroid/content/Context;", "style", "", "(Landroid/content/Context;I)V", "getButtonContainerLayout", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ButtonGroupDangerStyleController extends DefaultButtonStyleController {
    public ButtonGroupDangerStyleController(Context r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
    }

    @Override // com.obric.oui.dialog.v2.alert.style.DefaultButtonStyleController
    public int getButtonContainerLayout(int r2) {
        if (r2 == 0) goto L8;
        if (r2 == 1) goto L13;
        return super.getButtonContainerLayout(r2);
    L13:
        return R.layout.o_dialog_button_vertical_v2_danger;
    L8:
        if (ViewUtil.isInLargeFont(getContext().getResources().getConfiguration().fontScale) == false) goto L11;
        return R.layout.o_dialog_button_vertical_v2_danger;
    L11:
        return R.layout.o_dialog_button_horizontal_v2_danger;
    }
}
