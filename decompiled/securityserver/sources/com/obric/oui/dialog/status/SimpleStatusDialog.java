package com.obric.oui.dialog.status;

import a.a;
import android.view.Window;
import androidx.annotation.RequiresApi;
import com.bytedance.securityserver.R;
import com.obric.oui.dialog.base.BaseDialog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(30)
@Metadata
public final class SimpleStatusDialog extends BaseDialog {
    @Override // com.obric.oui.dialog.base.AbstractDialog
    public final int b() {
        return R.layout.o_status_toast_dialog;
    }

    @Override // com.obric.oui.dialog.base.AbstractDialog
    public final int c(Window r2) {
        return a.d("Resources.getSystem()", 1, 41);
    }
}
