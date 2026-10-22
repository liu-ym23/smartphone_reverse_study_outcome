package com.obric.oui.sheet;

import android.app.Dialog;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.obric.common.oui.j;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/obric/oui/sheet/OExpandableSheet;", "Lcom/obric/oui/sheet/OSheet;", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "<init>", "()V", "OUI_standardRelease"}, k = 1, mv = {1, 1, 15})
public class OExpandableSheet extends OSheet {
    public OExpandableSheet() {
    }

    @Override // com.obric.oui.sheet.OSheet, com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle r3) {
        OBottomSheetDialog r4 = new OBottomSheetDialog(requireContext(), j.f8276a);
        r4.setDismissWithAnimation(false);
        BottomSheetBehavior<FrameLayout> r2 = r4.getBehavior();
        o.e(r2, "behavior");
        r2.setSkipCollapsed(true);
        BottomSheetBehavior<FrameLayout> r5 = r4.getBehavior();
        o.e(r5, "behavior");
        r5.setFitToContents(true);
        r4.b(true);
        return r4;
    }
}
