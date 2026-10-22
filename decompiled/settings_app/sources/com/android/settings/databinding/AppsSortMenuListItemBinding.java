package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class AppsSortMenuListItemBinding implements ViewBinding {
    private final RelativeLayout rootView;
    public final TextView sortType;
    public final ImageView sortTypeIcon;
    public final ImageView sortTypeSelected;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private AppsSortMenuListItemBinding(RelativeLayout r1, TextView r2, ImageView r3, ImageView r4) {
        this.rootView = r1;
        this.sortType = r2;
        this.sortTypeIcon = r3;
        this.sortTypeSelected = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static AppsSortMenuListItemBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static AppsSortMenuListItemBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.apps_sort_menu_list_item, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static AppsSortMenuListItemBinding bind(View r4) {
        int r0 = R.id.sort_type;
        TextView r1 = (TextView) ViewBindings.findChildViewById(r4, R.id.sort_type);
        if (r1 == null) goto L11;
        r0 = R.id.sort_type_icon;
        ImageView r2 = (ImageView) ViewBindings.findChildViewById(r4, R.id.sort_type_icon);
        if (r2 == null) goto L11;
        r0 = R.id.sort_type_selected;
        ImageView r3 = (ImageView) ViewBindings.findChildViewById(r4, R.id.sort_type_selected);
        if (r3 == null) goto L11;
        return new AppsSortMenuListItemBinding((RelativeLayout) r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
