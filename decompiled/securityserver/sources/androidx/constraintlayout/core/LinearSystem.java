package androidx.constraintlayout.core;

import a.a;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import com.bytedance.librarian.LibrarianImpl;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class LinearSystem {
    public static long ARRAY_ROW_CREATION = 0;
    public static final boolean DEBUG = false;
    private static final boolean DEBUG_CONSTRAINTS = false;
    public static final boolean FULL_DEBUG = false;
    public static final boolean MEASURE = false;
    public static long OPTIMIZED_ARRAY_ROW_CREATION = 0;
    public static boolean OPTIMIZED_ENGINE = false;
    private static int POOL_SIZE = 1000;
    public static boolean SIMPLIFY_SYNONYMS = true;
    public static boolean SKIP_COLUMNS = true;
    public static boolean USE_BASIC_SYNONYMS = true;
    public static boolean USE_DEPENDENCY_ORDERING = false;
    public static boolean USE_SYNONYMS = true;
    public static Metrics sMetrics;
    private int TABLE_SIZE;
    public boolean graphOptimizer;
    public boolean hasSimpleDefinition;
    private boolean[] mAlreadyTestedCandidates;
    final Cache mCache;
    private Row mGoal;
    private int mMaxColumns;
    private int mMaxRows;
    int mNumColumns;
    int mNumRows;
    private SolverVariable[] mPoolVariables;
    private int mPoolVariablesCount;
    ArrayRow[] mRows;
    private Row mTempGoal;
    private HashMap<String, SolverVariable> mVariables;
    int mVariablesID;
    public boolean newgraphOptimizer;

    public interface Row {
        void addError(SolverVariable r1);

        void clear();

        SolverVariable getKey();

        SolverVariable getPivotCandidate(LinearSystem r1, boolean[] r2);

        void initFromRow(Row r1);

        boolean isEmpty();

        void updateFromFinalVariable(LinearSystem r1, SolverVariable r2, boolean r3);

        void updateFromRow(LinearSystem r1, ArrayRow r2, boolean r3);

        void updateFromSystem(LinearSystem r1);
    }

    public class ValuesRow extends ArrayRow {
        final /* synthetic */ LinearSystem this$0;

        public ValuesRow(LinearSystem r1, Cache r2) {
            this.this$0 = r1;
            this.variables = new SolverVariableValues(this, r2);
        }
    }

    public LinearSystem() {
        this.hasSimpleDefinition = false;
        this.mVariablesID = 0;
        this.mVariables = null;
        this.TABLE_SIZE = 32;
        this.mMaxColumns = 32;
        this.mRows = null;
        this.graphOptimizer = false;
        this.newgraphOptimizer = false;
        this.mAlreadyTestedCandidates = new boolean[32];
        this.mNumColumns = 1;
        this.mNumRows = 0;
        this.mMaxRows = 32;
        this.mPoolVariables = new SolverVariable[POOL_SIZE];
        this.mPoolVariablesCount = 0;
        this.mRows = new ArrayRow[32];
        releaseRows();
        Cache r0 = new Cache();
        this.mCache = r0;
        this.mGoal = new PriorityGoalRow(r0);
        if (OPTIMIZED_ENGINE == false) goto L5;
        this.mTempGoal = new ValuesRow(this, r0);
        return;
    L5:
        this.mTempGoal = new ArrayRow(r0);
    }

    private SolverVariable acquireSolverVariable(SolverVariable.Type r3, String r4) {
        SolverVariable r0 = this.mCache.solverVariablePool.acquire();
        if (r0 != null) goto L5;
        r0 = new SolverVariable(r3, r4);
        r0.setType(r3, r4);
    L6:
        int r5 = this.mPoolVariablesCount;
        int r6 = POOL_SIZE;
        if (r5 < r6) goto L9;
        int r7 = r6 * 2;
        POOL_SIZE = r7;
        this.mPoolVariables = (SolverVariable[]) Arrays.copyOf(this.mPoolVariables, r7);
    L9:
        SolverVariable[] r8 = this.mPoolVariables;
        int r9 = this.mPoolVariablesCount;
        this.mPoolVariablesCount = r9 + 1;
        r8[r9] = r0;
        return r0;
    L5:
        r0.reset();
        r0.setType(r3, r4);
        goto L6
    }

    private void addError(ArrayRow r2) {
        r2.addError(this, 0);
    }

    private final void addRow(ArrayRow r8) {
        if (SIMPLIFY_SYNONYMS == true) goto L5;
    L7:
        ArrayRow[] r0 = this.mRows;
        int r1 = this.mNumRows;
        r0[r1] = r8;
        SolverVariable r2 = r8.variable;
        r2.definitionId = r1;
        this.mNumRows = r1 + 1;
        r2.updateReferencesWithNewDefinition(this, r8);
    L9:
        if (SIMPLIFY_SYNONYMS == true) goto L11;
        return;
    L11:
        if (this.hasSimpleDefinition == false) goto L47;
        int r3 = 0;
    L14:
        if (r3 >= this.mNumRows) goto L37;
        if (this.mRows[r3] != null) goto L18;
        System.out.println("WTF");
    L18:
        ArrayRow r4 = this.mRows[r3];
        if (r4 == null) goto L36;
        if (r4.isSimpleDefinition == false) goto L36;
        r4.variable.setFinalValue(this, r4.constantValue);
        if (OPTIMIZED_ENGINE == false) goto L25;
        this.mCache.optimizedArrayRowPool.release(r4);
    L26:
        this.mRows[r3] = null;
        int r5 = r3 + 1;
        int r6 = r5;
    L27:
        int r7 = this.mNumRows;
        if (r5 >= r7) goto L33;
        ArrayRow[] r9 = this.mRows;
        int r10 = r5 - 1;
        ArrayRow r11 = r9[r5];
        r9[r10] = r11;
        SolverVariable r12 = r11.variable;
        if (r12.definitionId != r5) goto L32;
        r12.definitionId = r10;
    L32:
        r6 = r5;
        r5 = r5 + 1;
        goto L27
    L33:
        if (r6 >= r7) goto L35;
        this.mRows[r6] = null;
    L35:
        this.mNumRows = r7 - 1;
        r3 = r3 - 1;
        goto L36
    L25:
        this.mCache.arrayRowPool.release(r4);
    L36:
        r3 = r3 + 1;
        goto L14
    L37:
        this.hasSimpleDefinition = false;
        return;
    L47:
        return;
    L5:
        if (r8.isSimpleDefinition == false) goto L7;
        r8.variable.setFinalValue(this, r8.constantValue);
        goto L9
    }

    private void addSingleError(ArrayRow r2, int r3) {
        addSingleError(r2, r3, 0);
    }

    private void computeValues() {
        int r0 = 0;
    L4:
        if (r0 >= this.mNumRows) goto L6;
        ArrayRow r1 = this.mRows[r0];
        SolverVariable r2 = r1.variable;
        r2.computedValue = r1.constantValue;
        r0 = r0 + 1;
        goto L4
    }

    public static ArrayRow createRowDimensionPercent(LinearSystem r0, SolverVariable r1, SolverVariable r2, float r3) {
        return r0.createRow().createRowDimensionPercent(r1, r2, r3);
    }

    private SolverVariable createVariable(String r6, SolverVariable.Type r7) {
        Metrics r0 = sMetrics;
        if (r0 == null) goto L6;
        r0.variables++;
    L6:
        if ((this.mNumColumns + 1) < this.mMaxColumns) goto L8;
        increaseTableSize();
    L8:
        SolverVariable r8 = acquireSolverVariable(r7, null);
        r8.setName(r6);
        int r1 = this.mVariablesID + 1;
        this.mVariablesID = r1;
        this.mNumColumns++;
        r8.id = r1;
        if (this.mVariables != null) goto L11;
        this.mVariables = new HashMap();
    L11:
        this.mVariables.put(r6, r8);
        this.mCache.mIndexedVariables[this.mVariablesID] = r8;
        return r8;
    }

    private void displayRows() {
        displaySolverVariables();
        String r0 = "";
        int r1 = 0;
    L4:
        if (r1 >= this.mNumRows) goto L6;
        StringBuilder r2 = a.q(r0);
        r2.append(this.mRows[r1]);
        r0 = a.j(r2.toString(), "\n");
        r1 = r1 + 1;
        goto L4
    L6:
        StringBuilder r3 = a.q(r0);
        r3.append(this.mGoal);
        r3.append("\n");
        String r4 = r3.toString();
        System.out.println(r4);
    }

    private void displaySolverVariables() {
        StringBuilder r0 = new StringBuilder("Display Rows (");
        r0.append(this.mNumRows);
        r0.append("x");
        String r2 = a.n(r0, ")\n", this.mNumColumns);
        System.out.println(r2);
    }

    private int enforceBFS(Row r20) {
        int r2 = 0;
    L4:
        if (r2 >= this.mNumRows) goto L69;
        ArrayRow r3 = this.mRows[r2];
        if (r3.variable.mType == SolverVariable.Type.UNRESTRICTED) goto L68;
        if (r3.constantValue >= 0.0f) goto L68;
        boolean r4 = false;
        int r5 = 0;
    L11:
        if (r4 == true) goto L94;
        Metrics r6 = sMetrics;
        if (r6 == null) goto L15;
        r6.bfs++;
    L15:
        r5 = r5 + 1;
        float r8 = Float.MAX_VALUE;
        int r9 = 0;
        int r10 = -1;
        int r11 = -1;
        int r12 = 0;
    L16:
        int r14 = 1;
        if (r9 >= this.mNumRows) goto L58;
        ArrayRow r13 = this.mRows[r9];
        if (r13.variable.mType == SolverVariable.Type.UNRESTRICTED) goto L56;
        if (r13.isSimpleDefinition == true) goto L56;
        if (r13.constantValue >= 0.0f) goto L56;
        int r15 = 9;
        if (SKIP_COLUMNS == false) goto L43;
        int r1 = r13.variables.getCurrentSize();
        int r16 = 0;
    L29:
        if (r16 >= r1) goto L56;
        SolverVariable r7 = r13.variables.getVariable(r16);
        float r17 = r13.variables.get(r7);
        if (r17 <= 0.0f) goto L41;
        int r18 = 0;
    L34:
        if (r18 >= r15) goto L41;
        float r19 = r7.strengthVector[r18] / r17;
        if (r19 >= r8) goto L38;
        if (r18 != r12) goto L38;
    L39:
        r12 = r18;
        r11 = r7.id;
        r10 = r9;
        r8 = r19;
    L40:
        r18 = r18 + 1;
        r15 = 9;
    L38:
        if (r18 <= r12) goto L40;
    L41:
        r16 = r16 + 1;
        r15 = 9;
    L43:
        if (r14 >= this.mNumColumns) goto L56;
        SolverVariable r21 = this.mCache.mIndexedVariables[r14];
        float r22 = r13.variables.get(r21);
        if (r22 <= 0.0f) goto L55;
        int r23 = 0;
    L48:
        if (r23 >= 9) goto L55;
        float r110 = r21.strengthVector[r23] / r22;
        if (r110 >= r8) goto L52;
        if (r23 != r12) goto L52;
    L53:
        r12 = r23;
        r10 = r9;
        r11 = r14;
        r8 = r110;
    L54:
        r23 = r23 + 1;
    L52:
        if (r23 <= r12) goto L54;
    L55:
        r14 = r14 + 1;
    L56:
        r9 = r9 + 1;
        goto L16
    L58:
        if (r10 == (-1)) goto L63;
        ArrayRow r24 = this.mRows[r10];
        r24.variable.definitionId = -1;
        Metrics r25 = sMetrics;
        if (r25 == null) goto L62;
        r25.pivots++;
    L62:
        r24.pivot(this.mCache.mIndexedVariables[r11]);
        SolverVariable r26 = r24.variable;
        r26.definitionId = r10;
        r26.updateReferencesWithNewDefinition(this, r24);
    L65:
        if (r5 <= (this.mNumColumns / 2)) goto L11;
        r4 = true;
        goto L11
    L63:
        r4 = true;
        goto L65
    L94:
        return r5;
    L68:
        r2 = r2 + 1;
        goto L4
    L69:
        return 0;
    }

    private String getDisplaySize(int r3) {
        int r4 = r3 * 4;
        int r2 = r4 / 1024;
        int r0 = r2 / 1024;
        if (r0 > 0) goto L5;
        if (r2 <= 0) goto L10;
        return a.f(r2, "", " Kb");
    L10:
        return a.f(r4, "", " bytes");
    L5:
        return a.f(r0, "", " Mb");
    }

    private String getDisplayStrength(int r1) {
        if (r1 != 1) goto L7;
        return "LOW";
    L7:
        if (r1 != 2) goto L11;
        return "MEDIUM";
    L11:
        if (r1 != 3) goto L15;
        return "HIGH";
    L15:
        if (r1 != 4) goto L19;
        return "HIGHEST";
    L19:
        if (r1 != 5) goto L23;
        return "EQUALITY";
    L23:
        if (r1 != 8) goto L27;
        return "FIXED";
    L27:
        if (r1 != 6) goto L30;
        return "BARRIER";
    L30:
        return "NONE";
    }

    public static Metrics getMetrics() {
        return sMetrics;
    }

    private void increaseTableSize() {
        int r0 = this.TABLE_SIZE * 2;
        this.TABLE_SIZE = r0;
        this.mRows = (ArrayRow[]) Arrays.copyOf(this.mRows, r0);
        Cache r1 = this.mCache;
        r1.mIndexedVariables = (SolverVariable[]) Arrays.copyOf(r1.mIndexedVariables, this.TABLE_SIZE);
        int r2 = this.TABLE_SIZE;
        this.mAlreadyTestedCandidates = new boolean[r2];
        this.mMaxColumns = r2;
        this.mMaxRows = r2;
        Metrics r5 = sMetrics;
        if (r5 == null) goto L6;
        r5.tableSizeIncrease++;
        r5.maxTableSize = Math.max(r5.maxTableSize, r2);
        Metrics r6 = sMetrics;
        r6.lastTableSize = r6.maxTableSize;
        return;
    }

    private final int optimize(Row r13, boolean r14) {
        Metrics r15 = sMetrics;
        if (r15 == null) goto L5;
        r15.optimize++;
    L5:
        int r2 = 0;
    L7:
        if (r2 >= this.mNumColumns) goto L9;
        this.mAlreadyTestedCandidates[r2] = false;
        r2 = r2 + 1;
        goto L7
    L9:
        boolean r3 = false;
        int r4 = 0;
    L10:
        if (r3 == true) goto L50;
        Metrics r5 = sMetrics;
        if (r5 == null) goto L14;
        r5.iterations++;
    L14:
        r4 = r4 + 1;
        if (r4 >= (this.mNumColumns * 2)) goto L16;
        if (r13.getKey() == null) goto L20;
        this.mAlreadyTestedCandidates[r13.getKey().id] = true;
    L20:
        SolverVariable r6 = r13.getPivotCandidate(this, this.mAlreadyTestedCandidates);
        if (r6 == null) goto L26;
        boolean[] r7 = this.mAlreadyTestedCandidates;
        int r8 = r6.id;
        if (r7[r8] == true) goto L24;
        r7[r8] = true;
        goto L26
    L24:
        return r4;
    L26:
        if (r6 != null) goto L27;
        r3 = true;
        goto L10
    L27:
        float r9 = Float.MAX_VALUE;
        int r10 = 0;
        int r11 = -1;
    L29:
        if (r10 >= this.mNumRows) goto L44;
        ArrayRow r12 = this.mRows[r10];
        if (r12.variable.mType == SolverVariable.Type.UNRESTRICTED) goto L43;
        if (r12.isSimpleDefinition == true) goto L43;
        if (r12.hasVariable(r6) == false) goto L43;
        float r16 = r12.variables.get(r6);
        if (r16 >= 0.0f) goto L43;
        float r17 = (-r12.constantValue) / r16;
        if (r17 >= r9) goto L43;
        r11 = r10;
        r9 = r17;
    L43:
        r10 = r10 + 1;
        goto L29
    L44:
        if (r11 <= (-1)) goto L10;
        ArrayRow r18 = this.mRows[r11];
        r18.variable.definitionId = -1;
        Metrics r19 = sMetrics;
        if (r19 == null) goto L48;
        r19.pivots++;
    L48:
        r18.pivot(r6);
        SolverVariable r20 = r18.variable;
        r20.definitionId = r11;
        r20.updateReferencesWithNewDefinition(this, r18);
        goto L10
    L16:
        return r4;
    L50:
        return r4;
    }

    private void releaseRows() {
        int r2 = 0;
        if (OPTIMIZED_ENGINE == false) goto L11;
    L5:
        if (r2 >= this.mNumRows) goto L16;
        ArrayRow r0 = this.mRows[r2];
        if (r0 == null) goto L9;
        this.mCache.optimizedArrayRowPool.release(r0);
    L9:
        this.mRows[r2] = null;
        r2 = r2 + 1;
        goto L5
    L16:
        return;
    L11:
        if (r2 >= this.mNumRows) goto L23;
        ArrayRow r1 = this.mRows[r2];
        if (r1 == null) goto L15;
        this.mCache.arrayRowPool.release(r1);
    L15:
        this.mRows[r2] = null;
        r2 = r2 + 1;
        goto L11
    }

    public void addCenterPoint(ConstraintWidget r17, ConstraintWidget r18, float r19, int r20) {
        ConstraintAnchor.Type r3 = ConstraintAnchor.Type.LEFT;
        SolverVariable r6 = createObjectVariable(r17.getAnchor(r3));
        ConstraintAnchor.Type r4 = ConstraintAnchor.Type.TOP;
        SolverVariable r8 = createObjectVariable(r17.getAnchor(r4));
        ConstraintAnchor.Type r5 = ConstraintAnchor.Type.RIGHT;
        SolverVariable r13 = createObjectVariable(r17.getAnchor(r5));
        ConstraintAnchor.Type r7 = ConstraintAnchor.Type.BOTTOM;
        SolverVariable r9 = createObjectVariable(r17.getAnchor(r7));
        SolverVariable r1 = createObjectVariable(r18.getAnchor(r3));
        SolverVariable r10 = createObjectVariable(r18.getAnchor(r4));
        SolverVariable r11 = createObjectVariable(r18.getAnchor(r5));
        SolverVariable r12 = createObjectVariable(r18.getAnchor(r7));
        ArrayRow r2 = createRow();
        double r14 = r19;
        double r15 = r20;
        r2.createRowWithAngle(r8, r9, r10, r12, (float) (Math.sin(r14) * r15));
        addConstraint(r2);
        ArrayRow r16 = createRow();
        r16.createRowWithAngle(r6, r13, r1, r11, (float) (Math.cos(r14) * r15));
        addConstraint(r16);
    }

    public void addCentering(SolverVariable r12, SolverVariable r13, int r14, float r15, SolverVariable r16, SolverVariable r17, int r18, int r19) {
        ArrayRow r10 = createRow();
        r10.createRowCentering(r12, r13, r14, r15, r16, r17, r18);
        if (r19 == 8) goto L5;
        r10.addError(this, r19);
    L5:
        addConstraint(r10);
    }

    public void addConstraint(ArrayRow r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        Metrics r0 = sMetrics;
        if (r0 == null) goto L9;
        r0.constraints++;
        if (r8.isSimpleDefinition == false) goto L9;
        r0.simpleconstraints++;
    L9:
        boolean r3 = true;
        if ((this.mNumRows + 1) < this.mMaxRows) goto L12;
    L13:
        increaseTableSize();
    L14:
        boolean r4 = false;
        if (r8.isSimpleDefinition == true) goto L46;
        r8.updateFromSystem(this);
        if (r8.isEmpty() == false) goto L19;
        return;
    L19:
        r8.ensurePositiveConstant();
        if (r8.chooseSubject(this) == false) goto L41;
        SolverVariable r1 = createExtraVariable();
        r8.variable = r1;
        int r5 = this.mNumRows;
        addRow(r8);
        if (this.mNumRows != (r5 + 1)) goto L41;
        this.mTempGoal.initFromRow(r8);
        optimize(this.mTempGoal, true);
        if (r1.definitionId != (-1)) goto L43;
        if (r8.variable != r1) goto L34;
        SolverVariable r2 = r8.pickPivot(r1);
        if (r2 == null) goto L34;
        Metrics r6 = sMetrics;
        if (r6 == null) goto L32;
        r6.pivots++;
    L32:
        r8.pivot(r2);
    L34:
        if (r8.isSimpleDefinition == true) goto L37;
        r8.variable.updateReferencesWithNewDefinition(this, r8);
    L37:
        if (OPTIMIZED_ENGINE == false) goto L39;
        this.mCache.optimizedArrayRowPool.release(r8);
    L40:
        this.mNumRows--;
        goto L43
    L39:
        this.mCache.arrayRowPool.release(r8);
    L43:
        if (r8.hasKeyVariable() == true) goto L45;
        return;
    L45:
        r4 = r3;
    L41:
        r3 = false;
    L46:
        if (r4 == true) goto L49;
        addRow(r8);
        return;
    L49:
        return;
    L12:
        if ((this.mNumColumns + 1) < this.mMaxColumns) goto L14;
        goto L13
    }

    public ArrayRow addEquality(SolverVariable r4, SolverVariable r5, int r6, int r7) {
        if (USE_BASIC_SYNONYMS == false) goto L11;
        if (r7 != 8) goto L11;
        if (r5.isFinalValue == false) goto L11;
        if (r4.definitionId != (-1)) goto L11;
        r4.setFinalValue(this, r5.computedValue + r6);
        return null;
    L11:
        ArrayRow r0 = createRow();
        r0.createRowEquals(r4, r5, r6);
        if (r7 == 8) goto L14;
        r0.addError(this, r7);
    L14:
        addConstraint(r0);
        return r0;
    }

    public void addGreaterBarrier(SolverVariable r3, SolverVariable r4, int r5, boolean r6) {
        ArrayRow r7 = createRow();
        SolverVariable r0 = createSlackVariable();
        r0.strength = 0;
        r7.createRowGreaterThan(r3, r4, r0, r5);
        addConstraint(r7);
    }

    public void addGreaterThan(SolverVariable r4, SolverVariable r5, int r6, int r7) {
        ArrayRow r0 = createRow();
        SolverVariable r1 = createSlackVariable();
        r1.strength = 0;
        r0.createRowGreaterThan(r4, r5, r1, r6);
        if (r7 == 8) goto L5;
        addSingleError(r0, (int) (r0.variables.get(r1) * (-1.0f)), r7);
    L5:
        addConstraint(r0);
    }

    public void addLowerBarrier(SolverVariable r3, SolverVariable r4, int r5, boolean r6) {
        ArrayRow r7 = createRow();
        SolverVariable r0 = createSlackVariable();
        r0.strength = 0;
        r7.createRowLowerThan(r3, r4, r0, r5);
        addConstraint(r7);
    }

    public void addLowerThan(SolverVariable r4, SolverVariable r5, int r6, int r7) {
        ArrayRow r0 = createRow();
        SolverVariable r1 = createSlackVariable();
        r1.strength = 0;
        r0.createRowLowerThan(r4, r5, r1, r6);
        if (r7 == 8) goto L5;
        addSingleError(r0, (int) (r0.variables.get(r1) * (-1.0f)), r7);
    L5:
        addConstraint(r0);
    }

    public void addRatio(SolverVariable r8, SolverVariable r9, SolverVariable r10, SolverVariable r11, float r12, int r13) {
        ArrayRow r6 = createRow();
        r6.createRowDimensionRatio(r8, r9, r10, r11, r12);
        if (r13 == 8) goto L5;
        r6.addError(this, r13);
    L5:
        addConstraint(r6);
    }

    public void addSynonym(SolverVariable r3, SolverVariable r4, int r5) {
        if (r3.definitionId != (-1)) goto L12;
        if (r5 != 0) goto L12;
        if (r4.isSynonym == false) goto L9;
        r4 = this.mCache.mIndexedVariables[r4.synonym];
    L9:
        if (r3.isSynonym == false) goto L11;
        SolverVariable r2 = this.mCache.mIndexedVariables[r3.synonym];
        return;
    L11:
        r3.setSynonym(this, r4, 0.0f);
        return;
    L12:
        addEquality(r3, r4, r5, 8);
    }

    public final void cleanupRows() {
        int r0 = 0;
    L4:
        if (r0 >= this.mNumRows) goto L19;
        ArrayRow r1 = this.mRows[r0];
        if (r1.variables.getCurrentSize() != 0) goto L9;
        r1.isSimpleDefinition = true;
    L9:
        if (r1.isSimpleDefinition == false) goto L18;
        SolverVariable r2 = r1.variable;
        r2.computedValue = r1.constantValue;
        r2.removeFromRow(r1);
        int r3 = r0;
    L11:
        int r4 = this.mNumRows;
        if (r3 >= (r4 - 1)) goto L14;
        ArrayRow[] r5 = this.mRows;
        int r6 = r3 + 1;
        r5[r3] = r5[r6];
        r3 = r6;
        goto L11
    L14:
        this.mRows[r4 - 1] = null;
        this.mNumRows = r4 - 1;
        r0 = r0 - 1;
        if (OPTIMIZED_ENGINE == false) goto L17;
        this.mCache.optimizedArrayRowPool.release(r1);
        goto L18
    L17:
        this.mCache.arrayRowPool.release(r1);
    L18:
        r0 = r0 + 1;
        goto L4
    }

    public SolverVariable createErrorVariable(int r6, String r7) {
        Metrics r0 = sMetrics;
        if (r0 == null) goto L6;
        r0.errors++;
    L6:
        if ((this.mNumColumns + 1) < this.mMaxColumns) goto L8;
        increaseTableSize();
    L8:
        SolverVariable r8 = acquireSolverVariable(SolverVariable.Type.ERROR, r7);
        int r1 = this.mVariablesID + 1;
        this.mVariablesID = r1;
        this.mNumColumns++;
        r8.id = r1;
        r8.strength = r6;
        this.mCache.mIndexedVariables[r1] = r8;
        this.mGoal.addError(r8);
        return r8;
    }

    public SolverVariable createExtraVariable() {
        Metrics r0 = sMetrics;
        if (r0 == null) goto L6;
        r0.extravariables++;
    L6:
        if ((this.mNumColumns + 1) < this.mMaxColumns) goto L8;
        increaseTableSize();
    L8:
        SolverVariable r1 = acquireSolverVariable(SolverVariable.Type.SLACK, null);
        int r2 = this.mVariablesID + 1;
        this.mVariablesID = r2;
        this.mNumColumns++;
        r1.id = r2;
        this.mCache.mIndexedVariables[r2] = r1;
        return r1;
    }

    public SolverVariable createObjectVariable(Object r4) {
        SolverVariable r0 = null;
        if (r4 != null) goto L6;
        return null;
    L6:
        if ((this.mNumColumns + 1) < this.mMaxColumns) goto L9;
        increaseTableSize();
    L9:
        if ((r4 instanceof ConstraintAnchor) == false) goto L22;
        ConstraintAnchor r5 = (ConstraintAnchor) r4;
        r0 = r5.getSolverVariable();
        if (r0 != null) goto L13;
        r5.resetSolverVariable(this.mCache);
        r0 = r5.getSolverVariable();
    L13:
        int r6 = r0.id;
        if (r6 != (-1)) goto L16;
    L19:
        if (r6 == (-1)) goto L21;
        r0.reset();
    L21:
        int r7 = this.mVariablesID + 1;
        this.mVariablesID = r7;
        this.mNumColumns++;
        r0.id = r7;
        r0.mType = SolverVariable.Type.UNRESTRICTED;
        this.mCache.mIndexedVariables[r7] = r0;
        goto L22
    L16:
        if (r6 > this.mVariablesID) goto L19;
        if (this.mCache.mIndexedVariables[r6] == null) goto L19;
    L22:
        return r0;
    }

    public ArrayRow createRow() {
        if (OPTIMIZED_ENGINE == false) goto L8;
        ArrayRow r0 = this.mCache.optimizedArrayRowPool.acquire();
        if (r0 != null) goto L7;
        r0 = new ValuesRow(this, this.mCache);
        OPTIMIZED_ARRAY_ROW_CREATION++;
    L12:
        SolverVariable.increaseErrorId();
        return r0;
    L7:
        r0.reset();
        goto L12
    L8:
        r0 = this.mCache.arrayRowPool.acquire();
        if (r0 != null) goto L11;
        r0 = new ArrayRow(this.mCache);
        ARRAY_ROW_CREATION++;
        goto L12
    L11:
        r0.reset();
        goto L12
    }

    public SolverVariable createSlackVariable() {
        Metrics r0 = sMetrics;
        if (r0 == null) goto L6;
        r0.slackvariables++;
    L6:
        if ((this.mNumColumns + 1) < this.mMaxColumns) goto L8;
        increaseTableSize();
    L8:
        SolverVariable r1 = acquireSolverVariable(SolverVariable.Type.SLACK, null);
        int r2 = this.mVariablesID + 1;
        this.mVariablesID = r2;
        this.mNumColumns++;
        r1.id = r2;
        this.mCache.mIndexedVariables[r2] = r1;
        return r1;
    }

    public void displayReadableRows() {
        displaySolverVariables();
        String r0 = a.n(new StringBuilder(" num vars "), "\n", this.mVariablesID);
        int r1 = 0;
        int r3 = 0;
    L4:
        if (r3 >= (this.mVariablesID + 1)) goto L11;
        SolverVariable r4 = this.mCache.mIndexedVariables[r3];
        if (r4 == null) goto L10;
        if (r4.isFinalValue == false) goto L10;
        r0 = r0 + " $[" + r3 + "] => " + r4 + " = " + r4.computedValue + "\n";
    L10:
        r3 = r3 + 1;
        goto L4
    L11:
        String r2 = a.j(r0, "\n");
        int r5 = 0;
    L13:
        if (r5 >= (this.mVariablesID + 1)) goto L20;
        SolverVariable[] r6 = this.mCache.mIndexedVariables;
        SolverVariable r7 = r6[r5];
        if (r7 == null) goto L19;
        if (r7.isSynonym == false) goto L19;
        r2 = r2 + " ~[" + r5 + "] => " + r7 + " = " + r6[r7.synonym] + " + " + r7.synonymDelta + "\n";
    L19:
        r5 = r5 + 1;
        goto L13
    L20:
        String r8 = a.j(r2, "\n\n #  ");
    L22:
        if (r1 >= this.mNumRows) goto L25;
        StringBuilder r9 = a.q(r8);
        r9.append(this.mRows[r1].toReadableString());
        r8 = a.j(r9.toString(), "\n #  ");
        r1 = r1 + 1;
        goto L22
    L25:
        if (this.mGoal == null) goto L27;
        StringBuilder r10 = a.t(r8, "Goal: ");
        r10.append(this.mGoal);
        r10.append("\n");
        r8 = r10.toString();
    L27:
        System.out.println(r8);
    }

    public void displaySystemInformation() {
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r1 >= this.TABLE_SIZE) goto L9;
        ArrayRow r3 = this.mRows[r1];
        if (r3 == null) goto L8;
        r2 = r2 + r3.sizeInBytes();
    L8:
        r1 = r1 + 1;
        goto L4
    L9:
        int r4 = 0;
        int r5 = 0;
    L11:
        if (r4 >= this.mNumRows) goto L16;
        ArrayRow r6 = this.mRows[r4];
        if (r6 == null) goto L15;
        r5 = r5 + r6.sizeInBytes();
    L15:
        r4 = r4 + 1;
        goto L11
    L16:
        PrintStream r7 = System.out;
        StringBuilder r8 = new StringBuilder("Linear System -> Table size: ");
        r8.append(this.TABLE_SIZE);
        r8.append(" (");
        int r9 = this.TABLE_SIZE;
        r8.append(getDisplaySize(r9 * r9));
        r8.append(") -- row sizes: ");
        r8.append(getDisplaySize(r2));
        r8.append(", actual size: ");
        r8.append(getDisplaySize(r5));
        r8.append(" rows: ");
        r8.append(this.mNumRows);
        r8.append(LibrarianImpl.Constants.SEPARATOR);
        r8.append(this.mMaxRows);
        r8.append(" cols: ");
        r8.append(this.mNumColumns);
        r8.append(LibrarianImpl.Constants.SEPARATOR);
        r8.append(this.mMaxColumns);
        r8.append(" 0 occupied cells, ");
        r8.append(getDisplaySize(0));
        r7.println(r8.toString());
    }

    public void displayVariablesReadableRows() {
        displaySolverVariables();
        String r0 = "";
        int r1 = 0;
    L4:
        if (r1 >= this.mNumRows) goto L9;
        if (this.mRows[r1].variable.mType != SolverVariable.Type.UNRESTRICTED) goto L8;
        StringBuilder r2 = a.q(r0);
        r2.append(this.mRows[r1].toReadableString());
        r0 = a.j(r2.toString(), "\n");
    L8:
        r1 = r1 + 1;
        goto L4
    L9:
        StringBuilder r3 = a.q(r0);
        r3.append(this.mGoal);
        r3.append("\n");
        String r5 = r3.toString();
        System.out.println(r5);
    }

    public void fillMetrics(Metrics r1) {
        sMetrics = r1;
    }

    public Cache getCache() {
        return this.mCache;
    }

    public Row getGoal() {
        return this.mGoal;
    }

    public int getMemoryUsed() {
        int r0 = 0;
        int r1 = 0;
    L4:
        if (r0 >= this.mNumRows) goto L9;
        ArrayRow r2 = this.mRows[r0];
        if (r2 == null) goto L8;
        r1 = r2.sizeInBytes() + r1;
    L8:
        r0 = r0 + 1;
        goto L4
    L9:
        return r1;
    }

    public int getNumEquations() {
        return this.mNumRows;
    }

    public int getNumVariables() {
        return this.mVariablesID;
    }

    public int getObjectVariableValue(Object r1) {
        SolverVariable r0 = ((ConstraintAnchor) r1).getSolverVariable();
        if (r0 != null) goto L5;
        return 0;
    L5:
        return (int) (r0.computedValue + 0.5f);
    }

    public ArrayRow getRow(int r1) {
        return this.mRows[r1];
    }

    public float getValueFor(String r2) {
        SolverVariable r1 = getVariable(r2, SolverVariable.Type.UNRESTRICTED);
        if (r1 != null) goto L7;
        return 0.0f;
    L7:
        return r1.computedValue;
    }

    public SolverVariable getVariable(String r2, SolverVariable.Type r3) {
        if (this.mVariables != null) goto L5;
        this.mVariables = new HashMap();
    L5:
        SolverVariable r0 = this.mVariables.get(r2);
        if (r0 == null) goto L8;
        return r0;
    L8:
        return createVariable(r2, r3);
    }

    public void minimize() {
        Metrics r0 = sMetrics;
        if (r0 == null) goto L6;
        r0.minimize++;
    L6:
        if (this.mGoal.isEmpty() == false) goto L10;
        computeValues();
        return;
    L10:
        if (this.graphOptimizer == false) goto L12;
    L15:
        Metrics r1 = sMetrics;
        if (r1 == null) goto L18;
        r1.graphOptimizer++;
    L18:
        int r2 = 0;
    L20:
        if (r2 >= this.mNumRows) goto L25;
        if (this.mRows[r2].isSimpleDefinition == false) goto L23;
        r2 = r2 + 1;
        goto L20
    L23:
        minimizeGoal(this.mGoal);
        return;
    L25:
        Metrics r3 = sMetrics;
        if (r3 == null) goto L28;
        r3.fullySolved++;
    L28:
        computeValues();
        return;
    L12:
        if (this.newgraphOptimizer == true) goto L15;
        minimizeGoal(this.mGoal);
    }

    public void minimizeGoal(Row r6) {
        Metrics r0 = sMetrics;
        if (r0 == null) goto L5;
        r0.minimizeGoal++;
        r0.maxVariables = Math.max(r0.maxVariables, this.mNumColumns);
        Metrics r1 = sMetrics;
        r1.maxRows = Math.max(r1.maxRows, this.mNumRows);
    L5:
        enforceBFS(r6);
        optimize(r6, false);
        computeValues();
    }

    public void removeRow(ArrayRow r7) {
        if (r7.isSimpleDefinition == false) goto L26;
        SolverVariable r0 = r7.variable;
        if (r0 == null) goto L27;
        int r1 = r0.definitionId;
        if (r1 == (-1)) goto L15;
    L8:
        int r2 = this.mNumRows;
        if (r1 >= (r2 - 1)) goto L14;
        ArrayRow[] r3 = this.mRows;
        int r4 = r1 + 1;
        ArrayRow r5 = r3[r4];
        SolverVariable r6 = r5.variable;
        if (r6.definitionId != r4) goto L13;
        r6.definitionId = r1;
    L13:
        r3[r1] = r5;
        r1 = r4;
        goto L8
    L14:
        this.mNumRows = r2 - 1;
    L15:
        SolverVariable r8 = r7.variable;
        if (r8.isFinalValue == true) goto L19;
        r8.setFinalValue(this, r7.constantValue);
    L19:
        if (OPTIMIZED_ENGINE == false) goto L21;
        this.mCache.optimizedArrayRowPool.release(r7);
        return;
    L21:
        this.mCache.arrayRowPool.release(r7);
        return;
    L27:
        return;
    }

    public void reset() {
        int r1 = 0;
    L3:
        Cache r2 = this.mCache;
        SolverVariable[] r3 = r2.mIndexedVariables;
        if (r1 >= r3.length) goto L9;
        SolverVariable r4 = r3[r1];
        if (r4 == null) goto L8;
        r4.reset();
    L8:
        r1 = r1 + 1;
        goto L3
    L9:
        r2.solverVariablePool.releaseAll(this.mPoolVariables, this.mPoolVariablesCount);
        this.mPoolVariablesCount = 0;
        Arrays.fill(this.mCache.mIndexedVariables, null);
        HashMap<String, SolverVariable> r5 = this.mVariables;
        if (r5 == null) goto L12;
        r5.clear();
    L12:
        this.mVariablesID = 0;
        this.mGoal.clear();
        this.mNumColumns = 1;
        int r6 = 0;
    L14:
        if (r6 >= this.mNumRows) goto L19;
        ArrayRow r7 = this.mRows[r6];
        if (r7 == null) goto L18;
        r7.used = false;
    L18:
        r6 = r6 + 1;
        goto L14
    L19:
        releaseRows();
        this.mNumRows = 0;
        if (OPTIMIZED_ENGINE == false) goto L22;
        this.mTempGoal = new ValuesRow(this, this.mCache);
        return;
    L22:
        this.mTempGoal = new ArrayRow(this.mCache);
    }

    public void addSingleError(ArrayRow r2, int r3, int r4) {
        r2.addSingleError(createErrorVariable(r4, null), r3);
    }

    public void addEquality(SolverVariable r6, int r7) {
        if (USE_BASIC_SYNONYMS == true) goto L5;
    L18:
        int r0 = r6.definitionId;
        if (r0 == (-1)) goto L27;
        ArrayRow r1 = this.mRows[r0];
        if (r1.isSimpleDefinition == false) goto L24;
        r1.constantValue = r7;
        return;
    L24:
        if (r1.variables.getCurrentSize() != 0) goto L26;
        r1.isSimpleDefinition = true;
        r1.constantValue = r7;
        return;
    L26:
        ArrayRow r2 = createRow();
        r2.createRowEquals(r6, r7);
        addConstraint(r2);
        return;
    L27:
        ArrayRow r3 = createRow();
        r3.createRowDefinition(r6, r7);
        addConstraint(r3);
        return;
    L5:
        if (r6.definitionId != (-1)) goto L18;
        float r8 = r7;
        r6.setFinalValue(this, r8);
        int r4 = 0;
    L8:
        if (r4 >= (this.mVariablesID + 1)) goto L17;
        SolverVariable r5 = this.mCache.mIndexedVariables[r4];
        if (r5 == null) goto L16;
        if (r5.isSynonym == false) goto L16;
        if (r5.synonym != r6.id) goto L16;
        r5.setFinalValue(this, r5.synonymDelta + r8);
    L16:
        r4 = r4 + 1;
        goto L8
    }
}
