package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.widget.SettingItemButton;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import obric.widget.SettingItemText;

/* JADX INFO: loaded from: classes2.dex */
public final class SendPasswordLayoutBinding implements ViewBinding {
    public final EditText captchaInput;
    public final ImageView catpcha;
    public final SettingItemText emailAddress;
    public final LinearLayout keyboardObserverLayout;
    public final ImageView refresh;
    public final RelativeLayout rootView;
    private final RelativeLayout rootView_;
    public final OScrollView scrollView;
    public final SettingItemButton sendBtn;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private SendPasswordLayoutBinding(RelativeLayout r1, EditText r2, ImageView r3, SettingItemText r4, LinearLayout r5, ImageView r6, RelativeLayout r7, OScrollView r8, SettingItemButton r9, OFloatingTitleBar r10) {
        this.rootView_ = r1;
        this.captchaInput = r2;
        this.catpcha = r3;
        this.emailAddress = r4;
        this.keyboardObserverLayout = r5;
        this.refresh = r6;
        this.rootView = r7;
        this.scrollView = r8;
        this.sendBtn = r9;
        this.viewTitle = r10;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView_;
    }

    public static SendPasswordLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static SendPasswordLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.send_password_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static SendPasswordLayoutBinding bind(View r13) {
        int r0 = R.id.captcha_input;
        EditText r4 = (EditText) ViewBindings.findChildViewById(r13, R.id.captcha_input);
        if (r4 == null) goto L21;
        r0 = R.id.catpcha;
        ImageView r5 = (ImageView) ViewBindings.findChildViewById(r13, R.id.catpcha);
        if (r5 == null) goto L21;
        r0 = R.id.email_address;
        SettingItemText r6 = (SettingItemText) ViewBindings.findChildViewById(r13, R.id.email_address);
        if (r6 == null) goto L21;
        r0 = R.id.keyboard_observer_layout;
        LinearLayout r7 = (LinearLayout) ViewBindings.findChildViewById(r13, R.id.keyboard_observer_layout);
        if (r7 == null) goto L21;
        r0 = R.id.refresh;
        ImageView r8 = (ImageView) ViewBindings.findChildViewById(r13, R.id.refresh);
        if (r8 == null) goto L21;
        RelativeLayout r9 = (RelativeLayout) r13;
        r0 = R.id.scroll_view;
        OScrollView r10 = (OScrollView) ViewBindings.findChildViewById(r13, R.id.scroll_view);
        if (r10 == null) goto L21;
        r0 = R.id.send_btn;
        SettingItemButton r11 = (SettingItemButton) ViewBindings.findChildViewById(r13, R.id.send_btn);
        if (r11 == null) goto L21;
        r0 = R.id.view_title;
        OFloatingTitleBar r12 = (OFloatingTitleBar) ViewBindings.findChildViewById(r13, R.id.view_title);
        if (r12 == null) goto L21;
        return new SendPasswordLayoutBinding(r9, r4, r5, r6, r7, r8, r9, r10, r11, r12);
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(r13.getResources().getResourceName(r0)));
    }
}
