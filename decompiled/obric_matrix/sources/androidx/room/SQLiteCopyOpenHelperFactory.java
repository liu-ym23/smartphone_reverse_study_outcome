package androidx.room;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
class SQLiteCopyOpenHelperFactory implements SupportSQLiteOpenHelper.Factory {

    @Nullable
    private final String mCopyFromAssetPath;

    @Nullable
    private final File mCopyFromFile;

    @NonNull
    private final SupportSQLiteOpenHelper.Factory mDelegate;

    SQLiteCopyOpenHelperFactory(@Nullable String r1, @Nullable File r2, @NonNull SupportSQLiteOpenHelper.Factory r3) {
        this.mCopyFromAssetPath = r1;
        this.mCopyFromFile = r2;
        this.mDelegate = r3;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Factory
    public SupportSQLiteOpenHelper create(SupportSQLiteOpenHelper.Configuration r8) {
        return new SQLiteCopyOpenHelper(r8.context, this.mCopyFromAssetPath, this.mCopyFromFile, r8.callback.version, this.mDelegate.create(r8));
    }
}
