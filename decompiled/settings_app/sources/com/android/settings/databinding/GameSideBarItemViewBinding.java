package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import obric.widget.ListContentItemText;

/* JADX INFO: loaded from: classes2.dex */
public final class GameSideBarItemViewBinding implements ViewBinding {
    public final ImageView dragHandle;
    public final ListContentItemText dropContentView;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private GameSideBarItemViewBinding(LinearLayout r1, ImageView r2, ListContentItemText r3) {
        this.rootView = r1;
        this.dragHandle = r2;
        this.dropContentView = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static GameSideBarItemViewBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static GameSideBarItemViewBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.game_side_bar_item_view, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static GameSideBarItemViewBinding bind(View r3) {
        int r0 = R.id.drag_handle;
        ImageView r1 = (ImageView) ViewBindings.findChildViewById(r3, R.id.drag_handle);
        if (r1 == null) goto L9;
        r0 = R.id.drop_content_view;
        ListContentItemText r2 = (ListContentItemText) ViewBindings.findChildViewById(r3, R.id.drop_content_view);
        if (r2 == null) goto L9;
        return new GameSideBarItemViewBinding((LinearLayout) r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
