package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class PreferenceDialogSeekbarMaterialBinding implements ViewBinding {
    public final ImageView icon;
    private final LinearLayout rootView;
    public final SeekBar seekbar;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private PreferenceDialogSeekbarMaterialBinding(LinearLayout r1, ImageView r2, SeekBar r3) {
        this.rootView = r1;
        this.icon = r2;
        this.seekbar = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static PreferenceDialogSeekbarMaterialBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static PreferenceDialogSeekbarMaterialBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.preference_dialog_seekbar_material, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static PreferenceDialogSeekbarMaterialBinding bind(View r3) {
        int r0 = android.R.id.icon;
        ImageView r1 = (ImageView) ViewBindings.findChildViewById(r3, android.R.id.icon);
        if (r1 == null) goto L9;
        r0 = R.id.seekbar;
        SeekBar r2 = (SeekBar) ViewBindings.findChildViewById(r3, R.id.seekbar);
        if (r2 == null) goto L9;
        return new PreferenceDialogSeekbarMaterialBinding((LinearLayout) r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
