Código de ejemplo: Desarrollo dirigido por pruebas
==================================================
Joaquín Caraballo

Requisitos técnicos
-------------------
* sbt (probado con 0.12.0)
  Si no está instalado, se puede bajar y seguir las instrucciones de instalación de http://www.scala-sbt.org/download.html ; o bien, alternativamente, en unix se puede ejecutar directamente:

        wget http://typesafe.artifactoryonline.com/typesafe/ivy-releases/org.scala-sbt/sbt-launch/0.12.0/sbt-launch.jar && \
        echo 'java -Xmx512M -jar `dirname $0`/sbt-launch.jar "$@"' >sbt && \
        chmod 755 sbt

Instrucciones
-------------
* Desde el directorio apropiado (tdd-examples o unitconvert), ejecute sbt
* Una vez se hayan bajado todas las dependencias, ejecute las pruebas desde sbt con

        > test

Code examples: TDD
==================
Joaquín Caraballo

Requirements
------------
* sbt (tested with 0.12.0)
  If you haven't already installed it, you can download it from http://www.scala-sbt.org/download.html. Alternatively, on unix, you can directly run: 

        wget http://typesafe.artifactoryonline.com/typesafe/ivy-releases/org.scala-sbt/sbt-launch/0.12.0/sbt-launch.jar && \
        echo 'java -Xmx512M -jar `dirname $0`/sbt-launch.jar "$@"' >sbt && \
        chmod 755 sbt

Instructions
------------
* From the right directory (tdd-examples or unitconvert), start sbt
* Once all the depencies have been downloaded, from sbt, run the tests

        > test