package coil;

import android.graphics.Bitmap;
import coil.decode.DecodeResult;
import coil.decode.Decoder;
import coil.fetch.FetchResult;
import coil.fetch.Fetcher;
import coil.request.ErrorResult;
import coil.request.ImageRequest;
import coil.request.Options;
import coil.request.SuccessResult;
import coil.size.Size;
import coil.transition.Transition;
import com.bytedance.apm.constant.PerfConsts;
import com.obric.capabilitykit.common.Ext;
import kotlin.Metadata;

/* JADX INFO: compiled from: EventListener.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 +2\u00020\u0001:\u0002+,J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0017J \u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0017J*\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0010H\u0017J \u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\tH\u0017J\u001a\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0017J\u0018\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0017H\u0017J\u0018\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0017H\u0017J\u0018\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0017H\u0017J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0017J\u0018\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u001cH\u0017J\u0010\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0017J\u0018\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u001fH\u0017J\u0018\u0010 \u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\"H\u0017J\u0010\u0010#\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0017J\u0018\u0010$\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020%H\u0017J\u0018\u0010&\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020%H\u0017J\u0018\u0010'\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010(\u001a\u00020)H\u0017J\u0018\u0010*\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010(\u001a\u00020)H\u0017ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006-À\u0006\u0003"}, d2 = {"Lcoil/EventListener;", "Lcoil/request/ImageRequest$Listener;", "decodeEnd", "", Ext.KEY_REQUEST, "Lcoil/request/ImageRequest;", "decoder", "Lcoil/decode/Decoder;", "options", "Lcoil/request/Options;", "result", "Lcoil/decode/DecodeResult;", "decodeStart", "fetchEnd", "fetcher", "Lcoil/fetch/Fetcher;", "Lcoil/fetch/FetchResult;", "fetchStart", "keyEnd", "output", "", "keyStart", "input", "", "mapEnd", "mapStart", "onCancel", "onError", "Lcoil/request/ErrorResult;", "onStart", "onSuccess", "Lcoil/request/SuccessResult;", "resolveSizeEnd", PerfConsts.PERF_DISK_FILE_SIZE, "Lcoil/size/Size;", "resolveSizeStart", "transformEnd", "Landroid/graphics/Bitmap;", "transformStart", "transitionEnd", "transition", "Lcoil/transition/Transition;", "transitionStart", "Companion", "Factory", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface EventListener extends ImageRequest.Listener {
    public static final Companion Companion = null;
    public static final EventListener NONE = null;

    /* JADX INFO: compiled from: EventListener.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0013\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001¨\u0006\u0005"}, d2 = {"Lcoil/EventListener$Companion;", "", "()V", "NONE", "Lcoil/EventListener;", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;

        static {
            $$INSTANCE = new Companion();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: EventListener.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static void onStart(EventListener r0, ImageRequest r1) {
            EventListener.access$onStart$jd(r0, r1);
        }

        @Deprecated
        public static void resolveSizeStart(EventListener r0, ImageRequest r1) {
            EventListener.access$resolveSizeStart$jd(r0, r1);
        }

        @Deprecated
        public static void resolveSizeEnd(EventListener r0, ImageRequest r1, Size r2) {
            EventListener.access$resolveSizeEnd$jd(r0, r1, r2);
        }

        @Deprecated
        public static void mapStart(EventListener r0, ImageRequest r1, Object r2) {
            EventListener.access$mapStart$jd(r0, r1, r2);
        }

        @Deprecated
        public static void mapEnd(EventListener r0, ImageRequest r1, Object r2) {
            EventListener.access$mapEnd$jd(r0, r1, r2);
        }

        @Deprecated
        public static void keyStart(EventListener r0, ImageRequest r1, Object r2) {
            EventListener.access$keyStart$jd(r0, r1, r2);
        }

        @Deprecated
        public static void keyEnd(EventListener r0, ImageRequest r1, String r2) {
            EventListener.access$keyEnd$jd(r0, r1, r2);
        }

        @Deprecated
        public static void fetchStart(EventListener r0, ImageRequest r1, Fetcher r2, Options r3) {
            EventListener.access$fetchStart$jd(r0, r1, r2, r3);
        }

        @Deprecated
        public static void fetchEnd(EventListener r0, ImageRequest r1, Fetcher r2, Options r3, FetchResult r4) {
            EventListener.access$fetchEnd$jd(r0, r1, r2, r3, r4);
        }

        @Deprecated
        public static void decodeStart(EventListener r0, ImageRequest r1, Decoder r2, Options r3) {
            EventListener.access$decodeStart$jd(r0, r1, r2, r3);
        }

        @Deprecated
        public static void decodeEnd(EventListener r0, ImageRequest r1, Decoder r2, Options r3, DecodeResult r4) {
            EventListener.access$decodeEnd$jd(r0, r1, r2, r3, r4);
        }

        @Deprecated
        public static void transformStart(EventListener r0, ImageRequest r1, Bitmap r2) {
            EventListener.access$transformStart$jd(r0, r1, r2);
        }

        @Deprecated
        public static void transformEnd(EventListener r0, ImageRequest r1, Bitmap r2) {
            EventListener.access$transformEnd$jd(r0, r1, r2);
        }

        @Deprecated
        public static void transitionStart(EventListener r0, ImageRequest r1, Transition r2) {
            EventListener.access$transitionStart$jd(r0, r1, r2);
        }

        @Deprecated
        public static void transitionEnd(EventListener r0, ImageRequest r1, Transition r2) {
            EventListener.access$transitionEnd$jd(r0, r1, r2);
        }

        @Deprecated
        public static void onCancel(EventListener r0, ImageRequest r1) {
            EventListener.access$onCancel$jd(r0, r1);
        }

        @Deprecated
        public static void onError(EventListener r0, ImageRequest r1, ErrorResult r2) {
            EventListener.access$onError$jd(r0, r1, r2);
        }

        @Deprecated
        public static void onSuccess(EventListener r0, ImageRequest r1, SuccessResult r2) {
            EventListener.access$onSuccess$jd(r0, r1, r2);
        }
    }

    /* JADX INFO: compiled from: EventListener.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Lcoil/EventListener$Factory;", "", "create", "Lcoil/EventListener;", Ext.KEY_REQUEST, "Lcoil/request/ImageRequest;", "Companion", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface Factory {
        public static final Companion Companion = null;
        public static final Factory NONE = null;

        /* JADX INFO: compiled from: EventListener.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0013\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001¨\u0006\u0005"}, d2 = {"Lcoil/EventListener$Factory$Companion;", "", "()V", "NONE", "Lcoil/EventListener$Factory;", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = null;

            static {
                $$INSTANCE = new Companion();
            }

            private Companion() {
            }
        }

        static /* synthetic */ EventListener $r8$lambda$cavXhPPC4B9mj1lT3umPeB6UFGI(ImageRequest r0) {
            return NONE$lambda$0(r0);
        }

        EventListener create(ImageRequest r1);

        static {
            Companion = Companion.$$INSTANCE;
            NONE = new EventListener$Factory$$ExternalSyntheticLambda0();
        }

        private static EventListener NONE$lambda$0(ImageRequest r0) {
            return EventListener.NONE;
        }
    }

    default void decodeEnd(ImageRequest r1, Decoder r2, Options r3, DecodeResult r4) {
    }

    default void decodeStart(ImageRequest r1, Decoder r2, Options r3) {
    }

    default void fetchEnd(ImageRequest r1, Fetcher r2, Options r3, FetchResult r4) {
    }

    default void fetchStart(ImageRequest r1, Fetcher r2, Options r3) {
    }

    default void keyEnd(ImageRequest r1, String r2) {
    }

    default void keyStart(ImageRequest r1, Object r2) {
    }

    default void mapEnd(ImageRequest r1, Object r2) {
    }

    default void mapStart(ImageRequest r1, Object r2) {
    }

    @Override // coil.request.ImageRequest.Listener
    default void onCancel(ImageRequest r1) {
    }

    @Override // coil.request.ImageRequest.Listener
    default void onError(ImageRequest r1, ErrorResult r2) {
    }

    @Override // coil.request.ImageRequest.Listener
    default void onStart(ImageRequest r1) {
    }

    @Override // coil.request.ImageRequest.Listener
    default void onSuccess(ImageRequest r1, SuccessResult r2) {
    }

    default void resolveSizeEnd(ImageRequest r1, Size r2) {
    }

    default void resolveSizeStart(ImageRequest r1) {
    }

    default void transformEnd(ImageRequest r1, Bitmap r2) {
    }

    default void transformStart(ImageRequest r1, Bitmap r2) {
    }

    default void transitionEnd(ImageRequest r1, Transition r2) {
    }

    default void transitionStart(ImageRequest r1, Transition r2) {
    }

    static /* synthetic */ void access$decodeEnd$jd(EventListener r0, ImageRequest r1, Decoder r2, Options r3, DecodeResult r4) {
        super.decodeEnd(r1, r2, r3, r4);
    }

    static /* synthetic */ void access$decodeStart$jd(EventListener r0, ImageRequest r1, Decoder r2, Options r3) {
        super.decodeStart(r1, r2, r3);
    }

    static /* synthetic */ void access$fetchEnd$jd(EventListener r0, ImageRequest r1, Fetcher r2, Options r3, FetchResult r4) {
        super.fetchEnd(r1, r2, r3, r4);
    }

    static /* synthetic */ void access$fetchStart$jd(EventListener r0, ImageRequest r1, Fetcher r2, Options r3) {
        super.fetchStart(r1, r2, r3);
    }

    static /* synthetic */ void access$keyEnd$jd(EventListener r0, ImageRequest r1, String r2) {
        super.keyEnd(r1, r2);
    }

    static /* synthetic */ void access$keyStart$jd(EventListener r0, ImageRequest r1, Object r2) {
        super.keyStart(r1, r2);
    }

    static /* synthetic */ void access$mapEnd$jd(EventListener r0, ImageRequest r1, Object r2) {
        super.mapEnd(r1, r2);
    }

    static /* synthetic */ void access$mapStart$jd(EventListener r0, ImageRequest r1, Object r2) {
        super.mapStart(r1, r2);
    }

    static /* synthetic */ void access$onCancel$jd(EventListener r0, ImageRequest r1) {
        super.onCancel(r1);
    }

    static /* synthetic */ void access$onError$jd(EventListener r0, ImageRequest r1, ErrorResult r2) {
        super.onError(r1, r2);
    }

    static /* synthetic */ void access$onStart$jd(EventListener r0, ImageRequest r1) {
        super.onStart(r1);
    }

    static /* synthetic */ void access$onSuccess$jd(EventListener r0, ImageRequest r1, SuccessResult r2) {
        super.onSuccess(r1, r2);
    }

    static /* synthetic */ void access$resolveSizeEnd$jd(EventListener r0, ImageRequest r1, Size r2) {
        super.resolveSizeEnd(r1, r2);
    }

    static /* synthetic */ void access$resolveSizeStart$jd(EventListener r0, ImageRequest r1) {
        super.resolveSizeStart(r1);
    }

    static /* synthetic */ void access$transformEnd$jd(EventListener r0, ImageRequest r1, Bitmap r2) {
        super.transformEnd(r1, r2);
    }

    static /* synthetic */ void access$transformStart$jd(EventListener r0, ImageRequest r1, Bitmap r2) {
        super.transformStart(r1, r2);
    }

    static /* synthetic */ void access$transitionEnd$jd(EventListener r0, ImageRequest r1, Transition r2) {
        super.transitionEnd(r1, r2);
    }

    static /* synthetic */ void access$transitionStart$jd(EventListener r0, ImageRequest r1, Transition r2) {
        super.transitionStart(r1, r2);
    }

    static {
        Companion = Companion.$$INSTANCE;
        NONE = new EventListener$Companion$NONE$1();
    }
}
