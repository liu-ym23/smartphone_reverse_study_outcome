package cz.msebera.android.httpclient.auth;

/* JADX INFO: loaded from: classes5.dex */
public final enum ChallengeState extends Enum<ChallengeState> {
    private static final /* synthetic */ ChallengeState[] $VALUES = null;
    public static final ChallengeState PROXY = null;
    public static final ChallengeState TARGET = null;

    private ChallengeState(String r1, int r2) {
        super(r1, r2);
    }

    public static ChallengeState valueOf(String r1) {
        return (ChallengeState) Enum.valueOf(ChallengeState.class, r1);
    }

    public static ChallengeState[] values() {
        return (ChallengeState[]) $VALUES.clone();
    }

    static {
        ChallengeState r0 = new ChallengeState("TARGET", 0);
        TARGET = r0;
        ChallengeState r1 = new ChallengeState("PROXY", 1);
        PROXY = r1;
        $VALUES = new ChallengeState[]{r0, r1};
    }
}
