package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.button.OButton;
import com.obric.oui.button.OIconButton;

/* JADX INFO: loaded from: classes2.dex */
public final class ActivityBaseFaceBinding implements ViewBinding {
    public final ImageView assistantImg;
    public final TextView assistantSubtitle;
    public final FrameLayout assistantSubtitleContainer;
    public final TextView assistantTitle;
    public final RelativeLayout bottomActionBar;
    public final OButton bottomButton;
    public final FrameLayout contentFrame;
    public final RelativeLayout rootView;
    private final RelativeLayout rootView_;
    public final OIconButton titlebarBackBtn;
    public final RelativeLayout titlebarContainer;
    public final OButton titlebarRightBtn;
    public final TextView titlebarTitleTv;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ActivityBaseFaceBinding(RelativeLayout r1, ImageView r2, TextView r3, FrameLayout r4, TextView r5, RelativeLayout r6, OButton r7, FrameLayout r8, RelativeLayout r9, OIconButton r10, RelativeLayout r11, OButton r12, TextView r13) {
        this.rootView_ = r1;
        this.assistantImg = r2;
        this.assistantSubtitle = r3;
        this.assistantSubtitleContainer = r4;
        this.assistantTitle = r5;
        this.bottomActionBar = r6;
        this.bottomButton = r7;
        this.contentFrame = r8;
        this.rootView = r9;
        this.titlebarBackBtn = r10;
        this.titlebarContainer = r11;
        this.titlebarRightBtn = r12;
        this.titlebarTitleTv = r13;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView_;
    }

    public static ActivityBaseFaceBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ActivityBaseFaceBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.activity_base_face, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ActivityBaseFaceBinding bind(View r17) {
        int r1 = R.id.assistant_img;
        ImageView r5 = (ImageView) ViewBindings.findChildViewById(r17, R.id.assistant_img);
        if (r5 == null) goto L27;
        r1 = R.id.assistant_subtitle;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r17, R.id.assistant_subtitle);
        if (r6 == null) goto L27;
        r1 = R.id.assistant_subtitle_container;
        FrameLayout r7 = (FrameLayout) ViewBindings.findChildViewById(r17, R.id.assistant_subtitle_container);
        if (r7 == null) goto L27;
        r1 = R.id.assistant_title;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r17, R.id.assistant_title);
        if (r8 == null) goto L27;
        r1 = R.id.bottom_action_bar;
        RelativeLayout r9 = (RelativeLayout) ViewBindings.findChildViewById(r17, R.id.bottom_action_bar);
        if (r9 == null) goto L27;
        r1 = R.id.bottom_button;
        OButton r10 = (OButton) ViewBindings.findChildViewById(r17, R.id.bottom_button);
        if (r10 == null) goto L27;
        r1 = R.id.content_frame;
        FrameLayout r11 = (FrameLayout) ViewBindings.findChildViewById(r17, R.id.content_frame);
        if (r11 == null) goto L27;
        RelativeLayout r12 = (RelativeLayout) r17;
        r1 = R.id.titlebar_back_btn;
        OIconButton r13 = (OIconButton) ViewBindings.findChildViewById(r17, R.id.titlebar_back_btn);
        if (r13 == null) goto L27;
        r1 = R.id.titlebar_container;
        RelativeLayout r14 = (RelativeLayout) ViewBindings.findChildViewById(r17, R.id.titlebar_container);
        if (r14 == null) goto L27;
        r1 = R.id.titlebar_right_btn;
        OButton r15 = (OButton) ViewBindings.findChildViewById(r17, R.id.titlebar_right_btn);
        if (r15 == null) goto L27;
        r1 = R.id.titlebar_title_tv;
        TextView r16 = (TextView) ViewBindings.findChildViewById(r17, R.id.titlebar_title_tv);
        if (r16 == null) goto L27;
        return new ActivityBaseFaceBinding(r12, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16);
    L27:
        throw new NullPointerException("Missing required view with ID: ".concat(r17.getResources().getResourceName(r1)));
    }
}
