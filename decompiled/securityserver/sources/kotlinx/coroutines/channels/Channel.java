package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlinx.coroutines.internal.SystemPropsKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public interface Channel<E> extends SendChannel<E>, ReceiveChannel<E> {
    public static final Factory h = null;

    @Metadata
    public static final class DefaultImpls {
    }

    @Metadata
    public static final class Factory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f385a = 0;
        public static final /* synthetic */ Factory b = null;

        static {
            b = new Factory();
            f385a = (int) SystemPropsKt.b(64, "kotlinx.coroutines.channels.defaultBuffer", 1, 2147483646);
        }
    }

    static {
        h = Factory.b;
    }
}
