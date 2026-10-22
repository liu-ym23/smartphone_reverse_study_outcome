package com.bytedance.perf.collector;

import android.util.Log;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.block.trace.MethodCollector;
import com.bytedance.apm.block.trace.MethodItem;
import com.bytedance.apm.logging.MethodLogger;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes.dex */
public class TraceDataUtils {
    private static final String TAG = "TraceDataUtils";

    public interface IStructuredDataFilter {
        void fallback(List<MethodItem> r1, int r2);

        int getFilterMaxCount();

        boolean isFilter(long r1, int r3);
    }

    public static final class TreeNode {
        TreeNode father;
        MethodItem item;
        LinkedList<TreeNode> nextNode;

        public TreeNode(MethodItem r2, TreeNode r3) {
            this.nextNode = new LinkedList();
            this.item = r2;
            this.father = r3;
        }

        public static /* synthetic */ int access$000(TreeNode r0) {
            return r0.depth();
        }

        public static /* synthetic */ void access$100(TreeNode r0, TreeNode r1) {
            r0.add(r1);
        }

        private void add(TreeNode r1) {
            this.nextNode.addFirst(r1);
        }

        private int depth() {
            MethodItem r0 = this.item;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.depth;
        }

        private boolean isLeaf() {
            return this.nextNode.isEmpty();
        }
    }

    public TraceDataUtils() {
    }

    private static int addMethodItem(LinkedList<MethodItem> r3, MethodItem r4) {
        if (ApmContext.isDebugMode() == false) goto L6;
        Log.v(TAG, "method:" + r4);
    L6:
        if (r3.isEmpty() == true) goto L8;
        MethodItem r0 = r3.peek();
    L9:
        if (r0 != null) goto L11;
    L20:
        r3.push(r4);
        return r4.durTime;
    L11:
        if (r0.methodId != r4.methodId) goto L20;
        int r1 = r0.depth;
        int r2 = r4.depth;
        if (r1 != r2) goto L20;
        if (r2 == 0) goto L20;
        int r5 = r4.durTime;
        if (r5 != 5000) goto L18;
        r5 = r0.durTime;
    L18:
        r4.durTime = r5;
        r0.mergeMore(r5);
        return r0.durTime;
    L8:
        r0 = null;
        goto L9
    }

    public static int countTreeNode(TreeNode r2) {
        int r0 = r2.nextNode.size();
        Iterator<TreeNode> r3 = r2.nextNode.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r0 = r0 + countTreeNode(r3.next());
        goto L4
    L6:
        return r0;
    }

    public static int getMethodId(long r2) {
        return (int) ((r2 >> 43) & 1048575);
    }

    private static long getTime(long r2) {
        return r2 & 8796093022207L;
    }

    @Deprecated
    public static String getTreeKey(List<MethodItem> r2, final int r3) {
        StringBuilder r0 = new StringBuilder();
        LinkedList r1 = new LinkedList(r2);
        trimStack(r1, r3, new AnonymousClass1(r3));
        Iterator r4 = r1.iterator();
    L4:
        if (r4.hasNext() == false) goto L7;
        r0.append(((MethodItem) r4.next()).methodId + "|");
        goto L4
    L7:
        return r0.toString();
    }

    private static boolean isIn(long r2) {
        if (((r2 >> 63) & 1) != 1) goto L5;
        return true;
    L5:
        return false;
    }

    public static void printTree(TreeNode r2, StringBuilder r3) {
        r3.append("|*   TraceStack: ");
        r3.append("\n");
        printTree(r2, 0, r3, "|*        ");
    }

    private static void rechange(TreeNode r5) {
        if (r5.nextNode.isEmpty() == false) goto L5;
        return;
    L5:
        int r0 = r5.nextNode.size();
        TreeNode[] r1 = new TreeNode[r0];
        r5.nextNode.toArray(r1);
        r5.nextNode.clear();
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L8;
        TreeNode r3 = r1[r2];
        r5.nextNode.addFirst(r3);
        rechange(r3);
        r2 = r2 + 1;
        goto L6
    }

