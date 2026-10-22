package com.android.settings.wifi.scanner;

import android.icu.text.PluralRules;
import com.google.zxing.BarcodeFormat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BarDecodeResult.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J+\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/android/settings/wifi/scanner/BarDecodeResult;", "", "content", "", "barcodeFormat", "Lcom/google/zxing/BarcodeFormat;", "type", "Lcom/android/settings/wifi/scanner/SourceData$Type;", "(Ljava/lang/String;Lcom/google/zxing/BarcodeFormat;Lcom/android/settings/wifi/scanner/SourceData$Type;)V", "getBarcodeFormat", "()Lcom/google/zxing/BarcodeFormat;", "getContent", "()Ljava/lang/String;", "getType", "()Lcom/android/settings/wifi/scanner/SourceData$Type;", "component1", "component2", "component3", "copy", "equals", "", PluralRules.KEYWORD_OTHER, "hashCode", "", "toString", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class BarDecodeResult {
    private final BarcodeFormat barcodeFormat;
    private final String content;
    private final SourceData.Type type;

    public static /* synthetic */ BarDecodeResult copy$default(BarDecodeResult r0, String r1, BarcodeFormat r2, SourceData.Type r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.content;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.barcodeFormat;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.type;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.content;
    }

    public final BarcodeFormat component2() {
        return this.barcodeFormat;
    }

    public final SourceData.Type component3() {
        return this.type;
    }

    public final BarDecodeResult copy(String r1, BarcodeFormat r2, SourceData.Type r3) {
        Intrinsics.checkNotNullParameter(r3, "type");
        return new BarDecodeResult(r1, r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof BarDecodeResult) == true) goto L8;
        return false;
    L8:
        BarDecodeResult r6 = (BarDecodeResult) r5;
        if (Intrinsics.areEqual(this.content, r6.content) == true) goto L12;
        return false;
    L12:
        if (this.barcodeFormat == r6.barcodeFormat) goto L15;
        return false;
    L15:
        if (this.type == r6.type) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r0 = this.content;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        BarcodeFormat r4 = this.barcodeFormat;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return ((r3 + r1) * 31) + this.type.hashCode();
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "BarDecodeResult(content=" + this.content + ", barcodeFormat=" + this.barcodeFormat + ", type=" + this.type + ')';
    }

    public BarDecodeResult(String r2, BarcodeFormat r3, SourceData.Type r4) {
        Intrinsics.checkNotNullParameter(r4, "type");
        this.content = r2;
        this.barcodeFormat = r3;
        this.type = r4;
    }

    public final String getContent() {
        return this.content;
    }

    public final BarcodeFormat getBarcodeFormat() {
        return this.barcodeFormat;
    }

    public final SourceData.Type getType() {
        return this.type;
    }
}
