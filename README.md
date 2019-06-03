# SpringDataModule
POM project that provide abstraction for standard CRUD operations using spring-data framework which is implemented with different
integrations such as spring-jdbctemplate, spring-hibernate-integration, spring-jpa-integration and spring-data-jpa.

each module has its own AppConfig class that defines the required beans (Using @Annotations) in order to perform the basic crud operations
and using @Transactional in order to aquire spring facilities that manages ORM Sessions implicitly 
