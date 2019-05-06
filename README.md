# Self-study TestAuto (Kseniia Viushkova)

Self-study. Spring 2019

## HW1

Basic tests. No testng.xml file.

## HW2

Commands to run tests from hw2:

```
clean test -DsuiteXmlFile=testng-hw2-ex2-smoke.xml
clean test -DsuiteXmlFile=testng-hw2-ex2-regression.xml
clean test -DsuiteXmlFile=testng-hw2-ex3.xml
```

## HW4

DatesPageSlidersSelenideTest fails. It is expected behavior so far.
In order for the test to pass, comment the following line in file DatesPageSlidersSelenideTest.java:

```
datesPageSelenide.checkLog(30, 70);
```

## HW5

Screenshots of Jenkins job and Allure report can be found at \src\test\resources\hw5
Command to run tests from hw5:

```
clean test -DsuiteXmlFile=testng-hw5.xml
```

## HW6

Command to run tests from hw6:

```
clean test -DsuiteXmlFile=testng-hw6.xml
```