package org.apache.commons.math3.ml.neuralnet.twod;

import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.math3.exception.MathInternalError;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.ml.neuralnet.FeatureInitializer;
import org.apache.commons.math3.ml.neuralnet.Network;
import org.apache.commons.math3.ml.neuralnet.Neuron;
import org.apache.commons.math3.ml.neuralnet.SquareNeighbourhood;

/* JADX INFO: loaded from: classes6.dex */
public class NeuronSquareMesh2D implements Iterable<Neuron>, Serializable {
    private static final long serialVersionUID = 1;
    private final long[][] identifiers;
    private final SquareNeighbourhood neighbourhood;
    private final Network network;
    private final int numberOfColumns;
    private final int numberOfRows;
    private final boolean wrapColumns;
    private final boolean wrapRows;

    /* JADX INFO: renamed from: org.apache.commons.math3.ml.neuralnet.twod.NeuronSquareMesh2D$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$math3$ml$neuralnet$SquareNeighbourhood = null;
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$math3$ml$neuralnet$twod$NeuronSquareMesh2D$HorizontalDirection = null;
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$math3$ml$neuralnet$twod$NeuronSquareMesh2D$VerticalDirection = null;

        static {
            int[] r0 = new int[SquareNeighbourhood.values().length];
            $SwitchMap$org$apache$commons$math3$ml$neuralnet$SquareNeighbourhood = r0;
            r0[SquareNeighbourhood.MOORE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
        L24:
            $SwitchMap$org$apache$commons$math3$ml$neuralnet$SquareNeighbourhood[SquareNeighbourhood.VON_NEUMANN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
        L6:
            int[] r2 = new int[VerticalDirection.values().length];
            $SwitchMap$org$apache$commons$math3$ml$neuralnet$twod$NeuronSquareMesh2D$VerticalDirection = r2;
            r2[VerticalDirection.UP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L18
        L32:
            $SwitchMap$org$apache$commons$math3$ml$neuralnet$twod$NeuronSquareMesh2D$VerticalDirection[VerticalDirection.DOWN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L19
        L38:
            $SwitchMap$org$apache$commons$math3$ml$neuralnet$twod$NeuronSquareMesh2D$VerticalDirection[VerticalDirection.CENTER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L20
        L11:
            int[] r3 = new int[HorizontalDirection.values().length];
            $SwitchMap$org$apache$commons$math3$ml$neuralnet$twod$NeuronSquareMesh2D$HorizontalDirection = r3;
            r3[HorizontalDirection.LEFT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L26:
            $SwitchMap$org$apache$commons$math3$ml$neuralnet$twod$NeuronSquareMesh2D$HorizontalDirection[HorizontalDirection.RIGHT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
        L30:
            $SwitchMap$org$apache$commons$math3$ml$neuralnet$twod$NeuronSquareMesh2D$HorizontalDirection[HorizontalDirection.CENTER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L23
            return;
        }
    }

    public static final enum HorizontalDirection extends Enum<HorizontalDirection> {
        private static final /* synthetic */ HorizontalDirection[] $VALUES = null;
        public static final HorizontalDirection CENTER = null;
        public static final HorizontalDirection LEFT = null;
        public static final HorizontalDirection RIGHT = null;

        private HorizontalDirection(String r1, int r2) {
            super(r1, r2);
        }

        public static HorizontalDirection valueOf(String r1) {
            return (HorizontalDirection) Enum.valueOf(HorizontalDirection.class, r1);
        }

        public static HorizontalDirection[] values() {
            return (HorizontalDirection[]) $VALUES.clone();
        }

