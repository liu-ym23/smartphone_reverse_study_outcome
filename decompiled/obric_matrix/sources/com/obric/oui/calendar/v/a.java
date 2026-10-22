package com.obric.oui.calendar.v;

import org.threeten.bp.DayOfWeek;

/* JADX INFO: loaded from: classes2.dex */
public class a implements h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CharSequence[] f10926b;

    public a(CharSequence[] r3) {
        if (r3 == null) goto L11;
        if (r3.length != 7) goto L9;
        this.f10926b = r3;
        return;
    L9:
        throw new IllegalArgumentException("Array must contain exactly 7 elements");
    L11:
        throw new IllegalArgumentException("Cannot be null");
    }

    @Override // com.obric.oui.calendar.v.h
    public CharSequence a(DayOfWeek r1) {
        return this.f10926b[r1.getValue() - 1];
    }
}
