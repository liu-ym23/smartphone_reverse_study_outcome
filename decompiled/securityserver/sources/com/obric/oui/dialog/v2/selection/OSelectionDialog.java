package com.obric.oui.dialog.v2.selection;

import androidx.annotation.RequiresApi;
import com.bytedance.securityserver.R;
import com.obric.oui.dialog.base.OBaseDialog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(30)
@Metadata
public final class OSelectionDialog extends OBaseDialog {
    public static final /* synthetic */ int p = 0;

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public static final class Modifier {
    }

    @Override // com.obric.oui.dialog.base.AbstractDialog
    public final int b() {
        return R.layout.o_selection_dialog;
    }
}
