package okhttp3;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public interface CookieJar {
    public static final Companion Companion = null;

    @JvmField
    @NotNull
    public static final CookieJar NO_COOKIES = null;

    @Metadata
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;

        @Metadata
        public static final class NoCookies implements CookieJar {
            public NoCookies() {
            }

            @Override // okhttp3.CookieJar
            @NotNull
            public List<Cookie> loadForRequest(@NotNull HttpUrl r1) {
                Intrinsics.f(r1, "url");
                return EmptyList.b;
            }

            @Override // okhttp3.CookieJar
            public void saveFromResponse(@NotNull HttpUrl r1, @NotNull List<Cookie> r2) {
                Intrinsics.f(r1, "url");
                Intrinsics.f(r2, "cookies");
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
        NO_COOKIES = new Companion.NoCookies();
    }

    @NotNull
    List<Cookie> loadForRequest(@NotNull HttpUrl r1);

    void saveFromResponse(@NotNull HttpUrl r1, @NotNull List<Cookie> r2);
}
