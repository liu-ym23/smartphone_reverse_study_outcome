package com.ttnet.org.chromium.base;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.ttnet.org.chromium.base.UnownedUserData;
import com.ttnet.org.chromium.build.BuildConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class UnownedUserDataKey<T extends UnownedUserData> {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    @NonNull
    private final Class<T> mClazz;
    private final Set<UnownedUserDataHost> mWeakHostAttachments;

    static {
    }

    public UnownedUserDataKey(@NonNull Class<T> r2) {
        this.mWeakHostAttachments = Collections.newSetFromMap(new WeakHashMap());
        this.mClazz = r2;
    }

    private void assertNoDestroyedAttachments() {
        if (BuildConfig.ENABLE_ASSERTS == false) goto L11;
        Iterator<UnownedUserDataHost> r1 = this.mWeakHostAttachments.iterator();
    L6:
        if (r1.hasNext() == false) goto L15;
        if (r1.next().isDestroyed() == false) goto L6;
        throw new IllegalStateException();
    L15:
        return;
    }

    private void removeHostAttachment(UnownedUserDataHost r1) {
        r1.remove(this);
        this.mWeakHostAttachments.remove(r1);
    }

    public final void attachToHost(@NonNull UnownedUserDataHost r1, @NonNull T r2) {
        Objects.requireNonNull(r2);
        r1.set(this, r2);
        if (isAttachedToHost(r1) == true) goto L6;
        this.mWeakHostAttachments.add(r1);
        return;
    }

    public final void detachFromAllHosts(@NonNull T r4) {
        assertNoDestroyedAttachments();
        Iterator r0 = new ArrayList(this.mWeakHostAttachments).iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        UnownedUserDataHost r1 = (UnownedUserDataHost) r0.next();
        if (r4.equals(r1.get(this)) == false) goto L4;
        removeHostAttachment(r1);
        goto L4
    }

    public final void detachFromHost(@NonNull UnownedUserDataHost r4) {
        assertNoDestroyedAttachments();
        Iterator r0 = new ArrayList(this.mWeakHostAttachments).iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        UnownedUserDataHost r1 = (UnownedUserDataHost) r0.next();
        if (r4.equals(r1) == false) goto L4;
        removeHostAttachment(r1);
        goto L4
    }

    @VisibleForTesting(otherwise = 2)
    int getHostAttachmentCount(@NonNull T r4) {
        assertNoDestroyedAttachments();
        Iterator<UnownedUserDataHost> r0 = this.mWeakHostAttachments.iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L8;
        if (r4.equals(r0.next().get(this)) == false) goto L4;
        r1 = r1 + 1;
        goto L4
    L8:
        return r1;
    }

    @NonNull
    final Class<T> getValueClass() {
        return this.mClazz;
    }

    public final boolean isAttachedToAnyHost(@NonNull T r1) {
        if (getHostAttachmentCount(r1) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isAttachedToHost(@NonNull UnownedUserDataHost r1) {
        if (retrieveDataFromHost(r1) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Nullable
    public final T retrieveDataFromHost(@NonNull UnownedUserDataHost r3) {
        assertNoDestroyedAttachments();
        Iterator<UnownedUserDataHost> r0 = this.mWeakHostAttachments.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        if (r3.equals(r0.next()) == false) goto L4;
        return (T) r3.get(this);
    L9:
        return null;
    }
}
