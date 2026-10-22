package androidx.constraintlayout.core;

import java.util.Arrays;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public class SolverVariable implements Comparable<SolverVariable> {
    private static final boolean INTERNAL_DEBUG = false;
    static final int MAX_STRENGTH = 9;
    public static final int STRENGTH_BARRIER = 6;
    public static final int STRENGTH_CENTERING = 7;
    public static final int STRENGTH_EQUALITY = 5;
    public static final int STRENGTH_FIXED = 8;
    public static final int STRENGTH_HIGH = 3;
    public static final int STRENGTH_HIGHEST = 4;
    public static final int STRENGTH_LOW = 1;
    public static final int STRENGTH_MEDIUM = 2;
    public static final int STRENGTH_NONE = 0;
    private static final boolean VAR_USE_HASH = false;
    private static int uniqueConstantId = 1;
    private static int uniqueErrorId = 1;
    private static int uniqueId = 1;
    private static int uniqueSlackId = 1;
    private static int uniqueUnrestrictedId = 1;
    public float computedValue;
    int definitionId;
    float[] goalStrengthVector;
    public int id;
    public boolean inGoal;
    HashSet<ArrayRow> inRows;
    public boolean isFinalValue;
    boolean isSynonym;
    ArrayRow[] mClientEquations;
    int mClientEquationsCount;
    private String mName;
    Type mType;
    public int strength;
    float[] strengthVector;
    int synonym;
    float synonymDelta;
    public int usageInRowCount;

    /* JADX INFO: renamed from: androidx.constraintlayout.core.SolverVariable$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$core$SolverVariable$Type = null;

        static {
            int[] r0 = new int[Type.values().length];
            $SwitchMap$androidx$constraintlayout$core$SolverVariable$Type = r0;
            r0[Type.UNRESTRICTED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$androidx$constraintlayout$core$SolverVariable$Type[Type.CONSTANT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$androidx$constraintlayout$core$SolverVariable$Type[Type.SLACK.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            $SwitchMap$androidx$constraintlayout$core$SolverVariable$Type[Type.ERROR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            $SwitchMap$androidx$constraintlayout$core$SolverVariable$Type[Type.UNKNOWN.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public static final enum Type extends Enum<Type> {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final Type CONSTANT = null;
        public static final Type ERROR = null;
        public static final Type SLACK = null;
        public static final Type UNKNOWN = null;
        public static final Type UNRESTRICTED = null;

        static {
            Type r0 = new Type("UNRESTRICTED", 0);
            UNRESTRICTED = r0;
            Type r1 = new Type("CONSTANT", 1);
            CONSTANT = r1;
            Type r3 = new Type("SLACK", 2);
            SLACK = r3;
            Type r5 = new Type("ERROR", 3);
            ERROR = r5;
            Type r7 = new Type("UNKNOWN", 4);
            UNKNOWN = r7;
            $VALUES = new Type[]{r0, r1, r3, r5, r7};
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

    static {
    }

    public SolverVariable(Type r4, String r5) {
        this.id = -1;
        this.definitionId = -1;
        this.strength = 0;
        this.isFinalValue = false;
        this.strengthVector = new float[9];
        this.goalStrengthVector = new float[9];
        this.mClientEquations = new ArrayRow[16];
        this.mClientEquationsCount = 0;
        this.usageInRowCount = 0;
        this.isSynonym = false;
        this.synonym = -1;
        this.synonymDelta = 0.0f;
        this.inRows = null;
        this.mType = r4;
    }

    public SolverVariable(String r5, Type r6) {
        this.id = -1;
        this.definitionId = -1;
        this.strength = 0;
        this.isFinalValue = false;
        this.strengthVector = new float[9];
        this.goalStrengthVector = new float[9];
        this.mClientEquations = new ArrayRow[16];
        this.mClientEquationsCount = 0;
        this.usageInRowCount = 0;
        this.isSynonym = false;
        this.synonym = -1;
        this.synonymDelta = 0.0f;
        this.inRows = null;
        this.mName = r5;
        this.mType = r6;
    }

    private static String getUniqueName(Type r2, String r3) {
        if (r3 == null) goto L6;
        StringBuilder r4 = new StringBuilder();
        r4.append(r3);
        int r5 = uniqueErrorId;
    L4:
        r4.append(r5);
        return r4.toString();
    L6:
        int r6 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$SolverVariable$Type[r2.ordinal()];
        if (r6 != 1) goto L9;
        r4 = new StringBuilder();
        r4.append("U");
        r5 = uniqueUnrestrictedId + 1;
        uniqueUnrestrictedId = r5;
        goto L4
    L9:
        if (r6 != 2) goto L11;
        r4 = new StringBuilder();
        r4.append("C");
        r5 = uniqueConstantId + 1;
        uniqueConstantId = r5;
        goto L4
    L11:
        if (r6 != 3) goto L13;
        r4 = new StringBuilder();
        r4.append("S");
        r5 = uniqueSlackId + 1;
        uniqueSlackId = r5;
        goto L4
    L13:
        if (r6 != 4) goto L15;
        r4 = new StringBuilder();
        r4.append("e");
        r5 = uniqueErrorId + 1;
        uniqueErrorId = r5;
        goto L4
    L15:
        if (r6 != 5) goto L18;
        r4 = new StringBuilder();
        r4.append("V");
        r5 = uniqueId + 1;
        uniqueId = r5;
        goto L4
    L18:
        throw new AssertionError(r2.name());
    }

    static void increaseErrorId() {
        uniqueErrorId++;
    }

    public final void addToRow(ArrayRow r4) {
        int r0 = 0;
    L3:
        int r1 = this.mClientEquationsCount;
        if (r0 >= r1) goto L9;
        if (this.mClientEquations[r0] == r4) goto L7;
        r0 = r0 + 1;
        goto L3
    L7:
        return;
    L9:
        ArrayRow[] r2 = this.mClientEquations;
        if (r1 < r2.length) goto L12;
        this.mClientEquations = (ArrayRow[]) Arrays.copyOf(r2, r2.length * 2);
    L12:
        ArrayRow[] r3 = this.mClientEquations;
        int r5 = this.mClientEquationsCount;
        r3[r5] = r4;
        this.mClientEquationsCount = r5 + 1;
    }

    void clearStrengths() {
        int r0 = 0;
    L4:
        if (r0 >= 9) goto L6;
        this.strengthVector[r0] = 0.0f;
        r0 = r0 + 1;
        goto L4
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(SolverVariable r1) {
        return this.id - r1.id;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(SolverVariable r1) {
        return compareTo2(r1);
    }

    public String getName() {
        return this.mName;
    }

    public final void removeFromRow(ArrayRow r5) {
        int r0 = this.mClientEquationsCount;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L12;
        if (this.mClientEquations[r1] == r5) goto L7;
        r1 = r1 + 1;
    L7:
        if (r1 >= (r0 - 1)) goto L9;
        ArrayRow[] r6 = this.mClientEquations;
        int r2 = r1 + 1;
        r6[r1] = r6[r2];
        r1 = r2;
        goto L7
    L9:
        this.mClientEquationsCount--;
        return;
    }

    public void reset() {
        this.mName = null;
        this.mType = Type.UNKNOWN;
        this.strength = 0;
        this.id = -1;
        this.definitionId = -1;
        this.computedValue = 0.0f;
        this.isFinalValue = false;
        this.isSynonym = false;
        this.synonym = -1;
        this.synonymDelta = 0.0f;
        int r2 = this.mClientEquationsCount;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L5;
        this.mClientEquations[r4] = null;
        r4 = r4 + 1;
        goto L3
    L5:
        this.mClientEquationsCount = 0;
        this.usageInRowCount = 0;
        this.inGoal = false;
        Arrays.fill(this.goalStrengthVector, 0.0f);
    }

    public void setFinalValue(LinearSystem r4, float r5) {
        this.computedValue = r5;
        this.isFinalValue = true;
        this.isSynonym = false;
        this.synonym = -1;
        this.synonymDelta = 0.0f;
        int r1 = this.mClientEquationsCount;
        this.definitionId = -1;
        int r0 = 0;
    L3:
        if (r0 >= r1) goto L5;
        this.mClientEquations[r0].updateFromFinalVariable(r4, this, false);
        r0 = r0 + 1;
        goto L3
    L5:
        this.mClientEquationsCount = 0;
    }

    public void setName(String r1) {
        this.mName = r1;
    }

    public void setSynonym(LinearSystem r3, SolverVariable r4, float r5) {
        this.isSynonym = true;
        this.synonym = r4.id;
        this.synonymDelta = r5;
        int r6 = this.mClientEquationsCount;
        this.definitionId = -1;
        int r0 = 0;
    L3:
        if (r0 >= r6) goto L5;
        this.mClientEquations[r0].updateFromSynonymVariable(r3, this, false);
        r0 = r0 + 1;
        goto L3
    L5:
        this.mClientEquationsCount = 0;
        r3.displayReadableRows();
    }

    public void setType(Type r1, String r2) {
        this.mType = r1;
    }

    String strengthsToString() {
        String r0 = this + "[";
        boolean r5 = true;
        int r3 = 0;
        boolean r4 = false;
    L4:
        if (r3 >= this.strengthVector.length) goto L19;
        String r1 = r0 + this.strengthVector[r3];
        float[] r6 = this.strengthVector;
        if (r6[r3] <= 0.0f) goto L9;
        r4 = false;
    L12:
        if (r6[r3] == 0.0f) goto L15;
        r5 = false;
    L15:
        if (r3 >= (r6.length - 1)) goto L17;
        StringBuilder r7 = new StringBuilder();
        r7.append(r1);
        String r2 = ", ";
    L18:
        r7.append(r2);
        r0 = r7.toString();
        r3 = r3 + 1;
        goto L4
    L17:
        r7 = new StringBuilder();
        r7.append(r1);
        r2 = "] ";
        goto L18
    L9:
        if (r6[r3] >= 0.0f) goto L12;
        r4 = true;
        goto L12
    L19:
        if (r4 == false) goto L21;
        r0 = r0 + " (-)";
    L21:
        if (r5 == true) goto L23;
        return r0;
    L23:
        return r0 + " (*)";
    }

    public String toString() {
        if (this.mName == null) goto L5;
        StringBuilder r0 = new StringBuilder();
        r0.append("");
        r0.append(this.mName);
    L7:
        return r0.toString();
    L5:
        r0 = new StringBuilder();
        r0.append("");
        r0.append(this.id);
        goto L7
    }

    public final void updateReferencesWithNewDefinition(LinearSystem r5, ArrayRow r6) {
        int r0 = this.mClientEquationsCount;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        this.mClientEquations[r2].updateFromRow(r5, r6, false);
        r2 = r2 + 1;
        goto L3
    L5:
        this.mClientEquationsCount = 0;
    }
}
