package androidx.constraintlayout.core.widgets;

/* JADX INFO: loaded from: classes.dex */
public class Rectangle {
    public int height;
    public int width;
    public int x;
    public int y;

    public Rectangle() {
    }

    public boolean contains(int r3, int r4) {
        int r0 = this.x;
        if (r3 >= r0) goto L5;
    L11:
        return false;
    L5:
        if (r3 >= (r0 + this.width)) goto L11;
        int r5 = this.y;
        if (r4 < r5) goto L11;
        if (r4 >= (r5 + this.height)) goto L11;
        return true;
    }

    public int getCenterX() {
        return (this.x + this.width) / 2;
    }

    public int getCenterY() {
        return (this.y + this.height) / 2;
    }

    void grow(int r2, int r3) {
        this.x -= r2;
        this.y -= r3;
        this.width += r2 * 2;
        this.height += r3 * 2;
    }

    boolean intersects(Rectangle r4) {
        int r0 = this.x;
        int r1 = r4.x;
        if (r0 >= r1) goto L5;
    L11:
        return false;
    L5:
        if (r0 >= (r1 + r4.width)) goto L11;
        int r3 = this.y;
        int r2 = r4.y;
        if (r3 < r2) goto L11;
        if (r3 >= (r2 + r4.height)) goto L11;
        return true;
    }

    public void setBounds(int r1, int r2, int r3, int r4) {
        this.x = r1;
        this.y = r2;
        this.width = r3;
        this.height = r4;
    }
}
