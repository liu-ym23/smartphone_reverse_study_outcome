package com.loopj.android.http;

import cz.msebera.android.httpclient.cookie.Cookie;
import cz.msebera.android.httpclient.impl.cookie.BasicClientCookie;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

/* JADX INFO: loaded from: classes4.dex */
public class SerializableCookie implements Serializable {
    private static final long serialVersionUID = 6374381828722046732L;
    private transient BasicClientCookie clientCookie;
    private final transient Cookie cookie;

    public SerializableCookie(Cookie r1) {
        this.cookie = r1;
    }

    public Cookie getCookie() {
        Cookie r0 = this.cookie;
        BasicClientCookie r1 = this.clientCookie;
        if (r1 != null) goto L5;
        return r0;
    L5:
        return r1;
    }

    private void writeObject(ObjectOutputStream r2) throws IOException {
        r2.writeObject(this.cookie.getName());
        r2.writeObject(this.cookie.getValue());
        r2.writeObject(this.cookie.getComment());
        r2.writeObject(this.cookie.getDomain());
        r2.writeObject(this.cookie.getExpiryDate());
        r2.writeObject(this.cookie.getPath());
        r2.writeInt(this.cookie.getVersion());
        r2.writeBoolean(this.cookie.isSecure());
    }

    private void readObject(ObjectInputStream r4) throws IOException, ClassNotFoundException {
        BasicClientCookie r2 = new BasicClientCookie((String) r4.readObject(), (String) r4.readObject());
        this.clientCookie = r2;
        r2.setComment((String) r4.readObject());
        this.clientCookie.setDomain((String) r4.readObject());
        this.clientCookie.setExpiryDate((Date) r4.readObject());
        this.clientCookie.setPath((String) r4.readObject());
        this.clientCookie.setVersion(r4.readInt());
        this.clientCookie.setSecure(r4.readBoolean());
    }
}
