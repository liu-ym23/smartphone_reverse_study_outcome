package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.button.OButton;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class AiPoweredFingerprintEnrollingLayoutBinding implements ViewBinding {
    public final LinearLayout buttonsLayout;
    public final OButton doneButton;
    public final OButton enrollNextFinger;
    public final FrameLayout frameLayout;
    public final OButton gotoFaceEnroll;
    public final RelativeLayout pageContainer;
    private final RelativeLayout rootView;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private AiPoweredFingerprintEnrollingLayoutBinding(RelativeLayout r1, LinearLayout r2, OButton r3, OButton r4, FrameLayout r5, OButton r6, RelativeLayout r7, OFloatingTitleBar r8) {
        this.rootView = r1;
        this.buttonsLayout = r2;
        this.doneButton = r3;
        this.enrollNextFinger = r4;
        this.frameLayout = r5;
        this.gotoFaceEnroll = r6;
        this.pageContainer = r7;
        this.viewTitle = r8;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static AiPoweredFingerprintEnrollingLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static AiPoweredFingerprintEnrollingLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.ai_powered_fingerprint_enrolling_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static AiPoweredFingerprintEnrollingLayoutBinding bind(View r11) {
        int r0 = R.id.buttons_layout;
        LinearLayout r4 = (LinearLayout) ViewBindings.findChildViewById(r11, R.id.buttons_layout);
        if (r4 == null) goto L17;
        r0 = R.id.done_button;
        OButton r5 = (OButton) ViewBindings.findChildViewById(r11, R.id.done_button);
        if (r5 == null) goto L17;
        r0 = R.id.enroll_next_finger;
        OButton r6 = (OButton) ViewBindings.findChildViewById(r11, R.id.enroll_next_finger);
        if (r6 == null) goto L17;
        r0 = R.id.frame_layout;
        FrameLayout r7 = (FrameLayout) ViewBindings.findChildViewById(r11, R.id.frame_layout);
        if (r7 == null) goto L17;
        r0 = R.id.goto_face_enroll;
        OButton r8 = (OButton) ViewBindings.findChildViewById(r11, R.id.goto_face_enroll);
        if (r8 == null) goto L17;
        RelativeLayout r9 = (RelativeLayout) r11;
        r0 = R.id.view_title;
        OFloatingTitleBar r10 = (OFloatingTitleBar) ViewBindings.findChildViewById(r11, R.id.view_title);
        if (r10 == null) goto L17;
        return new AiPoweredFingerprintEnrollingLayoutBinding(r9, r4, r5, r6, r7, r8, r9, r10);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r0)));
    }
}
