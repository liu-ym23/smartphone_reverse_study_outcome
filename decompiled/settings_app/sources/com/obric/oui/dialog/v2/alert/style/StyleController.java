package com.obric.oui.dialog.v2.alert.style;

import android.content.Context;
import com.android.settings.wifi.WifiAuthorizeUtils;
import com.obric.oui.dialog.base.AbstractDialog;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StyleController.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&¨\u0006\u000e"}, d2 = {"Lcom/obric/oui/dialog/v2/alert/style/StyleController;", "", "attachToDialog", "", "dialog", "Lcom/obric/oui/dialog/base/AbstractDialog;", "attachToHost", WifiAuthorizeUtils.AUTO_LOGIN_HOST, "Lcom/obric/oui/dialog/v2/alert/style/AlertDialogHost;", "attachToParent", "context", "Landroid/content/Context;", "dialogContainer", "Lcom/obric/oui/dialog/v2/alert/style/DialogContainer;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface StyleController {

    /* JADX INFO: compiled from: StyleController.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void attachToDialog(StyleController r1, AbstractDialog r2) {
            Intrinsics.checkNotNullParameter(r1, "this");
            Intrinsics.checkNotNullParameter(r2, "dialog");
        }

        public static void attachToHost(StyleController r1, AlertDialogHost r2) {
            Intrinsics.checkNotNullParameter(r1, "this");
            Intrinsics.checkNotNullParameter(r2, WifiAuthorizeUtils.AUTO_LOGIN_HOST);
            if ((r2 instanceof OAlertDialog) == false) goto L6;
            r1.attachToDialog((AbstractDialog) r2);
            return;
        }
    }

    void attachToDialog(AbstractDialog r1);

    void attachToHost(AlertDialogHost r1);

    void attachToParent(Context r1, DialogContainer r2);
}
