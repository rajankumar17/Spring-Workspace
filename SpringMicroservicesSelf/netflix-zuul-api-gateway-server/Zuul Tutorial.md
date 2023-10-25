##  API Gateway and Zuul Tutorials

- https://www.javatpoint.com/introduction-to-api-gateways
- https://howtodoinjava.com/spring-cloud/spring-cloud-api-gateway-zuul/
- https://medium.com/geekculture/zuul-api-gateway-2bcdf4dd33e6
- https://levelup.gitconnected.com/spring-cloud-zuul-api-gateway-dffa5933d570
- https://spring.io/guides/gs/routing-and-filtering/

#### Zuul provides a range of different types of filters that allows us to quickly and nimbly apply functionality to our edge service. The filters perform the following functions:

- **Authentication and Security:** It provides authentication requirements for each resource.
- **Insights and Monitoring:** It tracks meaningful data and statistics that give us an accurate view of production.
- **Dynamic Routing:** It dynamically routes the requests to different backed clusters as needed.
- **Stress Testing:** It increases the traffic to a cluster in order to test performance.
- **Load Shedding:** It allocates capacity for each type of request and drops a request that goes over the limit.
- **Static Response Handling:** It builds some responses directly at the edge instead of forwarding them to an internal cluster.
- **Multi-region Resiliency:** It routes requests across AWS regions in order to diversify our ELB usage.

#### ZuulFilter class has four abstract methods that are listed below:

- **shouldFilter():** The shouldFilter() method checks the request and decides whether filter to be executed or not.
- **run():** The run() method invokes, if both !isFilterDisabled() and shouldFilter() methods returns true.
- **filterType():** The filterType() method classify a filter by type. There are four types of standard filters in Zuul: pre for pre-routing filtering, route for routing to an origin, post for post-routing filters, and error for error handling. Zuul also supports a static type for static responses. Any filter type can be created or added and run by calling the method runFilters(type).
- **filterOrder():** The filter order must be defined for a filter. Filters may have the same filter order if the precedence is not important for the filters. The filter order does not need to be sequential.

## Complete Code Example

- https://www.javatpoint.com/executing-a-request-through-zuul-api-gateway

Let's invoke the request through the Zuul API Gateway. 
- We use the following URL: http://localhost:8765/{application-name}/{uri}
. The port 8765 is the default port for the Zuul API Gateway server.

In our case, the application name is currency-exchange-service, and the URI is `/currency-exchange/from/EUR/to/INR`. So the complete URL will look like the following:
http://localhost:8765/currency-exchange-service/currency-exchange/from/EUR/to/INR

Setting up Zuul API Gateway between microservices invocations
In the previous step, we have used a direct URL to execute the currency-exchange-service through the Zuul API Gateway proxy. When we use the URL http://localhost:8765/currency-exchange-service/currency-exchange/from/EUR/to/INR
, it uses port 8765 that is proxy for API Gateway.

In this section, we will call the currency-calculation-service (currency-conversion-service) that calls the currency-exchange-service. So far, we were calling the service directly. Now, we will call it through the Zuul API Gateway instead of directly calling the currency-exchange-service.

- **Step 1:** Select the project currency-conversion-service.

- **Step 2:** Open the CurrencyExchangeServiceProxy.java file.

- **Step 3:** Enable the Feign by using the annotation @FeignClient with the attribute name="netflix-zuul-api-gateway-server".


@FeignClient(name="netflix-zuul-api-gateway-server")  
Remember: Remove or comment all other annotations @FeignClient in CurrencyExchangeServiceProxy.java file.

- **Step 4:** Define the mapping for the Zuul API Gateway server.

@GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")  
Remember: Remove or comment the mapping for currency-exchange-service.


- **Step 5:** Run the netflix-eureka-naming-server, currency-exchange-service, currency-conversion-service, and netflix-zuul-api-gateway-server in the same order in which we have written.

Remember: Ensure that all four services are running properly.

