# Read me

This project demonstrate how to copy bean properties to another bean. 

Domain package demonstrate the domain model, and repository package demonstrate hibernate entity. OrderMapper is a tool used to map domain to hibernate entity. Several orderMappers are implemented, they are tested in BeanCopyUtilsTest with performance tests.

The results shows OrderMapperCglibImpl's performance is very close to the OrderMapperSetterImpl, which is hard code by setters. And the Spring BeanUtils has low performance.  