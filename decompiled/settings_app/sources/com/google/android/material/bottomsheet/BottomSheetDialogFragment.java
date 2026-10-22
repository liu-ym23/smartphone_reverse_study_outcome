package com.google.android.material.bottomsheet;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatDialogFragment;

/* JADX INFO: loaded from: classes3.dex */
public class BottomSheetDialogFragment extends AppCompatDialogFragment {
    private boolean waitingForDismissAllowingStateLoss;

    /* JADX INFO: renamed from: com.google.android.material.bottomsheet.BottomSheetDialogFragment$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class BottomSheetDismissCallback extends BottomSheetBehavior.BottomSheetCallback {
        final /* synthetic */ BottomSheetDialogFragment this$0;

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onSlide(View r1, float r2) {
        }

        private BottomSheetDismissCallback(BottomSheetDialogFragment r1) {
            this.this$0 = r1;
        }

        /* synthetic */ BottomSheetDismissCallback(BottomSheetDialogFragment r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onStateChanged(View r1, int r2) {
            if (r2 != 5) goto L6;
            BottomSheetDialogFragment.access$100(this.this$0);
            return;
        }
    }

    public BottomSheetDialogFragment() {
    }

    static /* synthetic */ void access$100(BottomSheetDialogFragment r0) {
        r0.dismissAfterAnimation();
    }

    @Override // androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle r2) {
        return new BottomSheetDialog(getContext(), getTheme());
    }

    @Override // androidx.fragment.app.DialogFragment
    public void dismiss() {
        if (tryDismissWithAnimation(false) == true) goto L6;
        super.dismiss();
        return;
    }

    @Override // androidx.fragment.app.DialogFragment
    public void dismissAllowingStateLoss() {
        if (tryDismissWithAnimation(true) == true) goto L6;
        super.dismissAllowingStateLoss();
        return;
    }

    private boolean tryDismissWithAnimation(boolean r4) {
        Dialog r0 = getDialog();
        if ((r0 instanceof BottomSheetDialog) == false) goto L10;
        BottomSheetDialog r1 = (BottomSheetDialog) r0;
        BottomSheetBehavior<FrameLayout> r2 = r1.getBehavior();
        if (r2.isHideable() == true) goto L7;
        return false;
    L7:
        if (r1.getDismissWithAnimation() == false) goto L13;
        dismissWithAnimation(r2, r4);
        return true;
    L13:
        return false;
    L10:
        return false;
    }

    private void dismissWithAnimation(BottomSheetBehavior<?> r3, boolean r4) {
        this.waitingForDismissAllowingStateLoss = r4;
        if (r3.getState() != 5) goto L6;
        dismissAfterAnimation();
        return;
    L6:
        if ((getDialog() instanceof BottomSheetDialog) == false) goto L8;
        ((BottomSheetDialog) getDialog()).removeDefaultCallback();
    L8:
        r3.addBottomSheetCallback(new BottomSheetDismissCallback(this, null));
        r3.setState(5);
    }

    private void dismissAfterAnimation() {
        if (this.waitingForDismissAllowingStateLoss == false) goto L5;
        super.dismissAllowingStateLoss();
        return;
    L5:
        super.dismiss();
    }
}
