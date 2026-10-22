package com.google.crypto.tink.internal;

import com.google.crypto.tink.monitoring.MonitoringClient;
import com.google.crypto.tink.monitoring.MonitoringKeysetInfo;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public final class MutableMonitoringRegistry {
    private static final DoNothingClient DO_NOTHING_CLIENT = null;
    private static final MutableMonitoringRegistry GLOBAL_INSTANCE = null;
    private final AtomicReference<MonitoringClient> monitoringClient;

    /* JADX INFO: renamed from: com.google.crypto.tink.internal.MutableMonitoringRegistry$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class DoNothingClient implements MonitoringClient {
        private DoNothingClient() {
        }

        /* synthetic */ DoNothingClient(AnonymousClass1 r1) {
            this();
        }

        @Override // com.google.crypto.tink.monitoring.MonitoringClient
        public MonitoringClient.Logger createLogger(MonitoringKeysetInfo keysetInfo, String primitive, String api) {
            return MonitoringUtil.DO_NOTHING_LOGGER;
        }
    }

    static {
        GLOBAL_INSTANCE = new MutableMonitoringRegistry();
        DO_NOTHING_CLIENT = new DoNothingClient(null);
    }

    public static MutableMonitoringRegistry globalInstance() {
        return GLOBAL_INSTANCE;
    }

    public synchronized void clear() {
        monitor-enter(this);
        this.monitoringClient.set(null);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void registerMonitoringClient(MonitoringClient client) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.monitoringClient.get() != null) goto L9;
        this.monitoringClient.set(client);     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L9:
        throw new IllegalStateException("a monitoring client has already been registered");     // Catch: Throwable -> L10
    }

    public MonitoringClient getMonitoringClient() {
        MonitoringClient r0 = this.monitoringClient.get();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return DO_NOTHING_CLIENT;
    }

    public MutableMonitoringRegistry() {
        this.monitoringClient = new AtomicReference();
    }
}
