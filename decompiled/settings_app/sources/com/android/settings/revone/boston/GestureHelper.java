package com.android.settings.revone.boston;

import android.content.Context;
import android.provider.Settings;
import com.android.settings.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class GestureHelper {
    public static int getDefaultValue(String r0) {
        return 1;
    }

    public GestureHelper() {
    }

    public static List<GestureGroup> getTouchpadGestures(Context r9) {
        ArrayList r0 = new ArrayList();
        GestureGroup r1 = new GestureGroup();
        r1.groupTitle = r9.getString(R.string.group_navigation);
        r1.items = new ArrayList();
        GestureGroup.GestureItem r2 = new GestureGroup.GestureItem(GestureKey.TOUCHPAD_GESTURE_NAV_BACK, r9.getString(R.string.nav_back), r9.getString(R.string.nav_back_touchpad_summary));
        GestureGroup.GestureItem r3 = new GestureGroup.GestureItem(GestureKey.TOUCHPAD_GESTURE_NAV_MENU, r9.getString(R.string.nav_menu_touchpad), r9.getString(R.string.nav_menu_touchpad_summary));
        boolean r6 = true;
        if (Settings.Global.getInt(r9.getContentResolver(), "touch_to_click", 1) == 1) goto L6;
        r6 = false;
    L6:
        String r7 = r9.getString(R.string.nav_menu_touchpad_2_fingers);
        if (r6 == false) goto L9;
        String r8 = r9.getString(R.string.nav_menu_touchpad_2_fingers_summary);
    L10:
        GestureGroup.GestureItem r4 = new GestureGroup.GestureItem(GestureKey.TOUCHPAD_GESTURE_NAV_MENU_2_FINGERS, r7, r8);
        r1.items.add(r2);
        r1.items.add(r3);
        r1.items.add(r4);
        r0.add(r1);
        GestureGroup r5 = new GestureGroup();
        r5.groupTitle = r9.getString(R.string.group_content);
        r5.items = new ArrayList();
        GestureGroup.GestureItem r10 = new GestureGroup.GestureItem(GestureKey.TOUCHPAD_GESTURE_ZOOM_CANVAS, r9.getString(R.string.content_zoom_canvas), r9.getString(R.string.content_zoom_canvas_summary));
        r10.setEditable(false);
        GestureGroup.GestureItem r11 = new GestureGroup.GestureItem(GestureKey.TOUCHPAD_GESTURE_SCROLL_CANVAS, r9.getString(R.string.content_scroll_canvas), r9.getString(R.string.content_scroll_canvas_summary));
        r11.setEditable(false);
        GestureGroup.GestureItem r12 = new GestureGroup.GestureItem(GestureKey.TOUCHPAD_GESTURE_SELECT_TEXT, r9.getString(R.string.content_select_text), r9.getString(R.string.content_select_text_summary));
        r12.setEditable(false);
        r5.items.add(r10);
        r5.items.add(r11);
        r5.items.add(r12);
        r0.add(r5);
        GestureGroup r13 = new GestureGroup();
        r13.groupTitle = r9.getString(R.string.group_shortcut);
        r13.items = new ArrayList();
        new GestureGroup.GestureItem(GestureKey.TOUCHPAD_GESTURE_MAGIC_FLOW, r9.getString(R.string.shortcut_magic_flow), r9.getString(R.string.shortcut_magic_flow_touchpad_summary));
        new GestureGroup.GestureItem(GestureKey.TOUCHPAD_GESTURE_CONTROL_CENTER, r9.getString(R.string.shortcut_control_center), r9.getString(R.string.shortcut_control_center_touchpad_summary));
        GestureGroup r14 = new GestureGroup();
        r14.groupTitle = r9.getString(R.string.group_window);
        r14.items = new ArrayList();
        GestureGroup.GestureItem r15 = new GestureGroup.GestureItem(GestureKey.TOUCHPAD_GESTURE_WINDOW_MOVE, r9.getString(R.string.window_move), r9.getString(R.string.window_move_touchpad_summary));
        GestureGroup.GestureItem r16 = new GestureGroup.GestureItem(GestureKey.TOUCHPAD_GESTURE_WINDOW_MAX, r9.getString(R.string.window_max), r9.getString(R.string.window_max_summary));
        GestureGroup.GestureItem r17 = new GestureGroup.GestureItem(GestureKey.TOUCHPAD_GESTURE_WINDOW_RESET, r9.getString(R.string.window_reset), r9.getString(R.string.window_reset_summary));
        GestureGroup.GestureItem r18 = new GestureGroup.GestureItem(GestureKey.TOUCHPAD_GESTURE_WINDOW_MIN, r9.getString(R.string.window_min), r9.getString(R.string.window_min_summary));
        r14.items.add(r15);
        r14.items.add(r16);
        r14.items.add(r17);
        r14.items.add(r18);
        r0.add(r14);
        GestureGroup r19 = new GestureGroup();
        r19.groupTitle = r9.getString(R.string.group_task);
        r19.items = new ArrayList();
        new GestureGroup.GestureItem(GestureKey.TOUCHPAD_GESTURE_TASK_MANAGER, r9.getString(R.string.task_open_manager), r9.getString(R.string.task_open_manager_touchpad_summary));
        GestureGroup.GestureItem r20 = new GestureGroup.GestureItem(GestureKey.TOUCHPAD_GESTURE_TASK_MANAGER_4_FINGERS, r9.getString(R.string.task_open_manager_4fingers), r9.getString(R.string.task_open_manager_4fingers_summary));
        new GestureGroup.GestureItem(GestureKey.TOUCHPAD_GESTURE_SWITCH_TASK, r9.getString(R.string.task_switch), r9.getString(R.string.task_switch_summary));
        r19.items.add(r20);
        r0.add(r19);
        return r0;
    L9:
        r8 = r9.getString(R.string.nav_menu_touchpad_2_fingers_summary_click);
        goto L10
    }

    public static List<GestureGroup> getScreenGestures(Context r9) {
        ArrayList r0 = new ArrayList();
        GestureGroup r1 = new GestureGroup();
        r1.groupTitle = r9.getString(R.string.group_navigation);
        r1.items = new ArrayList();
        GestureGroup.GestureItem r2 = new GestureGroup.GestureItem(GestureKey.SCREEN_GESTURE_NAV_BACK, r9.getString(R.string.nav_back), r9.getString(R.string.nav_back_summary));
        GestureGroup.GestureItem r3 = new GestureGroup.GestureItem(GestureKey.SCREEN_GESTURE_NAV_MENU, r9.getString(R.string.nav_menu), r9.getString(R.string.nav_menu_summary));
        r1.items.add(r2);
        r1.items.add(r3);
        r0.add(r1);
        GestureGroup r4 = new GestureGroup();
        r4.groupTitle = r9.getString(R.string.group_content);
        r4.items = new ArrayList();
        GestureGroup.GestureItem r5 = new GestureGroup.GestureItem(GestureKey.SCREEN_GESTURE_ZOOM_CANVAS, r9.getString(R.string.content_zoom_canvas), r9.getString(R.string.content_zoom_canvas_summary));
        r5.setEditable(false);
        GestureGroup.GestureItem r6 = new GestureGroup.GestureItem(GestureKey.SCREEN_GESTURE_SCROLL_CANVAS, r9.getString(R.string.content_scroll_canvas), r9.getString(R.string.content_scroll_canvas_summary));
        r6.setEditable(false);
        r4.items.add(r5);
        r4.items.add(r6);
        r0.add(r4);
        GestureGroup r7 = new GestureGroup();
        r7.groupTitle = r9.getString(R.string.group_shortcut);
        r7.items = new ArrayList();
        new GestureGroup.GestureItem(GestureKey.SCREEN_GESTURE_MAGIC_FLOW, r9.getString(R.string.shortcut_magic_flow), r9.getString(R.string.shortcut_magic_flow_summary));
        GestureGroup.GestureItem r8 = new GestureGroup.GestureItem(GestureKey.SCREEN_GESTURE_CONTROL_CENTER, r9.getString(R.string.shortcut_control_center), r9.getString(R.string.shortcut_control_center_summary));
        r7.items.add(r8);
        r0.add(r7);
        GestureGroup r10 = new GestureGroup();
        r10.groupTitle = r9.getString(R.string.group_window);
        r10.items = new ArrayList();
        GestureGroup.GestureItem r11 = new GestureGroup.GestureItem(GestureKey.SCREEN_GESTURE_WINDOW_MOVE, r9.getString(R.string.window_move), r9.getString(R.string.window_move_summary));
        GestureGroup.GestureItem r12 = new GestureGroup.GestureItem(GestureKey.SCREEN_GESTURE_WINDOW_MAX, r9.getString(R.string.window_max), r9.getString(R.string.window_max_summary));
        GestureGroup.GestureItem r13 = new GestureGroup.GestureItem(GestureKey.SCREEN_GESTURE_WINDOW_RESET, r9.getString(R.string.window_reset), r9.getString(R.string.window_reset_summary));
        GestureGroup.GestureItem r14 = new GestureGroup.GestureItem(GestureKey.SCREEN_GESTURE_WINDOW_MIN, r9.getString(R.string.window_min), r9.getString(R.string.window_min_summary));
        r10.items.add(r11);
        r10.items.add(r12);
        r10.items.add(r13);
        r10.items.add(r14);
        r0.add(r10);
        GestureGroup r15 = new GestureGroup();
        r15.groupTitle = r9.getString(R.string.group_task);
        r15.items = new ArrayList();
        new GestureGroup.GestureItem(GestureKey.SCREEN_GESTURE_TASK_MANAGER, r9.getString(R.string.task_open_manager), r9.getString(R.string.task_open_manager_summary));
        GestureGroup.GestureItem r16 = new GestureGroup.GestureItem(GestureKey.SCREEN_GESTURE_TASK_MANAGER_4_FINGERS, r9.getString(R.string.task_open_manager_4fingers), r9.getString(R.string.task_open_manager_4fingers_summary));
        new GestureGroup.GestureItem(GestureKey.SCREEN_GESTURE_SWITCH_TASK, r9.getString(R.string.task_switch), r9.getString(R.string.task_switch_summary));
        r15.items.add(r16);
        r0.add(r15);
        return r0;
    }

    public static boolean isCheckboxEnabled(String r1) {
        if (GestureKey.SCREEN_GESTURE_ZOOM_CANVAS.equals(r1) == false) goto L5;
        return false;
    L5:
        if (GestureKey.SCREEN_GESTURE_SCROLL_CANVAS.equals(r1) == false) goto L7;
        return false;
    L7:
        if (GestureKey.TOUCHPAD_GESTURE_ZOOM_CANVAS.equals(r1) == false) goto L9;
        return false;
    L9:
        if (GestureKey.TOUCHPAD_GESTURE_SCROLL_CANVAS.equals(r1) == false) goto L11;
        return false;
    L11:
        if (GestureKey.TOUCHPAD_GESTURE_SELECT_TEXT.equals(r1) == true) goto L20;
        return true;
    L20:
        return false;
    }
}
