package com.android.settings.widget;

import android.R;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

/* JADX INFO: loaded from: classes.dex */
public class LoadingViewController2 {
    private static final long DELAY_SHOW_LOADING_CONTAINER_THRESHOLD_MS = 100;
    private final View mContentView;
    private final View mEmptyView;
    private final Handler mFgHandler;
    private final View mLoadingView;
    private Runnable mShowLoadingContainerRunnable;
    private final View mTitleBar;

    public LoadingViewController2(View r2, View r3, View r4, View r5) {
        this.mShowLoadingContainerRunnable = new AnonymousClass1(this);
        this.mTitleBar = r2;
        this.mLoadingView = r3;
        this.mContentView = r4;
        this.mEmptyView = r5;
        this.mFgHandler = new Handler(Looper.getMainLooper());
    }

    public void showContent(boolean r3) {
        this.mFgHandler.removeCallbacks(this.mShowLoadingContainerRunnable);
        handleLoadingContainer(true, false, r3);
    }

    public void showEmpty(boolean r3) {
        if (this.mEmptyView != null) goto L5;
        return;
    L5:
        this.mFgHandler.removeCallbacks(this.mShowLoadingContainerRunnable);
        handleLoadingContainer(false, true, r3);
    }

    public void showLoadingView() {
        handleLoadingContainer(false, false, false);
    }

    public void showLoadingViewDelayed() {
        this.mFgHandler.postDelayed(this.mShowLoadingContainerRunnable, 100);
    }

    private void handleLoadingContainer(boolean r8, boolean r9, boolean r10) {
        handleLoadingContainer(this.mTitleBar, this.mLoadingView, this.mContentView, this.mEmptyView, r8, r9, r10);
    }

    public static void handleLoadingContainer(View r1, View r2, boolean r3, boolean r4) {
        setViewShown(r1, !r3, r4);
        setViewShown(r2, r3, r4);
    }

    public static void handleLoadingContainer(View r0, View r1, View r2, View r3, boolean r4, boolean r5, boolean r6) {
        if (r3 == null) goto L4;
        setViewShown(r3, r5, r6);
    L4:
        setViewShown(r2, r4, r6);
        if (r4 == true) goto L8;
        if (r5 == true) goto L8;
        boolean r7 = true;
    L9:
        setViewShown(r1, r7, r6);
        return;
    L8:
        r7 = false;
        goto L9
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
