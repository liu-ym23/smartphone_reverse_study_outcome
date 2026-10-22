package cz.msebera.android.httpclient.impl.cookie;

import cz.msebera.android.httpclient.cookie.SetCookie2;
import java.util.Date;

/* JADX INFO: loaded from: classes5.dex */
public class BasicClientCookie2 extends BasicClientCookie implements SetCookie2 {
    private static final long serialVersionUID = -7744598295706617057L;
    private String commentURL;
    private boolean discard;
    private int[] ports;

    public BasicClientCookie2(String r1, String r2) {
        super(r1, r2);
    }

    @Override // cz.msebera.android.httpclient.impl.cookie.BasicClientCookie, cz.msebera.android.httpclient.cookie.Cookie
    public int[] getPorts() {
        return this.ports;
    }

    @Override // cz.msebera.android.httpclient.cookie.SetCookie2
    public void setPorts(int[] r1) {
        this.ports = r1;
    }

    @Override // cz.msebera.android.httpclient.impl.cookie.BasicClientCookie, cz.msebera.android.httpclient.cookie.Cookie
    public String getCommentURL() {
        return this.commentURL;
    }

    @Override // cz.msebera.android.httpclient.cookie.SetCookie2
    public void setCommentURL(String r1) {
        this.commentURL = r1;
    }

    @Override // cz.msebera.android.httpclient.cookie.SetCookie2
    public void setDiscard(boolean r1) {
        this.discard = r1;
    }

    @Override // cz.msebera.android.httpclient.impl.cookie.BasicClientCookie, cz.msebera.android.httpclient.cookie.Cookie
    public boolean isPersistent() {
        if (this.discard == false) goto L5;
    L7:
        return false;
    L5:
        if (super.isPersistent() == false) goto L7;
        return true;
    }

    @Override // cz.msebera.android.httpclient.impl.cookie.BasicClientCookie, cz.msebera.android.httpclient.cookie.Cookie
    public boolean isExpired(Date r2) {
        if (this.discard == false) goto L5;
    L8:
        return true;
    L5:
        if (super.isExpired(r2) == true) goto L8;
        return false;
    }

    @Override // cz.msebera.android.httpclient.impl.cookie.BasicClientCookie
    public Object clone() throws CloneNotSupportedException {
        BasicClientCookie2 r0 = (BasicClientCookie2) super.clone();
        int[] r1 = this.ports;
        if (r1 == null) goto L5;
        r0.ports = (int[]) r1.clone();
    L5:
        return r0;
    }
}
