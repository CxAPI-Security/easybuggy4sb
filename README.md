[![Build Status](https://travis-ci.org/k-tamura/easybuggy4sb.svg?branch=master)](https://travis-ci.org/k-tamura/easybuggy4sb)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![GitHub release](https://img.shields.io/github/release/k-tamura/easybuggy4sb.svg)](https://github.com/k-tamura/easybuggy4sb/releases/latest)

# EasyBuggy Boot :four_leaf_clover:

This is a clone of EasyBuggy built on Spring Boot. [EasyBuggy](https://github.com/k-tamura/easybuggy) is a broken web application in order to understand behavior of bugs and vulnerabilities, for example, [memory leak, deadlock, JVM crash, SQL injection and so on](https://github.com/k-tamura/easybuggy4sb/wiki).

![logo](https://raw.githubusercontent.com/wiki/k-tamura/easybuggy/images/mov_ebsb.gif)

:clock4: Quick Start
-

    $ mvn spring-boot:run

( or ``` java -jar ROOT.war ``` or deploy ROOT.war on your servlet container with [the JVM options](https://github.com/k-tamura/easybuggy4sb/blob/master/pom.xml#L148). )

Access to

    http://localhost:8080

#### To stop:

  Use <kbd>CTRL</kbd>+<kbd>C</kbd>

    
:clock4: For more detail
-
   
See [the wiki page](https://github.com/k-tamura/easybuggy4sb/wiki).

:clock4: Demo
-

This demo shows: Start up -> Infinite Loop -> LDAP Injection -> UnsatisfiedLinkError -> BufferOverflowException -> Deadlock -> Memory Leak -> JVM Crash (Shut down)

![demo](https://github.com/k-tamura/test/blob/master/demo_ebsb.gif)



## Second scan
We created branch: master-second-scan for comparison purposes
1. delete sensitive parameter - delete "password" from Request parameter. Impact API
    1. /eb/v1/sqlijc
2. Add Non-sensitive parameter - add "time" to request parameters. Impact APIs
    1. /eb/v1/start
3. Change sensitive parameter - rename "name" to "eman", request parameter. Impact APIs
    1. /eb/v1/sqlijc-reflection
4. Fix risk - fix "Command Injection" - CxController, source node - cmd, line: 37 (first node). Impact API
    1. legacy/runCommand/{cmd}
    2. probably it will solve 2 risks: command Injection & Stored XSS
5. Fix risk - fix "SQL Injection" - SQLInjectionController, source node - password, line: 31 (first node). Impact API
   1. /eb/v1/sqlijc
6. Add risk - SQL injection. source file: PingController; line: 16; source node: pong. Impact API:
    1. /eb/v1/ping
7. Change path - from /eb/v1/serverinfo to /eb/v1/serverinfoMe
8. Delete API - delete /v1/admins/cssinject
