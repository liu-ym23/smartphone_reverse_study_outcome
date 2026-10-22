package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class RestrictedPreferenceUserDeleteWidgetBinding implements ViewBinding {
    public final View dividerDelete;
    public final View dividerManage;
    public final ImageView manageUser;
    private final View rootView;
    public final ImageView trashUser;
    public final LinearLayout userDeleteWidget;

    private RestrictedPreferenceUserDeleteWidgetBinding(View r1, View r2, View r3, ImageView r4, ImageView r5, LinearLayout r6) {
        this.rootView = r1;
        this.dividerDelete = r2;
        this.dividerManage = r3;
        this.manageUser = r4;
        this.trashUser = r5;
        this.userDeleteWidget = r6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static RestrictedPreferenceUserDeleteWidgetBinding inflate(LayoutInflater r1, ViewGroup r2) {
        if (r2 == null) goto L6;
        r1.inflate(R.layout.restricted_preference_user_delete_widget, r2);
        return bind(r2);
    L6:
        throw new NullPointerException("parent");
    }

    public static RestrictedPreferenceUserDeleteWidgetBinding bind(View r8) {
        int r0 = R.id.divider_delete;
        View r3 = ViewBindings.findChildViewById(r8, R.id.divider_delete);
        if (r3 == null) goto L15;
        r0 = R.id.divider_manage;
        View r4 = ViewBindings.findChildViewById(r8, R.id.divider_manage);
        if (r4 == null) goto L15;
        r0 = R.id.manage_user;
        ImageView r5 = (ImageView) ViewBindings.findChildViewById(r8, R.id.manage_user);
        if (r5 == null) goto L15;
        r0 = R.id.trash_user;
        ImageView r6 = (ImageView) ViewBindings.findChildViewById(r8, R.id.trash_user);
        if (r6 == null) goto L15;
        r0 = R.id.user_delete_widget;
        LinearLayout r7 = (LinearLayout) ViewBindings.findChildViewById(r8, R.id.user_delete_widget);
        if (r7 == null) goto L15;
        return new RestrictedPreferenceUserDeleteWidgetBinding(r8, r3, r4, r5, r6, r7);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r0)));
    }
}
