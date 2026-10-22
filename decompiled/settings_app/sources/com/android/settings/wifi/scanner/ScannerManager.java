package com.android.settings.wifi.scanner;

import com.android.settings.wifi.scanner.zxing.ZxingBarCoder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ScannerManager.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\bJ\u0006\u0010\f\u001a\u00020\bJ\u0006\u0010\r\u001a\u00020\bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/android/settings/wifi/scanner/ScannerManager;", "", "qrScanResultCallback", "Lcom/android/settings/wifi/scanner/QRScanResultCallback;", "(Lcom/android/settings/wifi/scanner/QRScanResultCallback;)V", "barCoder", "Lcom/android/settings/wifi/scanner/zxing/ZxingBarCoder;", "addSource", "", "source", "Lcom/android/settings/wifi/scanner/SourceData;", "release", "startScan", "stopScan", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ScannerManager {
    private ZxingBarCoder barCoder;
    private final QRScanResultCallback qrScanResultCallback;

    public ScannerManager(QRScanResultCallback r2) {
        Intrinsics.checkNotNullParameter(r2, "qrScanResultCallback");
        this.qrScanResultCallback = r2;
        this.barCoder = new ZxingBarCoder(new ScannerManager$barCoder$1(this));
    }

    public static final /* synthetic */ QRScanResultCallback access$getQrScanResultCallback$p(ScannerManager r0) {
        return r0.qrScanResultCallback;
    }

    public final void addSource(SourceData r2) {
        Intrinsics.checkNotNullParameter(r2, "source");
        this.barCoder.addSource(r2);
    }

    public final void startScan() {
        this.barCoder.startScan();
    }

    public final void stopScan() {
        this.barCoder.stopScan();
    }

    public final void release() {
        this.barCoder.release();
    }
}
