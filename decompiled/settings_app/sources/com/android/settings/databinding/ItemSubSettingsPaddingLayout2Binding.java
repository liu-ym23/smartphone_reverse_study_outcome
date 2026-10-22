package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class ItemSubSettingsPaddingLayout2Binding implements ViewBinding {
    private final View rootView;

    private ItemSubSettingsPaddingLayout2Binding(View r1) {
        this.rootView = r1;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static ItemSubSettingsPaddingLayout2Binding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ItemSubSettingsPaddingLayout2Binding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.item_sub_settings_padding_layout2, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ItemSubSettingsPaddingLayout2Binding bind(View r1) {
        if (r1 == null) goto L6;
        return new ItemSubSettingsPaddingLayout2Binding(r1);
    L6:
        throw new NullPointerException("rootView");
    }
}
