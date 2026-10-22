package cz.msebera.android.httpclient.auth;

/* JADX INFO: loaded from: classes5.dex */
public final enum AuthProtocolState extends Enum<AuthProtocolState> {
    private static final /* synthetic */ AuthProtocolState[] $VALUES = null;
    public static final AuthProtocolState CHALLENGED = null;
    public static final AuthProtocolState FAILURE = null;
    public static final AuthProtocolState HANDSHAKE = null;
    public static final AuthProtocolState SUCCESS = null;
    public static final AuthProtocolState UNCHALLENGED = null;

    private AuthProtocolState(String r1, int r2) {
        super(r1, r2);
    }

    public static AuthProtocolState valueOf(String r1) {
        return (AuthProtocolState) Enum.valueOf(AuthProtocolState.class, r1);
    }

    public static AuthProtocolState[] values() {
        return (AuthProtocolState[]) $VALUES.clone();
    }

    static {
        AuthProtocolState r0 = new AuthProtocolState("UNCHALLENGED", 0);
        UNCHALLENGED = r0;
        AuthProtocolState r1 = new AuthProtocolState("CHALLENGED", 1);
        CHALLENGED = r1;
        AuthProtocolState r3 = new AuthProtocolState("HANDSHAKE", 2);
        HANDSHAKE = r3;
        AuthProtocolState r5 = new AuthProtocolState("FAILURE", 3);
        FAILURE = r5;
        AuthProtocolState r7 = new AuthProtocolState("SUCCESS", 4);
        SUCCESS = r7;
        $VALUES = new AuthProtocolState[]{r0, r1, r3, r5, r7};
    }
}
