# Logistic Company Service Проект Логистична Компания - Backend Service

https://logistics-engine.herokuapp.com/

## Кратко Описание
*LCS представлява spring boot backend service API, който се грижи за автентикация и авторизация на потребители с техните роли, функционалност, приемане на request-и и връщане на response-и в контекста на задачата Логистична Компания към курс-а CSCB025 НБУ.*

## Съставни Части на Service-a

1. Web конфигурация
2. Controllers
3. Entities
4. Service Functionality

## Postgres Инстанция База Данни
*Таблиците, полетата и връзките са дефинирани във Entity класовете*
*Информацията за Базата e дефинираna в application.properties*

## Свързване с базата Данни

1. Локално Чрез psql CLI
2. Локално Чрез клиентско софтуерно приложение за администриране на база данни (DBeaver)
3. Свързване с базата Данни в Heroku


### Локално Чрез psql CLI

1.След като имате инсталиран psql CLI, може да въведете следната команда:

psql -h <Име на Хост или IP адрес> -p <Порт> -d <Име на Базата> -U <Потребителско име>

2. Въведете паролата за базата
3. Връзката е осъществена успешно и можете да променяте, изтривате, въвеждате данни локално.

### Локално Чрез клиентско софтуерно приложение за администриране на база данни (DBeaver)

1. Инсталация на клиентското приложение
2. След като успешно инсталирате и отворите приложението ще видите бутон за добавяне на нова връзка
3. В Диалога, който ще излезне въвеждата правилно данните за вашата база  ->  Хост, Име на Базата, Потребител, Парола, Порт.
4. ![localdbeaVER](https://user-images.githubusercontent.com/47338843/117786010-0f77ce80-b280-11eb-86d2-8156daf954dd.png)
5. Връзката е осъществена успешно и можете да променяте, изтривате, въвеждате данни локално.

*Ако база с името, което е дефинирано в application.properties не съществува при вас локално, тогава трябва да създадете такава първо.*
*Дефинираните в application.properties поверителни данни трябва да бъдат същите, които ще използвате при създаването на базата за да се осъществи връзка с нея. Те също могат да бъдат променяни спрямо ваши предпочитания*

### Свързване с базата Данни в Heroku

1. Трябва ви клиентско софтуерно приложение и инструмент за администриране на база данни, с което да можете да осъществите връзката. Тук ще използваме **DBeaver**.
2. Ще ви бъдат необходими и Поверителните данни относно базата ->  Хост, Име на Базата, Потребител, Парола, Порт.
3. ![dataBaseCredentials](https://user-images.githubusercontent.com/47338843/117772875-9d4cbd00-b272-11eb-8ff7-ee97ac35d74f.png)
4. Въвеждане на Поверителните данни в приложението за администриране на база данни
5. ![Screenshot from 2021-05-11 16-07-35](https://user-images.githubusercontent.com/47338843/117773379-34197980-b273-11eb-8ee3-ac0a1fc38804.png)
6. Връзката е осъществена успешно и можете да променяте, изтривате, въвеждате данни в реално време.

## Deploy and Develop Процеси и практики

### Използвани технолигии за development

1. Git i Github
2. Postman - requests and responses to endpoints
![postman](https://user-images.githubusercontent.com/47338843/117790302-2ddfc900-b284-11eb-9a53-c159ac417b72.png)
*Пример*
4. InteliJ Comunity Edition
5. Spring Boot
6. Java 8
7. Dbeaver and PostgreSQL

Dependencies (Зависимости, Външни библиотеки) :

1. spring web
2. spring security
3. spring validation
4. jjwt -> json web tokens
5. jpa
6. postgresql

### Локален Development

1. Сваляне на проекта от github и постоянната му синхронизация (git pull) с master бранча, който е главен.
2. Стартиране на проекта, след като е конфигурирана средата (Конфигурация с базата данни)
3. Добавяне на нова функционалност, промени.
4. Добавяне на тестове или тяхно променяне, които да верифицират правилното държание на функционалността.
5. Правене на нов бранч от актуалния master и пушването му в github
6. Одобряването на промените от друг човек, преди да влезнат промените в master бранча

*При нов commit в master бранча, автоматично се редеплойва приложението в heroku*

## Линкове

1. https://logistics-engine.herokuapp.com/
2. https://spring.io/projects/spring-boot
3. https://start.spring.io/
4. https://dbeaver.io/
5. https://www.postman.com/
6. https://docs.spring.io/spring-boot/docs/current/reference/html/appendix-dependency-versions.html


