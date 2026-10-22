package com.google.zxing.multi.qrcode.detector;

import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.qrcode.detector.Detector;
import com.google.zxing.qrcode.detector.FinderPatternInfo;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class MultiDetector extends Detector {
    private static final DetectorResult[] EMPTY_DETECTOR_RESULTS = null;

    static {
        EMPTY_DETECTOR_RESULTS = new DetectorResult[0];
    }

    public MultiDetector(BitMatrix r1) {
        super(r1);
    }

    public DetectorResult[] detectMulti(Map<DecodeHintType, ?> r5) throws NotFoundException {
        BitMatrix r0 = getImage();
        if (r5 != null) goto L5;
        ResultPointCallback r1 = null;
    L6:
        FinderPatternInfo[] r6 = new MultiFinderPatternFinder(r0, r1).findMulti(r5);
        if (r6.length == 0) goto L20;
        ArrayList r2 = new ArrayList();
        int r3 = r6.length;
        int r4 = 0;
    L9:
        if (r4 >= r3) goto L14;
        r2.add(processFinderPatternInfo(r6[r4]));     // Catch: ReaderException -> L21
    L12:
        r4 = r4 + 1;
        goto L9
    L14:
        if (r2.isEmpty() == false) goto L18;
        return EMPTY_DETECTOR_RESULTS;
    L18:
        return (DetectorResult[]) r2.toArray(new DetectorResult[r2.size()]);
    L20:
        throw NotFoundException.getNotFoundInstance();
    L5:
        r1 = (ResultPointCallback) r5.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
        goto L6
    }
}
