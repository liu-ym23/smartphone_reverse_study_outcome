package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class TabletSearchbarBinding implements ViewBinding {
    public final ImageView btnClearSearch;
    private final View rootView;
    public final EditText search;

    private TabletSearchbarBinding(View r1, ImageView r2, EditText r3) {
        this.rootView = r1;
        this.btnClearSearch = r2;
        this.search = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static TabletSearchbarBinding inflate(LayoutInflater r1, ViewGroup r2) {
        if (r2 == null) goto L6;
        r1.inflate(R.layout.tablet_searchbar, r2);
        return bind(r2);
    L6:
        throw new NullPointerException("parent");
    }

    public static TabletSearchbarBinding bind(View r3) {
        int r0 = R.id.btn_clear_search;
        ImageView r1 = (ImageView) ViewBindings.findChildViewById(r3, R.id.btn_clear_search);
        if (r1 == null) goto L9;
        r0 = R.id.search;
        EditText r2 = (EditText) ViewBindings.findChildViewById(r3, R.id.search);
        if (r2 == null) goto L9;
        return new TabletSearchbarBinding(r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
