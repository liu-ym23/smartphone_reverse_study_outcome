package com.obric.olog.salvage;

/* JADX INFO: loaded from: classes4.dex */
public class ClassExistenceChecker {
    public ClassExistenceChecker() {
    }

    public static boolean isClassExists(String r0) {
        Class.forName(r0);     // Catch: ClassNotFoundException -> L5
        return true;
    L5:
        return false;
    }
}
