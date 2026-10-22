package com.android.settings.deviceinfo;

import android.content.Context;
import com.obric.oui.dialog.v2.selection.OSelectionItemView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UsbModeChooserKotlin.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {"createSelectItemView", "Lcom/obric/oui/dialog/v2/selection/OSelectionItemView;", "context", "Landroid/content/Context;", "app_neridaCnRelease"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class UsbModeChooserKotlinKt {
    public static final OSelectionItemView createSelectItemView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        OSelectionItemView r0 = new OSelectionItemView(r2, null);
        r0.setCheckStyle(OSelectionItemView.Companion.CheckStyle.ICON);
        return r0;
    }
}
