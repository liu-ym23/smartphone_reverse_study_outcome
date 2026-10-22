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
@Entity(primaryKeys = {"sync_id", "sync_cursor"}, tableName = "t_synclog")
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    @ColumnInfo(name = "sync_id")
    public String f6248a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @ColumnInfo(name = "did")
    public String f6249b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @ColumnInfo(name = "uid")
    public String f6250c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @ColumnInfo(name = "sync_cursor")
    public long f6251d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @ColumnInfo(name = "data", typeAffinity = 5)
    public byte[] f6252e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @ColumnInfo(name = "md5")
    public String f6253f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @ColumnInfo(name = "business")
    public long f6254g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @ColumnInfo(name = "consume_type")
    public h f6255h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @ColumnInfo(name = "data_type")
    public d.b.u.y.a f6256i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @ColumnInfo(name = "publish_ts")
    public long f6257j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @ColumnInfo(name = "receive_ts")
    public long f6258k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @ColumnInfo(name = "bucket")
    public g f6259l;

    @ColumnInfo(name = "req_id")
    public String m;

    @NonNull
    @ColumnInfo(name = "topic_type")
    public p n;

    @NonNull
    @ColumnInfo(name = "packet_status")
    public n o;

    @ColumnInfo(name = WsConstants.KEY_EXTRA)
    public Map<String, String> p;

    public e() {
    }

    public String toString() {
        return "SyncLog{syncId='" + this.f6248a + "', did='" + this.f6249b + "', uid='" + this.f6250c + "', syncCursor=" + this.f6251d + ", data=" + Arrays.toString(this.f6252e) + ", md5='" + this.f6253f + "', business=" + this.f6254g + ", consumeType=" + this.f6255h + ", dataType=" + this.f6256i + ", publishTs=" + this.f6257j + ", receiveTs=" + this.f6258k + ", bucket=" + this.f6259l + ", reqId='" + this.m + "', topicType=" + this.n + ", packetStatus=" + this.o + ", extra=" + this.p + '}';
    }
}
