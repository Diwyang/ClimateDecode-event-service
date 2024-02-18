package com.climate.decode.eventservice.converter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.convert.PropertyValueConverter;
import org.springframework.data.convert.ValueConversionContext;

@Slf4j
public class EnumValueConverter implements PropertyValueConverter {
	@Override
	public Object read(Object value, ValueConversionContext context) {
		Enum resolvedEnum = null;
		try {
			resolvedEnum = (Enum) context.getProperty().getActualType().getDeclaredMethod("fromValue", String.class)
					.invoke(null, value);
		} catch (Exception ex) {
			log.error(ex.getMessage());
		}
		return resolvedEnum;
	}

	@Override
	public Object write(Object value, ValueConversionContext context) {
		String enumValue = null;
		try {
			enumValue = (String) context.getProperty().getActualType().getDeclaredMethod("value").invoke(value);
		} catch (Exception ex) {
			log.error(ex.getMessage());
		}
		return enumValue != null;
	}
}
