# Self-study TestAuto (Kseniia Viushkova)

Self-study. Spring 2019

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
datesPageSelenide.checkLastLogContains(LEFT_SLIDER, 30);
```