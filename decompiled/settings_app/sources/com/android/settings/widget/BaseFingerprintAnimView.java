package com.android.settings.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.core.internal.view.SupportMenu;
import com.android.settings.ExecutorManager;
import com.bytedance.librarian.LibrarianImpl;
import com.obric.olog.OLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseFingerprintAnimView extends View {
    public static final int ID_INIT_BACKGROUND = 0;
    protected final long ANIM_DELAY_TIME;
    protected int IMAGE_SIZE;
    protected final int INVALIDATE_INTERVAL_TIME;
    protected final float MAX_BUBBLE_ALPHA;
    protected final float MAX_BUBBLE_RADIUS_RATE;
    protected final float MIN_RADIUS_RATE;
    protected final int MSG_INVALIDATE_SUCCESS_VIEW;
    protected final long OVERLAY_DELAY_TIME;
    protected int PADDING_TOP;
    protected int PROGRESS_RESOURCE_COUNT;
    protected final long STANDARD_BUBBLE_ANIM_TIME;
    protected final long STANDARD_OVERLAY_ANIM_TIME;
    protected final String TAG;
    protected int[] animingBubbleRadius;
    protected int[] animingOverlayRadius;
    private Paint circlePaint;
    protected Callback mCallback;
    protected Status mCurrentStatus;
    protected int mCurrentStep;
    protected Handler mHandler;
    protected final HashMap<Integer, Bitmap> mImageMap;
    protected int mLastEndAnimIndex;
    protected long mLastInvalidViewTime;
    protected int mMaxStep;
    private Paint mPaint;
    protected int mRunningAnimCount;
    protected int[] overlayAlphaValue;
    protected int[] overlayRadius;
    protected int[] progressResIds;
    protected float[] rateArr;
    protected int[] xCoordinates;
    private Xfermode xfermode;
    protected int[] yCoordinates;

    public interface Callback {
        void onAnimDone();
    }

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

    protected abstract int getBackgroundImageResource(int r1);

    protected float getBubbleAlphaRate(int r4, int r5) {
        float r3 = r5;
        float r2 = (0.8f * r3) / 2.0f;
        float r1 = r4;
        if (r1 >= ((1.2f * r3) / 2.0f)) goto L6;
        return (r1 - (r3 * 0.2f)) / r2;
    L6:
        return (r5 - r4) / r2;
    }

    protected abstract int getBubbleCenterRadiusRes();

    protected abstract int getBubbleCenterXRes();

    protected abstract int getBubbleCenterYRes();

    protected abstract int getImageSize();

    protected abstract float getScaleFactor();

    protected abstract void initProgressRes();

    public BaseFingerprintAnimView(Context r2) {
        this(r2, null);
    }

    public BaseFingerprintAnimView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public BaseFingerprintAnimView(Context r2, AttributeSet r3, int r4) {
        super(r2, r3, r4);
        this.TAG = "BaseFingerprintAnimView";
        this.STANDARD_OVERLAY_ANIM_TIME = 600;
        this.STANDARD_BUBBLE_ANIM_TIME = 700;
        this.OVERLAY_DELAY_TIME = 100;
        this.ANIM_DELAY_TIME = 300;
        this.MIN_RADIUS_RATE = 0.2f;
        this.MAX_BUBBLE_RADIUS_RATE = 0.8f;
        this.MAX_BUBBLE_ALPHA = 0.3f;
        this.INVALIDATE_INTERVAL_TIME = 20;
        int r5 = this.PROGRESS_RESOURCE_COUNT;
        this.animingOverlayRadius = new int[r5];
        this.animingBubbleRadius = new int[r5];
        this.overlayAlphaValue = new int[r5];
        this.mRunningAnimCount = 0;
        this.mCurrentStatus = Status.INIT;
        this.MSG_INVALIDATE_SUCCESS_VIEW = 11;
        this.mImageMap = new HashMap();
        this.mHandler = new AnonymousClass1(this);
        Paint r6 = new Paint(1);
        this.circlePaint = r6;
        r6.setColor(SupportMenu.CATEGORY_MASK);
        this.xfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        Paint r7 = new Paint(1);
        this.mPaint = r7;
        r7.setColor(SupportMenu.CATEGORY_MASK);
        initDimens();
        initProgressRes();
        preloadImages();
    }

    protected void initDimens() {
        this.IMAGE_SIZE = getImageSize();
        this.xCoordinates = getResources().getIntArray(getBubbleCenterXRes());
        float r0 = getScaleFactor();
        int r1 = 0;
        int r2 = 0;
    L3:
        int[] r3 = this.xCoordinates;
        if (r2 >= r3.length) goto L6;
        r3[r2] = (int) (r3[r2] * r0);
        r2 = r2 + 1;
        goto L3
    L6:
        this.yCoordinates = getResources().getIntArray(getBubbleCenterYRes());
        int r4 = 0;
    L7:
        int[] r5 = this.yCoordinates;
        if (r4 >= r5.length) goto L10;
        r5[r4] = (int) (r5[r4] * r0);
        r4 = r4 + 1;
        goto L7
    L10:
        this.overlayRadius = getResources().getIntArray(getBubbleCenterRadiusRes());
    L11:
        int[] r6 = this.overlayRadius;
        if (r1 >= r6.length) goto L14;
        r6[r1] = (int) (r6[r1] * r0);
        r1 = r1 + 1;
        goto L11
    }

    protected void preloadImages() {
        ExecutorManager.execute(new AnonymousClass2(this));
    }

    protected long calculateOverlayAnimTime(int r1) {
        return (long) (this.rateArr[r1] * 600.0f);
    }

    protected long calculateBubbleAnimTime(int r1) {
        return (long) (this.rateArr[r1] * 700.0f);
    }

    public void setStatus(int r2) {
        if (r2 == 0) goto L4;
        this.mCurrentStatus = Status.INIT;
    L5:
        invalidate();
        return;
    L4:
        this.mCurrentStatus = Status.INIT;
        int r3 = this.PROGRESS_RESOURCE_COUNT;
        this.animingOverlayRadius = new int[r3];
        this.animingBubbleRadius = new int[r3];
        this.overlayAlphaValue = new int[r3];
        this.mCurrentStep = 0;
        this.mLastEndAnimIndex = 0;
        goto L5
    }

    public void playAnimation(int r8, int r9) {
        if (r8 != 0) goto L4;
        return;
    L4:
        if (this.mCurrentStep == r8) goto L29;
        this.mCurrentStep = r8;
        this.mMaxStep = r9;
        this.mCurrentStatus = Status.ENROLLING;
        OLog.d("BaseFingerprintAnimView", "currentProgress " + r8 + LibrarianImpl.Constants.SEPARATOR + r9);
        float r0 = (this.PROGRESS_RESOURCE_COUNT * 1.0f) / r9;
        int r2 = (int) Math.ceil((r8 - 1) * r0);
        if (r2 > 0) goto L9;
        r2 = 1;
    L9:
        int r4 = this.mLastEndAnimIndex;
        if (r4 > 0) goto L12;
    L14:
        if (r9 != r8) goto L16;
        int r10 = this.PROGRESS_RESOURCE_COUNT;
    L17:
        this.mLastEndAnimIndex = r10;
        OLog.d("BaseFingerprintAnimView", "startAnimIndex=" + r2 + ", endAnimIndex=" + r10);
        ArrayList r11 = new ArrayList();
        int r1 = r2;
    L18:
        if (r1 > r10) goto L23;
        if (r1 != r2) goto L21;
        long r3 = 0;
    L22:
        r11.add(getBubbleAnimator(r1, r3));
        long r5 = r3 + 100;
        r11.add(getOverlayAlphaAnimator(r1, r5));
        r11.add(getOverlayAnimator(r1, r5));
        r1 = r1 + 1;
        goto L18
    L21:
        r3 = 300;
        goto L22
    L23:
        AnimatorSet r12 = new AnimatorSet();
        r12.playTogether(r11);
        r12.addListener(new AnonymousClass3(this));
        r12.start();
        return;
    L16:
        r10 = (int) Math.floor(r8 * r0);
        goto L17
    L12:
        if (r2 == (r4 + 1)) goto L14;
        OLog.d("BaseFingerprintAnimView", "calculated startAnimIndex '" + r2 + "' is NOT following the last end anim index,set it to: mLastEndAnimIndex + 1 = " + (this.mLastEndAnimIndex + 1));
        r2 = this.mLastEndAnimIndex + 1;
        goto L14
    }

    protected Animator getBubbleAnimator(final int r7, long r8) {
        int r1 = r7 - 1;
        int r0 = this.overlayRadius[r1];
        long r3 = calculateBubbleAnimTime(r1);
        ValueAnimator r2 = ValueAnimator.ofInt(new int[]{(int) (r0 * 0.2f), (int) (r0 * 0.8f)});
        r2.addUpdateListener(new AnonymousClass4(this, r7));
        r2.setDuration(r3);
        r2.setInterpolator(new AccelerateDecelerateInterpolator());
        r2.setStartDelay(r8);
        return r2;
    }

    protected Animator getOverlayAnimator(final int r7, long r8) {
        int r1 = r7 - 1;
        int r0 = this.overlayRadius[r1];
        long r3 = calculateOverlayAnimTime(r1);
        ValueAnimator r2 = ValueAnimator.ofInt(new int[]{(int) (r0 * 0.2f), r0});
        r2.addUpdateListener(new AnonymousClass5(this, r7));
        r2.setDuration(r3);
        r2.setStartDelay(r8);
        return r2;
    }

    protected Animator getOverlayAlphaAnimator(final int r5, long r6) {
        long r0 = calculateOverlayAnimTime(r5 - 1) / 6;
        ValueAnimator r2 = ValueAnimator.ofInt(new int[]{0, 255});
        r2.addUpdateListener(new AnonymousClass6(this, r5));
        r2.setDuration(r0);
        r2.setInterpolator(new DecelerateInterpolator());
        r2.setStartDelay(r6);
        return r2;
    }

    protected int getFinishedAnimProgressIndex() {
        int r0 = -1;
        int r1 = 0;
    L3:
        int r4 = r1;
        int r2 = r0;
        r0 = r4;
        if (r0 >= this.PROGRESS_RESOURCE_COUNT) goto L9;
        if (this.animingOverlayRadius[r0] < this.overlayRadius[r0]) goto L9;
        r1 = r0 + 1;
    L9:
        return r2 + 1;
    }

    protected Bitmap getBackgroundBitmap(int r7) {
        Bitmap r0 = this.mImageMap.get(Integer.valueOf(r7));
        if (r0 == null) goto L5;
        return r0;
    L5:
        if (r7 != 0) goto L10;
        int r1 = getBackgroundImageResource(r7);
        if (r1 <= 0) goto L10;
        return getImageRes(r1);
    L10:
        int r2 = this.PROGRESS_RESOURCE_COUNT;
        int r3 = this.mMaxStep;
        float r4 = (r2 * 1.0f) / r3;
        if (r3 == r7) goto L14;
        r2 = (int) Math.floor(r7 * r4);
    L14:
        Drawable[] r8 = new Drawable[r2];
        r8[0] = getResources().getDrawable(getBackgroundImageResource(r2));
        int r5 = 0;
    L16:
        if (r5 >= (r2 - 1)) goto L18;
        int r6 = r5 + 1;
        r8[r6] = getResources().getDrawable(this.progressResIds[r5]);
        r5 = r6;
        goto L16
    L18:
        LayerDrawable r9 = new LayerDrawable(r8);
        int r10 = this.IMAGE_SIZE;
        Bitmap r11 = Bitmap.createBitmap(r10, r10, Bitmap.Config.ARGB_8888);
        int r12 = this.IMAGE_SIZE;
        r9.setBounds(0, 0, r12, r12);
        r9.draw(new Canvas(r11));
        return r11;
    }

    @Override // android.view.View
    protected void onDraw(Canvas r7) {
        r7.translate(0.0f, this.PADDING_TOP);
        int r3 = 0;
        if (this.mCurrentStatus != Status.INIT) goto L6;
        r7.drawBitmap(getBackgroundBitmap(0), 0.0f, 0.0f, this.mPaint);
        return;
    L6:
        int r0 = this.mCurrentStep;
        r7.drawBitmap(getBackgroundBitmap(r0), 0.0f, 0.0f, this.mPaint);
        if (r0 == 0) goto L11;
        r3 = r0 - 1;
    L11:
        if (r3 >= this.PROGRESS_RESOURCE_COUNT) goto L18;
        if (this.animingOverlayRadius[r3] <= 0) goto L17;
        r7.drawBitmap(getXfermodeBitmap(r3), 0.0f, 0.0f, this.mPaint);
        int r1 = (int) (this.overlayRadius[r3] * 0.8f);
        if (this.animingBubbleRadius[r3] >= r1) goto L17;
        r7.save();
        int r2 = this.animingBubbleRadius[r3];
        r7.translate(this.xCoordinates[r3] - r2, this.yCoordinates[r3] - r2);
        r7.drawBitmap(getGradient(r2, r1), 0.0f, 0.0f, this.mPaint);
        r7.restore();
    L17:
        r3 = r3 + 1;
        goto L11
    }

    protected Bitmap getGradient(int r7, int r8) {
        int r0 = (r7 * 2) + 1;
        Bitmap r2 = Bitmap.createBitmap(r0, r0, Bitmap.Config.ARGB_8888);
        GradientDrawable r3 = new GradientDrawable(GradientDrawable.Orientation.TL_BR, new int[]{-10373889, -10373889, -10373889, -10373889, -10373889, -10373889, -10373889, -10373889, -10373889, 6403327});
        r3.setAlpha((int) (getBubbleAlphaRate(r7, r8) * 76.5f));
        r3.setShape(1);
        r3.setGradientType(1);
        r3.setSize(r0, r0);
        r3.setGradientRadius(r7);
        r3.setGradientCenter(0.5f, 0.5f);
        r3.setBounds(0, 0, r0, r0);
        r3.draw(new Canvas(r2));
        return r2;
    }

    protected Bitmap getXfermodeBitmap(int r7) {
        Bitmap r0 = getImageRes(this.progressResIds[r7]);
        int r1 = this.IMAGE_SIZE;
        Bitmap r2 = Bitmap.createBitmap(r1, r1, Bitmap.Config.ARGB_8888);
        Canvas r3 = new Canvas(r2);
        this.circlePaint.setAlpha(this.overlayAlphaValue[r7]);
        r3.drawCircle(this.xCoordinates[r7], this.yCoordinates[r7], this.animingOverlayRadius[r7], this.circlePaint);
        this.mPaint.setXfermode(this.xfermode);
        r3.drawBitmap(r0, 0.0f, 0.0f, this.mPaint);
        this.mPaint.setXfermode(null);
        return r2;
    }

    protected Bitmap decodeBitmapResource(int r2) {
        Bitmap r3 = BitmapFactory.decodeResource(getContext().getResources(), r2);
        int r1 = this.IMAGE_SIZE;
        return Bitmap.createScaledBitmap(r3, r1, r1, false);
    }

    protected Bitmap getImageRes(int r3) {
        Bitmap r0 = this.mImageMap.get(Integer.valueOf(r3));
        if (r0 == null) goto L7;
        if (r0.isRecycled() == true) goto L7;
        return r0;
    L7:
        return decodeBitmapResource(r3);
    }

    public void recycleBitmaps() {
        Iterator<Bitmap> r2 = this.mImageMap.values().iterator();
    L4:
        if (r2.hasNext() == false) goto L10;
        Bitmap r0 = r2.next();
        if (r0 == null) goto L4;
        if (r0.isRecycled() == true) goto L4;
        r0.recycle();
        goto L4
    }

    public void setCallback(Callback r1) {
        this.mCallback = r1;
    }
}
