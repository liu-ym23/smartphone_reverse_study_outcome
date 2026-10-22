package androidx.core.net;

import android.net.TrafficStats;
import androidx.annotation.NonNull;
import java.net.DatagramSocket;
import java.net.Socket;

/* JADX INFO: loaded from: classes.dex */
public final class TrafficStatsCompat {
    private TrafficStatsCompat() {
    }

    @Deprecated
    public static void clearThreadStatsTag() {
        TrafficStats.clearThreadStatsTag();
    }

    @Deprecated
    public static int getThreadStatsTag() {
        return TrafficStats.getThreadStatsTag();
    }

    @Deprecated
    public static void incrementOperationCount(int r0) {
        TrafficStats.incrementOperationCount(r0);
    }

    @Deprecated
    public static void setThreadStatsTag(int r0) {
        TrafficStats.setThreadStatsTag(r0);
    }

    public static void tagDatagramSocket(@NonNull DatagramSocket r0) {
        TrafficStats.tagDatagramSocket(r0);
    }

    @Deprecated
    public static void tagSocket(Socket r0) {
        TrafficStats.tagSocket(r0);
    }

    public static void untagDatagramSocket(@NonNull DatagramSocket r0) {
        TrafficStats.untagDatagramSocket(r0);
    }

    @Deprecated
    public static void untagSocket(Socket r0) {
        TrafficStats.untagSocket(r0);
    }

    @Deprecated
    public static void incrementOperationCount(int r0, int r1) {
        TrafficStats.incrementOperationCount(r0, r1);
    }
}
