package com.bytedance.sync.v2.presistence.c;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@Dao
public interface g {
    @Delete
    int a(List<? extends com.bytedance.sync.v2.presistence.d.f> r1);

    @Insert(onConflict = 1)
    void b(List<? extends com.bytedance.sync.v2.presistence.d.f> r1);

    @Update(onConflict = 1)
    int c(List<? extends com.bytedance.sync.v2.presistence.d.f> r1);

    @Insert
    long d(com.bytedance.sync.v2.presistence.d.f r1);

    @Query("SELECT * FROM t_report_synclog WHERE cursor <= 0 and did = :did and uid = :uid and business in (SELECT distinct id from t_business where bucket=:bucket) ORDER BY id ASC LIMIT :size")
    List<com.bytedance.sync.v2.presistence.d.f> g(com.bytedance.sync.v2.j.g r1, String r2, String r3, int r4);

    @Query("SELECT * FROM t_report_synclog WHERE cursor <= 0 and did = :did and business in (SELECT distinct id from t_business where bucket=:bucket) ORDER BY id ASC LIMIT :size")
    List<com.bytedance.sync.v2.presistence.d.f> h(com.bytedance.sync.v2.j.g r1, String r2, int r3);

    @Query("DELETE FROM t_report_synclog WHERE sync_id = :syncId AND cursor > 0 AND cursor <=:cursor")
    void i(long r1, long r3);

    @Query("DELETE FROM t_report_synclog WHERE t_report_synclog.business not in (SELECT distinct id from t_business) ")
    void l();

    @Query("SELECT * FROM t_report_synclog WHERE cursor > 0 and sync_id=:syncId ORDER BY cursor ASC LIMIT :limit")
    List<com.bytedance.sync.v2.presistence.d.f> n(String r1, int r2);
}
