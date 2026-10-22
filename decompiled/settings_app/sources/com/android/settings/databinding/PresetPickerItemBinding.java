package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.internal.widget.SubtitleView;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class PresetPickerItemBinding implements ViewBinding {
    public final SubtitleView preview;
    private final LinearLayout rootView;
    public final TextView summary;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private PresetPickerItemBinding(LinearLayout r1, SubtitleView r2, TextView r3) {
        this.rootView = r1;
        this.preview = r2;
        this.summary = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static PresetPickerItemBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static PresetPickerItemBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.preset_picker_item, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static PresetPickerItemBinding bind(View r3) {
        int r0 = R.id.preview;
        SubtitleView r1 = ViewBindings.findChildViewById(r3, R.id.preview);
        if (r1 == null) goto L9;
        r0 = R.id.summary;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r3, R.id.summary);
        if (r2 == null) goto L9;
        return new PresetPickerItemBinding((LinearLayout) r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
