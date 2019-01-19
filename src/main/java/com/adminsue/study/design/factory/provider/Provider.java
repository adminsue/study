package com.adminsue.study.design.factory.provider;

import com.adminsue.study.design.factory.freight.FreightCalculation;
import com.adminsue.study.design.factory.price.PriceCalculation;
import com.adminsue.study.design.factory.tax.TaxCalculation;

/**
 * @author adminsue[ceo@adminsue.com]
 * @since 2019-01-16.
 */
public interface Provider {

    PriceCalculation providePriceCalculation();

    FreightCalculation provideFreightCalculation();

    TaxCalculation provideTaxCalculation();

}
