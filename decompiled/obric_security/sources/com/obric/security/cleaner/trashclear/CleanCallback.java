package com.obric.security.cleaner.trashclear;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import tmsdk.fg.module.cleanV2.ICleanTaskCallBack;

/* JADX INFO: compiled from: CleanCallback.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0005J\b\u0010\n\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\bH\u0016J\u001a\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\bH\u0016J\u0010\u0010\u0014\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0005R\"\u0010\u0003\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0005`\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/security/cleaner/trashclear/CleanCallback;", "Ltmsdk/fg/module/cleanV2/ICleanTaskCallBack;", "()V", "cleanStatusCallBacks", "Ljava/util/ArrayList;", "Lcom/obric/security/cleaner/trashclear/CleanStatusCallBack;", "Lkotlin/collections/ArrayList;", "addCleanStatusCallBack", "", "callBack", "onCleanCanceled", "onCleanError", "p0", "", "onCleanFinished", "onCleanProcessChange", "percent", "path", "", "onCleanStarted", "removeCleanStatusCallBack", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class CleanCallback implements ICleanTaskCallBack {
    private final ArrayList<CleanStatusCallBack> cleanStatusCallBacks;

    @Override // tmsdk.fg.module.cleanV2.ICleanTaskCallBack
    public void onCleanError(int r1) {
    }

    public CleanCallback() {
        this.cleanStatusCallBacks = new ArrayList();
    }

    public final void addCleanStatusCallBack(CleanStatusCallBack r2) {
        if (this.cleanStatusCallBacks.contains(r2) == true) goto L6;
        this.cleanStatusCallBacks.add(r2);
        return;
    }

    public final void removeCleanStatusCallBack(CleanStatusCallBack r1) {
        this.cleanStatusCallBacks.remove(r1);
    }

    @Override // tmsdk.fg.module.cleanV2.ICleanTaskCallBack
    public void onCleanStarted() {
        Iterator<T> r1 = this.cleanStatusCallBacks.iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        CleanStatusCallBack r0 = (CleanStatusCallBack) r1.next();
        if (r0 == null) goto L4;
        r0.onCleanStarted();
        goto L4
    }

    @Override // tmsdk.fg.module.cleanV2.ICleanTaskCallBack
    public void onCleanProcessChange(int r2, String r3) {
        Iterator<T> r1 = this.cleanStatusCallBacks.iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        CleanStatusCallBack r0 = (CleanStatusCallBack) r1.next();
        if (r0 == null) goto L4;
        r0.onCleanProcessChange(r2, r3);
        goto L4
    }

    @Override // tmsdk.fg.module.cleanV2.ICleanTaskCallBack
    public void onCleanCanceled() {
        Iterator<T> r1 = this.cleanStatusCallBacks.iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        CleanStatusCallBack r0 = (CleanStatusCallBack) r1.next();
        if (r0 == null) goto L4;
        r0.onCleanCanceled();
        goto L4
    }

    @Override // tmsdk.fg.module.cleanV2.ICleanTaskCallBack
    public void onCleanFinished() {
        Iterator<T> r1 = this.cleanStatusCallBacks.iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        CleanStatusCallBack r0 = (CleanStatusCallBack) r1.next();
        if (r0 == null) goto L4;
        r0.onCleanFinished();
        goto L4
    }
}
