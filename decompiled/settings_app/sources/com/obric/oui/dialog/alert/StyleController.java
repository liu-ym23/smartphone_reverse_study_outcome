package com.obric.oui.dialog.alert;

import android.content.Context;
import android.widget.FrameLayout;
import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: compiled from: StyleController.kt */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated(message = "已废弃, 请用 com/obric/oui/dialog/v2 下面的版本")
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, d2 = {"Lcom/obric/oui/dialog/alert/StyleController;", "", "attachToDialog", "", "dialog", "Lcom/obric/oui/dialog/alert/OAlertDialog;", "attachToParent", "context", "Landroid/content/Context;", "parent", "Landroid/widget/FrameLayout;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface StyleController {
    void attachToDialog(OAlertDialog r1);

    void attachToParent(Context r1, FrameLayout r2);
}
