# Usage of Hibernate Validator

[![Build Status](https://travis-ci.org/MasterOfTheU/object-model-validation.svg?branch=master)](https://travis-ci.org/MasterOfTheU/object-model-validation)
[![codecov](https://codecov.io/gh/MasterOfTheU/object-model-validation/branch/master/graph/badge.svg)](https://codecov.io/gh/MasterOfTheU/object-model-validation)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/7e7cab85337b49d7814a9cf7a0f3c50e)](https://www.codacy.com/app/MasterOfTheU/object-model-validation?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=MasterOfTheU/object-model-validation&amp;utm_campaign=Badge_Grade)
[![Codacy Badge](https://api.codacy.com/project/badge/Coverage/7e7cab85337b49d7814a9cf7a0f3c50e)](https://www.codacy.com/app/MasterOfTheU/object-model-validation?utm_source=github.com&utm_medium=referral&utm_content=MasterOfTheU/object-model-validation&utm_campaign=Badge_Coverage)

## Person object model
This model has 10 fields of different types. We have to use hibernate validator annotations to check the validity of those fields.
![objmodel](https://user-images.githubusercontent.com/15348166/32693104-831422cc-c72d-11e7-803f-dceff1a1284a.PNG)

## Object examples
Created objects were converted to JSON format to provide a better understanding of model:
![objects](https://user-images.githubusercontent.com/15348166/32693965-2262df80-c73d-11e7-97bb-647c9dd69b99.png)

## Dependencies
<ol>
    <li><a href="https://mvnrepository.com/artifact/com.google.code.gson/gson/2.8.2">Gson v2.8.2</a></li>
    <li><a href="https://mvnrepository.com/artifact/org.hibernate/hibernate-validator/6.0.4.Final">Hibernate Validator</a></li>
    <li><a href="https://mvnrepository.com/artifact/org.hibernate/hibernate-validator-cdi/6.0.4.Final">Hibernate Validator CDI</a></li>
    <li><a href="https://mvnrepository.com/artifact/org.glassfish/javax.el/3.0.1-b08">Unified Expression Language v3.0.1-b08</a></li>
</ol>
