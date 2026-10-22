package androidx.room;

import android.content.Context;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class Room {
    private static final String CURSOR_CONV_SUFFIX = "_CursorConverter";
    static final String LOG_TAG = "ROOM";
    public static final String MASTER_TABLE_NAME = "room_master_table";

    @Deprecated
    public Room() {
    }

    @NonNull
    public static <T extends RoomDatabase> RoomDatabase.Builder<T> databaseBuilder(@NonNull Context r1, @NonNull Class<T> r2, @NonNull String r3) {
        if (r3 == null) goto L8;
        if (r3.trim().length() == 0) goto L8;
        return new RoomDatabase.Builder(r1, r2, r3);
    L8:
        throw new IllegalArgumentException("Cannot build a database with null or empty name. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder");
    }

    @NonNull
    static <T, C> T getGeneratedImplementation(Class<C> r5, String r6) {
        String r0 = r5.getPackage().getName();
        String r1 = r5.getCanonicalName();
        if (r0.isEmpty() == true) goto L6;
        r1 = r1.substring(r0.length() + 1);
    L6:
        String r7 = r1.replace('.', '_') + r6;
        if (r0.isEmpty() == false) goto L10;
        String r2 = r7;
    L11:
        return (T) Class.forName(r2).newInstance();
    L10:
        r2 = r0 + "." + r7;     // Catch: InstantiationException -> L13 IllegalAccessException -> L15 ClassNotFoundException -> L17
    L18:
        throw new RuntimeException("cannot find implementation for " + r5.getCanonicalName() + ". " + r7 + " does not exist");
    L16:
        throw new RuntimeException("Cannot access the constructor" + r5.getCanonicalName());
    L14:
        throw new RuntimeException("Failed to create an instance of " + r5.getCanonicalName());
    }

    @NonNull
    public static <T extends RoomDatabase> RoomDatabase.Builder<T> inMemoryDatabaseBuilder(@NonNull Context r2, @NonNull Class<T> r3) {
        return new RoomDatabase.Builder(r2, r3, null);
    }
}
