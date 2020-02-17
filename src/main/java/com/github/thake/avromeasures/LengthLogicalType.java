package com.github.thake.avromeasures;

import org.apache.avro.LogicalType;
import org.apache.avro.Schema;

public class LengthLogicalType extends LogicalType {
    public static final String LENGTH_LOGICAL_TYPE_NAME = "length_mm";

    LengthLogicalType() {
        super(LENGTH_LOGICAL_TYPE_NAME);
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
