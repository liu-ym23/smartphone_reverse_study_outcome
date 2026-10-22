package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.internal.widget.SubtitleView;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class CaptioningPreviewBinding implements ViewBinding {
    public final SubtitleView previewText;
    public final FrameLayout previewViewport;
    public final FrameLayout previewWindow;
    public final FrameLayout propertiesFragment;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private CaptioningPreviewBinding(LinearLayout r1, SubtitleView r2, FrameLayout r3, FrameLayout r4, FrameLayout r5) {
        this.rootView = r1;
        this.previewText = r2;
        this.previewViewport = r3;
        this.previewWindow = r4;
        this.propertiesFragment = r5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static CaptioningPreviewBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static CaptioningPreviewBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.captioning_preview, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static CaptioningPreviewBinding bind(View r8) {
        int r0 = R.id.preview_text;
        SubtitleView r4 = ViewBindings.findChildViewById(r8, R.id.preview_text);
        if (r4 == null) goto L13;
        r0 = R.id.preview_viewport;
        FrameLayout r5 = (FrameLayout) ViewBindings.findChildViewById(r8, R.id.preview_viewport);
        if (r5 == null) goto L13;
        r0 = R.id.preview_window;
        FrameLayout r6 = (FrameLayout) ViewBindings.findChildViewById(r8, R.id.preview_window);
        if (r6 == null) goto L13;
        r0 = R.id.properties_fragment;
        FrameLayout r7 = (FrameLayout) ViewBindings.findChildViewById(r8, R.id.properties_fragment);
        if (r7 == null) goto L13;
        return new CaptioningPreviewBinding((LinearLayout) r8, r4, r5, r6, r7);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r0)));
    }
}
