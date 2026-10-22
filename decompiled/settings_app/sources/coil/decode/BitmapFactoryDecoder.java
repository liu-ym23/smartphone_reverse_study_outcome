package coil.decode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.icu.lang.UCharacter;
import android.icu.text.PluralRules;
import coil.ImageLoader;
import coil.fetch.SourceResult;
import coil.request.Options;
import coil.size.Scale;
import coil.size.Size;
import coil.size.Sizes;
import coil.util.Bitmaps;
import coil.util.Utils;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.InterruptibleKt;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreKt;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;

/* JADX INFO: compiled from: BitmapFactoryDecoder.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00162\u00020\u0001:\u0003\u0016\u0017\u0018B\u0017\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B!\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0011\u0010\r\u001a\u00020\u000eH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u0014\u0010\u0010\u001a\u00020\u0011*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0014\u0010\u0015\u001a\u00020\u0011*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\f\u0010\r\u001a\u00020\u000e*\u00020\u0012H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"Lcoil/decode/BitmapFactoryDecoder;", "Lcoil/decode/Decoder;", "source", "Lcoil/decode/ImageSource;", "options", "Lcoil/request/Options;", "(Lcoil/decode/ImageSource;Lcoil/request/Options;)V", "parallelismLock", "Lkotlinx/coroutines/sync/Semaphore;", "(Lcoil/decode/ImageSource;Lcoil/request/Options;Lkotlinx/coroutines/sync/Semaphore;)V", "exifOrientationPolicy", "Lcoil/decode/ExifOrientationPolicy;", "(Lcoil/decode/ImageSource;Lcoil/request/Options;Lkotlinx/coroutines/sync/Semaphore;Lcoil/decode/ExifOrientationPolicy;)V", "decode", "Lcoil/decode/DecodeResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "configureConfig", "", "Landroid/graphics/BitmapFactory$Options;", "exifData", "Lcoil/decode/ExifData;", "configureScale", "Companion", "ExceptionCatchingSource", "Factory", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BitmapFactoryDecoder implements Decoder {
    public static final Companion Companion = null;
    public static final int DEFAULT_MAX_PARALLELISM = 4;
    private final ExifOrientationPolicy exifOrientationPolicy;
    private final Options options;
    private final Semaphore parallelismLock;
    private final ImageSource source;

    /* JADX INFO: compiled from: BitmapFactoryDecoder.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcoil/decode/BitmapFactoryDecoder$Companion;", "", "()V", "DEFAULT_MAX_PARALLELISM", "", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: BitmapFactoryDecoder.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fH\u0016R.\u0010\b\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u00072\u000e\u0010\u0005\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0010"}, d2 = {"Lcoil/decode/BitmapFactoryDecoder$ExceptionCatchingSource;", "Lokio/ForwardingSource;", "delegate", "Lokio/Source;", "(Lokio/Source;)V", "<set-?>", "Ljava/lang/Exception;", "Lkotlin/Exception;", "exception", "getException", "()Ljava/lang/Exception;", "read", "", "sink", "Lokio/Buffer;", "byteCount", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class ExceptionCatchingSource extends ForwardingSource {
        private Exception exception;

        public ExceptionCatchingSource(Source r1) {
            super(r1);
        }

        public final Exception getException() {
            return this.exception;
        }

        @Override // okio.ForwardingSource, okio.Source
        public long read(Buffer r1, long r2) {
            return super.read(r1, r2);
        L4:
            e = move-exception;
            this.exception = e;
            throw e;
        }
    }

    /* JADX INFO: compiled from: BitmapFactoryDecoder.kt */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0017¢\u0006\u0002\u0010\u0002B\u0011\b\u0017\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0019\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0004H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcoil/decode/BitmapFactoryDecoder$Factory;", "Lcoil/decode/Decoder$Factory;", "()V", "maxParallelism", "", "(I)V", "exifOrientationPolicy", "Lcoil/decode/ExifOrientationPolicy;", "(ILcoil/decode/ExifOrientationPolicy;)V", "parallelismLock", "Lkotlinx/coroutines/sync/Semaphore;", "create", "Lcoil/decode/Decoder;", "result", "Lcoil/fetch/SourceResult;", "options", "Lcoil/request/Options;", "imageLoader", "Lcoil/ImageLoader;", "equals", "", PluralRules.KEYWORD_OTHER, "", "hashCode", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Factory implements Decoder.Factory {
        private final ExifOrientationPolicy exifOrientationPolicy;
        private final Semaphore parallelismLock;

        public Factory(int r3, ExifOrientationPolicy r4) {
            this.exifOrientationPolicy = r4;
            this.parallelismLock = SemaphoreKt.Semaphore$default(r3, 0, 2, null);
        }

        public /* synthetic */ Factory(int r1, ExifOrientationPolicy r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = 4;
        L6:
            if ((r3 & 2) == 0) goto L8;
            r2 = ExifOrientationPolicy.RESPECT_PERFORMANCE;
        L8:
            this(r1, r2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Factory() {
            int r2 = 0;
            this(r2, null, 3, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Kept for binary compatibility.")
        public /* synthetic */ Factory(int r3) {
            this(r3, null, 2, 0 == true ? 1 : 0);
        }

        public /* synthetic */ Factory(int r1, int r2, DefaultConstructorMarker r3) {
            if ((r2 & 1) == 0) goto L5;
            r1 = 4;
        L5:
            this(r1);
        }

        @Override // coil.decode.Decoder.Factory
        public Decoder create(SourceResult r2, Options r3, ImageLoader r4) {
            return new BitmapFactoryDecoder(r2.getSource(), r3, this.parallelismLock, this.exifOrientationPolicy);
        }

        public boolean equals(Object r1) {
            return r1 instanceof Factory;
        }

        public int hashCode() {
            return getClass().hashCode();
        }
    }

    /* JADX INFO: renamed from: coil.decode.BitmapFactoryDecoder$decode$1, reason: invalid class name */
    /* JADX INFO: compiled from: BitmapFactoryDecoder.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "coil.decode.BitmapFactoryDecoder", f = "BitmapFactoryDecoder.kt", i = {0, 0, 1}, l = {UCharacter.UnicodeBlock.LINEAR_A_ID, 46}, m = "decode", n = {"this", "$this$withPermit$iv", "$this$withPermit$iv"}, s = {"L$0", "L$1", "L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ BitmapFactoryDecoder this$0;

        AnonymousClass1(BitmapFactoryDecoder r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.decode(this);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public BitmapFactoryDecoder(ImageSource r1, Options r2, Semaphore r3, ExifOrientationPolicy r4) {
        this.source = r1;
        this.options = r2;
        this.parallelismLock = r3;
        this.exifOrientationPolicy = r4;
    }

    public static final /* synthetic */ DecodeResult access$decode(BitmapFactoryDecoder r0, BitmapFactory.Options r1) {
        return r0.decode(r1);
    }

    public /* synthetic */ BitmapFactoryDecoder(ImageSource r3, Options r4, Semaphore r5, ExifOrientationPolicy r6, int r7, DefaultConstructorMarker r8) {
        if ((r7 & 4) == 0) goto L6;
        r5 = SemaphoreKt.Semaphore$default(Integer.MAX_VALUE, 0, 2, null);
    L6:
        if ((r7 & 8) == 0) goto L8;
        r6 = ExifOrientationPolicy.RESPECT_PERFORMANCE;
    L8:
        this(r3, r4, r5, r6);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Kept for binary compatibility.")
    public /* synthetic */ BitmapFactoryDecoder(ImageSource r8, Options r9) {
        this(r8, r9, null, null, 12, null);
    }

    public /* synthetic */ BitmapFactoryDecoder(ImageSource r2, Options r3, Semaphore r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 4) == 0) goto L5;
        r4 = SemaphoreKt.Semaphore$default(Integer.MAX_VALUE, 0, 2, null);
    L5:
        this(r2, r3, r4);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Kept for binary compatibility.")
    public /* synthetic */ BitmapFactoryDecoder(ImageSource r8, Options r9, Semaphore r10) {
        this(r8, r9, r10, null, 8, null);
    }

    @Override // coil.decode.Decoder
    public Object decode(Continuation<? super DecodeResult> r7) {
        if ((r7 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r7;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L20;
        if (r2 == 1) goto L19;
        if (r2 != 2) goto L18;
        Semaphore r6 = (Semaphore) r0.L$0;
        ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L15
    L27:
        DecodeResult r9 = (DecodeResult) r8;     // Catch: Throwable -> L15
        r6.release();
        return r9;
    L15:
        Throwable th = th;
    L32:
        r6.release();
        throw th;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        Semaphore r10 = (Semaphore) r0.L$1;
        BitmapFactoryDecoder r3 = (BitmapFactoryDecoder) r0.L$0;
        ResultKt.throwOnFailure(r8);
        Semaphore r11 = r10;
        final BitmapFactoryDecoder this = r3;
    L36:
        Function0<DecodeResult> r4 = new BitmapFactoryDecoder$decode$2$1(this);     // Catch: Throwable -> L30
        r0.L$0 = r11;     // Catch: Throwable -> L30
        r0.L$1 = null;     // Catch: Throwable -> L30
        r0.label = 2;     // Catch: Throwable -> L30
        Object r12 = InterruptibleKt.runInterruptible$default(null, r4, r0, 1, null);     // Catch: Throwable -> L30
        if (r12 != r1) goto L26;
        return r1;
    L26:
        Semaphore r5 = r11;
        r8 = r12;
        r6 = r5;
    L30:
        th = move-exception;
        Semaphore r13 = r11;
        th = th;
        r6 = r13;
        goto L32
    L20:
        ResultKt.throwOnFailure(r8);
        r11 = this.parallelismLock;
        r0.L$0 = this;
        r0.L$1 = r11;
        r0.label = 1;
        if (r11.acquire(r0) != r1) goto L36;
        return r1;
    L7:
        r0 = new AnonymousClass1(this, r7);
        goto L8
    }

    private final DecodeResult decode(BitmapFactory.Options r9) {
        ExceptionCatchingSource r0 = new ExceptionCatchingSource(this.source.source());
        BufferedSource r1 = Okio.buffer(r0);
        boolean r2 = true;
        r9.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(r1.peek().inputStream(), null, r9);
        Exception r3 = r0.getException();
        if (r3 != null) goto L31;
        r9.inJustDecodeBounds = false;
        ExifData r5 = ExifUtils.INSTANCE.getExifData(r9.outMimeType, r1, this.exifOrientationPolicy);
        Exception r6 = r0.getException();
        if (r6 != null) goto L30;
        r9.inMutable = false;
        if (this.options.getColorSpace() == null) goto L9;
        r9.inPreferredColorSpace = this.options.getColorSpace();
    L9:
        r9.inPremultiplied = this.options.getPremultipliedAlpha();
        configureConfig(r9, r5);
        configureScale(r9, r5);
        BufferedSource r4 = r1;
        Bitmap r7 = BitmapFactory.decodeStream(r4.inputStream(), null, r9);     // Catch: Throwable -> L25
        CloseableKt.closeFinally(r4, null);
        Exception r8 = r0.getException();
        if (r8 != null) goto L24;
        if (r7 == null) goto L23;
        r7.setDensity(this.options.getContext().getResources().getDisplayMetrics().densityDpi);
        BitmapDrawable r10 = new BitmapDrawable(this.options.getContext().getResources(), ExifUtils.INSTANCE.reverseTransformations(r7, r5));
        if (r9.inSampleSize > 1) goto L21;
        if (r9.inScaled == true) goto L21;
        r2 = false;
    L21:
        return new DecodeResult(r10, r2);
    L23:
        throw new IllegalStateException("BitmapFactory returned a null bitmap. Often this means BitmapFactory could not decode the image data read from the input source (e.g. network, disk, or memory) as it's not encoded as a valid image format.".toString());
    L24:
        throw r8;
    L25:
        th = move-exception;
        throw th;     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        CloseableKt.closeFinally(r4, th);
        throw th;
    L30:
        throw r6;
    L31:
        throw r3;
    }

    private final void configureConfig(BitmapFactory.Options r3, ExifData r4) {
        Bitmap.Config r0 = this.options.getConfig();
        if (r4.isFlipped() == false) goto L5;
    L6:
        r0 = Bitmaps.toSoftware(r0);
    L8:
        if (this.options.getAllowRgb565() == false) goto L15;
        if (r0 != Bitmap.Config.ARGB_8888) goto L15;
        if (Intrinsics.areEqual(r3.outMimeType, Utils.MIME_TYPE_JPEG) == false) goto L15;
        r0 = Bitmap.Config.RGB_565;
    L15:
        if (r3.outConfig == Bitmap.Config.RGBA_F16) goto L17;
    L19:
        r3.inPreferredConfig = r0;
        return;
    L17:
        if (r0 == Bitmap.Config.HARDWARE) goto L19;
        r0 = Bitmap.Config.RGBA_F16;
        goto L19
    L5:
        if (ExifUtilsKt.isRotated(r4) == false) goto L8;
        goto L6
    }

    private final void configureScale(BitmapFactory.Options r22, ExifData r23) {
        ImageSource.Metadata r2 = this.source.getMetadata();
        if ((r2 instanceof ResourceMetadata) == true) goto L5;
    L8:
        boolean r3 = false;
        if (r22.outWidth > 0) goto L11;
    L42:
        r22.inSampleSize = 1;
        r22.inScaled = false;
        return;
    L11:
        if (r22.outHeight <= 0) goto L42;
        if (ExifUtilsKt.isSwapped(r23) == false) goto L16;
        int r4 = r22.outHeight;
    L18:
        if (ExifUtilsKt.isSwapped(r23) == false) goto L20;
        int r5 = r22.outWidth;
    L21:
        Size r6 = this.options.getSize();
        Scale r7 = this.options.getScale();
        if (Sizes.isOriginal(r6) == false) goto L24;
        int r8 = r4;
    L25:
        Size r9 = this.options.getSize();
        Scale r10 = this.options.getScale();
        if (Sizes.isOriginal(r9) == false) goto L28;
        int r11 = r5;
    L29:
        r22.inSampleSize = DecodeUtils.calculateInSampleSize(r4, r5, r8, r11, this.options.getScale());
        double r12 = DecodeUtils.computeSizeMultiplier(((double) r4) / ((double) r22.inSampleSize), ((double) r5) / ((double) r22.inSampleSize), r8, r11, this.options.getScale());
        if (this.options.getAllowInexactSize() == false) goto L33;
        r12 = RangesKt.coerceAtMost(r12, 1.0d);
    L33:
        if (r12 != 1.0d) goto L35;
        r3 = true;
    L35:
        r22.inScaled = !r3;
        if (r22.inScaled == true) goto L38;
        return;
    L38:
        if (r12 <= 1.0d) goto L40;
        r22.inDensity = MathKt.roundToInt(((double) Integer.MAX_VALUE) / r12);
        r22.inTargetDensity = Integer.MAX_VALUE;
        return;
    L40:
        r22.inDensity = Integer.MAX_VALUE;
        r22.inTargetDensity = MathKt.roundToInt(((double) Integer.MAX_VALUE) * r12);
        return;
    L28:
        r11 = Utils.toPx(r9.getHeight(), r10);
        goto L29
    L24:
        r8 = Utils.toPx(r6.getWidth(), r7);
        goto L25
    L20:
        r5 = r22.outHeight;
        goto L21
    L16:
        r4 = r22.outWidth;
        goto L18
    L5:
        if (Sizes.isOriginal(this.options.getSize()) == false) goto L8;
        r22.inSampleSize = 1;
        r22.inScaled = true;
        r22.inDensity = ((ResourceMetadata) r2).getDensity();
        r22.inTargetDensity = this.options.getContext().getResources().getDisplayMetrics().densityDpi;
    }
}
