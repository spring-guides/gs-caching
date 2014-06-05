package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
public class Application {

    private final static Logger log = LoggerFactory.getLogger(Application.class);

    @Configuration
    static class Runner implements CommandLineRunner {
        @Autowired
        private BookRepository bookRepository;

        @Override
        public void run(String... args) throws Exception {
            log.info(".... Fetching books");
            log.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));
            log.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));
            log.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));
        }
    }

    @Bean
    public BookRepository bookRepository() {
        return new SimpleBookRepository();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
