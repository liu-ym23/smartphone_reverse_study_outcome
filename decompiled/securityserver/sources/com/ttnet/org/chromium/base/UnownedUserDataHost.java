package com.ttnet.org.chromium.base;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.ttnet.org.chromium.base.lifetime.DestroyChecker;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class UnownedUserDataHost {
    private final DestroyChecker mDestroyChecker;
    private Handler mHandler;
    private final ThreadUtils.ThreadChecker mThreadChecker;
    private HashMap<UnownedUserDataKey<?>, WeakReference<? extends UnownedUserData>> mUnownedUserDataMap;

    public UnownedUserDataHost() {
        this(new Handler(retrieveNonNullLooperOrThrow()));
    }

    public static /* synthetic */ void a(UnownedUserDataHost r0, UnownedUserData r1) {
        r0.lambda$remove$0(r1);
    }

    private void checkState() {
        this.mThreadChecker.assertOnValidThread();
        this.mDestroyChecker.checkNotDestroyed();
    }

    private /* synthetic */ void lambda$remove$0(UnownedUserData r1) {
        r1.onDetachedFromHost(this);
    }

    private static Looper retrieveNonNullLooperOrThrow() {
        Looper r0 = Looper.myLooper();
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException();
    }

    public void destroy() {
        this.mThreadChecker.assertOnValidThread();
        if (this.mDestroyChecker.isDestroyed() == false) goto L5;
        return;
    L5:
        Iterator r0 = new HashSet(this.mUnownedUserDataMap.keySet()).iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        ((UnownedUserDataKey) r0.next()).detachFromHost(this);
        goto L7
    L9:
        this.mUnownedUserDataMap = null;
        this.mHandler = null;
        this.mDestroyChecker.destroy();
    }

    @Nullable
    public <T extends UnownedUserData> T get(@NonNull UnownedUserDataKey<T> r3) {
        checkState();
        WeakReference<? extends UnownedUserData> r0 = this.mUnownedUserDataMap.get(r3);
        if (r0 != null) goto L5;
        return null;
    L5:
        UnownedUserData r1 = r0.get();
        if (r1 != null) goto L10;
        r3.detachFromHost(this);
        return null;
    L10:
        return r3.getValueClass().cast(r1);
    }

    @VisibleForTesting(otherwise = 5)
    public int getMapSize() {
        checkState();
        return this.mUnownedUserDataMap.size();
    }

    public boolean isDestroyed() {
        return this.mDestroyChecker.isDestroyed();
    }

    public <T extends UnownedUserData> void remove(@NonNull UnownedUserDataKey<T> r4) {
        checkState();
        WeakReference<? extends UnownedUserData> r5 = this.mUnownedUserDataMap.remove(r4);
        if (r5 != null) goto L5;
        return;
    L5:
        UnownedUserData r6 = r5.get();
        if (r6 != null) goto L8;
        return;
    L8:
        if (r6.informOnDetachmentFromHost() == false) goto L12;
        this.mHandler.post(new androidx.constraintlayout.motion.widget.a(10, this, r6));
        return;
    }

    public <T extends UnownedUserData> void set(@NonNull UnownedUserDataKey<T> r2, @NonNull T r3) {
        checkState();
        if (this.mUnownedUserDataMap.containsKey(r2) == true) goto L5;
    L7:
        this.mUnownedUserDataMap.put(r2, new WeakReference(r3));
        return;
    L5:
        if (r3.equals(get(r2)) == true) goto L7;
        r2.detachFromHost(this);
        goto L7
    }

    @VisibleForTesting(otherwise = 2)
    public UnownedUserDataHost(Handler r2) {
        this.mThreadChecker = new ThreadUtils.ThreadChecker();
        this.mDestroyChecker = new DestroyChecker();
        this.mUnownedUserDataMap = new HashMap();
        this.mHandler = r2;
    }
}
