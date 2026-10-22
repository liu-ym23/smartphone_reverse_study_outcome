package com.gyf.barlibrary;

import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: classes4.dex */
public class SimpleImmersionProxy {
    private Fragment mFragment;
    private boolean mIsActivityCreated;
    private SimpleImmersionOwner mSimpleImmersionOwner;

    /* JADX WARN: Multi-variable type inference failed */
    public SimpleImmersionProxy(Fragment r2) {
        this.mFragment = r2;
        if ((r2 instanceof SimpleImmersionOwner) == false) goto L7;
        this.mSimpleImmersionOwner = (SimpleImmersionOwner) r2;
        return;
    L7:
        throw new IllegalArgumentException("please implement SimpleImmersionOwner in your Fragment");
    }

    public void setUserVisibleHint(boolean r1) {
        setImmersionBar();
    }

    public void onActivityCreated(Bundle r1) {
        this.mIsActivityCreated = true;
        setImmersionBar();
    }

    public void onDestroy() {
        Fragment r0 = this.mFragment;
        if (r0 != null) goto L5;
    L9:
        this.mFragment = null;
        this.mSimpleImmersionOwner = null;
        return;
    L5:
        if (r0.getActivity() == null) goto L9;
        if (this.mSimpleImmersionOwner.immersionBarEnabled() == false) goto L9;
        ImmersionBar.with(this.mFragment).destroy();
        goto L9
    }

    public void onConfigurationChanged(Configuration r1) {
        setImmersionBar();
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

    private void setImmersionBar() {
        Fragment r0 = this.mFragment;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.mIsActivityCreated == true) goto L7;
        return;
    L7:
        if (r0.getUserVisibleHint() == true) goto L9;
        return;
    L9:
        if (this.mSimpleImmersionOwner.immersionBarEnabled() == false) goto L15;
        this.mSimpleImmersionOwner.initImmersionBar();
        return;
    }
}
