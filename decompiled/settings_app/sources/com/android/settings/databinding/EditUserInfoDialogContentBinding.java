package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class EditUserInfoDialogContentBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final EditText userName;
    public final ImageView userPhoto;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private EditUserInfoDialogContentBinding(LinearLayout r1, EditText r2, ImageView r3) {
        this.rootView = r1;
        this.userName = r2;
        this.userPhoto = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static EditUserInfoDialogContentBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static EditUserInfoDialogContentBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.edit_user_info_dialog_content, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static EditUserInfoDialogContentBinding bind(View r3) {
        int r0 = R.id.user_name;
        EditText r1 = (EditText) ViewBindings.findChildViewById(r3, R.id.user_name);
        if (r1 == null) goto L9;
        r0 = R.id.user_photo;
        ImageView r2 = (ImageView) ViewBindings.findChildViewById(r3, R.id.user_photo);
        if (r2 == null) goto L9;
        return new EditUserInfoDialogContentBinding((LinearLayout) r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
