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
import javax.measure.quantity.Mass;

public class MassConverter extends Conversion<Quantity<Mass>> {
    private static final Unit<Mass> UNIT = Units.GRAM;
    private static final MassConverter INSTANCE = new MassConverter();
    public static final MassConverter get(){ return INSTANCE; }
    private MassConverter(){ super(); }

    public Class<Quantity<Mass>> getConvertedType() {
        return (Class)Quantity.class;
    }

    public String getLogicalTypeName() {
        return MassLogicalType.MASS_LOGICAL_TYPE_NAME;
    }

    @Override public Quantity<Mass> fromLong(Long value, Schema schema, LogicalType type) {
        return Quantities.getQuantity(value, UNIT);
    }

    @Override public Long toLong(Quantity<Mass> value, Schema schema, LogicalType type) {
        return value.to(UNIT).getValue().longValue();
    }
}
