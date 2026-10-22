package com.obric.security.cleaner.trashclear;

import kotlin.Metadata;
import tmsdk.fg.module.cleanV2.IScanTaskCallBack;
import tmsdk.fg.module.cleanV2.RubbishEntity;
import tmsdk.fg.module.cleanV2.RubbishHolder;

/* JADX INFO: compiled from: AbstractScanTaskCallBack.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\fH\u0016J\u001a\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016¨\u0006\u0010"}, d2 = {"Lcom/obric/security/cleaner/trashclear/AbstractScanTaskCallBack;", "Ltmsdk/fg/module/cleanV2/IScanTaskCallBack;", "()V", "onDirectoryChange", "", "p0", "", "p1", "", "onRubbishFound", "Ltmsdk/fg/module/cleanV2/RubbishEntity;", "onScanCanceled", "Ltmsdk/fg/module/cleanV2/RubbishHolder;", "onScanError", "onScanFinished", "onScanStarted", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public abstract class AbstractScanTaskCallBack implements IScanTaskCallBack {
    @Override // tmsdk.fg.module.cleanV2.IScanTaskCallBack
    public void onDirectoryChange(String r1, int r2) {
    }

    @Override // tmsdk.fg.module.cleanV2.IScanTaskCallBack
    public void onRubbishFound(RubbishEntity r1) {
    }

    @Override // tmsdk.fg.module.cleanV2.IScanTaskCallBack
    public void onScanCanceled(RubbishHolder r1) {
    }

    @Override // tmsdk.fg.module.cleanV2.IScanTaskCallBack
    public void onScanError(int r1, RubbishHolder r2) {
    }

    @Override // tmsdk.fg.module.cleanV2.IScanTaskCallBack
    public void onScanFinished(RubbishHolder r1) {
    }

    @Override // tmsdk.fg.module.cleanV2.IScanTaskCallBack
    public void onScanStarted() {
    }

    public AbstractScanTaskCallBack() {
    }
}
