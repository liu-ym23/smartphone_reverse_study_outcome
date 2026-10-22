package androidx.constraintlayout.core;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class ArrayRow implements LinearSystem.Row {
    private static final boolean DEBUG = false;
    private static final boolean FULL_NEW_CHECK = false;
    float constantValue;
    boolean isSimpleDefinition;
    boolean used;
    SolverVariable variable;
    public ArrayRowVariables variables;
    ArrayList<SolverVariable> variablesToUpdate;

    public interface ArrayRowVariables {
        void add(SolverVariable r1, float r2, boolean r3);

        void clear();

        boolean contains(SolverVariable r1);

        void display();

        void divideByAmount(float r1);

        float get(SolverVariable r1);

        int getCurrentSize();

        SolverVariable getVariable(int r1);

        float getVariableValue(int r1);

        int indexOf(SolverVariable r1);

        void invert();

        void put(SolverVariable r1, float r2);

        float remove(SolverVariable r1, boolean r2);

        int sizeInBytes();

        float use(ArrayRow r1, boolean r2);
    }

    public ArrayRow() {
        this.variable = null;
        this.constantValue = 0.0f;
        this.used = false;
        this.variablesToUpdate = new ArrayList();
        this.isSimpleDefinition = false;
    }

    public ArrayRow(Cache r3) {
        this.variable = null;
        this.constantValue = 0.0f;
        this.used = false;
        this.variablesToUpdate = new ArrayList();
        this.isSimpleDefinition = false;
        this.variables = new ArrayLinkedVariables(this, r3);
    }

    private boolean isNew(SolverVariable r1, LinearSystem r2) {
        if (r1.usageInRowCount <= 1) goto L7;
        return false;
    L7:
        return true;
    }

    private SolverVariable pickPivotInVariables(boolean[] r10, SolverVariable r11) {
        int r0 = this.variables.getCurrentSize();
        SolverVariable r2 = null;
        int r3 = 0;
        float r4 = 0.0f;
    L3:
        if (r3 >= r0) goto L19;
        float r5 = this.variables.getVariableValue(r3);
        if (r5 >= 0.0f) goto L18;
        SolverVariable r6 = this.variables.getVariable(r3);
        if (r10 != null) goto L9;
    L10:
        if (r6 == r11) goto L18;
        SolverVariable.Type r7 = r6.mType;
        if (r7 == SolverVariable.Type.SLACK) goto L16;
        if (r7 != SolverVariable.Type.ERROR) goto L18;
    L16:
        if (r5 >= r4) goto L18;
        r4 = r5;
        r2 = r6;
        goto L18
    L9:
        if (r10[r6.id] == false) goto L10;
    L18:
        r3 = r3 + 1;
        goto L3
    L19:
        return r2;
    }

    public ArrayRow addError(LinearSystem r4, int r5) {
        this.variables.put(r4.createErrorVariable(r5, "ep"), 1.0f);
        this.variables.put(r4.createErrorVariable(r5, "em"), -1.0f);
        return this;
    }

    @Override // androidx.constraintlayout.core.LinearSystem.Row
    public void addError(SolverVariable r4) {
        int r0 = r4.strength;
        float r1 = 1.0f;
        if (r0 != 1) goto L6;
    L17:
        this.variables.put(r4, r1);
        return;
    L6:
        if (r0 != 2) goto L9;
        r1 = 1000.0f;
        goto L17
    L9:
        if (r0 != 3) goto L12;
        r1 = 1000000.0f;
        goto L17
    L12:
        if (r0 != 4) goto L15;
        r1 = 1.0E9f;
        goto L17
    L15:
        if (r0 != 5) goto L17;
        r1 = 1.0E12f;
        goto L17
    }

    ArrayRow addSingleError(SolverVariable r2, int r3) {
        this.variables.put(r2, r3);
        return this;
    }

    boolean chooseSubject(LinearSystem r3) {
        SolverVariable r4 = chooseSubjectInVariables(r3);
        if (r4 != null) goto L5;
        boolean r5 = true;
    L7:
        if (this.variables.getCurrentSize() != 0) goto L9;
        this.isSimpleDefinition = true;
    L9:
        return r5;
    L5:
        pivot(r4);
        r5 = false;
        goto L7
    }

    SolverVariable chooseSubjectInVariables(LinearSystem r15) {
        int r0 = this.variables.getCurrentSize();
        SolverVariable r1 = null;
        int r4 = 0;
        boolean r5 = false;
        boolean r6 = false;
        float r7 = 0.0f;
        float r8 = 0.0f;
        SolverVariable r2 = null;
    L3:
        if (r4 >= r0) goto L28;
        float r9 = this.variables.getVariableValue(r4);
        SolverVariable r10 = this.variables.getVariable(r4);
        if (r10.mType != SolverVariable.Type.UNRESTRICTED) goto L15;
        if (r1 != null) goto L9;
    L7:
        r5 = isNew(r10, r15);
        r7 = r9;
        r1 = r10;
    L27:
        r4 = r4 + 1;
        goto L3
    L9:
        if (r7 > r9) goto L7;
        if (r5 == true) goto L27;
        if (isNew(r10, r15) == false) goto L27;
        r7 = r9;
        r1 = r10;
        r5 = true;
        goto L27
    L15:
        if (r1 != null) goto L27;
        if (r9 >= 0.0f) goto L27;
        if (r2 != null) goto L21;
    L19:
        r6 = isNew(r10, r15);
        r8 = r9;
        r2 = r10;
        goto L27
    L21:
        if (r8 > r9) goto L19;
        if (r6 == true) goto L27;
        if (isNew(r10, r15) == false) goto L27;
        r8 = r9;
        r2 = r10;
        r6 = true;
        goto L27
    L28:
        if (r1 == null) goto L30;
        return r1;
    L30:
        return r2;
    }

    @Override // androidx.constraintlayout.core.LinearSystem.Row
    public void clear() {
        this.variables.clear();
        this.variable = null;
        this.constantValue = 0.0f;
    }

    ArrayRow createRowCentering(SolverVariable r6, SolverVariable r7, int r8, float r9, SolverVariable r10, SolverVariable r11, int r12) {
        if (r7 != r10) goto L7;
        this.variables.put(r6, 1.0f);
        this.variables.put(r11, 1.0f);
        this.variables.put(r7, -2.0f);
        return this;
    L7:
        if (r9 != 0.5f) goto L14;
        this.variables.put(r6, 1.0f);
        this.variables.put(r7, -1.0f);
        this.variables.put(r10, -1.0f);
        this.variables.put(r11, 1.0f);
        if (r8 > 0) goto L11;
        if (r12 > 0) goto L11;
    L24:
        return this;
    L11:
        int r13 = (-r8) + r12;
    L12:
        float r14 = r13;
    L16:
        this.constantValue = r14;
        goto L24
    L14:
        if (r9 > 0.0f) goto L18;
        this.variables.put(r6, -1.0f);
        this.variables.put(r7, 1.0f);
        r14 = r8;
        goto L16
    L18:
        if (r9 < 1.0f) goto L20;
        this.variables.put(r11, -1.0f);
        this.variables.put(r10, 1.0f);
        r13 = -r12;
        goto L12
    L20:
        float r3 = 1.0f - r9;
        this.variables.put(r6, r3 * 1.0f);
        this.variables.put(r7, r3 * (-1.0f));
        this.variables.put(r10, (-1.0f) * r9);
        this.variables.put(r11, 1.0f * r9);
        if (r8 > 0) goto L23;
        if (r12 <= 0) goto L24;
    L23:
        r14 = ((-r8) * r3) + (r12 * r9);
        goto L16
    }

    ArrayRow createRowDefinition(SolverVariable r1, int r2) {
        this.variable = r1;
        float r3 = r2;
        r1.computedValue = r3;
        this.constantValue = r3;
        this.isSimpleDefinition = true;
        return this;
    }

    ArrayRow createRowDimensionPercent(SolverVariable r3, SolverVariable r4, float r5) {
        this.variables.put(r3, -1.0f);
        this.variables.put(r4, r5);
        return this;
    }

    public ArrayRow createRowDimensionRatio(SolverVariable r3, SolverVariable r4, SolverVariable r5, SolverVariable r6, float r7) {
        this.variables.put(r3, -1.0f);
        this.variables.put(r4, 1.0f);
        this.variables.put(r5, r7);
        this.variables.put(r6, -r7);
        return this;
    }

    public ArrayRow createRowEqualDimension(float r4, float r5, float r6, SolverVariable r7, int r8, SolverVariable r9, int r10, SolverVariable r11, int r12, SolverVariable r13, int r14) {
        if (r5 != 0.0f) goto L5;
    L8:
        this.constantValue = (((-r8) - r10) + r12) + r14;
        this.variables.put(r7, 1.0f);
        this.variables.put(r9, -1.0f);
        this.variables.put(r13, 1.0f);
        this.variables.put(r11, -1.0f);
    L9:
        return this;
    L5:
        if (r4 == r6) goto L8;
        float r15 = (r4 / r5) / (r6 / r5);
        this.constantValue = (((-r8) - r10) + (r12 * r15)) + (r14 * r15);
        this.variables.put(r7, 1.0f);
        this.variables.put(r9, -1.0f);
        this.variables.put(r13, r15);
        this.variables.put(r11, -r15);
        goto L9
    }

    public ArrayRow createRowEqualMatchDimensions(float r5, float r6, float r7, SolverVariable r8, SolverVariable r9, SolverVariable r10, SolverVariable r11) {
        this.constantValue = 0.0f;
        if (r6 != 0.0f) goto L5;
    L14:
        this.variables.put(r8, 1.0f);
        this.variables.put(r9, -1.0f);
        this.variables.put(r11, 1.0f);
        this.variables.put(r10, -1.0f);
    L15:
        return this;
    L5:
        if (r5 == r7) goto L14;
        if (r5 != 0.0f) goto L11;
        this.variables.put(r8, 1.0f);
        this.variables.put(r9, -1.0f);
        goto L15
    L11:
        if (r7 != 0.0f) goto L13;
        this.variables.put(r10, 1.0f);
        this.variables.put(r11, -1.0f);
        goto L15
    L13:
        float r12 = (r5 / r6) / (r7 / r6);
        this.variables.put(r8, 1.0f);
        this.variables.put(r9, -1.0f);
        this.variables.put(r11, r12);
        this.variables.put(r10, -r12);
        goto L15
    }

    public ArrayRow createRowEquals(SolverVariable r2, int r3) {
        if (r3 >= 0) goto L4;
        this.constantValue = r3 * (-1);
        ArrayRowVariables r4 = this.variables;
        float r0 = 1.0f;
    L5:
        r4.put(r2, r0);
        return this;
    L4:
        this.constantValue = r3;
        r4 = this.variables;
        r0 = -1.0f;
        goto L5
    }

    public ArrayRow createRowEquals(SolverVariable r3, SolverVariable r4, int r5) {
        boolean r0 = false;
        if (r5 == 0) goto L8;
        if (r5 >= 0) goto L6;
        r5 = r5 * (-1);
        r0 = true;
    L6:
        this.constantValue = r5;
    L8:
        if (r0 == true) goto L10;
        this.variables.put(r3, -1.0f);
        this.variables.put(r4, 1.0f);
    L11:
        return this;
    L10:
        this.variables.put(r3, 1.0f);
        this.variables.put(r4, -1.0f);
        goto L11
    }

    public ArrayRow createRowGreaterThan(SolverVariable r1, int r2, SolverVariable r3) {
        this.constantValue = r2;
        this.variables.put(r1, -1.0f);
        return this;
    }

    public ArrayRow createRowGreaterThan(SolverVariable r3, SolverVariable r4, SolverVariable r5, int r6) {
        boolean r0 = false;
        if (r6 == 0) goto L8;
        if (r6 >= 0) goto L6;
        r6 = r6 * (-1);
        r0 = true;
    L6:
        this.constantValue = r6;
    L8:
        if (r0 == true) goto L10;
        this.variables.put(r3, -1.0f);
        this.variables.put(r4, 1.0f);
        this.variables.put(r5, 1.0f);
    L11:
        return this;
    L10:
        this.variables.put(r3, 1.0f);
        this.variables.put(r4, -1.0f);
        this.variables.put(r5, -1.0f);
        goto L11
    }

    public ArrayRow createRowLowerThan(SolverVariable r3, SolverVariable r4, SolverVariable r5, int r6) {
        boolean r0 = false;
        if (r6 == 0) goto L8;
        if (r6 >= 0) goto L6;
        r6 = r6 * (-1);
        r0 = true;
    L6:
        this.constantValue = r6;
    L8:
        if (r0 == true) goto L10;
        this.variables.put(r3, -1.0f);
        this.variables.put(r4, 1.0f);
        this.variables.put(r5, -1.0f);
    L11:
        return this;
    L10:
        this.variables.put(r3, 1.0f);
        this.variables.put(r4, -1.0f);
        this.variables.put(r5, 1.0f);
        goto L11
    }

    public ArrayRow createRowWithAngle(SolverVariable r3, SolverVariable r4, SolverVariable r5, SolverVariable r6, float r7) {
        this.variables.put(r5, 0.5f);
        this.variables.put(r6, 0.5f);
        this.variables.put(r3, -0.5f);
        this.variables.put(r4, -0.5f);
        this.constantValue = -r7;
        return this;
    }

    void ensurePositiveConstant() {
        float r0 = this.constantValue;
        if (r0 >= 0.0f) goto L6;
        this.constantValue = r0 * (-1.0f);
        this.variables.invert();
        return;
    }

    @Override // androidx.constraintlayout.core.LinearSystem.Row
    public SolverVariable getKey() {
        return this.variable;
    }

    @Override // androidx.constraintlayout.core.LinearSystem.Row
    public SolverVariable getPivotCandidate(LinearSystem r1, boolean[] r2) {
        return pickPivotInVariables(r2, null);
    }

    boolean hasKeyVariable() {
        SolverVariable r0 = this.variable;
        if (r0 != null) goto L5;
    L9:
        return false;
    L5:
        if (r0.mType != SolverVariable.Type.UNRESTRICTED) goto L7;
    L8:
        return true;
    L7:
        if (this.constantValue < 0.0f) goto L9;
        goto L8
    }

    boolean hasVariable(SolverVariable r1) {
        return this.variables.contains(r1);
    }

    @Override // androidx.constraintlayout.core.LinearSystem.Row
    public void initFromRow(LinearSystem.Row r6) {
        if ((r6 instanceof ArrayRow) == false) goto L8;
        ArrayRow r7 = (ArrayRow) r6;
        this.variable = null;
        this.variables.clear();
        int r0 = 0;
    L6:
        if (r0 >= r7.variables.getCurrentSize()) goto L10;
        SolverVariable r1 = r7.variables.getVariable(r0);
        float r2 = r7.variables.getVariableValue(r0);
        this.variables.add(r1, r2, true);
        r0 = r0 + 1;
        goto L6
    L10:
        return;
    }

    @Override // androidx.constraintlayout.core.LinearSystem.Row
    public boolean isEmpty() {
        if (this.variable == null) goto L5;
    L9:
        return false;
    L5:
        if (this.constantValue != 0.0f) goto L9;
        if (this.variables.getCurrentSize() != 0) goto L9;
        return true;
    }

    public SolverVariable pickPivot(SolverVariable r2) {
        return pickPivotInVariables(null, r2);
    }

    void pivot(SolverVariable r4) {
        SolverVariable r0 = this.variable;
        if (r0 == null) goto L5;
        this.variables.put(r0, -1.0f);
        this.variable.definitionId = -1;
        this.variable = null;
    L5:
        float r1 = this.variables.remove(r4, true) * (-1.0f);
        this.variable = r4;
        if (r1 != 1.0f) goto L8;
        return;
    L8:
        this.constantValue /= r1;
        this.variables.divideByAmount(r1);
    }

    public void reset() {
        this.variable = null;
        this.variables.clear();
        this.constantValue = 0.0f;
        this.isSimpleDefinition = false;
    }

    int sizeInBytes() {
        if (this.variable == null) goto L5;
        int r0 = 4;
    L7:
        return ((r0 + 4) + 4) + this.variables.sizeInBytes();
    L5:
        r0 = 0;
        goto L7
    }

    /*  JADX ERROR: ConcurrentModificationException in pass: ConstructorVisitor
        java.util.ConcurrentModificationException
        	at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1104)
        	at java.base/java.util.ArrayList$Itr.next(ArrayList.java:1058)
        	at jadx.core.dex.visitors.ConstructorVisitor.insertPhiInsn(ConstructorVisitor.java:139)
        	at jadx.core.dex.visitors.ConstructorVisitor.processInvoke(ConstructorVisitor.java:91)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:56)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:42)
        */
    java.lang.String toReadableString() {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r0v0 ??
            	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:341)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            Method dump skipped, instruction units count: 229
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.ArrayRow.toReadableString():java.lang.String");
    }

    public String toString() {
        return toReadableString();
    }

    @Override // androidx.constraintlayout.core.LinearSystem.Row
    public void updateFromFinalVariable(LinearSystem r4, SolverVariable r5, boolean r6) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.isFinalValue == false) goto L18;
        this.constantValue += r5.computedValue * this.variables.get(r5);
        this.variables.remove(r5, r6);
        if (r6 == false) goto L10;
        r5.removeFromRow(this);
    L10:
        if (LinearSystem.SIMPLIFY_SYNONYMS == true) goto L12;
        return;
    L12:
        if (this.variables.getCurrentSize() != 0) goto L17;
        this.isSimpleDefinition = true;
        r4.hasSimpleDefinition = true;
        return;
    L17:
        return;
    }

    @Override // androidx.constraintlayout.core.LinearSystem.Row
    public void updateFromRow(LinearSystem r4, ArrayRow r5, boolean r6) {
        this.constantValue += r5.constantValue * this.variables.use(r5, r6);
        if (r6 == false) goto L6;
        r5.variable.removeFromRow(this);
    L6:
        if (LinearSystem.SIMPLIFY_SYNONYMS == true) goto L8;
        return;
    L8:
        if (this.variable != null) goto L10;
        return;
    L10:
        if (this.variables.getCurrentSize() != 0) goto L15;
        this.isSimpleDefinition = true;
        r4.hasSimpleDefinition = true;
        return;
    }

    public void updateFromSynonymVariable(LinearSystem r4, SolverVariable r5, boolean r6) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.isSynonym == false) goto L18;
        float r0 = this.variables.get(r5);
        this.constantValue += r5.synonymDelta * r0;
        this.variables.remove(r5, r6);
        if (r6 == false) goto L9;
        r5.removeFromRow(this);
    L9:
        this.variables.add(r4.mCache.mIndexedVariables[r5.synonym], r0, r6);
        if (LinearSystem.SIMPLIFY_SYNONYMS == true) goto L12;
        return;
    L12:
        if (this.variables.getCurrentSize() != 0) goto L17;
        this.isSimpleDefinition = true;
        r4.hasSimpleDefinition = true;
        return;
    L17:
        return;
    }

    @Override // androidx.constraintlayout.core.LinearSystem.Row
    public void updateFromSystem(LinearSystem r9) {
        if (r9.mRows.length != 0) goto L5;
        return;
    L5:
        boolean r1 = false;
    L7:
        if (r1 == true) goto L33;
        int r3 = this.variables.getCurrentSize();
        int r4 = 0;
    L9:
        if (r4 >= r3) goto L18;
        SolverVariable r5 = this.variables.getVariable(r4);
        if (r5.definitionId == (-1)) goto L13;
    L16:
        this.variablesToUpdate.add(r5);
    L17:
        r4 = r4 + 1;
        goto L9
    L13:
        if (r5.isFinalValue == true) goto L16;
        if (r5.isSynonym == false) goto L17;
    L18:
        int r6 = this.variablesToUpdate.size();
        if (r6 > 0) goto L20;
        r1 = true;
        goto L7
    L20:
        int r7 = 0;
    L21:
        if (r7 >= r6) goto L30;
        SolverVariable r8 = this.variablesToUpdate.get(r7);
        if (r8.isFinalValue == false) goto L26;
        updateFromFinalVariable(r9, r8, true);
    L29:
        r7 = r7 + 1;
        goto L21
    L26:
        if (r8.isSynonym == false) goto L28;
        updateFromSynonymVariable(r9, r8, true);
        goto L29
    L28:
        updateFromRow(r9, r9.mRows[r8.definitionId], true);
        goto L29
    L30:
        this.variablesToUpdate.clear();
        goto L7
    L33:
        if (LinearSystem.SIMPLIFY_SYNONYMS == true) goto L35;
        return;
    L35:
        if (this.variable != null) goto L37;
        return;
    L37:
        if (this.variables.getCurrentSize() != 0) goto L55;
        this.isSimpleDefinition = true;
        r9.hasSimpleDefinition = true;
        return;
    }
}
