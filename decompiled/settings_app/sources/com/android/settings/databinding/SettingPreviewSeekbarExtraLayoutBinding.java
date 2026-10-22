package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.widget.ForceTouchSensitivityAnimView;

/* JADX INFO: loaded from: classes2.dex */
public final class SettingPreviewSeekbarExtraLayoutBinding implements ViewBinding {
    public final ForceTouchSensitivityAnimView forceTouchAnimView;
    private final RelativeLayout rootView;
    public final TextView tipsText;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private SettingPreviewSeekbarExtraLayoutBinding(RelativeLayout r1, ForceTouchSensitivityAnimView r2, TextView r3) {
        this.rootView = r1;
        this.forceTouchAnimView = r2;
        this.tipsText = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static SettingPreviewSeekbarExtraLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static SettingPreviewSeekbarExtraLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.setting_preview_seekbar_extra_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static SettingPreviewSeekbarExtraLayoutBinding bind(View r3) {
        int r0 = R.id.force_touch_anim_view;
        ForceTouchSensitivityAnimView r1 = (ForceTouchSensitivityAnimView) ViewBindings.findChildViewById(r3, R.id.force_touch_anim_view);
        if (r1 == null) goto L9;
        r0 = R.id.tips_text;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r3, R.id.tips_text);
        if (r2 == null) goto L9;
        return new SettingPreviewSeekbarExtraLayoutBinding((RelativeLayout) r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
