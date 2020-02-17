package com.github.thake.avromeasures;

import org.apache.avro.LogicalType;
import org.apache.avro.Schema;

public class MassLogicalType extends LogicalType {
    public static final String MASS_LOGICAL_TYPE_NAME = "length_g";

    MassLogicalType() {
        super(MASS_LOGICAL_TYPE_NAME);
    }

    @Override
    public void validate(Schema schema) {
        super.validate(schema);
        if (schema.getType() != Schema.Type.LONG) {
            throw new IllegalArgumentException(
                    "Logical type 'length' must be backed by a long");
        }
    }
}
