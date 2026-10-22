package com.obric.matrix.r.e;

import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: classes2.dex */
public class c {
    public static String a(long r1) {
        Date r0 = new Date(r1);
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(r0);
    }
}
