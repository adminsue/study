package com.adminsue.study.design.factory.price.impl;

import com.adminsue.study.design.factory.price.PriceCalculation;
import lombok.extern.slf4j.Slf4j;

/**
 * @author adminsue[ceo@adminsue.com]
 * @since 2019-01-19.
 */
@Slf4j
public class P1PriceCalculation implements PriceCalculation {

    public void recalculatePrice() {
        log.info("entry p1 recalculate price method");
    }

}