    public static void simplyTrimStack(List<MethodItem> r1, int r2) {
        if (r2 >= 0) goto L5;
        r1.clear();
        return;
    L5:
        ListIterator<MethodItem> r3 = r1.listIterator(r1.size());
    L7:
        if (r3.hasPrevious() == false) goto L11;
        if (r3.previous().durTime >= r2) goto L7;
        r3.remove();
        goto L7
    }

    public static long stackToString(LinkedList<MethodItem> r5, StringBuilder r6) {
        Iterator<MethodItem> r7 = r5.iterator();
        long r0 = 0;
    L4:
        if (r7.hasNext() == false) goto L8;
        MethodItem r2 = r7.next();
        r6.append(r2.toString());
        r6.append('\n');
        int r3 = r2.durTime;
        if (r0 >= r3) goto L4;
        r0 = r3;
        goto L4
    L8:
        return r0;
    }

    public static int stackToTree(LinkedList<MethodItem> r6, TreeNode r7) {
        ListIterator<MethodItem> r8 = r6.listIterator(0);
        TreeNode r1 = null;
        int r2 = 0;
    L4:
        if (r8.hasNext() == false) goto L31;
        TreeNode r3 = new TreeNode(r8.next(), r1);
        r2 = r2 + 1;
        if (r1 == null) goto L8;
    L13:
        int r4 = TreeNode.access$000(r3);
        if (r1 == null) goto L29;
        if (r4 == 0) goto L29;
        if (TreeNode.access$000(r1) < r4) goto L28;
    L19:
        if (r1 == null) goto L23;
        if (TreeNode.access$000(r1) <= r4) goto L23;
        r1 = r1.father;
    L23:
        if (r1 == null) goto L4;
        TreeNode r5 = r1.father;
        if (r5 == null) goto L30;
        r3.father = r5;
        TreeNode.access$100(r1.father, r3);
    L30:
        r1 = r3;
        goto L4
    L28:
        TreeNode.access$100(r1, r3);
    L29:
        TreeNode.access$100(r7, r3);
        goto L30
    L8:
        if (TreeNode.access$000(r3) == 0) goto L13;
        if (ApmContext.isDebugMode() == false) goto L12;
        MethodLogger.e(TAG, "[stackToTree] SceneMethodsInfo begin error! why the first node'depth is not 0!", new Object[0]);
    L12:
        return 0;
    L31:
        MethodLogger.i("SceneMethodsInfo", "[stackToTree] count [%d] ", new Object[]{Integer.valueOf(r2)});
        return r2;
    }

    public static void structuredDataToStack(long[] r7, LinkedList<MethodItem> r8, long r9, int r11) {
        structuredDataToStack(MethodCollector.METHOD_ID_DISPATCH, r7, r8, true, r9, r11);
    }

    private static void treeToStack(TreeNode r3, LinkedList<MethodItem> r4) {
        LinkedList r0 = new LinkedList();
    L3:
        if (r3 == null) goto L13;
        MethodItem r1 = r3.item;
        if (r1 == null) goto L7;
        r4.add(r1);
    L7:
        LinkedList<TreeNode> r5 = r3.nextNode;
        if (r5.isEmpty() == true) goto L12;
        int r2 = r5.size() - 1;
    L10:
        if (r2 < 0) goto L12;
        r0.add(r5.get(r2));
        r2 = r2 - 1;
    L12:
        r3 = (TreeNode) r0.pollLast();
        goto L3
    }

    public static void trimStack(List<MethodItem> r1, int r2) {
        ListIterator<MethodItem> r3 = r1.listIterator(r1.size());
    L4:
        if (r3.hasPrevious() == false) goto L10;
        MethodItem r0 = r3.previous();
        if (r0 == null) goto L4;
        if (r0.durTime >= r2) goto L4;
        r3.remove();
        goto L4
    }

    public static void structuredDataToStack(long[] r7, LinkedList<MethodItem> r8, boolean r9, long r10) {
        structuredDataToStack(MethodCollector.METHOD_ID_DISPATCH, r7, r8, r9, r10, -1);
    }

