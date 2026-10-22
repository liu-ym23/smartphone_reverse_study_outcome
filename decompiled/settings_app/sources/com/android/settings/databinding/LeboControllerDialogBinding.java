package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.bouncelayout.OScrollView;

/* JADX INFO: loaded from: classes2.dex */
public final class LeboControllerDialogBinding implements ViewBinding {
    public final FrameLayout mediaRouteControlFrame;
    public final LinearLayout mediaRouteVolumeLayout;
    public final SeekBar mediaRouteVolumeSlider;
    private final OScrollView rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private LeboControllerDialogBinding(OScrollView r1, FrameLayout r2, LinearLayout r3, SeekBar r4) {
        this.rootView = r1;
        this.mediaRouteControlFrame = r2;
        this.mediaRouteVolumeLayout = r3;
        this.mediaRouteVolumeSlider = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public OScrollView getRoot() {
        return this.rootView;
    }

    public static LeboControllerDialogBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static LeboControllerDialogBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.lebo_controller_dialog, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static LeboControllerDialogBinding bind(View r4) {
        int r0 = R.id.media_route_control_frame;
        FrameLayout r1 = (FrameLayout) ViewBindings.findChildViewById(r4, R.id.media_route_control_frame);
        if (r1 == null) goto L11;
        r0 = R.id.media_route_volume_layout;
        LinearLayout r2 = (LinearLayout) ViewBindings.findChildViewById(r4, R.id.media_route_volume_layout);
        if (r2 == null) goto L11;
        r0 = R.id.media_route_volume_slider;
        SeekBar r3 = (SeekBar) ViewBindings.findChildViewById(r4, R.id.media_route_volume_slider);
        if (r3 == null) goto L11;
        return new LeboControllerDialogBinding((OScrollView) r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
