package com.ashish.webservices.utility.convertor;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class JsonPojoConvertor {

	public JsonPojoConvertor() {

	}

	public void pojoToJsonConvertor(TestUser testUser) {

		ObjectMapper mapper = new ObjectMapper();

		try {

			// convert user object to json string, and save to a file
			mapper.writeValue(new File("E:\\Tutorials\\Output\\testUser.json"),
					testUser);

			// formatted output into file.
			mapper.writer()
					.withDefaultPrettyPrinter()
					.writeValue(
							new File(
									"E:\\Tutorials\\Output\\formattedTestUser.json"),
							testUser);

			// display to console
			System.out.println(mapper.writeValueAsString(testUser));

			// Actual output without formatter :
			// {"name":"mkyong","age":29,"messages":["msg 1","msg 2","msg 3"]}
			// Add Pretty Print JSON Object to format the output

			// System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(user));
			System.out.println("Formatted json:");
			System.out.println(mapper.writer().withDefaultPrettyPrinter()
					.writeValueAsString(testUser));

			// System.out.println(mapper.wr);

		} catch (JsonGenerationException e) {

			e.printStackTrace();

		} catch (JsonMappingException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
	}

	public void jsonToPojo(File file) {
		ObjectMapper mapper = new ObjectMapper();

		try {

			// read from file, convert it to TestUser class
			TestUser testUser = mapper.readValue(file, TestUser.class);

			// display to console
			System.out.println(testUser);

		} catch (JsonGenerationException e) {

			e.printStackTrace();

		} catch (JsonMappingException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

	public static void main(String[] args) {
		JsonPojoConvertor convertor = new JsonPojoConvertor();
		TestUser testUser = new TestUser();
		convertor.pojoToJsonConvertor(testUser);

		System.out.println("Json to Pojo Controller");
		File file = new File(
				"E:\\Tutorials\\Input\\inputFormattedTestUser.json");
		convertor.jsonToPojo(file);
	}

}
