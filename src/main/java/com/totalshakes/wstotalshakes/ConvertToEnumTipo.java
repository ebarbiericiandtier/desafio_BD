package com.totalshakes.wstotalshakes;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class ConvertToEnumTipo implements AttributeConverter<Ingredientes, String> {

	@Override
	public Ingredientes convertToEntityAttribute(String dbData) {
		if (dbData == null)
			return null;

		switch (dbData) {
		case "Iorgute":
			return Ingredientes.Iorgute;

		case "Sorvete":
			return Ingredientes.Sorvete;

		case "Leite":
			return Ingredientes.Leite;

		case "Morango":
			return Ingredientes.Morango;

		case "Banana":
			return Ingredientes.Banana;

		case "Abacate":
			return Ingredientes.Abacate;

		case "Aveia":
			return Ingredientes.Aveia;

		case "Mel":
			return Ingredientes.Mel;

		case "Chocolate":
			return Ingredientes.Chocolate;

		default:
			throw new IllegalArgumentException(dbData + "Ingrediente não existe");
		}
	}

	@Override
	public String convertToDatabaseColumn(Ingredientes attribute) {

		if (attribute == null)
			return null;

		switch (attribute) {
		case Iorgute:
			return new String("Iogurte");

		case Sorvete:
			return new String("Sorvete");

		case Leite:
			return new String("Leite");

		case Morango:
			return new String("Morango");

		case Banana:
			return new String("Banana");

		case Abacate:
			return new String("Abacate");

		case Aveia:
			return new String("Aveia");

		case Mel:
			return new String("Mel");

		case Chocolate:
			return new String("Chocolate");

		default:
			throw new IllegalArgumentException(attribute + " not supported.");
		}
	}

}
