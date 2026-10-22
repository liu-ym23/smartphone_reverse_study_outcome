package com.google.zxing;

import com.google.zxing.common.BitMatrix;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public interface Writer {
    BitMatrix encode(String r1, BarcodeFormat r2, int r3, int r4) throws WriterException;

    BitMatrix encode(String r1, BarcodeFormat r2, int r3, int r4, Map<EncodeHintType, ?> r5) throws WriterException;
}
