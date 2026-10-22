package com.obric.oui.panel;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.AppCompatDialogFragment;
import com.obric.oui.common.util.ToolsExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public class OBasicPanelFragment extends AppCompatDialogFragment {
    @Override // androidx.fragment.app.DialogFragment
    public final void dismiss() {
        Dialog r0 = getDialog();     // Catch: Exception -> L12
        if (r0 == null) goto L7;
        Window r1 = r0.getWindow();     // Catch: Exception -> L12
        if (r1 == null) goto L7;
        r1.getDecorView();     // Catch: Exception -> L12
    L7:
        Dialog r2 = getDialog();     // Catch: Exception -> L12
        if ((r2 instanceof BottomSheetDialog) == false) goto L10;
        Intrinsics.e(((BottomSheetDialog) r2).b(), "dialog.behavior");     // Catch: Exception -> L12
    L10:
        super.dismiss();     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        ToolsExtKt.a("Try exception occur " + e.getMessage());
    }

    @Override // androidx.fragment.app.DialogFragment
    public final void dismissAllowingStateLoss() {
        Dialog r0 = getDialog();
        if (r0 == null) goto L7;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L7;
        r1.getDecorView();
    L7:
        super.dismissAllowingStateLoss();
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface r2) {
        Intrinsics.f(r2, "dialog");
        Dialog r0 = getDialog();
        if (r0 == null) goto L7;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L7;
        r1.getDecorView();
    L7:
        super.onCancel(r2);
    }

    @Override // androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle r2) {
        Context r1 = requireContext();
        Intrinsics.e(r1, "requireContext()");
        OBasePanelDialog r3 = new OBasePanelDialog(r1, 0);
        r3.n = 0;
        r3.o = false;
        r3.p = false;
        r3.q = false;
        r3.r = false;
        r3.s = false;
        r3.t = null;
        r3.E = null;
        r3.F = null;
        r3.G = false;
        r3.u = false;
        r3.v = null;
        r3.w = false;
        r3.x = false;
        r3.y = null;
        r3.B = null;
        r3.C = null;
        r3.D = false;
        r3.z = false;
        r3.A = false;
        return r3;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface r2) {
        Intrinsics.f(r2, "dialog");
        super.onDismiss(r2);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r2, Bundle r3) {
        Intrinsics.f(r2, "view");
        super.onViewCreated(r2, r3);
        Dialog r4 = getDialog();
        if (r4 == null) goto L6;
        r4.setOnShowListener(new AnonymousClass1(this));
        return;
    }
}
