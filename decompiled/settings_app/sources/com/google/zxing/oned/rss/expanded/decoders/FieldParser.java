package com.google.zxing.oned.rss.expanded.decoders;

import com.bytedance.apm.constant.CommonServiceName;
import com.google.zxing.NotFoundException;

/* JADX INFO: loaded from: classes4.dex */
final class FieldParser {
    private static final Object[][] FOUR_DIGIT_DATA_LENGTH = null;
    private static final Object[][] THREE_DIGIT_DATA_LENGTH = null;
    private static final Object[][] THREE_DIGIT_PLUS_DIGIT_DATA_LENGTH = null;
    private static final Object[][] TWO_DIGIT_DATA_LENGTH = null;
    private static final Object VARIABLE_LENGTH = null;

    static {
        Object r0 = new Object();
        VARIABLE_LENGTH = r0;
        TWO_DIGIT_DATA_LENGTH = new Object[][]{new Object[]{"00", 18}, new Object[]{"01", 14}, new Object[]{"02", 14}, new Object[]{"10", r0, 20}, new Object[]{CommonServiceName.CRONET_ERROR_CODE_CANCEL, 6}, new Object[]{"12", 6}, new Object[]{"13", 6}, new Object[]{"15", 6}, new Object[]{"17", 6}, new Object[]{"20", 2}, new Object[]{"21", r0, 20}, new Object[]{"22", r0, 29}, new Object[]{"30", r0, 8}, new Object[]{"37", r0, 8}, new Object[]{"90", r0, 30}, new Object[]{"91", r0, 30}, new Object[]{"92", r0, 30}, new Object[]{"93", r0, 30}, new Object[]{"94", r0, 30}, new Object[]{"95", r0, 30}, new Object[]{"96", r0, 30}, new Object[]{"97", r0, 30}, new Object[]{"98", r0, 30}, new Object[]{"99", r0, 30}};
        THREE_DIGIT_DATA_LENGTH = new Object[][]{new Object[]{"240", r0, 30}, new Object[]{"241", r0, 30}, new Object[]{"242", r0, 6}, new Object[]{"250", r0, 30}, new Object[]{"251", r0, 30}, new Object[]{"253", r0, 17}, new Object[]{"254", r0, 20}, new Object[]{"400", r0, 30}, new Object[]{"401", r0, 30}, new Object[]{"402", 17}, new Object[]{"403", r0, 30}, new Object[]{"410", 13}, new Object[]{"411", 13}, new Object[]{"412", 13}, new Object[]{"413", 13}, new Object[]{"414", 13}, new Object[]{"420", r0, 20}, new Object[]{"421", r0, 15}, new Object[]{"422", 3}, new Object[]{"423", r0, 15}, new Object[]{"424", 3}, new Object[]{"425", 3}, new Object[]{"426", 3}};
        THREE_DIGIT_PLUS_DIGIT_DATA_LENGTH = new Object[][]{new Object[]{"310", 6}, new Object[]{"311", 6}, new Object[]{"312", 6}, new Object[]{"313", 6}, new Object[]{"314", 6}, new Object[]{"315", 6}, new Object[]{"316", 6}, new Object[]{"320", 6}, new Object[]{"321", 6}, new Object[]{"322", 6}, new Object[]{"323", 6}, new Object[]{"324", 6}, new Object[]{"325", 6}, new Object[]{"326", 6}, new Object[]{"327", 6}, new Object[]{"328", 6}, new Object[]{"329", 6}, new Object[]{"330", 6}, new Object[]{"331", 6}, new Object[]{"332", 6}, new Object[]{"333", 6}, new Object[]{"334", 6}, new Object[]{"335", 6}, new Object[]{"336", 6}, new Object[]{"340", 6}, new Object[]{"341", 6}, new Object[]{"342", 6}, new Object[]{"343", 6}, new Object[]{"344", 6}, new Object[]{"345", 6}, new Object[]{"346", 6}, new Object[]{"347", 6}, new Object[]{"348", 6}, new Object[]{"349", 6}, new Object[]{"350", 6}, new Object[]{"351", 6}, new Object[]{"352", 6}, new Object[]{"353", 6}, new Object[]{"354", 6}, new Object[]{"355", 6}, new Object[]{"356", 6}, new Object[]{"357", 6}, new Object[]{"360", 6}, new Object[]{"361", 6}, new Object[]{"362", 6}, new Object[]{"363", 6}, new Object[]{"364", 6}, new Object[]{"365", 6}, new Object[]{"366", 6}, new Object[]{"367", 6}, new Object[]{"368", 6}, new Object[]{"369", 6}, new Object[]{"390", r0, 15}, new Object[]{"391", r0, 18}, new Object[]{"392", r0, 15}, new Object[]{"393", r0, 18}, new Object[]{"703", r0, 30}};
        FOUR_DIGIT_DATA_LENGTH = new Object[][]{new Object[]{"7001", 13}, new Object[]{"7002", r0, 30}, new Object[]{"7003", 10}, new Object[]{"8001", 14}, new Object[]{"8002", r0, 20}, new Object[]{"8003", r0, 30}, new Object[]{"8004", r0, 30}, new Object[]{"8005", 6}, new Object[]{"8006", 18}, new Object[]{"8007", r0, 30}, new Object[]{"8008", r0, 12}, new Object[]{"8018", 18}, new Object[]{"8020", r0, 25}, new Object[]{"8100", 6}, new Object[]{"8101", 10}, new Object[]{"8102", 2}, new Object[]{"8110", r0, 70}, new Object[]{"8200", r0, 70}};
    }

