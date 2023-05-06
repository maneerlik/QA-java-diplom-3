<!-- PROJECT LOGO -->
<a name="readme-top"></a>
<div align="center">

![REST Assured](stellarburgers.png)

</div>
<div align="center">
    <h3 align="center">Part III: тестирование UI</h3>
    <p align="center">
        Третья часть дипломного проекта курса "qa-automation-engineer-java".
        <br/>
        <br/>
    </p>
</div>

<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li><a href="#about-the-project">About The Project</a></li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#classes">Classes</a></li>
    <li><a href="#tests">Tests</a></li>
    <li><a href="#tech-stack">Tech Stack</a></li>
  </ol>
</details>

### About The Project

Необходимо протестировать UI <a href="https://stellarburgers.nomoreparties.site/">Stellar Burgers</a>.
Тесты запустить в «Google Chrome" и «Яндекс.Браузере». Подключить Allure-отчёт.

<b>Регистрация:</b>
* Успешную регистрацию;
* Ошибку для некорректного пароля. Минимальный пароль — шесть символов.

<b>Вход:</b>
* по кнопке «Войти в аккаунт» на главной;
* через кнопку «Личный кабинет»;
* через кнопку в форме регистрации;
* через кнопку в форме восстановления пароля.

<b>Переход в личный кабинет:</b>
* переход по клику на «Личный кабинет».

<b>Переход из личного кабинета в конструктор:</b>
* переход по клику на «Конструктор» и на логотип Stellar Burgers.

<b>Раздел «Конструктор»</b>
<p>Проверить, что работают переходы к разделам:</p>

* «Булки»;
* «Соусы»;
* «Начинки».

<b>Выход из аккаунта:</b>
* выход по кнопке «Выйти» в личном кабинете.

### Usage

Для выбора браузера, в котором необходимо запустить тесты, в файле .env указать наименование браузера в формате var=value (н.п. `BROWSER=chrome` или `BROWSER=yandex`).
Для запуска тестов выполнить команду `mvn clean test`.
Для запуска отчета Allure выполнить команду `mvn allure:serve` 

### Classes
* `Constants` - константы, описывающие POM
* `WebDriverConfig` - конфигурация WebDriver-а
* `WebDriverFactory` - инстанцирование WebDriver-а
* `BasePage` - реализация базового поведения POM
* `BaseWeb` - базовый тестовый класс

### Tests
* `ConstructorTest` - проверка переходов конструктора
* `FailUserRegistrationTest` - регистрация пользователя с некорректными данными
* `LoginUserTest` - авторизация пользователя
* `PersonalKabinetTest` - тестирование персонального кабинета
* `SuccessUserRegistrationTest` - успешная регистрация пользователя

### Tech Stack

[![Java11][java]][javadoc-url]
[![Selenium][selenium]][selenium-url]
[![Allure][Allure]][Allure-url]
[![JUnit4][junit]][junit-url]
[![REST Assured][REST_Assured]][rest-assured-url]

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[javadoc-url]: https://docs.oracle.com/en/java/javase/11/docs/api/index.html
[java]: https://img.shields.io/badge/Java_11-FF2D20?style=for-the-badge&logo=oracle&logoColor=white
[selenium-url]: https://www.selenium.dev/documentation/
[selenium]: https://img.shields.io/badge/Selenium-43B02A?style=for-the-badge&logo=selenium&logoColor=white
[junit-url]: https://junit.org/junit4/
[junit]: https://img.shields.io/badge/JUnit_4-20232A?style=for-the-badge
[rest-assured-url]: https://rest-assured.io/
[REST_Assured]: https://img.shields.io/badge/rest_assured-00bb76?style=for-the-badge
[Allure-url]: https://docs.qameta.io/allure/
[Allure]: https://img.shields.io/badge/Allure-a5d37e?style=for-the-badge