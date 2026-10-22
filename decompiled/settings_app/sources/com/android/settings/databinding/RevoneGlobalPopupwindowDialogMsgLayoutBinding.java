package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import obric.tablet.widget.BytedanceJustifyTextView;
import obric.tablet.widget.BytedanceMaxScrollView;

/* JADX INFO: loaded from: classes2.dex */
public final class RevoneGlobalPopupwindowDialogMsgLayoutBinding implements ViewBinding {
    public final BytedanceJustifyTextView revonePopupwindowDialogMessage;
    public final BytedanceMaxScrollView revonePopupwindowDialogScrollView;
    private final BytedanceMaxScrollView rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private RevoneGlobalPopupwindowDialogMsgLayoutBinding(BytedanceMaxScrollView r1, BytedanceJustifyTextView r2, BytedanceMaxScrollView r3) {
        this.rootView = r1;
        this.revonePopupwindowDialogMessage = r2;
        this.revonePopupwindowDialogScrollView = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public BytedanceMaxScrollView getRoot() {
        return this.rootView;
    }

    public static RevoneGlobalPopupwindowDialogMsgLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static RevoneGlobalPopupwindowDialogMsgLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.revone_global_popupwindow_dialog_msg_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static RevoneGlobalPopupwindowDialogMsgLayoutBinding bind(View r2) {
        BytedanceJustifyTextView r1 = (BytedanceJustifyTextView) ViewBindings.findChildViewById(r2, R.id.revone_popupwindow_dialog_message);
        if (r1 == null) goto L7;
        BytedanceMaxScrollView r3 = (BytedanceMaxScrollView) r2;
        return new RevoneGlobalPopupwindowDialogMsgLayoutBinding(r3, r1, r3);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(R.id.revone_popupwindow_dialog_message)));
    }
}
