package androidx.transition;

import android.os.IBinder;

/* JADX INFO: loaded from: classes.dex */
class WindowIdApi14 implements WindowIdImpl {
    private final IBinder mToken;

    WindowIdApi14(IBinder r1) {
        this.mToken = r1;
    }

    public boolean equals(Object r2) {
        if ((r2 instanceof WindowIdApi14) == true) goto L5;
    L7:
        return false;
    L5:
        if (((WindowIdApi14) r2).mToken.equals(this.mToken) == false) goto L7;
        return true;
    }

    public int hashCode() {
        return this.mToken.hashCode();
    }
}
