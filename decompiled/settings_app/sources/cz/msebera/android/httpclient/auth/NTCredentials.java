package cz.msebera.android.httpclient.auth;

import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.LangUtils;
import java.io.Serializable;
import java.security.Principal;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class NTCredentials implements Credentials, Serializable {
    private static final long serialVersionUID = -7385699315228907265L;
    private final String password;
    private final NTUserPrincipal principal;
    private final String workstation;

    @Deprecated
    public NTCredentials(String r6) {
        Args.notNull(r6, "Username:password string");
        int r0 = r6.indexOf(58);
        if (r0 < 0) goto L5;
        String r3 = r6.substring(0, r0);
        this.password = r6.substring(r0 + 1);
        r6 = r3;
    L6:
        int r1 = r6.indexOf(47);
        if (r1 < 0) goto L9;
        this.principal = new NTUserPrincipal(r6.substring(0, r1).toUpperCase(Locale.ROOT), r6.substring(r1 + 1));
    L10:
        this.workstation = null;
        return;
    L9:
        this.principal = new NTUserPrincipal(null, r6.substring(r1 + 1));
        goto L10
    L5:
        this.password = null;
        goto L6
    }

    public NTCredentials(String r2, String r3, String r4, String r5) {
        Args.notNull(r2, "User name");
        this.principal = new NTUserPrincipal(r5, r2);
        this.password = r3;
        if (r4 == null) goto L5;
        this.workstation = r4.toUpperCase(Locale.ROOT);
        return;
    L5:
        this.workstation = null;
    }

    @Override // cz.msebera.android.httpclient.auth.Credentials
    public Principal getUserPrincipal() {
        return this.principal;
    }

    public String getUserName() {
        return this.principal.getUsername();
    }

    @Override // cz.msebera.android.httpclient.auth.Credentials
    public String getPassword() {
        return this.password;
    }

    public String getDomain() {
        return this.principal.getDomain();
    }

    public String getWorkstation() {
        return this.workstation;
    }

    public int hashCode() {
        return LangUtils.hashCode(LangUtils.hashCode(17, this.principal), this.workstation);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof NTCredentials) == false) goto L12;
        NTCredentials r5 = (NTCredentials) r4;
        if (LangUtils.equals(this.principal, r5.principal) == true) goto L10;
        return false;
    L10:
        if (LangUtils.equals(this.workstation, r5.workstation) == false) goto L15;
        return true;
    L15:
        return false;
    L12:
        return false;
    }

    public String toString() {
        return "[principal: " + this.principal + "][workstation: " + this.workstation + "]";
    }
}
