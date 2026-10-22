package cz.msebera.android.httpclient.cookie;

import java.util.Date;

/* JADX INFO: loaded from: classes5.dex */
public interface SetCookie extends Cookie {
    void setComment(String r1);

    void setDomain(String r1);

    void setExpiryDate(Date r1);

    void setPath(String r1);

    void setSecure(boolean r1);

    void setValue(String r1);

    void setVersion(int r1);
}
