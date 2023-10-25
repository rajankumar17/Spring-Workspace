https://www.pixeltrice.com/spring-security-ldap-authentication-example-using-spring-boot-application/

What is LDAP?
-------------
LDAP is a protocol to access the centralized directory over an Internet Protocol Network or IP Network. A centralized directory acts as a data source, which contains all important information related to the organization such as user details, system information, etc.

It is used to sharing the information with internet application or the application which is hosted on the internet or intranet.

Dependencies:
-------------
**unboundid-ldapsdk:** It is an Open Source implementation of LDAP Server, because of this dependency the instance of LDAP Server will start running on our local system.

**spring-ldap-core:** It is an spring integration library which works with LDAP.

**spring-security-ldap:** This will provides the spring security to LDAP.

Note: These dependencies ensures that the local instance of LDAP Server is Running on our system.

But still, in the LDAP Server, we don’t have any users data, so we need to configure it in the application.properties file as shown in the next step.

**Step 7:** Configure the LDAP Server properties in application.properties

spring.ldap.embedded.port=8389
spring.ldap.embedded.ldif=classpath:ldap-data.ldif
spring.ldap.embedded.base-dn=dc=springframework,dc=org
spring.ldap.embedded.port: It is used to mention the port number at which embedded LDAP instance or server has to be run.

**spring.ldap.embedded.ldif:** This property is used to give the reference about the file which contains all the users’ data or path where all the data stored on the LDAP Server. The spring boot pulls the users’ data from the .ldif file from LDAP Server and compares it with data provided by the user at the time of login.

**spring.ldap.embedded.base-dn:** This is used to specify the root node of LDAP.

**What is LDIF?**
-----------------
It is just syntax or format which is used to store the data in the LDAP Server. The full form of LDIF is the LDAP Data Interchange Format.

**Step 8:** Create a ldap-data.ldif file and store some data.

In this step, we will create a .ldif file and store some user’s data. You can create that file in of the location under classpath, but for simplicity, I am creating in under src/main/resources
Now we are good to go and configure our security policy’s.

**Step 9:** Configure the Spring Security LDAP Authentication

In this step we will be doing the configuration based on LDAP authentication, here we have to define which URL has to be authenticated.

