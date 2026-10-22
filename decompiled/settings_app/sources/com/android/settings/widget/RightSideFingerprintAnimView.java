package com.android.settings.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.android.settings.R;

/* JADX INFO: loaded from: classes.dex */
public class RightSideFingerprintAnimView extends BaseFingerprintAnimView {
    @Override // com.android.settings.widget.BaseFingerprintAnimView
    protected int getBackgroundImageResource(int r1) {
        return R.drawable.setting_fp_0;
    }

    @Override // com.android.settings.widget.BaseFingerprintAnimView
    protected int getBubbleCenterRadiusRes() {
        return R.array.fingerprint_overlay_radius;
    }

    @Override // com.android.settings.widget.BaseFingerprintAnimView
    protected int getBubbleCenterXRes() {
        return R.array.fingerprint_bubble_center_x;
    }

    @Override // com.android.settings.widget.BaseFingerprintAnimView
    protected int getBubbleCenterYRes() {
        return R.array.fingerprint_bubble_center_y;
    }

    public RightSideFingerprintAnimView(Context r2) {
        this(r2, null);
    }

    public RightSideFingerprintAnimView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public RightSideFingerprintAnimView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        init();
    }

    private void init() {
        this.PADDING_TOP = getResources().getDimensionPixelSize(R.dimen.fingerprint_progress_padding_top);
        this.PROGRESS_RESOURCE_COUNT = 20;
        this.rateArr = new float[]{0.55f, 0.52f, 0.43f, 0.804f, 0.711f, 1.065f, 1.182f, 0.981f, 0.463f, 0.952f, 0.925f, 0.478f, 0.666f, 0.9f, 0.843f, 1.144f, 0.759f, 1.038f, 0.78f, 0.52f};
    }

    @Override // com.android.settings.widget.BaseFingerprintAnimView
    protected int getImageSize() {
        return getResources().getDimensionPixelSize(R.dimen.fingerprint_progress_image_size);
    }

    @Override // com.android.settings.widget.BaseFingerprintAnimView
    protected float getScaleFactor() {
        return getResources().getDisplayMetrics().density / 3.0f;
    }

    @Override // com.android.settings.widget.BaseFingerprintAnimView
    protected void initProgressRes() {
        this.progressResIds = new int[]{R.drawable.finger_progress_01, R.drawable.finger_progress_02, R.drawable.finger_progress_03, R.drawable.finger_progress_04, R.drawable.finger_progress_05, R.drawable.finger_progress_06, R.drawable.finger_progress_07, R.drawable.finger_progress_08, R.drawable.finger_progress_09, R.drawable.finger_progress_10, R.drawable.finger_progress_11, R.drawable.finger_progress_12, R.drawable.finger_progress_13, R.drawable.finger_progress_14, R.drawable.finger_progress_15, R.drawable.finger_progress_16, R.drawable.finger_progress_17, R.drawable.finger_progress_18, R.drawable.finger_progress_19, R.drawable.finger_progress_20};
    }
}
