package com.adminsue.study.design.factory.provider.impl;

import com.adminsue.study.design.factory.freight.FreightCalculation;
import com.adminsue.study.design.factory.freight.impl.P1FreightCalculation;
import com.adminsue.study.design.factory.price.PriceCalculation;
import com.adminsue.study.design.factory.price.impl.P1PriceCalculation;
import com.adminsue.study.design.factory.provider.Provider;
import com.adminsue.study.design.factory.tax.TaxCalculation;
import com.adminsue.study.design.factory.tax.impl.P1TaxCalculation;

/**
 * p1 provide, provide the p1 implement
 *
 * @author adminsue[ceo@adminsue.com]
 * @since 2019-01-19.
 */
public class P1Provider implements Provider {

    public PriceCalculation providePriceCalculation() {
        return new P1PriceCalculation();
    }

    public FreightCalculation provideFreightCalculation() {
        return new P1FreightCalculation();
    }

    public TaxCalculation provideTaxCalculation() {
        return new P1TaxCalculation();
    }

}