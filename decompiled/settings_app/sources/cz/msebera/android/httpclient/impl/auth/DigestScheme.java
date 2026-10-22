package cz.msebera.android.httpclient.impl.auth;

import com.android.settingslib.SliceBroadcastRelay;
import com.android.settingslib.accessibility.AccessibilityUtils;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import cz.msebera.android.httpclient.Consts;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.NameValuePair;
import cz.msebera.android.httpclient.auth.AuthenticationException;
import cz.msebera.android.httpclient.auth.ChallengeState;
import cz.msebera.android.httpclient.auth.Credentials;
import cz.msebera.android.httpclient.auth.MalformedChallengeException;
import cz.msebera.android.httpclient.message.BasicHeaderValueFormatter;
import cz.msebera.android.httpclient.message.BasicNameValuePair;
import cz.msebera.android.httpclient.message.BufferedHeader;
import cz.msebera.android.httpclient.protocol.BasicHttpContext;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import cz.msebera.android.httpclient.util.EncodingUtils;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.HashSet;
import java.util.Locale;
import java.util.StringTokenizer;

/* JADX INFO: loaded from: classes5.dex */
public class DigestScheme extends RFC2617Scheme {
    private static final char[] HEXADECIMAL = null;
    private static final int QOP_AUTH = 2;
    private static final int QOP_AUTH_INT = 1;
    private static final int QOP_MISSING = 0;
    private static final int QOP_UNKNOWN = -1;
    private static final long serialVersionUID = 3883908186234566916L;
    private String a1;
    private String a2;
    private String cnonce;
    private boolean complete;
    private String lastNonce;
    private long nounceCount;

    @Override // cz.msebera.android.httpclient.auth.AuthScheme
    public String getSchemeName() {
        return "digest";
    }

    @Override // cz.msebera.android.httpclient.auth.AuthScheme
    public boolean isConnectionBased() {
        return false;
    }

