package kotlin.collections;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final enum State extends Enum<State> {
    public static final State b = null;
    public static final State c = null;
    public static final State e = null;
    public static final State f = null;
    public static final /* synthetic */ State[] i = null;

    static {
        State r0 = new State("Ready", 0);
        b = r0;
        State r1 = new State("NotReady", 1);
        c = r1;
        State r2 = new State("Done", 2);
        e = r2;
        State r3 = new State("Failed", 3);
        f = r3;
        i = new State[]{r0, r1, r2, r3};
    }

    public static State valueOf(String r1) {
        return (State) Enum.valueOf(State.class, r1);
    }

    public static State[] values() {
        return (State[]) i.clone();
    }
}
