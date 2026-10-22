package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class PhoneCaseKeysSettingsLayoutStubBinding implements ViewBinding {
    public final TextView idNavbarModeSettingTitle;
    public final ImageView idPhoneCasePreview;
    public final RelativeLayout idPhoneCaseShowing;
    public final TextView idTestTv1;
    public final TextView idTestTv2;
    public final TextView idTestTv3;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private PhoneCaseKeysSettingsLayoutStubBinding(LinearLayout r1, TextView r2, ImageView r3, RelativeLayout r4, TextView r5, TextView r6, TextView r7) {
        this.rootView = r1;
        this.idNavbarModeSettingTitle = r2;
        this.idPhoneCasePreview = r3;
        this.idPhoneCaseShowing = r4;
        this.idTestTv1 = r5;
        this.idTestTv2 = r6;
        this.idTestTv3 = r7;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static PhoneCaseKeysSettingsLayoutStubBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static PhoneCaseKeysSettingsLayoutStubBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.phone_case_keys_settings_layout_stub, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static PhoneCaseKeysSettingsLayoutStubBinding bind(View r10) {
        int r0 = R.id.id_navbar_mode_setting_title;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r10, R.id.id_navbar_mode_setting_title);
        if (r4 == null) goto L17;
        r0 = R.id.id_phone_case_preview;
        ImageView r5 = (ImageView) ViewBindings.findChildViewById(r10, R.id.id_phone_case_preview);
        if (r5 == null) goto L17;
        r0 = R.id.id_phone_case_showing;
        RelativeLayout r6 = (RelativeLayout) ViewBindings.findChildViewById(r10, R.id.id_phone_case_showing);
        if (r6 == null) goto L17;
        r0 = R.id.id_test_tv_1;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r10, R.id.id_test_tv_1);
        if (r7 == null) goto L17;
        r0 = R.id.id_test_tv_2;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r10, R.id.id_test_tv_2);
        if (r8 == null) goto L17;
        r0 = R.id.id_test_tv_3;
        TextView r9 = (TextView) ViewBindings.findChildViewById(r10, R.id.id_test_tv_3);
        if (r9 == null) goto L17;
        return new PhoneCaseKeysSettingsLayoutStubBinding((LinearLayout) r10, r4, r5, r6, r7, r8, r9);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r0)));
    }
}
