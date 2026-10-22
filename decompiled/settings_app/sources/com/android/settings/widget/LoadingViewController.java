package com.android.settings.widget;

import android.R;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

/* JADX INFO: loaded from: classes.dex */
public class LoadingViewController {
    private static final long DELAY_SHOW_LOADING_CONTAINER_THRESHOLD_MS = 100;
    public final View mContentView;
    public final Handler mFgHandler;
    public final View mLoadingView;
    private Runnable mShowLoadingContainerRunnable;

    public LoadingViewController(View r2, View r3) {
        this.mShowLoadingContainerRunnable = new AnonymousClass1(this);
        this.mLoadingView = r2;
        this.mContentView = r3;
        this.mFgHandler = new Handler(Looper.getMainLooper());
    }

    public void showContent(boolean r3) {
        this.mFgHandler.removeCallbacks(this.mShowLoadingContainerRunnable);
        handleLoadingContainer(true, r3);
    }

    public void showLoadingViewDelayed() {
        this.mFgHandler.postDelayed(this.mShowLoadingContainerRunnable, 100);
    }

    public void handleLoadingContainer(boolean r2, boolean r3) {
        handleLoadingContainer(this.mLoadingView, this.mContentView, r2, r3);
    }

    public static void handleLoadingContainer(View r1, View r2, boolean r3, boolean r4) {
        setViewShown(r1, !r3, r4);
        setViewShown(r2, r3, r4);
    }

    private static void setViewShown(final View r2, boolean r3, boolean r4) {
        int r0 = 0;
        if (r4 == false) goto L13;
        Context r5 = r2.getContext();
        if (r3 == false) goto L7;
        int r1 = R.anim.fade_in;
    L8:
        Animation r6 = AnimationUtils.loadAnimation(r5, r1);
        if (r3 == false) goto L11;
        r2.setVisibility(0);
    L12:
        r2.startAnimation(r6);
        return;
    L11:
        r6.setAnimationListener(new AnonymousClass2(r2));
        goto L12
    L7:
        r1 = R.anim.fade_out;
        goto L8
    L13:
        r2.clearAnimation();
        if (r3 == true) goto L17;
        r0 = 4;
    L17:
        r2.setVisibility(r0);
    }
}
