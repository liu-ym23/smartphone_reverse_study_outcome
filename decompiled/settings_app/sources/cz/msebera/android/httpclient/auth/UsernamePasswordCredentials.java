package cz.msebera.android.httpclient.auth;

import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.LangUtils;
import java.io.Serializable;
import java.security.Principal;

/* JADX INFO: loaded from: classes5.dex */
public class UsernamePasswordCredentials implements Credentials, Serializable {
    private static final long serialVersionUID = 243343858802739403L;
    private final String password;
    private final BasicUserPrincipal principal;

    @Deprecated
    public UsernamePasswordCredentials(String r4) {
        Args.notNull(r4, "Username:password string");
        int r0 = r4.indexOf(58);
        if (r0 < 0) goto L5;
        this.principal = new BasicUserPrincipal(r4.substring(0, r0));
        this.password = r4.substring(r0 + 1);
        return;
    L5:
        this.principal = new BasicUserPrincipal(r4);
        this.password = null;
    }

    public UsernamePasswordCredentials(String r2, String r3) {
        Args.notNull(r2, "Username");
        this.principal = new BasicUserPrincipal(r2);
        this.password = r3;
    }

    @Override // cz.msebera.android.httpclient.auth.Credentials
    public Principal getUserPrincipal() {
        return this.principal;
    }

    public String getUserName() {
        return this.principal.getName();
    }

    @Override // cz.msebera.android.httpclient.auth.Credentials
    public String getPassword() {
        return this.password;
    }

    public int hashCode() {
        return this.principal.hashCode();
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L6;
        return true;
    L6:
        if ((r3 instanceof UsernamePasswordCredentials) == true) goto L8;
        return false;
    L8:
        if (LangUtils.equals(this.principal, ((UsernamePasswordCredentials) r3).principal) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public String toString() {
        return this.principal.toString();
    }
}
