package com.loopj.android.http;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import cz.msebera.android.httpclient.client.CookieStore;
import cz.msebera.android.httpclient.cookie.Cookie;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes4.dex */
public class PersistentCookieStore implements CookieStore {
    private static final String COOKIE_NAME_PREFIX = "cookie_";
    private static final String COOKIE_NAME_STORE = "names";
    private static final String COOKIE_PREFS = "CookiePrefsFile";
    private static final String LOG_TAG = "PersistentCookieStore";
    private final SharedPreferences cookiePrefs;
    private final ConcurrentHashMap<String, Cookie> cookies;
    private boolean omitNonPersistentCookies;

    public PersistentCookieStore(Context r8) {
        int r0 = 0;
        this.omitNonPersistentCookies = false;
        SharedPreferences r9 = r8.getSharedPreferences(COOKIE_PREFS, 0);
        this.cookiePrefs = r9;
        this.cookies = new ConcurrentHashMap();
        String r10 = r9.getString(COOKIE_NAME_STORE, null);
        if (r10 == null) goto L18;
        String[] r11 = TextUtils.split(r10, ",");
        int r1 = r11.length;
    L5:
        if (r0 >= r1) goto L12;
        String r3 = r11[r0];
        String r4 = this.cookiePrefs.getString(COOKIE_NAME_PREFIX + r3, null);
        if (r4 == null) goto L11;
        Cookie r5 = decodeCookie(r4);
        if (r5 == null) goto L11;
        this.cookies.put(r3, r5);
    L11:
        r0 = r0 + 1;
        goto L5
    L12:
        clearExpired(new Date());
        return;
    }

    @Override // cz.msebera.android.httpclient.client.CookieStore
    public void addCookie(Cookie r5) {
        if (this.omitNonPersistentCookies == true) goto L5;
    L7:
        String r0 = r5.getName() + r5.getDomain();
        if (r5.isExpired(new Date()) == true) goto L10;
        this.cookies.put(r0, r5);
    L11:
        SharedPreferences.Editor r1 = this.cookiePrefs.edit();
        r1.putString(COOKIE_NAME_STORE, TextUtils.join(",", this.cookies.keySet()));
        r1.putString(COOKIE_NAME_PREFIX + r0, encodeCookie(new SerializableCookie(r5)));
        r1.apply();
        return;
    L10:
        this.cookies.remove(r0);
        goto L11
    L5:
        if (r5.isPersistent() == true) goto L7;
    }

    @Override // cz.msebera.android.httpclient.client.CookieStore
    public void clear() {
        SharedPreferences.Editor r0 = this.cookiePrefs.edit();
        Iterator<String> r1 = this.cookies.keySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r0.remove(COOKIE_NAME_PREFIX + r1.next());
        goto L4
    L6:
        r0.remove(COOKIE_NAME_STORE);
        r0.apply();
        this.cookies.clear();
    }

    @Override // cz.msebera.android.httpclient.client.CookieStore
    public boolean clearExpired(Date r6) {
        SharedPreferences.Editor r0 = this.cookiePrefs.edit();
        Iterator<Map.Entry<String, Cookie>> r1 = this.cookies.entrySet().iterator();
        boolean r2 = false;
    L4:
        if (r1.hasNext() == false) goto L8;
        Map.Entry<String, Cookie> r3 = r1.next();
        String r4 = r3.getKey();
        if (r3.getValue().isExpired(r6) == false) goto L4;
        this.cookies.remove(r4);
        r0.remove(COOKIE_NAME_PREFIX + r4);
        r2 = true;
        goto L4
    L8:
        if (r2 == false) goto L10;
        r0.putString(COOKIE_NAME_STORE, TextUtils.join(",", this.cookies.keySet()));
    L10:
        r0.apply();
        return r2;
    }

    @Override // cz.msebera.android.httpclient.client.CookieStore
    public List<Cookie> getCookies() {
        return new ArrayList(this.cookies.values());
    }

    public void setOmitNonPersistentCookies(boolean r1) {
        this.omitNonPersistentCookies = r1;
    }

    public void deleteCookie(Cookie r3) {
        String r4 = r3.getName() + r3.getDomain();
        this.cookies.remove(r4);
        SharedPreferences.Editor r2 = this.cookiePrefs.edit();
        r2.remove(COOKIE_NAME_PREFIX + r4);
        r2.apply();
    }

    protected String encodeCookie(SerializableCookie r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        ByteArrayOutputStream r1 = new ByteArrayOutputStream();
        new ObjectOutputStream(r1).writeObject(r4);     // Catch: IOException -> L9
        return byteArrayToHexString(r1.toByteArray());
    L9:
        e = move-exception;
        AsyncHttpClient.log.d(LOG_TAG, "IOException in encodeCookie", e);
        return null;
    }

    protected Cookie decodeCookie(String r3) {
    L13:
        return ((SerializableCookie) new ObjectInputStream(new ByteArrayInputStream(hexStringToByteArray(r3))).readObject()).getCookie();
    L7:
        e = move-exception;
        AsyncHttpClient.log.d(LOG_TAG, "IOException in decodeCookie", e);
    L9:
        return null;
    L5:
        e = move-exception;
        AsyncHttpClient.log.d(LOG_TAG, "ClassNotFoundException in decodeCookie", e);
        goto L9
    }

    protected String byteArrayToHexString(byte[] r5) {
        StringBuilder r4 = new StringBuilder(r5.length * 2);
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L9;
        int r2 = r5[r1] & 255;
        if (r2 >= 16) goto L7;
        r4.append('0');
    L7:
        r4.append(Integer.toHexString(r2));
        r1 = r1 + 1;
        goto L3
    L9:
        return r4.toString().toUpperCase(Locale.US);
    }

    protected byte[] hexStringToByteArray(String r7) {
        int r6 = r7.length();
        byte[] r0 = new byte[r6 / 2];
        int r1 = 0;
    L3:
        if (r1 >= r6) goto L5;
        r0[r1 / 2] = (byte) ((Character.digit(r7.charAt(r1), 16) << 4) + Character.digit(r7.charAt(r1 + 1), 16));
        r1 = r1 + 2;
        goto L3
    L5:
        return r0;
    }
}
