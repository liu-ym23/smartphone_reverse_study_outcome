package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.android.internal.widget.DialogTitle;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class UserSelectTitleBinding implements ViewBinding {
    private final DialogTitle rootView;
    public final DialogTitle title;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return m424getRoot();
    }

    private UserSelectTitleBinding(DialogTitle r1, DialogTitle r2) {
        this.rootView = r1;
        this.title = r2;
    }

    /* JADX INFO: renamed from: getRoot, reason: collision with other method in class */
    public DialogTitle m424getRoot() {
        return this.rootView;
    }

    public static UserSelectTitleBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static UserSelectTitleBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.user_select_title, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static UserSelectTitleBinding bind(View r1) {
        if (r1 == null) goto L6;
        DialogTitle r2 = (DialogTitle) r1;
        return new UserSelectTitleBinding(r2, r2);
    L6:
        throw new NullPointerException("rootView");
    }
}
