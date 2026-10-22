package com.obric.security.cleaner.trashclear;

import kotlin.Metadata;

/* JADX INFO: compiled from: CleanStatusCallBack.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u001a\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016¨\u0006\u000b"}, d2 = {"Lcom/obric/security/cleaner/trashclear/CleanStatusCallBack;", "", "onCleanCanceled", "", "onCleanFinished", "onCleanProcessChange", "percent", "", "path", "", "onCleanStarted", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public interface CleanStatusCallBack {

    /* JADX INFO: compiled from: CleanStatusCallBack.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static void onCleanCanceled(CleanStatusCallBack r0) {
        }

        public static void onCleanFinished(CleanStatusCallBack r0) {
        }

        public static void onCleanProcessChange(CleanStatusCallBack r0, int r1, String r2) {
        }

        public static void onCleanStarted(CleanStatusCallBack r0) {
        }
    }

    void onCleanCanceled();

    void onCleanFinished();

    void onCleanProcessChange(int r1, String r2);

    void onCleanStarted();
}
