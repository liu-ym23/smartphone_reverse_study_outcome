package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.constant.PerfConsts;
import kotlin.Metadata;

/* JADX INFO: compiled from: BroadcastChannel.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"BroadcastChannel", "Lkotlinx/coroutines/channels/BroadcastChannel;", ExifInterface.LONGITUDE_EAST, PerfConsts.KEY_CURRENT_CAPACITY, "", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class BroadcastChannelKt {
    public static final <E> BroadcastChannel<E> BroadcastChannel(int r1) {
        if (r1 == (-2)) goto L16;
        if (r1 == (-1)) goto L18;
        if (r1 == 0) goto L13;
        if (r1 == Integer.MAX_VALUE) goto L11;
        return new ArrayBroadcastChannel(r1);
    L11:
        throw new IllegalArgumentException("Unsupported UNLIMITED capacity for BroadcastChannel");
    L13:
        throw new IllegalArgumentException("Unsupported 0 capacity for BroadcastChannel");
    L18:
        return new ConflatedBroadcastChannel();
    L16:
        return new ArrayBroadcastChannel(Channel.Factory.getCHANNEL_DEFAULT_CAPACITY$kotlinx_coroutines_core());
    }
}
