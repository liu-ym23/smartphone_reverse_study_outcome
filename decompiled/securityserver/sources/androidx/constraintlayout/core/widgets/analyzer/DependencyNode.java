package androidx.constraintlayout.core.widgets.analyzer;

import a.a;
import com.bytedance.networkstackapplib.NetworkStackConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DependencyNode implements Dependency {
    public boolean delegateToWidgetRun;
    List<Dependency> dependencies;
    int margin;
    DimensionDependency marginDependency;
    int marginFactor;
    public boolean readyToSolve;
    public boolean resolved;
    WidgetRun run;
    List<DependencyNode> targets;
    Type type;
    public Dependency updateDelegate;
    public int value;

    public static final enum Type extends Enum<Type> {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final Type BASELINE = null;
        public static final Type BOTTOM = null;
        public static final Type HORIZONTAL_DIMENSION = null;
        public static final Type LEFT = null;
        public static final Type RIGHT = null;
        public static final Type TOP = null;
        public static final Type UNKNOWN = null;
        public static final Type VERTICAL_DIMENSION = null;

        static {
            Type r0 = new Type(NetworkStackConstant.UNKNOWN_TYPE, 0);
            UNKNOWN = r0;
            Type r1 = new Type("HORIZONTAL_DIMENSION", 1);
            HORIZONTAL_DIMENSION = r1;
            Type r2 = new Type("VERTICAL_DIMENSION", 2);
            VERTICAL_DIMENSION = r2;
            Type r3 = new Type("LEFT", 3);
            LEFT = r3;
            Type r4 = new Type("RIGHT", 4);
            RIGHT = r4;
            Type r5 = new Type("TOP", 5);
            TOP = r5;
            Type r6 = new Type("BOTTOM", 6);
            BOTTOM = r6;
            Type r7 = new Type("BASELINE", 7);
            BASELINE = r7;
            $VALUES = new Type[]{r0, r1, r2, r3, r4, r5, r6, r7};
        }

        private Type(String r1, int r2) {
            super(r1, r2);
        }

        public static Type valueOf(String r1) {
            return (Type) Enum.valueOf(Type.class, r1);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }
    }

    public DependencyNode(WidgetRun r4) {
        this.updateDelegate = null;
        this.delegateToWidgetRun = false;
        this.readyToSolve = false;
        this.type = Type.UNKNOWN;
        this.marginFactor = 1;
        this.marginDependency = null;
        this.resolved = false;
        this.dependencies = new ArrayList();
        this.targets = new ArrayList();
        this.run = r4;
    }

    public void addDependency(Dependency r2) {
        this.dependencies.add(r2);
        if (this.resolved == false) goto L6;
        r2.update(r2);
        return;
    }

    public void clear() {
        this.targets.clear();
        this.dependencies.clear();
        this.resolved = false;
        this.value = 0;
        this.readyToSolve = false;
        this.delegateToWidgetRun = false;
    }

    public String name() {
        String r0 = this.run.widget.getDebugName();
        Type r1 = this.type;
        if (r1 != Type.LEFT) goto L5;
    L8:
        String r2 = a.j(r0, "_HORIZONTAL");
    L9:
        StringBuilder r3 = a.t(r2, ":");
        r3.append(this.type.name());
        return r3.toString();
    L5:
        if (r1 == Type.RIGHT) goto L8;
        r2 = a.j(r0, "_VERTICAL");
        goto L9
    }

    public void resolve(int r2) {
        if (this.resolved == false) goto L5;
        return;
    L5:
        this.resolved = true;
        this.value = r2;
        Iterator<Dependency> r1 = this.dependencies.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        Dependency r3 = r1.next();
        r3.update(r3);
        goto L7
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append(this.run.widget.getDebugName());
        r0.append(":");
        r0.append(this.type);
        r0.append("(");
        if (this.resolved == false) goto L5;
        Object r1 = Integer.valueOf(this.value);
    L6:
        r0.append(r1);
        r0.append(") <t=");
        r0.append(this.targets.size());
        r0.append(":d=");
        r0.append(this.dependencies.size());
        r0.append(">");
        return r0.toString();
    L5:
        r1 = "unresolved";
        goto L6
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.Dependency
    public void update(Dependency r6) {
        Iterator<DependencyNode> r7 = this.targets.iterator();
    L4:
        if (r7.hasNext() == false) goto L8;
        if (r7.next().resolved == true) goto L4;
        return;
    L8:
        this.readyToSolve = true;
        Dependency r0 = this.updateDelegate;
        if (r0 == null) goto L12;
        r0.update(this);
    L12:
        if (this.delegateToWidgetRun == false) goto L15;
        this.run.update(this);
        return;
    L15:
        Iterator<DependencyNode> r1 = this.targets.iterator();
        DependencyNode r2 = null;
        int r3 = 0;
    L17:
        if (r1.hasNext() == false) goto L22;
        DependencyNode r4 = r1.next();
        if ((r4 instanceof DimensionDependency) == true) goto L17;
        r3 = r3 + 1;
        r2 = r4;
        goto L17
    L22:
        if (r2 == null) goto L33;
        if (r3 != 1) goto L33;
        if (r2.resolved == false) goto L33;
        DimensionDependency r8 = this.marginDependency;
        if (r8 != null) goto L29;
    L32:
        resolve(r2.value + this.margin);
        goto L33
    L29:
        if (r8.resolved == false) goto L31;
        this.margin = this.marginFactor * r8.value;
        goto L32
    L31:
        return;
    L33:
        Dependency r9 = this.updateDelegate;
        if (r9 == null) goto L45;
        r9.update(this);
        return;
    }
}
