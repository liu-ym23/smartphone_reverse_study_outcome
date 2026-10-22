package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.android.settings.R;
import com.android.settings.display.AppGridView;

/* JADX INFO: loaded from: classes2.dex */
public final class ScreenZoomPreview2Binding implements ViewBinding {
    private final AppGridView rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ScreenZoomPreview2Binding(AppGridView r1) {
        this.rootView = r1;
    }

    @Override // androidx.viewbinding.ViewBinding
    public AppGridView getRoot() {
        return this.rootView;
    }

    public static ScreenZoomPreview2Binding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ScreenZoomPreview2Binding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.screen_zoom_preview_2, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ScreenZoomPreview2Binding bind(View r1) {
        if (r1 == null) goto L6;
        return new ScreenZoomPreview2Binding((AppGridView) r1);
    L6:
        throw new NullPointerException("rootView");
    }
}
