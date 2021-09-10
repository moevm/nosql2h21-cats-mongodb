package ru.nosqlproject.catsmongo.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

import java.util.Collection;
import java.util.Collections;

/**
 * @author Kirill Mololkin Kirill-mol 10.09.2021
 */
@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {

	@Value("${mongodb.host}")
	private String host;

	@Value("${mongodb.port}")
	private String port;

	@Override
	protected String getDatabaseName() {
		return "cats";
	}

	@Override
	public MongoClient mongoClient() {
		System.out.println("mongodb://" + host +
				":" + port + "/cats");

		ConnectionString connectionString = new ConnectionString("mongodb://" + host +
				":" + port + "/cats");

		MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
				.applyConnectionString(connectionString)
				.build();

		return MongoClients.create(mongoClientSettings);
	}

	@Override
	public Collection<String> getMappingBasePackages() {
		return Collections.singleton("ru.nosqlproject");
	}
}
