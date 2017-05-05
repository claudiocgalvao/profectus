
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

import br.com.gti.profectus.business.entity.Person;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

@Data
@Log4j2
public class MongoApp {

	// private static final Log log = LogFactory.getLog(MongoApp.class);

	@Autowired
	private Mongo mongo;

	public static void main(String[] args) throws Exception {

		MongoClient client = new MongoClient("localhost");
		MongoOperations mongoOps = new MongoTemplate(client, "dataTestMongo");
		mongoOps.insert(new Person("Joe", 34));

		//log.info(mongoOps.findOne(new Query("name").is("Joe")), Person.class));

		//mongoOps.dropCollection("person");
	}
}
