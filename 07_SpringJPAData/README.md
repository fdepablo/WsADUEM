# Spring JPA-Data

Spring Data es un proyecto de SpringSource cuyo propósito es unificar y facilitar el acceso a distintos tipos de tecnologías de persistencia, tanto a bases de datos relacionales como a las del tipo NoSQL.

El objetivo de Spring JPA-Data es simplificar la implementación de la capa de acceso a datos, unificando la configuración y creando una jerarquía de excepciones común para todas ellas.

Con cada tipo de tecnología de persistencia los DAOs (Data Access Objects) ofrecen las funcionalidades típicas de un CRUD (Create-Read-Update-Delete ) para objetos de dominio propios, métodos de busqueda, ordenación y paginación. Spring Data proporciona interfaces genéricas para estos aspectos, como <b>JpaRepository</b>

A día de hoy, Spring Data proporciona soporte para las siguientes tecnologías de persistencia:

1. JPA y JDBC
2. Apache Hadoop
3. MongoDB
4. GemFire
5. Redis
6. Neo4j
7. HBase

## Creacion del proyecto con Spring Boot

Para crear este proyecto debemos de crear un proyecto spring boot normal y añadir dos starter, uno seria el de Spring JPA data y el otro sería la base de datos que vayammos a usar (en este caso hemos elegido H2).

Si elegimos una base de datos ligera, como puede ser H2 o Derby, si no le decimos a spring donde se tiene que contectar, nos levantara automaticamente una base de datos en memoria al arrancar la aplicacion. 

En el caso de Spring Boot no tenemos que configurar nada del data source, nos cojera una configuracion por defecto basandose en los starters. En este ejemplo de aqui no hace falta crear una clase de configuracion.

## Fichero de configuracion de Spring boot

El unico fichero de configuracion de Spring Boot se llama por defecto <b>application.properties</b> que se encutra situado en el paquete "src/main/resources". Cualquier configuracion que queramos darle se pondra en dicho fichero. Por ejemplo 

1. podemos configurar el puerto del tomcat (en caso de un proyecto web)
2. Podemos configurar la URL de nuestra BBDD, con su usuario y su password
3. Podemos configurar nuestro ViewResolver del un proyecto web

Podemos cambiar el starter de H2 a MySql para configurar en este fichero nuestro data source

1- Boton derecho sobre el proyecto | Spring | add Stater

## Poner en marcha la aplicacion

Para arrancar una aplicacion Spring Boot debemos ejecutar el método main de la misma. 

## Establecer banner

Podeis poner un banner personalizado creando un fichero <b>banner.txt</b> en el paquete "src/main/resources"

## Regla para negocio

Si teneis capa de negocio en la aplicacion, los métodos de negocio
que cambien la base de datos, deben de estar anotados con 




