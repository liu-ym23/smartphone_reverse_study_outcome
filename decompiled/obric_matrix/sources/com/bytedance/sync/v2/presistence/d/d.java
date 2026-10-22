package com.bytedance.sync.v2.presistence.d;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.sync.v2.j.g;
import com.bytedance.sync.v2.j.h;
import com.bytedance.sync.v2.j.n;
import com.bytedance.sync.v2.j.p;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@Entity(primaryKeys = {"sync_id", "sync_cursor"}, tableName = "t_history_synclog")
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    @ColumnInfo(name = "sync_id")
    public String f6236a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @ColumnInfo(name = "did")
    public String f6237b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @ColumnInfo(name = "uid")
    public String f6238c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @ColumnInfo(name = "sync_cursor")
    public long f6239d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @ColumnInfo(name = "data", typeAffinity = 5)
    public byte[] f6240e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @ColumnInfo(name = "md5")
    public String f6241f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @ColumnInfo(name = "business")
    public long f6242g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @ColumnInfo(name = "consume_type")
    public h f6243h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @ColumnInfo(name = "data_type")
    public d.b.u.y.a f6244i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @ColumnInfo(name = "publish_ts")
    public long f6245j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @ColumnInfo(name = "receive_ts")
    public long f6246k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @ColumnInfo(name = "bucket")
    public g f6247l;

    @ColumnInfo(name = "req_id")
    public String m;

    @ColumnInfo(name = "topic_type")
    public p n;

    @ColumnInfo(name = "packet_status")
    public n o;

    @ColumnInfo(name = WsConstants.KEY_EXTRA)
    public Map<String, String> p;

    public d() {
    }

    public String toString() {
        return "SyncHistoryLog{syncId='" + this.f6236a + "', did='" + this.f6237b + "', uid='" + this.f6238c + "', syncCursor=" + this.f6239d + ", data=" + Arrays.toString(this.f6240e) + ", md5='" + this.f6241f + "', business=" + this.f6242g + ", consumeType=" + this.f6243h + ", dataType=" + this.f6244i + ", publishTs=" + this.f6245j + ", receiveTs=" + this.f6246k + ", bucket=" + this.f6247l + ", reqId='" + this.m + "', topicType=" + this.n + ", packetStatus=" + this.o + ", extra=" + this.p + '}';
    }
}
