Overview
========

Specification: spec.txt
Design doc: <none>
Program entry point: com.quickstart.application.Main.main
Intergation test: <none>

Run program
===========

Build program with "mvn clean package" command in root project directory

From root project directory:
    cd target
    java -cp quickstart-<version id>.jar com.quickstart.application.Main ../src/test/resources/app.properties

Dev environment
===============

Build:

Maven 3 from Netbeans; didn't test "pure" Maven build

IDE Netbeans:

    Product Version: NetBeans IDE 8.0.2 (Build 201411181905)
    Updates: NetBeans IDE is updated to version NetBeans 8.0.2 Patch 2
    Java: 1.8.0_60; Java HotSpot(TM) 64-Bit Server VM 25.60-b23
    Runtime: Java(TM) SE Runtime Environment 1.8.0_60-b27
    System: Windows 7 version 6.1 running on amd64; Cp1251; en_US (nb)

IMPL NOTE source code compatibility Java 8 platform

Java 8:

    java version "1.8.0_60"
    Java(TM) SE Runtime Environment (build 1.8.0_60-b27)
    Java HotSpot(TM) 64-Bit Server VM (build 25.60-b23, mixed mode)

PC systeminfo:

    OS Name:                   Microsoft Windows 7 Ultimate
    OS Version:                6.1.7601 Service Pack 1 Build 7601
    OS Manufacturer:           Microsoft Corporation
    OS Configuration:          Standalone Workstation
    OS Build Type:             Multiprocessor Free
    System Type:               x64-based PC
    Processor(s):              1 Processor(s) Installed.
                               [01]: Intel64 Family 6 Model 42 Stepping 7 GenuineIntel ~3301 Mhz
    Total Physical Memory:     8,175 MB
    Available Physical Memory: 2,802 MB
    Virtual Memory: Max Size:  16,349 MB
    Virtual Memory: Available: 6,974 MB
    Virtual Memory: In Use:    9,375 MB