package com.android.settings.wifi.scanner.zxing;

import com.google.zxing.BarcodeFormat;
import java.util.Vector;
import kotlin.Metadata;

/* JADX INFO: compiled from: DecodeFormatManager.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/android/settings/wifi/scanner/zxing/DecodeFormatManager;", "", "()V", "DATA_MATRIX_FORMATS", "Ljava/util/Vector;", "Lcom/google/zxing/BarcodeFormat;", "getDATA_MATRIX_FORMATS", "()Ljava/util/Vector;", "ONE_D_FORMATS", "getONE_D_FORMATS", "PRODUCT_FORMATS", "QR_CODE_FORMATS", "getQR_CODE_FORMATS", "isSupportedFormat", "", "type", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DecodeFormatManager {
    private static final Vector<BarcodeFormat> DATA_MATRIX_FORMATS = null;
    public static final DecodeFormatManager INSTANCE = null;
    private static final Vector<BarcodeFormat> ONE_D_FORMATS = null;
    private static final Vector<BarcodeFormat> PRODUCT_FORMATS = null;
    private static final Vector<BarcodeFormat> QR_CODE_FORMATS = null;

    private DecodeFormatManager() {
    }

    static {
        INSTANCE = new DecodeFormatManager();
        Vector<BarcodeFormat> r0 = new Vector(5);
        PRODUCT_FORMATS = r0;
        Vector<BarcodeFormat> r1 = new Vector(r0.size() + 4);
        ONE_D_FORMATS = r1;
        Vector<BarcodeFormat> r2 = new Vector(1);
        QR_CODE_FORMATS = r2;
        Vector<BarcodeFormat> r4 = new Vector(1);
        DATA_MATRIX_FORMATS = r4;
        r1.addAll(r0);
        r1.add(BarcodeFormat.CODE_39);
        r1.add(BarcodeFormat.CODE_93);
        r1.add(BarcodeFormat.CODE_128);
        r2.add(BarcodeFormat.QR_CODE);
        r4.add(BarcodeFormat.DATA_MATRIX);
    }

    public final Vector<BarcodeFormat> getONE_D_FORMATS() {
        return ONE_D_FORMATS;
    }

    public final Vector<BarcodeFormat> getQR_CODE_FORMATS() {
        return QR_CODE_FORMATS;
    }

    public final Vector<BarcodeFormat> getDATA_MATRIX_FORMATS() {
        return DATA_MATRIX_FORMATS;
    }

    public final boolean isSupportedFormat(BarcodeFormat r1) {
        if (ONE_D_FORMATS.contains(r1) == false) goto L5;
    L10:
        return true;
    L5:
        if (QR_CODE_FORMATS.contains(r1) == true) goto L10;
        if (DATA_MATRIX_FORMATS.contains(r1) == true) goto L10;
        return false;
    }
}
