package android.app.clickviewtree;

import android.app.ObricActivityTaskManager;
import android.app.assist.AssistStructure;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemProperties;
import android.util.Log;
import java.util.ArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class ClickViewTreeReporter {
    private static final String TAG = "ClickViewTreeReporter";

    private static final class NodeStats {
        private int mMaxDepth;
        private final ArrayList<Integer> mNodesByDepth;
        private int mTotalNodes;

        /* synthetic */ NodeStats(ClickViewTreeReporterIA r1) {
            this();
        }

        private NodeStats() {
            this.mMaxDepth = -1;
            this.mNodesByDepth = new ArrayList();
        }

        void record(int depth) {
            this.mTotalNodes++;
            if (depth <= this.mMaxDepth) goto L6;
            this.mMaxDepth = depth;
        L6:
            if (this.mNodesByDepth.size() > depth) goto L8;
            this.mNodesByDepth.add(0);
            goto L6
        L8:
            this.mNodesByDepth.set(depth, Integer.valueOf(this.mNodesByDepth.get(depth).intValue() + 1));
        }

        String summary() {
            return "stats: nodes=" + this.mTotalNodes + " depth=" + (this.mMaxDepth + 1) + " dist=" + this.mNodesByDepth;
        }
    }

    private ClickViewTreeReporter() {
    }

    public static void report(ClickViewTreeRecord record) {
        if (record != null) goto L18;
        return;
    L18:
    L13:
        e = move-exception;
        if (isDebugEnabled() == false) goto L20;
        Log.w(TAG, "ClickViewTree[APP_REPORT] failed", e);
        return;
    L20:
        return;
    L5:
        if (record.event != null) goto L7;
        String eventId = null;
    L8:
        String fingerprint = buildFingerprint(record.event);     // Catch: Exception -> L13
        Bundle bundle = record.toBundle();     // Catch: Exception -> L13
        logReport(record, eventId, fingerprint, bundle);     // Catch: Exception -> L13
        if (isDebugJsonEnabled() == false) goto L11;
        logJson(record);     // Catch: Exception -> L13
    L11:
        ObricActivityTaskManager.reportClickViewTreeRecord(eventId, fingerprint, bundle, record.assistStructure);     // Catch: Exception -> L13
        return;
    L7:
        eventId = record.event.eventId;     // Catch: Exception -> L13
        goto L8
    }

    private static void logReport(ClickViewTreeRecord record, String eventId, String fingerprint, Bundle bundle) {
        if (isDebugEnabled() == true) goto L5;
        return;
    L5:
        ClickEventInfo event = record.event;
        String r1 = null;
        if (bundle != null) goto L8;
        String classification = null;
    L9:
        StringBuilder r3 = new StringBuilder().append("ClickViewTree[APP_REPORT] eventId=").append(eventId).append(" hasFingerprint=");
        boolean r4 = true;
        if (fingerprint == null) goto L12;
        boolean r6 = true;
    L13:
        StringBuilder r5 = r3.append(r6).append(" displayId=");
        if (event != null) goto L16;
        Integer r7 = null;
    L17:
        StringBuilder r8 = r5.append(r7).append(" status=").append(record.status).append(" clickClassification=").append(classification).append(" triggerSource=");
        if (event == null) goto L21;
        r1 = event.triggerSource;
    L21:
        StringBuilder r2 = r8.append(r1).append(" consumeReason=").append(record.consumeReason).append(" hasStructure=");
        if (record.assistStructure != null) goto L25;
        r4 = false;
    L25:
        Log.d(TAG, r2.append(r4).toString());
        return;
    L16:
        r7 = Integer.valueOf(event.displayId);
        goto L17
    L12:
        r6 = false;
        goto L13
    L8:
        classification = bundle.getString(ClickViewTreeConstants.KEY_CLICK_CLASSIFICATION);
        goto L9
    }

    private static boolean isDebugEnabled() {
        if (Build.IS_DEBUGGABLE == true) goto L5;
        return false;
    L5:
        if (SystemProperties.getBoolean(ClickViewTreeConstants.DEBUG_PROPERTY, false) == false) goto L9;
        return true;
    L9:
        return false;
    }

    private static boolean isDebugJsonEnabled() {
        if (isDebugEnabled() == true) goto L5;
        return false;
    L5:
        if (SystemProperties.getBoolean(ClickViewTreeConstants.DEBUG_JSON_PROPERTY, false) == false) goto L9;
        return true;
    L9:
        return false;
    }

    private static void logJson(ClickViewTreeRecord record) {
        if (record != null) goto L17;
        Log.d(TAG, "ClickViewTree[APP_JSON] record=null");
        return;
    L17:
        String scalarJson = new JSONObject(record.toJsonString()).toString(2);     // Catch: Exception -> L8
    L10:
        Log.d(TAG, "ClickViewTree[APP_JSON] scalarJson=\n" + scalarJson);
        if (record.assistStructure == null) goto L21;
        Log.d(TAG, "ClickViewTree[APP_STRUCTURE] structure=\n" + renderAssistStructure(record.assistStructure));     // Catch: Exception -> L14
        return;
    L14:
        e = move-exception;
        Log.w(TAG, "ClickViewTree[APP_STRUCTURE] failed", e);
        return;
    L21:
        return;
    L9:
        scalarJson = String.valueOf(record);
        goto L10
    }

    private static String buildFingerprint(ClickEventInfo event) {
        if (event != null) goto L4;
        return null;
    L4:
        if (Float.isNaN(event.rawX) == false) goto L6;
        return null;
    L6:
        if (Float.isNaN(event.rawY) == false) goto L8;
        return null;
    L8:
        if (event.source != null) goto L10;
        return null;
    L10:
        if (ClickViewTreeConstants.COORDINATE_SOURCE_INPUT_EVENT.equals(event.coordinateSource) == true) goto L13;
        return null;
    L13:
        return event.displayId + "|" + event.downTimeMillis + "|" + event.upTimeMillis + "|" + event.rawX + "|" + event.rawY + "|" + event.source;
    }

    private static String renderAssistStructure(AssistStructure structure) {
        if (structure != null) goto L5;
        return "<null>";
    L5:
        structure.ensureData();
        StringBuilder builder = new StringBuilder();
        NodeStats stats = new NodeStats(null);
        int windowCount = structure.getWindowNodeCount();
        int i = 0;
    L7:
        if (i >= windowCount) goto L9;
        AssistStructure.WindowNode window = structure.getWindowNodeAt(i);
        builder.append("window[").append(i).append("] ").append(window.getTitle()).append(" [").append(window.getLeft()).append(',').append(window.getTop()).append(' ').append(window.getWidth()).append('x').append(window.getHeight()).append("]\n");
        appendNode(builder, window.getRootViewNode(), 0, stats);
        i = i + 1;
        goto L7
    L9:
        builder.insert(0, stats.summary() + "\n");
        return builder.toString();
    }

    private static void appendNode(StringBuilder builder, AssistStructure.ViewNode node, int depth, NodeStats stats) {
        if (node != null) goto L5;
        return;
    L5:
        if (node.getClassName() != null) goto L7;
        return;
    L7:
        stats.record(depth);
        int i = 0;
    L8:
        if (i >= depth) goto L10;
        builder.append("  ");
        i = i + 1;
        goto L8
    L10:
        if (depth != 0) goto L12;
        String r0 = "* ";
    L13:
        builder.append(r0).append(node.getClassName());
        String idEntry = node.getIdEntry();
        if (idEntry == null) goto L16;
        builder.append(" id=").append(idEntry);
    L16:
        CharSequence desc = node.getContentDescription();
        if (desc == null) goto L19;
        builder.append(" desc=\"").append(desc).append('\"');
    L19:
        CharSequence text = node.getText();
        if (text == null) goto L23;
        builder.append(" text(len=").append(text.length()).append(')');
    L23:
        if (node.isClickable() == false) goto L25;
        builder.append(" clickable");
    L25:
        builder.append(" [").append(node.getLeft()).append(',').append(node.getTop()).append(' ').append(node.getWidth()).append('x').append(node.getHeight()).append("]\n");
        int childCount = node.getChildCount();
        int i2 = 0;
    L26:
        if (i2 >= childCount) goto L28;
        appendNode(builder, node.getChildAt(i2), depth + 1, stats);
        i2 = i2 + 1;
        goto L26
    L28:
        return;
    L12:
        r0 = "- ";
        goto L13
    }
}
