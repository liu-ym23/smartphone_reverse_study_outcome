package androidx.constraintlayout.core.motion.utils;

import androidx.constraintlayout.core.motion.CustomAttribute;
import androidx.constraintlayout.core.motion.CustomVariable;
import java.io.PrintStream;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class KeyFrameArray {

    public static class CustomArray {
        private static final int EMPTY = 999;
        int count;
        int[] keys;
        CustomAttribute[] values;

        public CustomArray() {
            this.keys = new int[101];
            this.values = new CustomAttribute[101];
            clear();
        }

        public void append(int r3, CustomAttribute r4) {
            if (this.values[r3] == null) goto L5;
            remove(r3);
        L5:
            this.values[r3] = r4;
            int[] r5 = this.keys;
            int r0 = this.count;
            this.count = r0 + 1;
            r5[r0] = r3;
            Arrays.sort(r5);
        }

        public void clear() {
            Arrays.fill(this.keys, EMPTY);
            Arrays.fill(this.values, null);
            this.count = 0;
        }

        public void dump() {
            PrintStream r0 = System.out;
            r0.println("V: " + Arrays.toString(Arrays.copyOf(this.keys, this.count)));
            r0.print("K: [");
            int r1 = 0;
        L4:
            if (r1 >= this.count) goto L10;
            PrintStream r2 = System.out;
            StringBuilder r3 = new StringBuilder();
            if (r1 != 0) goto L8;
            String r4 = "";
        L9:
            r3.append(r4);
            r3.append(valueAt(r1));
            r2.print(r3.toString());
            r1 = r1 + 1;
            goto L4
        L8:
            r4 = ", ";
            goto L9
        L10:
            System.out.println("]");
        }

        public int keyAt(int r1) {
            return this.keys[r1];
        }

        public void remove(int r5) {
            this.values[r5] = null;
            int r0 = 0;
            int r1 = 0;
        L3:
            int r2 = this.count;
            if (r0 >= r2) goto L11;
            int[] r3 = this.keys;
            if (r5 != r3[r0]) goto L8;
            r3[r0] = EMPTY;
            r1 = r1 + 1;
        L8:
            if (r0 == r1) goto L10;
            r3[r0] = r3[r1];
        L10:
            r1 = r1 + 1;
            r0 = r0 + 1;
            goto L3
        L11:
            this.count = r2 - 1;
        }

        public int size() {
            return this.count;
        }

        public CustomAttribute valueAt(int r2) {
            return this.values[this.keys[r2]];
        }
    }

    public static class CustomVar {
        private static final int EMPTY = 999;
        int count;
        int[] keys;
        CustomVariable[] values;

        public CustomVar() {
            this.keys = new int[101];
            this.values = new CustomVariable[101];
            clear();
        }

        public void append(int r3, CustomVariable r4) {
            if (this.values[r3] == null) goto L5;
            remove(r3);
        L5:
            this.values[r3] = r4;
            int[] r5 = this.keys;
            int r0 = this.count;
            this.count = r0 + 1;
            r5[r0] = r3;
            Arrays.sort(r5);
        }

        public void clear() {
            Arrays.fill(this.keys, EMPTY);
            Arrays.fill(this.values, null);
            this.count = 0;
        }

        public void dump() {
            PrintStream r0 = System.out;
            r0.println("V: " + Arrays.toString(Arrays.copyOf(this.keys, this.count)));
            r0.print("K: [");
            int r1 = 0;
        L4:
            if (r1 >= this.count) goto L10;
            PrintStream r2 = System.out;
            StringBuilder r3 = new StringBuilder();
            if (r1 != 0) goto L8;
            String r4 = "";
        L9:
            r3.append(r4);
            r3.append(valueAt(r1));
            r2.print(r3.toString());
            r1 = r1 + 1;
            goto L4
        L8:
            r4 = ", ";
            goto L9
        L10:
            System.out.println("]");
        }

        public int keyAt(int r1) {
            return this.keys[r1];
        }

        public void remove(int r5) {
            this.values[r5] = null;
            int r0 = 0;
            int r1 = 0;
        L3:
            int r2 = this.count;
            if (r0 >= r2) goto L11;
            int[] r3 = this.keys;
            if (r5 != r3[r0]) goto L8;
            r3[r0] = EMPTY;
            r1 = r1 + 1;
        L8:
            if (r0 == r1) goto L10;
            r3[r0] = r3[r1];
        L10:
            r1 = r1 + 1;
            r0 = r0 + 1;
            goto L3
        L11:
            this.count = r2 - 1;
        }

        public int size() {
            return this.count;
        }

        public CustomVariable valueAt(int r2) {
            return this.values[this.keys[r2]];
        }
    }

    public static class FloatArray {
        private static final int EMPTY = 999;
        int count;
        int[] keys;
        float[][] values;

        public FloatArray() {
            this.keys = new int[101];
            this.values = new float[101][];
            clear();
        }

        public void append(int r3, float[] r4) {
            if (this.values[r3] == null) goto L5;
            remove(r3);
        L5:
            this.values[r3] = r4;
            int[] r5 = this.keys;
            int r0 = this.count;
            this.count = r0 + 1;
            r5[r0] = r3;
            Arrays.sort(r5);
        }

        public void clear() {
            Arrays.fill(this.keys, EMPTY);
            Arrays.fill(this.values, null);
            this.count = 0;
        }

        public void dump() {
            PrintStream r0 = System.out;
            r0.println("V: " + Arrays.toString(Arrays.copyOf(this.keys, this.count)));
            r0.print("K: [");
            int r1 = 0;
        L4:
            if (r1 >= this.count) goto L10;
            PrintStream r2 = System.out;
            StringBuilder r3 = new StringBuilder();
            if (r1 != 0) goto L8;
            String r4 = "";
        L9:
            r3.append(r4);
            r3.append(Arrays.toString(valueAt(r1)));
            r2.print(r3.toString());
            r1 = r1 + 1;
            goto L4
        L8:
            r4 = ", ";
            goto L9
        L10:
            System.out.println("]");
        }

        public int keyAt(int r1) {
            return this.keys[r1];
        }

        public void remove(int r5) {
            this.values[r5] = null;
            int r0 = 0;
            int r1 = 0;
        L3:
            int r2 = this.count;
            if (r0 >= r2) goto L11;
            int[] r3 = this.keys;
            if (r5 != r3[r0]) goto L8;
            r3[r0] = EMPTY;
            r1 = r1 + 1;
        L8:
            if (r0 == r1) goto L10;
            r3[r0] = r3[r1];
        L10:
            r1 = r1 + 1;
            r0 = r0 + 1;
            goto L3
        L11:
            this.count = r2 - 1;
        }

        public int size() {
            return this.count;
        }

        public float[] valueAt(int r2) {
            return this.values[this.keys[r2]];
        }
    }

    public KeyFrameArray() {
    }
}
