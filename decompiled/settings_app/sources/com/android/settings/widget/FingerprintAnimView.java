package com.android.settings.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.android.settings.R;
import com.android.settings.Utils;

/* JADX INFO: loaded from: classes.dex */
public class FingerprintAnimView extends FrameLayout {
    private AnimationDrawable mAnimDrawable;
    private ImageView mAnimView;
    private Context mContext;
    private ImageView mPhoneFrameImage;
    private ImageView mPreviewImage;
    private String[] mValues;

    public FingerprintAnimView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public FingerprintAnimView(Context r2, AttributeSet r3, int r4) {
        this(r2, r3, r4, 0);
    }

    public FingerprintAnimView(Context r1, AttributeSet r2, int r3, int r4) {
        super(r1, r2, r3, r4);
        this.mContext = r1;
        View r5 = LayoutInflater.from(r1).inflate(R.layout.fingerprint_anim_layout, this, true);
        this.mPreviewImage = (ImageView) r5.findViewById(R.id.preview_image);
        this.mPhoneFrameImage = (ImageView) r5.findViewById(R.id.phone_frame);
        this.mAnimView = (ImageView) r5.findViewById(R.id.fingerprint_anim_view);
        this.mPhoneFrameImage.setImageResource(Utils.getSpecialPhoneFrameResId());
        this.mValues = r1.getResources().getStringArray(R.array.fingerprint_anim_name);
    }

    public void setAnimation(int r5) {
        FrameLayout.LayoutParams r0 = (FrameLayout.LayoutParams) this.mAnimView.getLayoutParams();
        Resources r1 = this.mContext.getResources();
        if (r5 != 0) goto L5;
        r0.width = r1.getDimensionPixelOffset(R.dimen.fingerprint_anim_size);
        r0.height = r1.getDimensionPixelOffset(R.dimen.fingerprint_anim_size);
        this.mAnimView.setTranslationY(r1.getDimensionPixelOffset(R.dimen.fingerprint_anim_margin_top));
    L6:
        this.mAnimView.setLayoutParams(r0);
        AnimationDrawable r6 = (AnimationDrawable) Utils.getDrawableFromPkg(this.mContext, "com.android.systemui", this.mValues[r5]);
        this.mAnimDrawable = r6;
        if (r6 == null) goto L10;
        this.mAnimView.setImageDrawable(r6);
        this.mAnimView.setLayerType(2, null);
        this.mAnimDrawable.setVisible(true, true);
        this.mAnimDrawable.start();
        return;
    L10:
        return;
    L5:
        r0.width = r1.getDimensionPixelOffset(R.dimen.fingerprint_anim_special_size);
        r0.height = r1.getDimensionPixelOffset(R.dimen.fingerprint_anim_special_size);
        this.mAnimView.setTranslationY(r1.getDimensionPixelOffset(R.dimen.fingerprint_anim_margin_special_top));
        goto L6
    }
}
