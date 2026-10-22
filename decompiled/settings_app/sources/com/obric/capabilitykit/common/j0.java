package com.obric.capabilitykit.common;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.StockEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/obric/capabilitykit/entity/app/StockEntityHashCodeGenerator;", "Lcom/obric/capabilitykit/entity/app/IEntityHashCodeGenerator;", "()V", "generatorHashCode", "", "instance", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class j0 implements a0 {
    public static final j0 a = null;

    static {
        a = new j0();
    }

    private j0() {
    }

    @Override // com.obric.capabilitykit.common.a0
    public int a(AppEntity r2) {
        Intrinsics.checkNotNullParameter(r2, "instance");
        if ((r2 instanceof StockEntity) == false) goto L111;
        StockEntity r3 = (StockEntity) r2;
        int r1 = r3.getName().hashCode() + 0;
        String r0 = r3.getCurrentPrice();
        if (r0 == null) goto L7;
        r1 = (r1 * 31) + r0.hashCode();
    L7:
        String r4 = r3.getHighestPrice();
        if (r4 == null) goto L10;
        r1 = (r1 * 31) + r4.hashCode();
    L10:
        String r5 = r3.getLowestPrice();
        if (r5 == null) goto L13;
        r1 = (r1 * 31) + r5.hashCode();
    L13:
        String r6 = r3.getTradingVolume();
        if (r6 == null) goto L16;
        r1 = (r1 * 31) + r6.hashCode();
    L16:
        String r7 = r3.getTradingValue();
        if (r7 == null) goto L19;
        r1 = (r1 * 31) + r7.hashCode();
    L19:
        String r8 = r3.getPriceChangeToday();
        if (r8 == null) goto L22;
        r1 = (r1 * 31) + r8.hashCode();
    L22:
        String r9 = r3.getPriceChangePercentageToday();
        if (r9 == null) goto L25;
        r1 = (r1 * 31) + r9.hashCode();
    L25:
        String r10 = r3.getOpeningPriceToday();
        if (r10 == null) goto L28;
        r1 = (r1 * 31) + r10.hashCode();
    L28:
        String r11 = r3.getClosingPriceToday();
        if (r11 == null) goto L31;
        r1 = (r1 * 31) + r11.hashCode();
    L31:
        String r12 = r3.getNetProfitToShareholders();
        if (r12 == null) goto L34;
        r1 = (r1 * 31) + r12.hashCode();
    L34:
        String r13 = r3.getOperatingIncome();
        if (r13 == null) goto L37;
        r1 = (r1 * 31) + r13.hashCode();
    L37:
        String r14 = r3.getBasicEarningsPerShare();
        if (r14 == null) goto L40;
        r1 = (r1 * 31) + r14.hashCode();
    L40:
        String r15 = r3.getNetAssetsPerShare();
        if (r15 == null) goto L43;
        r1 = (r1 * 31) + r15.hashCode();
    L43:
        String r16 = r3.getGrossProfitMargin();
        if (r16 == null) goto L46;
        r1 = (r1 * 31) + r16.hashCode();
    L46:
        String r17 = r3.getNetProfitMargin();
        if (r17 == null) goto L49;
        r1 = (r1 * 31) + r17.hashCode();
    L49:
        String r18 = r3.getReturnOnEquity();
        if (r18 == null) goto L52;
        r1 = (r1 * 31) + r18.hashCode();
    L52:
        String r19 = r3.getDebtToAssetsRatio();
        if (r19 == null) goto L55;
        r1 = (r1 * 31) + r19.hashCode();
    L55:
        String r20 = r3.getGrossProfit();
        if (r20 == null) goto L58;
        r1 = (r1 * 31) + r20.hashCode();
    L58:
        String r21 = r3.getOperatingProfit();
        if (r21 == null) goto L61;
        r1 = (r1 * 31) + r21.hashCode();
    L61:
        String r22 = r3.getProfitAfterTax();
        if (r22 == null) goto L64;
        r1 = (r1 * 31) + r22.hashCode();
    L64:
        String r23 = r3.getTotalCurrentAssets();
        if (r23 == null) goto L67;
        r1 = (r1 * 31) + r23.hashCode();
    L67:
        String r24 = r3.getTotalNonCurrentAssets();
        if (r24 == null) goto L70;
        r1 = (r1 * 31) + r24.hashCode();
    L70:
        String r25 = r3.getTotalAssets();
        if (r25 == null) goto L73;
        r1 = (r1 * 31) + r25.hashCode();
    L73:
        String r26 = r3.getTotalCurrentLiabilities();
        if (r26 == null) goto L76;
        r1 = (r1 * 31) + r26.hashCode();
    L76:
        String r27 = r3.getTotalNonCurrentLiabilities();
        if (r27 == null) goto L79;
        r1 = (r1 * 31) + r27.hashCode();
    L79:
        String r28 = r3.getTotalLiabilities();
        if (r28 == null) goto L82;
        r1 = (r1 * 31) + r28.hashCode();
    L82:
        String r29 = r3.getShareholdersEquity();
        if (r29 == null) goto L85;
        r1 = (r1 * 31) + r29.hashCode();
    L85:
        String r30 = r3.getTotalEquity();
        if (r30 == null) goto L88;
        r1 = (r1 * 31) + r30.hashCode();
    L88:
        String r31 = r3.getNetCashFlowFromOperatingActivities();
        if (r31 == null) goto L91;
        r1 = (r1 * 31) + r31.hashCode();
    L91:
        String r32 = r3.getNetCashFlowFromInvestingActivities();
        if (r32 == null) goto L94;
        r1 = (r1 * 31) + r32.hashCode();
    L94:
        String r33 = r3.getNetCashFlowFromFinancingActivities();
        if (r33 == null) goto L97;
        r1 = (r1 * 31) + r33.hashCode();
    L97:
        String r34 = r3.getNetCash();
        if (r34 == null) goto L100;
        r1 = (r1 * 31) + r34.hashCode();
    L100:
        String r35 = r3.getCashAtEndOfPeriod();
        if (r35 == null) goto L103;
        r1 = (r1 * 31) + r35.hashCode();
    L103:
        String r36 = r3.getMarket();
        if (r36 == null) goto L106;
        r1 = (r1 * 31) + r36.hashCode();
    L106:
        String r37 = r3.getMarketStatus();
        if (r37 != null) goto L109;
        return r1;
    L109:
        return (r1 * 31) + r37.hashCode();
    L111:
        throw new IllegalStateException("Check failed.".toString());
    }
}
