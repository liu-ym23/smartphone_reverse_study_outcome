package com.obric.oui.sheet;

import android.app.Dialog;
import android.os.Bundle;
import com.obric.common.oui.R;
import kotlin.Metadata;

/* JADX INFO: compiled from: OExpandableSheet.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/sheet/OExpandableSheet;", "Lcom/obric/oui/sheet/OSheet;", "()V", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OExpandableSheet extends OSheet {
    public OExpandableSheet() {
    }

    @Override // com.obric.oui.sheet.OSheet, com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle r2) {
        OBottomSheetDialog r3 = new OBottomSheetDialog(requireContext(), R.style.AppBottomSheetDialogTheme);
        r3.setDismissWithAnimation(false);
        r3.getBehavior().setSkipCollapsed(true);
        r3.getBehavior().setFitToContents(true);
        r3.setIs69Expandable(true);
        return r3;
    }
}
