package androidx.core.net;

import android.net.TrafficStats;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.net.DatagramSocket;
import java.net.Socket;

/* JADX INFO: loaded from: classes.dex */
public final class TrafficStatsCompat {

    @RequiresApi(24)
    static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        static void tagDatagramSocket(DatagramSocket r0) {
            TrafficStats.tagDatagramSocket(r0);
        }

        @DoNotInline
        static void untagDatagramSocket(DatagramSocket r0) {
            TrafficStats.untagDatagramSocket(r0);
        }
    }

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
    public static void incrementOperationCount(int r0, int r1) {
        TrafficStats.incrementOperationCount(r0, r1);
    }

    @Deprecated
    public static void setThreadStatsTag(int r0) {
        TrafficStats.setThreadStatsTag(r0);
    }

    public static void tagDatagramSocket(@NonNull DatagramSocket r3) {
        if (Build.VERSION.SDK_INT < 24) goto L5;
        Api24Impl.tagDatagramSocket(r3);
        return;
    L5:
        ParcelFileDescriptor r0 = ParcelFileDescriptor.fromDatagramSocket(r3);
        TrafficStats.tagSocket(new DatagramSocketWrapper(r3, r0.getFileDescriptor()));
        r0.detachFd();
    }

    @Deprecated
    public static void tagSocket(Socket r0) {
        TrafficStats.tagSocket(r0);
    }

    public static void untagDatagramSocket(@NonNull DatagramSocket r3) {
        if (Build.VERSION.SDK_INT < 24) goto L5;
        Api24Impl.untagDatagramSocket(r3);
        return;
    L5:
        ParcelFileDescriptor r0 = ParcelFileDescriptor.fromDatagramSocket(r3);
        TrafficStats.untagSocket(new DatagramSocketWrapper(r3, r0.getFileDescriptor()));
        r0.detachFd();
    }

    @Deprecated
    public static void untagSocket(Socket r0) {
        TrafficStats.untagSocket(r0);
    }
}
