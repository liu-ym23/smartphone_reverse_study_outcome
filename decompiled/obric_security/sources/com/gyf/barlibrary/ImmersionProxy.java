package com.gyf.barlibrary;

import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: classes2.dex */
public class ImmersionProxy {
    private Fragment mFragment;
    private ImmersionOwner mImmersionOwner;
    private boolean mIsActivityCreated;
    private boolean mIsLazyAfterView;
    private boolean mIsLazyBeforeView;

    /* JADX WARN: Multi-variable type inference failed */
    public ImmersionProxy(Fragment r2) {
        this.mFragment = r2;
        if ((r2 instanceof ImmersionOwner) == false) goto L7;
        this.mImmersionOwner = (ImmersionOwner) r2;
        return;
    L7:
        throw new IllegalArgumentException("please implement SimpleImmersionOwner in your Fragment");
    }

    public void setUserVisibleHint(boolean r2) {
        Fragment r3 = this.mFragment;
        if (r3 != null) goto L5;
        return;
    L5:
        if (r3.getUserVisibleHint() == false) goto L21;
        if (this.mIsLazyBeforeView == true) goto L10;
        this.mImmersionOwner.onLazyBeforeView();
        this.mIsLazyBeforeView = true;
    L10:
        if (this.mIsActivityCreated == true) goto L12;
        return;
    L12:
        if (this.mFragment.getUserVisibleHint() == true) goto L14;
        return;
    L14:
        if (this.mImmersionOwner.immersionBarEnabled() == false) goto L17;
        this.mImmersionOwner.initImmersionBar();
    L17:
        if (this.mIsLazyAfterView == true) goto L19;
        this.mImmersionOwner.onLazyAfterView();
        this.mIsLazyAfterView = true;
    L19:
        this.mImmersionOwner.onVisible();
        return;
    L21:
        if (this.mIsActivityCreated == false) goto L28;
        this.mImmersionOwner.onInvisible();
        return;
    }

    public void onCreate(Bundle r1) {
        Fragment r2 = this.mFragment;
        if (r2 != null) goto L5;
        return;
    L5:
        if (r2.getUserVisibleHint() == true) goto L7;
        return;
    L7:
        if (this.mIsLazyBeforeView == true) goto L12;
        this.mImmersionOwner.onLazyBeforeView();
        this.mIsLazyBeforeView = true;
        return;
    }

    public void onActivityCreated(Bundle r2) {
        this.mIsActivityCreated = true;
        Fragment r0 = this.mFragment;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getUserVisibleHint() == true) goto L7;
        return;
    L7:
        if (this.mImmersionOwner.immersionBarEnabled() == false) goto L10;
        this.mImmersionOwner.initImmersionBar();
    L10:
        if (this.mIsLazyAfterView == true) goto L15;
        this.mImmersionOwner.onLazyAfterView();
        this.mIsLazyAfterView = true;
        return;
    }

    public void onResume() {
        Fragment r0 = this.mFragment;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getUserVisibleHint() == false) goto L9;
        this.mImmersionOwner.onVisible();
        return;
    }

    public void onPause() {
        if (this.mFragment == null) goto L6;
        this.mImmersionOwner.onInvisible();
        return;
    }

    public void onDestroy() {
        Fragment r0 = this.mFragment;
        if (r0 != null) goto L5;
    L9:
        this.mFragment = null;
        this.mImmersionOwner = null;
        return;
    L5:
        if (r0.getActivity() == null) goto L9;
        if (this.mImmersionOwner.immersionBarEnabled() == false) goto L9;
        ImmersionBar.with(this.mFragment).destroy();
        goto L9
    }

    public void onConfigurationChanged(Configuration r1) {
        Fragment r2 = this.mFragment;
        if (r2 != null) goto L5;
        return;
    L5:
        if (r2.getUserVisibleHint() == true) goto L7;
        return;
    L7:
        if (this.mImmersionOwner.immersionBarEnabled() == false) goto L9;
        this.mImmersionOwner.initImmersionBar();
    L9:
        this.mImmersionOwner.onVisible();
    }

    public void onHiddenChanged(boolean r1) {
        Fragment r0 = this.mFragment;
        if (r0 == null) goto L6;
        r0.setUserVisibleHint(!r1);
        return;
    }

    public boolean isUserVisibleHint() {
        Fragment r0 = this.mFragment;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.getUserVisibleHint();
    }
}
