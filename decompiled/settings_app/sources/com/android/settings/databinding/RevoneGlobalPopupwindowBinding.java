package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class RevoneGlobalPopupwindowBinding implements ViewBinding {
    public final FrameLayout revonePopupwindowContent;
    public final ImageView revonePopupwindowDialogArrowDown;
    public final ImageView revonePopupwindowDialogArrowUp;
    private final RelativeLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private RevoneGlobalPopupwindowBinding(RelativeLayout r1, FrameLayout r2, ImageView r3, ImageView r4) {
        this.rootView = r1;
        this.revonePopupwindowContent = r2;
        this.revonePopupwindowDialogArrowDown = r3;
        this.revonePopupwindowDialogArrowUp = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static RevoneGlobalPopupwindowBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static RevoneGlobalPopupwindowBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.revone_global_popupwindow, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static RevoneGlobalPopupwindowBinding bind(View r4) {
        int r0 = R.id.revone_popupwindow_content;
        FrameLayout r1 = (FrameLayout) ViewBindings.findChildViewById(r4, R.id.revone_popupwindow_content);
        if (r1 == null) goto L11;
        r0 = R.id.revone_popupwindow_dialog_arrow_down;
        ImageView r2 = (ImageView) ViewBindings.findChildViewById(r4, R.id.revone_popupwindow_dialog_arrow_down);
        if (r2 == null) goto L11;
        r0 = R.id.revone_popupwindow_dialog_arrow_up;
        ImageView r3 = (ImageView) ViewBindings.findChildViewById(r4, R.id.revone_popupwindow_dialog_arrow_up);
        if (r3 == null) goto L11;
        return new RevoneGlobalPopupwindowBinding((RelativeLayout) r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
