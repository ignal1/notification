## Notification
Сервис для формирования уведомлений о контролируемых сделках в электронной форме. 
С его помощью можно сформировать **файл обмена** в формате XML, соответствующий 
XSD-схеме, утвержденной Приказом ФНС, на основе данных о контролируемых сделках, 
внесенных в шаблон в формате XLSX.

В приложении реализован алгоритм, выполняющий:
- разархивирование загруженного XLSX-шаблона и извлечение из него XML-файлов с данными;
- парсинг полученных файлов с помощью реализованных DOM- и StAX-анализаторов;
- формирование структуры Java DTO-классов на основе схемы XSD;
- инициализацию Java-классов данными, полученными из XML-файлов;
- маршаллинг, в результате которого формируется XML-файл на основе Java-объектов.

### Использованные языки и технологии
- Spring Boot;
- Spring Security Framework;
- Bean Validation API;
- JAXB;
- FreeMarker;
- JavaScript;
- Bootstrap;
- PostgreSQL;
- Flyway.

### Основные возможности
- конвертация данных из формата XLSX в формат XML, соответствующий схеме XSD
 (то есть, формирование уведомления в электронной форме);
- поддержка всех старых форматов уведомлений;
- двухшаговая регистрация пользователей (для подтверждения регистрации на 
email отправляется письмо со ссылкой);
- восстановление пароля (для восстановления пароля на email отправляется письмо со ссылкой);
- загрузка и хранение на сервере файлов с данными о контролируемых сделках 
(доступно зарегистрированным пользователям);
- возможность изменять имена загруженных файлов, добавлять к ним комментарии;
- создание/редактирование профиля пользователя;
- удаление аккаунта пользователем;
- для администраторов реализован функционал управления пользователями и настройки 
системы (реализовано в форме графического интерфейса);
- включение/отключение администратором ограниченной функциональности для отдельных 
пользователей (реализовано в форме графического интерфейса. Устанавливается дата, 
при наступлении которой для данного пользователя автоматически устанавливаются ограничения);
- валидация данных, вводимых в формы, как на стороне сервера, так и на стороне клиента;
- выполнение задач по расписанию (удаление ненужных данных из системы).
Ежедневно в определенное время удаляются из БД:
   -	данные пользователей, которые в течение 24 часов не подтвердили
        регистрацию переходом по отправленной им ссылке;
        
   -	неиспользованные в течение 24 часов токены для восстановления паролей.
   
   Также для всех пользователей ежедневно проверяется истечение срока неограниченной 
   функциональности (если он установлен). При наступлении соответствующей даты 
   данный режим автоматически прекращается.