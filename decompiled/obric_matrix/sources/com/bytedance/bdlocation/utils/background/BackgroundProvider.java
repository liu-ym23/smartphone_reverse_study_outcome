package com.bytedance.bdlocation.utils.background;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class BackgroundProvider {
    private volatile boolean isEnterBackground;
    private List<Callback> mCallback;

    public interface Callback {
        void onAppBackgroundSwitch(boolean r1);
    }

    public BackgroundProvider() {
        this.mCallback = new ArrayList();
        this.isEnterBackground = true;
    }

    public void addCallback(Callback r1) {
        List<Callback> r0 = this.mCallback;
        if (r0 == null) goto L6;
        r0.add(r1);
        return;
    }

    public List<Callback> getCallback() {
        return this.mCallback;
    }

    public boolean isBackground() {
        return this.isEnterBackground;
    }

    public void onAppBackgroundSwitch(boolean r3) {
        this.isEnterBackground = r3;
        List<Callback> r0 = this.mCallback;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.size() <= 0) goto L17;
        int r1 = 0;
    L8:
        if (r1 >= this.mCallback.size()) goto L18;
        if (this.mCallback.get(r1) == null) goto L12;
        this.mCallback.get(r1).onAppBackgroundSwitch(r3);
    L12:
        r1 = r1 + 1;
        goto L8
    L18:
        return;
    }

    public void setCallback(@NonNull List<Callback> r1) {
        if (r1 == null) goto L5;
        this.mCallback = r1;
        return;
    }
}
