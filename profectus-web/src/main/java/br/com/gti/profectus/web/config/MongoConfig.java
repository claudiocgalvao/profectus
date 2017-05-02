package br.com.gti.profectus.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
@EnableMongoRepositories(basePackages =  "br.com.gti" )
public class MongoConfig extends AbstractMongoConfiguration {


    protected String getDatabaseName() {
        return "test";
    }
  
    @Override
    protected String getMappingBasePackage() {
        return  "br.com.gti" ;
    }

	@Override
	public Mongo mongo() throws Exception {
		return new MongoClient("127.0.0.1", 27017);
	}	
	
}
