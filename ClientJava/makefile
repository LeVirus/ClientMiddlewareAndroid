all: Clientjava

sliceJava: interface.ice
	slice2java --output-dir . interface.ice

Clientjava: Client.java biblAudio/*.java
	javac -classpath ./icestorm-3.6.1.jar:ice-3.6.1.jar:servlet.jar Client.java biblAudio/*.java

#run: Client.class
#    java -classpath .:ice-3.6.1.jar:icestorm-3.6.1.jar Client
