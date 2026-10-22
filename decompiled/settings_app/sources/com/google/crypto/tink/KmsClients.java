package com.google.crypto.tink;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes4.dex */
public final class KmsClients {
    private static List<KmsClient> autoClients;
    private static final CopyOnWriteArrayList<KmsClient> clients = null;

    static {
        clients = new CopyOnWriteArrayList();
    }

    public static void add(KmsClient client) {
        clients.add(client);
    }

    public static KmsClient get(String keyUri) throws GeneralSecurityException {
        Iterator<KmsClient> r0 = clients.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        KmsClient r1 = r0.next();
        if (r1.doesSupport(keyUri) == false) goto L4;
        return r1;
    L9:
        throw new GeneralSecurityException("No KMS client does support: " + keyUri);
    }

    @Deprecated
    public static synchronized KmsClient getAutoLoaded(String keyUri) throws GeneralSecurityException {
        monitor-enter(KmsClients.class);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (autoClients != null) goto L7;
        autoClients = loadAutoKmsClients();     // Catch: Throwable -> L16
    L7:
        Iterator<KmsClient> r1 = autoClients.iterator();     // Catch: Throwable -> L16
    L9:
        if (r1.hasNext() == false) goto L15;
        KmsClient r2 = r1.next();     // Catch: Throwable -> L16
        if (r2.doesSupport(keyUri) == false) goto L9;
        monitor-exit(KmsClients.class);
        return r2;
    L15:
        throw new GeneralSecurityException("No KMS client does support: " + keyUri);     // Catch: Throwable -> L16
    }

    static void reset() {
        clients.clear();
    }

    private static List<KmsClient> loadAutoKmsClients() {
        ArrayList r0 = new ArrayList();
        Iterator r1 = ServiceLoader.load(KmsClient.class).iterator();
    L4:
        if (r1.hasNext() == false) goto L7;
        r0.add((KmsClient) r1.next());
        goto L4
    L7:
        return Collections.unmodifiableList(r0);
    }

    private KmsClients() {
    }
}
