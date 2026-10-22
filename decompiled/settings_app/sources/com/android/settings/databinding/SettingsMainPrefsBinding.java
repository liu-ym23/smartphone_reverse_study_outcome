package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.widget.SwitchBar;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class SettingsMainPrefsBinding implements ViewBinding {
    public final Button backButton;
    public final RelativeLayout buttonBar;
    public final FrameLayout mainContent;
    public final Button nextButton;
    private final LinearLayout rootView;
    public final Button skipButton;
    public final SwitchBar switchBar;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private SettingsMainPrefsBinding(LinearLayout r1, Button r2, RelativeLayout r3, FrameLayout r4, Button r5, Button r6, SwitchBar r7, OFloatingTitleBar r8) {
        this.rootView = r1;
        this.backButton = r2;
        this.buttonBar = r3;
        this.mainContent = r4;
        this.nextButton = r5;
        this.skipButton = r6;
        this.switchBar = r7;
        this.viewTitle = r8;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static SettingsMainPrefsBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static SettingsMainPrefsBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.settings_main_prefs, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static SettingsMainPrefsBinding bind(View r11) {
        int r0 = R.id.back_button;
        Button r4 = (Button) ViewBindings.findChildViewById(r11, R.id.back_button);
        if (r4 == null) goto L19;
        r0 = R.id.button_bar;
        RelativeLayout r5 = (RelativeLayout) ViewBindings.findChildViewById(r11, R.id.button_bar);
        if (r5 == null) goto L19;
        r0 = R.id.main_content;
        FrameLayout r6 = (FrameLayout) ViewBindings.findChildViewById(r11, R.id.main_content);
        if (r6 == null) goto L19;
        r0 = R.id.next_button;
        Button r7 = (Button) ViewBindings.findChildViewById(r11, R.id.next_button);
        if (r7 == null) goto L19;
        r0 = R.id.skip_button;
        Button r8 = (Button) ViewBindings.findChildViewById(r11, R.id.skip_button);
        if (r8 == null) goto L19;
        r0 = R.id.switch_bar;
        SwitchBar r9 = (SwitchBar) ViewBindings.findChildViewById(r11, R.id.switch_bar);
        if (r9 == null) goto L19;
        r0 = R.id.view_title;
        OFloatingTitleBar r10 = (OFloatingTitleBar) ViewBindings.findChildViewById(r11, R.id.view_title);
        if (r10 == null) goto L19;
        return new SettingsMainPrefsBinding((LinearLayout) r11, r4, r5, r6, r7, r8, r9, r10);
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r0)));
    }
}
