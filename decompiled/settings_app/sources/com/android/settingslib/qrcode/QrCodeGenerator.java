package com.android.settingslib.qrcode;

import android.graphics.Bitmap;
import com.android.settings.wifi.WifiSettings;
import com.bytedance.apm.constant.PerfConsts;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.nio.charset.StandardCharsets;
import java.util.EnumMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: QrCodeGenerator.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0007J,\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/android/settingslib/qrcode/QrCodeGenerator;", "", "()V", "DEFAULT_MARGIN", "", "encodeQrCode", "Landroid/graphics/Bitmap;", WifiSettings.ScannerIntentResult_CONTENTS, "", PerfConsts.PERF_DISK_FILE_SIZE, "invert", "", "margin", "isIso88591", "app_debug"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class QrCodeGenerator {
    private static final int DEFAULT_MARGIN = -1;
    public static final QrCodeGenerator INSTANCE = null;

    static {
        INSTANCE = new QrCodeGenerator();
    }

    @JvmStatic
    public static final Bitmap encodeQrCode(String r7, int r8) throws WriterException, IllegalArgumentException {
        Intrinsics.checkNotNullParameter(r7, WifiSettings.ScannerIntentResult_CONTENTS);
        return encodeQrCode$default(r7, r8, 0, false, 12, null);
    }

    @JvmStatic
    public static final Bitmap encodeQrCode(String r7, int r8, int r9) throws WriterException, IllegalArgumentException {
        Intrinsics.checkNotNullParameter(r7, WifiSettings.ScannerIntentResult_CONTENTS);
        return encodeQrCode$default(r7, r8, r9, false, 8, null);
    }

    private QrCodeGenerator() {
    }

    @JvmStatic
    public static final Bitmap encodeQrCode(String r1, int r2, boolean r3) throws WriterException, IllegalArgumentException {
        Intrinsics.checkNotNullParameter(r1, WifiSettings.ScannerIntentResult_CONTENTS);
        return encodeQrCode(r1, r2, -1, r3);
    }

    public static /* synthetic */ Bitmap encodeQrCode$default(String r0, int r1, int r2, boolean r3, int r4, Object r5) throws WriterException, IllegalArgumentException {
        if ((r4 & 4) == 0) goto L6;
        r2 = -1;
    L6:
        if ((r4 & 8) == 0) goto L9;
        r3 = false;
    L9:
        return encodeQrCode(r0, r1, r2, r3);
    }

    @JvmStatic
    public static final Bitmap encodeQrCode(String r10, int r11, int r12, boolean r13) throws WriterException, IllegalArgumentException {
        Intrinsics.checkNotNullParameter(r10, WifiSettings.ScannerIntentResult_CONTENTS);
        EnumMap r0 = new EnumMap(EncodeHintType.class);
        if (INSTANCE.isIso88591(r10) == true) goto L5;
        r0.put(EncodeHintType.CHARACTER_SET, StandardCharsets.UTF_8.name());
    L5:
        int r1 = -1;
        if (r12 == (-1)) goto L8;
        r0.put(EncodeHintType.MARGIN, Integer.valueOf(r12));
    L8:
        BitMatrix r14 = new MultiFormatWriter().encode(r10, BarcodeFormat.QR_CODE, r11, r11, r0);
        if (r13 == false) goto L11;
        int r2 = -1;
    L12:
        if (r13 == false) goto L14;
        r1 = -16777216;
    L14:
        int[] r3 = new int[r11 * r11];
        int r15 = 0;
    L15:
        if (r15 >= r11) goto L24;
        int r4 = 0;
    L17:
        if (r4 >= r11) goto L23;
        int r5 = (r15 * r11) + r4;
        if (r14.get(r15, r4) == false) goto L21;
        int r6 = r2;
    L22:
        r3[r5] = r6;
        r4 = r4 + 1;
        goto L17
    L21:
        r6 = r1;
        goto L22
    L23:
        r15 = r15 + 1;
        goto L15
    L24:
        Bitmap r16 = Bitmap.createBitmap(r11, r11, Bitmap.Config.RGB_565);
        Intrinsics.checkNotNullExpressionValue(r16, "createBitmap(size, size, Bitmap.Config.RGB_565)");
        r16.setPixels(r3, 0, r11, 0, 0, r11, r11);
        return r16;
    L11:
        r2 = -16777216;
        goto L12
    }

    private final boolean isIso88591(String r1) {
        return StandardCharsets.ISO_8859_1.newEncoder().canEncode(r1);
    }
}
