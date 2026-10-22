package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlinx.coroutines.ObsoleteCoroutinesApi;

/* JADX INFO: loaded from: classes2.dex */
@ObsoleteCoroutinesApi
@Metadata
public final enum TickerMode extends Enum<TickerMode> {
    public static final /* synthetic */ TickerMode[] b = null;

    static {
        b = new TickerMode[]{new TickerMode("FIXED_PERIOD", 0), new TickerMode("FIXED_DELAY", 1)};
    }

    public static TickerMode valueOf(String r1) {
        return (TickerMode) Enum.valueOf(TickerMode.class, r1);
    }

    public static TickerMode[] values() {
        return (TickerMode[]) b.clone();
    }
}
