

java -jar build/libs/capitalgains-0.0.1-SNAPSHOT.jar src/test/resources/example_input.txt
java -jar build/libs/capitalgains-0.0.1-SNAPSHOT.jar src/test/resources/case7_input.txt
java -jar build/libs/capitalgains-0.0.1-SNAPSHOT.jar case7_input.txt

sudo docker build -f Dockerfile -t nubank/capital-gains .
sudo docker run --network host -it nubank/capital-gains

$ pwd
/home/luisjavierjn/Projects/capitalgains
sudo docker run --network host -it nubank/capital-gains src/test/resources/case7_input.txt

#sudo docker run --network host -it nubank/capital-gains data/case7_input.txt  -> si tuviera COPY src/test/resources $APP_HOME/data
sudo docker run --network host -v /home/luisjavierjn/Projects/capitalgains/src/test/resources:/usr/app/data -it nubank/capital-gains data/case7_input.txt

gradle test #para correr solo los tests

# Description

This program was built using Java 11, SpringBoot and Gradle to handle dependencies. The initial code was generated through 
[start.spring.io](https://start.spring.io/)  
![img1](images/img1.png)  

No Web dependencies were included because this is a console program, so the approach was to implement the interface CommandLineRunner 
and override the method **public void run(String... args)**. Four packages were created to support the logic of the application, namely: 
business, exceptions, model and utils, where the *business.rules* package handles the main responsibility applying the 
[Rules Design Pattern](https://levelup.gitconnected.com/rules-design-pattern-in-c-6c62f0e20ee0).  
![img2](images/img2.png)  

Considering the previous image we can do the following matches  
- **RulesEngine:** this class is represented by the *TaxValidator* class using the method *validate*
- **IRule:** this class is represented by the *ITaxValidationRule* interface which has two methods to implement *IsValid* and *Execute*
- **RuleOne, RuleTwo and RuleThree:** these classes are represented by *BuyValidationRule*, *SellValidationRule* and *SellWithLossesValidationRule*

If there is another type of calculation for the taxes, we just create the *NewValidationRule* and add it to the list in *TaxValidator* 
for it to be evaluated like the rest. Because the topic this assigment is dealing with is about finance, the calculations were made 
using BigInteger and BigDecimal as Data Type. Moreover, when using the *Rules Design Pattern* we need to keep track of a certain *State* that 
can change as rules are being applied/validated according to the new information coming in, which in this case is every *Simulation* that 
is being read from the input files. Each Simulation comes with an *OperationType* (buy,sell), unit-cost and quantity, and when they are 
processed they can generate changes to the *State* which includes current quantity of stocks, the average price and/or any loss that can be 
deductible from capital gains. The classes *State*, *Simulation* and *OperationType* from the *model* package serve to this mechanism.  




