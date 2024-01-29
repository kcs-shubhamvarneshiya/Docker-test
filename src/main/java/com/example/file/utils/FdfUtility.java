package com.example.file.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class FdfUtility {

	public static String parseFDFToJSON(String fdfData) {
		fdfData = fdfData.replace("%FDF-1.2", "")
				.replace("1 0 obj","")
				.replace("endobj", "")
				.replace("trailer", "")
				.replace("%%EOF", "")
				.trim();
		ObjectNode jsonNode = new ObjectMapper().createObjectNode();

		String fieldsData = fdfData.substring(fdfData.indexOf("[") + 1, fdfData.lastIndexOf("]"));
		String[] fieldTokens = fieldsData.split("><");

		ArrayNode fieldsNode = jsonNode.putArray("fields");
		ObjectNode fieldNode = fieldsNode.addObject();
		for (String fieldToken : fieldTokens) {
			String[] fieldParts = fieldToken.replaceAll("[<>]", "").split("/T|/V");
			String fieldName = fieldParts[1].replaceAll("[()]", "");
			String fieldValue = fieldParts[2].replaceAll("[()]", "");
			fieldNode.put(fieldName, fieldValue);
		}
		return jsonNode.toString();
	}
}
