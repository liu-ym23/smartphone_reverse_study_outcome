package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.internal.widget.DialogTitle;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class RevoneGlobalPopupwindowDialogBinding implements ViewBinding {
    public final LinearLayout buttonPanel;
    public final LinearLayout leftSpacer;
    public final LinearLayout parentPanel;
    public final Button revonePopupwindowDialogButton1;
    public final Button revonePopupwindowDialogButton2;
    public final Button revonePopupwindowDialogButton3;
    public final ImageView revonePopupwindowDialogIcon;
    public final FrameLayout revonePopupwindowDialogLayoutContent;
    public final DialogTitle revonePopupwindowDialogTitle;
    public final LinearLayout rightSpacer;
    private final LinearLayout rootView;
    public final LinearLayout titleTemplate;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private RevoneGlobalPopupwindowDialogBinding(LinearLayout r1, LinearLayout r2, LinearLayout r3, LinearLayout r4, Button r5, Button r6, Button r7, ImageView r8, FrameLayout r9, DialogTitle r10, LinearLayout r11, LinearLayout r12) {
        this.rootView = r1;
        this.buttonPanel = r2;
        this.leftSpacer = r3;
        this.parentPanel = r4;
        this.revonePopupwindowDialogButton1 = r5;
        this.revonePopupwindowDialogButton2 = r6;
        this.revonePopupwindowDialogButton3 = r7;
        this.revonePopupwindowDialogIcon = r8;
        this.revonePopupwindowDialogLayoutContent = r9;
        this.revonePopupwindowDialogTitle = r10;
        this.rightSpacer = r11;
        this.titleTemplate = r12;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static RevoneGlobalPopupwindowDialogBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static RevoneGlobalPopupwindowDialogBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.revone_global_popupwindow_dialog, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static RevoneGlobalPopupwindowDialogBinding bind(View r15) {
        int r0 = R.id.buttonPanel;
        LinearLayout r4 = (LinearLayout) ViewBindings.findChildViewById(r15, R.id.buttonPanel);
        if (r4 == null) goto L25;
        r0 = R.id.leftSpacer;
        LinearLayout r5 = (LinearLayout) ViewBindings.findChildViewById(r15, R.id.leftSpacer);
        if (r5 == null) goto L25;
        LinearLayout r6 = (LinearLayout) r15;
        r0 = R.id.revone_popupwindow_dialog_button1;
        Button r7 = (Button) ViewBindings.findChildViewById(r15, R.id.revone_popupwindow_dialog_button1);
        if (r7 == null) goto L25;
        r0 = R.id.revone_popupwindow_dialog_button2;
        Button r8 = (Button) ViewBindings.findChildViewById(r15, R.id.revone_popupwindow_dialog_button2);
        if (r8 == null) goto L25;
        r0 = R.id.revone_popupwindow_dialog_button3;
        Button r9 = (Button) ViewBindings.findChildViewById(r15, R.id.revone_popupwindow_dialog_button3);
        if (r9 == null) goto L25;
        r0 = R.id.revone_popupwindow_dialog_icon;
        ImageView r10 = (ImageView) ViewBindings.findChildViewById(r15, R.id.revone_popupwindow_dialog_icon);
        if (r10 == null) goto L25;
        r0 = R.id.revone_popupwindow_dialog_layout_content;
        FrameLayout r11 = (FrameLayout) ViewBindings.findChildViewById(r15, R.id.revone_popupwindow_dialog_layout_content);
        if (r11 == null) goto L25;
        r0 = R.id.revone_popupwindow_dialog_title;
        DialogTitle r12 = ViewBindings.findChildViewById(r15, R.id.revone_popupwindow_dialog_title);
        if (r12 == null) goto L25;
        r0 = R.id.rightSpacer;
        LinearLayout r13 = (LinearLayout) ViewBindings.findChildViewById(r15, R.id.rightSpacer);
        if (r13 == null) goto L25;
        r0 = R.id.title_template;
        LinearLayout r14 = (LinearLayout) ViewBindings.findChildViewById(r15, R.id.title_template);
        if (r14 == null) goto L25;
        return new RevoneGlobalPopupwindowDialogBinding(r6, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14);
    L25:
        throw new NullPointerException("Missing required view with ID: ".concat(r15.getResources().getResourceName(r0)));
    }
}
