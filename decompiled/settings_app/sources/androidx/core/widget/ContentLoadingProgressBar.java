package androidx.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;

/* JADX INFO: loaded from: classes.dex */
public class ContentLoadingProgressBar extends ProgressBar {
    private static final int MIN_DELAY_MS = 500;
    private static final int MIN_SHOW_TIME_MS = 500;
    private final Runnable mDelayedHide;
    private final Runnable mDelayedShow;
    boolean mDismissed;
    boolean mPostedHide;
    boolean mPostedShow;
    long mStartTime;

    public static /* synthetic */ void $r8$lambda$Ije3417V0uZgdBrD9pbxQ2_AHiI(ContentLoadingProgressBar r0) {
        r0.hideOnUiThread();
    }

    /* JADX INFO: renamed from: $r8$lambda$tmknj5M20Tn8TaJxR587u-39ZDQ, reason: not valid java name */
    public static /* synthetic */ void m39$r8$lambda$tmknj5M20Tn8TaJxR587u39ZDQ(ContentLoadingProgressBar r0) {
        r0.showOnUiThread();
    }

    /* JADX INFO: renamed from: lambda$new$0$androidx-core-widget-ContentLoadingProgressBar, reason: not valid java name */
    /* synthetic */ void m40lambda$new$0$androidxcorewidgetContentLoadingProgressBar() {
        this.mPostedHide = false;
        this.mStartTime = -1;
        setVisibility(8);
    }

    /* JADX INFO: renamed from: lambda$new$1$androidx-core-widget-ContentLoadingProgressBar, reason: not valid java name */
    /* synthetic */ void m41lambda$new$1$androidxcorewidgetContentLoadingProgressBar() {
        this.mPostedShow = false;
        if (this.mDismissed == true) goto L6;
        this.mStartTime = System.currentTimeMillis();
        setVisibility(0);
        return;
    }

    public ContentLoadingProgressBar(Context r2) {
        this(r2, null);
    }

    public ContentLoadingProgressBar(Context r2, AttributeSet r3) {
        super(r2, r3, 0);
        this.mStartTime = -1;
        this.mPostedHide = false;
        this.mPostedShow = false;
        this.mDismissed = false;
        this.mDelayedHide = new ContentLoadingProgressBar$$ExternalSyntheticLambda2(this);
        this.mDelayedShow = new ContentLoadingProgressBar$$ExternalSyntheticLambda3(this);
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        removeCallbacks();
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks();
    }

    private void removeCallbacks() {
        removeCallbacks(this.mDelayedHide);
        removeCallbacks(this.mDelayedShow);
    }

    public void hide() {
        post(new ContentLoadingProgressBar$$ExternalSyntheticLambda1(this));
    }

    private void hideOnUiThread() {
        this.mDismissed = true;
        removeCallbacks(this.mDelayedShow);
        this.mPostedShow = false;
        long r1 = System.currentTimeMillis();
        long r3 = this.mStartTime;
        long r2 = r1 - r3;
        if (r2 < 500) goto L5;
    L10:
        setVisibility(8);
        return;
    L5:
        if (r3 == (-1)) goto L10;
        if (this.mPostedHide == true) goto L12;
        postDelayed(this.mDelayedHide, 500 - r2);
        this.mPostedHide = true;
        return;
    }

    public void show() {
        post(new ContentLoadingProgressBar$$ExternalSyntheticLambda0(this));
    }

    private void showOnUiThread() {
        this.mStartTime = -1;
        this.mDismissed = false;
        removeCallbacks(this.mDelayedHide);
        this.mPostedHide = false;
        if (this.mPostedShow == true) goto L6;
        postDelayed(this.mDelayedShow, 500);
        this.mPostedShow = true;
        return;
    }
}
