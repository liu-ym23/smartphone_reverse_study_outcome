package com.android.settings.widget;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.android.settings.R;
import com.android.settingslib.widget.LottieColorUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.obric.common.oea.foundation.animation.token.Token;
import com.obric.common.oea.foundation.animation.token.TokenUtil;
import com.obric.olog.OLog;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class FingerprintEnrollIntroductionImageView extends AppCompatImageView {
    private static final int DURATION = 0;
    private static final String TAG = "FingerprintEnrollIntroductionImageView";
    private TimeInterpolator mInterpolator;
    private int mProgress;

    static {
        DURATION = Token.Duration.OUI_ANIMATION_DURATION_MEDIUM_4.getDuration();
    }

    public FingerprintEnrollIntroductionImageView(Context r3) {
        super(r3);
        this.mProgress = 0;
        this.mInterpolator = TokenUtil.INSTANCE.getInterpolator(Token.Easing.OUI_ANIMATION_EASING_STANDARD);
        init(r3);
    }

    public FingerprintEnrollIntroductionImageView(Context r2, AttributeSet r3) {
        super(r2, r3);
        this.mProgress = 0;
        this.mInterpolator = TokenUtil.INSTANCE.getInterpolator(Token.Easing.OUI_ANIMATION_EASING_STANDARD);
        init(r2);
    }

    private void init(Context r2) {
        if (LottieColorUtils.isDarkMode(r2.getApplicationContext()) == false) goto L5;
        int r0 = R.drawable.front_fingerprint_enroll_init_hand4_dark;
    L6:
        Glide.with(r2).load(Integer.valueOf(r0)).diskCacheStrategy(DiskCacheStrategy.ALL).into(this);
        return;
    L5:
        r0 = R.drawable.front_fingerprint_enroll_init_hand4;
        goto L6
    }

    public void setImageDrawable(int r2) {
        Glide.with(getContext()).load(Integer.valueOf(r2)).diskCacheStrategy(DiskCacheStrategy.ALL).into(this);
    }

    public void setProgressWithAnimation(int r5) {
        OLog.i(TAG, "setProgressWithAnimation: " + this.mProgress + " -> " + r5);
        int r0 = DURATION;
        if (this.mProgress != 0) goto L7;
        if (r5 == 0) goto L8;
        setProgress(r5);
        ArrayList r6 = new ArrayList();
        r6.add(ObjectAnimator.ofFloat(this, "alpha", new float[]{1.0f, 0.0f}));
        AnimatorSet r1 = new AnimatorSet();
        r1.setDuration(r0);
        r1.setInterpolator(this.mInterpolator);
        r1.playTogether(r6);
        r1.start();
        return;
    L8:
        return;
    }

    public void reset() {
        OLog.i(TAG, "reset");
        setProgress(0);
        setAlpha(1.0f);
    }

    public void setProgress(int r1) {
        this.mProgress = r1;
        invalidate();
    }
}
