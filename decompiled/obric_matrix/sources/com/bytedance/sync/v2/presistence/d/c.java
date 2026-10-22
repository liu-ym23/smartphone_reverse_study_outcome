package com.bytedance.sync.v2.presistence.d;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import com.bytedance.sync.v2.j.g;
import com.bytedance.sync.v2.j.p;

/* JADX INFO: loaded from: classes.dex */
@Entity(primaryKeys = {"sync_id"}, tableName = "t_sync_cursor")
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    @ColumnInfo(name = "sync_id")
    public String f6229a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @ColumnInfo(name = "did")
    public String f6230b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @ColumnInfo(name = "uid")
    public String f6231c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @ColumnInfo(name = "topic_type")
    public p f6232d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @ColumnInfo(name = "bucket")
    public g f6233e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @ColumnInfo(name = "recv_cursor")
    public long f6234f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @ColumnInfo(name = "report_cursor")
    public long f6235g;

    public c() {
    }

    public c(c r3) {
        this.f6230b = r3.f6230b;
        this.f6231c = r3.f6231c;
        this.f6229a = r3.f6229a;
        this.f6232d = r3.f6232d;
        this.f6233e = r3.f6233e;
        this.f6234f = r3.f6234f;
        this.f6235g = r3.f6235g;
    }

    public String toString() {
        return "SyncCursor{did='" + this.f6230b + "', uid='" + this.f6231c + "', syncId='" + this.f6229a + "', topicType=" + this.f6232d + ", bucket=" + this.f6233e + ", receiveCursor=" + this.f6234f + ", reportCursor=" + this.f6235g + '}';
    }
}
