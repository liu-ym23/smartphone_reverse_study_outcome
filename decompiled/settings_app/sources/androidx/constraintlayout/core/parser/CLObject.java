package androidx.constraintlayout.core.parser;

import java.util.Iterator;
import org.apache.commons.math3.geometry.VectorFormat;

/* JADX INFO: loaded from: classes.dex */
public class CLObject extends CLContainer implements Iterable<CLKey> {

    private class CLObjectIterator implements Iterator {
        int index;
        CLObject myObject;
        final /* synthetic */ CLObject this$0;

        public CLObjectIterator(CLObject r1, CLObject r2) {
            this.this$0 = r1;
            this.index = 0;
            this.myObject = r2;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.index >= this.myObject.size()) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        public Object next() {
            CLKey r0 = (CLKey) this.myObject.mElements.get(this.index);
            this.index++;
            return r0;
        }
    }

    public CLObject(char[] r1) {
        super(r1);
    }

    public static CLObject allocate(char[] r1) {
        return new CLObject(r1);
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toJSON() {
        StringBuilder r0 = new StringBuilder(getDebugName() + "{ ");
        Iterator<CLElement> r4 = this.mElements.iterator();
        boolean r1 = true;
    L4:
        if (r4.hasNext() == false) goto L10;
        CLElement r2 = r4.next();
        if (r1 == true) goto L8;
        r0.append(", ");
    L9:
        r0.append(r2.toJSON());
        goto L4
    L8:
        r1 = false;
        goto L9
    L10:
        r0.append(" }");
        return r0.toString();
    }

    public String toFormattedJSON() {
        return toFormattedJSON(0, 0);
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toFormattedJSON(int r8, int r9) {
        StringBuilder r0 = new StringBuilder(getDebugName());
        r0.append("{\n");
        Iterator<CLElement> r1 = this.mElements.iterator();
        boolean r3 = true;
    L4:
        if (r1.hasNext() == false) goto L10;
        CLElement r4 = r1.next();
        if (r3 == true) goto L8;
        r0.append(",\n");
    L9:
        r0.append(r4.toFormattedJSON(BASE_INDENT + r8, r9 - 1));
        goto L4
    L8:
        r3 = false;
        goto L9
    L10:
        r0.append("\n");
        addIndent(r0, r8);
        r0.append(VectorFormat.DEFAULT_SUFFIX);
        return r0.toString();
    }

    @Override // java.lang.Iterable
    public Iterator<CLKey> iterator() {
        return new CLObjectIterator(this, this);
    }
}
