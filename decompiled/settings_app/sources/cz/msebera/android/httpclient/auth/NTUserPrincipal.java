package cz.msebera.android.httpclient.auth;

import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.LangUtils;
import java.io.Serializable;
import java.security.Principal;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class NTUserPrincipal implements Principal, Serializable {
    private static final long serialVersionUID = -6870169797924406894L;
    private final String domain;
    private final String ntname;
    private final String username;

    public NTUserPrincipal(String r2, String r3) {
        Args.notNull(r3, "User name");
        this.username = r3;
        if (r2 == null) goto L5;
        this.domain = r2.toUpperCase(Locale.ROOT);
    L6:
        String r4 = this.domain;
        if (r4 != null) goto L9;
    L11:
        this.ntname = r3;
        return;
    L9:
        if (r4.isEmpty() == true) goto L11;
        this.ntname = this.domain + '\\' + r3;
        return;
    L5:
        this.domain = null;
        goto L6
    }

    @Override // java.security.Principal
    public String getName() {
        return this.ntname;
    }

    public String getDomain() {
        return this.domain;
    }

    public String getUsername() {
        return this.username;
    }

    @Override // java.security.Principal
    public int hashCode() {
        return LangUtils.hashCode(LangUtils.hashCode(17, this.username), this.domain);
    }

    @Override // java.security.Principal
    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof NTUserPrincipal) == false) goto L12;
        NTUserPrincipal r5 = (NTUserPrincipal) r4;
        if (LangUtils.equals(this.username, r5.username) == true) goto L10;
        return false;
    L10:
        if (LangUtils.equals(this.domain, r5.domain) == false) goto L15;
        return true;
    L15:
        return false;
    L12:
        return false;
    }

    @Override // java.security.Principal
    public String toString() {
        return this.ntname;
    }
}