        static {
            HorizontalDirection r0 = new HorizontalDirection("RIGHT", 0);
            RIGHT = r0;
            HorizontalDirection r1 = new HorizontalDirection("CENTER", 1);
            CENTER = r1;
            HorizontalDirection r3 = new HorizontalDirection("LEFT", 2);
            LEFT = r3;
            $VALUES = new HorizontalDirection[]{r0, r1, r3};
        }
    }

    private static class SerializationProxy implements Serializable {
        private static final long serialVersionUID = 20130226;
        private final double[][][] featuresList;
        private final SquareNeighbourhood neighbourhood;
        private final boolean wrapColumns;
        private final boolean wrapRows;

        SerializationProxy(boolean r1, boolean r2, SquareNeighbourhood r3, double[][][] r4) {
            this.wrapRows = r1;
            this.wrapColumns = r2;
            this.neighbourhood = r3;
            this.featuresList = r4;
        }

        private Object readResolve() {
            return new NeuronSquareMesh2D(this.wrapRows, this.wrapColumns, this.neighbourhood, this.featuresList);
        }
    }

    public static final enum VerticalDirection extends Enum<VerticalDirection> {
        private static final /* synthetic */ VerticalDirection[] $VALUES = null;
        public static final VerticalDirection CENTER = null;
        public static final VerticalDirection DOWN = null;
        public static final VerticalDirection UP = null;

        private VerticalDirection(String r1, int r2) {
            super(r1, r2);
        }

        public static VerticalDirection valueOf(String r1) {
            return (VerticalDirection) Enum.valueOf(VerticalDirection.class, r1);
        }

        public static VerticalDirection[] values() {
            return (VerticalDirection[]) $VALUES.clone();
        }

        static {
            VerticalDirection r0 = new VerticalDirection("UP", 0);
            UP = r0;
            VerticalDirection r1 = new VerticalDirection("CENTER", 1);
            CENTER = r1;
            VerticalDirection r3 = new VerticalDirection("DOWN", 2);
            DOWN = r3;
            $VALUES = new VerticalDirection[]{r0, r1, r3};
        }
    }

    NeuronSquareMesh2D(boolean r9, boolean r10, SquareNeighbourhood r11, double[][][] r12) {
        int r0 = r12.length;
        this.numberOfRows = r0;
        double[][] r2 = r12[0];
        int r3 = r2.length;
        this.numberOfColumns = r3;
        if (r0 < 2) goto L18;
        if (r3 < 2) goto L16;
        this.wrapRows = r9;
        this.wrapColumns = r10;
        this.neighbourhood = r11;
        this.network = new Network(0, r2[0].length);
        this.identifiers = (long[][]) Array.newInstance(Long.TYPE, new int[]{r0, r3});
        int r13 = 0;
    L7:
        if (r13 >= this.numberOfRows) goto L13;
        int r14 = 0;
    L10:
        if (r14 >= this.numberOfColumns) goto L12;
        this.identifiers[r13][r14] = this.network.createNeuron(r12[r13][r14]);
        r14 = r14 + 1;
        goto L10
    L12:
        r13 = r13 + 1;
        goto L7
    L13:
        createLinks();
        return;
    L16:
        throw new NumberIsTooSmallException(Integer.valueOf(r3), 2, true);
    L18:
        throw new NumberIsTooSmallException(Integer.valueOf(r0), 2, true);
    }

    public NeuronSquareMesh2D(int r6, boolean r7, int r8, boolean r9, SquareNeighbourhood r10, FeatureInitializer[] r11) {
        if (r6 < 2) goto L19;
        if (r8 < 2) goto L17;
        this.numberOfRows = r6;
        this.wrapRows = r7;
        this.numberOfColumns = r8;
        this.wrapColumns = r9;
        this.neighbourhood = r10;
        this.identifiers = (long[][]) Array.newInstance(Long.TYPE, new int[]{r6, r8});
        int r12 = r11.length;
        this.network = new Network(0, r12);
        int r13 = 0;
    L6:
        if (r13 >= r6) goto L14;
        int r0 = 0;
    L8:
        if (r0 >= r8) goto L13;
        double[] r1 = new double[r12];
        int r2 = 0;
    L10:
        if (r2 >= r12) goto L12;
        r1[r2] = r11[r2].value();
        r2 = r2 + 1;
        goto L10
    L12:
        this.identifiers[r13][r0] = this.network.createNeuron(r1);
        r0 = r0 + 1;
        goto L8
    L13:
        r13 = r13 + 1;
        goto L6
    L14:
        createLinks();
        return;
    L17:
        throw new NumberIsTooSmallException(Integer.valueOf(r8), 2, true);
    L19:
        throw new NumberIsTooSmallException(Integer.valueOf(r6), 2, true);
    }

    private NeuronSquareMesh2D(boolean r2, boolean r3, SquareNeighbourhood r4, Network r5, long[][] r6) {
        this.numberOfRows = r6.length;
        this.numberOfColumns = r6[0].length;
        this.wrapRows = r2;
        this.wrapColumns = r3;
        this.neighbourhood = r4;
        this.network = r5;
        this.identifiers = r6;
    }

    public synchronized NeuronSquareMesh2D copy() {
        monitor-enter(this);
        long[][] r7 = (long[][]) Array.newInstance(Long.TYPE, new int[]{this.numberOfRows, this.numberOfColumns});     // Catch: Throwable -> L14
        int r0 = 0;
    L5:
        if (r0 >= this.numberOfRows) goto L11;
        int r2 = 0;
    L8:
        if (r2 >= this.numberOfColumns) goto L10;
        r7[r0][r2] = this.identifiers[r0][r2];     // Catch: Throwable -> L14
        r2 = r2 + 1;     // Catch: Throwable -> L14
        goto L8
    L10:
        r0 = r0 + 1;     // Catch: Throwable -> L14
        goto L5
    L11:
        NeuronSquareMesh2D r1 = new NeuronSquareMesh2D(this.wrapRows, this.wrapColumns, this.neighbourhood, this.network.copy(), r7);     // Catch: Throwable -> L14
        monitor-exit(this);
        return r1;
    L14:
        th = move-exception;
        throw th;
    }

    @Override // java.lang.Iterable
    public Iterator<Neuron> iterator() {
        return this.network.iterator();
    }

    public Network getNetwork() {
        return this.network;
    }

    public int getNumberOfRows() {
        return this.numberOfRows;
    }

    public int getNumberOfColumns() {
        return this.numberOfColumns;
    }

    public Neuron getNeuron(int r3, int r4) {
        if (r3 < 0) goto L14;
        if (r3 >= this.numberOfRows) goto L14;
        if (r4 < 0) goto L12;
        if (r4 >= this.numberOfColumns) goto L12;
        return this.network.getNeuron(this.identifiers[r3][r4]);
    L12:
        throw new OutOfRangeException(Integer.valueOf(r4), 0, Integer.valueOf(this.numberOfColumns - 1));
    L14:
        throw new OutOfRangeException(Integer.valueOf(r3), 0, Integer.valueOf(this.numberOfRows - 1));
    }

    public Neuron getNeuron(int r1, int r2, HorizontalDirection r3, VerticalDirection r4) {
        int[] r5 = getLocation(r1, r2, r3, r4);
        if (r5 != null) goto L6;
        return null;
    L6:
        return getNeuron(r5[0], r5[1]);
    }

    private int[] getLocation(int r6, int r7, HorizontalDirection r8, VerticalDirection r9) {
        int r10 = AnonymousClass1.$SwitchMap$org$apache$commons$math3$ml$neuralnet$twod$NeuronSquareMesh2D$HorizontalDirection[r8.ordinal()];
        int r0 = -1;
        if (r10 == 1) goto L10;
        if (r10 == 2) goto L9;
        if (r10 != 3) goto L8;
        int r11 = 0;
    L11:
        int r12 = r7 + r11;
        if (this.wrapColumns == false) goto L16;
        if (r12 >= 0) goto L15;
        r12 = r12 + this.numberOfColumns;
        goto L16
    L15:
        r12 = r12 % this.numberOfColumns;
    L16:
        int r13 = AnonymousClass1.$SwitchMap$org$apache$commons$math3$ml$neuralnet$twod$NeuronSquareMesh2D$VerticalDirection[r9.ordinal()];
        if (r13 == 1) goto L24;
        if (r13 == 2) goto L23;
        if (r13 != 3) goto L22;
        r0 = 0;
        goto L24
    L22:
        throw new MathInternalError();
    L23:
        r0 = 1;
    L24:
        int r14 = r6 + r0;
        if (this.wrapRows == false) goto L29;
        if (r14 >= 0) goto L28;
        r14 = r14 + this.numberOfRows;
        goto L29
    L28:
        r14 = r14 % this.numberOfRows;
    L29:
        if (r14 >= 0) goto L31;
        return null;
    L31:
        if (r14 >= this.numberOfRows) goto L40;
        if (r12 >= 0) goto L34;
        return null;
    L34:
        if (r12 < this.numberOfColumns) goto L37;
        return null;
    L37:
        return new int[]{r14, r12};
    L40:
        return null;
    L8:
        throw new MathInternalError();
    L9:
        r11 = 1;
        goto L11
    L10:
        r11 = -1;
        goto L11
    }

    private void createLinks() {
        ArrayList r0 = new ArrayList();
        int r1 = this.numberOfRows - 1;
        int r3 = this.numberOfColumns - 1;
        int r5 = 0;
    L4:
        if (r5 >= this.numberOfRows) goto L91;
        int r6 = 0;
    L7:
        if (r6 >= this.numberOfColumns) goto L90;
        r0.clear();
        int r7 = AnonymousClass1.$SwitchMap$org$apache$commons$math3$ml$neuralnet$SquareNeighbourhood[this.neighbourhood.ordinal()];
        if (r7 != 1) goto L11;
        if (r5 <= 0) goto L20;
        if (r6 <= 0) goto L18;
        r0.add(Long.valueOf(this.identifiers[r5 - 1][r6 - 1]));
    L18:
        if (r6 >= r3) goto L20;
        r0.add(Long.valueOf(this.identifiers[r5 - 1][r6 + 1]));
    L20:
        if (r5 >= r1) goto L26;
        if (r6 <= 0) goto L23;
        r0.add(Long.valueOf(this.identifiers[r5 + 1][r6 - 1]));
    L23:
        if (r6 >= r3) goto L26;
        r0.add(Long.valueOf(this.identifiers[r5 + 1][r6 + 1]));
    L26:
        if (this.wrapRows == false) goto L38;
        if (r5 != 0) goto L32;
        if (r6 <= 0) goto L30;
        r0.add(Long.valueOf(this.identifiers[r1][r6 - 1]));
    L30:
        if (r6 >= r3) goto L38;
        r0.add(Long.valueOf(this.identifiers[r1][r6 + 1]));
        goto L38
    L32:
        if (r5 != r1) goto L38;
        if (r6 <= 0) goto L35;
        r0.add(Long.valueOf(this.identifiers[0][r6 - 1]));
    L35:
        if (r6 >= r3) goto L38;
        r0.add(Long.valueOf(this.identifiers[0][r6 + 1]));
    L38:
        if (this.wrapColumns == false) goto L50;
        if (r6 != 0) goto L44;
        if (r5 <= 0) goto L42;
        r0.add(Long.valueOf(this.identifiers[r5 - 1][r3]));
    L42:
        if (r5 >= r1) goto L50;
        r0.add(Long.valueOf(this.identifiers[r5 + 1][r3]));
        goto L50
    L44:
        if (r6 != r3) goto L50;
        if (r5 <= 0) goto L47;
        r0.add(Long.valueOf(this.identifiers[r5 - 1][0]));
    L47:
        if (r5 >= r1) goto L50;
        r0.add(Long.valueOf(this.identifiers[r5 + 1][0]));
    L50:
        if (this.wrapRows == true) goto L52;
    L65:
        if (r5 <= 0) goto L67;
        r0.add(Long.valueOf(this.identifiers[r5 - 1][r6]));
    L67:
        if (r5 >= r1) goto L70;
        r0.add(Long.valueOf(this.identifiers[r5 + 1][r6]));
    L70:
        if (this.wrapRows == false) goto L75;
        if (r5 != 0) goto L73;
        r0.add(Long.valueOf(this.identifiers[r1][r6]));
        goto L75
    L73:
        if (r5 != r1) goto L75;
        r0.add(Long.valueOf(this.identifiers[0][r6]));
    L75:
        if (r6 <= 0) goto L77;
        r0.add(Long.valueOf(this.identifiers[r5][r6 - 1]));
    L77:
        if (r6 >= r3) goto L80;
        r0.add(Long.valueOf(this.identifiers[r5][r6 + 1]));
    L80:
        if (this.wrapColumns == false) goto L85;
        if (r6 != 0) goto L83;
        r0.add(Long.valueOf(this.identifiers[r5][r3]));
        goto L85
    L83:
        if (r6 != r3) goto L85;
        r0.add(Long.valueOf(this.identifiers[r5][0]));
    L85:
        Neuron r8 = this.network.getNeuron(this.identifiers[r5][r6]);
        Iterator r9 = r0.iterator();
    L87:
        if (r9.hasNext() == false) goto L89;
        this.network.addLink(r8, this.network.getNeuron(((Long) r9.next()).longValue()));
        goto L87
    L89:
        r6 = r6 + 1;
        goto L7
    L52:
        if (this.wrapColumns == false) goto L65;
        if (r5 != 0) goto L56;
        if (r6 != 0) goto L56;
        r0.add(Long.valueOf(this.identifiers[r1][r3]));
    L56:
        if (r5 != 0) goto L59;
        if (r6 != r3) goto L59;
        r0.add(Long.valueOf(this.identifiers[r1][0]));
    L59:
        if (r5 != r1) goto L62;
        if (r6 != 0) goto L62;
        r0.add(Long.valueOf(this.identifiers[0][r3]));
    L62:
        if (r5 != r1) goto L65;
        if (r6 != r3) goto L65;
        r0.add(Long.valueOf(this.identifiers[0][0]));
        goto L65
    L11:
        if (r7 == 2) goto L65;
        throw new MathInternalError();
    L90:
        r5 = r5 + 1;
        goto L4
    }

    private void readObject(ObjectInputStream r1) {
        throw new IllegalStateException();
    }

    private Object writeReplace() {
        double[][][] r0 = (double[][][]) Array.newInstance(double[].class, new int[]{this.numberOfRows, this.numberOfColumns});
        int r2 = 0;
    L4:
        if (r2 >= this.numberOfRows) goto L11;
        int r3 = 0;
    L7:
        if (r3 >= this.numberOfColumns) goto L9;
        r0[r2][r3] = getNeuron(r2, r3).getFeatures();
        r3 = r3 + 1;
        goto L7
    L9:
        r2 = r2 + 1;
        goto L4
    L11:
        return new SerializationProxy(this.wrapRows, this.wrapColumns, this.neighbourhood, r0);
    }
}
