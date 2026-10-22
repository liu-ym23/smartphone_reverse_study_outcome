package com.obric.oui.sheet;

import android.app.Dialog;
import android.os.Bundle;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public class OExpandableSheet extends OSheet {
    @Override // com.obric.oui.sheet.OSheet, com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r3) {
        OBottomSheetDialog r4 = new OBottomSheetDialog(requireContext());
        r4.f = false;
        if (r4.b != null) goto L5;
        r4.a();
    L5:
        BottomSheetBehavior r2 = r4.b;
        Intrinsics.e(r2, "behavior");
        r2.setSkipCollapsed(true);
        if (r4.b != null) goto L8;
        r4.a();
    L8:
        BottomSheetBehavior r5 = r4.b;
        Intrinsics.e(r5, "behavior");
        r5.setFitToContents(true);
        r4.l = true;
        return r4;
    }
}
