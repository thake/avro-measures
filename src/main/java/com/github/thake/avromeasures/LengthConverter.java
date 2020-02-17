package com.github.thake.avromeasures;

import org.apache.avro.Conversion;
import org.apache.avro.LogicalType;
import org.apache.avro.Schema;
import tech.units.indriya.quantity.Quantities;
import tech.units.indriya.unit.Units;

import javax.measure.MetricPrefix;
import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.quantity.Length;

public class LengthConverter extends Conversion<Quantity<Length>> {
    private static final Unit<Length> UNIT = MetricPrefix.MILLI(Units.METRE);
    private static final LengthConverter INSTANCE = new LengthConverter();
    public static final LengthConverter get(){ return INSTANCE; }
    private LengthConverter(){ super(); }

    public Class<Quantity<Length>> getConvertedType() {
        return (Class)Quantity.class;
    }

    public String getLogicalTypeName() {
        return LengthLogicalType.LENGTH_LOGICAL_TYPE_NAME;
    }

    @Override public Quantity<Length> fromLong(Long value, Schema schema, LogicalType type) {
        return Quantities.getQuantity(value,UNIT);
    }

    @Override public Long toLong(Quantity<Length> value, Schema schema, LogicalType type) {
        return value.to(UNIT).getValue().longValue();
    }
}
