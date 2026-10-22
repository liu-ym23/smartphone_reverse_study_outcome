package okhttp3;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public interface Dns {
    public static final Companion Companion = null;

    @JvmField
    @NotNull
    public static final Dns SYSTEM = null;

    @Metadata
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;

        @Metadata
        public static final class DnsSystem implements Dns {
            public DnsSystem() {
            }

            @Override // okhttp3.Dns
            @NotNull
            public List<InetAddress> lookup(@NotNull String r3) {
                Intrinsics.f(r3, "hostname");
                InetAddress[] r2 = InetAddress.getAllByName(r3);     // Catch: NullPointerException -> L5
                Intrinsics.e(r2, "InetAddress.getAllByName(hostname)");     // Catch: NullPointerException -> L5
                return ArraysKt.u(r2);
            L5:
                e = move-exception;
                UnknownHostException r0 = new UnknownHostException("Broken system behaviour for dns lookup of ".concat(r3));
                r0.initCause(e);
                throw r0;
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
        SYSTEM = new Companion.DnsSystem();
    }

    @NotNull
    List<InetAddress> lookup(@NotNull String r1);
}
