package cz.msebera.android.httpclient.impl.cookie;

import cz.msebera.android.httpclient.cookie.ClientCookie;
import cz.msebera.android.httpclient.cookie.SetCookie;
import cz.msebera.android.httpclient.util.Args;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class BasicClientCookie implements SetCookie, ClientCookie, Cloneable, Serializable {
    private static final long serialVersionUID = -3869795591041535538L;
    private Map<String, String> attribs;
    private String cookieComment;
    private String cookieDomain;
    private Date cookieExpiryDate;
    private String cookiePath;
    private int cookieVersion;
    private Date creationDate;
    private boolean isSecure;
    private final String name;
    private String value;

    @Override // cz.msebera.android.httpclient.cookie.Cookie
    public String getCommentURL() {
        return null;
    }

    @Override // cz.msebera.android.httpclient.cookie.Cookie
    public int[] getPorts() {
        return null;
    }

    public BasicClientCookie(String r2, String r3) {
        Args.notNull(r2, "Name");
        this.name = r2;
        this.attribs = new HashMap();
        this.value = r3;
    }

    @Override // cz.msebera.android.httpclient.cookie.Cookie
    public String getName() {
        return this.name;
    }

    @Override // cz.msebera.android.httpclient.cookie.Cookie
    public String getValue() {
        return this.value;
    }

    @Override // cz.msebera.android.httpclient.cookie.SetCookie
    public void setValue(String r1) {
        this.value = r1;
    }

    @Override // cz.msebera.android.httpclient.cookie.Cookie
    public String getComment() {
        return this.cookieComment;
    }

    @Override // cz.msebera.android.httpclient.cookie.SetCookie
    public void setComment(String r1) {
        this.cookieComment = r1;
    }

    @Override // cz.msebera.android.httpclient.cookie.Cookie
    public Date getExpiryDate() {
        return this.cookieExpiryDate;
    }

    @Override // cz.msebera.android.httpclient.cookie.SetCookie
    public void setExpiryDate(Date r1) {
        this.cookieExpiryDate = r1;
    }

    @Override // cz.msebera.android.httpclient.cookie.Cookie
    public boolean isPersistent() {
        if (this.cookieExpiryDate == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // cz.msebera.android.httpclient.cookie.Cookie
    public String getDomain() {
        return this.cookieDomain;
    }

    @Override // cz.msebera.android.httpclient.cookie.SetCookie
    public void setDomain(String r2) {
        if (r2 == null) goto L4;
        this.cookieDomain = r2.toLowerCase(Locale.ROOT);
        return;
    L4:
        this.cookieDomain = null;
    }

    @Override // cz.msebera.android.httpclient.cookie.Cookie
    public String getPath() {
        return this.cookiePath;
    }

    @Override // cz.msebera.android.httpclient.cookie.SetCookie
    public void setPath(String r1) {
        this.cookiePath = r1;
    }

    @Override // cz.msebera.android.httpclient.cookie.Cookie
    public boolean isSecure() {
        return this.isSecure;
    }

    @Override // cz.msebera.android.httpclient.cookie.SetCookie
    public void setSecure(boolean r1) {
        this.isSecure = r1;
    }

    @Override // cz.msebera.android.httpclient.cookie.Cookie
    public int getVersion() {
        return this.cookieVersion;
    }

    @Override // cz.msebera.android.httpclient.cookie.SetCookie
    public void setVersion(int r1) {
        this.cookieVersion = r1;
    }

    @Override // cz.msebera.android.httpclient.cookie.Cookie
    public boolean isExpired(Date r3) {
        Args.notNull(r3, "Date");
        Date r2 = this.cookieExpiryDate;
        if (r2 != null) goto L5;
    L7:
        return false;
    L5:
        if (r2.getTime() > r3.getTime()) goto L7;
        return true;
    }

    public Date getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(Date r1) {
        this.creationDate = r1;
    }

    public void setAttribute(String r1, String r2) {
        this.attribs.put(r1, r2);
    }

    @Override // cz.msebera.android.httpclient.cookie.ClientCookie
    public String getAttribute(String r1) {
        return this.attribs.get(r1);
    }

    @Override // cz.msebera.android.httpclient.cookie.ClientCookie
    public boolean containsAttribute(String r1) {
        return this.attribs.containsKey(r1);
    }

    public boolean removeAttribute(String r1) {
        if (this.attribs.remove(r1) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public Object clone() throws CloneNotSupportedException {
        BasicClientCookie r0 = (BasicClientCookie) super.clone();
        r0.attribs = new HashMap(this.attribs);
        return r0;
    }

    public String toString() {
        return "[version: " + Integer.toString(this.cookieVersion) + "][name: " + this.name + "][value: " + this.value + "][domain: " + this.cookieDomain + "][path: " + this.cookiePath + "][expiry: " + this.cookieExpiryDate + "]";
    }
}
