package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import androidx.viewbinding.ViewBinding;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class WifiSetupListItemSingleChoiceBinding implements ViewBinding {
    private final CheckedTextView rootView;
    public final CheckedTextView text1;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private WifiSetupListItemSingleChoiceBinding(CheckedTextView r1, CheckedTextView r2) {
        this.rootView = r1;
        this.text1 = r2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CheckedTextView getRoot() {
        return this.rootView;
    }

    public static WifiSetupListItemSingleChoiceBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static WifiSetupListItemSingleChoiceBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.wifi_setup_list_item_single_choice, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static WifiSetupListItemSingleChoiceBinding bind(View r1) {
        if (r1 == null) goto L6;
        CheckedTextView r2 = (CheckedTextView) r1;
        return new WifiSetupListItemSingleChoiceBinding(r2, r2);
    L6:
        throw new NullPointerException("rootView");
    }
}
