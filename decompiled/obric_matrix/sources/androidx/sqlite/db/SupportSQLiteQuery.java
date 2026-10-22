package androidx.sqlite.db;

/* JADX INFO: loaded from: classes.dex */
public interface SupportSQLiteQuery {
    void bindTo(SupportSQLiteProgram r1);

    int getArgCount();

    String getSql();
}
