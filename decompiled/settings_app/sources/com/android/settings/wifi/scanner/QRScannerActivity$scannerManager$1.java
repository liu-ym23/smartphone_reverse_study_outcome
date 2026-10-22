package com.android.settings.wifi.scanner;

import android.net.wifi.WifiManager;
import com.android.settings.R;
import com.android.settings.wifi.scanner.zxing.DecodeFormatManager;
import com.obric.olog.OLog;
import com.obric.oui.toast.OToast;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: QRScannerActivity.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/android/settings/wifi/scanner/QRScannerActivity$scannerManager$1", "Lcom/android/settings/wifi/scanner/QRScanResultCallback;", "onResult", "", "result", "Lcom/android/settings/wifi/scanner/BarDecodeResult;", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class QRScannerActivity$scannerManager$1 implements QRScanResultCallback {
    final /* synthetic */ QRScannerActivity this$0;

    /* JADX INFO: renamed from: $r8$lambda$wF0gS0BJARMTA-mai9rv6BgG6NY, reason: not valid java name */
    public static /* synthetic */ void m731$r8$lambda$wF0gS0BJARMTAmai9rv6BgG6NY(QRScannerActivity r0) {
        onResult$lambda$0(r0);
    }

    QRScannerActivity$scannerManager$1(QRScannerActivity r1) {
        this.this$0 = r1;
    }

    @Override // com.android.settings.wifi.scanner.QRScanResultCallback
    public void onResult(BarDecodeResult r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        if (r6.getContent() == null) goto L20;
        String r0 = r6.getContent();
        Intrinsics.checkNotNull(r0);
        if (StringsKt.isBlank(r0) == true) goto L20;
        if (DecodeFormatManager.INSTANCE.isSupportedFormat(r6.getBarcodeFormat()) == true) goto L12;
        OLog.e(QRScannerActivity.TAG, "not supported barcode format!");
        return;
    L12:
        WifiParsedResult r1 = new WifiResultParser().parse(r6.getContent());
        if (r1 != null) goto L16;
        OLog.d(QRScannerActivity.TAG, "wifi result is empty!");
        final QRScannerActivity r5 = this.this$0;
        r5.runOnUiThread(new QRScannerActivity$scannerManager$1$$ExternalSyntheticLambda0(r5));
        return;
    L16:
        WifiManager r3 = QRScannerActivity.access$getMWifiManager$p(this.this$0);
        if (r3 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mWifiManager");
        r3 = null;
    L19:
        new WifiConfigManager(r3).execute(new WifiParsedResult[]{r1});
        OLog.d(QRScannerActivity.TAG, "scan result: " + r6);
        QRScannerActivity.access$closeAndFinish(this.this$0);
        return;
    L20:
        OLog.e(QRScannerActivity.TAG, "scan result is empty!");
    }

    private static final void onResult$lambda$0(QRScannerActivity r10) {
        Intrinsics.checkNotNullParameter(r10, "this$0");
        QRScannerActivity r2 = r10;
        String r3 = r10.getResources().getString(R.string.result_barcode_error);
        Intrinsics.checkNotNullExpressionValue(r3, "getString(...)");
        new OToast(r2, r3, 80, true, null, 0, 48, null).show();
    }
}
