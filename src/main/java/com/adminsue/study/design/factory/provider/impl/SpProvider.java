package com.adminsue.study.design.factory.provider.impl;

import com.adminsue.study.design.factory.freight.FreightCalculation;
import com.adminsue.study.design.factory.freight.impl.SpFreightCalculation;
import com.adminsue.study.design.factory.price.PriceCalculation;
import com.adminsue.study.design.factory.price.impl.SpPriceCalculation;
import com.adminsue.study.design.factory.provider.Provider;
import com.adminsue.study.design.factory.tax.TaxCalculation;
import com.adminsue.study.design.factory.tax.impl.SpTaxCalculation;

/**
 * sp provider, provide the stored procedure wrapper implement
 *
 * @author adminsue[ceo@adminsue.com]
 * @since 2019-01-19.
 */
public class SpProvider implements Provider {

    public PriceCalculation providePriceCalculation() {
        return new SpPriceCalculation();
    }

    public FreightCalculation provideFreightCalculation() {
        return new SpFreightCalculation();
    }

    public TaxCalculation provideTaxCalculation() {
        return new SpTaxCalculation();
    }

}
