package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class DictWordItemBinding implements ViewBinding {
    public final ImageView delete;
    private final LinearLayout rootView;
    public final TextView word;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private DictWordItemBinding(LinearLayout r1, ImageView r2, TextView r3) {
        this.rootView = r1;
        this.delete = r2;
        this.word = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DictWordItemBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static DictWordItemBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.dict_word_item, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static DictWordItemBinding bind(View r3) {
        int r0 = R.id.delete;
        ImageView r1 = (ImageView) ViewBindings.findChildViewById(r3, R.id.delete);
        if (r1 == null) goto L9;
        r0 = R.id.word;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r3, R.id.word);
        if (r2 == null) goto L9;
        return new DictWordItemBinding((LinearLayout) r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
