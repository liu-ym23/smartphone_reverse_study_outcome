package com.bytedance.sync.v2.presistence.d;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.bytedance.sync.v2.j.g;
import com.bytedance.sync.v2.j.h;

/* JADX INFO: loaded from: classes.dex */
@Entity(tableName = "t_business")
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @PrimaryKey
    @ColumnInfo(name = "id")
    public int f6214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @ColumnInfo(name = "consume_type")
    public h f6215b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @ColumnInfo(name = "bucket")
    public g f6216c;

    public a() {
    }

    public String toString() {
        return "Business{id=" + this.f6214a + ", consumeType=" + this.f6215b + ", bucket=" + this.f6216c + '}';
    }
}
