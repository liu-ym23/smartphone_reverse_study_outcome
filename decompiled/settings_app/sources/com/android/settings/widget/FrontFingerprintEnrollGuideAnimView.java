package com.android.settings.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.android.settings.R;
import com.android.settingslib.widget.LottieColorUtils;
import com.obric.olog.OLog;

/* JADX INFO: loaded from: classes.dex */
public class FrontFingerprintEnrollGuideAnimView extends RelativeLayout {
    private static final String TAG = "FrontFingerprintEnrollGuideAnimView";
    private Context mContext;
    private LottieAnimationView mGuideLottieView;
    private ImageView mIntroductionView;
    private boolean mIsAnimPlaying;

    public FrontFingerprintEnrollGuideAnimView(Context r2) {
        this(r2, null);
    }

    public FrontFingerprintEnrollGuideAnimView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public FrontFingerprintEnrollGuideAnimView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.mIsAnimPlaying = false;
        init(r1);
    }

    private void init(Context r2) {
        inflate(r2, R.layout.front_fingerprint_enroll_guide_anim_view, this);
        this.mContext = r2;
        this.mIntroductionView = (ImageView) findViewById(R.id.iv_normal_state);
        initGuideLottieView();
    }

    public void reset() {
        if (this.mIsAnimPlaying == true) goto L5;
        return;
    L5:
        OLog.i(TAG, "reset");
        this.mIsAnimPlaying = false;
        this.mGuideLottieView.cancelAnimation();
        this.mGuideLottieView.setVisibility(8);
        this.mIntroductionView.setVisibility(0);
        invalidate();
    }

    private void initGuideLottieView() {
        this.mGuideLottieView = (LottieAnimationView) findViewById(R.id.guide_anim_view);
        if (LottieColorUtils.isDarkMode(this.mContext.getApplicationContext()) == false) goto L5;
        this.mGuideLottieView.setAnimation(R.raw.lottie_fingerprint_enroll_guide_loop_dark);
    L6:
        this.mGuideLottieView.setVisibility(8);
        return;
    L5:
        this.mGuideLottieView.setAnimation(R.raw.lottie_fingerprint_enroll_guide_loop_light);
        goto L6
    }

    public void playAnimation() {
        if (this.mIsAnimPlaying == false) goto L5;
        return;
    L5:
        OLog.i(TAG, "playAnimation");
        this.mIsAnimPlaying = true;
        this.mGuideLottieView.setRepeatCount(-1);
        this.mGuideLottieView.setRepeatMode(1);
        this.mGuideLottieView.playAnimation();
        this.mGuideLottieView.setVisibility(0);
        this.mIntroductionView.setVisibility(8);
        invalidate();
    }
}
