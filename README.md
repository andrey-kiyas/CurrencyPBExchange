_**Реализовать Обмен валют в кассе банка**_

* Срок выполнения - в течении недели (само задание на 1-2 дня)
* Суть задания - Обмен валют в кассе банка
* Критерии качества: чистый, понятный и структурированный код.
* Отчет о задании - репозиторий или ссылка на архив для скачивания проекта

_**Оцениваются в т.ч. и не до конца выполненные задания!**_

Цель тестового задания - оценить уровень знаний кандидата по технологиям:
1. Java 8 (Collections Framework, Stream, Lambda, JDBC, Servlet API, JSP, JSTL)
2. HTML, JS, CSS
3. Web-сервисы (REST xml и json)
4. Spring и Spring MVC

```
[Spring Boot - НЕ использовать!]
```

Приложение должно состоять из следующих частей:
1. Любая БД SQL на платформе PostgreSQL, MySQL, h2 и т.п.
2. Web-сервис, принимающий запросы от клиентских программ по протоколу http
3. Web-интерфейс пользователя
4. Web-интерфейс администрирования

Внешнее оформление на усмотрение кандидата.

---

Список доступных валют: **USD** - доллар США, **EUR** - евро

[Сервис курсов валют НБУ](https://bank.gov.ua/ua/open-data/api-dev)

Наличный курс ПриватБанка (в отделениях):
* [GET XML](https://api.privatbank.ua/p24api/pubinfo?exchange&coursid=5)
* [GET JSON](https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=5)

Параметры ответа:  
***ccy*** Код валюты  
***base_ccy*** Код национальной валюты  
***buy*** Курс покупки  
***sale*** Курс продажи

---

_**Требования к компонентам:**_
1. В БД хранятся справочники и журнал операций покупки/продажи
2. Web-сервис должен обеспечивать все необходимые операции для работы интерфейсов администрирования и просмотра. RESTful в форматах json и xml: поиск, чтение,
   добавление, редактирование, удаление.  
   DAO - слой реализовать на “голом” JDBC, Spring JdbcTemplate и, по желанию, Spring
   Data. Т.е. один из интерфейсов реализовать на JDBC, другой JdbcTemplate (***обе
   имплементации для одного интерфейса не нужны!***).
3. Web-интерфейс пользователя:
   1. проведение(создание) операций обмена валют
   2. просмотр журнала операций
   3. Отчеты (расчет производить на уровне java-кода, а не sql):
      1. группировка журнала операций по датам и суммам купли/продажи в разрезе дня, месяца, квартала, года
      2. «+» доп группировка по валютам
   4. просмотр справочника курсов валют (наличный и НБУ)
4. Web-интерфейс администрирования  
   a. ведение справочников курсов валют (заполнение из сервисов и CRUD операции)  
   b. просмотр/редактирование заказов журнала операций. При удалении запись физически не удалять, а изменять статус операции
