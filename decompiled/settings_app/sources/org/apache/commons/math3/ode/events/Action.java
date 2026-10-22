package org.apache.commons.math3.ode.events;

/* JADX INFO: loaded from: classes6.dex */
public final enum Action extends Enum<Action> {
    private static final /* synthetic */ Action[] $VALUES = null;
    public static final Action CONTINUE = null;
    public static final Action RESET_DERIVATIVES = null;
    public static final Action RESET_STATE = null;
    public static final Action STOP = null;

    private Action(String r1, int r2) {
        super(r1, r2);
    }

    public static Action valueOf(String r1) {
        return (Action) Enum.valueOf(Action.class, r1);
    }

    public static Action[] values() {
        return (Action[]) $VALUES.clone();
    }

    static {
        Action r0 = new Action("STOP", 0);
        STOP = r0;
        Action r1 = new Action("RESET_STATE", 1);
        RESET_STATE = r1;
        Action r3 = new Action("RESET_DERIVATIVES", 2);
        RESET_DERIVATIVES = r3;
        Action r5 = new Action("CONTINUE", 3);
        CONTINUE = r5;
        $VALUES = new Action[]{r0, r1, r3, r5};
    }
}
