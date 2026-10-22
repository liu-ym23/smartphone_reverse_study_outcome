package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.internal.widget.LinearLayoutWithDefaultTouchRecepient;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class ConfirmLockPasswordBaseBinding implements ViewBinding {
    public final Button cancelButton;
    public final TextView detailsText;
    public final TextView errorText;
    public final ImageView fingerprintIcon;
    public final TextView headerText;
    public final EditText passwordEntry;
    private final LinearLayoutWithDefaultTouchRecepient rootView;
    public final LinearLayoutWithDefaultTouchRecepient topLayout;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return m422getRoot();
    }

    private ConfirmLockPasswordBaseBinding(LinearLayoutWithDefaultTouchRecepient r1, Button r2, TextView r3, TextView r4, ImageView r5, TextView r6, EditText r7, LinearLayoutWithDefaultTouchRecepient r8) {
        this.rootView = r1;
        this.cancelButton = r2;
        this.detailsText = r3;
        this.errorText = r4;
        this.fingerprintIcon = r5;
        this.headerText = r6;
        this.passwordEntry = r7;
        this.topLayout = r8;
    }

    /* JADX INFO: renamed from: getRoot, reason: collision with other method in class */
    public LinearLayoutWithDefaultTouchRecepient m422getRoot() {
        return this.rootView;
    }

    public static ConfirmLockPasswordBaseBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ConfirmLockPasswordBaseBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.confirm_lock_password_base, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ConfirmLockPasswordBaseBinding bind(View r11) {
        int r0 = R.id.cancelButton;
        Button r4 = (Button) ViewBindings.findChildViewById(r11, R.id.cancelButton);
        if (r4 == null) goto L17;
        r0 = R.id.detailsText;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r11, R.id.detailsText);
        if (r5 == null) goto L17;
        r0 = R.id.errorText;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r11, R.id.errorText);
        if (r6 == null) goto L17;
        r0 = R.id.fingerprintIcon;
        ImageView r7 = (ImageView) ViewBindings.findChildViewById(r11, R.id.fingerprintIcon);
        if (r7 == null) goto L17;
        r0 = R.id.headerText;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r11, R.id.headerText);
        if (r8 == null) goto L17;
        r0 = R.id.password_entry;
        EditText r9 = (EditText) ViewBindings.findChildViewById(r11, R.id.password_entry);
        if (r9 == null) goto L17;
        LinearLayoutWithDefaultTouchRecepient r10 = (LinearLayoutWithDefaultTouchRecepient) r11;
        return new ConfirmLockPasswordBaseBinding(r10, r4, r5, r6, r7, r8, r9, r10);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r0)));
    }
}
