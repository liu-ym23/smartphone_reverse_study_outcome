package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.widget.SlideListView;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class StoragePathLayoutBinding implements ViewBinding {
    public final BottomBarBinding idBottomBar;
    public final SlideListView listView;
    private final RelativeLayout rootView;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private StoragePathLayoutBinding(RelativeLayout r1, BottomBarBinding r2, SlideListView r3, OFloatingTitleBar r4) {
        this.rootView = r1;
        this.idBottomBar = r2;
        this.listView = r3;
        this.viewTitle = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static StoragePathLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static StoragePathLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.storage_path_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static StoragePathLayoutBinding bind(View r4) {
        int r0 = R.id.id_bottom_bar;
        View r1 = ViewBindings.findChildViewById(r4, R.id.id_bottom_bar);
        if (r1 == null) goto L12;
        BottomBarBinding r2 = BottomBarBinding.bind(r1);
        int r3 = R.id.listView;
        SlideListView r5 = (SlideListView) ViewBindings.findChildViewById(r4, R.id.listView);
        if (r5 == null) goto L10;
        r3 = R.id.view_title;
        OFloatingTitleBar r6 = (OFloatingTitleBar) ViewBindings.findChildViewById(r4, R.id.view_title);
        if (r6 == null) goto L10;
        return new StoragePathLayoutBinding((RelativeLayout) r4, r2, r5, r6);
    L10:
        r0 = r3;
    L12:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
