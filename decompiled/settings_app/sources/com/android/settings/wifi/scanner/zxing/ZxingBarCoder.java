package com.android.settings.wifi.scanner.zxing;

import android.graphics.Bitmap;
import com.android.settings.wifi.scanner.BarDecodeResult;
import com.android.settings.wifi.scanner.SourceData;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.RGBLuminanceSource;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.common.HybridBinarizer;
import com.obric.olog.OLog;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ZxingBarCoder.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u0000 $2\u00020\u0001:\u0001$B*\u0012#\u0010\u0002\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\u0002\u0010\tJ\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0015J\u0010\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0015H\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\u0012\u0010\u001d\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0006\u0010!\u001a\u00020\bJ\u0006\u0010\"\u001a\u00020\bJ\u0006\u0010#\u001a\u00020\bR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR7\u0010\u0002\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\tR\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/android/settings/wifi/scanner/zxing/ZxingBarCoder;", "", "resultCallback", "Lkotlin/Function1;", "Lcom/android/settings/wifi/scanner/BarDecodeResult;", "Lkotlin/ParameterName;", "name", "result", "", "(Lkotlin/jvm/functions/Function1;)V", "decodeService", "Lcom/android/settings/wifi/scanner/zxing/DecoderThread;", "getDecodeService", "()Lcom/android/settings/wifi/scanner/zxing/DecoderThread;", "setDecodeService", "(Lcom/android/settings/wifi/scanner/zxing/DecoderThread;)V", "getResultCallback", "()Lkotlin/jvm/functions/Function1;", "setResultCallback", "sourceQueue", "Ljava/util/concurrent/BlockingQueue;", "Lcom/android/settings/wifi/scanner/SourceData;", "addSource", "", "source", "decodeJpgImageByZxing", "sourceData", "getMultiFormatReader", "Lcom/google/zxing/MultiFormatReader;", "handleScanResult", "onDecodeSuccess", "timestamp", "", "release", "startScan", "stopScan", "Companion", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ZxingBarCoder {
    private static final int BUFFER_SIZE = 5;
    public static final Companion Companion = null;
    private static final String TAG = "BarCoder";
    private volatile DecoderThread decodeService;
    private Function1<? super BarDecodeResult, Unit> resultCallback;
    private final BlockingQueue<SourceData> sourceQueue;

    /* JADX INFO: compiled from: ZxingBarCoder.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/android/settings/wifi/scanner/zxing/ZxingBarCoder$Companion;", "", "()V", "BUFFER_SIZE", "", "TAG", "", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$Ktz2qAE8Ya-o1cwIwsXNQDjXb7k, reason: not valid java name */
    public static /* synthetic */ void m732$r8$lambda$Ktz2qAE8Yao1cwIwsXNQDjXb7k(ZxingBarCoder r0) {
        _init_$lambda$0(r0);
    }

    static {
        Companion = new Companion(null);
    }

    public ZxingBarCoder(Function1<? super BarDecodeResult, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "resultCallback");
        this.resultCallback = r3;
        this.sourceQueue = new LinkedBlockingQueue(5);
        this.decodeService = new DecoderThread(new ZxingBarCoder$$ExternalSyntheticLambda0(this), false);
        DecoderThread r2 = this.decodeService;
        if (r2 == null) goto L6;
        r2.start();
        return;
    }

    public final Function1<BarDecodeResult, Unit> getResultCallback() {
        return this.resultCallback;
    }

    public final void setResultCallback(Function1<? super BarDecodeResult, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.resultCallback = r2;
    }

    public final DecoderThread getDecodeService() {
        return this.decodeService;
    }

    public final void setDecodeService(DecoderThread r1) {
        this.decodeService = r1;
    }

    private static final void _init_$lambda$0(ZxingBarCoder r4) {
        Intrinsics.checkNotNullParameter(r4, "this$0");
    L17:
        DecoderThread r1 = r4.decodeService;     // Catch: Exception -> L13 InterruptedException -> L15
        boolean r2 = false;
        if (r1 != null) goto L6;
    L8:
        if (r2 == false) goto L25;
        SourceData r3 = r4.sourceQueue.take();     // Catch: Exception -> L13 InterruptedException -> L15
        long r5 = System.currentTimeMillis();     // Catch: Exception -> L13 InterruptedException -> L15
        Intrinsics.checkNotNull(r3);     // Catch: Exception -> L13 InterruptedException -> L15
        if (r4.decodeJpgImageByZxing(r3) == false) goto L17;
        r4.onDecodeSuccess(r5);     // Catch: Exception -> L13 InterruptedException -> L15
        goto L17
    L25:
        return;
    L6:
        if (r1.getInterrupt() == true) goto L8;
        r2 = true;
        goto L8
    L15:
        OLog.d(TAG, "Decoder thread was interrupted.");
        Thread.currentThread().interrupt();
        return;
    L13:
        e = move-exception;
        OLog.d(TAG, "cancel decode thread e:" + e);
    }

    public final void startScan() {
        OLog.d(TAG, "startScan start");
        this.sourceQueue.clear();
    }

    public final void release() {
        DecoderThread r0 = this.decodeService;
        if (r0 == null) goto L9;
        OLog.d(TAG, "release: stopping decode thread");
        r0.setInterrupt(true);
        r0.interrupt();
        r0.join(500);     // Catch: InterruptedException -> L7
    L8:
        this.decodeService = null;
    L7:
        Thread.currentThread().interrupt();
    L9:
        this.sourceQueue.clear();
        handleScanResult(null);
    }

    public final void stopScan() {
        OLog.d(TAG, "stopScan");
        this.sourceQueue.clear();
        handleScanResult(null);
    }

    public final boolean addSource(SourceData r3) {
        Intrinsics.checkNotNullParameter(r3, "source");
        if (r3.getType() != SourceData.Type.FROM_GALLERY) goto L11;
        this.sourceQueue.clear();     // Catch: Exception -> L7
        this.sourceQueue.put(r3);     // Catch: Exception -> L7
        return true;
    L7:
        e = move-exception;
        OLog.e(TAG, "add source to sourceQueue failed, exception: " + e.getMessage());
        return false;
    L11:
        return this.sourceQueue.offer(r3);
    }

    private final boolean decodeJpgImageByZxing(SourceData r20) {
        Bitmap r1 = r20.getImage();
        MultiFormatReader r2 = getMultiFormatReader();
        long r3 = System.currentTimeMillis();
        List r4 = CollectionsKt.mutableListOf(new Bitmap[]{r1});
        ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        Bitmap r9 = (Bitmap) r5.next();
        int[] r15 = new int[r9.getWidth() * r9.getHeight()];
        r9.getPixels(r15, 0, r9.getWidth(), 0, 0, r9.getWidth(), r9.getHeight());
        r6.add(new RGBLuminanceSource(r9.getWidth(), r9.getHeight(), r15));
        goto L4
    L6:
        List r7 = CollectionsKt.toMutableList(r6);
        LuminanceSource r8 = ((LuminanceSource) r7.get(0)).invert();
        Intrinsics.checkNotNullExpressionValue(r8, "invert(...)");
        r7.add(r8);
        List r10 = r7;
        ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator r12 = r10.iterator();
    L8:
        if (r12.hasNext() == false) goto L10;
        r11.add(new BinaryBitmap(new HybridBinarizer((LuminanceSource) r12.next())));
        goto L8
    L10:
        Iterator r13 = r11.iterator();
        Result r14 = null;
    L12:
        if (r13.hasNext() == false) goto L24;
        r14 = r2.decodeWithState((BinaryBitmap) r13.next());     // Catch: Throwable -> L20 ReaderException -> L23
        StringBuilder r16 = new StringBuilder().append("zxing barcode success: ");     // Catch: Throwable -> L20 ReaderException -> L23
        if (r14 == null) goto L17;
        String r17 = r14.getText();     // Catch: Throwable -> L20 ReaderException -> L23
    L18:
        OLog.d(TAG, r16.append(r17).toString());     // Catch: Throwable -> L20 ReaderException -> L23
    L19:
        r2.reset();
        goto L24
    L17:
        r17 = null;
    L23:
        r2.reset();
    L20:
        th = move-exception;
        r2.reset();
        throw th;
    L24:
        OLog.d(TAG, "zxing barcode cost: " + (System.currentTimeMillis() - r3) + " ms!");
        if (r14 == null) goto L29;
        handleScanResult(new BarDecodeResult(r14.getText(), r14.getBarcodeFormat(), r20.getType()));
        return true;
    L29:
        if (r20.getType() != SourceData.Type.FROM_GALLERY) goto L31;
        handleScanResult(new BarDecodeResult(null, null, r20.getType()));
    L31:
        return false;
    }

    private final void onDecodeSuccess(long r3) {
        OLog.d(TAG, "decode image cost: " + (System.currentTimeMillis() - r3) + " ms!");
    }

    private final void handleScanResult(BarDecodeResult r1) {
        this.resultCallback.invoke(r1);
    }

    private final MultiFormatReader getMultiFormatReader() {
        MultiFormatReader r3 = new MultiFormatReader();
        EnumSet r0 = EnumSet.noneOf(BarcodeFormat.class);
        Intrinsics.checkNotNullExpressionValue(r0, "noneOf(...)");
        EnumSet r1 = r0;
        r1.addAll(DecodeFormatManager.INSTANCE.getONE_D_FORMATS());
        r1.addAll(DecodeFormatManager.INSTANCE.getQR_CODE_FORMATS());
        r1.addAll(DecodeFormatManager.INSTANCE.getDATA_MATRIX_FORMATS());
        EnumMap r2 = new EnumMap(DecodeHintType.class);
        r2.put(DecodeHintType.POSSIBLE_FORMATS, r1);
        r2.put(DecodeHintType.CHARACTER_SET, "UTF8");
        r2.put(DecodeHintType.TRY_HARDER, true);
        r3.setHints(r2);
        return r3;
    }
}
