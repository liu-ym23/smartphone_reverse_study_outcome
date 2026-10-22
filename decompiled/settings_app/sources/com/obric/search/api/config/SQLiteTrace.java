package com.obric.search.api.config;

import android.icu.text.PluralRules;
import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SQLiteTrace.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u0018J\"\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016JT\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\t2\u0014\u0010\r\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000f\u0018\u00010\u000e2\u001a\u0010\u0010\u001a\u0016\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u000f\u0018\u00010\u000eH\u0016J\b\u0010\u0013\u001a\u00020\u0003H\u0016J\"\u0010\u0014\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0007H\u0016¨\u0006\u0019"}, d2 = {"Lcom/obric/search/api/config/SQLiteTrace;", "", "onConnectionObtained", "", "sql", "", "waitTime", "", "isPrimary", "", "onConnectionPoolBusy", "sqlWaiting", "wantPrimaryConnection", "sqlRunning", "", "Lcom/obric/search/api/config/SQLiteTrace$TraceInfo;", "longLastingActions", "", "Ljava/lang/StackTraceElement;", "onDatabaseCorrupted", "onSQLExecuted", "type", "", "time", "TraceInfo", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface SQLiteTrace {

    /* JADX INFO: compiled from: SQLiteTrace.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {
        public static void onConnectionObtained(SQLiteTrace r0, String r1, long r2, boolean r4) {
        }

        public static void onConnectionPoolBusy(SQLiteTrace r0, String r1, long r2, boolean r4, List<TraceInfo<String>> r5, List<TraceInfo<StackTraceElement[]>> r6) {
        }

        public static void onDatabaseCorrupted(SQLiteTrace r0) {
        }

        public static void onSQLExecuted(SQLiteTrace r0, String r1, int r2, long r3) {
        }
    }

    /* JADX INFO: compiled from: SQLiteTrace.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u0010\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J2\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/obric/search/api/config/SQLiteTrace$TraceInfo;", ExifInterface.GPS_DIRECTION_TRUE, "", "info", "time", "", "tid", "", "(Ljava/lang/Object;JI)V", "getInfo", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getTid", "()I", "getTime", "()J", "component1", "component2", "component3", "copy", "(Ljava/lang/Object;JI)Lcom/obric/search/api/config/SQLiteTrace$TraceInfo;", "equals", "", PluralRules.KEYWORD_OTHER, "hashCode", "toString", "", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class TraceInfo<T> {
        private final T info;
        private final int tid;
        private final long time;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ TraceInfo copy$default(TraceInfo r0, Object r1, long r2, int r4, int r5, Object r6) {
            if ((r5 & 1) == 0) goto L6;
            r1 = r0.info;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r2 = r0.time;
        L9:
            if ((r5 & 4) == 0) goto L12;
            r4 = r0.tid;
        L12:
            return r0.copy(r1, r2, r4);
        }

        public final T component1() {
            return this.info;
        }

        public final long component2() {
            return this.time;
        }

        public final int component3() {
            return this.tid;
        }

        public final TraceInfo<T> copy(T r1, long r2, int r4) {
            return new TraceInfo(r1, r2, r4);
        }

        public boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof TraceInfo) == true) goto L8;
            return false;
        L8:
            TraceInfo r9 = (TraceInfo) r8;
            if (Intrinsics.areEqual(this.info, r9.info) == true) goto L12;
            return false;
        L12:
            if (this.time == r9.time) goto L15;
            return false;
        L15:
            if (this.tid == r9.tid) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            T r0 = this.info;
            if (r0 != null) goto L5;
            int r1 = 0;
        L7:
            return (((r1 * 31) + Long.hashCode(this.time)) * 31) + Integer.hashCode(this.tid);
        L5:
            r1 = r0.hashCode();
            goto L7
        }

        public String toString() {
            return "TraceInfo(info=" + this.info + ", time=" + this.time + ", tid=" + this.tid + ')';
        }

        public TraceInfo(T r1, long r2, int r4) {
            this.info = r1;
            this.time = r2;
            this.tid = r4;
        }

        public final T getInfo() {
            return this.info;
        }

        public final int getTid() {
            return this.tid;
        }

        public final long getTime() {
            return this.time;
        }
    }

    void onConnectionObtained(String r1, long r2, boolean r4);

    void onConnectionPoolBusy(String r1, long r2, boolean r4, List<TraceInfo<String>> r5, List<TraceInfo<StackTraceElement[]>> r6);

    void onDatabaseCorrupted();

    void onSQLExecuted(String r1, int r2, long r3);
}
