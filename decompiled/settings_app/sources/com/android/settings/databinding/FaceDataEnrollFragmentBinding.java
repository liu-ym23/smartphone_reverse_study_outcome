package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.button.OButton;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class FaceDataEnrollFragmentBinding implements ViewBinding {
    public final OButton enrollStart;
    public final FrameLayout frameLayout;
    private final RelativeLayout rootView;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private FaceDataEnrollFragmentBinding(RelativeLayout r1, OButton r2, FrameLayout r3, OFloatingTitleBar r4) {
        this.rootView = r1;
        this.enrollStart = r2;
        this.frameLayout = r3;
        this.viewTitle = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FaceDataEnrollFragmentBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static FaceDataEnrollFragmentBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.face_data_enroll_fragment, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static FaceDataEnrollFragmentBinding bind(View r4) {
        int r0 = R.id.enroll_start;
        OButton r1 = (OButton) ViewBindings.findChildViewById(r4, R.id.enroll_start);
        if (r1 == null) goto L11;
        r0 = R.id.frame_layout;
        FrameLayout r2 = (FrameLayout) ViewBindings.findChildViewById(r4, R.id.frame_layout);
        if (r2 == null) goto L11;
        r0 = R.id.view_title;
        OFloatingTitleBar r3 = (OFloatingTitleBar) ViewBindings.findChildViewById(r4, R.id.view_title);
        if (r3 == null) goto L11;
        return new FaceDataEnrollFragmentBinding((RelativeLayout) r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
