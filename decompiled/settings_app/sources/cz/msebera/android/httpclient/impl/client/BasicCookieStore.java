package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.client.CookieStore;
import cz.msebera.android.httpclient.cookie.Cookie;
import cz.msebera.android.httpclient.cookie.CookieIdentityComparator;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes5.dex */
public class BasicCookieStore implements CookieStore, Serializable {
    private static final long serialVersionUID = -7581093305228232025L;
    private final TreeSet<Cookie> cookies;
    private transient ReadWriteLock lock;

    public BasicCookieStore() {
        this.cookies = new TreeSet(new CookieIdentityComparator());
        this.lock = new ReentrantReadWriteLock();
    }

    private void readObject(ObjectInputStream r1) throws IOException, ClassNotFoundException {
        r1.defaultReadObject();
        this.lock = new ReentrantReadWriteLock();
    }

    @Override // cz.msebera.android.httpclient.client.CookieStore
    public void addCookie(Cookie r2) {
        if (r2 == null) goto L11;
        this.lock.writeLock().lock();
        this.cookies.remove(r2);     // Catch: Throwable -> L8
        if (r2.isExpired(new Date()) == true) goto L7;
        this.cookies.add(r2);     // Catch: Throwable -> L8
    L7:
        this.lock.writeLock().unlock();
        return;
    L8:
        th = move-exception;
        this.lock.writeLock().unlock();
        throw th;
    }

    public void addCookies(Cookie[] r4) {
        if (r4 == null) goto L6;
        int r0 = r4.length;
        int r1 = 0;
    L4:
        if (r1 >= r0) goto L8;
        addCookie(r4[r1]);
        r1 = r1 + 1;
        goto L4
    L8:
        return;
    }

    @Override // cz.msebera.android.httpclient.client.CookieStore
    public List<Cookie> getCookies() {
        this.lock.readLock().lock();
        ArrayList r0 = new ArrayList(this.cookies);     // Catch: Throwable -> L6
        this.lock.readLock().unlock();
        return r0;
    L6:
        th = move-exception;
        this.lock.readLock().unlock();
        throw th;
    }

    @Override // cz.msebera.android.httpclient.client.CookieStore
    public boolean clearExpired(Date r4) {
        boolean r0 = false;
        if (r4 != null) goto L5;
        return false;
    L5:
        this.lock.writeLock().lock();
        Iterator<Cookie> r1 = this.cookies.iterator();     // Catch: Throwable -> L15
    L8:
        if (r1.hasNext() == false) goto L13;
        if (r1.next().isExpired(r4) == false) goto L8;
        r1.remove();     // Catch: Throwable -> L15
        r0 = true;
        goto L8
    L13:
        this.lock.writeLock().unlock();
        return r0;
    L15:
        th = move-exception;
        this.lock.writeLock().unlock();
        throw th;
    }

    @Override // cz.msebera.android.httpclient.client.CookieStore
    public void clear() {
        this.lock.writeLock().lock();
        this.cookies.clear();     // Catch: Throwable -> L6
        this.lock.writeLock().unlock();
        return;
    L6:
        th = move-exception;
        this.lock.writeLock().unlock();
        throw th;
    }

    public String toString() {
        this.lock.readLock().lock();
        String r0 = this.cookies.toString();     // Catch: Throwable -> L6
        this.lock.readLock().unlock();
        return r0;
    L6:
        th = move-exception;
        this.lock.readLock().unlock();
        throw th;
    }
}
