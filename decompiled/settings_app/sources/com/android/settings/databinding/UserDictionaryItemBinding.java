package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class UserDictionaryItemBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final TextView text1;
    public final TextView text2;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private UserDictionaryItemBinding(LinearLayout r1, TextView r2, TextView r3) {
        this.rootView = r1;
        this.text1 = r2;
        this.text2 = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static UserDictionaryItemBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static UserDictionaryItemBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.user_dictionary_item, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static UserDictionaryItemBinding bind(View r3) {
        int r0 = android.R.id.text1;
        TextView r1 = (TextView) ViewBindings.findChildViewById(r3, android.R.id.text1);
        if (r1 == null) goto L9;
        r0 = android.R.id.text2;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r3, android.R.id.text2);
        if (r2 == null) goto L9;
        return new UserDictionaryItemBinding((LinearLayout) r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
