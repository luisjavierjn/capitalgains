

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