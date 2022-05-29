# Setup

to compile program na linuxie używaj .: na widowsie .\

```
javac -cp .:PCJ.jar Example1
javac -cp C:\Users\ŁukaszMazurek\Desktop\pcj\PCJ.jar Example2.java
```

to start program run command na linuxie używaj .: na widowsie .\
```
java -cp .:PCJ.jar Example1
java -cp C:\Users\ŁukaszMazurek\Desktop\pcj\PCJ.jar Example2.java
```

to start program on linux cluster with MPI library
```
mpiexec bash -c 'java -cp .:PCJ.jar HelloWorld'
```

PCJ.jar leatest version of pcj library https://pcj.icm.edu.pl/downloads