    static {
        HEXADECIMAL = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    public DigestScheme(Charset r1) {
        super(r1);
        this.complete = false;
    }

    @Deprecated
    public DigestScheme(ChallengeState r1) {
        super(r1);
    }

    public DigestScheme() {
        this(Consts.ASCII);
    }

    @Override // cz.msebera.android.httpclient.impl.auth.AuthSchemeBase, cz.msebera.android.httpclient.auth.AuthScheme
    public void processChallenge(Header r1) throws MalformedChallengeException {
        super.processChallenge(r1);
        this.complete = true;
        if (getParameters().isEmpty() == true) goto L6;
        return;
    L6:
        throw new MalformedChallengeException("Authentication challenge is empty");
    }

    @Override // cz.msebera.android.httpclient.auth.AuthScheme
    public boolean isComplete() {
        if ("true".equalsIgnoreCase(getParameter("stale")) == false) goto L6;
        return false;
    L6:
        return this.complete;
    }

    public void overrideParamter(String r1, String r2) {
        getParameters().put(r1, r2);
    }

    @Override // cz.msebera.android.httpclient.auth.AuthScheme
    @Deprecated
    public Header authenticate(Credentials r2, HttpRequest r3) throws AuthenticationException {
        return authenticate(r2, r3, new BasicHttpContext());
    }

    @Override // cz.msebera.android.httpclient.impl.auth.AuthSchemeBase, cz.msebera.android.httpclient.auth.ContextAwareAuthScheme
    public Header authenticate(Credentials r3, HttpRequest r4, HttpContext r5) throws AuthenticationException {
        Args.notNull(r3, "Credentials");
        Args.notNull(r4, "HTTP request");
        if (getParameter("realm") == null) goto L14;
        if (getParameter("nonce") == null) goto L12;
        getParameters().put("methodname", r4.getRequestLine().getMethod());
        getParameters().put(SliceBroadcastRelay.EXTRA_URI, r4.getRequestLine().getUri());
        if (getParameter("charset") != null) goto L10;
        getParameters().put("charset", getCredentialsCharset(r4));
    L10:
        return createDigestHeader(r3, r4);
    L12:
        throw new AuthenticationException("missing nonce in challenge");
    L14:
        throw new AuthenticationException("missing realm in challenge");
    }

    private static MessageDigest createMessageDigest(String r3) throws UnsupportedDigestAlgorithmException {
        return MessageDigest.getInstance(r3);
    L5:
        throw new UnsupportedDigestAlgorithmException("Unsupported algorithm in HTTP Digest authentication: " + r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private Header createDigestHeader(Credentials r29, HttpRequest r30) throws AuthenticationException {
        String r3 = getParameter(SliceBroadcastRelay.EXTRA_URI);
        String r5 = getParameter("realm");
        String r7 = getParameter("nonce");
        String r9 = getParameter("opaque");
        String r10 = getParameter("methodname");
        String r12 = getParameter("algorithm");
        if (r12 != null) goto L5;
        r12 = "MD5";
    L5:
        HashSet r14 = new HashSet(8);
        String r16 = "MD5";
        String r13 = getParameter("qop");
        if (r13 == null) goto L20;
        String r21 = "qop";
        StringTokenizer r11 = new StringTokenizer(r13, ",");
    L9:
        if (r11.hasMoreTokens() == false) goto L12;
        r14.add(r11.nextToken().trim().toLowerCase(Locale.ROOT));
        r11 = r11;
        goto L9
    L12:
        if ((r30 instanceof HttpEntityEnclosingRequest) == false) goto L17;
        if (r14.contains("auth-int") == false) goto L17;
        byte r15 = 1;
    L22:
        if (r15 == (-1)) goto L112;
        String r17 = getParameter("charset");
        if (r17 != null) goto L27;
        r17 = "ISO-8859-1";
    L27:
        if (r12.equalsIgnoreCase("MD5-sess") == true) goto L115;
        r16 = r12;
    L115:
        MessageDigest r8 = createMessageDigest(r16);     // Catch: UnsupportedDigestAlgorithmException -> L109
        String r2 = r29.getUserPrincipal().getName();
        String r6 = r29.getPassword();
        if (r7.equals(this.lastNonce) == false) goto L34;
        this.nounceCount++;
    L35:
        StringBuilder r4 = new StringBuilder(256);
        Formatter r18 = new Formatter(r4, Locale.US);
        r18.format("%08x", new Object[]{Long.valueOf(this.nounceCount)});
        r18.close();
        String r19 = r4.toString();
        if (this.cnonce != null) goto L38;
        this.cnonce = createCnonce();
    L38:
        this.a1 = null;
        this.a2 = null;
        if (r12.equalsIgnoreCase("MD5-sess") == false) goto L41;
        r4.setLength(0);
        r4.append(r2).append(AccessibilityUtils.ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR).append(r5).append(AccessibilityUtils.ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR).append(r6);
        MessageDigest r110 = r8;
        String r20 = encode(r110.digest(EncodingUtils.getBytes(r4.toString(), r17)));
        r4.setLength(0);
        r4.append(r20).append(AccessibilityUtils.ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR).append(r7).append(AccessibilityUtils.ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR).append(this.cnonce);
        this.a1 = r4.toString();
    L42:
        String r22 = encode(r110.digest(EncodingUtils.getBytes(this.a1, r17)));
        if (r15 != 2) goto L45;
        String r23 = r3;
        this.a2 = r10 + AccessibilityUtils.ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR + r23;
        String r111 = "auth";
    L69:
        String r1 = encode(r110.digest(EncodingUtils.getBytes(this.a2, r17)));
        if (r15 != 0) goto L72;
        int r24 = 0;
        r4.setLength(0);
        r4.append(r22).append(AccessibilityUtils.ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR).append(r7).append(AccessibilityUtils.ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR).append(r1);
        String r25 = r4.toString();
    L77:
        String r26 = encode(r110.digest(EncodingUtils.getAsciiBytes(r25)));
        CharArrayBuffer r27 = new CharArrayBuffer(128);
        if (isProxy() == false) goto L80;
        r27.append("Proxy-Authorization");
    L81:
        r27.append(": Digest ");
        ArrayList r28 = new ArrayList(20);
        r28.add(new BasicNameValuePair("username", r2));
        r28.add(new BasicNameValuePair("realm", r5));
        r28.add(new BasicNameValuePair("nonce", r7));
        r28.add(new BasicNameValuePair(SliceBroadcastRelay.EXTRA_URI, r23));
        r28.add(new BasicNameValuePair(ApmTrafficStats.TTNET_RESPONSE, r26));
        if (r15 != 0) goto L84;
        String r31 = r21;
    L88:
        r28.add(new BasicNameValuePair("algorithm", r12));
        if (r9 == null) goto L91;
        r28.add(new BasicNameValuePair("opaque", r9));
    L91:
        int r0 = r24;
    L93:
        if (r0 >= r28.size()) goto L108;
        NameValuePair r32 = (BasicNameValuePair) r28.get(r0);
        if (r0 <= 0) goto L97;
        r27.append(", ");
    L97:
        String r33 = r32.getName();
        if ("nc".equals(r33) == false) goto L100;
    L105:
        int r34 = 1;
    L106:
        BasicHeaderValueFormatter.INSTANCE.formatNameValuePair(r27, r32, r34 ^ 1);
        r0 = r0 + 1;
        goto L93
    L100:
        if (r31.equals(r33) == true) goto L105;
        if ("algorithm".equals(r33) == true) goto L105;
        r34 = r24;
        goto L106
    L108:
        return new BufferedHeader(r27);
    L84:
        if (r15 != 1) goto L86;
        r111 = "auth-int";
    L86:
        r31 = r21;
        r28.add(new BasicNameValuePair(r31, r111));
        r28.add(new BasicNameValuePair("nc", r19));
        r28.add(new BasicNameValuePair("cnonce", this.cnonce));
        goto L88
    L80:
        r27.append("Authorization");
        goto L81
    L72:
        r24 = 0;
        r4.setLength(0);
        StringBuilder r35 = r4.append(r22).append(AccessibilityUtils.ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR).append(r7).append(AccessibilityUtils.ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR).append(r19).append(AccessibilityUtils.ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR).append(this.cnonce).append(AccessibilityUtils.ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR);
        if (r15 != 1) goto L75;
        String r112 = r8;
    L76:
        r35.append(r112).append(AccessibilityUtils.ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR).append(r1);
        r25 = r4.toString();
        goto L77
    L75:
        r112 = r111;
        goto L76
    L45:
        r23 = r3;
        if (r15 == 1) goto L48;
        r111 = "auth";
        this.a2 = r10 + AccessibilityUtils.ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR + r23;
        goto L69
    L48:
        if ((r30 instanceof HttpEntityEnclosingRequest) == false) goto L50;
        HttpEntity r36 = ((HttpEntityEnclosingRequest) r30).getEntity();
    L51:
        if (r36 != null) goto L53;
    L59:
        r111 = "auth";
        HttpEntityDigester r113 = new HttpEntityDigester(r110);
        if (r36 != null) goto L113;
    L62:
        r113.close();     // Catch: IOException -> L65
        this.a2 = r10 + AccessibilityUtils.ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR + r23 + AccessibilityUtils.ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR + encode(r113.getDigest());
        byte r37 = r15;
    L64:
        r15 = r37;
    L65:
        e = move-exception;
        throw new AuthenticationException("I/O error reading entity content", e);
    L113:
        r36.writeTo(r113);     // Catch: IOException -> L65
        goto L62
    L53:
        if (r36.isRepeatable() == true) goto L59;
        r111 = "auth";
        if (r14.contains(r111) == false) goto L58;
        this.a2 = r10 + AccessibilityUtils.ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR + r23;
        r37 = 2;
        goto L64
    L58:
        throw new AuthenticationException("Qop auth-int cannot be used with a non-repeatable entity");
    L50:
        r36 = null;
        goto L51
    L41:
        r110 = r8;
        r4.setLength(0);
        r4.append(r2).append(AccessibilityUtils.ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR).append(r5).append(AccessibilityUtils.ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR).append(r6);
        this.a1 = r4.toString();
        goto L42
    L34:
        this.nounceCount = 1;
        this.cnonce = null;
        this.lastNonce = r7;
    L110:
        throw new AuthenticationException("Unsuppported digest algorithm: " + r16);
    L112:
        throw new AuthenticationException("None of the qop methods is supported: " + r13);
    L17:
        if (r14.contains("auth") == false) goto L19;
        r15 = 2;
        goto L22
    L19:
        r15 = -1;
        goto L22
    L20:
        r21 = "qop";
        r15 = 0;
        goto L22
    }

    String getCnonce() {
        return this.cnonce;
    }

    String getA1() {
        return this.a1;
    }

    String getA2() {
        return this.a2;
    }

    static String encode(byte[] r7) {
        int r0 = r7.length;
        char[] r1 = new char[r0 * 2];
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L6;
        byte r3 = r7[r2];
        int r4 = r3 & 15;
        int r5 = r2 * 2;
        char[] r6 = HEXADECIMAL;
        r1[r5] = r6[(r3 & 240) >> 4];
        r1[r5 + 1] = r6[r4];
        r2 = r2 + 1;
        goto L3
    L6:
        return new String(r1);
    }

    public static String createCnonce() {
        byte[] r1 = new byte[8];
        new SecureRandom().nextBytes(r1);
        return encode(r1);
    }

    @Override // cz.msebera.android.httpclient.impl.auth.AuthSchemeBase
    public String toString() {
        StringBuilder r0 = new StringBuilder("DIGEST [complete=");
        r0.append(this.complete).append(", nonce=").append(this.lastNonce).append(", nc=").append(this.nounceCount).append("]");
        return r0.toString();
    }
}
