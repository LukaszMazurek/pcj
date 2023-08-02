# Setup

compile programs (for linux use .: insted of .\)

```
javac -cp .:PCJ.jar Example1
javac -cp path\PCJ.jar Example2.java
```

run programs
```
java -cp .:PCJ.jar Example1
java -cp path\PCJ.jar Example2.java
```

start programs on cluster with mpi
```
mpiexec bash -c 'java -cp .:PCJ.jar HelloWorld'
```

PCJ.jar leatest version of pcj library https://pcj.icm.edu.pl/downloads

