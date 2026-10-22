package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.constant.PerfConsts;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: Channel.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u001a\u001e\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0007\u001a>\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u001aX\u0010\n\u001a\u0002H\u000b\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u0002H\u000b0\f2#\u0010\r\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u0002H\u000b0\bH\u0086\bø\u0001\u0000ø\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a^\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u000b0\f\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u0002H\u000b0\f2#\u0010\u0015\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\t0\bH\u0086\bø\u0001\u0000ø\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0004\b\u0016\u0010\u0013\u001a^\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u000b0\f\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u0002H\u000b0\f2#\u0010\u0015\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\t0\bH\u0086\bø\u0001\u0000ø\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0004\b\u0017\u0010\u0013\u001a\\\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u000b0\f\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u0002H\u000b0\f2!\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u0011H\u000b¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\t0\bH\u0086\bø\u0001\u0000ø\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0004\b\u001a\u0010\u0013\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Channel", "Lkotlinx/coroutines/channels/Channel;", "E", PerfConsts.KEY_CURRENT_CAPACITY, "", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "onUndeliveredElement", "Lkotlin/Function1;", "", "getOrElse", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/channels/ChannelResult;", "onFailure", "", "Lkotlin/ParameterName;", "name", "exception", "getOrElse-WpGqRn0", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "onClosed", "action", "onClosed-WpGqRn0", "onFailure-WpGqRn0", "onSuccess", "value", "onSuccess-WpGqRn0", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ChannelKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getOrElse-WpGqRn0, reason: not valid java name */
    public static final <T> T m3018getOrElseWpGqRn0(Object r1, Function1<? super Throwable, ? extends T> r2) {
        if ((r1 instanceof ChannelResult.Failed) == true) goto L5;
        return r1;
    L5:
        return r2.invoke(ChannelResult.m3026exceptionOrNullimpl(r1));
    }

    /* JADX INFO: renamed from: onSuccess-WpGqRn0, reason: not valid java name */
    public static final <T> Object m3021onSuccessWpGqRn0(Object r1, Function1<? super T, Unit> r2) {
        if ((r1 instanceof ChannelResult.Failed) == true) goto L5;
        r2.invoke(r1);
    L5:
        return r1;
    }

    /* JADX INFO: renamed from: onFailure-WpGqRn0, reason: not valid java name */
    public static final <T> Object m3020onFailureWpGqRn0(Object r1, Function1<? super Throwable, Unit> r2) {
        if ((r1 instanceof ChannelResult.Failed) == false) goto L5;
        r2.invoke(ChannelResult.m3026exceptionOrNullimpl(r1));
    L5:
        return r1;
    }

    /* JADX INFO: renamed from: onClosed-WpGqRn0, reason: not valid java name */
    public static final <T> Object m3019onClosedWpGqRn0(Object r1, Function1<? super Throwable, Unit> r2) {
        if ((r1 instanceof ChannelResult.Closed) == false) goto L5;
        r2.invoke(ChannelResult.m3026exceptionOrNullimpl(r1));
    L5:
        return r1;
    }

    public static /* synthetic */ Channel Channel$default(int r0, BufferOverflow r1, Function1 r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r0 = 0;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r1 = BufferOverflow.SUSPEND;
    L9:
        if ((r3 & 4) == 0) goto L12;
        r2 = null;
    L12:
        return Channel(r0, r1, r2);
    }

    public static final <E> Channel<E> Channel(int r3, BufferOverflow r4, Function1<? super E, Unit> r5) {
        if (r3 == (-2)) goto L28;
        boolean r2 = false;
        if (r3 == (-1)) goto L21;
        if (r3 == 0) goto L16;
        if (r3 == Integer.MAX_VALUE) goto L34;
        if (r4 != BufferOverflow.SUSPEND) goto L12;
        ConflatedBufferedChannel r6 = new BufferedChannel(r3, r5);
    L33:
        return r6;
    L12:
        r6 = new ConflatedBufferedChannel(r3, r4, r5);
        goto L33
    L34:
        return new BufferedChannel(Integer.MAX_VALUE, r5);
    L16:
        if (r4 != BufferOverflow.SUSPEND) goto L18;
        ConflatedBufferedChannel r7 = new BufferedChannel(0, r5);
    L35:
        return r7;
    L18:
        r7 = new ConflatedBufferedChannel(1, r4, r5);
        goto L35
    L21:
        if (r4 != BufferOverflow.SUSPEND) goto L23;
        r2 = true;
    L23:
        if (r2 == false) goto L26;
        return new ConflatedBufferedChannel(1, BufferOverflow.DROP_OLDEST, r5);
    L26:
        throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
    L28:
        if (r4 != BufferOverflow.SUSPEND) goto L30;
        ConflatedBufferedChannel r8 = new BufferedChannel(Channel.Factory.getCHANNEL_DEFAULT_CAPACITY$kotlinx_coroutines_core(), r5);
    L32:
        return r8;
    L30:
        r8 = new ConflatedBufferedChannel(1, r4, r5);
        goto L32
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.4.0, binary compatibility with earlier versions")
    public static final /* synthetic */ Channel Channel(int r2) {
        return Channel$default(r2, null, null, 6, null);
    }

    public static /* synthetic */ Channel Channel$default(int r0, int r1, Object r2) {
        if ((r1 & 1) == 0) goto L6;
        r0 = 0;
    L6:
        return Channel(r0);
    }
}
