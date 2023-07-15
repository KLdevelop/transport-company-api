# transport-company-api

## Введение

Данный проект является тестовым заданием для вакансии Junior Java разработчик (стажер).

Проект состоит из двух репозиториев:

*   Backend (текущий репозиторий)
*   Frontend (https://github.com/KLdevelop/transport-company-web)

## Инструкция по запуску

### 1\. Склонировать текущий репозиторий

```shell
git clone https://github.com/KLdevelop/transport-company-web
```


### 2\. Создать и подключить базу данных к проекту

При тестировании проекта использовалась БД PostgreSQL.

Команды, с помощью которых создавались таблицы:

```sql
CREATE TABLE category (
    id bigint generated by default as identity primary key,
    category_name text
);
```

```sql
CREATE TABLE vehicle_type (
    id bigint generated by default as identity primary key,
    type_name text
);
```

```sql
CREATE TABLE vehicle (
    id bigint generated by default as identity primary key, 
    brand text, 
    model text, 
    category_id bigint REFERENCES category(id), 
    state_number text, 
    type_id bigint REFERENCES vehicle_type(id), 
    release_year integer, 
    has_trailer boolean
);
```


Таблицы vehicle\_type и category заполнялись следующим образом:

```sql
INSERT INTO vehicle_type(type_name) VALUES ('A'), ('B'), ('C'), ('D'), ('BE'), ('CE'), ('DE');
```

```sql
INSERT INTO category(category_name) VALUES ('Внедорожник'), 
                                           ('Кроссовер'), 
                                           ('Седан'), 
                                           ('Грузовик'), 
                                           ('Универсал / Хэтчбэк'),
                                           ('Кабриолет'),
                                           ('Купе'),
                                           ('Гибрид / Электрический'),
                                           ('Вэн / Минивэн'),
                                           ('Спорткар');
```


### 3\. Заполнить application.properties

Рядом с application.properties находится файл application.properties.origin, откуда можно скопировать шаблон для заполнения в соответсвии с подключенной БД.


## Запуск

После запуска по адресу http://localhost:8080/ будет доступна веб-страница

![](https://33333.cdn.cke-cs.com/kSW7V9NHUXugvhoQeFaf/images/c80c6596f1974ae422bed6f7fa2e4b3b964e79d9d70c98a0.png)

Фильтрация записей таблицы осуществляется с помощью нижней панели.

Для добавления новой записи следует нажать кнопку “Добавить” в верхней части таблицы.

Редактирование записей производится крайней правой кнопкой “Редактировать”.

Модальное окно добавления/редактирования:

![](https://33333.cdn.cke-cs.com/kSW7V9NHUXugvhoQeFaf/images/6103104db3868a95f5ad1fb7bf7e9bc8363b9e63fbd94a18.png)

Для закрытия модального окна достаточно кликнуть в любое место затемненной области. При нажатии кнопки “Изменить” модальное окно закроется самостоятельно.