    private FieldParser() {
    }

    static String parseFieldsInGeneralPurpose(String r10) throws NotFoundException {
        if (r10.isEmpty() == false) goto L7;
        return null;
    L7:
        if (r10.length() < 2) goto L65;
        String r2 = r10.substring(0, 2);
        Object[][] r3 = TWO_DIGIT_DATA_LENGTH;
        int r4 = r3.length;
        int r5 = 0;
    L10:
        if (r5 >= r4) goto L21;
        Object[] r7 = r3[r5];
        if (r7[0].equals(r2) == true) goto L13;
        r5 = r5 + 1;
        goto L10
    L13:
        Object r0 = r7[1];
        if (r0 != VARIABLE_LENGTH) goto L18;
        return processVariableAI(2, ((Integer) r7[2]).intValue(), r10);
    L18:
        return processFixedAI(2, ((Integer) r0).intValue(), r10);
    L21:
        if (r10.length() < 3) goto L63;
        String r6 = r10.substring(0, 3);
        Object[][] r8 = THREE_DIGIT_DATA_LENGTH;
        int r9 = r8.length;
        int r11 = 0;
    L23:
        if (r11 >= r9) goto L33;
        Object[] r12 = r8[r11];
        if (r12[0].equals(r6) == true) goto L26;
        r11 = r11 + 1;
        goto L23
    L26:
        Object r1 = r12[1];
        if (r1 != VARIABLE_LENGTH) goto L31;
        return processVariableAI(3, ((Integer) r12[2]).intValue(), r10);
    L31:
        return processFixedAI(3, ((Integer) r1).intValue(), r10);
    L33:
        Object[][] r13 = THREE_DIGIT_PLUS_DIGIT_DATA_LENGTH;
        int r14 = r13.length;
        int r15 = 0;
    L35:
        if (r15 >= r14) goto L46;
        Object[] r16 = r13[r15];
        if (r16[0].equals(r6) == true) goto L38;
        r15 = r15 + 1;
        goto L35
    L38:
        Object r17 = r16[1];
        if (r17 != VARIABLE_LENGTH) goto L43;
        return processVariableAI(4, ((Integer) r16[2]).intValue(), r10);
    L43:
        return processFixedAI(4, ((Integer) r17).intValue(), r10);
    L46:
        if (r10.length() < 4) goto L61;
        String r18 = r10.substring(0, 4);
        Object[][] r19 = FOUR_DIGIT_DATA_LENGTH;
        int r20 = r19.length;
        int r21 = 0;
    L48:
        if (r21 >= r20) goto L59;
        Object[] r22 = r19[r21];
        if (r22[0].equals(r18) == true) goto L51;
        r21 = r21 + 1;
        goto L48
    L51:
        Object r23 = r22[1];
        if (r23 != VARIABLE_LENGTH) goto L56;
        return processVariableAI(4, ((Integer) r22[2]).intValue(), r10);
    L56:
        return processFixedAI(4, ((Integer) r23).intValue(), r10);
    L59:
        throw NotFoundException.getNotFoundInstance();
    L61:
        throw NotFoundException.getNotFoundInstance();
    L63:
        throw NotFoundException.getNotFoundInstance();
    L65:
        throw NotFoundException.getNotFoundInstance();
    }

    private static String processFixedAI(int r2, int r3, String r4) throws NotFoundException {
        if (r4.length() < r2) goto L14;
        String r0 = r4.substring(0, r2);
        int r5 = r3 + r2;
        if (r4.length() < r5) goto L12;
        String r6 = r4.substring(r2, r5);
        String r7 = "(" + r0 + ')' + r6;
        String r8 = parseFieldsInGeneralPurpose(r4.substring(r5));
        if (r8 != null) goto L10;
        return r7;
    L10:
        return r7 + r8;
    L12:
        throw NotFoundException.getNotFoundInstance();
    L14:
        throw NotFoundException.getNotFoundInstance();
    }

    private static String processVariableAI(int r2, int r3, String r4) throws NotFoundException {
        String r0 = r4.substring(0, r2);
        int r5 = r3 + r2;
        if (r4.length() >= r5) goto L5;
        r5 = r4.length();
    L5:
        String r6 = r4.substring(r2, r5);
        String r7 = "(" + r0 + ')' + r6;
        String r8 = parseFieldsInGeneralPurpose(r4.substring(r5));
        if (r8 != null) goto L9;
        return r7;
    L9:
        return r7 + r8;
    }
}
