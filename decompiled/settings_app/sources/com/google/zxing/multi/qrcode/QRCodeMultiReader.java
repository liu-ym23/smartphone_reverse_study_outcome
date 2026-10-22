package com.google.zxing.multi.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.multi.MultipleBarcodeReader;
import com.google.zxing.multi.qrcode.detector.MultiDetector;
import com.google.zxing.qrcode.QRCodeReader;
import com.google.zxing.qrcode.decoder.QRCodeDecoderMetaData;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class QRCodeMultiReader extends QRCodeReader implements MultipleBarcodeReader {
    private static final Result[] EMPTY_RESULT_ARRAY = null;
    private static final ResultPoint[] NO_POINTS = null;

    /* JADX INFO: renamed from: com.google.zxing.multi.qrcode.QRCodeMultiReader$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class SAComparator implements Serializable, Comparator<Result> {
        private SAComparator() {
        }

        /* synthetic */ SAComparator(AnonymousClass1 r1) {
            this();
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Result r1, Result r2) {
            return compare2(r1, r2);
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(Result r1, Result r2) {
            return Integer.compare(((Integer) r1.getResultMetadata().get(ResultMetadataType.STRUCTURED_APPEND_SEQUENCE)).intValue(), ((Integer) r2.getResultMetadata().get(ResultMetadataType.STRUCTURED_APPEND_SEQUENCE)).intValue());
        }
    }

    public QRCodeMultiReader() {
    }

    static {
        EMPTY_RESULT_ARRAY = new Result[0];
        NO_POINTS = new ResultPoint[0];
    }

    @Override // com.google.zxing.multi.MultipleBarcodeReader
    public Result[] decodeMultiple(BinaryBitmap r2) throws NotFoundException {
        return decodeMultiple(r2, null);
    }

    @Override // com.google.zxing.multi.MultipleBarcodeReader
    public Result[] decodeMultiple(BinaryBitmap r10, Map<DecodeHintType, ?> r11) throws NotFoundException {
        ArrayList r0 = new ArrayList();
        DetectorResult[] r12 = new MultiDetector(r10.getBlackMatrix()).detectMulti(r11);
        int r1 = r12.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L20;
        DetectorResult r3 = r12[r2];
        DecoderResult r4 = getDecoder().decode(r3.getBits(), r11);     // Catch: ReaderException -> L25
        ResultPoint[] r5 = r3.getPoints();     // Catch: ReaderException -> L25
        if ((r4.getOther() instanceof QRCodeDecoderMetaData) == false) goto L8;
        ((QRCodeDecoderMetaData) r4.getOther()).applyMirroredCorrection(r5);     // Catch: ReaderException -> L25
    L8:
        Result r6 = new Result(r4.getText(), r4.getRawBytes(), r5, BarcodeFormat.QR_CODE);     // Catch: ReaderException -> L25
        List<byte[]> r7 = r4.getByteSegments();     // Catch: ReaderException -> L25
        if (r7 == null) goto L11;
        r6.putMetadata(ResultMetadataType.BYTE_SEGMENTS, r7);     // Catch: ReaderException -> L25
    L11:
        String r8 = r4.getECLevel();     // Catch: ReaderException -> L25
        if (r8 == null) goto L15;
        r6.putMetadata(ResultMetadataType.ERROR_CORRECTION_LEVEL, r8);     // Catch: ReaderException -> L25
    L15:
        if (r4.hasStructuredAppend() == false) goto L17;
        r6.putMetadata(ResultMetadataType.STRUCTURED_APPEND_SEQUENCE, Integer.valueOf(r4.getStructuredAppendSequenceNumber()));     // Catch: ReaderException -> L25
        r6.putMetadata(ResultMetadataType.STRUCTURED_APPEND_PARITY, Integer.valueOf(r4.getStructuredAppendParity()));     // Catch: ReaderException -> L25
    L17:
        r0.add(r6);     // Catch: ReaderException -> L25
    L18:
        r2 = r2 + 1;
        goto L3
    L20:
        if (r0.isEmpty() == true) goto L22;
        List<Result> r9 = processStructuredAppend(r0);
        return (Result[]) r9.toArray(new Result[r9.size()]);
    L22:
        return EMPTY_RESULT_ARRAY;
    }

    private static List<Result> processStructuredAppend(List<Result> r11) {
        Iterator<Result> r0 = r11.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        if (r0.next().getResultMetadata().containsKey(ResultMetadataType.STRUCTURED_APPEND_SEQUENCE) == false) goto L4;
        boolean r1 = true;
    L9:
        if (r1 == true) goto L11;
        return r11;
    L11:
        ArrayList r2 = new ArrayList();
        ArrayList r3 = new ArrayList();
        Iterator<Result> r12 = r11.iterator();
    L13:
        if (r12.hasNext() == false) goto L17;
        Result r4 = r12.next();
        r2.add(r4);
        if (r4.getResultMetadata().containsKey(ResultMetadataType.STRUCTURED_APPEND_SEQUENCE) == false) goto L13;
        r3.add(r4);
        goto L13
    L17:
        Collections.sort(r3, new SAComparator(null));
        StringBuilder r13 = new StringBuilder();
        Iterator r5 = r3.iterator();
        int r6 = 0;
        int r7 = 0;
    L19:
        if (r5.hasNext() == false) goto L26;
        Result r8 = (Result) r5.next();
        r13.append(r8.getText());
        r6 = r6 + r8.getRawBytes().length;
        if (r8.getResultMetadata().containsKey(ResultMetadataType.BYTE_SEGMENTS) == false) goto L19;
        Iterator r9 = ((Iterable) r8.getResultMetadata().get(ResultMetadataType.BYTE_SEGMENTS)).iterator();
    L24:
        if (r9.hasNext() == false) goto L19;
        r7 = r7 + ((byte[]) r9.next()).length;
        goto L24
    L26:
        byte[] r10 = new byte[r6];
        byte[] r14 = new byte[r7];
        Iterator r15 = r3.iterator();
        int r16 = 0;
        int r17 = 0;
    L28:
        if (r15.hasNext() == false) goto L35;
        Result r18 = (Result) r15.next();
        System.arraycopy(r18.getRawBytes(), 0, r10, r16, r18.getRawBytes().length);
        r16 = r16 + r18.getRawBytes().length;
        if (r18.getResultMetadata().containsKey(ResultMetadataType.BYTE_SEGMENTS) == false) goto L28;
        Iterator r19 = ((Iterable) r18.getResultMetadata().get(ResultMetadataType.BYTE_SEGMENTS)).iterator();
    L33:
        if (r19.hasNext() == false) goto L28;
        byte[] r20 = (byte[]) r19.next();
        System.arraycopy(r20, 0, r14, r17, r20.length);
        r17 = r17 + r20.length;
        goto L33
    L35:
        Result r21 = new Result(r13.toString(), r10, NO_POINTS, BarcodeFormat.QR_CODE);
        if (r7 <= 0) goto L38;
        ArrayList r110 = new ArrayList();
        r110.add(r14);
        r21.putMetadata(ResultMetadataType.BYTE_SEGMENTS, r110);
    L38:
        r2.add(r21);
        return r2;
    L8:
        r1 = false;
        goto L9
    }
}
