package com.bytedance.sync.v2.presistence.c;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@Dao
public interface a {
    @Insert(onConflict = 1)
    void a(List<? extends com.bytedance.sync.v2.presistence.d.a> r1);

    @Insert(onConflict = 1)
    void b(List<? extends com.bytedance.sync.v2.presistence.d.c> r1);

    @Query("DELETE from t_sync_cursor where sync_id in (:pendingDelete)")
    void c(List<String> r1);

    @Query("SELECT * FROM t_sync_cursor WHERE sync_id = :syncId")
    com.bytedance.sync.v2.presistence.d.c d(long r1);

    @Query("UPDATE t_sync_cursor SET recv_cursor = 0 WHERE sync_id=:syncId")
    void e(String r1);

    @Query("SELECT * FROM t_sync_cursor WHERE did = :did")
    List<com.bytedance.sync.v2.presistence.d.c> f(String r1);

    @Query("UPDATE t_sync_cursor SET report_cursor = :cursor WHERE sync_id = :syncId ")
    int g(String r1, long r2);
}
