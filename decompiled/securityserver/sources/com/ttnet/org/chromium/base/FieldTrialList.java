package com.ttnet.org.chromium.base;

import com.ttnet.org.chromium.base.annotations.MainDex;

/* JADX INFO: loaded from: classes2.dex */
@MainDex
public class FieldTrialList {

    public interface Natives {
        boolean createFieldTrial(String r1, String r2);

        String findFullName(String r1);

        String getVariationParameter(String r1, String r2);

        void logActiveTrials();

        boolean trialExists(String r1);
    }

    private FieldTrialList() {
    }

    public static boolean createFieldTrial(String r1, String r2) {
        return FieldTrialListJni.get().createFieldTrial(r1, r2);
    }

    public static String findFullName(String r1) {
        return FieldTrialListJni.get().findFullName(r1);
    }

    public static String getVariationParameter(String r1, String r2) {
        return FieldTrialListJni.get().getVariationParameter(r1, r2);
    }

    public static void logActiveTrials() {
        FieldTrialListJni.get().logActiveTrials();
    }

    public static boolean trialExists(String r1) {
        return FieldTrialListJni.get().trialExists(r1);
    }
}
