package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.bouncelayout.OScrollView;

/* JADX INFO: loaded from: classes2.dex */
public final class DeleteManagedProfileDialogBinding implements ViewBinding {
    public final TextView deleteManagedProfileClosingParagraph;
    public final TextView deleteManagedProfileDeviceManagerName;
    public final ImageView deleteManagedProfileMdmIconView;
    public final TextView deleteManagedProfileOpeningParagraph;
    private final OScrollView rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private DeleteManagedProfileDialogBinding(OScrollView r1, TextView r2, TextView r3, ImageView r4, TextView r5) {
        this.rootView = r1;
        this.deleteManagedProfileClosingParagraph = r2;
        this.deleteManagedProfileDeviceManagerName = r3;
        this.deleteManagedProfileMdmIconView = r4;
        this.deleteManagedProfileOpeningParagraph = r5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public OScrollView getRoot() {
        return this.rootView;
    }

    public static DeleteManagedProfileDialogBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static DeleteManagedProfileDialogBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.delete_managed_profile_dialog, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static DeleteManagedProfileDialogBinding bind(View r8) {
        int r0 = R.id.delete_managed_profile_closing_paragraph;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r8, R.id.delete_managed_profile_closing_paragraph);
        if (r4 == null) goto L13;
        r0 = R.id.delete_managed_profile_device_manager_name;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r8, R.id.delete_managed_profile_device_manager_name);
        if (r5 == null) goto L13;
        r0 = R.id.delete_managed_profile_mdm_icon_view;
        ImageView r6 = (ImageView) ViewBindings.findChildViewById(r8, R.id.delete_managed_profile_mdm_icon_view);
        if (r6 == null) goto L13;
        r0 = R.id.delete_managed_profile_opening_paragraph;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r8, R.id.delete_managed_profile_opening_paragraph);
        if (r7 == null) goto L13;
        return new DeleteManagedProfileDialogBinding((OScrollView) r8, r4, r5, r6, r7);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r0)));
    }
}
