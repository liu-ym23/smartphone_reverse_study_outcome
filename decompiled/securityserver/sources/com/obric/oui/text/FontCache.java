package com.obric.oui.text;

import android.util.SparseArray;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class FontCache {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile SparseArray f296a;
    public static volatile HashMap b;

    static {
        f296a = new SparseArray();
        f296a.put(1, "regular");
        f296a.put(2, "bold");
        f296a.put(3, "boldItalic");
        f296a.put(4, "italic");
        f296a.put(5, "light");
        f296a.put(6, "lightItalic");
        f296a.put(7, "medium");
        f296a.put(8, "mediumItalic");
        b = new HashMap();
        b.put("regular", 1);
        b.put("bold", 2);
        b.put("boldItalic", 3);
        b.put("italic", 4);
        b.put("light", 5);
        b.put("lightItalic", 6);
        b.put("medium", 7);
        b.put("mediumItalic", 8);
    }
}
