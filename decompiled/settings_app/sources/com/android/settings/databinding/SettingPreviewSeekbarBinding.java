package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.widget.ForceTouchSensitivityAnimView;
import obric.widget.SettingItemCheck;

/* JADX INFO: loaded from: classes2.dex */
public final class SettingPreviewSeekbarBinding implements ViewBinding {
    public final RelativeLayout animAnchorView;
    public final TextView animTipsTv;
    public final ForceTouchSensitivityAnimView forceTouchAnimView;
    public final SettingItemCheck idForceTouchPressureHeavy;
    public final SettingItemCheck idForceTouchPressureLight;
    public final SettingItemCheck idForceTouchPressureStandard;
    public final RelativeLayout idPreviewModeProgress;
    public final LinearLayout idPreviewModeSimpleItem;
    public final SeekBar idSeekbar;
    public final TextView idSeekbarCenter;
    public final TextView idSeekbarLeft;
    public final TextView idSeekbarRight;
    public final TextView idSeekbarTips;
    public final TextView idSeekbarTitle;
    private final View rootView;

    private SettingPreviewSeekbarBinding(View r1, RelativeLayout r2, TextView r3, ForceTouchSensitivityAnimView r4, SettingItemCheck r5, SettingItemCheck r6, SettingItemCheck r7, RelativeLayout r8, LinearLayout r9, SeekBar r10, TextView r11, TextView r12, TextView r13, TextView r14, TextView r15) {
        this.rootView = r1;
        this.animAnchorView = r2;
        this.animTipsTv = r3;
        this.forceTouchAnimView = r4;
        this.idForceTouchPressureHeavy = r5;
        this.idForceTouchPressureLight = r6;
        this.idForceTouchPressureStandard = r7;
        this.idPreviewModeProgress = r8;
        this.idPreviewModeSimpleItem = r9;
        this.idSeekbar = r10;
        this.idSeekbarCenter = r11;
        this.idSeekbarLeft = r12;
        this.idSeekbarRight = r13;
        this.idSeekbarTips = r14;
        this.idSeekbarTitle = r15;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static SettingPreviewSeekbarBinding inflate(LayoutInflater r1, ViewGroup r2) {
        if (r2 == null) goto L6;
        r1.inflate(R.layout.setting_preview_seekbar, r2);
        return bind(r2);
    L6:
        throw new NullPointerException("parent");
    }

    public static SettingPreviewSeekbarBinding bind(View r17) {
        int r0 = R.id.anim_anchor_view;
        RelativeLayout r2 = (RelativeLayout) ViewBindings.findChildViewById(r17, R.id.anim_anchor_view);
        if (r2 == null) goto L33;
        r0 = R.id.anim_tips_tv;
        TextView r3 = (TextView) ViewBindings.findChildViewById(r17, R.id.anim_tips_tv);
        if (r3 == null) goto L33;
        r0 = R.id.force_touch_anim_view;
        ForceTouchSensitivityAnimView r4 = (ForceTouchSensitivityAnimView) ViewBindings.findChildViewById(r17, R.id.force_touch_anim_view);
        if (r4 == null) goto L33;
        r0 = R.id.id_force_touch_pressure_heavy;
        SettingItemCheck r5 = (SettingItemCheck) ViewBindings.findChildViewById(r17, R.id.id_force_touch_pressure_heavy);
        if (r5 == null) goto L33;
        r0 = R.id.id_force_touch_pressure_light;
        SettingItemCheck r6 = (SettingItemCheck) ViewBindings.findChildViewById(r17, R.id.id_force_touch_pressure_light);
        if (r6 == null) goto L33;
        r0 = R.id.id_force_touch_pressure_standard;
        SettingItemCheck r7 = (SettingItemCheck) ViewBindings.findChildViewById(r17, R.id.id_force_touch_pressure_standard);
        if (r7 == null) goto L33;
        r0 = R.id.id_preview_mode_progress;
        RelativeLayout r8 = (RelativeLayout) ViewBindings.findChildViewById(r17, R.id.id_preview_mode_progress);
        if (r8 == null) goto L33;
        r0 = R.id.id_preview_mode_simple_item;
        LinearLayout r9 = (LinearLayout) ViewBindings.findChildViewById(r17, R.id.id_preview_mode_simple_item);
        if (r9 == null) goto L33;
        r0 = R.id.id_seekbar;
        SeekBar r10 = (SeekBar) ViewBindings.findChildViewById(r17, R.id.id_seekbar);
        if (r10 == null) goto L33;
        r0 = R.id.id_seekbar_center;
        TextView r11 = (TextView) ViewBindings.findChildViewById(r17, R.id.id_seekbar_center);
        if (r11 == null) goto L33;
        r0 = R.id.id_seekbar_left;
        TextView r12 = (TextView) ViewBindings.findChildViewById(r17, R.id.id_seekbar_left);
        if (r12 == null) goto L33;
        r0 = R.id.id_seekbar_right;
        TextView r13 = (TextView) ViewBindings.findChildViewById(r17, R.id.id_seekbar_right);
        if (r13 == null) goto L33;
        r0 = R.id.id_seekbar_tips;
        TextView r14 = (TextView) ViewBindings.findChildViewById(r17, R.id.id_seekbar_tips);
        if (r14 == null) goto L33;
        r0 = R.id.id_seekbar_title;
        TextView r15 = (TextView) ViewBindings.findChildViewById(r17, R.id.id_seekbar_title);
        if (r15 == null) goto L33;
        return new SettingPreviewSeekbarBinding(r17, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15);
    L33:
        throw new NullPointerException("Missing required view with ID: ".concat(r17.getResources().getResourceName(r0)));
    }
}
