package com.bytedance.sync.v2.presistence.d;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import com.bytedance.sync.v2.j.g;
import com.bytedance.sync.v2.j.h;

/* JADX INFO: loaded from: classes.dex */
@Entity(primaryKeys = {"sync_id", "business"}, tableName = "t_snapshot")
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    @ColumnInfo(name = "sync_id")
    public String f6217a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    @ColumnInfo(name = "business")
    public long f6218b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @ColumnInfo(name = "uid")
    public String f6219c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @ColumnInfo(name = "did")
    public String f6220d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @ColumnInfo(name = "cursor")
    public long f6221e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @ColumnInfo(name = "data", typeAffinity = 5)
    public byte[] f6222f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @ColumnInfo(name = "notified")
    public long f6223g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @ColumnInfo(name = "bucket")
    public g f6224h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @ColumnInfo(name = "data_type")
    public d.b.u.y.a f6225i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @ColumnInfo(name = "publish_ts")
    public long f6226j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @ColumnInfo(name = "receive_ts")
    public long f6227k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @ColumnInfo(name = "consume_type")
    public h f6228l;

    @ColumnInfo(name = "patch_cnt")
    public int m;

    public b() {
    }
}
