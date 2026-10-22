package com.android.settings.widget;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.android.settings.R;
import com.android.settingslib.widget.LottieColorUtils;
import com.obric.common.oea.foundation.animation.token.Token;
import com.obric.common.oea.foundation.animation.token.TokenUtil;
import com.obric.olog.OLog;

/* JADX INFO: loaded from: classes.dex */
public class FrontFingerprintAnimView extends RelativeLayout {
    public static final int ID_INIT_BACKGROUND = 0;
    private static final String TAG = "FrontFingerprintAnimView";
    private Context mContext;
    protected Status mCurrentStatus;
    private TimeInterpolator mInterpolator;
    private FingerprintEnrollIntroductionImageView mIntroductionView;
    private FingerprintEnrollProgressLottieView mProgressViewLottie;
    private int sensorType;

    protected static final enum Status extends Enum<Status> {
        private static final /* synthetic */ Status[] $VALUES = null;
        public static final Status ENROLLING = null;
        public static final Status INIT = null;

        private static /* synthetic */ Status[] $values() {
            return new Status[]{INIT, ENROLLING};
        }

        private Status(String r1, int r2) {
            super(r1, r2);
        }

        public static Status valueOf(String r1) {
            return (Status) Enum.valueOf(Status.class, r1);
        }

        public static Status[] values() {
            return (Status[]) $VALUES.clone();
        }

        static {
            INIT = new Status("INIT", 0);
            ENROLLING = new Status("ENROLLING", 1);
            $VALUES = $values();
        }
    }

    public FrontFingerprintAnimView(Context r2) {
        this(r2, null);
    }

    public FrontFingerprintAnimView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public FrontFingerprintAnimView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.sensorType = 0;
        this.mInterpolator = TokenUtil.INSTANCE.getInterpolator(Token.Easing.OUI_ANIMATION_EASING_STANDARD);
        this.mCurrentStatus = Status.INIT;
        init(r1);
    }

    private void init(Context r2) {
        inflate(r2, R.layout.front_fingerprint_anim_view, this);
        this.mIntroductionView = (FingerprintEnrollIntroductionImageView) findViewById(R.id.init_base_bg);
        this.mContext = r2;
        updateUdfpsProgressViewLottie();
    }

    public void setCallback(FingerprintEnrollProgressView.Callback r1) {
        this.mProgressViewLottie.setCallback(r1);
    }

    public void setSensorType(int r1) {
        this.mProgressViewLottie.setSensorType(r1);
    }

    public void reset() {
        OLog.i(TAG, "reset");
        this.mCurrentStatus = Status.INIT;
        this.mProgressViewLottie.setVisibility(4);
        this.mProgressViewLottie.reset();
        this.mProgressViewLottie.setVisibility(4);
        this.mIntroductionView.reset();
        invalidate();
    }

    private void updateUdfpsProgressViewLottie() {
        this.mProgressViewLottie = (FingerprintEnrollProgressLottieView) findViewById(R.id.udfps_progress_lottie);
        if (LottieColorUtils.isDarkMode(this.mContext.getApplicationContext()) == false) goto L5;
        this.mProgressViewLottie.setAnimation(R.raw.lottie_fingerprint_enroll_progress_dark);
    L6:
        LottieColorUtils.applyDynamicColors(this.mContext.getApplicationContext(), this.mProgressViewLottie);
        this.mProgressViewLottie.setVisibility(4);
        this.mProgressViewLottie.setMinAndMaxProgress(0.0f, 1.0f);
        this.mProgressViewLottie.setProgress(0.0f);
        return;
    L5:
        this.mProgressViewLottie.setAnimation(R.raw.lottie_fingerprint_enroll_progress_light);
        goto L6
    }

    public void playAnimation(int r3) {
        this.mCurrentStatus = Status.ENROLLING;
        if (this.mProgressViewLottie.getVisibility() == 0) goto L5;
        this.mProgressViewLottie.setVisibility(0);
    L5:
        this.mProgressViewLottie.playAnimationLottie(r3);
        this.mIntroductionView.setProgressWithAnimation(r3);
        invalidate();
    }

    public void processDone(boolean r1) {
        invalidate();
    }

    public void setIntroductionImage(int r1) {
        this.mIntroductionView.setImageDrawable(r1);
    }
}
