package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.inputmethod.DictWordItem;

/* JADX INFO: loaded from: classes2.dex */
public final class DictWordsAdapterItemBinding implements ViewBinding {
    public final DictWordItem item0;
    public final DictWordItem item1;
    public final DictWordItem item2;
    public final DictWordItem item3;
    public final DictWordItem item4;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private DictWordsAdapterItemBinding(LinearLayout r1, DictWordItem r2, DictWordItem r3, DictWordItem r4, DictWordItem r5, DictWordItem r6) {
        this.rootView = r1;
        this.item0 = r2;
        this.item1 = r3;
        this.item2 = r4;
        this.item3 = r5;
        this.item4 = r6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DictWordsAdapterItemBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static DictWordsAdapterItemBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.dict_words_adapter_item, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static DictWordsAdapterItemBinding bind(View r9) {
        int r0 = R.id.item_0;
        DictWordItem r4 = (DictWordItem) ViewBindings.findChildViewById(r9, R.id.item_0);
        if (r4 == null) goto L15;
        r0 = R.id.item_1;
        DictWordItem r5 = (DictWordItem) ViewBindings.findChildViewById(r9, R.id.item_1);
        if (r5 == null) goto L15;
        r0 = R.id.item_2;
        DictWordItem r6 = (DictWordItem) ViewBindings.findChildViewById(r9, R.id.item_2);
        if (r6 == null) goto L15;
        r0 = R.id.item_3;
        DictWordItem r7 = (DictWordItem) ViewBindings.findChildViewById(r9, R.id.item_3);
        if (r7 == null) goto L15;
        r0 = R.id.item_4;
        DictWordItem r8 = (DictWordItem) ViewBindings.findChildViewById(r9, R.id.item_4);
        if (r8 == null) goto L15;
        return new DictWordsAdapterItemBinding((LinearLayout) r9, r4, r5, r6, r7, r8);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r9.getResources().getResourceName(r0)));
    }
}
