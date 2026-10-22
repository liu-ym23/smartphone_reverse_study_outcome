package cz.msebera.android.httpclient.impl.auth;

import cz.msebera.android.httpclient.Consts;
import cz.msebera.android.httpclient.HeaderElement;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.auth.ChallengeState;
import cz.msebera.android.httpclient.auth.MalformedChallengeException;
import cz.msebera.android.httpclient.auth.params.AuthPNames;
import cz.msebera.android.httpclient.message.BasicHeaderValueParser;
import cz.msebera.android.httpclient.message.ParserCursor;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import cz.msebera.android.httpclient.util.CharsetUtils;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public abstract class RFC2617Scheme extends AuthSchemeBase implements Serializable {
    private static final long serialVersionUID = -2845454858205884623L;
    private transient Charset credentialsCharset;
    private final Map<String, String> params;

    private void readObjectNoData() throws ObjectStreamException {
    }

    @Deprecated
    public RFC2617Scheme(ChallengeState r1) {
        super(r1);
        this.params = new HashMap();
        this.credentialsCharset = Consts.ASCII;
    }

    public RFC2617Scheme(Charset r2) {
        this.params = new HashMap();
        if (r2 != null) goto L6;
        r2 = Consts.ASCII;
    L6:
        this.credentialsCharset = r2;
    }

    public RFC2617Scheme() {
        this(Consts.ASCII);
    }

    public Charset getCredentialsCharset() {
        Charset r0 = this.credentialsCharset;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return Consts.ASCII;
    }

    String getCredentialsCharset(HttpRequest r2) {
        String r3 = (String) r2.getParams().getParameter(AuthPNames.CREDENTIAL_CHARSET);
        if (r3 == null) goto L5;
        return r3;
    L5:
        return getCredentialsCharset().name();
    }

    @Override // cz.msebera.android.httpclient.impl.auth.AuthSchemeBase
    protected void parseChallenge(CharArrayBuffer r5, int r6, int r7) throws MalformedChallengeException {
        HeaderElement[] r8 = BasicHeaderValueParser.INSTANCE.parseElements(r5, new ParserCursor(r6, r5.length()));
        this.params.clear();
        int r9 = r8.length;
        int r10 = 0;
    L3:
        if (r10 >= r9) goto L5;
        HeaderElement r0 = r8[r10];
        this.params.put(r0.getName().toLowerCase(Locale.ROOT), r0.getValue());
        r10 = r10 + 1;
        goto L3
    }

    protected Map<String, String> getParameters() {
        return this.params;
    }

    @Override // cz.msebera.android.httpclient.auth.AuthScheme
    public String getParameter(String r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return this.params.get(r2.toLowerCase(Locale.ROOT));
    }

    @Override // cz.msebera.android.httpclient.auth.AuthScheme
    public String getRealm() {
        return getParameter("realm");
    }

    private void writeObject(ObjectOutputStream r2) throws IOException {
        r2.defaultWriteObject();
        r2.writeUTF(this.credentialsCharset.name());
        r2.writeObject(this.challengeState);
    }

    private void readObject(ObjectInputStream r2) throws IOException, ClassNotFoundException {
        r2.defaultReadObject();
        Charset r0 = CharsetUtils.get(r2.readUTF());
        this.credentialsCharset = r0;
        if (r0 != null) goto L5;
        this.credentialsCharset = Consts.ASCII;
    L5:
        this.challengeState = (ChallengeState) r2.readObject();
    }
}
