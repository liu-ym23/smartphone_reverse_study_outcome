package com.obric.security.cleaner.trashclear;

import kotlin.Metadata;

/* JADX INFO: compiled from: ScanStatusCallBack.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H\u0016¨\u0006\u0006"}, d2 = {"Lcom/obric/security/cleaner/trashclear/ScanStatusCallBack;", "", "onScanCanceled", "", "onScanFinished", "onScanStarted", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public interface ScanStatusCallBack {

    /* JADX INFO: compiled from: ScanStatusCallBack.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static void onScanCanceled(ScanStatusCallBack r0) {
        }

        public static void onScanStarted(ScanStatusCallBack r0) {
        }
    }

    void onScanCanceled();

    void onScanFinished();

    void onScanStarted();
}
