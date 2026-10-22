package okhttp3.internal.http2;

import androidx.appcompat.widget.ActivityChooserView;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class Settings {
    public static final int COUNT = 10;
    public static final Companion Companion = null;
    public static final int DEFAULT_INITIAL_WINDOW_SIZE = 65535;
    public static final int ENABLE_PUSH = 2;
    public static final int HEADER_TABLE_SIZE = 1;
    public static final int INITIAL_WINDOW_SIZE = 7;
    public static final int MAX_CONCURRENT_STREAMS = 4;
    public static final int MAX_FRAME_SIZE = 5;
    public static final int MAX_HEADER_LIST_SIZE = 6;
    private int set;
    private final int[] values;

    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public Settings() {
        this.values = new int[10];
    }

    public final void clear() {
        this.set = 0;
        int[] r2 = this.values;
        Arrays.fill(r2, 0, r2.length, 0);
    }

    public final int get(int r1) {
        return this.values[r1];
    }

    public final boolean getEnablePush(boolean r2) {
        if ((this.set & 4) != 0) goto L5;
        return r2;
    L5:
        if (this.values[2] == 1) goto L10;
        return false;
    L10:
        return true;
    }

    public final int getHeaderTableSize() {
        if ((this.set & 2) != 0) goto L7;
        return -1;
    L7:
        return this.values[1];
    }

    public final int getInitialWindowSize() {
        if ((this.set & 128) != 0) goto L7;
        return 65535;
    L7:
        return this.values[7];
    }

    public final int getMaxConcurrentStreams() {
        if ((this.set & 16) != 0) goto L7;
        return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    L7:
        return this.values[4];
    }

    public final int getMaxFrameSize(int r2) {
        if ((this.set & 32) != 0) goto L5;
        return r2;
    L5:
        return this.values[5];
    }

    public final int getMaxHeaderListSize(int r2) {
        if ((this.set & 64) != 0) goto L5;
        return r2;
    L5:
        return this.values[6];
    }

    public final boolean isSet(int r2) {
        int r1 = this.set;
        if ((r1 & (1 << r2)) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    public final void merge(@NotNull Settings r3) {
        Intrinsics.f(r3, "other");
        int r0 = 0;
    L4:
        if (r0 >= 10) goto L10;
        if (r3.isSet(r0) == false) goto L9;
        set(r0, r3.get(r0));
    L9:
        r0 = r0 + 1;
        goto L4
    }

    @NotNull
    public final Settings set(int r4, int r5) {
        if (r4 < 0) goto L7;
        int[] r0 = this.values;
        if (r4 >= r0.length) goto L7;
        this.set = (1 << r4) | this.set;
        r0[r4] = r5;
    L7:
        return this;
    }

    public final int size() {
        return Integer.bitCount(this.set);
    }
}
