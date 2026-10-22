package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class ForceTouchAnimLayoutBinding implements ViewBinding {
    public final ImageView circle;
    public final ImageView hand;
    public final ImageView layer1;
    public final ImageView layer2;
    private final RelativeLayout rootView;
    public final ImageView tool1;
    public final ImageView tool2;
    public final ImageView tool3;
    public final ImageView tool4;
    public final ImageView tool5;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ForceTouchAnimLayoutBinding(RelativeLayout r1, ImageView r2, ImageView r3, ImageView r4, ImageView r5, ImageView r6, ImageView r7, ImageView r8, ImageView r9, ImageView r10) {
        this.rootView = r1;
        this.circle = r2;
        this.hand = r3;
        this.layer1 = r4;
        this.layer2 = r5;
        this.tool1 = r6;
        this.tool2 = r7;
        this.tool3 = r8;
        this.tool4 = r9;
        this.tool5 = r10;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ForceTouchAnimLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ForceTouchAnimLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.force_touch_anim_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ForceTouchAnimLayoutBinding bind(View r13) {
        int r0 = R.id.circle;
        ImageView r4 = (ImageView) ViewBindings.findChildViewById(r13, R.id.circle);
        if (r4 == null) goto L23;
        r0 = R.id.hand;
        ImageView r5 = (ImageView) ViewBindings.findChildViewById(r13, R.id.hand);
        if (r5 == null) goto L23;
        r0 = R.id.layer_1;
        ImageView r6 = (ImageView) ViewBindings.findChildViewById(r13, R.id.layer_1);
        if (r6 == null) goto L23;
        r0 = R.id.layer_2;
        ImageView r7 = (ImageView) ViewBindings.findChildViewById(r13, R.id.layer_2);
        if (r7 == null) goto L23;
        r0 = R.id.tool_1;
        ImageView r8 = (ImageView) ViewBindings.findChildViewById(r13, R.id.tool_1);
        if (r8 == null) goto L23;
        r0 = R.id.tool_2;
        ImageView r9 = (ImageView) ViewBindings.findChildViewById(r13, R.id.tool_2);
        if (r9 == null) goto L23;
        r0 = R.id.tool_3;
        ImageView r10 = (ImageView) ViewBindings.findChildViewById(r13, R.id.tool_3);
        if (r10 == null) goto L23;
        r0 = R.id.tool_4;
        ImageView r11 = (ImageView) ViewBindings.findChildViewById(r13, R.id.tool_4);
        if (r11 == null) goto L23;
        r0 = R.id.tool_5;
        ImageView r12 = (ImageView) ViewBindings.findChildViewById(r13, R.id.tool_5);
        if (r12 == null) goto L23;
        return new ForceTouchAnimLayoutBinding((RelativeLayout) r13, r4, r5, r6, r7, r8, r9, r10, r11, r12);
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(r13.getResources().getResourceName(r0)));
    }
}
