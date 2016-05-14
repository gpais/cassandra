package com.LetsGetDigital.dao;

import com.datastax.driver.core.TypeCodec;
import com.datastax.driver.core.UserType;
import com.LetsGetDigital.model.CarType;
import com.datastax.driver.core.UDTValue;
import com.datastax.driver.extras.codecs.MappingCodec;

public class CarTypeCodec  extends MappingCodec<CarType, UDTValue> {
    private final UserType userType;

	public CarTypeCodec(TypeCodec<UDTValue> innerCodec, Class<CarType> javaType) {
		super(innerCodec, javaType);
        userType = (UserType) innerCodec.getCqlType();
	}

	@Override
	protected CarType deserialize(UDTValue value) {
	    return value == null ? null : new CarType(value.getString("sipp"), value.getString("supplier"));
	}

	@Override
	protected UDTValue serialize(CarType value) {
        return value == null ? null : userType.newValue().setString("sipp", value.getSipp()).setString("supplier", value.getSupplier());
	}
}
