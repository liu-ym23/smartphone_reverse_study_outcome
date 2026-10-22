package com.obric.securitycenter.api;

import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: UrlCheckResult.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J4\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0013"}, d2 = {"Lcom/obric/securitycenter/api/ApkScanListener;", "", "onScanCanceled", "", "var1", "", "onScanContinue", "onScanError", "onScanFinished", "var2", "", "Lcom/obric/securitycenter/api/ApkResultEntity;", "onScanPaused", "onScanProgress", "var3", "var4", "", "var5", "onScanStarted", "api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface ApkScanListener {

    /* JADX INFO: compiled from: UrlCheckResult.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {
        public static void onScanCanceled(ApkScanListener r0, int r1) {
        }

        public static void onScanContinue(ApkScanListener r0, int r1) {
        }

        public static void onScanError(ApkScanListener r0, int r1) {
        }

        public static void onScanPaused(ApkScanListener r0, int r1) {
        }

        public static void onScanProgress(ApkScanListener r0, int r1, int r2, int r3, String r4, String r5) {
        }

        public static void onScanStarted(ApkScanListener r0, int r1) {
        }
    }

    void onScanCanceled(int r1);

    void onScanContinue(int r1);

    void onScanError(int r1);

    void onScanFinished(int r1, List<ApkResultEntity> r2);

    void onScanPaused(int r1);

    void onScanProgress(int r1, int r2, int r3, String r4, String r5);

    void onScanStarted(int r1);
}
