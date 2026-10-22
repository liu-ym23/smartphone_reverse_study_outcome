package cz.msebera.android.httpclient.impl.client.cache;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Formatter;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
class BasicIdGenerator {
    private long count;
    private final String hostname;
    private final SecureRandom rnd;

    public BasicIdGenerator() {
        String r0 = InetAddress.getLocalHost().getHostName();     // Catch: UnknownHostException -> L5
    L6:
        this.hostname = r0;
        this.rnd = SecureRandom.getInstance("SHA1PRNG");     // Catch: NoSuchAlgorithmException -> L9
        return;
    L9:
        e = move-exception;
        throw new Error(e);
    L5:
        r0 = "localhost";
        goto L6
    }

    public synchronized void generate(StringBuilder r8) {
        monitor-enter(this);
        this.count++;     // Catch: Throwable -> L6
        int r0 = this.rnd.nextInt();     // Catch: Throwable -> L6
        r8.append(System.currentTimeMillis());     // Catch: Throwable -> L6
        r8.append('.');     // Catch: Throwable -> L6
        Formatter r2 = new Formatter(r8, Locale.US);     // Catch: Throwable -> L6
        r2.format("%1$016x-%2$08x", new Object[]{Long.valueOf(this.count), Integer.valueOf(r0)});     // Catch: Throwable -> L6
        r2.close();     // Catch: Throwable -> L6
        r8.append('.');     // Catch: Throwable -> L6
        r8.append(this.hostname);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public String generate() {
        StringBuilder r0 = new StringBuilder();
        generate(r0);
        return r0.toString();
    }
}
