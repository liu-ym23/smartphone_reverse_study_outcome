package com.bytedance.frameworks.baselib.network.http.impl;

import android.util.Log;
import com.bytedance.frameworks.baselib.network.http.io.SafeObjectInputStream;
import com.bytedance.frameworks.baselib.network.http.util.HttpHost;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class SerializableHttpCookie implements Serializable {
    private static final char[] HEX_ARRAY = null;
    private static final String TAG = "SerializableHttpCookie";
    private static final long serialVersionUID = 6374381323722046732L;
    private transient HttpCookie cookie;
    private long whenCreated;

    static {
        HEX_ARRAY = "0123456789ABCDEF".toCharArray();
    }

    public SerializableHttpCookie(HttpCookie r3) {
        this.cookie = r3;
        this.whenCreated = System.currentTimeMillis();
    }

    private String byteArrayToHexString(byte[] r6) {
        char[] r5 = new char[r6.length * 2];
        int r0 = 0;
    L4:
        if (r0 >= r6.length) goto L7;
        byte r1 = r6[r0];
        int r3 = r0 * 2;
        char[] r4 = HEX_ARRAY;
        r5[r3] = r4[(r1 & 255) >>> 4];
        r5[r3 + 1] = r4[r1 & 15];
        r0 = r0 + 1;
        goto L4
    L7:
        return new String(r5);
    }

    public static SerializableHttpCookie decode(String r3) {
        if (r3 != null) goto L5;
    L16:
        return null;
    L5:
        if (r3.isEmpty() == true) goto L16;
        return (SerializableHttpCookie) new SafeObjectInputStream(new ByteArrayInputStream(hexStringToByteArray(r3)), new Class[]{SerializableHttpCookie.class}).readObject();
    L12:
        e = move-exception;
        Log.d(TAG, "IOException in decodeCookie", e);
    L10:
        e = move-exception;
        Log.d(TAG, "ClassNotFoundException in decodeCookie", e);
        goto L16
    }

    public static int getEffectivePort(String r1, int r2) {
        if (r2 == (-1)) goto L6;
        return r2;
    L6:
        if (HttpHost.DEFAULT_SCHEME_NAME.equalsIgnoreCase(r1) == false) goto L10;
        return 80;
    L10:
        if ("https".equalsIgnoreCase(r1) == false) goto L13;
        return 443;
    L13:
        return -1;
    }

    private boolean getHttpOnly() {
        return this.cookie.getHttpOnly();
    }

    private static byte[] hexStringToByteArray(String r7) {
        int r0 = r7.length();
        byte[] r1 = new byte[r0 / 2];
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        int r4 = Character.digit(r7.charAt(r2), 16) << 4;
        r1[r2 / 2] = (byte) (Character.digit(r7.charAt(r2 + 1), 16) + r4);
        r2 = r2 + 2;
        goto L3
    L5:
        return r1;
    }

    private void readObject(ObjectInputStream r4) {
        HttpCookie r2 = new HttpCookie((String) r4.readObject(), (String) r4.readObject());
        this.cookie = r2;
        r2.setComment((String) r4.readObject());
        this.cookie.setCommentURL((String) r4.readObject());
        this.cookie.setDomain((String) r4.readObject());
        this.cookie.setMaxAge(r4.readLong());
        this.cookie.setPath((String) r4.readObject());
        this.cookie.setPortlist((String) r4.readObject());
        this.cookie.setVersion(r4.readInt());
        this.cookie.setSecure(r4.readBoolean());
        this.cookie.setDiscard(r4.readBoolean());
        setHttpOnly(r4.readBoolean());
        this.whenCreated = r4.readLong();
    }

    private void setHttpOnly(boolean r1) {
        this.cookie.setHttpOnly(r1);
    }

    private void writeObject(ObjectOutputStream r3) {
        r3.writeObject(this.cookie.getName());
        r3.writeObject(this.cookie.getValue());
        r3.writeObject(this.cookie.getComment());
        r3.writeObject(this.cookie.getCommentURL());
        r3.writeObject(this.cookie.getDomain());
        r3.writeLong(this.cookie.getMaxAge());
        r3.writeObject(this.cookie.getPath());
        r3.writeObject(this.cookie.getPortlist());
        r3.writeInt(this.cookie.getVersion());
        r3.writeBoolean(this.cookie.getSecure());
        r3.writeBoolean(this.cookie.getDiscard());
        r3.writeBoolean(getHttpOnly());
        r3.writeLong(this.whenCreated);
    }

    public String encode() {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        new ObjectOutputStream(r0).writeObject(this);     // Catch: IOException -> L6
        return byteArrayToHexString(r0.toByteArray());
    L6:
        e = move-exception;
        Log.d(TAG, "IOException in encodeCookie", e);
        return null;
    }

    public boolean equals(Object r2) {
        if ((r2 instanceof HttpCookie) == false) goto L7;
        return this.cookie.equals(r2);
    L7:
        if ((r2 instanceof SerializableHttpCookie) == true) goto L9;
        return false;
    L9:
        return this.cookie.equals(((SerializableHttpCookie) r2).cookie);
    }

    public HttpCookie getHttpCookie() {
        return this.cookie;
    }

    public Long getWhenCreated() {
        return Long.valueOf(this.whenCreated);
    }

    public boolean hasExpired() {
        long r0 = this.cookie.getMaxAge();
        if (r0 != (-1)) goto L6;
        return false;
    L6:
        if (((System.currentTimeMillis() - this.whenCreated) / 1000) <= r0) goto L9;
        return true;
    L9:
        return false;
    }

    public int hashCode() {
        return this.cookie.hashCode();
    }
}
