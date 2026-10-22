package com.bytedance.sync.v2.presistence.c;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import com.bytedance.sync.v2.j.p;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@Dao
public interface c {
    @Query("SELECT * FROM t_history_synclog  WHERE did=:did AND uid in (0, :uid) AND business =:businessId  AND topic_type = :topicType ORDER BY sync_cursor DESC  LIMIT :limit")
    List<com.bytedance.sync.v2.presistence.d.d> a(String r1, String r2, long r3, p r5, int r6);

    @Delete
    void b(List<? extends com.bytedance.sync.v2.presistence.d.d> r1);

    @Query("SELECT * FROM t_history_synclog  WHERE did=:did AND uid in (0, :uid) AND business =:businessId  AND topic_type = :topicType AND req_id = :reqId ORDER BY sync_cursor DESC LIMIT :limit")
    List<com.bytedance.sync.v2.presistence.d.d> c(String r1, String r2, long r3, p r5, String r6, int r7);

    @Query("SELECT * FROM t_history_synclog  WHERE did=:did AND uid in (0, :uid) AND business =:businessId  AND topic_type = :topicType ORDER BY publish_ts DESC  LIMIT :limit")
    List<com.bytedance.sync.v2.presistence.d.d> d(String r1, String r2, long r3, p r5, int r6);

    @Insert(onConflict = 1)
    void e(ArrayList<com.bytedance.sync.v2.presistence.d.d> r1);
}
