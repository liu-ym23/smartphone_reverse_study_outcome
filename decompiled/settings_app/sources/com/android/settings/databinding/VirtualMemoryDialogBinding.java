package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.internal.widget.DialogTitle;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class VirtualMemoryDialogBinding implements ViewBinding {
    public final DialogTitle alertTitle;
    public final LinearLayout buttonPanel;
    public final CheckBox checkbox;
    public final LinearLayout checkboxLayout;
    public final LinearLayout contentPanel;
    public final Button disable;
    public final Button enable;
    public final ImageView icon;
    public final TextView message;
    public final LinearLayout parentPanel;
    private final LinearLayout rootView;
    public final LinearLayout titleTemplate;
    public final LinearLayout topPanel;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private VirtualMemoryDialogBinding(LinearLayout r1, DialogTitle r2, LinearLayout r3, CheckBox r4, LinearLayout r5, LinearLayout r6, Button r7, Button r8, ImageView r9, TextView r10, LinearLayout r11, LinearLayout r12, LinearLayout r13) {
        this.rootView = r1;
        this.alertTitle = r2;
        this.buttonPanel = r3;
        this.checkbox = r4;
        this.checkboxLayout = r5;
        this.contentPanel = r6;
        this.disable = r7;
        this.enable = r8;
        this.icon = r9;
        this.message = r10;
        this.parentPanel = r11;
        this.titleTemplate = r12;
        this.topPanel = r13;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static VirtualMemoryDialogBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static VirtualMemoryDialogBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.virtual_memory_dialog, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static VirtualMemoryDialogBinding bind(View r17) {
        int r1 = R.id.alertTitle;
        DialogTitle r5 = ViewBindings.findChildViewById(r17, R.id.alertTitle);
        if (r5 == null) goto L27;
        r1 = R.id.buttonPanel;
        LinearLayout r6 = (LinearLayout) ViewBindings.findChildViewById(r17, R.id.buttonPanel);
        if (r6 == null) goto L27;
        r1 = R.id.checkbox;
        CheckBox r7 = (CheckBox) ViewBindings.findChildViewById(r17, R.id.checkbox);
        if (r7 == null) goto L27;
        r1 = R.id.checkbox_layout;
        LinearLayout r8 = (LinearLayout) ViewBindings.findChildViewById(r17, R.id.checkbox_layout);
        if (r8 == null) goto L27;
        r1 = R.id.contentPanel;
        LinearLayout r9 = (LinearLayout) ViewBindings.findChildViewById(r17, R.id.contentPanel);
        if (r9 == null) goto L27;
        r1 = R.id.disable;
        Button r10 = (Button) ViewBindings.findChildViewById(r17, R.id.disable);
        if (r10 == null) goto L27;
        r1 = R.id.enable;
        Button r11 = (Button) ViewBindings.findChildViewById(r17, R.id.enable);
        if (r11 == null) goto L27;
        r1 = R.id.icon;
        ImageView r12 = (ImageView) ViewBindings.findChildViewById(r17, R.id.icon);
        if (r12 == null) goto L27;
        r1 = R.id.message;
        TextView r13 = (TextView) ViewBindings.findChildViewById(r17, R.id.message);
        if (r13 == null) goto L27;
        LinearLayout r14 = (LinearLayout) r17;
        r1 = R.id.title_template;
        LinearLayout r15 = (LinearLayout) ViewBindings.findChildViewById(r17, R.id.title_template);
        if (r15 == null) goto L27;
        r1 = R.id.topPanel;
        LinearLayout r16 = (LinearLayout) ViewBindings.findChildViewById(r17, R.id.topPanel);
        if (r16 == null) goto L27;
        return new VirtualMemoryDialogBinding(r14, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16);
    L27:
        throw new NullPointerException("Missing required view with ID: ".concat(r17.getResources().getResourceName(r1)));
    }
}
