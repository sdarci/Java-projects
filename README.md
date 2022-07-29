# Java-projects

Junit_test - директория с проектом по тестам базы данных (HSQL), проект собирается с помощью Maven (test, clean etc.) Тестируется подключение к базе данных, тестируются функции поиска по ID, save (функция добавления VALUES )
все тесты проходят на success


Multithreads - директория с проектом о многопоточности (компилируется с помощью javac -Program.java / запуск Java Program --arraySize=13 --threadsCount=3 значения можно подать любые) Максимальное количество элементов массива - 2 000 000. Максимальное количество потоков не превышает текущего количества элементов массива. Максимальное значение по модулю каждого элемента массива равно 1000. Все данные гарантированно являются достоверными. 

Пример работы программы (каждый элемент массива равен 1):

$ java Program --arraySize=13 --threadsCount=3

Sum: 13

Thread 1: from 0 to 4 sum is 5

Thread 2: from 5 to 9 sum is 5

Thread 3: from 10 to 12 sum is 3

Sum by threads: 13

PostgreSQL - директория с проектом по работе с базой данных (PostgreSQL), maven проект, в этой директории есть директории с названием ex00 ex01 ex02 ex03

ex00 - просто создание таблицы с помощью Schema.sql и добавление в нее данных из Data.sql

ex01 - Реализация MessagesRepository с помощью ОДНОГО метода Optional<Message> findById(Long ID) и его реализации MessagesRepositoryJdbcImpl.
Этот метод должен возвращать объект сообщения, в котором будут указаны автор и комната чата. В свою очередь, НЕТ НЕОБХОДИМОСТИ вводить подразделы (список комнат чата, создатель комнаты чата и т.д.) Для автора и комнаты чата.

ex02 - Create/Save . Таким образом, метод сохранения должен присвоить значение идентификатора для входящей модели после сохранения данных в базе данных. Если у автора и комнаты нет идентификаторов, существующих в назначенной базе данных, или эти идентификаторы равны нулю, вызовите исключение Runtimeexception NotSavedSubEntityException ( это исключение реализованно самостоятельно). 

ex03 - Update . Реализован метод обновления в MessageRepository. Этот метод должен полностью обновить существующий объект в базе данных. Если новое значение поля в обновляемом объекте равно null, это значение должно быть сохранено в базе данных.
