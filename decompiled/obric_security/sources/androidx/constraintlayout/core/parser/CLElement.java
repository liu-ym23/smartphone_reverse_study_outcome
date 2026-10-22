package androidx.constraintlayout.core.parser;

/* JADX INFO: loaded from: classes.dex */
public class CLElement {
    protected static int BASE_INDENT = 2;
    protected static int MAX_LINE = 80;
    protected long end;
    private int line;
    protected CLContainer mContainer;
    private final char[] mContent;
    protected long start;

    static {
    }

    protected String toFormattedJSON(int r1, int r2) {
        return "";
    }

    protected String toJSON() {
        return "";
    }

    public CLElement(char[] r3) {
        this.start = -1;
        this.end = Long.MAX_VALUE;
        this.mContent = r3;
    }

    public boolean notStarted() {
        if (this.start != (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public void setLine(int r1) {
        this.line = r1;
    }

    public int getLine() {
        return this.line;
    }

    public void setStart(long r1) {
        this.start = r1;
    }

    public long getStart() {
        return this.start;
    }

    public long getEnd() {
        return this.end;
    }

    public void setEnd(long r5) {
        if (this.end == Long.MAX_VALUE) goto L5;
        return;
    L5:
        this.end = r5;
        if (CLParser.DEBUG == false) goto L8;
        System.out.println("closing " + hashCode() + " -> " + this);
    L8:
        CLContainer r6 = this.mContainer;
        if (r6 == null) goto L12;
        r6.add(this);
        return;
    }

    protected void addIndent(StringBuilder r2, int r3) {
        int r1 = 0;
    L3:
        if (r1 >= r3) goto L5;
        r2.append(' ');
        r1 = r1 + 1;
        goto L3
    }

    public String toString() {
        long r0 = this.start;
        long r2 = this.end;
        if (r0 > r2) goto L10;
        if (r2 == Long.MAX_VALUE) goto L10;
        return getStrClass() + " (" + this.start + " : " + this.end + ") <<" + new String(this.mContent).substring((int) this.start, ((int) this.end) + 1) + ">>";
    L10:
        return getClass() + " (INVALID, " + this.start + "-" + this.end + ")";
    }

    protected String getStrClass() {
        String r1 = getClass().toString();
        return r1.substring(r1.lastIndexOf(46) + 1);
    }

    protected String getDebugName() {
        if (CLParser.DEBUG == true) goto L5;
        return "";
    L5:
        return getStrClass() + " -> ";
    }

    public String content() {
        String r0 = new String(this.mContent);
        long r1 = this.end;
        if (r1 == Long.MAX_VALUE) goto L9;
        long r3 = this.start;
        if (r1 < r3) goto L9;
        return r0.substring((int) r3, ((int) r1) + 1);
    L9:
        long r2 = this.start;
        return r0.substring((int) r2, ((int) r2) + 1);
    }

    public boolean isDone() {
        if (this.end == Long.MAX_VALUE) goto L5;
        return true;
    L5:
        return false;
    }

    public void setContainer(CLContainer r1) {
        this.mContainer = r1;
    }

    public CLElement getContainer() {
        return this.mContainer;
    }

    public boolean isStarted() {
        if (this.start <= (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public int getInt() {
        if ((this instanceof CLNumber) == true) goto L5;
        return 0;
    L5:
        return ((CLNumber) this).getInt();
    }

    public float getFloat() {
        if ((this instanceof CLNumber) == true) goto L5;
        return Float.NaN;
    L5:
        return ((CLNumber) this).getFloat();
    }
}
