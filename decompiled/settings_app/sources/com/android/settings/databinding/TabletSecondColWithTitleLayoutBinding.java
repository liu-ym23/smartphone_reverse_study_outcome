package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class TabletSecondColWithTitleLayoutBinding implements ViewBinding {
    private final View rootView;
    public final RelativeLayout secondContentParent;
    public final TabletTitlebarBinding titlebar;

    private TabletSecondColWithTitleLayoutBinding(View r1, RelativeLayout r2, TabletTitlebarBinding r3) {
        this.rootView = r1;
        this.secondContentParent = r2;
        this.titlebar = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static TabletSecondColWithTitleLayoutBinding inflate(LayoutInflater r1, ViewGroup r2) {
        if (r2 == null) goto L6;
        r1.inflate(R.layout.tablet_second_col_with_title_layout, r2);
        return bind(r2);
    L6:
        throw new NullPointerException("parent");
    }

    public static TabletSecondColWithTitleLayoutBinding bind(View r3) {
        int r0 = R.id.second_content_parent;
        RelativeLayout r1 = (RelativeLayout) ViewBindings.findChildViewById(r3, R.id.second_content_parent);
        if (r1 == null) goto L9;
        r0 = R.id.titlebar;
        View r2 = ViewBindings.findChildViewById(r3, R.id.titlebar);
        if (r2 == null) goto L9;
        return new TabletSecondColWithTitleLayoutBinding(r3, r1, TabletTitlebarBinding.bind(r2));
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
