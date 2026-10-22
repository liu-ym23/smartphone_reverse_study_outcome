package cz.msebera.android.httpclient.impl.auth;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.auth.AuthenticationException;
import cz.msebera.android.httpclient.auth.Credentials;
import cz.msebera.android.httpclient.auth.InvalidCredentialsException;
import cz.msebera.android.httpclient.auth.MalformedChallengeException;
import cz.msebera.android.httpclient.auth.NTCredentials;
import cz.msebera.android.httpclient.message.BufferedHeader;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.CharArrayBuffer;

/* JADX INFO: loaded from: classes5.dex */
public class NTLMScheme extends AuthSchemeBase {
    private String challenge;
    private final NTLMEngine engine;
    private State state;

    static final enum State extends Enum<State> {
        private static final /* synthetic */ State[] $VALUES = null;
        public static final State CHALLENGE_RECEIVED = null;
        public static final State FAILED = null;
        public static final State MSG_TYPE1_GENERATED = null;
        public static final State MSG_TYPE2_RECEVIED = null;
        public static final State MSG_TYPE3_GENERATED = null;
        public static final State UNINITIATED = null;

        private State(String r1, int r2) {
            super(r1, r2);
        }

        public static State valueOf(String r1) {
            return (State) Enum.valueOf(State.class, r1);
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }

        static {
            State r0 = new State("UNINITIATED", 0);
            UNINITIATED = r0;
            State r1 = new State("CHALLENGE_RECEIVED", 1);
            CHALLENGE_RECEIVED = r1;
            State r3 = new State("MSG_TYPE1_GENERATED", 2);
            MSG_TYPE1_GENERATED = r3;
            State r5 = new State("MSG_TYPE2_RECEVIED", 3);
            MSG_TYPE2_RECEVIED = r5;
            State r7 = new State("MSG_TYPE3_GENERATED", 4);
            MSG_TYPE3_GENERATED = r7;
            State r9 = new State("FAILED", 5);
            FAILED = r9;
            $VALUES = new State[]{r0, r1, r3, r5, r7, r9};
        }
    }

    @Override // cz.msebera.android.httpclient.auth.AuthScheme
    public String getParameter(String r1) {
        return null;
    }

    @Override // cz.msebera.android.httpclient.auth.AuthScheme
    public String getRealm() {
        return null;
    }

    @Override // cz.msebera.android.httpclient.auth.AuthScheme
    public String getSchemeName() {
        return "ntlm";
    }

    @Override // cz.msebera.android.httpclient.auth.AuthScheme
    public boolean isConnectionBased() {
        return true;
    }

    public NTLMScheme(NTLMEngine r2) {
        Args.notNull(r2, "NTLM engine");
        this.engine = r2;
        this.state = State.UNINITIATED;
        this.challenge = null;
    }

    public NTLMScheme() {
        this(new NTLMEngineImpl());
    }

    @Override // cz.msebera.android.httpclient.impl.auth.AuthSchemeBase
    protected void parseChallenge(CharArrayBuffer r1, int r2, int r3) throws MalformedChallengeException {
        String r4 = r1.substringTrimmed(r2, r3);
        this.challenge = r4;
        if (r4.isEmpty() == false) goto L9;
        if (this.state != State.UNINITIATED) goto L7;
        this.state = State.CHALLENGE_RECEIVED;
        return;
    L7:
        this.state = State.FAILED;
        return;
    L9:
        if (this.state.compareTo(State.MSG_TYPE1_GENERATED) >= 0) goto L11;
        this.state = State.FAILED;
        throw new MalformedChallengeException("Out of sequence NTLM response message");
    L11:
        if (this.state != State.MSG_TYPE1_GENERATED) goto L18;
        this.state = State.MSG_TYPE2_RECEVIED;
        return;
    }

    @Override // cz.msebera.android.httpclient.auth.AuthScheme
    public Header authenticate(Credentials r8, HttpRequest r9) throws AuthenticationException {
        NTCredentials r10 = (NTCredentials) r8;     // Catch: ClassCastException -> L21
        if (this.state == State.FAILED) goto L20;
        if (this.state != State.CHALLENGE_RECEIVED) goto L9;
        String r11 = this.engine.generateType1Msg(r10.getDomain(), r10.getWorkstation());
        this.state = State.MSG_TYPE1_GENERATED;
    L11:
        CharArrayBuffer r12 = new CharArrayBuffer(32);
        if (isProxy() == false) goto L14;
        r12.append("Proxy-Authorization");
    L15:
        r12.append(": NTLM ");
        r12.append(r11);
        return new BufferedHeader(r12);
    L14:
        r12.append("Authorization");
        goto L15
    L9:
        if (this.state != State.MSG_TYPE2_RECEVIED) goto L18;
        r11 = this.engine.generateType3Msg(r10.getUserName(), r10.getPassword(), r10.getDomain(), r10.getWorkstation(), this.challenge);
        this.state = State.MSG_TYPE3_GENERATED;
        goto L11
    L18:
        throw new AuthenticationException("Unexpected state: " + this.state);
    L20:
        throw new AuthenticationException("NTLM authentication failed");
    L22:
        throw new InvalidCredentialsException("Credentials cannot be used for NTLM authentication: " + r8.getClass().getName());
    }

    @Override // cz.msebera.android.httpclient.auth.AuthScheme
    public boolean isComplete() {
        if (this.state != State.MSG_TYPE3_GENERATED) goto L5;
    L8:
        return true;
    L5:
        if (this.state == State.FAILED) goto L8;
        return false;
    }
}
