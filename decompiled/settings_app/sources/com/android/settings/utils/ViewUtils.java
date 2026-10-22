package com.android.settings.utils;

import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

/* JADX INFO: loaded from: classes2.dex */
public class ViewUtils {
    public ViewUtils() {
    }

    public static void setListViewHeightBasedOnChildren(ListView r6, BaseAdapter r7) {
        if (r6 != null) goto L4;
        return;
    L4:
        if (r7 != null) goto L6;
        return;
    L6:
        int r1 = 0;
        int r2 = 0;
        int r3 = 0;
    L8:
        if (r1 >= r7.getCount()) goto L13;
        View r4 = r7.getView(r1, null, r6);
        if (r4.getVisibility() != 0) goto L12;
        r4.measure(0, 0);
        r3 = r3 + r4.getMeasuredHeight();
        r2 = r2 + 1;
    L12:
        r1 = r1 + 1;
        goto L8
    L13:
        ViewGroup.LayoutParams r8 = r6.getLayoutParams();
        if (r2 == 0) goto L18;
        int r0 = r6.getDividerHeight();
        if (r0 <= 0) goto L18;
        r3 = r3 + (r0 * (r2 - 1));
    L18:
        r8.height = r3;
        r6.setLayoutParams(r8);
    }

    public static String breakTextIntoLines(String r18, int r19, TextPaint r20) {
        if (r18 != null) goto L5;
        return "";
    L5:
        if (r18.isEmpty() == true) goto L36;
        StringBuilder r1 = new StringBuilder();
        int r2 = r18.length();
        int r4 = 0;
    L8:
        if (r4 >= r2) goto L27;
        int r6 = r18.indexOf(10, r4);
        int r7 = -1;
        if (r6 != (-1)) goto L12;
        int r8 = r2;
    L13:
        String r5 = r18.substring(r4, r8);
        int r15 = r5.length();
        int r14 = 0;
    L14:
        if (r14 >= r15) goto L23;
        int r3 = r14;
        int r9 = r15;
        int r10 = r20.breakText(r5, r14, r15, true, r19, null);
        if (r10 > 0) goto L18;
        r10 = 1;
    L18:
        r14 = r3 + r10;
        r1.append(r5, r3, r14);
        if (r14 >= r9) goto L21;
        r1.append('\n');
    L21:
        r15 = r9;
        r7 = -1;
        goto L14
    L23:
        if (r6 == r7) goto L25;
        r1.append('\n');
    L25:
        r4 = r8 + 1;
        goto L8
    L12:
        r8 = r6;
        goto L13
    L27:
        return r1.toString();
    L36:
        return "";
    }
}
