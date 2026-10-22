package com.obric.oui.sheet;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.obric.oui.common.util.OUnitExtensionKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public class OSheet extends BottomSheetDialogFragment {
    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle r3) {
        OBottomSheetDialog r4 = new OBottomSheetDialog(requireContext());
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
        Context r0 = r4.getContext();
        Intrinsics.e(r0, "context");
        r5.setPeekHeight(OUnitExtensionKt.b(r0));
        return r4;
    }
}
