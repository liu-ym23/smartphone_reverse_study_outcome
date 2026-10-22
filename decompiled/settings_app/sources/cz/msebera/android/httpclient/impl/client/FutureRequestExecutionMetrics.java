package cz.msebera.android.httpclient.impl.client;

import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes5.dex */
public final class FutureRequestExecutionMetrics {
    private final AtomicLong activeConnections;
    private final DurationCounter failedConnections;
    private final DurationCounter requests;
    private final AtomicLong scheduledConnections;
    private final DurationCounter successfulConnections;
    private final DurationCounter tasks;

    static class DurationCounter {
        private final AtomicLong count;
        private final AtomicLong cumulativeDuration;

        DurationCounter() {
            this.count = new AtomicLong(0);
            this.cumulativeDuration = new AtomicLong(0);
        }

        public void increment(long r3) {
            this.count.incrementAndGet();
            this.cumulativeDuration.addAndGet(System.currentTimeMillis() - r3);
        }

        public long count() {
            return this.count.get();
        }

        public long averageDuration() {
            long r0 = this.count.get();
            if (r0 > 0) goto L5;
            return 0;
        L5:
            return this.cumulativeDuration.get() / r0;
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder("[count=");
            r0.append(count()).append(", averageDuration=").append(averageDuration()).append("]");
            return r0.toString();
        }
    }

    FutureRequestExecutionMetrics() {
        this.activeConnections = new AtomicLong();
        this.scheduledConnections = new AtomicLong();
        this.successfulConnections = new DurationCounter();
        this.failedConnections = new DurationCounter();
        this.requests = new DurationCounter();
        this.tasks = new DurationCounter();
    }

    AtomicLong getActiveConnections() {
        return this.activeConnections;
    }

    AtomicLong getScheduledConnections() {
        return this.scheduledConnections;
    }

    DurationCounter getSuccessfulConnections() {
        return this.successfulConnections;
    }

    DurationCounter getFailedConnections() {
        return this.failedConnections;
    }

    DurationCounter getRequests() {
        return this.requests;
    }

    DurationCounter getTasks() {
        return this.tasks;
    }

    public long getActiveConnectionCount() {
        return this.activeConnections.get();
    }

    public long getScheduledConnectionCount() {
        return this.scheduledConnections.get();
    }

    public long getSuccessfulConnectionCount() {
        return this.successfulConnections.count();
    }

    public long getSuccessfulConnectionAverageDuration() {
        return this.successfulConnections.averageDuration();
    }

    public long getFailedConnectionCount() {
        return this.failedConnections.count();
    }

    public long getFailedConnectionAverageDuration() {
        return this.failedConnections.averageDuration();
    }

    public long getRequestCount() {
        return this.requests.count();
    }

    public long getRequestAverageDuration() {
        return this.requests.averageDuration();
    }

    public long getTaskCount() {
        return this.tasks.count();
    }

    public long getTaskAverageDuration() {
        return this.tasks.averageDuration();
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("[activeConnections=");
        r0.append(this.activeConnections).append(", scheduledConnections=").append(this.scheduledConnections).append(", successfulConnections=").append(this.successfulConnections).append(", failedConnections=").append(this.failedConnections).append(", requests=").append(this.requests).append(", tasks=").append(this.tasks).append("]");
        return r0.toString();
    }
}
