package com.bytedance.sync.v2.presistence.d;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.window.embedding.EmbeddingCompat;
import com.bytedance.sync.v2.j.g;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
@Entity(tableName = "t_report_synclog")
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @PrimaryKey(autoGenerate = EmbeddingCompat.DEBUG)
    @ColumnInfo(name = "id")
    public long f6260a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @ColumnInfo(name = "sync_id")
    public String f6261b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @ColumnInfo(name = "business")
    public long f6262c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @ColumnInfo(name = "did")
    public String f6263d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @ColumnInfo(name = "uid")
    public String f6264e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @ColumnInfo(name = "bucket")
    public g f6265f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @ColumnInfo(name = "cursor")
    public long f6266g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @ColumnInfo(name = "data")
    public byte[] f6267h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @ColumnInfo(name = "md5")
    public String f6268i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @ColumnInfo(name = "msg_id")
    public String f6269j;

    public f() {
    }

    public String toString() {
        return "UploadItem{id=" + this.f6260a + ", syncId='" + this.f6261b + "', business=" + this.f6262c + ", did='" + this.f6263d + "', uid='" + this.f6264e + "', bucket=" + this.f6265f + ", cursor=" + this.f6266g + ", data=" + Arrays.toString(this.f6267h) + ", md5='" + this.f6268i + "', msg_id='" + this.f6269j + "'}";
    }
}
