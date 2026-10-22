package org.checkerframework.checker.units.qual;

import android.icu.text.PluralRules;

/* JADX INFO: loaded from: classes6.dex */
public final enum Prefix extends Enum<Prefix> {
    private static final /* synthetic */ Prefix[] $VALUES = null;
    public static final Prefix atto = null;
    public static final Prefix centi = null;
    public static final Prefix deca = null;
    public static final Prefix deci = null;
    public static final Prefix exa = null;
    public static final Prefix femto = null;
    public static final Prefix giga = null;
    public static final Prefix hecto = null;
    public static final Prefix kilo = null;
    public static final Prefix mega = null;
    public static final Prefix micro = null;
    public static final Prefix milli = null;
    public static final Prefix nano = null;
    public static final Prefix one = null;
    public static final Prefix peta = null;
    public static final Prefix pico = null;
    public static final Prefix tera = null;
    public static final Prefix yocto = null;
    public static final Prefix yotta = null;
    public static final Prefix zepto = null;
    public static final Prefix zetta = null;

    private Prefix(String r1, int r2) {
        super(r1, r2);
    }

    public static Prefix valueOf(String r1) {
        return (Prefix) Enum.valueOf(Prefix.class, r1);
    }

    public static Prefix[] values() {
        return (Prefix[]) $VALUES.clone();
    }

    static {
        Prefix r0 = new Prefix("yotta", 0);
        yotta = r0;
        Prefix r1 = new Prefix("zetta", 1);
        zetta = r1;
        Prefix r3 = new Prefix("exa", 2);
        exa = r3;
        Prefix r5 = new Prefix("peta", 3);
        peta = r5;
        Prefix r7 = new Prefix("tera", 4);
        tera = r7;
        Prefix r9 = new Prefix("giga", 5);
        giga = r9;
        Prefix r11 = new Prefix("mega", 6);
        mega = r11;
        Prefix r13 = new Prefix("kilo", 7);
        kilo = r13;
        Prefix r15 = new Prefix("hecto", 8);
        hecto = r15;
        Prefix r14 = new Prefix("deca", 9);
        deca = r14;
        Prefix r12 = new Prefix(PluralRules.KEYWORD_ONE, 10);
        one = r12;
        Prefix r10 = new Prefix("deci", 11);
        deci = r10;
        Prefix r8 = new Prefix("centi", 12);
        centi = r8;
        Prefix r6 = new Prefix("milli", 13);
        milli = r6;
        Prefix r4 = new Prefix("micro", 14);
        micro = r4;
        Prefix r2 = new Prefix("nano", 15);
        nano = r2;
        Prefix r16 = new Prefix("pico", 16);
        pico = r16;
        Prefix r17 = new Prefix("femto", 17);
        femto = r17;
        Prefix r18 = new Prefix("atto", 18);
        atto = r18;
        Prefix r19 = new Prefix("zepto", 19);
        zepto = r19;
        Prefix r20 = new Prefix("yocto", 20);
        yocto = r20;
        $VALUES = new Prefix[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16, r17, r18, r19, r20};
    }
}
