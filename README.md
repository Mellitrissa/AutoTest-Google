# Проект по автоматизации тестовых сценариев для сайта  [Google.com](https://www.google.com/)
## Содержание:

- [Используемый стек](#computer-используемый-стек)
- [Запуск автотестов](#arrow_forward-запуск-автотестов)

## :rocket: Используемый стек

<p align="center">
<a href="https://www.jetbrains.com/idea/"/><img width="6%" title="IntelliJ IDEA" src="media/logo/Intelij_IDEA.svg"/>
<a href="https://www.java.com/"/><img width="6%" title="Java" src="media/logo/Java.svg"/>
<a href="https://selenide.org/"/><img width="6%" title="Selenide" src="media/logo/Selenide.svg"/>
<a href="https://github.com/allure-framework/allure2"/><img width="6%" title="Allure Report" src="media/logo/Allure_Report.svg"/>
<a href="https://gradle.org/"/><img width="6%" title="Gradle" src="media/logo/Gradle.svg"/>
<a href="https://junit.org/junit5/"/><img width="6%" title="JUnit5" src="media/logo/JUnit5.svg"/>
<a href="https://github.com/"/><img width="6%" title="GitHub" src="media/logo/GitHub.svg"/>



- Тесты в данном проекте написаны на языке <code>Java</code> с использованием фреймворка для тестирования [Selenide](https://selenide.org/)
- В качестве сборщика был использован - <code>Gradle</code>
- <code>JUnit 5</code> задействован в качестве фреймворка модульного тестирования


##  :computer: Запуск автотестов

###  Запуск тестов из терминала
```
gradle clean test
```
## Генерация Allure отчета
```
gradle allure:serve
```
