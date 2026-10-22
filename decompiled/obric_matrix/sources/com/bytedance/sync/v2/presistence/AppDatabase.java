package com.bytedance.sync.v2.presistence;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import com.bytedance.sync.v2.presistence.b.b;
import com.bytedance.sync.v2.presistence.b.c;
import com.bytedance.sync.v2.presistence.b.d;
import com.bytedance.sync.v2.presistence.b.e;
import com.bytedance.sync.v2.presistence.b.f;
import com.bytedance.sync.v2.presistence.b.g;

/* JADX INFO: loaded from: classes.dex */
@TypeConverters({com.bytedance.sync.v2.presistence.b.a.class, b.class, e.class, g.class, f.class, d.b.u.a0.a.a.class, c.class, d.class})
@Database(entities = {com.bytedance.sync.v2.presistence.d.a.class, com.bytedance.sync.v2.presistence.d.f.class, com.bytedance.sync.v2.presistence.d.c.class, com.bytedance.sync.v2.presistence.d.e.class, com.bytedance.sync.v2.presistence.d.b.class, com.bytedance.sync.v2.presistence.d.d.class}, version = 4)
public abstract class AppDatabase extends RoomDatabase {
    public AppDatabase() {
    }

    public abstract com.bytedance.sync.v2.presistence.c.a a();

    public abstract com.bytedance.sync.v2.presistence.c.c b();

    public abstract com.bytedance.sync.v2.presistence.c.e c();

    public abstract com.bytedance.sync.v2.presistence.c.g d();
}
