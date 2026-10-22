package com.bytedance.apm.agent.instrumentation;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Keep;
import com.bytedance.apm.o.b.a;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class ClickInstrumentation {
    private static final String ACTION_NAME = "view_click";
    private static final String CLICK_TYPE = "click_type";
    private static final String VIEW_ID = "view_id";
    private static final String VIEW_NAME = "view_name";
    private static final String VIEW_TEXT = "view_text";
    private static final int VIEW_TEXT_LENGTH_LIMIT = 100;

    public ClickInstrumentation() {
    }

    @Keep
    public static void onClick(View r5) {
        if (r5 != null) goto L45;
        return;
    L45:
        JSONObject r1 = new JSONObject();     // Catch: Exception -> L42
        Resources r2 = r5.getContext().getResources();     // Catch: Exception -> L42
        if (r5.getId() == (-1)) goto L9;
        r1.put(VIEW_ID, r5.getId());     // Catch: Exception -> L42
        r1.put(VIEW_NAME, r2.getResourceEntryName(r5.getId()));     // Catch: Exception -> L42
    L9:
        if ((r5 instanceof TextView) == false) goto L17;
        CharSequence r3 = ((TextView) r5).getText();     // Catch: Exception -> L42
        if (r3 == null) goto L17;
        String r4 = r3.toString();     // Catch: Exception -> L42
        if (r4.length() <= 100) goto L15;
        r4 = r4.substring(0, 100);     // Catch: Exception -> L42
    L15:
        r1.put(VIEW_TEXT, r4);     // Catch: Exception -> L42
    L17:
        if (r5.getParent() == null) goto L23;
        String r6 = r5.getParent().getClass().getSimpleName();     // Catch: Exception -> L42
        if (r5.getParent().getParent() == null) goto L21;
        r6 = r5.getParent().getParent().getClass().getSimpleName() + "#" + r6 + "#" + r5.getClass().getSimpleName();     // Catch: Exception -> L42
    L21:
        r1.put("view_path", r6);     // Catch: Exception -> L42
    L23:
        if (r5.getTag(-16777215) == null) goto L28;
        if (TextUtils.isEmpty(r5.getTag(-16777215).toString()) == true) goto L28;
        r1.put("view_tag_1", r5.getTag(-16777215).toString());     // Catch: Exception -> L42
    L28:
        if (r5.getTag(-16777214) == null) goto L33;
        if (TextUtils.isEmpty(r5.getTag(-16777214).toString()) == true) goto L33;
        r1.put("view_tag_2", r5.getTag(-16777214).toString());     // Catch: Exception -> L42
    L33:
        if (r5.getTag(-16777213) != null) goto L35;
    L40:
        r1.put(CLICK_TYPE, "View#OnClick");     // Catch: Exception -> L42
        a.c(ACTION_NAME, "", r1);     // Catch: Exception -> L42
        return;
    L35:
        if ((r5.getTag(-16777213) instanceof Map) == false) goto L40;
        Iterator r7 = ((Map) r5.getTag(-16777213)).entrySet().iterator();     // Catch: Exception -> L42
    L38:
        if (r7.hasNext() == false) goto L40;
        Map.Entry r0 = (Map.Entry) r7.next();     // Catch: Exception -> L42
        r1.put("view_tag_map_" + r0.getKey().toString(), r0.getValue().toString());     // Catch: Exception -> L42
    L42:
        e = move-exception;
        e.printStackTrace();
    }

    @Keep
    public static void onTabChanged(String r2) {
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L4
        r0.put(VIEW_NAME, r2);     // Catch: Exception -> L4
        r0.put(CLICK_TYPE, "TabHost#OnTabChanged");     // Catch: Exception -> L4
        a.c(ACTION_NAME, "", r0);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }
}
