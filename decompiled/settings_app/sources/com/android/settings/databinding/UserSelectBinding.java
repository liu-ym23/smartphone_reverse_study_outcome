package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.internal.widget.RecyclerView;
import com.android.settings.R;
import com.obric.oui.bouncelayout.OScrollView;

/* JADX INFO: loaded from: classes2.dex */
public final class UserSelectBinding implements ViewBinding {
    public final RecyclerView list;
    private final OScrollView rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private UserSelectBinding(OScrollView r1, RecyclerView r2) {
        this.rootView = r1;
        this.list = r2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public OScrollView getRoot() {
        return this.rootView;
    }

    public static UserSelectBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static UserSelectBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.user_select, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static UserSelectBinding bind(View r2) {
        RecyclerView r1 = ViewBindings.findChildViewById(r2, R.id.list);
        if (r1 == null) goto L7;
        return new UserSelectBinding((OScrollView) r2, r1);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(R.id.list)));
    }
}