    public static void printTree(TreeNode r4, int r5, StringBuilder r6, String r7) {
        StringBuilder r0 = new StringBuilder(r7);
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r2 > r5) goto L6;
        r0.append("    ");
        r2 = r2 + 1;
    L6:
        if (r1 >= r4.nextNode.size()) goto L11;
        TreeNode r3 = r4.nextNode.get(r1);
        r6.append(r0.toString());
        r6.append(r3.item.methodId);
        r6.append("[");
        r6.append(r3.item.durTime);
        r6.append("]");
        r6.append("\n");
        if (r3.nextNode.isEmpty() == true) goto L10;
        printTree(r3, r5 + 1, r6, r7);
    L10:
        r1 = r1 + 1;
        goto L6
    }

    public static void structuredDataToStack(int r25, long[] r26, LinkedList<MethodItem> r27, boolean r28, long r29, int r31) {
        if (r26 != null) goto L5;
        return;
    L5:
        if (r26.length == 0) goto L113;
        int r4 = 1;
        long r7 = 0;
        if (r26[r26.length - 1] == 0) goto L10;
        long r5 = getTime(r26[r26.length - 1]);
    L11:
        int r9 = 0;
    L13:
        if (r9 >= r26.length) goto L18;
        if (getTime(r26[r9]) < r5) goto L18;
        r9 = r9 + 1;
    L18:
        if (r25 > 0) goto L20;
        int r6 = MethodCollector.METHOD_ID_DISPATCH;
    L21:
        LinkedList r8 = new LinkedList();
        int r10 = 0;
        int r11 = 0;
    L23:
        if (r9 >= r26.length) goto L73;
        long r15 = r26[r9];
        if (r7 != r15) goto L27;
    L26:
        long r17 = r7;
    L72:
        r9 = r9 + 1;
        r7 = r17;
        r4 = 1;
        goto L23
    L27:
        if (r28 == false) goto L38;
        if (isIn(r15) == true) goto L31;
    L33:
        if (r11 != 0) goto L38;
        if (getMethodId(r15) <= 1048000) goto L26;
        MethodLogger.i("SceneMethodsInfo", "s2 pass this method[%s], isIn [%b] ", new Object[]{Integer.valueOf(getMethodId(r15)), Boolean.valueOf(isIn(r15))});
        goto L26
    L31:
        if (r6 != getMethodId(r15)) goto L33;
        r11 = r4;
    L38:
        if (isIn(r15) == true) goto L40;
        int r12 = getMethodId(r15);
        if (r8.isEmpty() == true) goto L69;
        Long r13 = (Long) r8.pop();
        long r14 = r13.longValue();
        r10 = r10 - 1;
        LinkedList r16 = new LinkedList();
        r16.push(r13);
    L47:
        int r18 = getMethodId(r14);
        if (r18 == r12) goto L55;
        if (r8.isEmpty() == true) goto L55;
        if (ApmContext.isDebugMode() == false) goto L54;
        MethodLogger.w(TAG, "pop inMethodId[%s] to continue match ouMethodId[%s]", new Object[]{Integer.valueOf(r18), Integer.valueOf(r12)});
    L54:
        Long r19 = (Long) r8.pop();
        r14 = r19.longValue();
        r10 = r10 - 1;
        r16.push(r19);
    L55:
        if (r18 == r12) goto L58;
        if (r18 != r6) goto L58;
        ApmContext.isDebugMode();
        r8.addAll(r16);
        r10 = r10 + r8.size();
    L43:
        r17 = 0;
    L58:
        long r110 = MethodCollector.getDiffTime() + getTime(r15);
    L60:
        if (r16.size() == 0) goto L43;
        long r22 = MethodCollector.getDiffTime() + getTime(((Long) r16.pop()).longValue());
        long r111 = r110 - r22;
        if (r111 < 0) goto L64;
        addMethodItem(r27, new MethodItem(r12, (int) r111, r22, r10));
        goto L60
    L64:
        if (ApmContext.isDebugMode() == false) goto L66;
        MethodLogger.e(TAG, "[structuredDataToStack] trace during invalid:%d", new Object[]{Long.valueOf(r111)});
    L66:
        r8.clear();
        r27.clear();
        return;
    L69:
        r17 = 0;
        if (ApmContext.isDebugMode() == false) goto L72;
        MethodLogger.w(TAG, "[structuredDataToStack] method[%s] not found in! ", new Object[]{Integer.valueOf(r12)});
        goto L72
    L40:
        if (getMethodId(r15) != r6) goto L42;
        r8.clear();
        r10 = 0;
    L42:
        r10 = r10 + r4;
        r8.push(Long.valueOf(r15));
        goto L43
    L73:
        MethodLogger.i("SceneMethodsInfo", "structuredDataToStack inner, result.size: " + r27.size() + ", " + r8.size(), new Object[0]);
    L75:
        if (r8.isEmpty() == true) goto L86;
        long r3 = ((Long) r8.pop()).longValue();
        int r112 = getMethodId(r3);
        boolean r0 = isIn(r3);
        long r113 = MethodCollector.getDiffTime() + getTime(r3);
        if (ApmContext.isDebugMode() == false) goto L79;
        MethodLogger.w(TAG, "[structuredDataToStack] has never out method[%s], isIn:%s, inTime:%s, endTime:%s,rawData size:%s", new Object[]{Integer.valueOf(r112), Boolean.valueOf(r0), Long.valueOf(r113), Long.valueOf(r29), Integer.valueOf(r8.size())});
    L79:
        if (r0 == false) goto L81;
        if (r31 <= 0) goto L85;
        if (r10 > r31) goto L75;
    L85:
        addMethodItem(r27, new MethodItem(r112, (int) (r29 - r113), r113, r8.size()));
        goto L75
    L81:
        if (ApmContext.isDebugMode() == false) goto L75;
        MethodLogger.e(TAG, "[structuredDataToStack] why has out Method[%s]? is wrong! ", new Object[]{Integer.valueOf(r112)});
        goto L75
    L86:
        TreeNode r1 = new TreeNode(null, null);
        stackToTree(r27, r1);
        r27.clear();
        treeToStack(r1, r27);
        return;
    L20:
        r6 = r25;
        goto L21
    L10:
        r5 = Long.MAX_VALUE;
        goto L11
    }

    public static void trimStack(List<MethodItem> r5, int r6, IStructuredDataFilter r7) {
        if (r6 >= 0) goto L5;
        r5.clear();
        return;
    L5:
        int r0 = r5.size();
        int r1 = 1;
    L6:
        if (r0 <= r6) goto L17;
        ListIterator<MethodItem> r2 = r5.listIterator(r5.size());
    L9:
        if (r2.hasPrevious() == false) goto L15;
        if (r7.isFilter(r2.previous().durTime, r1) == false) goto L9;
        r2.remove();
        r0 = r0 - 1;
        if (r0 > r6) goto L9;
        return;
    L15:
        r0 = r5.size();
        r1 = r1 + 1;
        if (r7.getFilterMaxCount() >= r1) goto L6;
    L17:
        int r3 = r5.size();
        if (r3 <= r6) goto L30;
        r7.fallback(r5, r3);
        return;
    }

    public static String getTreeKey(List<MethodItem> r6, long r7) {
        StringBuilder r0 = new StringBuilder();
        long r8 = (long) (r7 * 0.3f);
        LinkedList r1 = new LinkedList();
        Iterator<MethodItem> r2 = r6.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        MethodItem r3 = r2.next();
        if (r3.durTime < r8) goto L4;
        r1.add(r3);
        goto L4
    L8:
        Collections.sort(r1, new AnonymousClass2());
        if (r1.isEmpty() == false) goto L14;
        if (r6.isEmpty() == true) goto L14;
        r1.add(r6.get(0));
    L18:
        Iterator r9 = r1.iterator();
        if (r9.hasNext() == false) goto L22;
        r0.append(((MethodItem) r9.next()).methodId + "\n");
    L22:
        return r0.toString();
    L14:
        if (r1.size() <= 1) goto L18;
        if (((MethodItem) r1.peek()).methodId != 1048574) goto L18;
        r1.removeFirst();
        goto L18
    }
}
