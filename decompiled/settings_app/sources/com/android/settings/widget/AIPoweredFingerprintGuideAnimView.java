package com.android.settings.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.android.settings.R;
import com.obric.olog.OLog;

/* JADX INFO: loaded from: classes.dex */
public class AIPoweredFingerprintGuideAnimView extends RelativeLayout {
    private static final String TAG = "AIPoweredFingerprintGuideAnimView";
    private LottieAnimationView mGuideLottieView;
    private ImageView mIntroductionView;

    public AIPoweredFingerprintGuideAnimView(Context r2) {
        this(r2, null);
    }

    public AIPoweredFingerprintGuideAnimView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public AIPoweredFingerprintGuideAnimView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        init(r1);
    }

    private void init(Context r2) {
        inflate(r2, R.layout.ai_powered_fingerprint_guide_anim_view, this);
        this.mIntroductionView = (ImageView) findViewById(R.id.intro_view);
        initGuideLottieView();
    }

    public void reset() {
        OLog.i(TAG, "reset");
        this.mGuideLottieView.cancelAnimation();
        this.mGuideLottieView.setVisibility(8);
        this.mIntroductionView.setVisibility(0);
        invalidate();
    }

    private void initGuideLottieView() {
        LottieAnimationView r0 = (LottieAnimationView) findViewById(R.id.guide_anim_view);
        this.mGuideLottieView = r0;
        r0.setAnimation(R.raw.lottie_ai_button_fingerprint_enroll_guide);
        this.mGuideLottieView.setVisibility(8);
    }

    public void playAnimation() {
        this.mGuideLottieView.setRepeatCount(-1);
        this.mGuideLottieView.setRepeatMode(2);
        this.mGuideLottieView.playAnimation();
        this.mGuideLottieView.setVisibility(0);
        this.mIntroductionView.setVisibility(8);
        invalidate();
    }
}
