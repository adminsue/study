package com.adminsue.study.design.factory;

import com.adminsue.study.design.factory.freight.FreightCalculation;
import com.adminsue.study.design.factory.price.PriceCalculation;
import com.adminsue.study.design.factory.provider.Provider;
import com.adminsue.study.design.factory.tax.TaxCalculation;
import org.springframework.stereotype.Component;

/**
 * @author adminsue[ceo@adminsue.com]
 * @since 2019-01-19.
 */
@Component
public class Queue {

    public void doQueue(Provider provider) {

        PriceCalculation priceCalculation = provider.providePriceCalculation();
        priceCalculation.recalculatePrice();

        FreightCalculation freightCalculation = provider.provideFreightCalculation();
        freightCalculation.recalculateFreight();

        TaxCalculation taxCalculation = provider.provideTaxCalculation();
        taxCalculation.recalculateTax();

    }


}
