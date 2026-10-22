package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import androidx.viewbinding.ViewBinding;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class PreferenceWidgetRadiobuttonBinding implements ViewBinding {
    public final RadioButton checkbox;
    private final RadioButton rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private PreferenceWidgetRadiobuttonBinding(RadioButton r1, RadioButton r2) {
        this.rootView = r1;
        this.checkbox = r2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RadioButton getRoot() {
        return this.rootView;
    }

    public static PreferenceWidgetRadiobuttonBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static PreferenceWidgetRadiobuttonBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.preference_widget_radiobutton, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static PreferenceWidgetRadiobuttonBinding bind(View r1) {
        if (r1 == null) goto L6;
        RadioButton r2 = (RadioButton) r1;
        return new PreferenceWidgetRadiobuttonBinding(r2, r2);
    L6:
        throw new NullPointerException("rootView");
    }
}
