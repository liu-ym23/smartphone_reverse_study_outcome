package androidx.constraintlayout.core.parser;

import a.a;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class CLContainer extends CLElement {
    ArrayList<CLElement> mElements;

    public CLContainer(char[] r1) {
        super(r1);
        this.mElements = new ArrayList();
    }

    public static CLElement allocate(char[] r1) {
        return new CLContainer(r1);
    }

    public void add(CLElement r4) {
        this.mElements.add(r4);
        if (CLParser.DEBUG == false) goto L6;
        System.out.println("added element " + r4 + " to " + this);
        return;
    }

    public CLElement get(String r4) {
        Iterator<CLElement> r0 = this.mElements.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        CLKey r1 = (CLKey) r0.next();
        if (r1.content().equals(r4) == false) goto L4;
        return r1.getValue();
    L10:
        throw new CLParsingException(a.k("no element for key <", r4, ">"), this);
    }

    public CLArray getArray(String r5) {
        CLElement r0 = get(r5);
        if ((r0 instanceof CLArray) == true) goto L5;
        StringBuilder r6 = a.u("no array found for key <", r5, ">, found [");
        r6.append(r0.getStrClass());
        r6.append("] : ");
        r6.append(r0);
        throw new CLParsingException(r6.toString(), this);
    L5:
        return (CLArray) r0;
    }

    public CLArray getArrayOrNull(String r1) {
        CLElement r0 = getOrNull(r1);
        if ((r0 instanceof CLArray) == true) goto L5;
        return null;
    L5:
        return (CLArray) r0;
    }

    public boolean getBoolean(String r5) {
        CLElement r0 = get(r5);
        if ((r0 instanceof CLToken) == true) goto L5;
        StringBuilder r6 = a.u("no boolean found for key <", r5, ">, found [");
        r6.append(r0.getStrClass());
        r6.append("] : ");
        r6.append(r0);
        throw new CLParsingException(r6.toString(), this);
    L5:
        return ((CLToken) r0).getBoolean();
    }

    public float getFloat(String r5) {
        CLElement r0 = get(r5);
        if (r0 != null) goto L5;
        StringBuilder r6 = a.u("no float found for key <", r5, ">, found [");
        r6.append(r0.getStrClass());
        r6.append("] : ");
        r6.append(r0);
        throw new CLParsingException(r6.toString(), this);
    L5:
        return r0.getFloat();
    }

    public float getFloatOrNaN(String r1) {
        CLElement r0 = getOrNull(r1);
        if ((r0 instanceof CLNumber) == true) goto L5;
        return Float.NaN;
    L5:
        return r0.getFloat();
    }

    public int getInt(String r5) {
        CLElement r0 = get(r5);
        if (r0 != null) goto L5;
        StringBuilder r6 = a.u("no int found for key <", r5, ">, found [");
        r6.append(r0.getStrClass());
        r6.append("] : ");
        r6.append(r0);
        throw new CLParsingException(r6.toString(), this);
    L5:
        return r0.getInt();
    }

    public CLObject getObject(String r5) {
        CLElement r0 = get(r5);
        if ((r0 instanceof CLObject) == true) goto L5;
        StringBuilder r6 = a.u("no object found for key <", r5, ">, found [");
        r6.append(r0.getStrClass());
        r6.append("] : ");
        r6.append(r0);
        throw new CLParsingException(r6.toString(), this);
    L5:
        return (CLObject) r0;
    }

    public CLObject getObjectOrNull(String r1) {
        CLElement r0 = getOrNull(r1);
        if ((r0 instanceof CLObject) == true) goto L5;
        return null;
    L5:
        return (CLObject) r0;
    }

    public CLElement getOrNull(String r3) {
        Iterator<CLElement> r2 = this.mElements.iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        CLKey r0 = (CLKey) r2.next();
        if (r0.content().equals(r3) == false) goto L4;
        return r0.getValue();
    L9:
        return null;
    }

    public String getString(String r6) {
        CLElement r0 = get(r6);
        if ((r0 instanceof CLString) == true) goto L5;
        if (r0 == null) goto L8;
        String r1 = r0.getStrClass();
    L10:
        throw new CLParsingException("no string found for key <" + r6 + ">, found [" + r1 + "] : " + r0, this);
    L8:
        r1 = null;
        goto L10
    L5:
        return r0.content();
    }

    public String getStringOrNull(String r1) {
        CLElement r0 = getOrNull(r1);
        if ((r0 instanceof CLString) == true) goto L5;
        return null;
    L5:
        return r0.content();
    }

    public boolean has(String r3) {
        Iterator<CLElement> r2 = this.mElements.iterator();
    L4:
        if (r2.hasNext() == false) goto L11;
        CLElement r0 = r2.next();
        if ((r0 instanceof CLKey) == false) goto L4;
        if (((CLKey) r0).content().equals(r3) == false) goto L4;
        return true;
    L11:
        return false;
    }

    public ArrayList<String> names() {
        ArrayList<String> r0 = new ArrayList();
        Iterator<CLElement> r3 = this.mElements.iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        CLElement r1 = r3.next();
        if ((r1 instanceof CLKey) == false) goto L4;
        r0.add(((CLKey) r1).content());
        goto L4
    L8:
        return r0;
    }

    public void put(String r4, CLElement r5) {
        Iterator<CLElement> r0 = this.mElements.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        CLKey r1 = (CLKey) r0.next();
        if (r1.content().equals(r4) == false) goto L4;
        r1.set(r5);
        return;
    L9:
        CLKey r6 = (CLKey) CLKey.allocate(r4, r5);
        this.mElements.add(r6);
    }

    public void putNumber(String r2, float r3) {
        put(r2, new CLNumber(r3));
    }

    public void remove(String r5) {
        ArrayList r0 = new ArrayList();
        Iterator<CLElement> r1 = this.mElements.iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        CLElement r2 = r1.next();
        if (((CLKey) r2).content().equals(r5) == false) goto L4;
        r0.add(r2);
        goto L4
    L8:
        Iterator r6 = r0.iterator();
    L10:
        if (r6.hasNext() == false) goto L12;
        CLElement r3 = (CLElement) r6.next();
        this.mElements.remove(r3);
        goto L10
    }

    public int size() {
        return this.mElements.size();
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        Iterator<CLElement> r1 = this.mElements.iterator();
    L4:
        if (r1.hasNext() == false) goto L10;
        CLElement r2 = r1.next();
        if (r0.length() <= 0) goto L8;
        r0.append("; ");
    L8:
        r0.append(r2);
        goto L4
    L10:
        return super.toString() + " = <" + r0 + " >";
    }

    public String getStringOrNull(int r1) {
        CLElement r0 = getOrNull(r1);
        if ((r0 instanceof CLString) == true) goto L5;
        return null;
    L5:
        return r0.content();
    }

    public CLElement getOrNull(int r2) {
        if (r2 >= 0) goto L4;
        return null;
    L4:
        if (r2 < this.mElements.size()) goto L6;
        return null;
    L6:
        return this.mElements.get(r2);
    }

    public String getString(int r3) {
        CLElement r0 = get(r3);
        if ((r0 instanceof CLString) == false) goto L7;
        return r0.content();
    L7:
        throw new CLParsingException(a.e(r3, "no string at index "), this);
    }

    public float getFloat(int r3) {
        CLElement r0 = get(r3);
        if (r0 == null) goto L7;
        return r0.getFloat();
    L7:
        throw new CLParsingException(a.e(r3, "no float at index "), this);
    }

    public int getInt(int r3) {
        CLElement r0 = get(r3);
        if (r0 == null) goto L7;
        return r0.getInt();
    L7:
        throw new CLParsingException(a.e(r3, "no int at index "), this);
    }

    public CLArray getArray(int r3) {
        CLElement r0 = get(r3);
        if ((r0 instanceof CLArray) == false) goto L7;
        return (CLArray) r0;
    L7:
        throw new CLParsingException(a.e(r3, "no array at index "), this);
    }

    public boolean getBoolean(int r3) {
        CLElement r0 = get(r3);
        if ((r0 instanceof CLToken) == false) goto L7;
        return ((CLToken) r0).getBoolean();
    L7:
        throw new CLParsingException(a.e(r3, "no boolean at index "), this);
    }

    public CLObject getObject(int r3) {
        CLElement r0 = get(r3);
        if ((r0 instanceof CLObject) == false) goto L7;
        return (CLObject) r0;
    L7:
        throw new CLParsingException(a.e(r3, "no object at index "), this);
    }

    public CLElement get(int r3) {
        if (r3 < 0) goto L8;
        if (r3 >= this.mElements.size()) goto L8;
        return this.mElements.get(r3);
    L8:
        throw new CLParsingException(a.e(r3, "no element at index "), this);
    }
}