- **Step 6:** Open the browser and invoke the URL http://localhost:8100/currency-converter-feign/from/USD/to/INR/quantity/1000
. It returns the following response:

Executing a Request through Zuul API Gateway
Let's see the log for NetflixZullApiGatewayServerApplication.

- **Step 7:** Click on the arrow that is beside the console icon and select the NetflixZullApiGatewayServerApplication.

Executing a Request through Zuul API Gateway
It shows a couple of logs, as shown in the following image.

Executing a Request through Zuul API Gateway
- **Step 8:** Refresh the URL again. It shows a single log on the console.

Executing a Request through Zuul API Gateway
Whenever we call the CurrencyClaculationService (currency-converter-service) through Feign, it routed through the API Gateway server. The Gateway executes a filter called ZuulLoggingFilter that invokes the currency-exchange-service.

Now let's intercept the calls between currency converter-service and currency-exchange-service. It means the API Gateway executes two times when we invoke the URL.


The first time, API Gateway executes when we call the currency-conversion-service. It means before the execution of the currency-conversion-service. The currency-conversion-service routed through the API Gateway.
The second time, API Gateway executes when the currency-conversion-service calls the currency-exchange-service. It means after the execution of currency-conversion-service and before the execution of currency-exchange-service. The currency-exchange-service also routed through the API Gateway.
Let's implement the interception in our project.

Send the request http://localhost:8765
through the API Gateway. The URI will be /{application-name}/{uri}. The complete URL will look like the following:

http://localhost:8765/currency-conversion-service/currency-converter-feign/from/USD/to/INR/quantity/1000

Invoke the above URL. It returns the same response as the URL http://localhost:8100/currency-converter-feign/from/USD/to/INR/quantity/1000
returns.

Executing a Request through Zuul API Gateway
We can see in the log that the logging filter executes two times. The first time it calls the currency-converter-service and the second time when the currency-converter-service calls the currency-exchange-service.

Executing a Request through Zuul API Gateway
In this section, we have executed both the services through the Zuul API Gateway server.

### RabbitMQ

RabbitMQ is widely deployed open-source message broker software that implements Advanced Message Queuing Protocol (AQMP). It is lightweight and easy to deploy in the cloud. It supports multiple messaging protocols. It can be deployed in a distributed environment to meet high-scale and high-availability requirements. It is modeled on the AMQP standard. The RabbitMQ is written in the Erlang programming language. It is developed on the Open Telecom Platform (OTP) framework for clustering and failover.

RabbitMQ runs on different operating systems and cloud environments. It provides a large number of platforms like Java, .NET, Python, etc.

**Advantagesof RabbitMQ**
- Fast performance
- Polyglot (using several languages)
- Easy Management
- No Erlang knowledge needed
- Great documentation

**AMQP defines:**
- Where to send messages (Routing)
- How to get there (Delivery)
-  What goes in must come out (Fidelity)

**Message broker**
- A message broker sits between the machine and the distributed computing system. Instead of passing the messages directly to the receiver, the messages are first sent to the message broker (RabbitMQ). The message broker orders the messages in an optimized queue and passes them to the receiving machine when the machines are ready to process the messages.

A message might be a command to process an order, run a specified task, a pull request made to a database.

The machine that sends the message is called the producer. The machine that receives the message is called the consumer. The bit in the middle is called the broker.

**Message broker does the following:**

- Decouple the message publisher and consumer
- Store the message
- Routing the message
- Monitoring and management of message
- Transform message format between producer and consumer

**Erlang**
- Erlang is a compiled, fault-tolerant, concurrent, dynamically typed programming language. It is used to build a massively scalable, real-time system with requirements on high availability. It is used in banking, e-commerce, telecom, computer telephony, and instant messaging.

**OTP**
- OTP stands for Open Telecom Platform. It is a collection of Erlang libraries and design principles. It provides middleware to develop these systems. It includes its own tools such as distributed database, applications to interface towards other languages, debugging and release handling tools.