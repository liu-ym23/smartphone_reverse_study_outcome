package androidx.sqlite.db;

import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class SupportSQLiteQueryBuilder {
    private static final Pattern sLimitPattern = null;
    private Object[] mBindArgs;
    private String[] mColumns;
    private boolean mDistinct;
    private String mGroupBy;
    private String mHaving;
    private String mLimit;
    private String mOrderBy;
    private String mSelection;
    private final String mTable;

    static {
        sLimitPattern = Pattern.compile("\\s*\\d+\\s*(,\\s*\\d+\\s*)?");
    }

    private SupportSQLiteQueryBuilder(String r2) {
        this.mDistinct = false;
        this.mColumns = null;
        this.mGroupBy = null;
        this.mHaving = null;
        this.mOrderBy = null;
        this.mLimit = null;
        this.mTable = r2;
    }

    private static void appendClause(StringBuilder r1, String r2, String r3) {
        if (isEmpty(r3) == true) goto L6;
        r1.append(r2);
        r1.append(r3);
        return;
    }

    private static void appendColumns(StringBuilder r4, String[] r5) {
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        String r2 = r5[r1];
        if (r1 <= 0) goto L7;
        r4.append(", ");
    L7:
        r4.append(r2);
        r1 = r1 + 1;
        goto L3
    L8:
        r4.append(' ');
    }

    public static SupportSQLiteQueryBuilder builder(String r1) {
        return new SupportSQLiteQueryBuilder(r1);
    }

    private static boolean isEmpty(String r0) {
        if (r0 != null) goto L4;
    L7:
        return true;
    L4:
        if (r0.length() == 0) goto L7;
        return false;
    }

    public SupportSQLiteQueryBuilder columns(String[] r1) {
        this.mColumns = r1;
        return this;
    }

    public SupportSQLiteQuery create() {
        if (isEmpty(this.mGroupBy) == true) goto L5;
    L9:
        StringBuilder r0 = new StringBuilder(120);
        r0.append("SELECT ");
        if (this.mDistinct == false) goto L12;
        r0.append("DISTINCT ");
    L12:
        String[] r1 = this.mColumns;
        if (r1 != null) goto L15;
    L17:
        r0.append(" * ");
    L18:
        r0.append(" FROM ");
        r0.append(this.mTable);
        appendClause(r0, " WHERE ", this.mSelection);
        appendClause(r0, " GROUP BY ", this.mGroupBy);
        appendClause(r0, " HAVING ", this.mHaving);
        appendClause(r0, " ORDER BY ", this.mOrderBy);
        appendClause(r0, " LIMIT ", this.mLimit);
        return new SimpleSQLiteQuery(r0.toString(), this.mBindArgs);
    L15:
        if (r1.length == 0) goto L17;
        appendColumns(r0, r1);
        goto L18
    L5:
        if (isEmpty(this.mHaving) == true) goto L9;
        throw new IllegalArgumentException("HAVING clauses are only permitted when using a groupBy clause");
    }

    public SupportSQLiteQueryBuilder distinct() {
        this.mDistinct = true;
        return this;
    }

    public SupportSQLiteQueryBuilder groupBy(String r1) {
        this.mGroupBy = r1;
        return this;
    }

    public SupportSQLiteQueryBuilder having(String r1) {
        this.mHaving = r1;
        return this;
    }

    public SupportSQLiteQueryBuilder limit(String r3) {
        if (isEmpty(r3) == false) goto L5;
    L9:
        this.mLimit = r3;
        return this;
    L5:
        if (sLimitPattern.matcher(r3).matches() == true) goto L9;
        throw new IllegalArgumentException("invalid LIMIT clauses:" + r3);
    }

    public SupportSQLiteQueryBuilder orderBy(String r1) {
        this.mOrderBy = r1;
        return this;
    }

    public SupportSQLiteQueryBuilder selection(String r1, Object[] r2) {
        this.mSelection = r1;
        this.mBindArgs = r2;
        return this;
    }
}
