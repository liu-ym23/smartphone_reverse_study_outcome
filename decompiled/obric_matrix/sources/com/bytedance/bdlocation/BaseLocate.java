package com.bytedance.bdlocation;

import android.content.Context;
import com.bytedance.bdlocation.api.ILocate;
import com.bytedance.bdlocation.callback.LocateCallback;
import com.bytedance.bdlocation.exception.BDLocationException;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseLocate implements ILocate, LocateCallback {
    protected Context mContext;
    protected LocateCallback mLocateCallback;

    public BaseLocate(Context r1) {
        this.mContext = r1;
    }

    @Override // com.bytedance.bdlocation.callback.LocateCallback
    public void onLocateChange(String r1, BDLocation r2) {
        LocateCallback r0 = this.mLocateCallback;
        if (r0 == null) goto L6;
        r0.onLocateChange(r1, r2);
        return;
    }

    @Override // com.bytedance.bdlocation.callback.LocateCallback
    public void onLocateError(String r1, BDLocationException r2) {
        LocateCallback r0 = this.mLocateCallback;
        if (r0 == null) goto L6;
        r0.onLocateError(r1, r2);
        return;
    }

    @Override // com.bytedance.bdlocation.callback.LocateCallback
    public void onLocateStart(String r1) {
        LocateCallback r0 = this.mLocateCallback;
        if (r0 == null) goto L6;
        r0.onLocateStart(r1);
        return;
    }

    @Override // com.bytedance.bdlocation.callback.LocateCallback
    public void onLocateStop(String r1) {
        LocateCallback r0 = this.mLocateCallback;
        if (r0 == null) goto L6;
        r0.onLocateStop(r1);
        return;
    }

    public void setLocateCallback(LocateCallback r1) {
        this.mLocateCallback = r1;
    }
}
