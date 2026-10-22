package kotlinx.coroutines.flow;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final enum SharingCommand extends Enum<SharingCommand> {
    public static final SharingCommand b = null;
    public static final SharingCommand c = null;
    public static final /* synthetic */ SharingCommand[] e = null;

    static {
        SharingCommand r0 = new SharingCommand("START", 0);
        b = r0;
        SharingCommand r1 = new SharingCommand("STOP", 1);
        SharingCommand r2 = new SharingCommand("STOP_AND_RESET_REPLAY_CACHE", 2);
        c = r2;
        e = new SharingCommand[]{r0, r1, r2};
    }

    public static SharingCommand valueOf(String r1) {
        return (SharingCommand) Enum.valueOf(SharingCommand.class, r1);
    }

    public static SharingCommand[] values() {
        return (SharingCommand[]) e.clone();
    }
}
