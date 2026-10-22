package androidx.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class ContentLoadingProgressBar extends ProgressBar {
    private static final int MIN_DELAY = 500;
    private static final int MIN_SHOW_TIME = 500;
    private final Runnable mDelayedHide;
    private final Runnable mDelayedShow;
    boolean mDismissed;
    boolean mPostedHide;
    boolean mPostedShow;
    long mStartTime;

    public ContentLoadingProgressBar(@NonNull Context r2) {
        this(r2, null);
    }

    private void removeCallbacks() {
        removeCallbacks(this.mDelayedHide);
        removeCallbacks(this.mDelayedShow);
    }

    public synchronized void hide() {
        monitor-enter(this);
        this.mDismissed = true;     // Catch: Throwable -> L12
        removeCallbacks(this.mDelayedShow);     // Catch: Throwable -> L12
        this.mPostedShow = false;     // Catch: Throwable -> L12
        long r1 = System.currentTimeMillis();     // Catch: Throwable -> L12
        long r3 = this.mStartTime;     // Catch: Throwable -> L12
        long r2 = r1 - r3;     // Catch: Throwable -> L12
        if (r2 < 500) goto L7;
    L14:
        setVisibility(8);     // Catch: Throwable -> L12
    L15:
        monitor-exit(this);
        return;
    L7:
        if (r3 == (-1)) goto L14;
        if (this.mPostedHide == true) goto L15;
        postDelayed(this.mDelayedHide, 500 - r2);     // Catch: Throwable -> L12
        this.mPostedHide = true;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
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

    public synchronized void show() {
        monitor-enter(this);
        this.mStartTime = -1;     // Catch: Throwable -> L8
        this.mDismissed = false;     // Catch: Throwable -> L8
        removeCallbacks(this.mDelayedHide);     // Catch: Throwable -> L8
        this.mPostedHide = false;     // Catch: Throwable -> L8
        if (this.mPostedShow == true) goto L10;
        postDelayed(this.mDelayedShow, 500);     // Catch: Throwable -> L8
        this.mPostedShow = true;     // Catch: Throwable -> L8
    L10:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public ContentLoadingProgressBar(@NonNull Context r2, @Nullable AttributeSet r3) {
        super(r2, r3, 0);
        this.mStartTime = -1;
        this.mPostedHide = false;
        this.mPostedShow = false;
        this.mDismissed = false;
        this.mDelayedHide = new AnonymousClass1(this);
        this.mDelayedShow = new AnonymousClass2(this);
    }
}
