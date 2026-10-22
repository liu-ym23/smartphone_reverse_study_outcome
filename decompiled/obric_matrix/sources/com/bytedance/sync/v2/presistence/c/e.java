package com.bytedance.sync.v2.presistence.c;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import com.bytedance.sync.v2.j.n;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@Dao
public interface e {
    @Query("DELETE FROM t_snapshot WHERE sync_id = :syncId")
    void a(String r1);

    @Query("DELETE FROM t_synclog WHERE sync_id = :syncId")
    void b(String r1);

    @Query("SELECT * FROM t_synclog WHERE sync_id in (:syncIds) AND packet_status =:packetStatus ORDER BY sync_id, business, sync_cursor ASC LIMIT :size offset :offset")
    List<com.bytedance.sync.v2.presistence.d.e> c(Set<Long> r1, n r2, int r3, int r4);

    @Insert(onConflict = 1)
    void d(com.bytedance.sync.v2.presistence.d.b r1);

    @Insert(onConflict = 1)
    long e(com.bytedance.sync.v2.presistence.d.b r1);

    @Query("SELECT * FROM t_snapshot WHERE notified < cursor ORDER BY sync_id,business LIMIT :limit offset :offset")
    List<com.bytedance.sync.v2.presistence.d.b> f(int r1, int r2);

    @Insert(onConflict = 1)
    void g(ArrayList<com.bytedance.sync.v2.presistence.d.e> r1);

    @Query("SELECT * FROM t_synclog WHERE business = :business AND consume_type = :consumeType ORDER BY sync_cursor ASC limit :limit offset :offset")
    List<com.bytedance.sync.v2.presistence.d.e> h(long r1, int r3, com.bytedance.sync.v2.j.h r4, int r5);

    @Delete
    int i(List<? extends com.bytedance.sync.v2.presistence.d.e> r1);

    @Query("SELECT * FROM t_snapshot WHERE sync_id = :syncId AND business = :business ")
    com.bytedance.sync.v2.presistence.d.b k(String r1, long r2);
}
