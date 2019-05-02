# Recruit

Redesigned SEU Recruit system.

## Introduction

This system is a redesigned recruit system for SEU undergraduate student enrollment. Even though we have already developed a system (which is running currently), there are some problems in the existing system that need to be improved. Thus, I redesign this system, which is a demo to serve as a blueprint for later reference.

So, what are the problems of the existing system? In other words, what other aspects of the existing system can be improved?

In my humble opinion, the database structure should be redesigned with careful consideration. Due to the lack of time, the previous structure of collections and tables was rushed online without careful design. In the following operation and maintenance process, with the increasing demand of first-party, we had to modify or add new tables to the database repeatedly, which made it increasingly bloated and ugly. Thus, an ideal database design should take full advantage of the previous lessons and pay attention to scalability and robustness.

Secondly, a big problem of the former system is that it has no possibility of horizontal and vertical expansion. The unified implementation of all services and interfaces makes the business logic highly coupled. In addition, the chaos of application structure also brings great difficulty to the maintenance of later comers. Therefore, in the redesigned system, I will try to decompose the application into microservices using **Spring Cloud** architecture.

## Security Issues

This redesigned system contains no sensible data or information of existing recruit system and its business details. Thus it can be open-sourced safely.

## Copyright

Any use or modification of the code contained in the library is discouraged, and no secondary creation based on the library is allowed.

Copyright © [Rui Song](https://github.com/wurahara).

               
